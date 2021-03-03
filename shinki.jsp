<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8") ;%>

<html>

  <head>

    <meta charset="utf-8">

    <title>新規登録</title>

    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    
    <meta HTTP-EQUIV = "content-type" CONTENT = "text/html;charset = UTF-8">

  </head>

  <body>


    <form method="POST" action="/prototype/user_insertout.jsp">
      <h1><span>新規登録</span></h1>
      <input placeholder="ユーザーID" type="text" name="user_id" required/>
      <input placeholder="ユーザーパスワード" type="text" name="user_pas" required/>
      <input placeholder="ユーザーネーム" type="text" name="user_name" required/>
      <div class="error-message">※ 入力必須です</div>
      <input type = "submit" value = "送信">
 	  <input type = "reset" value = "入力クリア">
    </form>

		<form>
	    	<button class="btn"><a href="index.jsp">ログインページへ</a></button>
	　　</form>

    <script src="js/common.js" type="text/javascript"></script>


  </body>

</html>