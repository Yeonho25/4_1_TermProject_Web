<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
    
 <%@ include file="/WEB-INF/layout/headerMenu.jsp" %>
	
 <section class="section">
            <div class="category">
                <span>${category}</span>
            </div>
            <div class="product-box">
            	<ul class="product-list">

				<c:forEach var="product" items="${products}">
					<li class="item">
						
						<div class="item-inner"><!-- img도 네임받아서.png 이런식으로 -->
							<a href="/4_1_TermProject_Web/front/product/detail?productName=${product.name}"> 
								<img src="<%=request.getContextPath()%>/image/${product.category}/${product.name}.jpg">	
							</a>
						<div class="item-info">
							<p class="item-name">${product.name}</p>
							<p class="item-price">${product.price }<span> 원</span></p>
						</div>
						</div>
					</li>
				</c:forEach>
				</ul>
            </div>
        </section>
<%@ include file="/WEB-INF/layout/footer.jsp" %>