package activityFeed;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.appdevdbproject.R;



public class Articles extends ListFragment {
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	        return inflater.inflate(R.layout.activity_feed_article_main, container, false);
	    }
	 
	  public void onActivityCreated(Bundle savedInstanceState) {
	        super.onActivityCreated(savedInstanceState);
	      
	        /* adapter that will populate the view with relevant listed data */
	        
	        ListAdapter adapter = new ArrayAdapter<String>(getActivity(),
	                android.R.layout.simple_list_item_activated_1,
	                Utilities.articles);

	        /* set the adapter */
	       setListAdapter(adapter);         
	  }//onActivityCreated
	  
	  @Override
	  public void onListItemClick(ListView lv, View view, int position, long id){
	 	super.onListItemClick(lv, view, position, id);
	 	showDetails(position);
	  }// onListItemClick



 
 void showDetails(int index) {
		int mCurCheckPosition = index;

		// The basic design is mutli-pane (landscape on the phone) allows us
		// to display both fragments (titles and details) with in the same
		// activity; that is FragmentLayout -- one activity with two
		// fragments.
		// Else, it's single-pane (portrait on the phone) and we fire
		// another activity to render the details fragment - two activities
		// each with its own fragment .
		//
			// We can display everything in-place with fragments, so update
			// the list to highlight the selected item and show the data.
			// We keep highlighted the current selection
			getListView().setItemChecked(index, true);

			// Check what fragment is currently shown, replace if needed.
			ArticleFragment details = (ArticleFragment) getFragmentManager()
					.findFragmentById(R.id.activity_feed_frame);
			
			if (details == null || details.getShownIndex() != index) {
				// Make new fragment to show this selection.

				details = ArticleFragment.newInstance(index);


				// Execute a transaction, replacing any existing fragment
				// with this one inside the frame.
				android.support.v4.app.FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.activity_feed_frame, details);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.commit();
			}

 }
}//Articles
