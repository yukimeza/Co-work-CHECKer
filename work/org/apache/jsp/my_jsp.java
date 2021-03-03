package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class my_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Myページ</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/reset.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/common.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/calendar.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/theme.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
			if(hit_flag == 1){		//認証OK
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write(" \t<h1>Myページ</h1>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <h1>");
      out.print( list.get(0).get("user_name") );
      out.write("さんの連勤度</h1>\r\n");
      out.write("    <img src=\"images/angry.png\" alt=\"choshi\">\r\n");
      out.write("    <h3>");
      out.print( joutaiStr );
      out.write("</h3>\r\n");
      out.write("\r\n");
      out.write("    <form method=\"post\" action=\"/prototype/syukkin.jsp\">\r\n");
      out.write(" \t  <input type = \"hidden\" name = \"user_id\" value = \"");
      out.print( list.get(0).get("user_id") );
      out.write("\">\r\n");
      out.write(" \t  <input type = \"submit\" value = \"出退勤登録\">\r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("  <form method=\"post\" action=\"/prototype/kibou2.jsp\">\r\n");
      out.write(" \t  <input type = \"hidden\" name = \"user_id\" value = \"");
      out.print( list.get(0).get("user_id") );
      out.write("\">\r\n");
      out.write(" \t  <input type = \"submit\" value = \"シフト希望\">\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("   <h1>今週の予定</h1>\r\n");
      out.write("\r\n");
      out.write("   <div class=\"container-calendar\">\r\n");
      out.write("          <h4 id=\"monthAndYear\"></h4>\r\n");
      out.write("          <div class=\"button-container-calendar\">\r\n");
      out.write("              <button id=\"previous\" onclick=\"previous()\">‹</button>\r\n");
      out.write("              <button id=\"next\" onclick=\"next()\">›</button>\r\n");
      out.write("          </div>\r\n");
      out.write("          \r\n");
      out.write("          <table class=\"table-calendar\" id=\"calendar\" data-lang=\"ja\">\r\n");
      out.write("              <thead id=\"thead-month\"></thead>\r\n");
      out.write("              <tbody id=\"calendar-body\"></tbody>\r\n");
      out.write("          </table>\r\n");
      out.write("          \r\n");
      out.write("          <div class=\"footer-container-calendar\">\r\n");
      out.write("              <label for=\"month\">日付指定：</label>\r\n");
      out.write("              <select id=\"month\" onchange=\"jump()\">\r\n");
      out.write("                  <option value=0>1月</option>\r\n");
      out.write("                  <option value=1>2月</option>\r\n");
      out.write("                  <option value=2>3月</option>\r\n");
      out.write("                  <option value=3>4月</option>\r\n");
      out.write("                  <option value=4>5月</option>\r\n");
      out.write("                  <option value=5>6月</option>\r\n");
      out.write("                  <option value=6>7月</option>\r\n");
      out.write("                  <option value=7>8月</option>\r\n");
      out.write("                  <option value=8>9月</option>\r\n");
      out.write("                  <option value=9>10月</option>\r\n");
      out.write("                  <option value=10>11月</option>\r\n");
      out.write("                  <option value=11>12月</option>\r\n");
      out.write("              </select>\r\n");
      out.write("              <select id=\"year\" onchange=\"jump()\"></select>\r\n");
      out.write("          </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"caleandar\"></div>\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\t\t <h1>連勤度表</h1>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <div class=\"wrappercan\">\r\n");
      out.write("\t\t  <canvas id=\"myLineChart\"></canvas>\r\n");
      out.write("\t\t    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t  <script>\r\n");
      out.write("\t\t  var ctx = document.getElementById(\"myLineChart\");\r\n");
      out.write("\t\t  var myLineChart = new Chart(ctx, {\r\n");
      out.write("\t\t    type: 'line',\r\n");
      out.write("\t\t    data: {\r\n");
      out.write("\t\t      labels: ['3月1日', '3月2日', '3月3日', '3月4日', '3月5日', '3月6日', '3月7日'],\r\n");
      out.write("\t\t      datasets: [\r\n");
      out.write("\t\t        {\r\n");
      out.write("\t\t          label: '残業判定ライン（時）',\r\n");
      out.write("\t\t          data: [8, 8, 8, 8, 8, 8, 8, 8],\r\n");
      out.write("\t\t          borderColor: \"rgba(255,0,0,1)\",\r\n");
      out.write("\t\t          backgroundColor: \"rgba(0,0,0,0)\"\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        {\r\n");
      out.write("\t\t          label: '勤務時間（時）',\r\n");
      out.write("\t\t          data: [4, 6, 0, 3, 7, 9, 0, 6],\r\n");
      out.write("\t\t          borderColor: \"rgba(0,0,255,1)\",\r\n");
      out.write("\t\t          backgroundColor: \"rgba(0,0,0,0)\"\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t      ],\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t    options: {\r\n");
      out.write("\t\t      title: {\r\n");
      out.write("\t\t        display: true,\r\n");
      out.write("\t\t        text: '勤務時間（3月1日~3月7日）'\r\n");
      out.write("\t\t      },\r\n");
      out.write("\t\t      scales: {\r\n");
      out.write("\t\t        yAxes: [{\r\n");
      out.write("\t\t          ticks: {\r\n");
      out.write("\t\t            suggestedMax: 10,\r\n");
      out.write("\t\t            suggestedMin: 0,\r\n");
      out.write("\t\t            stepSize: 10,\r\n");
      out.write("\t\t            callback: function(value, index, values){\r\n");
      out.write("\t\t              return  value +  '時間'\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t\t          }\r\n");
      out.write("\t\t        }]\r\n");
      out.write("\t\t      },\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t  });\r\n");
      out.write("\t\t  </script>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("    <form method=\"post\" action=\"/prototype/idpass.jsp\">\r\n");
      out.write("    \r\n");
      out.write(" \t  <input type = \"hidden\" name = \"user_id\" value = \"");
      out.print( list.get(0).get("user_id") );
      out.write("\">\r\n");
      out.write(" \t  <input type = \"hidden\" name = \"user_pas\" value = \"");
      out.print( list.get(0).get("user_id") );
      out.write("\">\r\n");
      out.write(" \t  <input type = \"hidden\" name = \"user_name\" value = \"");
      out.print( list.get(0).get("user_id") );
      out.write("\">\r\n");
      out.write(" \t  <input type = \"submit\" value = \"パスワード変更\">\t\r\n");
      out.write("    \t\r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("    <form method=\"post\" action=\"/prototype/index.jsp\">\r\n");
      out.write(" \t  <input type = \"submit\" value = \"ログアウト\">\r\n");
      out.write("    </form>\r\n");
      out.write("\t\r\n");
      out.write("    <script src=\"js/common.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/calendar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/demo.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    \r\n");

		}else{		//認証NG

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<h2>パスワードが間違っています。</h2>\r\n");
      out.write("\t\t<form>\r\n");
      out.write("\t    \t<button class=\"btn\"><a href=\"index.jsp\">ログインページへ</a></button>\r\n");
      out.write("\t　　</form>\r\n");
      out.write("\t\t\t\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \t");
 if(ERMSG != null){ 
      out.write("\r\n");
      out.write(" \t予期せぬエラーが発生しました<br />\r\n");
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
      out.write(" \t\r\n");
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
