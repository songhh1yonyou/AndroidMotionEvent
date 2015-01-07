package com.example.androidmotionevent;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {

	private static final String TAG="TESTMotionEVENT";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		setContentView(new TestMotionView(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public class  TestMotionView extends View{
		
		private Paint mPaint = new Paint();
		private int mAction;
		private float mX;
		private float mY;

		public TestMotionView(Context c) {
			super(c);
			// TODO Auto-generated constructor stub
			mAction=MotionEvent.ACTION_UP;
			mX=0;
			mY=0;
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			Paint paint=mPaint;
			canvas.drawColor(Color.WHITE);
			if(MotionEvent.ACTION_MOVE==mAction){
				paint.setColor(Color.RED);
			}else if(MotionEvent.ACTION_UP==mAction){
				paint.setColor(Color.GREEN);
			}else if(MotionEvent.ACTION_DOWN==mAction){
				paint.setColor(Color.BLUE);				
			}
			canvas.drawCircle(mX, mY, 10, paint);
			setTitle("A="+mAction+"["+mX+","+mY+"]");
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			mAction=event.getAction();
			mX=event.getX();
			mY=event.getY();
			Log.v(TAG, "Action="+mAction);
			Log.v(TAG,"("+mX+","+mY+")");
			invalidate();
			return true;
			
		}
		
		
	}
	

}
