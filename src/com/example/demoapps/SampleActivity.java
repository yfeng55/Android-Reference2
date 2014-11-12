package com.example.demoapps;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;


public class SampleActivity extends Activity{
	
	private TextView sender;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.samplelayout);
		
		sender = (TextView) findViewById(R.id.senderNum);
		
		// set font
//		Typeface type = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Italic.ttf");
//		sender.setTypeface(type);
	}
	
	
}
