<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8") ;%>

<html>

  <head>

    <meta charset="utf-8">

    <title>管理者専用新規登録</title>

    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    
    <meta HTTP-EQUIV = "content-type" CONTENT = "text/html;charset = UTF-8">

  </head>

  <body>


    <form method="POST" action="/prototype/mas_shinki2.jsp">
    <h2>パスワード入力</h2>
     <input type="text" name="kanri_id" placeholder="管理者登録PASSを入力して下さい" required/>
 	  <input type = "submit" value = "認証">
    </form>

		<form>
	    	<button class="btn"><a href="index.jsp">ログインページへ</a></button>
	　　</form>

    <script src="js/common.js" type="text/javascript"></script>


  </body>

</html>