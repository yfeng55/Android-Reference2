package com.example.demoapps;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MenuActivty extends ListActivity{

	String activities[]= {"SlidingDrawerDemo", "TabsDemo", "HttpDemo", "Flipper", "SharedPrefsDemo", "InternalDataDemo", "HistogramDemo", "Carousel"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activities));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		String menuchoice = activities[position];
		
		try {
			Class myactivity = Class.forName("com.example.demoapps." + menuchoice);
			Intent i = new Intent(this, myactivity);
			startActivity(i);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}


}
