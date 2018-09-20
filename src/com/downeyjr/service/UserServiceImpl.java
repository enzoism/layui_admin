package com.downeyjr.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.downeyjr.dao.UserDao;
import com.downeyjr.entity.Blob;
import com.downeyjr.entity.CTest;
import com.downeyjr.entity.User;
import com.downeyjr.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
	private UserDao userDao;

   /**
    * 登陆验证
    * @param
    */
	public User checkLogin(String username, String password) {
		
		User user=userDao.findUserByName(username);
		System.out.println("-------------------dao:"+user);
		if(user!=null&&user.getPassword().equals(password)){
			return user;
		}
		return null;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class},timeout=30,isolation=Isolation.DEFAULT)  
	public int insertMultiUserFail(List<User> userList)throws Exception  {
		int num = -1;
		int insertNum = userDao.insertMultiUser(userList);
		if (insertNum == userList.size()) {
			num = -1;//模拟数据库失败
			throw new Exception();
		}
		return num;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class},timeout=30,isolation=Isolation.DEFAULT)  
	public int insertMultiUserSuccess(List<User> userList)throws Exception   {
		int num = -1;
			int insertNum = userDao.insertMultiUser(userList);
			if (insertNum == userList.size()) {
				num = insertNum;//模拟数据库成功
			}
		return num;
	}
	
	public List<CTest> getCTESTData(Map<String, Object> param){
		List<CTest> list = userDao.getCTESTData(param);
		return list;
	}
	
	public List<CTest> getCTESTData2(List<String> param){
		List<CTest> list = userDao.getCTESTData2(param);
		return list;
	}


	@Override
	public int insertIntoBlob(Blob blob) throws Exception {
		int num = userDao.insertIntoBlob(blob);
		return num;
	}

}
