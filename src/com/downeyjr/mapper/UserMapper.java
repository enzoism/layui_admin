package com.downeyjr.mapper;

import java.util.List;
import java.util.Map;

import com.downeyjr.entity.Blob;
import com.downeyjr.entity.CTest;
import com.downeyjr.entity.User;

public interface UserMapper {
	
	public User getUserByName(String username);
	public int insertMultiUser(List<User> userList);
	public List<CTest> getCTESTData(Map<String, Object> param);
	public List<CTest> getCTESTData2(List<String> param);
	public int insertIntoBlob(Blob blob);

}
