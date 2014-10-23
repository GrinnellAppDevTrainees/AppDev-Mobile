package com.example.fragmentswithtabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class ArticlesDetails extends Fragment {

	// Create a new instance of DetailsFragment, initialized to show the
	// text at 'index'.

	public static ArticlesDetails newInstance(int index) {
		ArticlesDetails f = new ArticlesDetails();

		// Supply index input as an argument.
		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);

		return f;	
	}

	        /**snippet**/

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

                    /**snippet**/

                        // programmatically create a scrollview and textview for the text in
                        // the container/fragment layout. Set up the properties and add the view

                        ScrollView scroller = new ScrollView(getActivity());
                        TextView text = new TextView(getActivity());
                        int padding = (int) TypedValue.applyDimension(
                                            TypedValue.COMPLEX_UNIT_DIP, 4, getActivity()
                                                          .getResources().getDisplayMetrics());
                        text.setPadding(padding, padding, padding, padding);
                        scroller.addView(text);
                        text.setText(Utilities.DIALOGUE[getShownIndex()]);
                        return scroller;
                }
    }
