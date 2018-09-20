package com.downeyjr.entity;

public class Blob {
	private String UNo;
	private String UContent;
	public String getUNo() {
		return UNo;
	}
	public void setUNo(String uNo) {
		UNo = uNo;
	}
	public String getUContent() {
		return UContent;
	}
	public void setUContent(String uContent) {
		UContent = uContent;
	}
	@Override
	public String toString() {
		return "Blob [UNo=" + UNo + ", UContent=" + UContent + "]";
	}
	

}
