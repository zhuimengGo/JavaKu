<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0049)http://localhost:8080/HouseRent/page/register.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 用户注册</TITLE>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="scripts/send.js"></script>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DD class=past>填写个人信息</DD>
  <DD class=past2><a href="welcome.action">返回登录</a></DD>
  </DL>
<DIV class=box>
<FORM action=# id="reg" method="post">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>用 户 名(*)：</TD>
    <TD><INPUT class=text type=text name=user.name><span></span> </TD></TR>
  <TR>
    <TD class=field>密　　码(*)：</TD>
    <TD><INPUT class=text type=password name=user.password><span></span></TD></TR>
  <TR>
    <TD class=field>确认密码(*)：</TD>
    <TD><INPUT class=text type=password name=repassword><span></span></TD></TR>
  <TR>
    <TD class=field>用户姓名：</TD>
    <TD><INPUT class=text type=text name=user.username><span></span> </TD></TR>
    <tr>
	<td class="field">手机(*)：</td>						
	<td><input class="text" type="text" name="user.telephone" />&nbsp;&nbsp;<input type="button" value="获取验证码" name="send" style="width:70px; height:23px" /><span><input type="hidden" value="1" name="user.state"><input type="hidden" value="5" name="user.logincount"></span></td>
	</tr>
   <tr>
		<td class="field">验证码：</td>
		<td><input type="text" name="yzm"/><span></span></td>
	</tr>
    </TBODY></TABLE>
<DIV class=buttons>
<INPUT value=立即注册 type="submit" name="submit">
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>钟飞租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
