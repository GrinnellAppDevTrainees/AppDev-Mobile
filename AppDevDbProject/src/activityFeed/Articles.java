package activityFeed;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;



public class Articles extends ListFragment {
	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      
        /* adapter that will populate the view with relevant listed data */
        
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                Utilities.articles);

        /* set the adapter */
       setListAdapter(adapter);         
  }//onActivityCreated
}//Articles
