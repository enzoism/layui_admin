package com.downeyjr.entity;

public class CTest {
	private String CID;
	private String CName;
	private String CFLAG;

	
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getCFLAG() {
		return CFLAG;
	}
	public void setCFLAG(String cFLAG) {
		CFLAG = cFLAG;
	}
	@Override
	public String toString() {
		return "CTest [CID=" + CID + ", CName=" + CName + ", CFLAG=" + CFLAG + "]";
	}

	
}
