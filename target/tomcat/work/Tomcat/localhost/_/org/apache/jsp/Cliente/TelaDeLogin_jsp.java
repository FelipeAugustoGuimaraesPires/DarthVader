/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2024-04-18 17:56:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Cliente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TelaDeLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"pt-BR\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>UtopiaNerd</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../Css/Cliente/Login.css\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\" id=\"container\">\r\n");
      out.write("    <div class=\"form-container sign-up-container\">\r\n");
      out.write("        <form action=\"/cadastroServlet\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("            <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.mensagemCad}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            <input type=\"text\" id=\"nome\" name=\"nome\" placeholder=\"Name\" />\r\n");
      out.write("            <input type=\"email\" id=\"email-criar\" name=\"email-criar\" placeholder=\"Email\" />\r\n");
      out.write("            <input type=\"CPF\" id=\"cpf\" name=\"cpf\" oninput=\"formatarCPF()\" maxlength=\"14\" placeholder=\"CPF\" />\r\n");
      out.write("\r\n");
      out.write("             <button type=\"submit\">Cadastrar</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"form-container sign-in-container\">\r\n");
      out.write("        <form action=\"/login-cliente\" method=\"post\">\r\n");
      out.write("            <h1>Entrar</h1>\r\n");
      out.write("            <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.mensagem}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"Email\" />\r\n");
      out.write("            <input type=\"password\" id=\"senha\" name=\"senha\" placeholder=\"Senha\" />\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\">Entre</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"overlay-container\">\r\n");
      out.write("        <div class=\"overlay\">\r\n");
      out.write("            <div class=\"overlay-panel overlay-left\">\r\n");
      out.write("                <h1>Bem vindo</h1>\r\n");
      out.write("                <p>Entre com seu login </p>\r\n");
      out.write("                <button class=\"ghost\" id=\"signIn\">Entrar\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"overlay-panel overlay-right\">\r\n");
      out.write("                <h1>Ola, Bem vindo!</h1>\r\n");
      out.write("                <p>Para prosseguir, crie sua conta colocando suas informações nos campos ao lado</p>\r\n");
      out.write("                <button class=\"ghost\" id=\"signUp\">Cadastre-se</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function formatarCPF() {\r\n");
      out.write("            let cpfInput = document.getElementById('cpf');\r\n");
      out.write("            let cpf = cpfInput.value;\r\n");
      out.write("\r\n");
      out.write("            cpf = cpf.replace(/\\D/g, '');\r\n");
      out.write("\r\n");
      out.write("            cpf = cpf.replace(/(\\d{3})(\\d{3})(\\d{3})(\\d{2})/, '$1.$2.$3-$4');\r\n");
      out.write("\r\n");
      out.write("            cpfInput.value = cpf;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"../Javascript/Cliente/Login.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}