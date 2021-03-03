package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class mas_005frenkin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\t\r\n");
      out.write("<HTML>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv= \"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<title>商品管理　全件検索</title>\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/reset.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/common.css\">\r\n");
      out.write("    \r\n");
      out.write(" \t</head>\r\n");
      out.write(" \t");
 if(ERMSG != null){ 
      out.write("\r\n");
      out.write(" \t\t予期せぬエラーが発生しました<br />\r\n");
      out.write(" \t");
      out.print( ERMSG );
      out.write("\r\n");
      out.write(" \t");
 } 
      out.write("\r\n");
      out.write(" \t<body>\r\n");
      out.write(" \t\r\n");
      out.write(" \t \t\t\t\r\n");
      out.write(" \t<h1>登録社員一覧</h1>\r\n");
      out.write(" \t");

		//ArrayListからデータを取り出す
		for(int i=0; i<list.size(); i++){
	
      out.write("\r\n");
      out.write("\t<form method=\"post\" action=\"/prototype/mas_userkanri.jsp\" >\r\n");
      out.write("\t\t<span>ユーザー番号  ");
      out.print( list.get(i).get("user_no") );
      out.write("</span>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<span>ユーザーID  ");
      out.print( list.get(i).get("user_id") );
      out.write("</span>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<span>ユーザーPASS  ");
      out.print( list.get(i).get("user_pas") );
      out.write("</span>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<span>ユーザー名  ");
      out.print( list.get(i).get("user_name") );
      out.write("</span>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<input type = \"hidden\" value = \"");
      out.print( list.get(i).get("user_id") );
      out.write("\">\r\n");
      out.write(" \t\t<input type = \"submit\" value = \"編集\">\t\r\n");
      out.write(" \t\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t\r\n");
      out.write("\t");
 
		}
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("    <form method=\"post\" action=\"/prototype/top.jsp\">\r\n");
      out.write(" \t  <input type = \"submit\" value = \"戻る\">\r\n");
      out.write("    </form>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</HTML>\r\n");
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
