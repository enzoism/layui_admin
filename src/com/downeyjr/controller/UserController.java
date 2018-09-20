package com.downeyjr.controller;

import java.io.File;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.downeyjr.service.UserService;



@Controller
@Scope(value="prototype")
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;	
	
	@RequestMapping(value="/testAjax",method=RequestMethod.POST)
	public String  testAjax(HttpServletRequest request, @RequestParam(value = "file", required = true) MultipartFile  excelFile) throws Exception {
		System.out.println("-------------------------request:"+request);
		System.out.println("-------------------------excelFile:"+excelFile);
		if (null != excelFile) {
			System.out.println(excelFile.getContentType());
			System.out.println(excelFile.getName());
			System.out.println(excelFile.getOriginalFilename());
			System.out.println(excelFile.getSize());
			System.out.println(excelFile.getInputStream());
			InputStream inputStream = excelFile.getInputStream();
			FileUtils.copyInputStreamToFile(inputStream, new File("D:/ZmjemaWorkspace/upload/111.jpg"));
			
		}else{
			System.out.println("excelFile为空");
		}


		
		System.out.println();
		return "success";
	}

}
