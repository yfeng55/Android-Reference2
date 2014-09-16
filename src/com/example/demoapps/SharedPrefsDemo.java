package com.example.demoapps;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SharedPrefsDemo extends Activity implements OnClickListener{
	
	private EditText name_field;
	private TextView dataresults;
	private Button savebutton;
	private Button loadbutton;
	
	private SharedPreferences prefs;
	static public String filename = "MySharedPreferences";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedprefs);
		
		name_field = (EditText) findViewById(R.id.et_namefield);
		dataresults = (TextView) findViewById(R.id.tv_dataresults);
		savebutton = (Button) findViewById(R.id.b_save);
		loadbutton = (Button) findViewById(R.id.b_load);
		
		savebutton.setOnClickListener(this);
		loadbutton.setOnClickListener(this);
		
		prefs = getSharedPreferences(filename, 0);
	}

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.b_save:
			String name = name_field.getText().toString();
			Editor editor = prefs.edit();
			editor.putString("name", name);
			editor.commit();
			break;
		case R.id.b_load:
			String returnedName = prefs.getString("name", "Couldn't Load Data");
			dataresults.setText(returnedName);
			break;
		}
	}
	
}
