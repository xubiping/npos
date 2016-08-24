package com.online.goods.api;

import org.json.JSONObject;

public class OutPut {
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Object getOutput() {
		return output;
	}
	public void setOutput(Object output) {
		this.output = output;
	}
	private int code=-1000;
	private String tip="NONE";
	private Object output=new Object();

	public void format(String val){
		try {
			if (!val.isEmpty()) {
				JSONObject json = new JSONObject(val);
				int code = json.getInt("code");
				String tip = json.getString("tip");
				Object oput = json.get("output");
				JSONObject json_temp = null;
				if (oput != null) {
					json_temp = (JSONObject) (oput);
				}
				this.setOutput(json_temp);
				this.setCode(code);
				this.setTip(tip);
			}
		} catch(Exception e){
			e.getStackTrace();
		}
	}
}
