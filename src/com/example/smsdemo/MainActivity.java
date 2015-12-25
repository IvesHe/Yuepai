package com.example.smsdemo;

import static cn.smssdk.framework.utils.R.getStringRes;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
 
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button sensmsButton,verificationButton,countryButton;
	private TextView countryTextView,textView2;
	private EditText phonEditText,verEditText;
	// 填写从短信SDK应用后台注册得到的APPKEY 
	private static String APPKEY = "4a5449be48fc ";//463db7238681  27fe7909f8e8
	// 填写从短信SDK应用后台注册得到的APPSECRET
	private static String APPSECRET = "f08bd04c243dab7e41ca94e9499dec00";//
	public String phString;                                              //3684fd4f0e16d68f69645af1c7f8f5bd
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sensmsButton=(Button) findViewById(R.id.button1);
		verificationButton=(Button) findViewById(R.id.button2);
		
		countryTextView=(TextView) findViewById(R.id.textView1);
		textView2=(TextView) findViewById(R.id.textView2);
		phonEditText=(EditText) findViewById(R.id.editText1);
		verEditText=(EditText) findViewById(R.id.editText2);
		sensmsButton.setOnClickListener(this);
		verificationButton.setOnClickListener(this);
		
		
		//System.loadLibrary("OSbase");
		SMSSDK.initSDK(this,APPKEY,APPSECRET);
		EventHandler eh=new EventHandler(){

			@Override
			public void afterEvent(int event, int result, Object data) {
				
				Message msg = new Message();
				msg.arg1 = event;
				msg.arg2 = result;
				msg.obj = data;
				handler.sendMessage(msg);
			}
			
		};
		SMSSDK.registerEventHandler(eh);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1://获取验证码
			if(!TextUtils.isEmpty(phonEditText.getText().toString())){
				SMSSDK.getVerificationCode("86",phonEditText.getText().toString());
				phString=phonEditText.getText().toString();
			}else {
				Toast.makeText(this, "电话不能为空", 1).show();
			}
			
			break;
		case R.id.button2://校验验证码
			if(!TextUtils.isEmpty(verEditText.getText().toString())){
				SMSSDK.submitVerificationCode("86", phString, verEditText.getText().toString());
			}else {
				Toast.makeText(this, "验证码不能为空", 1).show();
			}
			break;
		default:
			break;
		}
	}
	Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			int event = msg.arg1;
			int result = msg.arg2;
			Object data = msg.obj;
			Log.e("event", "event="+event);
			if (result == SMSSDK.RESULT_COMPLETE) {
				//短信注册成功后，返回MainActivity,然后提示新好友
				if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {//提交验证码成功
					Toast.makeText(getApplicationContext(), "提交验证码成功", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(MainActivity.this,
							Shouye.class);
					startActivity(intent);
				} else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
					Toast.makeText(getApplicationContext(), "验证码已经发送", Toast.LENGTH_SHORT).show();
				}
			} else {
				((Throwable) data).printStackTrace();
				int resId = getStringRes(MainActivity.this, "smssdk_network_error");
				Toast.makeText(MainActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
				if (resId > 0) {
					Toast.makeText(MainActivity.this, resId, Toast.LENGTH_SHORT).show();
				}
			}
			
		}
		
	};
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		SMSSDK.unregisterAllEventHandler();
	}
	

}
