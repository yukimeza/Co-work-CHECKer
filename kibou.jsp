
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8") ;%>


<html>

  <head>

    <meta charset="utf-8">

    <title>シフト希望提出</title>

　　
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/calendar.css">
    <link rel="stylesheet" href="css/theme.css">
    
  </head>

  <body>

  <h1>シフト予定</h1>


		<form >
			<input type="date" name="kibou">
		</form>

   <div class="container-calendar">
          <h4 id="monthAndYear"></h4>
          <div class="button-container-calendar">
              <button id="previous" onclick="previous()">‹</button>
              <button id="next" onclick="next()">›</button>
          </div>
          
          <table class="table-calendar" id="calendar" data-lang="ja">
              <thead id="thead-month"></thead>
              <tbody id="calendar-body"></tbody>
          </table>
          
          <div class="footer-container-calendar">
              <label for="month">日付指定：</label>
              <select id="month" onchange="jump()">
                  <option value=0>1月</option>
                  <option value=1>2月</option>
                  <option value=2>3月</option>
                  <option value=3>4月</option>
                  <option value=4>5月</option>
                  <option value=5>6月</option>
                  <option value=6>7月</option>
                  <option value=7>8月</option>
                  <option value=8>9月</option>
                  <option value=9>10月</option>
                  <option value=10>11月</option>
                  <option value=11>12月</option>
              </select>
              <select id="year" onchange="jump()"></select>
          </div>
    </div>

    <form>
      <button class="btn"><a href="kibou_ok.jsp">シフト希望提出</a></button>
    </form>


    <form>
      <button class="btn"><a href="my.jsp">TOPページへ</a></button>
    </form>


   <script src="js/common.js" type="text/javascript"></script>
    <script src="js/calendar.js" type="text/javascript"></script>
    <script src="js/demo.js" type="text/javascript"></script>


  </body>

</html>