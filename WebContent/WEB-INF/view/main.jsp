<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 <%@ include file="/WEB-INF/layout/headerMenu.jsp" %>
	<section class="section">
            <article class="article1">
            	<div class="slideshow-container">
                    <div class="mySlides fade">
                        <div class="numbertext">1 / 3</div>
                        <img src="<%=request.getContextPath()%>/image/1.jpg" style="width:100%">
                      
                    </div>
                    
                    <div class="mySlides fade">
                        <div class="numbertext">2 / 3</div>
                        <img src="<%=request.getContextPath()%>/image/2.jpg" style="width:100%">
                     
                    </div>
                    
                    <div class="mySlides fade">
                        <div class="numbertext">3 / 3</div>
                        <img src="<%=request.getContextPath()%>/image/3.jpg" style="width:100%">
                        
                    </div>
                    
                    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlides(1)">&#10095;</a>
        
                    <div style="text-align:center">
                        <span class="dot" onclick="currentSlide(1)"></span> 
                        <span class="dot" onclick="currentSlide(2)"></span> 
                        <span class="dot" onclick="currentSlide(3)"></span> 
                    </div>
                </div>
            </article>
           <article class="article2">
                <ul class="reco-box">
                    <li class="reco-item">
                        <img src="<%=request.getContextPath()%>/image/reco1.jpg" alt="카바나셔츠">
                        <div class="reco-info">
                            <p class="reco-name">카나바 셔츠,ALOHA !</p>
                            <p class="reco-address">형형색색의 화려한 컬러와 패턴</p>
                        </div>
                    </li>
                    <li class="reco-item">
                        <img src="<%=request.getContextPath()%>/image/reco2.jpg" alt="린넨">
                        <div class="reco-info">
                            <p class="reco-name">SUMMER LINEN</p>
                            <p class="reco-address">이 계절에만 누릴 수 있는 특권!</p>
                        </div>

                    </li>
                </ul>
            </article>
    </section>
 <%@ include file="/WEB-INF/layout/footer.jsp" %>