package com.example.demoapps;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ViewFlipper;


public class Carousel extends Activity{

	private ViewFlipper viewFlipper;
	private float initialX;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.carousel);
		
		viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
		viewFlipper.setInAnimation(this, android.R.anim.fade_in);
		viewFlipper.setOutAnimation(this, android.R.anim.fade_out);
		
	}
	

	@Override
	public boolean onTouchEvent(MotionEvent touchevent) {
		switch (touchevent.getAction()) {
		case MotionEvent.ACTION_DOWN:
			initialX = touchevent.getX();
			break;
		case MotionEvent.ACTION_UP:
			float finalX = touchevent.getX();
			if (initialX > finalX) {
				if (viewFlipper.getDisplayedChild() == 1)
					break;

				viewFlipper.setInAnimation(this, R.anim.in_right);
				viewFlipper.setOutAnimation(this, R.anim.out_left);

				viewFlipper.showNext();
			} else {
				if (viewFlipper.getDisplayedChild() == 0)
					break;

				viewFlipper.setInAnimation(this, R.anim.in_left);
				viewFlipper.setOutAnimation(this, R.anim.out_right);

				viewFlipper.showPrevious();
			}
			break;
		}
		return false;
	}

}
