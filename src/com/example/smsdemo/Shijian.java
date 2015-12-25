package com.example.smsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.TimePicker.OnTimeChangedListener;

public class Shijian extends Activity {
	private TimePicker t1;
	private Button qd;
	private EditText ne,ye,re;
	private String shijian;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shijian);
		ne=(EditText)findViewById(R.id.niane);
		ye=(EditText)findViewById(R.id.yuee);
		re=(EditText)findViewById(R.id.rie);
		t1=(TimePicker)findViewById(R.id.timePicker1);
		t1.setIs24HourView(true);
		t1.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
				// TODO Auto-generated method stub
				shijian=arg1+"时"+arg2+"锟斤拷";
				
			}
		});
		qd=(Button)findViewById(R.id.quedingbutton);
		qd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String nian=ne.getText().toString();
				String yue=ye.getText().toString();
				String ri=re.getText().toString();
				
				int yzn= Integer.parseInt(nian);
				int yzy=Integer.parseInt(yue);
				int yzr=Integer.parseInt(ri);
				if(yzn>2050 || yzn<2016)
				{
					Toast.makeText(getApplicationContext(), "输入错误！重新输入",Toast.LENGTH_LONG).show();
					nian=null;
				}
				if(yzy>13 || yzy<1)
				{
					Toast.makeText(getApplicationContext(), "输入错误！重新输入",Toast.LENGTH_LONG).show();
					nian=null;
				}
				if(yzr>30 || yzr<1)
				{
					Toast.makeText(getApplicationContext(), "输入错误！重新输入",Toast.LENGTH_LONG).show();
					nian=null;
				}
			
			
				
					Intent tiao=new Intent();
					tiao.putExtra("one", nian);  
		            tiao.putExtra("two", yue);  
		            tiao.putExtra("three", ri); 
		            tiao.putExtra("four", shijian);
		         
					tiao.setClass(Shijian.this,Yuyue.class);
					startActivity(tiao);
					Shijian.this.finish();
					
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shijian, menu);
		return true;
	}

}
