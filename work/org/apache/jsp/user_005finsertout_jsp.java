package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class user_005finsertout_jsp extends org.apache.jasper.runtime.HttpJspBase
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

		//文字コードの指定
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");

		//入力データ受信
		String user_idStr = request.getParameter("user_id");
		String user_pasStr = request.getParameter("user_pas");
		String user_nameStr = request.getParameter("user_name");


		//	データベースに接続するために使用する変数宣言
		Connection con = null;
		Statement stmt = null;
		StringBuffer SQL = null;
		ResultSet rs = null;


		//	ローカルのMySQLに接続する設定
		String USER = "mezamashi";
		String PASSWORD = "2970yukihisa";
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
					}else{	//存在しない
											
											//ヒットフラグOFF
												hit_flag = 0;
											//SQLステートメントの作成（選択クエリ）
											SQL = new StringBuffer();

											//SQL文の構築（DB追加）
											SQL.append("insert into user_tbl(user_id,user_pas,user_name)");
											SQL.append(" values('");
											SQL.append(user_idStr);
											SQL.append("','");
											SQL.append(user_pasStr);
											SQL.append("','");
											SQL.append(user_nameStr);
											SQL.append("')");

									System.out.println(SQL.toString());
									//SQL文の実行（DB追加）
									ins_count = stmt.executeUpdate(SQL.toString());
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
      out.write("    <title>ユーザー新規登録完了</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/reset.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/common.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form>\r\n");
      out.write("      <h1>ようこそ</h1>\r\n");
      out.write("      <h2>登録完了</h2>\r\n");
      out.write("      <button class=\"btn\"><a href=\"index.jsp\">再度ログイン</a></button>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"js/common.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write(" \t");
 
			if(hit_flag == 1){		//追加NG
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t追加NG<br>\r\n");
      out.write("\t");
      out.print( "入力された商品名は既に登録されています" );
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t");

		}else if(ins_count == 0){		//追加処理失敗
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t追加NG<br>\r\n");
      out.write("\t");
      out.print( "登録処理が失敗しました" );
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

		}else{ //認証OK
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t追加OK<br>\r\n");
      out.write("\t");
      out.print( ins_count + "件　登録が完了しました" );
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");

		}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("<br><br>\r\n");
      out.write(" \t");
 if(ERMSG != null){ 
      out.write("\r\n");
      out.write(" \t予期せぬエラーが発生しました<br/>\r\n");
      out.write(" \t");
      out.print( ERMSG );
      out.write("\r\n");
      out.write(" \t");
 }else{ 
      out.write("\r\n");
      out.write(" \t※エラーは発生しませんでした<br/>\r\n");
      out.write(" \t");
 } 
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
