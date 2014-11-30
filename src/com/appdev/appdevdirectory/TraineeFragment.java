package com.appdev.appdevdirectory;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.variablevision.appdevdirectory.R;

public class TraineeFragment extends ListFragment {
	
	public static final int NUMBER_OF_POSTS = 20;
	public static final String TAG = MembersList.class.getSimpleName();
	protected JSONObject mMemberData;
	protected ProgressBar mProgressBar;

	private final String KEY_NAME = "name";
	private final String KEY_ROLE = "role";
	private final String KEY_CATEGORY = "category";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_trainee, container, false);
		
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity().getApplicationContext())
        .build();
    ImageLoader.getInstance().init(config);

		mProgressBar = (ProgressBar) rootView.findViewById(R.id.traineeProgressBar);

		if (isNetworkAvailable()) {
			mProgressBar.setVisibility(View.VISIBLE);
			GetMembersTask getMembersTask = new GetMembersTask();
			getMembersTask.execute();
		} else {
			Toast.makeText(getActivity().getApplicationContext(), "Network is unavailable!", Toast.LENGTH_LONG)
					.show();
		
		}
		return rootView;
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager manager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getActiveNetworkInfo();

		boolean isAvailable = false;
		if (networkInfo != null && networkInfo.isConnected()) {
			isAvailable = true;
		}
		return isAvailable;
	}

	public void handleResponse() {
		mProgressBar.setVisibility(View.INVISIBLE);

		if (mMemberData == null) {
			updateDisplayForError();

		} else {
			try {
				JSONArray jsonMembers = mMemberData.getJSONArray("members");
				ArrayList<HashMap<String, String>> members = new ArrayList<HashMap<String, String>>();
				for (int i = 0; i < jsonMembers.length(); i++) {
					JSONObject member = jsonMembers.getJSONObject(i);
					
					String category = member.getString(KEY_CATEGORY);
					category = Html.fromHtml(category).toString();

					

					String name = member.getString(KEY_NAME);
					name = Html.fromHtml(name).toString();
					String role = member.getString(KEY_ROLE);
					role = Html.fromHtml(role).toString();
					

					HashMap<String, String> directory = new HashMap<String, String>();
					

						directory.put(KEY_NAME, name);
						directory.put(KEY_ROLE, role);	
						members.add(directory);


				String[] keys = { KEY_NAME, KEY_ROLE };
				int[] ids = { android.R.id.text1, android.R.id.text2 };
				SimpleAdapter adapter = new SimpleAdapter(getActivity().getApplicationContext(), members,
						android.R.layout.simple_list_item_2, keys, ids);

				setListAdapter(adapter);
				}

			} catch (JSONException e) {
				Log.e(TAG, "Exception caught!", e);
			}

		}
	}

	private void updateDisplayForError() {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity().getApplicationContext());
		builder.setTitle(getString(R.string.error_title));
		builder.setMessage(getString(R.string.error_message));
		builder.setPositiveButton(android.R.string.ok, null);
		AlertDialog dialog = builder.create();
		dialog.show();

		TextView emptyTextView = (TextView) getListView().getEmptyView();
		emptyTextView.setText(getString(R.string.no_items));
	}

	private class GetMembersTask extends AsyncTask<Object, Void, JSONObject> {

		@Override
		protected JSONObject doInBackground(Object... arg0) {
			int responseCode = -1;
			JSONObject jsonResponse = null;

			try {
				URL directoryUrl = new URL(
						"http://www.cs.grinnell.edu/~owusumic17/trainees.json");
				HttpURLConnection connection = (HttpURLConnection) directoryUrl
						.openConnection();
				connection.connect();

				responseCode = connection.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
					InputStream inputStream = connection.getInputStream();
					Reader reader = new InputStreamReader(inputStream);
					int contentLength = connection.getContentLength();
					char[] charArray = new char[contentLength];
					reader.read(charArray);
					String responseData = new String(charArray);
					Log.v(TAG, responseData);

					jsonResponse = new JSONObject(responseData);

				} else {

					Log.i(TAG, "Unsuccessful HTTP Response Code: "
							+ responseCode);
				}

			} catch (MalformedURLException e) {
				Log.e(TAG, "Exception caught: ", e);
			} catch (IOException e) {
				Log.e(TAG, "Exception caught: ", e);
			} catch (Exception e) {
				Log.e(TAG, "Exception caught: ", e);
			}

			return jsonResponse;
		}

		@Override
		protected void onPostExecute(JSONObject result) {
			mMemberData = result;
			handleResponse();

		}

	}

}