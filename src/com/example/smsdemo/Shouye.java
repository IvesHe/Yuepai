package com.example.smsdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Shouye extends Activity {
	
	private RadioGroup r1;
	private ImageButton b1,b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shouye);
		r1=(RadioGroup)findViewById(R.id.rg);
		r1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				switch (arg1) {  
	            case R.id.rb1:  
	                
	                break;  
	            case R.id.rb2:  
	            	Intent aa2=new Intent();
	            	aa2.setClass(Shouye.this, ZL.class);
	            	startActivity(aa2);
	            	Shouye.this.finish();
	                
	                break;  
	            case R.id.rb3: 
	            	Intent aa1=new Intent();
	            	aa1.setClass(Shouye.this, Wdedd.class);
	            	startActivity(aa1);
	            	Shouye.this.finish();
     
	            	break;  
				}
			}
		});
		b1=(ImageButton)findViewById(R.id.imageButton1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent aa=new Intent();
            	aa.setClass(Shouye.this, Onesix.class);
            	startActivity(aa);
            	Shouye.this.finish();
				
			}
		});
		
		b2=(ImageButton)findViewById(R.id.imageButton2);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent aa=new Intent();
            	aa.setClass(Shouye.this, Six.class);
            	startActivity(aa);
            	Shouye.this.finish();
			}
		});
		
		
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

