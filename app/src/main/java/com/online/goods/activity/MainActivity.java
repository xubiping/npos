package com.online.goods.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;

import com.online.goods.R;

public class MainActivity extends BaseActivity {

	private Context ctx;
	private Activity act;
	private EditText edit;
	private EditText edit1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//setContentView(R.layout.activity_home);
		
		Intent intent = new Intent(this, HomeActivity.class);
		/**
		 * Intent.FLAG_ACTIVITY_CLEAR_TOP:如果在当前Task中，有要启动的Activity，
		 * 那么把该Acitivity之前的所有Activity都关掉，并把此Activity置前以避免创建Activity的实例
		 */
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		
		/*ctx = this;
		act = this;

		edit = (EditText) this.findViewById(R.id.edit);
		edit.setInputType(InputType.TYPE_NULL);

		edit1 = (EditText) this.findViewById(R.id.edit1);
		new KeyboardUtil(act, ctx, edit).showKeyboard();*/
		

	}

}
