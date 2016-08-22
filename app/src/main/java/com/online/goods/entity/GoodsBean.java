package com.online.goods.entity;

public class GoodsBean {

	private String id;//商品id
	private String name;//商品名称
	private String des;//商品描述
	private String price;//商品单价
	private int type;//商品类型
	private int iconId;//资源图片
	
	public GoodsBean(){
		
	}
    public GoodsBean(String id,String name,String des,String price,int type,int iconId){
		this.id = id;
		this.name = name;
		this.des = des;
		this.price = price;
		this.type = type;
		this.iconId = iconId;
    	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIconId() {
		return iconId;
	}

	public void setIconId(int iconId) {
		this.iconId = iconId;
	}
	
}
