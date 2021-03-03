<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>

<%
		//文字コードの指定
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");

		//	データベースに接続するために使用する変数宣言
		Connection con = null;
		Statement stmt = null;
		StringBuffer SQL = null;
		ResultSet rs = null;

		//	ローカルのMySQLに接続する設定
		String USER = "root";
		String PASSWORD = "";
		String URL = "jdbc:mysql://localhost/nhs00649db";
		String DRIVER = "com.mysql.jdbc.Driver";

		//確認メッセージ
		StringBuffer ERMSG = null;

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
					
					//SQL文の発行（選択クエリ）
					SQL.append("select * from user_tbl");
					
					System.out.println(SQL.toString());
					
					//SQL文の発行（選択クエリ）
					rs = stmt.executeQuery(SQL.toString());

					//抽出したデータを繰り返し処理で表示する
					while(rs.next()){
						//DBのデータをHashMapへ格納する
								map = new HashMap<String,String>();
								map.put("user_no",rs.getString("user_no"));
								map.put("user_id",rs.getString("user_id"));
								map.put("user_pas",rs.getString("user_pas"));
								map.put("user_name",rs.getString("user_name"));
								//１件分のデータ（HashMap）をArrayListへ追加
								list.add(map);
						}
		}	//ｔｒｙブロック終了

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
	
<HTML>
	<head>
		<meta http-equiv= "Content-Type" content="text/html; charset=UTF-8">
		<title>商品管理　全件検索</title>		
		
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    
 	</head>
 	<% if(ERMSG != null){ %>
 		予期せぬエラーが発生しました<br />
 	<%= ERMSG %>
 	<% } %>
 	<body>
 	
 	 			
 	<h1>登録社員一覧</h1>
 	<%
		//ArrayListからデータを取り出す
		for(int i=0; i<list.size(); i++){
	%>
	<form method="post" action="/prototype/mas_userkanri.jsp" >
		<span>ユーザー番号  <%= list.get(i).get("user_no") %></span>
		<br>
		<span>ユーザーID  <%= list.get(i).get("user_id") %></span>
		<br>
		<span>ユーザーPASS  <%= list.get(i).get("user_pas") %></span>
		<br>
		<span>ユーザー名  <%= list.get(i).get("user_name") %></span>
		
		<input type = "hidden" value = "<%= list.get(i).get("user_id") %>">
 		<input type = "submit" value = "編集">	
 		
	</form>
	<br />
	
	<% 
		}
	%>
	
	
    <form method="post" action="/prototype/top.jsp">
 	  <input type = "submit" value = "戻る">
    </form>
	
</body>
</HTML>
