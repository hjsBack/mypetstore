<%--
  Created by IntelliJ IDEA.
  User: ��
  Date: 2017/3/31
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>��֤��</title>
    <script language="javascript">
        function refresh(obj) {
            obj.src = obj.src + "?nocache=" + new Date().getTime();
        }
    </script>

    </head>

<body>
<form action="Check.jsp" method="post">
    <input name="checkCode" type="text" id="checkCode" title="��֤�����ִ�Сд" size="8" ,maxlength="4" />
    <img src="PictureCheckCode" id="CreateCheckCode" align="middle" onclick="refresh(this)">
    <a href="" onclick="refresh()"> ������,��һ��</a>
    <input type="submit" value="�ύ" />
</form>
<form action="#" method="post">
    <input type="text"/>
</form>
</body>
</html>