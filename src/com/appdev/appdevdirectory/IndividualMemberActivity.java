package com.appdev.appdevdirectory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.variablevision.appdevdirectory.R;

public class IndividualMemberActivity extends Activity {

	String year, name, email, cellphone, picurl, giturl, linkedurl, twitterurl, homepageurl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_individual_member);

		ImageLoader loader = ImageLoader.getInstance();

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();

		picurl = bundle.getString("image");

		TextView emailTextView = (TextView) findViewById(R.id.email);
		TextView yearTextView = (TextView) findViewById(R.id.year);
		TextView cellTextView = (TextView) findViewById(R.id.cellphone);
		TextView nameTextView = (TextView) findViewById(R.id.name);

		ImageView imgview = ((ImageView) findViewById(R.id.imageView1));

		loader.displayImage(picurl, imgview);

		year = bundle.getString("year");
		name = bundle.getString("name");
		email = bundle.getString("email");
		cellphone = bundle.getString("cellphone");
		giturl = bundle.getString("giturl");
		linkedurl = bundle.getString("linkedurl");
		twitterurl = bundle.getString("twitterurl");
		homepageurl = bundle.getString("homepageurl");

//		Log.d("HomepageURL : ", homepageurl);
//		Log.d("TwitterURL: ", twitterurl);
//		Log.d("GitURL : ", giturl);
//		Log.d("LinkedInURL : ", linkedurl);
	

		emailTextView.setText(email);
		yearTextView.setText(year);
		cellTextView.setText(cellphone);
		nameTextView.setText(name);

		ImageButton git = (ImageButton) findViewById(R.id.gitHubButton);
		ImageButton twitter = (ImageButton) findViewById(R.id.twitterButton);	
		ImageButton home = (ImageButton) findViewById(R.id.homeButton);
		ImageButton linkedin = (ImageButton) findViewById(R.id.linkedButton);
		
		git.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(IndividualMemberActivity.this,
						GitWebViewActivity.class);
				intent.putExtra("giturl", giturl);
				startActivity(intent);
			}
		});
		
		twitter.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(IndividualMemberActivity.this,
						TwitterWebViewActivity.class);
				intent.putExtra("twitterurl", twitterurl);
				startActivity(intent);
			}
		});
		
		home.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(IndividualMemberActivity.this,
						HomePageWebActivity.class);
				intent.putExtra("homepageurl", homepageurl);
				startActivity(intent);
			}
		});
		
		linkedin.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(IndividualMemberActivity.this,
						LinkedInWebActivity.class);
				intent.putExtra("linkedurl", linkedurl);
				startActivity(intent);
			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.individual_member, menu);
		return true;
	}

}
