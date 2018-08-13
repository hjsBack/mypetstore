<%--
  Created by IntelliJ IDEA.
  User: 梦
  Date: 2017/4/1
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,java.util.*,java.text.*,com.neusoft.xkxt.dao.*,com.neusoft.xkxt.bean.*,com.neusoft.xkxt.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%

    String authcode=request.getParameter("authcode");
    String code=(String)session.getAttribute("code");



    if(authcode.equals(code)){
        out.println("<div class='right'>√</div>");}

    else{
        out.println("<div class='wrong'>验证码不正确</div>");}


%>
