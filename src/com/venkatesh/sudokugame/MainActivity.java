package com.venkatesh.sudokugame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.venkatesh.sudokugame.gui.MainMenuScreen;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Fragment homeFragment = new MainMenuScreen();
		FragmentManager fragmentManager = getSupportFragmentManager();  
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); 
		fragmentTransaction.add(R.id.container, homeFragment);     
		fragmentTransaction.commit();
	}
}
