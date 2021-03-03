<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8") ;%>
<html>

  <head>

    <meta charset="utf-8">

    <title>ID/PASS再設定</title>


    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">


  </head>

  <body>


    <form>
      <h1><span>再発行</span></h1>
      <input placeholder="Username" type="text" required/>
      <input placeholder="Password" type="password" required/>
      <div class="error-message">※ 入力必須です</div>
      <button class="btn"><a href="user_insertout.jsp">これで登録する</a></button>
    </form>


    <script src="js/common.js" type="text/javascript"></script>


  </body>

</html>