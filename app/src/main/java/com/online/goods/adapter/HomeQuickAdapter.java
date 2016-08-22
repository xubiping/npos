package com.online.goods.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.online.goods.R;
import com.online.goods.entity.GoodsBean;

import java.util.ArrayList;
import java.util.List;

public class HomeQuickAdapter extends BaseAdapter {
    private List<GoodsBean> hotBean;
    private Context context;
    private int STATE = 1;
    private LayoutInflater layoutInflater;

    public HomeQuickAdapter(List<GoodsBean> hotBean, Context context) {
        this.hotBean = hotBean;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return hotBean.size();
    }

    @Override
    public Object getItem(int position) {
        return hotBean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_home_buy, null);
            viewHolder = new ViewHolder();

            viewHolder.tvName = (TextView) convertView.findViewById(R.id.textview_goodsname);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageview_act);
            viewHolder.tvPrice = (TextView) convertView.findViewById(R.id.textview_price);
            viewHolder.tvNum = (TextView) convertView.findViewById(R.id.textview_num);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GoodsBean hot = (GoodsBean) getItem(position);
        viewHolder.tvName.setText(hot.getName());

       // viewHolder.tvPrice.setText(hot.getPrice());
        viewHolder.tvNum.setText("2");


        return convertView;
    }

    protected class ViewHolder {


        private ImageView imageView;
        private TextView tvNum;
        private TextView tvPrice;
        private TextView tvName;

    }
}
