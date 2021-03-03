
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8") ;%>

<html>

  <head>
	
		<meta HTTP-EQUIV = "content-type" CONTENT = "text/html;charset = UTF-8">

    <title>出退勤</title>


    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">


  </head>

  <body>

    <form method="post" action="/prototype/index2.jsp">
      <h1>出退勤</h1>
    	<button class="btn"><a href="syukkin_ok.jsp">出勤</a></button>
    	<button class="btn"><a href="syukkin_ok.jsp">退勤</a></button>
    </form>


    <script src="js/common.js" type="text/javascript"></script>

  </body>

</html>