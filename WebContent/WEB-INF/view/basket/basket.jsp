<%@ page import="java.util.*"%>
<%@ page import="domain.Basket"%>
<%@ page import="persistence.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ٱ���</title>

<style>
.border {
   border: 1px solid black;
}
</style>
</head>
<body>
   <%
   String id = (String) session.getAttribute("id");
   %>
   <br></br>
   <h1 style="text-align: center">��ٱ���</h1>
   <table style="display: flex; justify-content: center">
      <tr>
         <td>
            <form action="../../MainController" method="post">

               <input type="submit" name="add" value="�׽�Ʈ�� ������ �߰�"> <input
                  type="hidden" name="userId" value=<%=id%>>

            </form>
         </td>
      </tr>

      <tr>
         <th>�̹���</th>
         <th>��ǰ��</th>
         <th>����</th>
         <th>����</th>
      </tr>

      <%
      BasketRepository basket=new BasketRepository();
     ArrayList<Basket> aList = basket.serachData(id);
      Iterator<Basket> iterator = aList.iterator();
      int totalPrice = 0;

      while (iterator.hasNext()) {
         Basket dto = iterator.next();
         int quantity = dto.getQuantity();
         String pName = dto.getProductName();
         int price = dto.getPrice();
         out.println("<td>" + "<img src=\"view/img/logo.jpg\" width=\"100px\" height=\"100px\"" + "  </td>");
         out.println("<td>" + pName + "  </td>");
         out.println("<td>" + quantity + "</td>");
         out.println("<td>" + price + "</td>");
         totalPrice += price;
         out.println("<td>" +

         "<form action=\"../../MainController\" method=\"post\" accept-charset=\"utf-8\">" +

         "<input type=\"submit\" name=\"button\"" + " value=����>" +

         "<input type=\"hidden\" name=\"id\" value=\"" + id + "\">" +

         "<input type=\"hidden\" name=\"pName\" value=\"" + pName + "\">" +

         "</form>" +

         "<tr>");
      }
      %>

      <td style="display: flex; justify-content: center;">
         <form action="../../MainController" method="post">


            <input type="submit" name="calculation" value="���"> <input
               type="hidden" name="id" value=<%=id%>> <input type="hidden"
               name="price" value="<%=totalPrice%>">
         </form>
      </td>
   </table>
</body>
</html>