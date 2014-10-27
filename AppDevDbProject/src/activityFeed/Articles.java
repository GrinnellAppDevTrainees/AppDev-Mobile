package activityFeed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;



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
	
 @Override
 public void onListItemClick(ListView lv, View view, int position, long id){
	super.onListItemClick(lv, view, position, id);
	 Intent myIntent = new Intent(view.getContext(), ArticleDetailActivity.class);
	 myIntent.putExtra("listItemPosition", position);
	 startActivity(myIntent);
 }// onListItemClick
 
}//Articles
