<%--
  Created by IntelliJ IDEA.
  User: 梦
  Date: 2017/4/1
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>修改个人信息</title>
    <script>


        function createXMLHttpRequest() {
            //表示当前浏览器不是ie,如ns,firefox
            if(window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function validate(field) {
            var div=document.getElementById("divbid");
// var reg=/[^A-Za-z0-9_]{7,10}/g;
            if (field.value.length != 0) {


                //创建XMLHttpRequest
                createXMLHttpRequest();
                var url = "codevalidate.jsp?authcode=" + field.value + "×tamp=" + new Date().getTime();//加时间戳防止缓存重复
                xmlHttp.open("GET", url, true);
                //方法地址，处理完成后自动调用，回调
                xmlHttp.onreadystatechange=function() { //匿名函数
                    if(xmlHttp.readyState == 4) { //Ajax引擎初始化成功
                        if (xmlHttp.status == 200) { //http协议成功
                            document.getElementById("divbid").innerHTML =xmlHttp.responseText;
                        }else {
                            alert("请求失败，错误码=" + xmlHttp.status);
                        }
                    }
                };
                //将参数发送到Ajax引擎
                xmlHttp.send(null);




            }else {

                div.innerHTML="<div  class=\"wrong\">验证码不能为空</div>"
            }
        }

        function reloadImage(imgurl){

            var getimagecode=document.getElementById("codeimg");
            getimagecode.src= imgurl + "?id=" + Math.random();
            var code=<%=session.getAttribute("code")%>;
            alert(code)
        }
    </script>

</head>
<body>

<form action="authcode.jsp" method="post" name="loginform">

    输入验证码：<input type="text" name="authcode" id="authcode" maxlength="4" size="10" onblur="validate(this)" ><span id="divbid"></span>
    <img id="codeimg" name="codeimg" border=0 src="authcode.jsp">
    <a href="javascript:reloadImage('authcode.jsp')">看不清</a><br/>

</form>

<script language="javascript" type="text/javascript">
    function reloadImage(imgurl){

        var getimagecode=document.getElementById("codeimg");
        getimagecode.src= imgurl + "?id=" + Math.random();
        var code=<%=session.getAttribute("code")%>;
        alert(code)
    }
</script>
</body>
</html>
