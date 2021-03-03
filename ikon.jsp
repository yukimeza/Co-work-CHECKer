
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8") ;%>

<html>

  <head>

    <meta charset="utf-8">

    <title>アイコン設定</title>


    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">


  </head>

  <body>

    <form id="ikon">
      <h3>アカウント名を変更する</h3>
      <p>現在のアカウント名を入力してください</p>
      <input type="name" placeholder="現在のアカウント名">
      <p>新規アカウント名を入力してください</p>
      <input type="name" placeholder="新規アカウント名">
      <button class="btn"><a href="settei_ok.jsp">このアイコン名にする</a></button>

    </form>



    <form id="ikon">
      <h3>アカウント画像を変更する</h3>
      <input type="file" accept='image/*' onchange="previewImage(this);">
      <h4>プレビュー:</h4>
      <img id="preview" src="data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==" style="max-width:200px;">
      <button class="btn"><a href="settei_ok.jsp">この画像をアイコンにする</a></button>
    </form>


    <script src="js/common.js" type="text/javascript"></script>
    <script src="js/gazo.js" type="text/javascript"></script>


  </body>

</html>