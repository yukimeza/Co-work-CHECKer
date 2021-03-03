
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

    <title>管理者ページ</title>


    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">


  </head>
  
  <h2><%= list.get(0).get("user_name") %>様</h2>

  <body>


    <form action="/prototype/mas_renkin.jsp">
    <input type="submit" value="登録社員管理">
    </form>
    
    <form action="/prototype/mas_taityo.jsp">
    <input type="submit" value="体調・気分一覧">
    </form>
    
    <form action="/prototype/mas_settei.jsp">
    <input type="hidden" value="<%= list.get(0).get("user_id") %>" name="user_id">
    <input type="submit" value="各種設定変更">
    </form>
    
    <form action="/prototype/mas_shinki.jsp">
    <input type="submit" value="管理者新規登録">
    </form>
    
    <form action="/prototype/index.jsp">
    <input type="submit" value="ログアウト">
    </form>

    <script src="js/common.js" type="text/javascript"></script>

  </body>

</html>