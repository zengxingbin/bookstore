/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-05 09:32:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;
import java.util.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/menu_search.jsp", Long.valueOf(1486220720775L));
    _jspx_dependants.put("/head.jsp", Long.valueOf(1486222363994L));
  }

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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<title>bookStore注册页面</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/main.css\" type=\"text/css\" />\r\n");
      out.write("<script src=\"js/my.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar judge = new Boolean(true);\r\n");
      out.write("\tfunction clearTip() {\r\n");
      out.write("        var validateCodeMsg =window.document.getElementById(\"validateCodeMsg\");\r\n");
      out.write("        validateCodeMsg.innerHTML = \"\";\r\n");
      out.write("    }\r\n");
      out.write("\tfunction changeImage() {\r\n");
      out.write("\t    document.getElementById(\"inputid5\").value=\"\";\r\n");
      out.write("\t    clearTip();\r\n");
      out.write("\t\tdocument.getElementById(\"img\").src = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/kaptcha/imageCode.do?time=\"\r\n");
      out.write("\t\t\t\t+ new Date().getTime();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction check(msg) {\r\n");
      out.write("\t\tif(msg != \"\")\r\n");
      out.write("\t\t\talert(msg);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction prompt(fontid) {\r\n");
      out.write("\t\tvar font = document.getElementById(fontid);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(\"fontid1\"== fontid)\r\n");
      out.write("\t\t\tfont.innerHTML = \"请输入有效的邮箱地址\";\r\n");
      out.write("\t\telse if(\"fontid2\"== fontid)\r\n");
      out.write("\t\t\tfont.innerHTML = \"用户名设置至少6位\";\r\n");
      out.write("\t\telse if(\"fontid3\"== fontid)\r\n");
      out.write("\t\t\tfont.innerHTML = \"密码设置至少6位\";\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t\tfont.innerHTML = \"\";\r\n");
      out.write("\t\tfont.color = \"black\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkEmail(submit) {\r\n");
      out.write("\t\t//获取input结点\r\n");
      out.write("\t\tvar input = document.getElementById(\"inputid1\");\r\n");
      out.write("\t\t//获取font结点\r\n");
      out.write("\t\tvar font = document.getElementById(\"fontid1\");\r\n");
      out.write("\t\t//创建正则表达式对象\r\n");
      out.write("\t\tvar reg = /^[A-z0-9_-]+\\@[A-z0-9]+(\\.[A-z]+)+$/;\r\n");
      out.write("\t\tif(\"\" == input.value) {\r\n");
      out.write("\t\t\tif(submit == \"submit\") {\r\n");
      out.write("\t\t\t\tfont.innerHTML = \"邮箱不能为空！\";\r\n");
      out.write("\t\t\t\tfont.color = \"red\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tjudge = false;\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(reg.test(input.value)) {\r\n");
      out.write("\t\t\t//创建XMLHttpResquest对象\r\n");
      out.write("\t\t\tvar xhr = getXMLHttpRequest();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//处理响应结果\r\n");
      out.write("\t\t\txhr.onreadystatechange = function() {\r\n");
      out.write("\t\t\t\tif(xhr.readyState == 4) \r\n");
      out.write("\t\t\t\t\tif(xhr.status == 200) {\r\n");
      out.write("\t\t\t\t\t\tif(xhr.responseText == \"true\") {\r\n");
      out.write("\t\t\t\t\t\t\tfont.innerHTML = \"邮箱已经被注册！\";\r\n");
      out.write("\t\t\t\t\t\t\tfont.color = \"orange\";\r\n");
      out.write("\t\t\t\t\t\t\tjudge = false;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\telse {\r\n");
      out.write("\t\t\t\t\t\t\tfont.innerHTML = \"邮箱格式正确！\";\r\n");
      out.write("\t\t\t\t\t\t\tfont.color = \"green\";\r\n");
      out.write("\t\t\t\t\t\t\tjudge = true;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//创建连接\r\n");
      out.write("\t\t\txhr.open(\"get\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user?method=findUserByEmail&email=\" + input.value);\r\n");
      out.write("\t\t\t//发送请求\r\n");
      out.write("\t\t\txhr.send(null);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse {\r\n");
      out.write("\t\t\tfont.innerHTML = \"邮箱格式错误!\";\r\n");
      out.write("\t\t\tfont.color = \"red\";\r\n");
      out.write("\t\t\tjudge = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkUserName(submit) {\r\n");
      out.write("\t\t//获取结点\r\n");
      out.write("\t\tvar input = document.getElementById(\"inputid2\");\r\n");
      out.write("\t\tvar font = document.getElementById(\"fontid2\");\r\n");
      out.write("\t\tif(input.value == \"\") {\r\n");
      out.write("\t\t\tif(submit == \"submit\") {\r\n");
      out.write("\t\t\t\tfont.innerHTML = \"用户名不能为空！\";\r\n");
      out.write("\t\t\t\tfont.color = \"red\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tjudge = false;\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar value = input.value;\r\n");
      out.write("\t\tif(value.length < 6) {\r\n");
      out.write("\t\t\tfont.innerHTML = \"用户名格式错误！\";\r\n");
      out.write("\t\t\tfont.color = \"red\";\r\n");
      out.write("\t\t\tjudge = false;\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\t\t\t//创建XMLHttpResquest对象\r\n");
      out.write("\t\t\tvar xhr = getXMLHttpRequest();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//处理响应结果\r\n");
      out.write("\t\t\txhr.onreadystatechange = function() {\r\n");
      out.write("\t\t\t\tif(xhr.readyState == 4) \r\n");
      out.write("\t\t\t\t\tif(xhr.status == 200) {\r\n");
      out.write("\t\t\t\t\t\tif(xhr.responseText == \"true\") {\r\n");
      out.write("\t\t\t\t\t\t\tfont.innerHTML = \"用户名已经被注册！\";\r\n");
      out.write("\t\t\t\t\t\t\tfont.color = \"orange\";\r\n");
      out.write("\t\t\t\t\t\t\tjudge = false;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\telse {\r\n");
      out.write("\t\t\t\t\t\t\tfont.innerHTML = \"用户名格式正确！\";\r\n");
      out.write("\t\t\t\t\t\t\tfont.color = \"green\";\r\n");
      out.write("\t\t\t\t\t\t\tjudge = true;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//创建连接\r\n");
      out.write("\t\t\txhr.open(\"get\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user?method=findUserByName&name=\" + input.value);\r\n");
      out.write("\t\t\t//发送请求\r\n");
      out.write("\t\t\txhr.send(null);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkPassword(submit) {\r\n");
      out.write("\t\tvar input = document.getElementById(\"inputid3\");\r\n");
      out.write("\t\tvar font = document.getElementById(\"fontid3\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(input.value == \"\")\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tif(submit == \"submit\") {\r\n");
      out.write("\t\t\t\tfont.innerHTML = \"密码不能为空！\";\r\n");
      out.write("\t\t\t\tfont.color = \"red\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(input.value.length < 6) {\r\n");
      out.write("\t\t\tfont.innerHTML = \"密码格式错误！\";\r\n");
      out.write("\t\t\tfont.color = \"red\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\t\t\tfont.innerHTML = \"密码格式正确！\";\r\n");
      out.write("\t\t\tfont.color = \"green\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkRepassword(submit) {\r\n");
      out.write("\t\tvar input = document.getElementById(\"inputid3\");\r\n");
      out.write("\t\tvar input2 = document.getElementById(\"inputid4\");\r\n");
      out.write("\t\tvar font = document.getElementById(\"fontid4\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(\"\" == input2.value) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(submit == \"submit\") {\r\n");
      out.write("\t\t\t\tfont.innerHTML = \"重复密码不能为空！\";\r\n");
      out.write("\t\t\t\tfont.color = \"red\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfont.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(input.value.length < 6) {\r\n");
      out.write("\t\t\tfont.innerHTML = \"密码格式错误！\";\r\n");
      out.write("\t\t\tfont.color = \"red\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} \r\n");
      out.write("\t\tif(input.value != input2.value) {\r\n");
      out.write("\t\t\tfont.innerHTML = \"前后密码不一致！\";\r\n");
      out.write("\t\t\tfont.color = \"red\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\t\t\tfont.innerHTML = \"重复密码正确！\";\r\n");
      out.write("\t\t\tfont.color = \"green\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkvalidateCode(obj) {\r\n");
      out.write("\t    var validateCodeMsg =window.document.getElementById(\"validateCodeMsg\");\r\n");
      out.write("\t    if(obj.value != \"\") {\r\n");
      out.write("\t        var xmlhttp = getXMLHttpRequest();\r\n");
      out.write("\t        xmlhttp.onreadystatechange = function() {\r\n");
      out.write("\t            if(xmlhttp.readyState == 4) {\r\n");
      out.write("\t                if(xmlhttp.status == 200) {\r\n");
      out.write("\t                    if(xmlhttp.responseText == \"true\") {\r\n");
      out.write("\t                        validateCodeMsg.innerHTML = \"<font color='green'>验证码正确</font>\";\r\n");
      out.write("\t                        validateCodeStatus = true;\r\n");
      out.write("\t                    } else {\r\n");
      out.write("\t                        validateCodeMsg.innerHTML = \"<font color='red'>验证码错误</font>\";\r\n");
      out.write("\t                    }\r\n");
      out.write("\t                } else {\r\n");
      out.write("\t                    alert(\"服务器繁忙，请稍后注册！（状态码：\" + xmlhttp.status + \"）\");\r\n");
      out.write("\t                }               \r\n");
      out.write("\t            }\r\n");
      out.write("\t        };\r\n");
      out.write("\t        // 建立与服务器的异步连接\r\n");
      out.write("\t        var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/kaptcha/checkvalidatecode.do?userInputValidateCode=\" + obj.value;\r\n");
      out.write("\t        \r\n");
      out.write("\t        xmlhttp.open(\"get\", url);\r\n");
      out.write("\t        xmlhttp.send(null);     \r\n");
      out.write("\t    }\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkAll(submit) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tcheckEmail(submit);\r\n");
      out.write("\t\tif(judge == true)\r\n");
      out.write("\t\t\tcheckUserName(submit);\r\n");
      out.write("\t\telse {\r\n");
      out.write("\t\t\tcheckUserName(submit);\r\n");
      out.write("\t\t\tjudge = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(judge & checkPassword(submit) & checkRepassword(submit)) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\treturn true; \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body class=\"main\">\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<div id=\"divhead\">\r\n");
      out.write("\t<table cellspacing=\"0\" class=\"headtable\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td><a href=\"index.jsp\"><img src=\"images/logo.png\"\r\n");
      out.write("\t\t\t\t\twidth=\"95\" height=\"30\" border=\"0\" /> </a></td>\r\n");
      out.write("\t\t\t<td style=\"text-align:right\"><img src=\"images/cart.gif\"\r\n");
      out.write("\t\t\t\twidth=\"26\" height=\"23\" style=\"margin-bottom:-4px\" />&nbsp;<a\r\n");
      out.write("\t\t\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/updatePageServlet\">购物车</a> | <a href=\"#\">帮助中心</a> | <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user?method=myAccount\">我的帐户</a>\r\n");
      out.write("\t\t\t\t| <a href=\"register.jsp\">新用户注册</a></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my.js\">\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\tfunction fillNameValue(subDiv) {\r\n");
      out.write("\t\tdocument.getElementById(\"name\").value = subDiv.innerHTML;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"content\").style.display=\"none\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction searchName() {\r\n");
      out.write("\t\tvar nameElement = document.getElementById(\"name\");\r\n");
      out.write("\t\t//获取输入的信息\r\n");
      out.write("\t\tvar nameValue = nameElement.value;\r\n");
      out.write("\r\n");
      out.write("\t\tvar div = document.getElementById(\"content\");\r\n");
      out.write("\t\tdiv.innerHTML = \"\";\r\n");
      out.write("\t\t//1.获取XMLHttpRequest对象\r\n");
      out.write("\t\tvar xmlhttp = getXMLHttpRequest();\r\n");
      out.write("\r\n");
      out.write("\t\t//2.绑定回调函数\r\n");
      out.write("\t\txmlhttp.onreadystatechange = function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tvar jsonObj = eval(\"(\" + xmlhttp.responseText + \")\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(jsonObj.length>0){\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"content\").style.display=\"block\";\r\n");
      out.write("\t\t\t\t\tfor ( var i = 0; i < jsonObj.length; i++) {\r\n");
      out.write("\t\t\t\t\t\tdiv.innerHTML += \"<div onclick='fillNameValue(this)' onmouseover='changeBackground_over(this)' onmouseout='changeBackground_out(this)'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ jsonObj[i] + \"</div>\"\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t//3.open\r\n");
      out.write("\t\txmlhttp.open(\"GET\",\r\n");
      out.write("\t\t\t\t\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/findProductName?name=\"\r\n");
      out.write("\t\t\t\t\t\t+ window.encodeURIComponent(nameValue, \"utf-8\")\r\n");
      out.write("\t\t\t\t\t\t+ \"&time=\" + new Date().getTime());\r\n");
      out.write("\t\t//4.send\r\n");
      out.write("\t\txmlhttp.send(null);\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\tfunction changeBackground_over(div){\r\n");
      out.write("\t\tdiv.style.background=\"gray\";\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction changeBackground_out(div){\r\n");
      out.write("\t\tdiv.style.background=\"white\";\r\n");
      out.write("\t}\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div id=\"divmenu\">\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=文学\">文学</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=生活\">生活</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=计算机\">计算机</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=外语\">外语</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=经营\">经管</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=励志\">励志</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=社科\">社科</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=学术\">学术</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=少儿\">少儿</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=艺术\">艺术</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=原版\">原版</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=科技\">科技</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=考试\">考试</a>\r\n");
      out.write("\t<a\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page&category=生活百科\">生活百科</a>\r\n");
      out.write("\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product?method=page\"\r\n");
      out.write("\t\tstyle=\"color:#FFFF00\">全部商品目录</a>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"divsearch\">\r\n");
      out.write("\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/findProductBySearch\"\r\n");
      out.write("\t\tmethod=\"post\">\r\n");
      out.write("\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td style=\"text-align:right; padding-right:220px\">\r\n");
      out.write("\t\t\t\tSearch <input\r\n");
      out.write("\t\t\t\t\ttype=\"text\" name=\"name\" class=\"inputtable\" onkeyup=\"searchName();\"\r\n");
      out.write("\t\t\t\t\tid=\"name\" /> \r\n");
      out.write("\t\t\t\t\t<input type=\"image\" src=\"images/serchbutton.gif\"\r\n");
      out.write("\t\t\t\t\tborder=\"0\" style=\"margin-bottom:-4px\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"content\"\r\n");
      out.write("\tstyle=\"background-color:white;width:128px; text-align:left;margin-left:945px;color:black;float:left;margin-top: -20px;display: none\">\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"divcontent\">\r\n");
      out.write("\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user?method=regist\"\r\n");
      out.write("\t\t\tmethod=\"post\" onsubmit = \"return checkAll('submit')\">\r\n");
      out.write("\t\t\t<table width=\"850px\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"padding:30px\">\r\n");
      out.write("\t\t\t\t\t\t<h1>新会员注册</h1>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<table width=\"70%\" border=\"0\" cellspacing=\"2\" class=\"upline\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:right; width:20%\">会员邮箱：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"width:40%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id = \"inputid1\" type=\"text\" class=\"textinput\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"email\" onfocus = \"prompt('fontid1')\" onblur = \"checkEmail('no')\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><font id = \"fontid1\" color=\"#999999\">请输入有效的邮箱地址</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:right\">会员名：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id = \"inputid2\" type=\"text\" class=\"textinput\" name=\"userName\" onfocus = \"prompt('fontid2')\" onblur = \"checkUserName('no')\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><font id = \"fontid2\"color=\"#999999\">用户名设置至少6位</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:right\">密码：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input id = \"inputid3\" type=\"password\" class=\"textinput\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"password\" onfocus = \"prompt('fontid3')\" onblur = \"checkPassword('no')\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><font id = \"fontid3\" color=\"#999999\">密码设置至少6位</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:right\">重复密码：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input id = \"inputid4\" type=\"password\" class=\"textinput\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"repassword\" onfocus = \"prompt('fontid4')\" onblur = \"checkRepassword('no')\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><font id = \"fontid4\"></font></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:right\">性别：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"2\">&nbsp;&nbsp;<input type=\"radio\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"gender\" value=\"男\" checked=\"checked\" /> 男\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"radio\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"gender\" value=\"女\" /> 女</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:right\">联系电话：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"text\" class=\"textinput\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"width:350px\" name=\"telephone\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:right\">个人介绍：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"2\"><textarea class=\"textarea\" name=\"introduce\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<h1>注册校验</h1>\r\n");
      out.write("\t\t\t\t\t\t<table width=\"80%\" border=\"0\" cellspacing=\"2\" class=\"upline\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:right; width:20%\">输入校验码：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"width:50%\"><input id = \"inputid5\" type=\"text\" name = \"imagecode\" class=\"textinput\" onblur=\"checkvalidateCode(this)\" onfocus=\"clearTip()\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"validateCodeMsg\"></font></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:right;width:20%;\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"2\" style=\"width:50%\"><img\r\n");
      out.write("\t\t\t\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("kaptcha/imageCode.do\" width=\"180\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\theight=\"30\" class=\"textinput\" style=\"height:30px;\" id=\"img\" />&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0);\" onclick=\"changeImage()\">看不清换一张</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<table width=\"70%\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"padding-top:20px; text-align:center\"><input \r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"image\" src=\"images/signup.gif\" name=\"submit\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"divfoot\">\r\n");
      out.write("\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td rowspan=\"2\" style=\"width:10%\"><img\r\n");
      out.write("\t\t\t\t\tsrc=\"images/bottomlogo.gif\" width=\"195\" height=\"50\"\r\n");
      out.write("\t\t\t\t\tstyle=\"margin-left:175px\" /></td>\r\n");
      out.write("\t\t\t\t<td style=\"padding-top:5px; padding-left:50px\"><a href=\"#\"><font\r\n");
      out.write("\t\t\t\t\t\tcolor=\"#747556\"><b>CONTACT US</b> </font> </a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td style=\"padding-left:50px\"><font color=\"#CCCCCC\"><b>COPYRIGHT\r\n");
      out.write("\t\t\t\t\t\t\t2008 &copy; eShop All Rights RESERVED.</b> </font></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
