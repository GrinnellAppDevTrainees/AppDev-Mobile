package com.appdev.appdevdirectory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.variablevision.appdevdirectory.R;

public class AppReqFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_app_req, container, false);
		
		
		 final EditText name = (EditText) rootView.findViewById(R.id.ar_name);	
		 final EditText budget = (EditText) rootView.findViewById(R.id.budget);
		 final EditText ar_email = (EditText) rootView.findViewById(R.id.ar_email);
		 final EditText comment = (EditText) rootView.findViewById(R.id.comment);

		 Button submit = (Button) rootView.findViewById(R.id.submitAppRequest);
		 

		 submit.setOnClickListener(new View.OnClickListener()  {
			 
			 @Override
			 public void onClick(View v){
				 
				 Intent email = new Intent(Intent.ACTION_SEND);

				 email.setType("plain/text");
				 email.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"owusumic17@grinnell.edu"});
				 email.putExtra(android.content.Intent.EXTRA_SUBJECT, "Application Request");
				 email.putExtra(android.content.Intent.EXTRA_TEXT, 
						 "Name: "+name.getText().toString()+'\n'+"Email: "+ar_email.getText().toString()+'\n'
						 +"Role: "+budget.getText().toString()+'\n'+"Graduation Year: "+'\n'+'\n'
						 +"Description/Comments:\n\n"+comment.getText().toString()+'\n'+'\n'+"Sent from AppDev Mobile.");

				 /* Send it off to the Activity-Chooser */
				 startActivity(Intent.createChooser(email, "Send mail..."));
			 }
		 });
		 
			return rootView;
			}

}

