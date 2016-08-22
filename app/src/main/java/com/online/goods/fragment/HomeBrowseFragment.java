package com.online.goods.fragment;


import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.online.goods.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeBrowseFragment extends Fragment {

	private Activity mainActivity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		System.out.println("*********************HomeBrowseFragment oncreate");
		 View inflate = inflater.inflate(R.layout.layout_home_browse, container, false);
	        ViewUtils.inject(this, inflate);
	       // homeFragment = this;
	        
	        loadData();
	        return inflate;
	}

	public Activity getMainActivity() {
		return mainActivity;
	}

	public void setMainActivity(Activity mainActivity) {
		this.mainActivity = mainActivity;
	}

	private void loadData() {
	}
	
	@OnClick({ R.id.quickbutton, R.id.submenu_layoutid})
	private void onClick(View view) {
		switch (view.getId()) {
		case R.id.quickbutton:
			System.out.println("*********************quickbutton");
			break;
		case R.id.submenu_layoutid:
			System.out.println("*********************submenu_layoutid");
			break;

		default:
			break;
		}
	}
}
