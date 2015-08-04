package com.venkatesh.sudoku.CustomFont;

import android.content.Context;
import android.graphics.Typeface;

public final class CustomFont{

	public static final Typeface setRegularFont(Context ctx){
		Typeface typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/HelveticaNeue-Light.otf");
		return typeface;
	}
	public static final Typeface setNumberFont(Context ctx){
		Typeface typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/HelveticaNeue-UltraLight.otf");
		return typeface;
	}    
}