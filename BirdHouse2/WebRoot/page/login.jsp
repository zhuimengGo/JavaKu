<%@page import="org.apache.struts2.ServletActionContext"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0032)http://localhost:8080/HouseRent/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 用户登录</TITLE>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DIV class=box>
<H4>用户登录</H4>
<FORM id=user method=post name=user action=#>
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD colSpan=2></TD></TR>
    <s:fielderror/><!-- 显示表单验证的出错信息 -->
   
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><!-- <input type="text" class="text" name="name"/> -->
    <INPUT id=user_name class=text type=text name=name value="${session.user.name }"/><span></span> </TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><input type="password" class="text" name="password" /><span></span></TD>
  </TR>
	<TR>
		<td class="field">验 证 码：</td>
		<td><input type="text" class="text verycode" name="veryCode"/><img src="page/Number.jsp" id="safeCode" style='position:absolute;bottom:255px'/>
		<a id="changeCode" href="#" style="text-decoration: none">&quest;&quest;&quest;&quest;&quest;&quest;&quest;看不清，换一张</a><br></td>
	</TR>
				</TBODY></TABLE>
<DIV class=buttons> <INPUT type="submit" name="submit" value=登陆 > <INPUT onclick='document.location="regs.action"' value=注册 type=button> 
</DIV></DIV>
	
</FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT class="gongsi">钟飞租房 © 2016 钟科IT 京ICP证1000001号</DT>
  <DD class="gongsi">关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
