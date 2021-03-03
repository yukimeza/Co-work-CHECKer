
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8") ;%>

<html>

  <head>
	
		<meta HTTP-EQUIV = "content-type" CONTENT = "text/html;charset = UTF-8">

    <title>Co-Warking CHECKER</title>


    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">


  </head>

  <body>

    <form method="post" action="/prototype/index2.jsp">
    
      <h1><img id="home" alt="home" src="images/home.jpg"></h1><br><br><br>
     
      <input type="text" name="user_id" placeholder="ユーザーID" required/>
 	  <input type = "submit" value = "認証">
 	  <input type = "reset" value = "入力クリア">
 	  
    </form> 
    

    <script src="js/common.js" type="text/javascript"></script>

  </body>

	<footer>
	  <h2><a target="_blank" href="shinki.jsp">新規登録</a></h2>
	</footer>


</html>