package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class syukkin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
 request.setCharacterEncoding("UTF-8") ;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("  <head>\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("    <title>出退勤情報記入</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/reset.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/common.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("  \r\n");
      out.write("  <h1>");
      out.print( list.get(0).get("user_name") );
      out.write("さん</h1>\r\n");
      out.write("  \r\n");
      out.write("\t<form method=\"post\" action=\"/prototype/syukkin_ok.jsp\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("      \r\n");
      out.write(" \t  <input type = \"hidden\" name = \"part_id\" value = \"");
      out.print( list.get(0).get("user_id") );
      out.write("\">\r\n");
      out.write(" \t  <input type = \"hidden\" name = \"part_name\" value = \"");
      out.print( list.get(0).get("user_name") );
      out.write("\">\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t \t <p>就業日時</p>\r\n");
      out.write("\t \t <input type=\"date\" name=\"hinichi\" style=\"width:100%\" required/>\r\n");
      out.write("    \t <p>就業開始時間</p>\r\n");
      out.write("   \t\t <input type=\"time\" name=\"hajime\" style=\"width:100%\" required/>\r\n");
      out.write("   \t\t <p>就業終了時間</p>\r\n");
      out.write("    \t<input type=\"time\" name=\"owari\" style=\"width:100%\" required/>\r\n");
      out.write("    \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t    <p>現在の体温は、</p>\r\n");
      out.write("\t    <div id=\"taion\" >\r\n");
      out.write("\t      <select name=\"taion\" >\r\n");
      out.write("\t        <option>未入力</option>\r\n");
      out.write("\t        <option>35.5</option>\r\n");
      out.write("\t        <option>35.6</option>\r\n");
      out.write("\t        <option>35.7</option>\r\n");
      out.write("\t        <option>35.8</option>\r\n");
      out.write("\t        <option>35.9</option>\r\n");
      out.write("\t        <option>36.0</option>\r\n");
      out.write("\t        <option>36.1</option>\r\n");
      out.write("\t        <option>36.2</option>\r\n");
      out.write("\t        <option>36.3</option>\r\n");
      out.write("\t        <option>36.4</option>\r\n");
      out.write("\t        <option>36.5</option>\r\n");
      out.write("\t        <option>36.6</option>\r\n");
      out.write("\t        <option>36.7</option>\r\n");
      out.write("\t        <option>36.8</option>\r\n");
      out.write("\t        <option>36.9</option>\r\n");
      out.write("\t        <option>37.0</option>\r\n");
      out.write("\t        <option>37.1</option>\r\n");
      out.write("\t        <option>37.2</option>\r\n");
      out.write("\t        <option>37.3</option>\r\n");
      out.write("\t        <option>37.4</option>\r\n");
      out.write("\t        <option>37.5</option>\r\n");
      out.write("\t        <option>37.6以上</option>\r\n");
      out.write("\t      </select>\r\n");
      out.write("\t      ℃です。<br><br><br>\r\n");
      out.write("\t      \r\n");
      out.write("\t      <p color= \"red\">※37．5℃以上の方は出勤不可になります。</p>\r\n");
      out.write("\t      ------------------------------------------------\r\n");
      out.write("\t    </div><br><br><br>\r\n");
      out.write("\t    \r\n");
      out.write("\t      <p>現在の気分を選択してください</p>\r\n");
      out.write("\t      <input type=\"range\" id=\"example\" min=\"1\" max=\"10\" step=\"1\" name=\"kibun\">\r\n");
      out.write("\t      <p id=\"kibun\">今の気分は<span id=\"current-value\"></span>です</p>\r\n");
      out.write("\t      <br><br><br>\r\n");
      out.write("\t\r\n");
      out.write("\t \t  <input type = \"submit\" value = \"登録\">\r\n");
      out.write("    </form>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("    <form>\r\n");
      out.write("      <button class=\"btn\"><a href=\"index.jsp\">ログアウト</a></button>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"js/common.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/current-value.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
