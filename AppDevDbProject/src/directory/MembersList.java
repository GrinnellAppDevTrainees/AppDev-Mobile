package directory;


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
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdevdbproject.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MembersList extends ListActivity {

	public static final int NUMBER_OF_POSTS = 20;
	public static final String TAG = MembersList.class.getSimpleName();
	protected JSONObject mMemberData;
	protected ProgressBar mProgressBar;

	private final String KEY_NAME = "name";
	private final String KEY_ROLE = "role";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_members);
		
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
        .build();
    ImageLoader.getInstance().init(config);

		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);

		if (isNetworkAvailable()) {
			mProgressBar.setVisibility(View.VISIBLE);
			GetMembersTask getMembersTask = new GetMembersTask();
			getMembersTask.execute();
		} else {
			Toast.makeText(this, "Network is unavailable!", Toast.LENGTH_LONG)
					.show();
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		JSONArray jsonMembers;
		
		try {
			jsonMembers = mMemberData.getJSONArray("members");
			JSONObject jsonMember = jsonMembers.getJSONObject(position);

			
			String year, name, email, cellphone, picurl;
			
			year = jsonMember.getString("year");
			name = jsonMember.getString("name");
			email = jsonMember.getString("email");
			cellphone = jsonMember.getString("cellphone");
			picurl = jsonMember.getString("image");
			
			
			
			Intent intent = new Intent(MembersList.this, IndividualMemberActivity.class);
			intent.putExtra("year", year);
			intent.putExtra("name", name);
			intent.putExtra("email", email);
			intent.putExtra("cellphone", cellphone);
			intent.putExtra("image", picurl);
			
			
			startActivity(intent);

		} catch (JSONException e) {
			Log.e(TAG, "Exception caught: ", e);
		}

	}

	private boolean isNetworkAvailable() {
		ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
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
					String name = member.getString(KEY_NAME);
					name = Html.fromHtml(name).toString();
					String role = member.getString(KEY_ROLE);
					role = Html.fromHtml(role).toString();

					HashMap<String, String> directory = new HashMap<String, String>();
					directory.put(KEY_NAME, name);
					directory.put(KEY_ROLE, role);

					members.add(directory);
				}
				String[] keys = { KEY_NAME, KEY_ROLE };
				int[] ids = { android.R.id.text1, android.R.id.text2 };
				SimpleAdapter adapter = new SimpleAdapter(this, members,
						android.R.layout.simple_list_item_2, keys, ids);

				setListAdapter(adapter);

			} catch (JSONException e) {
				Log.e(TAG, "Exception caught!", e);
			}

		}
	}

	private void updateDisplayForError() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
						"http://grinnellappdev.com/tutorials/appdev_directory.json");
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


