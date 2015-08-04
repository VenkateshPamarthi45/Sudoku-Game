package com.venkatesh.sudokugame.gui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venkatesh.Navigation.NavigationFragments;
import com.venkatesh.sudokugame.R;

public class SelectLevelScreen extends Fragment implements OnClickListener{

	View view;
	TextView easyLevelTextView, mediumLevelTextView, hardLevelTextView;
	int screenWidth = 0;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.select_level_layout, container, false);
		initalizingGUIVariables();
		gettingScreenSize();
		return view;
	}
	private void initalizingGUIVariables() {
		easyLevelTextView = (TextView) view.findViewById(R.id.easyTextview);
		easyLevelTextView.setOnClickListener(this);
		mediumLevelTextView = (TextView) view.findViewById(R.id.mediumTextview);
		hardLevelTextView = (TextView) view.findViewById(R.id.hardTextview);
		mediumLevelTextView.setOnClickListener(this);
		hardLevelTextView.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.easyTextview:
			NavigationFragments.movingFragments(SelectLevelScreen.this, new SudokuTable(screenWidth, 35), R.animator.moving_right_animation);
			break;
		case R.id.mediumTextview:
			NavigationFragments.movingFragments(SelectLevelScreen.this, new SudokuTable(screenWidth, 50), R.animator.moving_right_animation);
			break;
		case R.id.hardTextview:
			NavigationFragments.movingFragments(SelectLevelScreen.this, new SudokuTable(screenWidth, 55), R.animator.moving_right_animation);
			break;

		default:
			break;
		}
	}	
	private void gettingScreenSize() {
		Display display = getActivity().getWindowManager().getDefaultDisplay();
		screenWidth = display.getWidth();
	}
}
