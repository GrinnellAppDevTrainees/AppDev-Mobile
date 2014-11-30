package info.androidhive.tabsswipe.adapter;

import com.appdev.appdevdirectory.AlumniFragment;
import com.appdev.appdevdirectory.AndroidFragment;
import com.appdev.appdevdirectory.IOSFragment;
import com.appdev.appdevdirectory.ResourceTeamFragment;
import com.appdev.appdevdirectory.TraineeFragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
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
		case 4:
			// ResourceTeamFragment activity
			return new ResourceTeamFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 5;
	}

}
