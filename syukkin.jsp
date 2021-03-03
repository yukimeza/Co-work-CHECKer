
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

    <title>出退勤情報記入</title>


    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">


  </head>

  <body>
  
  <h1><%= list.get(0).get("user_name") %>さん</h1>
  
	<form method="post" action="/prototype/syukkin_ok.jsp">
	
		
      
 	  <input type = "hidden" name = "part_id" value = "<%= list.get(0).get("user_id") %>">
 	  <input type = "hidden" name = "part_name" value = "<%= list.get(0).get("user_name") %>">
	
	
	
	 	 <p>就業日時</p>
	 	 <input type="date" name="hinichi" style="width:100%" required/>
    	 <p>就業開始時間</p>
   		 <input type="time" name="hajime" style="width:100%" required/>
   		 <p>就業終了時間</p>
    	<input type="time" name="owari" style="width:100%" required/>
    
	
	
	    <p>現在の体温は、</p>
	    <div id="taion" >
	      <select name="taion" >
	        <option>未入力</option>
	        <option>35.5</option>
	        <option>35.6</option>
	        <option>35.7</option>
	        <option>35.8</option>
	        <option>35.9</option>
	        <option>36.0</option>
	        <option>36.1</option>
	        <option>36.2</option>
	        <option>36.3</option>
	        <option>36.4</option>
	        <option>36.5</option>
	        <option>36.6</option>
	        <option>36.7</option>
	        <option>36.8</option>
	        <option>36.9</option>
	        <option>37.0</option>
	        <option>37.1</option>
	        <option>37.2</option>
	        <option>37.3</option>
	        <option>37.4</option>
	        <option>37.5</option>
	        <option>37.6以上</option>
	      </select>
	      ℃です。<br><br><br>
	      
	      <p color= "red">※37．5℃以上の方は出勤不可になります。</p>
	      ------------------------------------------------
	    </div><br><br><br>
	    
	      <p>現在の気分を選択してください</p>
	      <input type="range" id="example" min="1" max="10" step="1" name="kibun">
	      <p id="kibun">今の気分は<span id="current-value"></span>です</p>
	      <br><br><br>
	
	 	  <input type = "submit" value = "登録">
    </form>
	
	

    <form>
      <button class="btn"><a href="index.jsp">ログアウト</a></button>
    </form>



    <script src="js/common.js" type="text/javascript"></script>
    <script src="js/current-value.js" type="text/javascript"></script>


  </body>

</html>