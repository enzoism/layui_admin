package com.downeyjr.service;

import java.util.List;
import java.util.Map;

import com.downeyjr.entity.Blob;
import com.downeyjr.entity.CTest;
import com.downeyjr.entity.User;

public interface UserService {

	public User checkLogin(String username, String password);

	public int insertMultiUserFail(List<User> userList) throws Exception;

	public int insertMultiUserSuccess(List<User> userList) throws Exception;
	
	public List<CTest> getCTESTData(Map<String, Object> param)throws Exception;

	public List<CTest> getCTESTData2(List<String> param)throws Exception;

	public int insertIntoBlob(Blob blob)throws Exception;

}
