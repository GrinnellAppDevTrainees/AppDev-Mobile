package com.example.fragmentswithtabs;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Articles extends ListFragment {
	  boolean mDualPane = true;
      int mCurCheckPosition = 0;
	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // You can use getActivity(), which returns the activity associated
        // with a fragment.
        // The activity is a context (since Activity extends Context) .


        // Populate list with our static array of titles in list in the
        // Utilities class
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                Utilities.articles));

        // Check to see if we have a frame in which to embed the details
        // fragment directly in the containing UI.
        // R.id.details relates to the res/layout-land/fragment_layout.xml
        // This is first created when the phone is switched to landscape
        // mode

       // View detailsFrame = findViewById(R.id.pager);

       // Toast.makeText(getActivity(), "detailsFrame " + detailsFrame,
         //       Toast.LENGTH_LONG).show();

        // Check that a view exists and is visible
        // A view is visible (0) on the screen; the default value.
        // It can also be invisible and hidden, as if the view had not been
        // added.
        //
      //  mDualPane = detailsFrame != null
           //     && detailsFrame.getVisibility() == View.VISIBLE;

        Toast.makeText(getActivity(), "mDualPane " + mDualPane,
                Toast.LENGTH_LONG).show();

        if (savedInstanceState != null) {
            // Restore last state for checked position.
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

       if (mDualPane) {
            // In dual-pane mode, the list view highlights the selected
            // item.
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            // Make sure our UI is in the correct state.
           // showDetails(mCurCheckPosition);
            
       }
       /*  else { 
       
            // We also highlight in uni-pane just for fun
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(mCurCheckPosition, true);
        //}
          */
	}

	/*@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_article, container, false);
		
		return rootView;
	} // onCreateView
	
	*/
    void showDetails(int index) {
        mCurCheckPosition = index;

        // The basic design is mutli-pane (landscape on the phone) allows us
        // to display both fragments (titles and details) with in the same
        // activity; that is FragmentLayout -- one activity with two
        // fragments.
        // Else, it's single-pane (portrait on the phone) and we fire
        // another activity to render the details fragment - two activities
        // each with its own fragment .
        //
        if (mDualPane) {
            // We can display everything in-place with fragments, so update
            // the list to highlight the selected item and show the data.
            // We keep highlighted the current selection
            getListView().setItemChecked(index, true);

            // Check what fragment is currently shown, replace if needed.
            ArticlesDetails details = (ArticlesDetails) getFragmentManager()
                    .findFragmentById(R.id.details);
            if (details == null || details.getShownIndex() != index) {
                // Make new fragment to show this selection.

                details = ArticlesDetails.newInstance(index);

                Toast.makeText(getActivity(),
                        "showDetails dual-pane: create and replace fragment",
                        Toast.LENGTH_LONG).show();

                // Execute a transaction, replacing any existing fragment
                // with this one inside the frame.
                FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.details, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else {
            // Otherwise we need to launch a new activity to display
            // the dialog fragment with selected text.
            // That is: if this is a single-pane (e.g., portrait mode on a
            // phone) then fire DetailsActivity to display the details
            // fragment

            // Create an intent for starting the DetailsActivity
          //  Intent intent = new Intent();

            // explicitly set the activity context and class
            // associated with the intent (context, class)
          //  intent.setClass(getActivity(), DetailsActivity.class);

            // pass the current position
          //  intent.putExtra("index", index);

          //  startActivity(intent);
        }
    }
}//Articles
