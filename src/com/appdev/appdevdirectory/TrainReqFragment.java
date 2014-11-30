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

public class TrainReqFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_train_req, container, false);
		
		
		 final EditText name = (EditText) rootView.findViewById(R.id.tr_name);	
		 final EditText tr_email = (EditText) rootView.findViewById(R.id.tr_email);
		 final EditText role = (EditText) rootView.findViewById(R.id.role);
		 final EditText gradYear = (EditText) rootView.findViewById(R.id.gradYear);
		 final EditText comment = (EditText) rootView.findViewById(R.id.addComments);

		 Button submit = (Button) rootView.findViewById(R.id.submitTrainRequest);
		 

		 submit.setOnClickListener(new View.OnClickListener()  {
			 
			 @Override
			 public void onClick(View v){
				 
				 Intent email = new Intent(Intent.ACTION_SEND);

				 /* Fill it with Data */
				 email.setType("plain/text");
				 email.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"owusumic17@grinnell.edu"});
				 email.putExtra(android.content.Intent.EXTRA_SUBJECT, "Mobile Application Training Request");
				 email.putExtra(android.content.Intent.EXTRA_TEXT, 
						 "Name: "+name.getText().toString()+'\n'+"Email: "+tr_email.getText().toString()+'\n'
						 +"Role: "+role.getText().toString()+'\n'+"Graduation Year: "+gradYear.getText().toString()+'\n'+'\n'
						 +"Additional comments:\n\n"+comment.getText().toString()+'\n'+'\n'+"Sent from AppDev Mobile.");

				 /* Send it off to the Activity-Chooser */
				 startActivity(Intent.createChooser(email, "Send mail..."));
			 }
		 });
		 
			return rootView;
			}

}
