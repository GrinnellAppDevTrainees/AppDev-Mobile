package activityFeed;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;


public class ArticleFragment extends Fragment {

	// Create a new instance of DetailsFragment, initialized to show the
		// text at 'index'.

		public static ArticleFragment newInstance(int index) {
			ArticleFragment f = new ArticleFragment();

			// Supply index input as an argument.
			Bundle args = new Bundle();
			args.putInt("index", index);
			f.setArguments(args);

			return f;	
		}

		public int getShownIndex() {
			return getArguments().getInt("index", 0);
		}

		// The system calls this when it's time for the fragment to draw its
		// user interface for the first time. To draw a UI for your fragment,
		// you must return a View from this method that is the root of your
		// fragment's layout. You can return null if the fragment does not
		// provide a UI.

		// We create the UI with a scrollview and text and return a reference to
		// the scoller which is then drawn to the screen

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			
			//
			// if (container == null) {
			// // We have different layouts, and in one of them this
			// // fragment's containing frame doesn't exist. The fragment
			// // may still be created from its saved state, but there is
			// // no reason to try to create its view hierarchy because it
			// // won't be displayed. Note this is not needed -- we could
			// // just run the code below, where we would create and return
			// // the view hierarchy; it would just never be used.
			// return null;
			// }

			// If non-null, this is the parent view that the fragment's UI
			// should be attached to. The fragment should not add the view
			// itself, but this can be used to generate the LayoutParams of
			// the view.
			//

			// programmatically create a scrollview and texview for the text in
			// the container/fragment layout. Set up the properties and add the
			// view.

			ScrollView scroller = new ScrollView(getActivity());
			TextView text = new TextView(getActivity());
			int padding = (int) TypedValue.applyDimension(
					TypedValue.COMPLEX_UNIT_DIP, 4, getActivity()
							.getResources().getDisplayMetrics());
			text.setPadding(padding, padding, padding, padding);
			scroller.addView(text);
			text.setText(Utilities.ARTICLE_DETAILS[getShownIndex()]);
			return scroller;
		}
	
}
