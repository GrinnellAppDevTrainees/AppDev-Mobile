package activityFeed;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.appdevdbproject.R;

public class ArticleDetailActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article_detail);
		
		/* get parsed information and select relevant article */
		 int viewPosition = getIntent().getIntExtra("listItemPosition", 0);
		 String detailString;
		 
		 switch (viewPosition){
		 case 0 :   detailString =Utilities.ARTICLE_DETAILS[viewPosition];
		 	break;
		 case 1 :   detailString =Utilities.ARTICLE_DETAILS[viewPosition];
		 break;
		 case 2:  detailString =Utilities.ARTICLE_DETAILS[viewPosition];
		 break;
		 case 3 : detailString =Utilities.ARTICLE_DETAILS[viewPosition];
		 break;
		 case 4 : detailString =Utilities.ARTICLE_DETAILS[viewPosition];
		 break;
		 case 5 : detailString =Utilities.ARTICLE_DETAILS[viewPosition];
		 break;
		 case 6 : detailString =Utilities.ARTICLE_DETAILS[viewPosition];
		 break;
		 default : detailString = "Article Unavailable";
		 }//switch
		 
		/* Set text in textView with relevant article */
		TextView detailTextView = (TextView) findViewById(R.id.detailText);
		detailTextView.setText(detailString);
	} //onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.article_detail, menu);
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
