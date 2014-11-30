package com.appdev.appdevdirectory;

import com.variablevision.appdevdirectory.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button directory = (Button) findViewById(R.id.Directory);
		Button services = (Button) findViewById(R.id.Services);
		
		directory.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						DirectoryActivity.class);
				startActivity(intent);
			}
		});
		
		services.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						Services.class);
				startActivity(intent);
			}
		});
		
		
		
	}
}
