<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
	
	function submitOnBtn() {
		var objList = new Array();
		var obj = {
			id : 1
		};
		$.ajax({
				type : "POST",
				url : "http://localhost:8080/couponmng_selectCouponCustomerType.action",
				data : {
					username:"tony",
					password:"123456"
				},
				success : function(data) {
					alert("Wow,Fantastic Boby!!!");
				}
			});
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<input type="button" onclick="submitOnBtn();" value="1.直接点击就可以测试用户登录" /><br/>
	<a href="user/insertMultiUserSuccess.do">2.点击的时候进行数据的批量插入(模拟成功)</a><br/>
	<a href="user/insertMultiUserFail.do">3.点击的时候进行数据的批量插入(模拟失败)</a><br/>
	<a href="user/testAjax.do">3.测试Ajax请求成功与否</a><br/>
	<a href="user/getCTESTData.do">4.测试数组的数据测试</a><br/>
	<a href="user/getCTESTData2.do">5.测试数组的数据测试2</a><br/>
	<a href="user/insertIntoBlob.do?UContent='beijing'">6.测试数据库插入数据</a><br/>
	
</body>
