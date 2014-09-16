package com.example.demoapps;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;


public class SlidingDrawerDemo extends Activity implements OnClickListener, OnCheckedChangeListener{
	
	SlidingDrawer sd;
	Button openbutton;
	Button closebutton;
	Button toggleButton;
	CheckBox lockcheckbox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slidingdrawer_demo);
		
		sd = (SlidingDrawer) findViewById(R.id.slidingdrawer1);
		openbutton = (Button) findViewById(R.id.b_open);
		closebutton = (Button) findViewById(R.id.b_close);
		toggleButton = (Button) findViewById(R.id.b_toggle);
		lockcheckbox = (CheckBox) findViewById(R.id.cb_lockunlock);
		
		openbutton.setOnClickListener(this);
		closebutton.setOnClickListener(this);
		toggleButton.setOnClickListener(this);
		lockcheckbox.setOnCheckedChangeListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.b_open:
			sd.open();
			break;
		case R.id.b_close:
			sd.close();
			break;
		case R.id.b_toggle:
			sd.toggle();
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton c, boolean isChecked) {
		if(c.isChecked()){
			sd.lock();
		}else{
			sd.unlock();
		}
	}

	
}
