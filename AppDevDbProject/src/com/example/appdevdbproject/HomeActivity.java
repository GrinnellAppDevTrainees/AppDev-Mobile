package com.example.appdevdbproject;


import services.ServicesActivity;
import about.AboutActivity;
import activityFeed.ActivityFeedActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import directory.DirectoryActivity;

public class HomeActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		/* Get button Id's */
		Button directoryButton = (Button) findViewById(R.id.Directory);
		Button aboutButton = (Button) findViewById(R.id.About);
		Button servicesButton = (Button) findViewById(R.id.Services);
		Button activityFeedButton = (Button) findViewById(R.id.ActivityFeed);
		
		/* on click of directoryButton move to the directoryActivity*/
		directoryButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this,
						DirectoryActivity.class);
				startActivity(intent);
			}
		});
		
		
		/* on click of aboutButton move to the aboutActivity*/
		aboutButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this,
						AboutActivity.class);
				
				startActivity(intent);
			}
		});
		
		/* on click of servicesButton move to the servicesActivity*/
		servicesButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this,
						ServicesActivity.class);
				startActivity(intent);
			}
		});
		
		/* on click of servicesButton move to the servicesActivity*/
		activityFeedButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this,
						ActivityFeedActivity.class);
				startActivity(intent);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}