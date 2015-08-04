package com.venkatesh.sudokugame.gui;

import java.util.Random;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.venkatesh.Navigation.NavigationFragments;
import com.venkatesh.sudoku.CustomFont.CustomFont;
import com.venkatesh.sudoku.backendlogic.PuzzleChecker;
import com.venkatesh.sudoku.backendlogic.SudukoCreator;
import com.venkatesh.sudokugame.R;

public class SudokuTable extends Fragment implements OnClickListener {

	LinearLayout sudokuboardlayout;
	int[][] puzzle;
	int screenWidth;
	int difficulty;
	int screenHeight;
	View view;
	Button donebtn;	
	TextView cell00, cell01, cell02, cell03, cell04, cell05, cell06, cell07,
	cell08, cell10, cell11, cell12, cell13, cell14, cell15, cell16,
	cell17, cell18, cell20, cell21, cell22, cell23, cell24, cell25,
	cell26, cell27, cell28, cell30, cell31, cell32, cell33, cell34,
	cell35, cell36, cell37, cell38, cell40, cell41, cell42, cell43,
	cell44, cell45, cell46, cell47, cell48, cell50, cell51, cell52,
	cell53, cell54, cell55, cell56, cell57, cell58, cell60, cell61,
	cell62, cell63, cell64, cell65, cell66, cell67, cell68, cell70,
	cell71, cell72, cell73, cell74, cell75, cell76, cell77, cell78,
	cell80, cell81, cell82, cell83, cell84, cell85, cell86, cell87,
	cell88;

	ProgressDialog progressDialog;
	// class Sudoku Creator
	SudukoCreator sudukoCreator;


	public SudokuTable(int screenWidth, int difficulty) {
		super();
		this.screenWidth = screenWidth;
		this.difficulty = difficulty;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_main, container, false);	
		sudokuboardlayout = (LinearLayout) view.findViewById(R.id.sudokuboardlayout);
		sudukoCreator = new SudukoCreator();
		settingBoardSize();
		initializingGUIViews();			
		settingSudokuPuzzle();
		return view;
	}

	private void settingSudokuPuzzle() {
		puzzle = sudukoCreator.createBoard(difficulty);
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				String valueString = String.valueOf(i) + String.valueOf(j);	
				displayingRegularInBox(valueString, puzzle[i][j]);	
			}
		}		
	}

	private void displayingRegularInBox(String valueString, int numberToBeInsert) {
		if(valueString.equalsIgnoreCase("00"))
		{
			if(numberToBeInsert == 0)
			{
				cell00.setText("");				
			}
			else {
				cell00.setText(String.valueOf(numberToBeInsert));
				cell00.setTextColor(getResources().getColor(R.color.system_color));
				cell00.setClickable(false);				
			}			
		}
		else if (valueString.equalsIgnoreCase("01")) {
			if(numberToBeInsert == 0)
			{
				cell01.setText("");
			}
			else {
				cell01.setText(String.valueOf(numberToBeInsert));
				cell01.setTextColor(getResources().getColor(R.color.system_color));
				cell01.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("02")) {
			if(numberToBeInsert == 0)
			{
				cell02.setText("");
			}
			else {
				cell02.setText(String.valueOf(numberToBeInsert));
				cell02.setTextColor(getResources().getColor(R.color.system_color));
				cell02.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("03")) {
			if(numberToBeInsert == 0)
			{
				cell03.setText("");
			}
			else {
				cell03.setText(String.valueOf(numberToBeInsert));
				cell03.setTextColor(getResources().getColor(R.color.system_color));
				cell03.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("04")) {
			if(numberToBeInsert == 0)
			{
				cell04.setText("");
			}
			else {
				cell04.setText(String.valueOf(numberToBeInsert));
				cell04.setTextColor(getResources().getColor(R.color.system_color));
				cell04.setClickable(false);
			}
		}
		else if( valueString.equalsIgnoreCase("05")) {
			if(numberToBeInsert == 0)
			{
				cell05.setText("");
			}
			else {
				cell05.setText(String.valueOf(numberToBeInsert));
				cell05.setTextColor(getResources().getColor(R.color.system_color));
				cell05.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("06")) {
			if(numberToBeInsert == 0)
			{
				cell06.setText("");
			}
			else {
				cell06.setText(String.valueOf(numberToBeInsert));
				cell06.setTextColor(getResources().getColor(R.color.system_color));
				cell06.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("07")) {
			if(numberToBeInsert == 0)
			{
				cell07.setText("");
			}
			else {
				cell07.setText(String.valueOf(numberToBeInsert));
				cell07.setTextColor(getResources().getColor(R.color.system_color));
				cell07.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("08")) {
			if(numberToBeInsert == 0)
			{
				cell08.setText("");
			}
			else {
				cell08.setText(String.valueOf(numberToBeInsert));
				cell08.setTextColor(getResources().getColor(R.color.system_color));
				cell08.setClickable(false);
			}
		}

		// 2nd row display
		else if(valueString.equalsIgnoreCase("10"))
		{
			if(numberToBeInsert == 0)
			{
				cell10.setText("");
			}
			else {
				cell10.setText(String.valueOf(numberToBeInsert));
				cell10.setTextColor(getResources().getColor(R.color.system_color));
				cell10.setClickable(false);
			}

		}
		else if (valueString.equalsIgnoreCase("11")) {
			if(numberToBeInsert == 0)
			{
				cell11.setText("");
			}
			else {
				cell11.setText(String.valueOf(numberToBeInsert));
				cell11.setTextColor(getResources().getColor(R.color.system_color));
				cell11.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("12")) {
			if(numberToBeInsert == 0)
			{
				cell12.setText("");
			}
			else {
				cell12.setText(String.valueOf(numberToBeInsert));
				cell12.setTextColor(getResources().getColor(R.color.system_color));
				cell12.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("13")) {
			if(numberToBeInsert == 0)
			{
				cell13.setText("");
			}
			else {
				cell13.setText(String.valueOf(numberToBeInsert));
				cell13.setTextColor(getResources().getColor(R.color.system_color));
				cell13.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("14")) {
			if(numberToBeInsert == 0)
			{
				cell14.setText("");
			}
			else {
				cell14.setText(String.valueOf(numberToBeInsert));
				cell14.setTextColor(getResources().getColor(R.color.system_color));
				cell14.setClickable(false);
			}
		}
		else if( valueString.equalsIgnoreCase("15")) {
			if(numberToBeInsert == 0)
			{
				cell15.setText("");
			}
			else {
				cell15.setText(String.valueOf(numberToBeInsert));
				cell15.setTextColor(getResources().getColor(R.color.system_color));
				cell15.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("16")) {
			if(numberToBeInsert == 0)
			{
				cell16.setText("");
			}
			else {
				cell16.setText(String.valueOf(numberToBeInsert));
				cell16.setTextColor(getResources().getColor(R.color.system_color));
				cell16.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("17")) {
			if(numberToBeInsert == 0)
			{
				cell17.setText("");
			}
			else {
				cell17.setText(String.valueOf(numberToBeInsert));
				cell17.setTextColor(getResources().getColor(R.color.system_color));
				cell17.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("18")) {
			if(numberToBeInsert == 0)
			{
				cell18.setText("");
			}
			else {
				cell18.setText(String.valueOf(numberToBeInsert));
				cell18.setTextColor(getResources().getColor(R.color.system_color));
				cell18.setClickable(false);
			}
		}

		// 3rd row

		else if(valueString.equalsIgnoreCase("20"))
		{
			if(numberToBeInsert == 0)
			{
				cell20.setText("");
			}
			else {
				cell20.setText(String.valueOf(numberToBeInsert));
				cell20.setTextColor(getResources().getColor(R.color.system_color));
				cell20.setClickable(false);
			}

		}
		else if (valueString.equalsIgnoreCase("21")) {
			if(numberToBeInsert == 0)
			{
				cell21.setText("");
			}
			else {
				cell21.setText(String.valueOf(numberToBeInsert));
				cell21.setTextColor(getResources().getColor(R.color.system_color));
				cell21.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("22")) {
			if(numberToBeInsert == 0)
			{
				cell22.setText("");
			}
			else {
				cell22.setText(String.valueOf(numberToBeInsert));
				cell22.setTextColor(getResources().getColor(R.color.system_color));
				cell22.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("23")) {
			if(numberToBeInsert == 0)
			{
				cell23.setText("");
			}
			else {
				cell23.setText(String.valueOf(numberToBeInsert));
				cell23.setTextColor(getResources().getColor(R.color.system_color));
				cell23.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("24")) {
			if(numberToBeInsert == 0)
			{
				cell24.setText("");
			}
			else {
				cell24.setText(String.valueOf(numberToBeInsert));
				cell24.setTextColor(getResources().getColor(R.color.system_color));
				cell24.setClickable(false);
			}
		}
		else if( valueString.equalsIgnoreCase("25")) {
			if(numberToBeInsert == 0)
			{
				cell25.setText("");
			}
			else {
				cell25.setText(String.valueOf(numberToBeInsert));
				cell25.setTextColor(getResources().getColor(R.color.system_color));
				cell25.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("26")) {
			if(numberToBeInsert == 0)
			{
				cell26.setText("");
			}
			else {
				cell26.setText(String.valueOf(numberToBeInsert));
				cell26.setTextColor(getResources().getColor(R.color.system_color));
				cell26.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("27")) {
			if(numberToBeInsert == 0)
			{
				cell27.setText("");
			}
			else {
				cell27.setText(String.valueOf(numberToBeInsert));
				cell27.setTextColor(getResources().getColor(R.color.system_color));
				cell27.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("28")) {
			if(numberToBeInsert == 0)
			{
				cell28.setText("");
			}
			else {
				cell28.setText(String.valueOf(numberToBeInsert));
				cell28.setTextColor(getResources().getColor(R.color.system_color));
				cell28.setClickable(false);
			}
		}

		// 4th row
		else if(valueString.equalsIgnoreCase("30"))
		{
			if(numberToBeInsert == 0)
			{
				cell30.setText("");
			}
			else {
				cell30.setText(String.valueOf(numberToBeInsert));
				cell30.setTextColor(getResources().getColor(R.color.system_color));
				cell30.setClickable(false);
			}

		}
		else if (valueString.equalsIgnoreCase("31")) {
			if(numberToBeInsert == 0)
			{
				cell31.setText("");
			}
			else {
				cell31.setText(String.valueOf(numberToBeInsert));
				cell31.setTextColor(getResources().getColor(R.color.system_color));
				cell31.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("32")) {
			if(numberToBeInsert == 0)
			{
				cell32.setText("");
			}
			else {
				cell32.setText(String.valueOf(numberToBeInsert));
				cell32.setTextColor(getResources().getColor(R.color.system_color));
				cell32.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("33")) {
			if(numberToBeInsert == 0)
			{
				cell33.setText("");
			}
			else {
				cell33.setText(String.valueOf(numberToBeInsert));
				cell33.setTextColor(getResources().getColor(R.color.system_color));
				cell33.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("34")) {
			if(numberToBeInsert == 0)
			{
				cell34.setText("");
			}
			else {
				cell34.setText(String.valueOf(numberToBeInsert));
				cell34.setTextColor(getResources().getColor(R.color.system_color));
				cell34.setClickable(false);
			}
		}
		else if( valueString.equalsIgnoreCase("35")) {
			if(numberToBeInsert == 0)
			{
				cell35.setText("");
			}
			else {
				cell35.setText(String.valueOf(numberToBeInsert));
				cell35.setTextColor(getResources().getColor(R.color.system_color));
				cell35.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("36")) {
			if(numberToBeInsert == 0)
			{
				cell36.setText("");
			}
			else {
				cell36.setText(String.valueOf(numberToBeInsert));
				cell36.setTextColor(getResources().getColor(R.color.system_color));
				cell36.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("37")) {
			if(numberToBeInsert == 0)
			{
				cell37.setText("");
			}
			else {
				cell37.setText(String.valueOf(numberToBeInsert));
				cell37.setTextColor(getResources().getColor(R.color.system_color));
				cell37.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("38")) {
			if(numberToBeInsert == 0)
			{
				cell38.setText("");
			}
			else {
				cell38.setText(String.valueOf(numberToBeInsert));
				cell38.setTextColor(getResources().getColor(R.color.system_color));
				cell38.setClickable(false);
			}
		}

		// 5th row
		else if(valueString.equalsIgnoreCase("40"))
		{
			if(numberToBeInsert == 0)
			{
				cell40.setText("");
			}
			else {
				cell40.setText(String.valueOf(numberToBeInsert));
				cell40.setTextColor(getResources().getColor(R.color.system_color));
				cell40.setClickable(false);
			}

		}
		else if (valueString.equalsIgnoreCase("41")) {
			if(numberToBeInsert == 0)
			{
				cell41.setText("");
			}
			else {
				cell41.setText(String.valueOf(numberToBeInsert));
				cell41.setTextColor(getResources().getColor(R.color.system_color));
				cell41.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("42")) {
			if(numberToBeInsert == 0)
			{
				cell42.setText("");
			}
			else {
				cell42.setText(String.valueOf(numberToBeInsert));
				cell42.setTextColor(getResources().getColor(R.color.system_color));
				cell42.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("43")) {
			if(numberToBeInsert == 0)
			{
				cell43.setText("");
			}
			else {
				cell43.setText(String.valueOf(numberToBeInsert));
				cell43.setTextColor(getResources().getColor(R.color.system_color));
				cell43.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("44")) {
			if(numberToBeInsert == 0)
			{
				cell44.setText("");
			}
			else {
				cell44.setText(String.valueOf(numberToBeInsert));
				cell44.setTextColor(getResources().getColor(R.color.system_color));
				cell44.setClickable(false);
			}
		}
		else if( valueString.equalsIgnoreCase("45")) {
			if(numberToBeInsert == 0)
			{
				cell45.setText("");
			}
			else {
				cell45.setText(String.valueOf(numberToBeInsert));
				cell45.setTextColor(getResources().getColor(R.color.system_color));
				cell45.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("46")) {
			if(numberToBeInsert == 0)
			{
				cell46.setText("");
			}
			else {
				cell46.setText(String.valueOf(numberToBeInsert));
				cell46.setTextColor(getResources().getColor(R.color.system_color));
				cell46.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("47")) {
			if(numberToBeInsert == 0)
			{
				cell47.setText("");
			}
			else {
				cell47.setText(String.valueOf(numberToBeInsert));
				cell47.setTextColor(getResources().getColor(R.color.system_color));
				cell47.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("48")) {
			if(numberToBeInsert == 0)
			{
				cell48.setText("");
			}
			else {
				cell48.setText(String.valueOf(numberToBeInsert));
				cell48.setTextColor(getResources().getColor(R.color.system_color));
				cell48.setClickable(false);
			}
		}

		// 6th row
		else if(valueString.equalsIgnoreCase("50"))
		{
			if(numberToBeInsert == 0)
			{
				cell50.setText("");
			}
			else {
				cell50.setText(String.valueOf(numberToBeInsert));
				cell50.setTextColor(getResources().getColor(R.color.system_color));
				cell50.setClickable(false);
			}

		}
		else if (valueString.equalsIgnoreCase("51")) {
			if(numberToBeInsert == 0)
			{
				cell51.setText("");
			}
			else {
				cell51.setText(String.valueOf(numberToBeInsert));
				cell51.setTextColor(getResources().getColor(R.color.system_color));
				cell51.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("52")) {
			if(numberToBeInsert == 0)
			{
				cell52.setText("");
			}
			else {
				cell52.setText(String.valueOf(numberToBeInsert));
				cell52.setTextColor(getResources().getColor(R.color.system_color));
				cell52.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("53")) {
			if(numberToBeInsert == 0)
			{
				cell53.setText("");
			}
			else {
				cell53.setText(String.valueOf(numberToBeInsert));
				cell53.setTextColor(getResources().getColor(R.color.system_color));
				cell53.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("54")) {
			if(numberToBeInsert == 0)
			{
				cell54.setText("");
			}
			else {
				cell54.setText(String.valueOf(numberToBeInsert));
				cell54.setTextColor(getResources().getColor(R.color.system_color));
				cell54.setClickable(false);
			}
		}
		else if( valueString.equalsIgnoreCase("55")) {
			if(numberToBeInsert == 0)
			{
				cell55.setText("");
			}
			else {
				cell55.setText(String.valueOf(numberToBeInsert));
				cell55.setTextColor(getResources().getColor(R.color.system_color));
				cell55.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("56")) {
			if(numberToBeInsert == 0)
			{
				cell56.setText("");
			}
			else {
				cell56.setText(String.valueOf(numberToBeInsert));
				cell56.setTextColor(getResources().getColor(R.color.system_color));
				cell56.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("57")) {
			if(numberToBeInsert == 0)
			{
				cell57.setText("");
			}
			else {
				cell57.setText(String.valueOf(numberToBeInsert));
				cell57.setTextColor(getResources().getColor(R.color.system_color));
				cell57.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("58")) {
			if(numberToBeInsert == 0)
			{
				cell58.setText("");
			}
			else {
				cell58.setText(String.valueOf(numberToBeInsert));
				cell58.setTextColor(getResources().getColor(R.color.system_color));
				cell58.setClickable(false);
			}
		}

		//7th row
		else if(valueString.equalsIgnoreCase("60"))
		{
			if(numberToBeInsert == 0)
			{
				cell60.setText("");
			}
			else {
				cell60.setText(String.valueOf(numberToBeInsert));
				cell60.setTextColor(getResources().getColor(R.color.system_color));
				cell60.setClickable(false);
			}

		}
		else if (valueString.equalsIgnoreCase("61")) {
			if(numberToBeInsert == 0)
			{
				cell61.setText("");
			}
			else {
				cell61.setText(String.valueOf(numberToBeInsert));
				cell61.setTextColor(getResources().getColor(R.color.system_color));
				cell61.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("62")) {
			if(numberToBeInsert == 0)
			{
				cell62.setText("");
			}
			else {
				cell62.setText(String.valueOf(numberToBeInsert));
				cell62.setTextColor(getResources().getColor(R.color.system_color));
				cell62.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("63")) {
			if(numberToBeInsert == 0)
			{
				cell63.setText("");
			}
			else {
				cell63.setText(String.valueOf(numberToBeInsert));
				cell63.setTextColor(getResources().getColor(R.color.system_color));
				cell63.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("64")) {
			if(numberToBeInsert == 0)
			{
				cell64.setText("");
			}
			else {
				cell64.setText(String.valueOf(numberToBeInsert));
				cell64.setTextColor(getResources().getColor(R.color.system_color));
				cell64.setClickable(false);
			}
		}
		else if( valueString.equalsIgnoreCase("65")) {
			if(numberToBeInsert == 0)
			{
				cell65.setText("");
			}
			else {
				cell65.setText(String.valueOf(numberToBeInsert));
				cell65.setTextColor(getResources().getColor(R.color.system_color));
				cell65.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("66")) {
			if(numberToBeInsert == 0)
			{
				cell66.setText("");
			}
			else {
				cell66.setText(String.valueOf(numberToBeInsert));
				cell66.setTextColor(getResources().getColor(R.color.system_color));
				cell66.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("67")) {
			if(numberToBeInsert == 0)
			{
				cell67.setText("");
			}
			else {
				cell67.setText(String.valueOf(numberToBeInsert));
				cell67.setTextColor(getResources().getColor(R.color.system_color));
				cell67.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("68")) {
			if(numberToBeInsert == 0)
			{
				cell68.setText("");
			}
			else {
				cell68.setText(String.valueOf(numberToBeInsert));
				cell68.setTextColor(getResources().getColor(R.color.system_color));
				cell68.setClickable(false);
			}
		}

		// 8th row
		else if(valueString.equalsIgnoreCase("70"))
		{
			if(numberToBeInsert == 0)
			{
				cell70.setText("");
			}
			else {
				cell70.setText(String.valueOf(numberToBeInsert));
				cell70.setTextColor(getResources().getColor(R.color.system_color));
				cell70.setClickable(false);
			}

		}
		else if (valueString.equalsIgnoreCase("71")) {
			if(numberToBeInsert == 0)
			{
				cell71.setText("");
			}
			else {
				cell71.setText(String.valueOf(numberToBeInsert));
				cell71.setTextColor(getResources().getColor(R.color.system_color));
				cell71.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("72")) {
			if(numberToBeInsert == 0)
			{
				cell72.setText("");
			}
			else {
				cell72.setText(String.valueOf(numberToBeInsert));
				cell72.setTextColor(getResources().getColor(R.color.system_color));
				cell72.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("73")) {
			if(numberToBeInsert == 0)
			{
				cell73.setText("");
			}
			else {
				cell73.setText(String.valueOf(numberToBeInsert));
				cell73.setTextColor(getResources().getColor(R.color.system_color));
				cell73.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("74")) {
			if(numberToBeInsert == 0)
			{
				cell74.setText("");
			}
			else {
				cell74.setText(String.valueOf(numberToBeInsert));
				cell74.setTextColor(getResources().getColor(R.color.system_color));
				cell74.setClickable(false);
			}
		}
		else if( valueString.equalsIgnoreCase("75")) {
			if(numberToBeInsert == 0)
			{
				cell75.setText("");
			}
			else {
				cell75.setText(String.valueOf(numberToBeInsert));
				cell75.setTextColor(getResources().getColor(R.color.system_color));
				cell75.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("76")) {
			if(numberToBeInsert == 0)
			{
				cell76.setText("");
			}
			else {
				cell76.setText(String.valueOf(numberToBeInsert));
				cell76.setTextColor(getResources().getColor(R.color.system_color));
				cell76.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("77")) {
			if(numberToBeInsert == 0)
			{
				cell77.setText("");
			}
			else {
				cell77.setText(String.valueOf(numberToBeInsert));
				cell77.setTextColor(getResources().getColor(R.color.system_color));
				cell77.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("78")) {
			if(numberToBeInsert == 0)
			{
				cell78.setText("");
			}
			else {
				cell78.setText(String.valueOf(numberToBeInsert));
				cell78.setTextColor(getResources().getColor(R.color.system_color));
				cell78.setClickable(false);
			}
		}

		//9th row
		else if(valueString.equalsIgnoreCase("80"))
		{
			if(numberToBeInsert == 0)
			{
				cell80.setText("");
			}
			else {
				cell80.setText(String.valueOf(numberToBeInsert));
				cell80.setTextColor(getResources().getColor(R.color.system_color));
				cell80.setClickable(false);
			}

		}
		else if (valueString.equalsIgnoreCase("81")) {
			if(numberToBeInsert == 0)
			{
				cell81.setText("");
			}
			else {
				cell81.setText(String.valueOf(numberToBeInsert));
				cell81.setTextColor(getResources().getColor(R.color.system_color));
				cell81.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("82")) {
			if(numberToBeInsert == 0)
			{
				cell82.setText("");
			}
			else {
				cell82.setText(String.valueOf(numberToBeInsert));
				cell82.setTextColor(getResources().getColor(R.color.system_color));
				cell82.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("83")) {
			if(numberToBeInsert == 0)
			{
				cell83.setText("");
			}
			else {
				cell83.setText(String.valueOf(numberToBeInsert));
				cell83.setTextColor(getResources().getColor(R.color.system_color));
				cell83.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("84")) {
			if(numberToBeInsert == 0)
			{
				cell84.setText("");
			}
			else {
				cell84.setText(String.valueOf(numberToBeInsert));
				cell84.setTextColor(getResources().getColor(R.color.system_color));
				cell84.setClickable(false);
			}
		}
		else if( valueString.equalsIgnoreCase("85")) {
			if(numberToBeInsert == 0)
			{
				cell85.setText("");
			}
			else {
				cell85.setText(String.valueOf(numberToBeInsert));
				cell85.setTextColor(getResources().getColor(R.color.system_color));
				cell85.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("86")) {
			if(numberToBeInsert == 0)
			{
				cell86.setText("");
			}
			else {
				cell86.setText(String.valueOf(numberToBeInsert));
				cell86.setTextColor(getResources().getColor(R.color.system_color));
				cell86.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("87")) {
			if(numberToBeInsert == 0)
			{
				cell87.setText("");
			}
			else {
				cell87.setText(String.valueOf(numberToBeInsert));
				cell87.setTextColor(getResources().getColor(R.color.system_color));
				cell87.setClickable(false);
			}
		}
		else if (valueString.equalsIgnoreCase("88")) {
			if(numberToBeInsert == 0)
			{
				cell88.setText("");
			}
			else {
				cell88.setText(String.valueOf(numberToBeInsert));
				cell88.setTextColor(getResources().getColor(R.color.system_color));
				cell88.setClickable(false);			
			}
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.donebtn:
			checkingRegularsFilled();
			break;

		case R.id.cell00:
			gettingTag(v);

			break;
		case R.id.cell01:
			gettingTag(v);

			break;
		case R.id.cell02:
			gettingTag(v);

			break;
		case R.id.cell03:
			gettingTag(v);

			break;
		case R.id.cell04:
			gettingTag(v);

			break;
		case R.id.cell05:
			gettingTag(v);

			break;
		case R.id.cell06:
			gettingTag(v);

			break;
		case R.id.cell07:
			gettingTag(v);

			break;
		case R.id.cell08:
			gettingTag(v);

			break;
		case R.id.cell10:
			gettingTag(v);

			break;
		case R.id.cell11:
			gettingTag(v);

			break;
		case R.id.cell12:
			gettingTag(v);

			break;
		case R.id.cell13:
			gettingTag(v);

			break;
		case R.id.cell14:
			gettingTag(v);

			break;
		case R.id.cell15:
			gettingTag(v);

			break;
		case R.id.cell16:
			gettingTag(v);

			break;
		case R.id.cell17:
			gettingTag(v);

			break;
		case R.id.cell18:
			gettingTag(v);

			break;
		case R.id.cell20:
			gettingTag(v);

			break;
		case R.id.cell21:
			gettingTag(v);

			break;
		case R.id.cell22:
			gettingTag(v);

			break;
		case R.id.cell23:
			gettingTag(v);

			break;
		case R.id.cell24:
			gettingTag(v);

			break;
		case R.id.cell25:
			gettingTag(v);

			break;
		case R.id.cell26:
			gettingTag(v);

			break;
		case R.id.cell27:
			gettingTag(v);

			break;
		case R.id.cell28:
			gettingTag(v);

			break;
		case R.id.cell30:
			gettingTag(v);

			break;
		case R.id.cell31:
			gettingTag(v);

			break;
		case R.id.cell32:
			gettingTag(v);

			break;
		case R.id.cell33:
			gettingTag(v);

			break;
		case R.id.cell34:
			gettingTag(v);

			break;
		case R.id.cell35:
			gettingTag(v);

			break;
		case R.id.cell36:
			gettingTag(v);

			break;
		case R.id.cell37:
			gettingTag(v);

			break;
		case R.id.cell38:
			gettingTag(v);

			break;
		case R.id.cell40:
			gettingTag(v);

			break;
		case R.id.cell41:
			gettingTag(v);

			break;
		case R.id.cell42:
			gettingTag(v);

			break;
		case R.id.cell43:
			gettingTag(v);

			break;
		case R.id.cell44:
			gettingTag(v);

			break;
		case R.id.cell45:
			gettingTag(v);

			break;
		case R.id.cell46:
			gettingTag(v);

			break;
		case R.id.cell47:
			gettingTag(v);

			break;
		case R.id.cell48:
			gettingTag(v);

			break;
		case R.id.cell50:
			gettingTag(v);

			break;
		case R.id.cell51:
			gettingTag(v);

			break;
		case R.id.cell52:
			gettingTag(v);

			break;
		case R.id.cell53:
			gettingTag(v);

			break;
		case R.id.cell54:
			gettingTag(v);

			break;
		case R.id.cell55:
			gettingTag(v);

			break;
		case R.id.cell56:
			gettingTag(v);

			break;
		case R.id.cell57:
			gettingTag(v);

			break;
		case R.id.cell58:
			gettingTag(v);

			break;
		case R.id.cell60:
			gettingTag(v);

			break;
		case R.id.cell61:
			gettingTag(v);

			break;
		case R.id.cell62:
			gettingTag(v);

			break;
		case R.id.cell63:
			gettingTag(v);

			break;
		case R.id.cell64:
			gettingTag(v);

			break;
		case R.id.cell65:
			gettingTag(v);

			break;
		case R.id.cell66:
			gettingTag(v);

			break;
		case R.id.cell67:
			gettingTag(v);

			break;
		case R.id.cell68:
			gettingTag(v);

			break;
		case R.id.cell70:
			gettingTag(v);

			break;
		case R.id.cell71:
			gettingTag(v);

			break;
		case R.id.cell72:
			gettingTag(v);

			break;
		case R.id.cell73:
			gettingTag(v);

			break;
		case R.id.cell74:
			gettingTag(v);

			break;
		case R.id.cell75:
			gettingTag(v);

			break;
		case R.id.cell76:
			gettingTag(v);

			break;
		case R.id.cell77:
			gettingTag(v);

			break;
		case R.id.cell78:
			gettingTag(v);

			break;
		case R.id.cell80:
			gettingTag(v);

			break;
		case R.id.cell81:
			gettingTag(v);

			break;
		case R.id.cell82:
			gettingTag(v);

			break;
		case R.id.cell83:
			gettingTag(v);

			break;
		case R.id.cell84:
			gettingTag(v);

			break;
		case R.id.cell85:
			gettingTag(v);

			break;
		case R.id.cell86:
			gettingTag(v);

			break;
		case R.id.cell87:
			gettingTag(v);

			break;
		case R.id.cell88:
			gettingTag(v);

			break;

		default:
			break;
		}
	}

	private void checkingRegularsFilled() {
		if(PuzzleChecker.isPuzzleFilled(puzzle))
		{
			if (checkingFilledRegulars()) {
				showingAlertBox();
			}
			else {
				Toast.makeText(getActivity(), "Please fill Correctly", Toast.LENGTH_SHORT).show();
			}

		}
		else {
			Toast.makeText(getActivity(), "Please Fill Numbers", Toast.LENGTH_SHORT).show();
		}
	}

	private void showingAlertBox() {
		AlertDialog.Builder alert = new Builder(getActivity());
		alert.setTitle(" Congratulations");
		alert.setMessage(" Do you want to Play Next Puzzle?");
		alert.setCancelable(false);
		alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {							
			@Override
			public void onClick(DialogInterface dialog, int which) {
				settingSudokuPuzzle();
			}
		});
		alert.setNegativeButton("No", new DialogInterface.OnClickListener() {							
			@Override
			public void onClick(DialogInterface dialog, int which) {
				NavigationFragments.movingBackFragments(SudokuTable.this, new MainMenuScreen(), R.animator.moving_left_animation);
			}
		});
		alert.show();
	}

	private boolean checkingFilledRegulars() {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				int number = puzzle[i][j];
				if(!PuzzleChecker.isPuzzleFilledCorrectly(i, j, number, puzzle))
					return false;			
			}
		}
		return true;
	}

	private void gettingTag(View tagv) {

		String tag1 = tagv.getTag().toString(); 
		int rowNum1 =  Integer.parseInt(tag1.substring(0, 1)); 
		int colNum1 =  Integer.parseInt(tag1.substring(1)); 		
		disPlayingKeyPad(rowNum1, colNum1, puzzle, (TextView) tagv);

	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	private void  disPlayingKeyPad(final int row, final int column, final int[][] puzzle, final TextView textview) {
		final Dialog dialog = new Dialog(getActivity());
		Random random = new Random();
		int value = random.nextInt((3 - 1) + 1) + 1;
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.keypad_layout);
		RelativeLayout numKePadLayout = (RelativeLayout) dialog.findViewById(R.id.rootlayout);
		int sdk = android.os.Build.VERSION.SDK_INT;

		if(value == 1)
		{
			if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
				numKePadLayout.setBackgroundDrawable( getResources().getDrawable(R.drawable.color_gradient1_background_color) );
			} else {
				numKePadLayout.setBackground( getResources().getDrawable(R.drawable.color_gradient1_background_color));
			}
		}
		else if (value == 2) {
			if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
				numKePadLayout.setBackgroundDrawable( getResources().getDrawable(R.drawable.color_gradient_background_color) );
			} else {
				numKePadLayout.setBackground( getResources().getDrawable(R.drawable.color_gradient_background_color));
			}
		}
		else if (value == 3) {
			if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
				numKePadLayout.setBackgroundDrawable( getResources().getDrawable(R.drawable.keypad_background_color) );
			} else {
				numKePadLayout.setBackground( getResources().getDrawable(R.drawable.keypad_background_color));
			}
		}

		TextView oneNum = (TextView) dialog.findViewById(R.id.oneNum);
		oneNum.setTypeface(CustomFont.setRegularFont(getActivity()));
		TextView twoNum = (TextView) dialog.findViewById(R.id.twoNum);
		twoNum.setTypeface(CustomFont.setRegularFont(getActivity()));
		TextView threeNum = (TextView) dialog.findViewById(R.id.threeNum);
		threeNum.setTypeface(CustomFont.setRegularFont(getActivity()));
		TextView fourNum = (TextView) dialog.findViewById(R.id.fourNum);
		fourNum.setTypeface(CustomFont.setRegularFont(getActivity()));
		TextView fiveNum = (TextView) dialog.findViewById(R.id.fiveNum);
		fiveNum.setTypeface(CustomFont.setRegularFont(getActivity()));
		TextView sixNum = (TextView) dialog.findViewById(R.id.sixNum);
		sixNum.setTypeface(CustomFont.setRegularFont(getActivity()));
		TextView sevenNum = (TextView) dialog.findViewById(R.id.sevenNum);
		sevenNum.setTypeface(CustomFont.setRegularFont(getActivity()));
		TextView eightNum = (TextView) dialog.findViewById(R.id.eightNum);
		eightNum.setTypeface(CustomFont.setRegularFont(getActivity()));
		TextView nineNum = (TextView) dialog.findViewById(R.id.nineNum);
		nineNum.setTypeface(CustomFont.setRegularFont(getActivity()));	

		oneNum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isValid = sudukoCreator.isNumberValidHere(row, column, 1, puzzle);
				puzzle[row] [column] = 1;
				textview.setText("1");			
				if(isValid)
					textview.setTextColor(getResources().getColor(R.color.correct_color));
				else 
					textview.setTextColor(getResources().getColor(R.color.incorrect_color));					
				dialog.dismiss();
			}		
		});
		twoNum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isValid = sudukoCreator.isNumberValidHere(row, column, 2, puzzle);
				puzzle[row] [column] = 2;
				textview.setText("2");			
				if(isValid)
					textview.setTextColor(getResources().getColor(R.color.correct_color));
				else 
					textview.setTextColor(getResources().getColor(R.color.incorrect_color));					
				dialog.dismiss();
			}		
		});
		threeNum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isValid = sudukoCreator.isNumberValidHere(row, column, 3, puzzle);
				puzzle[row] [column] = 3;
				textview.setText("3");			
				if(isValid)
					textview.setTextColor(getResources().getColor(R.color.correct_color));
				else 
					textview.setTextColor(getResources().getColor(R.color.incorrect_color));					
				dialog.dismiss();
			}		
		});
		fourNum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isValid = sudukoCreator.isNumberValidHere(row, column, 4, puzzle);
				puzzle[row] [column] = 4;
				textview.setText("4");			
				if(isValid)
					textview.setTextColor(getResources().getColor(R.color.correct_color));
				else 
					textview.setTextColor(getResources().getColor(R.color.incorrect_color));					
				dialog.dismiss();
			}		
		});
		fiveNum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isValid = sudukoCreator.isNumberValidHere(row, column, 5, puzzle);
				puzzle[row] [column] = 5;
				textview.setText("5");			
				if(isValid)
					textview.setTextColor(getResources().getColor(R.color.correct_color));
				else 
					textview.setTextColor(getResources().getColor(R.color.incorrect_color));					
				dialog.dismiss();
			}		
		});
		sixNum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isValid = sudukoCreator.isNumberValidHere(row, column, 6, puzzle);
				puzzle[row] [column] = 6;
				textview.setText("6");			
				if(isValid)
					textview.setTextColor(getResources().getColor(R.color.correct_color));
				else 
					textview.setTextColor(getResources().getColor(R.color.incorrect_color));					
				dialog.dismiss();
			}		
		});
		sevenNum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isValid = sudukoCreator.isNumberValidHere(row, column, 7, puzzle);
				puzzle[row] [column] = 7;
				textview.setText("7");			
				if(isValid)
					textview.setTextColor(getResources().getColor(R.color.correct_color));
				else 
					textview.setTextColor(getResources().getColor(R.color.incorrect_color));					
				dialog.dismiss();
			}		
		});
		eightNum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isValid = sudukoCreator.isNumberValidHere(row, column, 8, puzzle);
				puzzle[row] [column] = 8;
				textview.setText("8");			
				if(isValid)
					textview.setTextColor(getResources().getColor(R.color.correct_color));
				else 
					textview.setTextColor(getResources().getColor(R.color.incorrect_color));					
				dialog.dismiss();
			}		
		});
		nineNum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isValid = sudukoCreator.isNumberValidHere(row, column, 9, puzzle);
				puzzle[row] [column] = 9;
				textview.setText("9");			
				if(isValid)
					textview.setTextColor(getResources().getColor(R.color.correct_color));
				else 
					textview.setTextColor(getResources().getColor(R.color.incorrect_color));					
				dialog.dismiss();
			}		
		});
		dialog.show();
	}

	private void settingCustomFont() {
		cell00.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell01.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell02.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell03.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell04.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell05.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell06.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell07.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell08.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell10.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell11.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell12.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell13.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell14.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell15.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell16.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell17.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell18.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell20.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell21.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell22.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell23.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell24.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell25.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell26.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell27.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell28.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell30.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell31.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell32.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell33.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell34.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell35.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell36.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell37.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell38.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell40.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell41.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell42.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell43.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell44.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell45.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell46.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell47.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell48.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell50.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell51.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell52.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell53.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell54.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell55.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell56.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell57.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell58.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell60.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell61.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell62.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell63.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell64.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell65.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell66.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell67.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell68.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell70.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell71.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell72.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell73.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell74.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell75.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell76.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell77.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell78.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell80.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell81.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell82.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell83.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell84.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell85.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell86.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell87.setTypeface(CustomFont.setRegularFont(getActivity()));
		cell88.setTypeface(CustomFont.setRegularFont(getActivity()));
	}

	private void addingTextViewListeners() {
		donebtn.setOnClickListener(this);
		cell00.setOnClickListener(this);
		cell01.setOnClickListener(this);
		cell02.setOnClickListener(this);
		cell03.setOnClickListener(this);
		cell04.setOnClickListener(this);
		cell05.setOnClickListener(this);
		cell06.setOnClickListener(this);
		cell07.setOnClickListener(this);
		cell08.setOnClickListener(this);
		cell10.setOnClickListener(this);
		cell11.setOnClickListener(this);
		cell12.setOnClickListener(this);
		cell13.setOnClickListener(this);
		cell14.setOnClickListener(this);
		cell15.setOnClickListener(this);
		cell16.setOnClickListener(this);
		cell17.setOnClickListener(this);
		cell18.setOnClickListener(this);
		cell20.setOnClickListener(this);
		cell21.setOnClickListener(this);
		cell22.setOnClickListener(this);
		cell23.setOnClickListener(this);
		cell24.setOnClickListener(this);
		cell25.setOnClickListener(this);
		cell26.setOnClickListener(this);
		cell27.setOnClickListener(this);
		cell28.setOnClickListener(this);
		cell30.setOnClickListener(this);
		cell31.setOnClickListener(this);
		cell32.setOnClickListener(this);
		cell33.setOnClickListener(this);
		cell34.setOnClickListener(this);
		cell35.setOnClickListener(this);
		cell36.setOnClickListener(this);
		cell37.setOnClickListener(this);
		cell38.setOnClickListener(this);
		cell40.setOnClickListener(this);
		cell41.setOnClickListener(this);
		cell42.setOnClickListener(this);
		cell43.setOnClickListener(this);
		cell44.setOnClickListener(this);
		cell45.setOnClickListener(this);
		cell46.setOnClickListener(this);
		cell47.setOnClickListener(this);
		cell48.setOnClickListener(this);
		cell50.setOnClickListener(this);
		cell51.setOnClickListener(this);
		cell52.setOnClickListener(this);
		cell53.setOnClickListener(this);
		cell54.setOnClickListener(this);
		cell55.setOnClickListener(this);
		cell56.setOnClickListener(this);
		cell57.setOnClickListener(this);
		cell58.setOnClickListener(this);
		cell60.setOnClickListener(this);
		cell61.setOnClickListener(this);
		cell62.setOnClickListener(this);
		cell63.setOnClickListener(this);
		cell64.setOnClickListener(this);
		cell65.setOnClickListener(this);
		cell66.setOnClickListener(this);
		cell67.setOnClickListener(this);
		cell68.setOnClickListener(this);
		cell70.setOnClickListener(this);
		cell71.setOnClickListener(this);
		cell72.setOnClickListener(this);
		cell73.setOnClickListener(this);
		cell74.setOnClickListener(this);
		cell75.setOnClickListener(this);
		cell76.setOnClickListener(this);
		cell77.setOnClickListener(this);
		cell78.setOnClickListener(this);
		cell80.setOnClickListener(this);
		cell81.setOnClickListener(this);
		cell82.setOnClickListener(this);
		cell83.setOnClickListener(this);
		cell84.setOnClickListener(this);
		cell85.setOnClickListener(this);
		cell86.setOnClickListener(this);
		cell87.setOnClickListener(this);
		cell88.setOnClickListener(this);
	}

	private void initializingGUIViews() {

		donebtn = (Button) view.findViewById(R.id.donebtn);
		cell00 = (TextView) view.findViewById(R.id.cell00);
		cell01 = (TextView) view.findViewById(R.id.cell01);
		cell02 = (TextView) view.findViewById(R.id.cell02);
		cell03 = (TextView) view.findViewById(R.id.cell03);
		cell04 = (TextView) view.findViewById(R.id.cell04);
		cell05 = (TextView) view.findViewById(R.id.cell05);
		cell06 = (TextView) view.findViewById(R.id.cell06);
		cell07 = (TextView) view.findViewById(R.id.cell07);
		cell08 = (TextView) view.findViewById(R.id.cell08);
		cell10 = (TextView) view.findViewById(R.id.cell10);
		cell11 = (TextView) view.findViewById(R.id.cell11);
		cell12 = (TextView) view.findViewById(R.id.cell12);
		cell13 = (TextView) view.findViewById(R.id.cell13);
		cell14 = (TextView) view.findViewById(R.id.cell14);
		cell15 = (TextView) view.findViewById(R.id.cell15);
		cell16 = (TextView) view.findViewById(R.id.cell16);
		cell17 = (TextView) view.findViewById(R.id.cell17);
		cell18 = (TextView) view.findViewById(R.id.cell18);
		cell20 = (TextView) view.findViewById(R.id.cell20);
		cell21 = (TextView) view.findViewById(R.id.cell21);
		cell22 = (TextView) view.findViewById(R.id.cell22);
		cell23 = (TextView) view.findViewById(R.id.cell23);
		cell24 = (TextView) view.findViewById(R.id.cell24);
		cell25 = (TextView) view.findViewById(R.id.cell25);
		cell26 = (TextView) view.findViewById(R.id.cell26);
		cell27 = (TextView) view.findViewById(R.id.cell27);
		cell28 = (TextView) view.findViewById(R.id.cell28);
		cell30 = (TextView) view.findViewById(R.id.cell30);
		cell31 = (TextView) view.findViewById(R.id.cell31);
		cell32 = (TextView) view.findViewById(R.id.cell32);
		cell33 = (TextView) view.findViewById(R.id.cell33);
		cell34 = (TextView) view.findViewById(R.id.cell34);
		cell35 = (TextView) view.findViewById(R.id.cell35);
		cell36 = (TextView) view.findViewById(R.id.cell36);
		cell37 = (TextView) view.findViewById(R.id.cell37);
		cell38 = (TextView) view.findViewById(R.id.cell38);

		cell40 = (TextView) view.findViewById(R.id.cell40);
		cell41 = (TextView) view.findViewById(R.id.cell41);
		cell42 = (TextView) view.findViewById(R.id.cell42);
		cell43 = (TextView) view.findViewById(R.id.cell43);
		cell44 = (TextView) view.findViewById(R.id.cell44);
		cell45 = (TextView) view.findViewById(R.id.cell45);
		cell46 = (TextView) view.findViewById(R.id.cell46);
		cell47 = (TextView) view.findViewById(R.id.cell47);
		cell48 = (TextView) view.findViewById(R.id.cell48);

		cell50 = (TextView) view.findViewById(R.id.cell50);
		cell51 = (TextView) view.findViewById(R.id.cell51);
		cell52 = (TextView) view.findViewById(R.id.cell52);
		cell53 = (TextView) view.findViewById(R.id.cell53);
		cell54 = (TextView) view.findViewById(R.id.cell54);
		cell55 = (TextView) view.findViewById(R.id.cell55);
		cell56 = (TextView) view.findViewById(R.id.cell56);
		cell57 = (TextView) view.findViewById(R.id.cell57);
		cell58 = (TextView) view.findViewById(R.id.cell58);

		cell60 = (TextView) view.findViewById(R.id.cell60);
		cell61 = (TextView) view.findViewById(R.id.cell61);
		cell62 = (TextView) view.findViewById(R.id.cell62);
		cell63 = (TextView) view.findViewById(R.id.cell63);
		cell64 = (TextView) view.findViewById(R.id.cell64);
		cell65 = (TextView) view.findViewById(R.id.cell65);
		cell66 = (TextView) view.findViewById(R.id.cell66);
		cell67 = (TextView) view.findViewById(R.id.cell67);
		cell68 = (TextView) view.findViewById(R.id.cell68);

		cell70 = (TextView) view.findViewById(R.id.cell70);
		cell71 = (TextView) view.findViewById(R.id.cell71);
		cell72 = (TextView) view.findViewById(R.id.cell72);
		cell73 = (TextView) view.findViewById(R.id.cell73);
		cell74 = (TextView) view.findViewById(R.id.cell74);
		cell75 = (TextView) view.findViewById(R.id.cell75);
		cell76 = (TextView) view.findViewById(R.id.cell76);
		cell77 = (TextView) view.findViewById(R.id.cell77);
		cell78 = (TextView) view.findViewById(R.id.cell78);

		cell80 = (TextView) view.findViewById(R.id.cell80);
		cell81 = (TextView) view.findViewById(R.id.cell81);
		cell82 = (TextView) view.findViewById(R.id.cell82);
		cell83 = (TextView) view.findViewById(R.id.cell83);
		cell84 = (TextView) view.findViewById(R.id.cell84);
		cell85 = (TextView) view.findViewById(R.id.cell85);
		cell86 = (TextView) view.findViewById(R.id.cell86);
		cell87 = (TextView) view.findViewById(R.id.cell87);
		cell88 = (TextView) view.findViewById(R.id.cell88);
		addingTextViewListeners();
	}

	private void settingBoardSize() {
		ViewGroup.LayoutParams params = sudokuboardlayout
				.getLayoutParams();
		params.width = screenWidth;
		params.height = screenWidth;
		sudokuboardlayout.setLayoutParams(params);
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
		alert.setMessage(" Do you want to Exit Puzzle?");
		alert.setCancelable(false);
		alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {							
			@Override
			public void onClick(DialogInterface dialog, int which) {
				NavigationFragments.movingBackFragments(SudokuTable.this, new MainMenuScreen(), R.animator.moving_left_animation);
			}
		});
		alert.setNegativeButton("No", null);
		alert.show();
	}	
}
