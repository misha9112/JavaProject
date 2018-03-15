package com.inc.project.v2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

public class MemoList implements Serializable{
	
	Vector<String> listStr = new Vector<>();
	HashMap<String, String> memo;
	


	public Vector<String> getListStr() {
		return listStr;
	}

	public void setListStr(Vector<String> listStr) {
		this.listStr = listStr;
	}

	public HashMap<String, String> getMemo() {
		return memo;
	}

	public void setMemo(HashMap<String, String> memo) {
		this.memo = memo;
	}
	
	
	
	

}
