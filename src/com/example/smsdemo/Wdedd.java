package com.example.smsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Wdedd extends Activity {
	private TextView t1;
	private Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wdedd);
		t1=(TextView)findViewById(R.id.textView1);
		b1=(Button)findViewById(R.id.fanhui);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent hh=new Intent();
				hh.setClass(Wdedd.this,Shouye.class);
				startActivity(hh);
				Wdedd.this.finish();
				
			}
		});
		Intent a=getIntent();
		String num1 = a.getStringExtra("five");  
    	String num2 = a.getStringExtra("six");  
    	String num3 = a.getStringExtra("seven");  
    	String num4 = a.getStringExtra("eight"); 
    	String num5 = a.getStringExtra("nine"); 
    	if(num1!=null)
    		t1.setText("��Ӱʦ��"+num5+"\n"+"ʱ�䣺"+num1+"��"+num2+"��"+num3+"��"+num4);
    	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wdedd, menu);
		return true;
	}

}
