<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8") ;%>


<html>

  <head>

    <meta charset="utf-8">

    <title>エラーページ</title>


    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">


  </head>

  <body>

    <form>
      <h1>ERROR</h1>
      <input placeholder="○○○○○○" type="text" required/>
      <span id="red">入力が間違っています</span>
      <input placeholder="●●●●●●" type="password" required/>
      <span id="red">入力が間違っています</span>
      <div class="error-message"> ※ 入力必須です</div>
      <button class="btn"><a href="top.html">ログイン</a></button>
    </form>


    <script src="js/common.js" type="text/javascript"></script>

  </body>

<footer>
  <h2><a target="_blank" href="shinki.html">新規登録</a></h2>
  <h5>Right click and visit: <a target="_blank" href="reset.html">パスワードを忘れましたか?</a></h5>
  <h5>▲<a target="_blank" href="index.html">戻る</a></h5>
</footer>


</html>