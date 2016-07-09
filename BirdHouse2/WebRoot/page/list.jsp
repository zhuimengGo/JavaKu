<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>钟科租房 - 首页</TITLE>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action=searchFang.action>
  <DT>
  <UL>
    <LI class=bold>房屋信息</LI>
    <LI>标题：<INPUT class=text type=text name=title value="${session.title}"> <LABEL class=ui-blue><INPUT value=搜索房屋 type="submit" name=search></LABEL> 
    </LI></UL></DT>
  <DD>
  <UL>
    <LI class=first>价格</LI>
    <LI><SELECT name="priceList" id="priceList"> <OPTION selected value="0">不限</OPTION> <OPTION 
      value=1>1000元以下</OPTION> <OPTION value=2 >2000元以下</OPTION>
      <OPTION value=3>3000元以下</OPTION> <OPTION value=4>4000元以下</OPTION> 
      <OPTION value=5>5000元以下</OPTION>
      </SELECT><input type="hidden" value="${session.priceIndex}" name="hiddenprice"/> </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>区域</LI>
    <LI><SELECT id="district" name="district"> <OPTION selected 
      value="0">不限</OPTION> 
       <s:iterator value="#session.Districts" status="statu" id="item" var="show">  
       <OPTION value=""><s:property value="#show.name" /></OPTION>
       </s:iterator>
       </SELECT> <input type="hidden" value="${session.hiddendistrict}" name="hiddendistrict"/></LI></UL></DD>
       
  <DD>
  <UL>
    <LI class=first>街道</LI>
    <LI><SELECT id=street name=street_id> <OPTION selected 
      value="0">不限</OPTION>
      <s:iterator value="#session.Streets" status="statu" id="item" var="show">  
       <OPTION value=""><s:property value="#show.name" /></OPTION>
       </s:iterator>
      </SELECT> <input type="hidden" value="${session.hiddenstreet}" name="hiddenstreet"/></LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房型</LI>
    <LI><SELECT name=type_id id="types"> 
    <OPTION selected value="0">不限</OPTION> 
     <s:iterator value="#session.Types" status="statu" id="item" var="show">  
    <OPTION value=#show.id><s:property value="#show.name" /></OPTION> 
    </s:iterator>
    </SELECT> <input type="hidden" value="${session.hiddentypes}" name="hiddentypes"/>
  </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>面积 </LI>
    <LI><SELECT name=floorage id="floorage"> <OPTION selected value="0">不限</OPTION> <OPTION 
      value=1>100以下</OPTION> <OPTION value=2>200以下</OPTION> <OPTION 
      value=3>300以下</OPTION></SELECT>
      <input type="hidden" value="${session.floorage}" name="hiddenfloorage"/>
       </LI></UL></DD></FORM></DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <!--  -->
    <!-- 
  <TR class=odd>
    <TD class=house-thumb><span><A href="detailsFang.action" target="_blank"><img src="images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="detailsFang.action" target="_blank">大房子</A></DT>
        <DD>海淀区中关村大街,100平米<BR>联系方式：123456789 </DD></DL></TD>
    <TD class=house-type>一室一厅</TD>
    <TD class=house-price><SPAN>230.0</SPAN>元/月</TD></TR> -->
    <s:iterator value="#session.listShow" status="statu" id="item" var="show">  
  <TR>
    <TD class=house-thumb><span><A href="detailsFang.action?hid=<s:property value="#show.id" />" target="_blank"><img src="images/thumb_house.gif" width="100" height="75" alt=""></a></span>
    <span><s:if test="#session.UserId==#show.users.id">
    		您发布的信息
        </s:if></span></TD>
    <TD>
      <DL>
        <DT><A href="detailsFang.action?hid=<s:property value="#show.id" />" target="_blank"><s:property value="#show.title" />  </A></DT>
        <DD><s:property value="#show.street.district.name" />区<s:property value="#show.street.name" />,<s:property value="#show.floorage" />平米<BR>联系方式： <s:property value="#show.users.telephone" /> </DD></DL></TD>
    <TD class=house-type><s:property value="#show.types.name" /></TD>
    <TD class=house-price><SPAN><s:property value="#show.price" /></SPAN>元/月</TD></TR>
     
</s:iterator> 
    </TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="showFang.action?curPage=1">首页</A></LI>
  <LI><A href="showFang.action?curPage=${session.curPage-1}">上一页</A></LI>
  <LI><A href="showFang.action?curPage=${session.curPage+1}">下一页</A></LI>
  <LI><A href="showFang.action?curPage=1000">末页</A></LI></UL><SPAN 
class=total><s:property value="#session.curPage"/>/<s:property value="#session.count"/>页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>钟科租房 © 2016 钟科 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心
 </DD></DL></DIV></BODY></HTML>
