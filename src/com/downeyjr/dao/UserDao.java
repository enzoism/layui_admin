package com.downeyjr.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.downeyjr.entity.Blob;
import com.downeyjr.entity.CTest;
import com.downeyjr.entity.User;
import com.downeyjr.mapper.UserMapper;

@Repository("userDao")
public class UserDao extends IBaseDao {

	@Resource(name = "userMapper")
	private UserMapper userMapper;

	public User findUserByName(String username) {

		return userMapper.getUserByName(username);
	}

	public int insertMultiUser(List<User> userList) {
		return userMapper.insertMultiUser(userList);

	}
	
	public List<CTest> getCTESTData(Map<String, Object> param){
		return userMapper.getCTESTData(param);
	}
	
	public List<CTest> getCTESTData2(List<String> param){
		return userMapper.getCTESTData2(param);

	}
	
	public int insertIntoBlob(Blob blob){
		return userMapper.insertIntoBlob(blob);
	}
}
