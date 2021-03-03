package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class kibou2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("import java.io.*;\r\n");
      out.write("import javax.servlet.*;\r\n");
      out.write("import javax.servlet.http.*;\r\n");
      out.write("\r\n");
      out.write("public class MonthView1 extends HttpServlet{\r\n");
      out.write("\r\n");
      out.write("    public void doGet(HttpServletRequest req, HttpServletResponse res)\r\n");
      out.write("        throws ServletException, IOException{\r\n");
      out.write("\r\n");
      out.write("        res.setContentType(\"text/html;charset=Shift_Jis\");\r\n");
      out.write("        PrintWriter out = res.getWriter();\r\n");
      out.write("\r\n");
      out.write("        StringBuffer sb = new StringBuffer();\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<!DOCTYPE html PUBLIC \\\"-//W3C//DTD HTML 4.0.1//EN\\\" \\\"http://www.w3.org/TR/html4/strict.dtd\\\">\");\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<html lang=\\\"ja\\\">\");\r\n");
      out.write("        sb.append(\"<head>\");\r\n");
      out.write("        sb.append(\"<meta http-equiv=\\\"Content-Type\\\" Content=\\\"text/html;charset=Shift_JIS\\\">\");\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<title>スケジュール管理</title>\");\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<style>\");\r\n");
      out.write("        sb.append(\"table{border:1px solid #a9a9a9;width:90%;padding:0px;margin:0px;border-collapse:collapse;}\");\r\n");
      out.write("        sb.append(\"td{width:12%;border-top:1px solid #a9a9a9;border-left:1px solid #a9a9a9;vertical-align:top;margin:0px;padding:2px;}\");\r\n");
      out.write("        sb.append(\"td.week{background-color:#f0f8ff;text-align:center;}\");\r\n");
      out.write("        sb.append(\"td.day{background-color:#f5f5f5;text-align:right;font-size:0.75em;}\");\r\n");
      out.write("        sb.append(\"td.otherday{background-color:#f5f5f5;color:#d3d3d3;text-align:right;font-size:0.75em;}\");\r\n");
      out.write("        sb.append(\"td.sche{background-color:#fffffff;text-align:left;height:80px;}\");\r\n");
      out.write("        sb.append(\"img{border:0px;}\");\r\n");
      out.write("        sb.append(\"p{font-size:0.75em;}\");\r\n");
      out.write("        sb.append(\"</style>\");\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"</head>\");\r\n");
      out.write("        sb.append(\"<body>\");\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<p>2006年11月</p>\");\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<table>\");\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<tr><td class=\\\"week\\\">日</td><td class=\\\"week\\\">月</td><td class=\\\"week\\\">火</td><td class=\\\"week\\\">水</td><td class=\\\"week\\\">木</td><td class=\\\"week\\\">金</td><td class=\\\"week\\\">土</td></tr>\");\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<tr><td class=\\\"otherday\\\">29</td><td class=\\\"otherday\\\">30</td><td class=\\\"otherday\\\">31</td><td class=\\\"day\\\">1</td><td class=\\\"day\\\">2</td><td class=\\\"day\\\">3</td><td class=\\\"day\\\">4</td></tr>\");\r\n");
      out.write("        sb.append(createScheduleStr());\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<tr><td class=\\\"day\\\">5</td><td class=\\\"day\\\">6</td><td class=\\\"day\\\">7</td><td class=\\\"day\\\">8</td><td class=\\\"day\\\">9</td><td class=\\\"day\\\">10</td><td class=\\\"day\\\">11</td></tr>\");\r\n");
      out.write("        sb.append(createScheduleStr());\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<tr><td class=\\\"day\\\">12</td><td class=\\\"day\\\">13</td><td class=\\\"day\\\">14</td><td class=\\\"day\\\">15</td><td class=\\\"day\\\">16</td><td class=\\\"day\\\">17</td><td class=\\\"day\\\">18</td></tr>\");\r\n");
      out.write("        sb.append(createScheduleStr());\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<tr><td class=\\\"day\\\">19</td><td class=\\\"day\\\">20</td><td class=\\\"day\\\">21</td><td class=\\\"day\\\">22</td><td class=\\\"day\\\">23</td><td class=\\\"day\\\">24</td><td class=\\\"day\\\">25</td></tr>\");\r\n");
      out.write("        sb.append(createScheduleStr());\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<tr><td class=\\\"day\\\">26</td><td class=\\\"day\\\">27</td><td class=\\\"day\\\">28</td><td class=\\\"day\\\">29</td><td class=\\\"day\\\">30</td><td class=\\\"otherday\\\">1</td><td class=\\\"otherday\\\">2</td></tr>\");\r\n");
      out.write("        sb.append(createScheduleStr());\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"</table>\");\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"</body>\");\r\n");
      out.write("        sb.append(\"</html>\");\r\n");
      out.write("\r\n");
      out.write("        out.println(new String(sb));\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    protected String createScheduleStr(){\r\n");
      out.write("        StringBuffer sb = new StringBuffer();\r\n");
      out.write("\r\n");
      out.write("        sb.append(\"<tr>\");\r\n");
      out.write("        for (int i = 0 ; i < 7 ; i++){\r\n");
      out.write("            sb.append(\"<td class=\\\"sche\\\"><img src=\\\"./img/memo.png\\\" width=\\\"14\\\" height=\\\"16\\\"></td>\");\r\n");
      out.write("        }\r\n");
      out.write("        sb.append(\"</tr>\");\r\n");
      out.write("\r\n");
      out.write("        return (new String(sb));\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 request.setCharacterEncoding("UTF-8") ;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("<title>スケジュール管理</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<h1>スケジュール管理</h1>\r\n");
      out.write("\r\n");
      out.write("<p><a href=\"/schedule/MonthView\">月一覧表の表示</a></p>\r\n");
      out.write("</body>\r\n");
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
