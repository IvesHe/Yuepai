package com.example.smsdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Yuyue extends Activity {
	private Button qsb,yyb,fhb;
	public int i=0;
	String num1,num2,num3,num4,num5;
	private Spinner spiEdu=null;
	private ArrayAdapter<CharSequence> adapteEdu=null;
	private List<CharSequence> dataEdu=null;//瀹氫箟涓�釜闆嗗悎鏁版嵁

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_yuyue);
		qsb=(Button)findViewById(R.id.qishibutton);
		Intent a=getIntent();
		
			num1 = a.getStringExtra("one");  
        	num2 = a.getStringExtra("two");  
        	num3 = a.getStringExtra("three");  
        	num4 = a.getStringExtra("four"); 
        	
        	this.dataEdu=new ArrayList<CharSequence>();
        	this.dataEdu.add("向日癸");
        	this.dataEdu.add("玫瑰");
        	this.dataEdu.add("茉莉");
        	this.spiEdu=(Spinner)super.findViewById(R.id.spinner1);
        	this.spiEdu.setPrompt("请选择摄影师:");
        	this.adapteEdu=new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item,this.dataEdu);
        	this.adapteEdu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        	this.spiEdu.setAdapter(this.adapteEdu);
        	 num5 = spiEdu.getSelectedItem().toString();
        	
   
        
        		
		
		qsb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i1=new Intent();
				i1.setClass(Yuyue.this,Shijian.class);
				startActivity(i1);
				Yuyue.this.finish();
				
			}
		});
		
		
		if(num1==null)
    		qsb.setText("点击设置时间:");
		else if(num1!=null)
    		qsb.setText(num1+"年"+num2+"月"+num3+"日"+num4);
		
	
		yyb=(Button)findViewById(R.id.yuyuebutton);
		yyb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(num1==null)
					Toast.makeText(getApplicationContext(), "请设置预约时间！", Toast.LENGTH_LONG).show();
				else
				{
					Toast.makeText(getApplicationContext(), "恭喜你预约成功！", Toast.LENGTH_LONG).show();
					Intent i2=new Intent();
					i2.putExtra("five", num1);
					i2.putExtra("six", num2);
					i2.putExtra("seven", num3);
					i2.putExtra("eight", num4);
					i2.putExtra("nine", num5);
					i2.setClass(Yuyue.this,Wdedd.class);
					startActivity(i2);
					Yuyue.this.finish();
				}
				
				
			}
		});
		fhb=(Button)findViewById(R.id.fanhuibutton);
		fhb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i4=new Intent();
				i4.setClass(Yuyue.this,Shouye.class);
				startActivity(i4);
				Yuyue.this.finish();
			
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.yuyue, menu);
		return true;
	}

}
