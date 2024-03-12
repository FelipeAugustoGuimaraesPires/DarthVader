/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2024-03-12 17:11:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CriarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\"\r\n");
      out.write("          href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\r\n");
      out.write("    <script src=\"../Javascript/verificaCriar.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loggedUser !=null}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("        <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loggedUser}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("        <a href=\"/logout\">Sair</a>\r\n");
      out.write("    </c:if>\r\n");
      out.write("\r\n");
      out.write("    <title>Cadastrar Usuário</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form action=\"/criar-usuario\" method=\"post\" onsubmit=\"return validarFormulario()\">\r\n");
      out.write("        <section>\r\n");
      out.write("            <p> Cadastrar Usuário </p>\r\n");
      out.write("\r\n");
      out.write("            <div>Nome: <input type=\"text\" name=\"User-Nome\" id=\"User-Nome\"></div>\r\n");
      out.write("            <div>CPF: <input type=\"text\" name=\"User-CPF\" id=\"User-CPF\" oninput=\"formatarCPF()\" maxlength=\"14\"></div>\r\n");
      out.write("            <div>E-mail: <input type=\"email\" name=\"User-Email\" id=\"User-Email\"></div>\r\n");
      out.write("            <div>Senha: <input type=\"password\" id=\"senha\"></div>\r\n");
      out.write("            <div>Confirmar Senha: <input type=\"password\" name=\"User-Senha\" id=\"confirmarSenha\"></div>\r\n");
      out.write("            <div>Grupo:\r\n");
      out.write("                <input list=\"grupo\" name=\"User-Grupo\" id=\"User-Grupo\"> </input><br/><br/>\r\n");
      out.write("                <datalist id=\"grupo\">\r\n");
      out.write("                  <option value=\"ADM\">\r\n");
      out.write("                  <option value=\"Estoquista\">\r\n");
      out.write("                </datalist>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\">Ok</button>\r\n");
      out.write("\r\n");
      out.write("            <div><input type=\"hidden\" name=\"id\" id=\"id\"></div>\r\n");
      out.write("        </section>\r\n");
      out.write("    </form>\r\n");
      out.write("    <a href=\"/achar-todos-usuarios\"><button>Cancelar</button></a>\r\n");
      out.write("    <span id=\"mensagemErro\" style=\"display: none; color: red;\"></span>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function formatarCPF() {\r\n");
      out.write("            let cpfInput = document.getElementById('User-CPF');\r\n");
      out.write("            let cpf = cpfInput.value;\r\n");
      out.write("\r\n");
      out.write("            cpf = cpf.replace(/\\D/g, '');\r\n");
      out.write("\r\n");
      out.write("            cpf = cpf.replace(/(\\d{3})(\\d{3})(\\d{3})(\\d{2})/, '$1.$2.$3-$4');\r\n");
      out.write("\r\n");
      out.write("            cpfInput.value = cpf;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
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
