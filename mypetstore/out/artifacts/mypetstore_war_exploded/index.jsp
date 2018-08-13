<%--
  Created by IntelliJ IDEA.
  User: 梦
  Date: 2017/3/31
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>验证码</title>
    <script language="javascript">
        function refresh(obj) {
            obj.src = obj.src + "?nocache=" + new Date().getTime();
        }
    </script>

    </head>

<body>
<form action="Check.jsp" method="post">
    <input name="checkCode" type="text" id="checkCode" title="验证码区分大小写" size="8" ,maxlength="4" />
    <img src="PictureCheckCode" id="CreateCheckCode" align="middle" onclick="refresh(this)">
    <a href="" onclick="refresh()"> 看不清,换一个</a>
    <input type="submit" value="提交" />
</form>
<form action="#" method="post">
    <input type="text"/>
</form>
</body>
</html>