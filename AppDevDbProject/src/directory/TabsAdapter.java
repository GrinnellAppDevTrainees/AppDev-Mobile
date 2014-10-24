package directory;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

public class TabsAdapter extends FragmentPagerAdapter {

	public TabsAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public ListFragment getItem(int index) {

		switch (index) {
		case 0:
			// Android ListFragment activity
			return new AndroidFragment();
		case 1:
			// IOS ListFragment activity
			return new IOSFragment();
		case 2:
			// Trainee ListFragment activity
			return new TraineeFragment();
		case 3:
			// Trainee AlumniFragment activity
			return new AlumniFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 4;
	}

}