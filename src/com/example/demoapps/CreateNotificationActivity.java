package com.example.demoapps;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class CreateNotificationActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createnotification);
	}

	public void createNotification(View view) {
		
		// Prepare intent which is triggered if the notification is selected
		Intent intent = new Intent(this, NotificationReceiverActivity.class);
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

		// Build the notification with example Actions
		Notification noti = new Notification.Builder(this)
				.setContentTitle("New mail from " + "test@gmail.com")
				.setContentText("Subject").setSmallIcon(R.drawable.ic_launcher)
				.setContentIntent(pIntent).build();
		
		//get the notificationManager
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		// hide the notification after it is selected; add the cancel flag to the NotificationManager object
		noti.flags = noti.flags | Notification.FLAG_AUTO_CANCEL;

		notificationManager.notify(0, noti);
	}
}