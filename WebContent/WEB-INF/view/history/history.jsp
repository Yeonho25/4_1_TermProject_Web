<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
    
 <%@ include file="/WEB-INF/layout/headerMenu.jsp" %>
	<table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>번호</td>
				<td>상품 이름</td>								
				<td>수량</td>
				<td>가격</td>
				<td>총금액</td>
				<td>구매일</td>
				<td>후기 등록</td>
			</tr>
		</thead>		
	
		<c:forEach var="history" items="${history}">
			<tr>
				<td>${history.id}</td>
				<td>${history.product_name}</td>								
				<td>${history.quantity}</td>
				<td>${history.price}</td>		
				<td>${history.price * history.quantity}</td>
				<td>${history.buydate}</td>
				<td>
				
				<c:if test="${history.reviewed == 1}">
				    후기 등록 완료!
				</c:if>
				<c:if test="${history.reviewed == 0}">
				 <button><a href="/4_1_TermProject_Web/front/review/review?id=${history.id}">후기등록</a></button>  
				   <!--<input  type="submit" value="후기 	등록" onclick="location.href='review/review?id=${history.id}'">    --> 
				</c:if>
				</td>
			</tr>
		</c:forEach>
						
	</table>
		
	<jsp:include page="../paging.jsp">
	    <jsp:param value="${paging.page}" name="page"/>
	    <jsp:param value="${paging.beginPage}" name="beginPage"/>
	    <jsp:param value="${paging.endPage}" name="endPage"/>
	    <jsp:param value="${paging.prev}" name="prev"/>
	    <jsp:param value="${paging.next}" name="next"/>
	</jsp:include>
<%@ include file="/WEB-INF/layout/footer.jsp" %>