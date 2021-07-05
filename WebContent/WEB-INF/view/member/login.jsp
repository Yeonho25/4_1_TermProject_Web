<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/layout/headerMenu.jsp" %>

	<form method="post" action="login">
		<h3 style="text-align">로그인 화면</h3>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디" name="memberID">
		</div>
		<div>
			<input type="password" class="form-control" placeholder="비밀번호" name="memberPassword">
		</div>
		<input type="submit" class="submitBtn" value="로그인">
	</form>


<%@ include file="/WEB-INF/layout/footer.jsp" %>