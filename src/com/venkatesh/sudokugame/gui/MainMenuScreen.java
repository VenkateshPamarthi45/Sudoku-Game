package com.venkatesh.sudokugame.gui;

import com.venkatesh.Navigation.NavigationFragments;
import com.venkatesh.sudokugame.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainMenuScreen extends Fragment implements OnClickListener{

	View view;
	TextView startTextview, exitTextview;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {	

		view = inflater.inflate(R.layout.mainmenu_layout,container, false);
		initalizingGUIVariables();
		return view;
	}

	private void initalizingGUIVariables() {
		startTextview = (TextView) view.findViewById(R.id.startTextview);
		startTextview.setOnClickListener(this);
		exitTextview = (TextView) view.findViewById(R.id.exitTextview);
		exitTextview.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.exitTextview:
			movingToExitBox();
			break;
		case R.id.startTextview:
			NavigationFragments.movingFragmentsaddToBackStack(MainMenuScreen.this, new SelectLevelScreen(), R.animator.moving_right_animation);
			break;
		default:
			break;
		}
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getView().setFocusableInTouchMode(true);
		getView().requestFocus();

		getView().setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {
						movingToExitBox();
						return true;
					}
				}
				return false;
			}
		});
	}
	private void movingToExitBox()
	{
		AlertDialog.Builder alert = new Builder(getActivity());
		alert.setTitle(" Quit ?");
		alert.setMessage(" Do you want to Exit ?");
		alert.setCancelable(false);
		alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {							
			@Override
			public void onClick(DialogInterface dialog, int which) {
				getActivity().finish();
			}
		});
		alert.setNegativeButton("No", null);
		alert.show();
	}	
}
