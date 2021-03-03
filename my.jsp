<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>

<%
		//文字コードの指定
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");

		//入力データ受信
		String user_idStr = request.getParameter("user_id");
		String user_pasStr = request.getParameter("user_pas");
		String renkinStr = request.getParameter("renkin_num");

		String gazouStr = "";  //ｒｓ２用の引き数の宣言
		String joutaiStr = "";
		
		//	データベースに接続するために使用する変数宣言
		Connection con = null;
		Statement stmt = null;
		StringBuffer SQL = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		//	ローカルのMySQLに接続する設定
		String USER = "root";
		String PASSWORD = "";
		String URL = "jdbc:mysql://localhost/nhs00649db";
		String DRIVER = "com.mysql.jdbc.Driver";

		//確認メッセージ
		StringBuffer ERMSG = null;

		//ヒットフラグ配置
		int hit_flag = 0;

		//HashMap(１件分のデータを格納する連想配列)
		HashMap<String,String> map = null;

		//ArrayList(すべての件数を格納する配列)
		ArrayList<HashMap> list = null;
		list = new ArrayList<HashMap>();	//初期化


		try{		//ロードに失敗したときのための例外処理
					//JDBCドライバのロード
					 Class.forName(DRIVER).newInstance();
					
					//Connectionオブジェクトの作成
					con = DriverManager.getConnection(URL,USER,PASSWORD);

					//Statementオブジェクトの作成
					stmt = con.createStatement();

					//SQLステートメントの作成（選択クエリ）
					SQL = new StringBuffer();
					
					//SQL文の構築（選択クエリ）
					SQL.append("select * from user_tbl where user_id = '");
					SQL.append(user_idStr);
					SQL.append("'");

					System.out.println(SQL.toString());
					
					//SQL文の発行（選択クエリ）
					rs = stmt.executeQuery(SQL.toString());

					//入力したデータがデータベースに存在するか調べる
					if(rs.next()){		//存在する
												//ヒットフラグON
												hit_flag = 1;

						//	検索データをHashMapへ格納する
						map = new HashMap<String,String>();
								map.put("user_no",rs.getString("user_no"));
								map.put("user_id",rs.getString("user_id"));
								map.put("user_pas",rs.getString("user_pas"));
								map.put("user_name",rs.getString("user_name"));

								//１件分のデータ（HashMap）をArrayListへ追加
								list.add(map);

					}else{	//存在しない
												
											//ヒットフラグOFF
												hit_flag = 0;
					}

					if(!(list.get(0).get("user_pas").equals(user_pasStr))){
						hit_flag = 0;
						}
					

					//SQLステートメントの作成（選択クエリ）→初期化
					SQL = new StringBuffer();
					
					//SQL文の構築（選択クエリ）
					SQL.append("select * from renkin_tbl where renkin_num = '");
					SQL.append(renkinStr);
					SQL.append("'");
					System.out.println(SQL.toString());
					
					//SQL文の発行（選択クエリ）
					rs2 = stmt.executeQuery(SQL.toString());
					
					if(rs2.next()){
						gazouStr = rs2.getString("gazou_id");
						joutaiStr = rs2.getString("joutai");
						}

					
			}				//tryブロック終了

		catch(ClassNotFoundException e){
					ERMSG = new StringBuffer();
					ERMSG.append(e.getMessage());
		}

		catch(SQLException e){
					ERMSG = new StringBuffer();
					ERMSG.append(e.getMessage());
		}

		catch(Exception e){
					ERMSG = new StringBuffer();
					ERMSG.append(e.getMessage());
		}

		finally{
					//	各種オブジェクトクローズ
		try{
					if(rs != null){
							rs.close();
					}
					if(stmt != null){
							stmt.close();
					}
					if(con != null){
							con.close();
					}
			}

					catch(SQLException e){
					ERMSG = new StringBuffer();
					ERMSG.append(e.getMessage());
					}	

		}
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8") ;%>

<html>

  <head>

    <meta charset="utf-8">

    <title>Myページ</title>


    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/calendar.css">
    <link rel="stylesheet" href="css/theme.css">


  </head>

  <body>


<% 
			if(hit_flag == 1){		//認証OK
	%>
	
 	<h1>Myページ</h1>


    <h1><%= list.get(0).get("user_name") %>さんの連勤度</h1>
    <img src="images/<%= list.get(0).get("gazou_id")  %>" alt="choshi">
    <h3><%= joutaiStr %></h3>

    <form method="post" action="/prototype/syukkin.jsp">
 	  <input type = "hidden" name = "user_id" value = "<%= list.get(0).get("user_id") %>">
 	  <input type = "submit" value = "出退勤登録">
    </form>
    
  <form method="post" action="/prototype/kibou2.jsp">
 	  <input type = "hidden" name = "user_id" value = "<%= list.get(0).get("user_id") %>">
 	  <input type = "submit" value = "シフト希望">
    </form>

  
   <h1>今週の予定</h1>

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

    <div id="caleandar"></div>

 
		 <h1>連勤度表</h1>
		  
		  <div class="wrappercan">
		  <canvas id="myLineChart"></canvas>
		    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
		
		  <script>
		  var ctx = document.getElementById("myLineChart");
		  var myLineChart = new Chart(ctx, {
		    type: 'line',
		    data: {
		      labels: ['3月1日', '3月2日', '3月3日', '3月4日', '3月5日', '3月6日', '3月7日'],
		      datasets: [
		        {
		          label: '残業判定ライン（時）',
		          data: [8, 8, 8, 8, 8, 8, 8, 8],
		          borderColor: "rgba(255,0,0,1)",
		          backgroundColor: "rgba(0,0,0,0)"
		        },
		        {
		          label: '勤務時間（時）',
		          data: [4, 6, 0, 3, 7, 9, 0, 6],
		          borderColor: "rgba(0,0,255,1)",
		          backgroundColor: "rgba(0,0,0,0)"
		        }
		      ],
		    },
		    options: {
		      title: {
		        display: true,
		        text: '勤務時間（3月1日~月7日）'
		      },
		      scales: {
		        yAxes: [{
		          ticks: {
		            suggestedMax: 10,
		            suggestedMin: 0,
		            stepSize: 10,
		            callback: function(value, index, values){
		              return  value +  '時間'
		            }
		          }
		        }]
		      },
		    }
		  });
		  </script>
		</div>

    <form method="post" action="/prototype/idpass.jsp">
    
 	  <input type = "hidden" name = "user_id" value = "<%= list.get(0).get("user_id") %>">
 	  <input type = "hidden" name = "user_pas" value = "<%= list.get(0).get("user_id") %>">
 	  <input type = "hidden" name = "user_name" value = "<%= list.get(0).get("user_id") %>">
 	  <input type = "submit" value = "パスワード変更">	
    	
    </form>
    
    <form method="post" action="/prototype/index.jsp">
 	  <input type = "submit" value = "ログアウト">
    </form>
	
    <script src="js/common.js" type="text/javascript"></script>
    <script src="js/calendar.js" type="text/javascript"></script>
    <script src="js/demo.js" type="text/javascript"></script>
    
<%
		}else{		//認証NG
%>

		<h2>パスワードが間違っています。</h2>
		<form>
	    	<button class="btn"><a href="index.jsp">ログインページへ</a></button>
	　　</form>
			
<% } %>

 	<% if(ERMSG != null){ %>
 	予期せぬエラーが発生しました<br />
 	<%= ERMSG %>
 	<% }else{ %>
 	※エラーは発生しませんでした<br/>
 	<% } %>
 	
  </body>

</html>