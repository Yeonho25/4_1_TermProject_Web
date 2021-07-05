<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
    <title>쇼핑몰 웹사이트 연습</title>
    
   
    <style>
    	@charset "utf-8";
html,
body,
section,
nav,
ul,
li,
dl,
dt,
dd,
p,
span,
a {
  font-family: "나눔 고딕", NanumGothic, "돋움", Dotum, sans-serif;
  margin: 0;
  padding: 0;
  border: 0;
  list-style: none;
  text-decoration: none;
  color: #000;
}

* {
  color: white;
}
.wrap {
  max-width: 1280px;
  margin: 0 auto;
}
.header {
  display: flex;
  justify-content: center;
  height: 200px;
  max-width: 1280px;
  margin: 0 auto;
}
.header .logo {
  padding: 25px 0;
  display: flex;
  align-items: center;
}
.header img {
  width: 200px;
  height: 200px;
}
.navbar {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px 20px;
  background: #263343;
}
.navbar .inner-nav {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 100%;
}
.navbar .inner-nav .nav-menu {
  display: flex;
  flex-direction: row;
}
.navbar .inner-nav .nav-menu li {
  padding: 8px 20px;
}
.navbar .inner-nav .nav-menu a {
  color: white;
  display: block;
}
.navbar .inner-nav .nav-menu li:hover {
  font-weight: bold;
  background: #d49466;
  border-radius: 5px;
}
.navbar-toggleBtn {
  display: none;
}
.navbar-toggleBtn img {
  width: 40px;
  height: 40px;
  margin-top: 70px;
  margin-left: 150px;
}
.section {
  min-height: 500px;
  background: rgb(216, 226, 238);
}
.section article {
  float: left;
  width: 50%;
  min-height: 500px;
}
.section article1 {
	display: flex;
	align-items: center;
}
.section .article2 {
  background: rgb(97, 165, 165);
}

section article {
  font-size: 30px;
}
/* article 2 */
.reco-box {
 display: flex;
 align-items: center;
 min-height: 500px;
 justify-content: space-around;
}
.reco-item img {
  width: 200px;
}
.reco-item .reco-name {
  font-size: 0.9em;
  white-space: wrap;
}
.reco-item .reco-address {
  font-size: 0.5em;
}
/* 푸터 */
.footer {
  min-width: 1280px;
  height: 100px;
  border-top: 1px solid;
  border-color: #d1d1d1;
  text-align: center;
}
.footer .address {
  margin-top: 30px;
  font-size: 12px;
  font-style: normal;
  color: #999;
}
.footer .copyright {
  margin-top: 10px;
  font-size: 12px;
  margin-bottom: 30px;
}

/* 상품화면 css */
.category {
  padding-top: 30px;
  padding-left: 70px;
}
.category span {
  font-weight: bold;
  font-size: 1.5em;
}
.product-box {
  padding: 70px;
}
.product-list {
  overflow: hidden;
}
.product-list .item {
  float: left;
  width: 25%;
  text-align: center;
  font-size: 1.5em;
}
.item-inner img {
  width: 150px;
  height: 170px;
}
.item-inner .item-info {
  margin-bottom: 2em;
}
/* 로그인 */
form .form-control{
  color: black;
}
.form-group input,
.submitBtn
 {
	color: black;
}
.memberID {
  margin-top: 80px;
  margin-left: 100px;
}
#id {
	font-weight: bold;
}
#okid {
	display: none;
}


/* 상세화면 */
table{
	margin-top : 30px;
}
table td {
  color: black;
}
table td input {
  color: black;
}
tr td img {
  width: 150px;
  width: 150px;
}
/* 구매내역 */
h1{
color: black;
}
#paging{
color: black;
}
/* 리뷰 */
#review-form td textarea,
 #review-form td input{
	color : black;
}
/* slideshow */
.slideshow-container {
  max-width: 500px;
  position: relative;
  margin: 30px;
}
.prev,
.next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -22px;
  color: black;
  font-weight: bold;
  font-size: 40px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}
.prev:hover,
.next:hover {
  background-color: rgba(75, 233, 245, 0.8);
}
.numbertext {
  color: black;
  font-size: 20px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
  background-color: rgb(241, 241, 241);
  opacity: 0.5;
}
.text {
  color: black;
  font-size: 25px;
  padding: 8px 12px;
  position: absolute;
  bottom: 18px;
  width: 100%;
  text-align: center;
}
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}
.active,
.dot:hover {
  background-color: #717171;
}
.mySlides img {
	min-height : 300px;
}


@media (max-width: 768px) {
  .section article {
    width: 100%;
    height: 50%;
  }
  .navbar-toggleBtn {
    display: block;
  }
  .navbar {
    padding: 8px 24px;
    display: none;
  }
  .navbar .inner-nav {
    flex-direction: column;
  }
  .navbar .inner-nav .menu1 {
    flex-direction: column;
    align-items: center;
    margin-bottom: 20px;
  }
  .navbar .inner-nav .menu2 {
    font-size: 0.9em;
  }
  .navbar .inner-nav .nav-menu li {
    width: 100%;
    text-align: center;
  }
  .navbar.active {
    display: block;
  }
  .product-list .item {
    width: 50%;
  }
}

    	
    </style>
</head>

<body>
    <header class="header">
        <div class="logo">
            <a href="/4_1_TermProject_Web/front/"><img src="<%=request.getContextPath()%>/image/logo.png" alt="logoImage"></a>
        </div>
        <a href="#" class="navbar-toggleBtn">
            <img src="<%=request.getContextPath()%>/image/hamburger.png" alt="triggerImage">
        </a>
        <div class="memberID">
        	<span id="id">${sessionScope.memberID}</span>
        </div>
        
    </header>
    <main class="wrap">
        <nav class="navbar">
            <div class="inner-nav">
                <ul class="nav-menu menu1">
                    <li><a href="/4_1_TermProject_Web/front/product/list?category=outer">OUTER</a></li>
                    <li><a href="/4_1_TermProject_Web/front/product/list?category=top">TOP</a></li>
                    <li><a href="/4_1_TermProject_Web/front/product/list?category=denim">DENIM</a></li>
                    <li><a href="/4_1_TermProject_Web/front/product/list?category=bottom">BOTTOM</a></li>
                </ul>
                <ul class="nav-menu menu2">
                	 
                	         
                	<%
                	 session = request.getSession();
                		
                
                	if(session.getAttribute("memeberID") == null) {
                		
                	%>
      				
                	<li><a href="/4_1_TermProject_Web/front/member/login">로그인</a></li>
                    <li><a href="#">회원가입</a></li>
                    <li><a href="../front/view/basket/basket.jsp">장바구니</a></li>
                    <li><a href="/4_1_TermProject_Web/front/history/history">구매내역</a></li>
              
                	<%
                		} else {
                	%>
                	<li><a href="/4_1_TermProject_Web/front/member/login">로그아웃</a></li>
                    <li><a href="/4_1_TermProject_Web/controller/MainController">장바구니</a></li>
                    <li><a href="/4_1_TermProject_Web/front/history/history">구매내역</a></li>
                	<%
                		}
                	%>
                    
                </ul>
            </div>
        </nav>