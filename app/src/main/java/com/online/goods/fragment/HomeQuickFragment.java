package com.online.goods.fragment;


import java.util.ArrayList;
import java.util.List;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.online.goods.R;
import com.online.goods.adapter.HomeHotAdapter;
import com.online.goods.adapter.HomeQuickAdapter;
import com.online.goods.entity.GoodsBean;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HomeQuickFragment extends Fragment {

	@ViewInject(R.id.fg_home_quick)
	ListView listView;
	private Activity mainActivity;
	private List<GoodsBean> hotBean;
	private HomeQuickAdapter homeQuickAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("***********************-1");
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
	System.out.println("***********************0");
		 View inflate = inflater.inflate(R.layout.fg_home_quick, container, false);
	     if(inflate ==null)
	     {
	    	 System.out.println("***********************inflate null");
	     }
		 ViewUtils.inject(this, inflate);
	       // homeFragment = this;
	        
	        loadData();
	    	System.out.println("***********************1");
	        return inflate;
	}

	public Activity getMainActivity() {
		return mainActivity;
	}

	public void setMainActivity(Activity mainActivity) {
		this.mainActivity = mainActivity;
	}

	private void loadData() {
		hotBean = new ArrayList<GoodsBean>();
		for (int i = 0; i < 6; i++) {
			GoodsBean bean = new GoodsBean("" + i, "商品名称" + i, "商品名称" + i, "2",
					0, 0);
			hotBean.add(bean);
		}
		homeQuickAdapter = new HomeQuickAdapter(hotBean, getMainActivity());
		if(listView != null&& homeQuickAdapter!=null){
			listView.setAdapter(homeQuickAdapter);
		}
		
	}
}
