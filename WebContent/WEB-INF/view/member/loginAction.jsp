<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.Member"%>
<%@ page import="persistence.MemberRepository"%>
<%@ page import="java.io.PrintWriter"%>

<jsp:useBean id="member" class="domain.Member" scope="page"/>
<jsp:setProperty name="member" property="memberID"/>
<jsp:setProperty name="member" property="memberPassword"/>

<%
	
	/* if(result == true) {
		PrintWriter scipt = response.getWriter();
		scipt.println("<script>");
		scipt.println("location.href= 'main.jsp'");
		scipt.println("</script>");
		
		
	}else if(result == false) {
		PrintWriter scipt = response.getWriter();
		scipt.println("<script>");
		scipt.println("alert('비밀번호가 틀립니다.')");
		scipt.println("history.back()");
		scipt.println("</script>");
	} */
	/*else if(result == -1) {
		PrintWriter scipt = response.getWriter();
		scipt.println("<script>");
		scipt.println("alert('존재하지 않는 아이디입니다.')");
		scipt.println("history.back()");
		scipt.println("</script>");
	}else if(result == -2) {
		PrintWriter scipt = response.getWriter();
		scipt.println("<script>");
		scipt.println("alert('데이터베이스 오류 발생.')");
		scipt.println("history.back()");
		scipt.println("</script>");
	}*/

%>
