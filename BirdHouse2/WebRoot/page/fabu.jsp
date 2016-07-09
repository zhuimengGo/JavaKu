<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>钟科租房 -发布房屋信息</TITLE>
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
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DT><a href="guanli.action">返回</a></DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post name=addorupdateHouse
action=addorupdateHouse.action>
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name=title value=<s:property value="#session.hs.title"/>> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><input name="typeid" type="hidden" value=<s:property value="#session.typeid" />><SELECT class=text name=type_id id=type_id><s:iterator value="#session.Types" status="statu" id="item" var="show">  
    <OPTION value=<s:property value="#show.id" /> id=<s:property value="#show.id" />><s:property value="#show.name" /></OPTION> 
    </s:iterator></SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text 
name=floorage value=<s:property value="#session.hs.floorage"/>></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value=<s:property value="#session.hs.price"/>> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    <TD><INPUT class=text type=text name="houseDate" value=<s:property value="#session.hs.pubdate"/>></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD><input type="hidden" name="districtid" value=<s:property value="#session.districtid" />>区：<SELECT class=text name="fabu_district" id="fabu_district"><option selected="selected">请选择</option> <s:iterator value="#session.Districts" status="statu" id="item" var="show">  
       <OPTION value="#show.name"><s:property value="#show.name" /></OPTION>
       </s:iterator>
       </SELECT> <input type="hidden" name="streetsid" value=<s:property value="#session.streetsid" />>街：<SELECT class=text 
        name=street_id id=street_id></SELECT> </TD></TR><!-- 
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value=<s:property value="#session.hs.users.telephone"/>> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description><s:property value="#session.hs.description"/></TEXTAREA></TD></TR></TBODY></TABLE>
<DIV class=buttons><INPUT  value=立即发布 type="submit"> 
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>钟科租房 © 2016 钟科 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
