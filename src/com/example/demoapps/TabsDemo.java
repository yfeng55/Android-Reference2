package com.example.demoapps;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


public class TabsDemo extends Activity implements OnClickListener{

	TabHost th;
	TabSpec ts;
	Button newtabbutton, startbutton, stopbutton;
	TextView showResults;
	long start, stop;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_demo);
		
		th = (TabHost) findViewById(R.id.tabhost);
		th.setup();
		
		//add tabs to tabhost
		ts = th.newTabSpec("tag1");
		ts.setContent(R.id.tab1);
		ts.setIndicator("Tab 1");
		th.addTab(ts);
		
		ts = th.newTabSpec("tag2");
		ts.setContent(R.id.tab2);
		ts.setIndicator("Tab 2");
		th.addTab(ts);
		
		ts = th.newTabSpec("tag3");
		ts.setContent(R.id.tab3);
		ts.setIndicator("Tab 3");
		th.addTab(ts);
		
		//set buttons
		newtabbutton = (Button) findViewById(R.id.b_addtab);
		startbutton = (Button) findViewById(R.id.b_start);
		stopbutton = (Button) findViewById(R.id.b_stop);
		
		newtabbutton.setOnClickListener(this);
		startbutton.setOnClickListener(this);
		stopbutton.setOnClickListener(this);
		
		//timer
		showResults = (TextView) findViewById(R.id.tv_showresults);
		start = 0;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.b_start:
			start = System.currentTimeMillis();
			break;
		case R.id.b_stop:
			stop = System.currentTimeMillis();
			
			if(start != 0){
				int minutes, seconds, millis;
				long result = stop - start;
				
				millis = (int) result;
				seconds = (int) millis / 1000;
				minutes = (int) seconds / 60;
				
//				millis = millis % 100;
//				seconds = seconds % 60;
				
				showResults.setText(String.format("%d:%02d:%03d", minutes, seconds, millis));
			}
			break;
		case R.id.b_addtab:
			TabSpec newspec = th.newTabSpec("tag1");
			newspec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String tag) {
					TextView text = new TextView(TabsDemo.this);
					text.setText("you've created a tab");
					return text;
				}
			});
			newspec.setIndicator("New");
			th.addTab(newspec);
			
			break;
		}
	}

	
	
}
