package com.orb.table;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import org.w3c.dom.*;
import android.content.Intent.*;
import android.content.*;
import android.net.Uri;
import android.view.animation.*;
import java.util.*;
import android.animation.*;
import android.text.*;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity
{
    @Override
	private long splashDelay=2000;

	public void vim()
	{
		// TODO: Implement this method
	}
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		
	
		setContentView(R.layout.splash);
	
		new Timer().schedule(new TimerTask() {
				public void run() {
				
		vim( );
					
				}
			}, this.splashDelay);
		
		
		



	}

	@Override
	protected void onRestart()
	{
		// TODO: Implement this method
		super.onRestart();
		
		setContentView(R.layout.splash);
		
	}

	

	
	public void showtable(View view){
		TextView resultt=(TextView)findViewById(R.id.mainTextView1);
		EditText myval=(EditText)findViewById(R.id.mainEditText1);
		

		String myvals=myval.getText().toString();
		if(myvals.equals("")){
			Toast.makeText(getApplicationContext(),"Input a value",Toast.LENGTH_SHORT).show();
	
			}else{
			
		if(myvals.length()<=5){
		
		int myvali=Integer.valueOf(myvals);
		
		if(myvali>=1){
			
			if(myvali<=10000){
			
		String mytable="";
		
		for(int i=1;i<=10;i++){
			int x=i*myvali;
			mytable+=myvals+" x "+Integer.toString(i)+" = "+x+"\n";
	
			
		}
			    LinearLayout lay3=(LinearLayout)findViewById(R.id.lay3);
				// Do some fancy animation...
				TranslateAnimation animation = new TranslateAnimation(0,0,-1000,0);
				animation.setDuration(1000);
				lay3.startAnimation(animation);
		
				


				resultt.setText(mytable);
		
		
		}else{
			Toast.makeText(getApplicationContext(),"Input a number from 1-10000",Toast.LENGTH_SHORT).show();
			
			
		}
		}else{
			Toast.makeText(getApplicationContext(),"Input a value from 1-10000",Toast.LENGTH_SHORT).show();
		}
		
		}else{
			Toast.makeText(getApplicationContext(),"Input a value from 1-10000",Toast.LENGTH_SHORT).show();
		}
			
		
	
}}

public void goToFb(View view){
	Intent gofb=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com/bappyrehsan"));
	startActivity(gofb);
	
	
	
}
public void cleantxtbox(View view){
	EditText mytxt=(EditText)findViewById(R.id.mainEditText1);
	mytxt.setText("");
	
}
public void vim(View view){
	
	setContentView(R.layout.main);
	
	LinearLayout lay3=(LinearLayout)findViewById(R.id.lay3);
	// Do some fancy animation...
	TranslateAnimation animation = new TranslateAnimation(0,0,1000,0);
	animation.setDuration(1000);
	lay3.startAnimation(animation);
	
	
	
	
}

}
