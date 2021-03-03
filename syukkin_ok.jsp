<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%
		//文字コードの指定
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");

		//入力データ受信
		String part_idStr = request.getParameter("part_id");
		String part_nameStr = request.getParameter("part_name");
		String hinichiStr = request.getParameter("hinichi");
		String hajimeStr = request.getParameter("hajime");
		String owariStr = request.getParameter("owari");
		String taionStr = request.getParameter("taion");
		String kibunStr = request.getParameter("kibun");


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


		//ヒットフラグ配置
		int hit_flag = 0;

		//追加件数
		int ins_count = 0;


		try{		//ロードに失敗したときのための例外処理
					//JDBCドライバのロード
					 Class.forName(DRIVER).newInstance();
					
					//Connectionオブジェクトの作成
					con = DriverManager.getConnection(URL,USER,PASSWORD);

					//Statementオブジェクトの作成
					stmt = con.createStatement();

					//SQLステートメントの作成（選択クエリ）
					//SQL = new StringBuffer();      
					
					//SQL文の構築（選択クエリ）
					//SQL.append("select * from kintai_tbl where part_id = '");
					//SQL.append(part_idStr);
					//SQL.append("'");
					//System.out.println(SQL.toString());
					
					//SQL文の発行（選択クエリ）
					//rs = stmt.executeQuery(SQL.toString());


					//入力したデータがデータベースに存在するか調べる
					//if(rs.next()){		//存在する
												//ヒットフラグON
												//hit_flag = 1;
					//}else{	//存在しない
											
											//ヒットフラグOFF
												//hit_flag = 0;
											//SQLステートメントの作成（選択クエリ）
											SQL = new StringBuffer();

											//SQL文の構築（DB追加）
											SQL.append("insert into kintai_tbl(part_id,part_name,hinichi,hajime,owari,taion,kibun)");
											SQL.append(" values('");
											SQL.append(part_idStr);
											SQL.append("','");
											SQL.append(part_nameStr);
											SQL.append("','");
											SQL.append(hinichiStr);
											SQL.append("','");
											SQL.append(hajimeStr);
											SQL.append("','");
											SQL.append(owariStr);
											SQL.append("','");
											SQL.append(taionStr);
											SQL.append("','");
											SQL.append(kibunStr);
											SQL.append("')");

									System.out.println(SQL.toString());
									//SQL文の実行（DB追加）
									ins_count = stmt.executeUpdate(SQL.toString());
					//}
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

    <title>出退勤登録完了</title>


    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">


  </head>

  <body>


    <form>
      <h1>お疲れ様です</h1>
      <h2>登録完了</h2>
      <button class="btn"><a href="index.jsp">ログアウト</a></button>
    </form>
    
	<% if(ERMSG != null){ %>
 	予期せぬエラーが発生しました<br />
 	<%= ERMSG %>
 	<% }else{ %>
 	※エラーは発生しませんでした<br/>
 	<% } %>

    <script src="js/common.js" type="text/javascript"></script>


  </body>

</html>