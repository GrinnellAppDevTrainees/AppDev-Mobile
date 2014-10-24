package com.example.appdevdbproject;

import android.app.ActionBar;
import android.app.ActionBar.Tab;

public class GeneralUtils {

	
	public static void addNameToTabs(String[] tabNames , ActionBar actionBar, ActionBar.TabListener listener){
		
		for(String tabName : tabNames){
			Tab tab = actionBar.newTab().setText(tabName).setTabListener(listener);
			actionBar.addTab(tab);
		}//for
	}//addNameTotabs(String [] , ActionBar, ActionBar.TabListener)
	
	
}
