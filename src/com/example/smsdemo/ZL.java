package com.example.smsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ZL extends Activity {
	private Button b1,b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zl);
		b1=(Button)findViewById(R.id.btnOk);
		b2=(Button)findViewById(R.id.cw);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i4=new Intent();
				i4.setClass(ZL.this,Shouye.class);
				startActivity(i4);
				ZL.this.finish();
				
			}
		});
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_LONG).show();
				b1.setText("成为摄影师");
				b2.setText("返回");
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zl, menu);
		return true;
	}

}

