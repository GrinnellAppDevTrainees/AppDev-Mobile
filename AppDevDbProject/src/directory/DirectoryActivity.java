package directory;
import activityFeed.TabsAdapter;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.appdevdbproject.GeneralUtils;
import com.example.appdevdbproject.R;



/**
 * Implements DirectoryActivity
 * @author Michael Owusu
 * @author Albert Owusu-Asare 
 * @version 0.1 of October 2014
 *
 */
public class DirectoryActivity extends FragmentActivity  {
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	 setContentView(R.layout.activity_directory);
	
	 //References to ActionBar TabsAdapter and ViewPager objects
	 final ActionBar actionBar;
	 TabsAdapter tabAdapter;
	 final ViewPager viewPager;
	
		tabAdapter = new TabsAdapter(getSupportFragmentManager());
		 actionBar = getActionBar();
		 viewPager = (ViewPager) findViewById(R.id.directory_pager);
		
		//set the viewPager 
		viewPager.setAdapter(tabAdapter);
		
		/* Listens for page change on viewPage */
		ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageSelected(int pagePosition) {
				actionBar.setSelectedNavigationItem(pagePosition);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
				
			}
		};
		
		viewPager.setOnPageChangeListener(pageChangeListener);
		
		
		 
		 //specify tabs are displayed in the action bar
		 actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		 
		 /* tab listener to listen for changes in tabs */
		 
		 ActionBar.TabListener tabListener = new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				viewPager.setCurrentItem(tab.getPosition());
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
			}
		};//tabListiner
		
	
		GeneralUtils.addNameToTabs(Utilities.tabs, actionBar, tabListener);

	}//onCreate()

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.directory, menu);
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
