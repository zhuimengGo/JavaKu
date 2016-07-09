<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>钟科租房 - 用户管理</TITLE>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="css/style.css">

<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV>
<DIV class=search><LABEL class="ui-green searchs"><a href="fabu.action" title="">发布房屋信息</a></LABEL> 
<LABEL class=ui-green><INPUT onclick='document.location="logout.action"' value="退       出" type=button name=search></LABEL> 
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>
   <s:iterator value="#session.listShow" status="statu" id="item" var="show">
  <TR>
    <TD class=house-thumb><SPAN><A href="detailsFang.action?hid=<s:property value="#show.id" />" target="_blank"><img src="images/thumb_house.gif" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="detailsFang.action?hid=<s:property value="#show.id" />" target="_blank"><s:property value="#show.title" /></A></DT>
        <DD><s:property value="#show.street.district.name" />区<s:property value="#show.street.name" />,<s:property value="#show.floorage" />平米<BR>联系方式： <s:property value="#show.users.telephone" /></DD></DL></TD>
    <TD class=house-type><LABEL class=ui-green><INPUT value="修    改" type=button name=upd><input type="hidden" value=<s:property value="#show.id"/> name="hid"/></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT value="删    除" type=button name="del" id="del"><input type="hidden" value=<s:property value="#show.id"/> name="hid"/></LABEL></TD></TR>
    </s:iterator>
    </TBODY></TABLE></DIV>

<DIV id=footer class=wrap>
<DL>
  <DT>钟科租房 © 2010 北大钟科 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
