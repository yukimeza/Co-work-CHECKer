
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>



<%
		//文字コードの指定
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");

		//入力データ受信
		String user_idStr = request.getParameter("user_id");
		String coStr = "";
		

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
		HashMap<String,String> map2 = null;

		//ArrayList(すべての件数を格納する配列)
		ArrayList<HashMap> list = null;
		list = new ArrayList<HashMap>();	//初期化
		
		//ArrayList(すべての件数を格納する配列)
		ArrayList<HashMap> list2 = null;
		list2 = new ArrayList<HashMap>();	//初期化


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
					
					
					
					//SQLステートメントの作成（選択クエリ）→初期化
					SQL = new StringBuffer();
					
					//SQL文の構築（選択クエリ）
					SQL.append("select count(hajime) AS syukkin from kintai_tbl where part_id = '");
					SQL.append(user_idStr);
					SQL.append("'AND hinichi >= current_date - 7");
					System.out.println(SQL.toString());
					
					//SQL文の発行（選択クエリ）
					rs2 = stmt.executeQuery(SQL.toString());

					//入力したデータがデータベースに存在するか調べる
					if(rs2.next()){  	//存在する
												//ヒットフラグON
												hit_flag = 1;
												//	検索データをHashMapへ格納する
						
						map2 = new HashMap<String,String>();
						map2.put("syukkin",rs2.getString("syukkin"));
						
								//１件分のデータ（HashMap）をArrayListへ追加
								list2.add(map2);
								
					}else{
						
									//ヒットフラグOFF
									hit_flag = 0;
						
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

    <title>Co-Warking CHECKER</title>


    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">


  </head>

  <body>

<%  if(user_idStr.matches(".*Z.*")){
 %>
　　<form method="post" action="/prototype/top.jsp">
    
      <h1>管理担当者ページ</h1>
      <h1><%= list.get(0).get("user_name") %>様</h1>
      
 	  <input type = "hidden" name = "user_id" value = "<%= list.get(0).get("user_id") %>">
      <input type="text" name="user_pas" placeholder="パスワードを入力してください" required/>
 	  <input type = "submit" value = "認証">
 	  <input type = "reset" value = "入力クリア">
        
   　</form>
   
<% }else{ %>
     
     <form method="post" action="/prototype/my.jsp">
    
      <h1><%= list.get(0).get("user_name") %>様</h1>
      
 	  <input type = "hidden" name = "user_id" value = "<%= list.get(0).get("user_id") %>">
 	  <input type = "hidden" name = "renkin_num" value = "<%= list2.get(0).get("syukkin") %>">
      <input type="text" name="user_pas" placeholder="パスワードを入力してください" required/>
 	  <input type = "submit" value = "認証">
 	  <input type = "reset" value = "入力クリア">
        
    </form>
    
<% } %>

    <script src="js/common.js" type="text/javascript"></script>

  </body>

	<footer>
	  <h5>Right click and visit: <a target="_blank" href="reset.jsp">パスワードを忘れましたか？</a></h5>
	  <h5>▲<a target="_blank" href="error.jsp">エラーページ</a></h5>
	</footer>

</html>