package com.example.demoapps;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class InternalDataDemo extends Activity implements OnClickListener{
	
	private EditText name_field;
	private TextView dataresults;
	private Button savebutton;
	private Button loadbutton;
	
	private FileOutputStream fos;
	private FileInputStream fis;
	private static String FILENAME = "datasource";
	
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
		
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.b_save:
			String name = name_field.getText().toString();
			try {
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.write(name.getBytes());
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case R.id.b_load:
			try {
				String collected = null;
				fis = openFileInput(FILENAME);
				byte[] dataArray = new byte[fis.available()];
				while (fis.read(dataArray) != -1){
					collected = new String(dataArray);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		
	}
	
}
