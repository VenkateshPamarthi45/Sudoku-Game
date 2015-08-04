package com.venkatesh.Navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.venkatesh.sudokugame.R;


public class NavigationFragments {

	public static void movingFragments(Fragment fragment, Fragment destFrag, int animation) {
		FragmentTransaction ft = fragment.getFragmentManager().beginTransaction();
		ft.setCustomAnimations(animation, R.animator.fading_out);
		ft.replace(R.id.container, destFrag,"Newfragment");
		ft.commit();
	}

	public static void movingFragmentsaddToBackStack(Fragment fragment, Fragment destFrag, int animation) {
		FragmentTransaction ft = fragment.getFragmentManager().beginTransaction();
		ft.setCustomAnimations(animation, R.animator.fading_out,R.animator.fade_in,R.animator.moving_left_animation);
		ft.replace(R.id.container, destFrag,"Newfragment");
		ft.addToBackStack("Newfragment");
		ft.commit();
	}
	public static void movingBackFragments(Fragment fragment, Fragment destFrag, int animation) {
		FragmentTransaction ft = fragment.getFragmentManager().beginTransaction();
		ft.setCustomAnimations(R.animator.fade_in, animation);
		ft.replace(R.id.container, destFrag,"Newfragment");
		ft.commit();
	}
}
