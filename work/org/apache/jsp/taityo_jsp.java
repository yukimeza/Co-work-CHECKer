package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class taityo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>体調情報記入</title>\r\n");
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
      out.write("\t<h2>現在の体調/気分を入力してください。</h2>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<form>\r\n");
      out.write("    <h2>体温選択</h2>\r\n");
      out.write("    <div id=\"taion\">\r\n");
      out.write("      <select>\r\n");
      out.write("        <option>未入力</option>\r\n");
      out.write("        <option>35.5</option>\r\n");
      out.write("        <option>35.6</option>\r\n");
      out.write("        <option>35.7</option>\r\n");
      out.write("        <option>35.8</option>\r\n");
      out.write("        <option>35.9</option>\r\n");
      out.write("        <option>36.0</option>\r\n");
      out.write("        <option>36.1</option>\r\n");
      out.write("        <option>36.2</option>\r\n");
      out.write("        <option>36.3</option>\r\n");
      out.write("        <option>36.4</option>\r\n");
      out.write("        <option>36.5</option>\r\n");
      out.write("        <option>36.6</option>\r\n");
      out.write("        <option>36.7</option>\r\n");
      out.write("        <option>36.8</option>\r\n");
      out.write("        <option>36.9</option>\r\n");
      out.write("        <option>37.0</option>\r\n");
      out.write("        <option>37.1</option>\r\n");
      out.write("        <option>37.2</option>\r\n");
      out.write("        <option>37.3</option>\r\n");
      out.write("        <option>37.4</option>\r\n");
      out.write("        <option>37.5</option>\r\n");
      out.write("        <option>37.6以上</option>\r\n");
      out.write("      </select>\r\n");
      out.write("      ℃<br>\r\n");
      out.write("      ※37．5℃以上の方は出勤不可になります。<br>\r\n");
      out.write("      ------------------------------------------------\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("      <h3>今の気分を</h3><h3>選択してください</h3>\r\n");
      out.write("      <input type=\"range\" id=\"example\" min=\"1\" max=\"10\" step=\"1\">\r\n");
      out.write("      <p id=\"kibun\">今の気分は<span id=\"current-value\"></span>です</p>\r\n");
      out.write("\r\n");
      out.write("    <button class=\"btn\"><a href=\"syukkin.jsp\">登録する</a></button>\r\n");
      out.write("    </form>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("    <form>\r\n");
      out.write("      <button class=\"btn\"><a href=\"my.jsp\">Myページへ</a></button>\r\n");
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
