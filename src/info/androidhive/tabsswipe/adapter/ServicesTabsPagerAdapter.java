package info.androidhive.tabsswipe.adapter;

import com.appdev.appdevdirectory.AppReqFragment;
import com.appdev.appdevdirectory.TrainReqFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ServicesTabsPagerAdapter extends FragmentPagerAdapter{

	public ServicesTabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Android ListFragment activity
			return new AppReqFragment();
		case 1:
			// IOS ListFragment activity
			return new TrainReqFragment();

		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 2;
	}

}
