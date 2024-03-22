/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2024-03-22 18:05:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Produto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CadastrodeProduto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("    <title>Title</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../Css/Cadastro.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form action=\"/cadastrar-produto\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("        <h1>Adicionar Produto</h1>\r\n");
      out.write("        <section>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <label for=\"Prod-Nome\">Item</label>\r\n");
      out.write("                <input type=\"text\" name=\"Prod-Nome\" id=\"Prod-Nome\" placeholder=\"Produto\" required minlength=\"2\" maxlength=\"99\"\r\n");
      out.write("                       pattern=\"^[a-zA-Z][a-zA-Z\\s]*$\" title=\"Name should not contain any numbers or special characters.\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <label for=\"Prod-Quantidade\">Quantidade</label>\r\n");
      out.write("                <select name=\"Prod-Quantidade\" id=\"Prod-Quantidade\" required>\r\n");
      out.write("                    <option disabled selected></option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <label for=\"Prod-Avaliacao\">Avaliação</label>\r\n");
      out.write("                <input type=\"number\" name=\"Prod-Avaliacao\" id=\"Prod-Avaliacao\" min=\"1\" max=\"5\" step=\"0.5\" required/>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"descricao\">\r\n");
      out.write("                <label for=\"Prod-Descricao\">Descrição</label>\r\n");
      out.write("                <textarea name=\"Prod-Descricao\" id=\"Prod-Descricao\" required maxlength=\"2000\"\r\n");
      out.write("                          oninput=\"updateCharacterCount()\"></textarea>\r\n");
      out.write("                <div id=\"characterCount\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <label for=\"Prod-Preco\">Preço</label>\r\n");
      out.write("                <span>R$</span>\r\n");
      out.write("                <input type=\"text\" name=\"Prod-Preco\" id=\"Prod-Preco\" inputmode=\"decimal\" min=\"0\" oninput=\"formatPrice(this)\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <label for=\"image\">Upload da primeira imagem</label>\r\n");
      out.write("                <input type=\"file\" name=\"image\" id=\"image\" accept=\"image/png, image/jpeg\"  required/>\r\n");
      out.write("                <img id=\"preview\" src=\"#\" alt=\"Prévia da imagem\" style=\"max-width: 300px; max-height: 200px; display: none;\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <label for=\"image2\">Upload da segunda imagem</label>\r\n");
      out.write("                <input type=\"file\" name=\"image2\" id=\"image2\" accept=\"image/png, image/jpeg\"required/>\r\n");
      out.write("                <img id=\"preview2\" src=\"#\" alt=\"Prévia da imagem\" style=\"max-width: 300px; max-height: 200px; display: none;\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <label for=\"image3\">Upload da terceira imagem</label>\r\n");
      out.write("                <input type=\"file\" name=\"image3\" id=\"image3\" accept=\"image/png, image/jpeg\" required/>\r\n");
      out.write("                <img id=\"preview3\" src=\"#\" alt=\"Prévia da imagem\" style=\"max-width: 300px; max-height: 200px; display: none;\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <label for=\"image4\">Upload da quarta imagem</label>\r\n");
      out.write("                <input type=\"file\" name=\"image4\" id=\"image4\" accept=\"image/png, image/jpeg\" required/>\r\n");
      out.write("                <img id=\"preview4\" src=\"#\" alt=\"Prévia da imagem\" style=\"max-width: 300px; max-height: 200px; display: none;\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\">Ok</button>\r\n");
      out.write("            <div><input type=\"hidden\" name=\"id\" id=\"id\"></div>\r\n");
      out.write("        </section>\r\n");
      out.write("    </form>\r\n");
      out.write("    <a href=\"/achar-todos-produtos\"><button>Cancelar</button></a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function previewImage(event) {\r\n");
      out.write("          var input = event.target;\r\n");
      out.write("          var preview = document.getElementById(\"preview\");\r\n");
      out.write("\r\n");
      out.write("          if (input.files && input.files[0]) {\r\n");
      out.write("            var reader = new FileReader();\r\n");
      out.write("\r\n");
      out.write("            reader.onload = function (e) {\r\n");
      out.write("              preview.src = e.target.result;\r\n");
      out.write("              preview.style.display = \"block\";\r\n");
      out.write("            };\r\n");
      out.write("\r\n");
      out.write("            reader.readAsDataURL(input.files[0]);\r\n");
      out.write("          } else {\r\n");
      out.write("            preview.src = \"#\";\r\n");
      out.write("            preview.style.display = \"none\";\r\n");
      out.write("          }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        var select = document.getElementById(\"Prod-Quantidade\");\r\n");
      out.write("\r\n");
      out.write("        for (var i = 1; i <= 50; i++) {\r\n");
      out.write("          var option = document.createElement(\"option\");\r\n");
      out.write("          option.value = i;\r\n");
      out.write("          option.text = i;\r\n");
      out.write("          select.appendChild(option);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function formatPrice(input) {\r\n");
      out.write("          var value = input.value;\r\n");
      out.write("          value = value.replace(/\\D/g, '');\r\n");
      out.write("          value = value.replace(/^0+/, '');\r\n");
      out.write("\r\n");
      out.write("          if (value.length > 2) {\r\n");
      out.write("            var cents = value.slice(-2);\r\n");
      out.write("            var dollars = value.slice(0, -2);\r\n");
      out.write("            value = dollars + ',' + cents;\r\n");
      out.write("          } else if (value.length === 2) {\r\n");
      out.write("            value = '0,' + value;\r\n");
      out.write("          } else if (value.length === 1) {\r\n");
      out.write("            value = '0,0' + value;\r\n");
      out.write("          }\r\n");
      out.write("\r\n");
      out.write("          input.value = value;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /Produto/CadastrodeProduto.jsp(12,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loggedUser != null || sessionScope.loggedUserEstoque != null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        <span>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loggedUser}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</span>\r\n");
        out.write("        <span>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loggedUserEstoque}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</span>\r\n");
        out.write("        <a href=\"/logout\"><button>Sair</button></a>\r\n");
        out.write("        <a href=\"/PaginaInicial.jsp\"><button>Menu</button></a>\r\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
