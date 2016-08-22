package com.online.goods.view;


import com.online.goods.special.KeyboardUtil;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.widget.EditText;
public class MyKeyboardView extends KeyboardView{
	private Context ctx;
	private Activity act;
	private EditText edit;
	KeyboardUtil keyboardUtil;
	
	public MyKeyboardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		//new KeyboardUtil(act, ctx, edit).showKeyboard();
		
		keyboardUtil=new KeyboardUtil();
	}
	public void init(Activity act, Context ctx, EditText edit){
		this.act = act;
		this.ctx = ctx;
		this.edit = edit;
	}
	public void setEdit(EditText edit){
		this.edit = edit;
	}

}
