package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_005fpart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>TOPページ</title>\r\n");
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
      out.write("    <form>\r\n");
      out.write("    \t<button class=\"btn\"><a href=\"syukkin.jsp\">出退勤</a></button>\r\n");
      out.write("    \t<button class=\"btn\"><a href=\"/prototype/index.jsp\">シフト希望</a></button>\r\n");
      out.write("    \t<button class=\"btn\"><a href=\"/prototype/index.jsp\">ログアウト</a></button>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("   <h1>シフト予定</h1>\r\n");
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
      out.write("\t\t      labels: ['11月1日', '11月2日', '11月3日', '11月4日', '11月5日', '11月6日', '11月7日'],\r\n");
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
      out.write("\t\t        text: '勤務時間（11月1日~11月7日）'\r\n");
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
      out.write("    <script src=\"js/common.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/calendar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/demo.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    \r\n");
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
