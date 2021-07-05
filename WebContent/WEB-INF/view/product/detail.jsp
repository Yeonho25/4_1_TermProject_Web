<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

 <%@ include file="/WEB-INF/layout/headerMenu.jsp" %>
	<!-- header -->
	
	<!-- body -->
	<!-- <div class="content">
		<div class="imageArea">
			<img src = "\test.png"/>
		</div>
		
		<div class="orderArea">
			
		</div>		
	</div> -->
	<form action="detail" method="POST" >
	<table width="500" border="3" bordercolor="lightgray" align="center">
		<c:forEach var="detail" items="${detail}">
			<input type="hidden" name="price" value="${detail.price }">	
			<input type="hidden" name="product_name" value="${detail.name }">
			<tr>
				<td rowspan=4>
					<img src="<%=request.getContextPath()%>/image/${detail.category}/${detail.name}.jpg"/>
				</td>
			</tr>
			<tr>
				<td width="80">상품이름</td>
				<td>${detail.name }</td>
			</tr>
			<tr>
				<td width="80">가격</td>
				<td>${detail.price }</td>
			</tr>
		</c:forEach>
			
			<tr>
				<td width="80">수량</td>
				<td><input type="text" name="quantity" /> 개</td>
			</tr>
			<tr>
				<td colspan="3" height="50">
					
						<input align="center" type="submit" value="장바구니에 담기" />
						<!-- <input type="button" value="구매" onclick="location.href='insert'"> -->
					<!-- <input type="button" value="장바구니로 이동" onclick="location.href ='basket'"> -->
				</td>
			</tr>	
		
	</table>
	</form>	
	<br>
	<br>
	
	<table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>상품명</td>								
				<td>내용</td>
				<td>평점</td>
				<td>등록일</td>
			</tr>
		</thead>		
		<c:forEach var="review" items="${review}">
			<tr>
				<td width="120">${review.product }</td>								
				<td>${review.content}</td>
				<td width="50">${review.rating}</td>
				<td width="100">${review.regdate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/layout/footer.jsp" %>
