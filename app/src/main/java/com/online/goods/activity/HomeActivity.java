package com.online.goods.activity;

import java.util.ArrayList;
import java.util.List;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.online.goods.R;
import com.online.goods.adapter.HomeQuickAdapter;
import com.online.goods.entity.GoodsBean;
import com.online.goods.fragment.HomeBrowseFragment;
import com.online.goods.fragment.HomeFragment;
import com.online.goods.fragment.HomeQuickFragment;
import com.online.goods.special.KeyboardUtil;
import com.online.goods.view.MyKeyboardView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class HomeActivity extends BaseActivity {

	private HomeFragment homeFragment;
	private HomeQuickFragment homQuickFragment;
	private KeyboardUtil keyboardUtil;
	@ViewInject(R.id.include_home_browse_submenu)
	LinearLayout linear_submenu_show;

	@ViewInject(R.id.include_home_quick)
	LinearLayout linear_home_qucic;

	@ViewInject(R.id.include_home_browse)
	LinearLayout linear_home_browse;
	
	@ViewInject(R.id.fg_home_quick)
	ListView listView_quick;

	private int showMode = 0;// 0浏览模式，1快速模式
	
	private Context ctx;
	private Activity act;
	private EditText edit;
	private EditText et_home_quick;
	
	private HomeBrowseFragment homeBrowseFragment;
	private HomeQuickFragment homeQuickFragment;
	
	private HomeQuickAdapter homeQuickAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ViewUtils.inject(this);
		if (savedInstanceState != null) {
			homeFragment = (HomeFragment) getSupportFragmentManager()
					.findFragmentByTag("homeFragment");
		}
		init(savedInstanceState);
	}

	private void init(Bundle savedInstanceState) {
		ctx = this;
		act = this;

		edit = (EditText) this.findViewById(R.id.edit);
		et_home_quick =(EditText) this.findViewById(R.id.et_home_quick);
		//edit.setInputType(InputType.TYPE_NULL);
		
		homeFragment = new HomeFragment();
		homeFragment.setMainActivity(this);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.main_fl, homeFragment, "homeFragment").commit();

			getSupportFragmentManager().beginTransaction().addToBackStack(null);

		}
		/*keyboardUtil=new KeyboardUtil(act, ctx, et_home_quick);
		keyboardUtil.showKeyboard();*/
		
		
		
	}

	public void modeSwitch(int mode) {
		showMode = mode;
		if (linear_home_qucic != null) {
			System.out.println("*********linear_home_qucic no null");
		}
		if (linear_home_browse != null) {
			System.out.println("*********linear_home_browse no null");
		}
		
		if (linear_home_browse != null && linear_home_qucic != null) {
			if (showMode == 0) {
				System.out.println("*******showMode 0");
				linear_home_browse.setVisibility(View.VISIBLE);
				linear_home_qucic.setVisibility(View.GONE);
			} else {
				System.out.println("*******showMode 1");
				linear_home_browse.setVisibility(View.GONE);
				linear_home_qucic.setVisibility(View.VISIBLE);
				
				loadQuickData();
				
				
				
			}
		}

	}
	private void loadQuickData() {
		List<GoodsBean> hotBean= new ArrayList<GoodsBean>();
		for (int i = 0; i < 6; i++) {
			GoodsBean bean = new GoodsBean("" + i, "商品名称" + i, "商品名称" + i, "2",
					0, 0);
			hotBean.add(bean);
		}
		homeQuickAdapter = new HomeQuickAdapter(hotBean, this);
		if(listView_quick != null&& homeQuickAdapter!=null){
			listView_quick.setAdapter(homeQuickAdapter);
		}
		
	}
	public void showSubMenu() {
		if (linear_submenu_show != null) {
			linear_submenu_show.setVisibility(View.VISIBLE);
		}else{
			System.out.println("******************showSubMenu");
		}
	}

	public void hideSubMenu() {
		if (linear_submenu_show != null) {
			linear_submenu_show.setVisibility(View.GONE);
		}else{
			System.out.println("******************hideSubMenu");
		}
	}

	/*@OnClick({ R.id.quickbutton, R.id.browsebutton, R.id.linear_submenu_show })
	private void onClick(View view) {
		switch (view.getId()) {
		case R.id.quickbutton:
			System.out.println("*********************quickbutton");
			modeSwitch(1);
			break;
		case R.id.browsebutton:
			System.out.println("*********************browsebutton");
			modeSwitch(0);
			break;
		case R.id.linear_submenu_show:
			System.out.println("*********************linear_submenu_show");
			hideSubMenu();
			break;
		case R.id.submenu_layoutid:
			System.out.println("*********************submenu_layoutid");
			showSubMenu();
			break;

		default:
			break;
		}
	}*/
	
	@OnClick({ R.id.quickbutton,R.id.browsebutton, R.id.submenu_layoutid,R.id.submenu_show_close})
	private void onClick(View view) {
		switch (view.getId()) {
		case R.id.quickbutton:
			modeSwitch(1);
			break;
		case R.id.browsebutton:
			modeSwitch(0);
			break;
		case R.id.submenu_layoutid:
			showSubMenu();
			break;
		case R.id.submenu_show_close:
			hideSubMenu();
			break;

		default:
			break;
		}
	}
}
