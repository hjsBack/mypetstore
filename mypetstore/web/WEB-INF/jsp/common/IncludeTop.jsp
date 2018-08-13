<%--
  Created by IntelliJ IDEA.
  User: songtie
  Date: 2015/4/21
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css" media="screen" />
    <link rel="Stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="Stylesheet" type="text/css" href="css/simpletooltip.css" />
    <link rel="Stylesheet" type="text/css" rel="stylesheet" href="css/style.css" />
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.autocompleter.min.js" type="text/javascript"></script>
    <script src="js/layui.js" type="text/javascript"></script>
    <script src="js/simpletooltip.js" type="text/javascript"></script>
    <script src="js/poshytip.js" type="text/javascript"></script>

    <link rel="stylesheet" href="css/tip-yellow/tip-yellow.css" type="text/css" />
    <link rel="stylesheet" href="css/tip-violet/tip-violet.css" type="text/css" />
    <link rel="stylesheet" href="css/tip-darkgray/tip-darkgray.css" type="text/css" />
    <link rel="stylesheet" href="css/tip-skyblue/tip-skyblue.css" type="text/css" />
    <link rel="stylesheet" href="css/tip-yellowsimple/tip-yellowsimple.css" type="text/css" />
    <link rel="stylesheet" href="css/tip-twitter/tip-twitter.css" type="text/css" />
    <link rel="stylesheet" href="css/tip-green/tip-green.css" type="text/css" />


    <link rel="stylesheet" type="text/css" href="css/jquery.autocompleter.css" />
    <%--<link rel="stylesheet" type="text/css" href="css/demo.css" />--%>
    <%--<link rel="stylesheet" type="text/css" href="css/component.css" />--%>
    <%--<script src="js/jquery.bigautocomplete.js" charset="UTF-8" type="text/javascript"></script>--%>
    <%--<link rel="stylesheet" href="css/jquery.bigautocomplete.css" type="text/css" />--%>

    <meta name="generator" content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>MyPetStore</title>
    <meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />

    <script language="javascript">
        function refresh(obj) {
            obj.src = obj.src + "?nocache=" + new Date().getTime();
        }
    </script>


    <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>

</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.jpg" /></a>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="viewCategory?categoryId=FISH"><img src="images/sm_fish.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=DOGS"><img src="images/sm_dogs.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=REPTILES"><img src="images/sm_reptiles.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=CATS"><img src="images/sm_cats.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=BIRDS" id="abc" title="abc"><img src="images/sm_birds.gif" /></a>
    </div>

    <script>
        $(function() {
            $("abc").tooltip();
        });
    </script>

    <div id="Search" >
        <div id="SearchContent">
            <form action="searchProduct" method="post">
                <input type="text" name="keyword" id="keyword" maxlength="40" />
                <input type="submit" name="seach" VALUE="Seach">
            </form>
        </div>
    </div>

    <script>
        $('#keyword').poshytip({
            className: 'tip-yellowsimple',
            showOn: 'focus',
            alignTo: 'target',
            alignX: 'right',
            alignY: 'center',
            offsetX: 5,
            showTimeout: 100
        });
    </script>

    <link rel="stylesheet" href="css/jquery-ui.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>

    <script>
        $(document).ready(function () {
            $(function () {
                var availableTags = [];
                var i = 0;
                    <c:forEach var="productNameList" items="${sessionScope.productNameList}">
                    availableTags[i] = "${productNameList}";
                    i++;
                    </c:forEach>
                $("#keyword").autocomplete({
                    source: availableTags
                });
            })
        })
    </script>



    <div id="Menu">
        <div id="MenuContent">
            <a href="viewCart"><img align="middle" name="img_cart" src="images/cart.gif" /></a>
            <img align="middle" src="images/separator.gif" />
            <c:if test="${sessionScope.usernameMsg == null}">
                <a href="#" class="tc">Sign In</a>
            </c:if>

            <c:if test="${sessionScope.usernameMsg != null}">
                <a href="signOut">Sign Out</a>
                <img align="middle" src="images/separator.gif" />
                <a href="includeAccountFields">My Account</a>
            </c:if>
            <img align="middle" src="images/separator.gif" />
            <a href="../help.jsp">?</a>

        </div>
    </div>


    <div class="popup" id="popup">
        <div class="top_nav" id='top_nav'>
            <div align="center">
                <span>Sign In</span>
                <a class="guanbi"></a>
            </div>
        </div>
        <div class="min">
            <div class="tc_login">
                <div class="left">
                    <p></p><p></p>
                    <div align="center">
                        <img src="images/dog5.gif" width="150" height="150" />
                    </div>
                </div>
                <div class="right">
                    <form action="login" method="post" name="form_login" target="_top">
                        <div align="center">
                           <p></p>
                            <input type="text" name="username" id="name" required="required" placeholder="用户名" autocomplete="off" class="input_yh">
                            <input type="password" name="password" id="pass" required="required" placeholder="密码" autocomplete="off" class="input_mm">
                            <input type="text" name="checkCode" id="checkCode"  required="required" placeholder="验证码" autocomplete="off" style="width: 130px">
                        </div>
                        <div style="position: relative;width:100px;height:50px;top: 10px;left: 35px">
                            <img src="PictureCheckCode" id="CreateCheckCode" align="middle" onclick="refresh(this)">
                        </div>
                        <div align="center">
                            <input type="submit" class="button" title="Sign In" value="Login">
                        </div>
                    </form>
                    <dd>
                        <div align="center"><a href="viewNewAccount" target="_blank">Register</a></div>
                    </dd>
                    <hr align="center" />
                    <font color="red"> ${sessionScope.LoginMsg} </font>
                </div>
            </div>
        </div>
    </div>




    <script type="text/javascript">
        //窗口效果
        //点击登录class为tc 显示
        $(".tc").click(function(){
            $("#gray").show();
            $("#popup").show();//查找ID为popup的DIV show()显示#gray
            tc_center();
        });
        //点击关闭按钮
        $("a.guanbi").click(function(){
            $("#gray").hide();
            $("#popup").hide();//查找ID为popup的DIV hide()隐藏
        })

        //窗口水平居中
        $(window).resize(function(){
            tc_center();
        });

        function tc_center(){
            var _top=($(window).height()-$(".popup").height())/2;
            var _left=($(window).width()-$(".popup").width())/2;

            $(".popup").css({top:_top,left:_left});
        }
    </script>

    <script type="text/javascript">
        $(document).ready(function(){

            $(".top_nav").mousedown(function(e){
                $(this).css("cursor","move");//改变鼠标指针的形状
                var offset = $(this).offset();//DIV在页面的位置
                var x = e.pageX - offset.left;//获得鼠标指针离DIV元素左边界的距离
                var y = e.pageY - offset.top;//获得鼠标指针离DIV元素上边界的距离
                $(document).bind("mousemove",function(ev){ //绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件

                    $(".popup").stop();//加上这个之后

                    var _x = ev.pageX - x;//获得X轴方向移动的值
                    var _y = ev.pageY - y;//获得Y轴方向移动的值

                    $(".popup").animate({left:_x+"px",top:_y+"px"},10);
                });

            });

            $(document).mouseup(function() {
                $(".popup").css("cursor","default");
                $(this).unbind("mousemove");
            });
        })
    </script>

</div>

<div id="Content">
