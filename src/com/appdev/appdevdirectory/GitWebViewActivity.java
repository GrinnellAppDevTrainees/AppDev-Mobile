package com.appdev.appdevdirectory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.variablevision.appdevdirectory.R;

public class GitWebViewActivity extends Activity {

	protected String mUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_git_web_view);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		mUrl = bundle.getString("giturl");
		
		WebView webView = (WebView) findViewById(R.id.webView1);
		webView.loadUrl(mUrl);
	}


}
