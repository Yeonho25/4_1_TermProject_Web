<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/layout/headerMenu.jsp" %>

	<form action="../history/history" method="post">
		
			<input type="hidden" name="id" value="${review.history_id }">
			<table id="review-form" width="700" border="3" bordercolor="lightgray" align="center">
				<tr>
					<td>후기 내용</td>
					<td><textarea name="content" rows="6" cols="30"></textarea></td>
				</tr>
				<tr>
					<td>평점</td>
					<td><input type="text" name="rating" /></td>
				</tr>
				<tr>
					<td colspan="2"> <input type="submit" value="등록" ></td>
				</tr>
			</table>
		
	</form>

	<%@ include file="/WEB-INF/layout/footer.jsp" %>