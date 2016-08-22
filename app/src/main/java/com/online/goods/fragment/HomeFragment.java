package com.online.goods.fragment;

import java.util.ArrayList;
import java.util.List;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.online.goods.R;
import com.online.goods.adapter.HomeHotAdapter;
import com.online.goods.entity.GoodsBean;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HomeFragment extends Fragment {

	@ViewInject(R.id.fg_home_hot)
	ListView hotListView;
	private Activity mainActivity;
	private HomeHotAdapter hotAdapter;
	private List<GoodsBean> hotBean;

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
	
		 View inflate = inflater.inflate(R.layout.fg_home, container, false);
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
		hotBean = new ArrayList<GoodsBean>();
		for (int i = 0; i < 6; i++) {
			GoodsBean bean = new GoodsBean("" + i, "商品名称" + i, "商品名称" + i, "2",
					0, 0);
			hotBean.add(bean);
		}
		hotAdapter = new HomeHotAdapter(hotBean, getMainActivity());
		if(hotListView != null&& hotAdapter!=null){
			hotListView.setAdapter(hotAdapter);
		}
		
	}
	
	
}
