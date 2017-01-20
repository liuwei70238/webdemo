<%--
  Created by IntelliJ IDEA.
  User: liuw
  Date: 2017/1/13
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><!-- 对移动设备更好的支持-->
    <meta name="description" content="">
    <meta name="author" content="Sergey Pozhilov (GetTemplate.com)">
    <link rel="shortcut icon" href="${ctx}/images/gt_favicon.png">


    <link rel="stylesheet" href="${ctx}/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/css/bootstrap/font-awesome.min.css">

    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="${ctx}/css/bootstrap/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" href="${ctx}/css/bootstrap/main.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>

    <![endif]-->

    <script src="${ctx}/js/jquery-1.9.1.js" type="text/javascript"></script>
    <div class="navbar navbar-inverse navbar-fixed-top headroom">
        <div class="container">
            <div class="navbar-header">
                <!-- Button for smallest screens -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
                <a class="navbar-brand" href="index.html"><img src="/images/logo.png"
                                                               alt="Progressus HTML5 template"></a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav pull-right">
                    <li class="active"><a href="/index.jsp">主页</a></li>
                    <li class="active"><a href="#">关于</a></li>
                    <li class="active" >
                        <a href="/family.do" >家谱</a>
                    </li>
                    <li class="active"><a href="#">联系我们</a></li>
                    <c:if test="${sessionScope.username == null}">
                        <li  class="active"><a class="btn" href="/login-view.do">登录/ 注册</a></li>
                    </c:if>

                    <c:choose>
                        <c:when test="${sessionScope.username != null}">
                        <li class="dropdown">
                            <a lass="dropdown-toggle" data-toggle="dropdown"><img class="img_user" src="/images/p_red.png"> ${sessionScope.username}<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/logout.do">退出账号</a></li>
                                <li><a href="/login-view.do">切换账号</a></li>
                            </ul>
                        </li>
                       </c:when>
                        <c:otherwise>
                            <li><a><img class="img_user" src="/images/p_white.png"></a></li>
                        </c:otherwise>
                    </c:choose>

                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
    <header id="head" class="secondary"></header>
