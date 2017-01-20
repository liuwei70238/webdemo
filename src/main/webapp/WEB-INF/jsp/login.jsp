<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<jsp:include page="head.jsp"></jsp:include>
    <title>登录界面</title>
</head>

<script>
    $(function() {
        $(".btn").click(function(){

            var username = $("#id-username").val();
            var password = $("#id-password").val();
            console.log('点击..' + username + ", " + password);
            if(username == ""){
                alert('用户名为空');
            }else if(password == ""){
                alert('密码为空');
            }else {
                $.ajax({
                    url: 'login.do',
                    type: 'POST',
                    data: {
                        username: $("#id-username").val(),
                        password: $("#id-password").val()
                    },
                    dataType: 'json',
                    success: function (r) {
                        if (r.code) {
                            alert('登陆成功');
                            window.location.href="index.jsp";
                        } else {
                            alert('用户名或者密码错误');
                        }
                    },
                    error: function (xhr, e) {
                        alert('请求出错' +  xhr);
                    }

                });
            }
        });
    });
</script>
<body>
<%--<jsp:include page="/head.html"></jsp:include>--%>
<!-- container -->
<div class="container">
    <ol class="breadcrumb">
        <li><a href="index.html">Home</a></li>
        <li class="active">User access</li>
    </ol>

    <div class="row">

        <!-- Article main content -->
        <article class="col-xs-12 maincontent">
            <header class="page-header">
                <h1 class="page-title">登录</h1>
            </header>

            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="thin text-center">登录界面</h3>

                        <hr>

                        <form>
                            <div class="top-margin">
                                <label>用户名 <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="id-username">
                            </div>
                            <div class="top-margin">
                                <label>密码 <span class="text-danger">*</span></label>
                                <input type="password" class="form-control" id="id-password">
                            </div>

                            <hr>

                            <div class="row">
                                <div class="col-lg-8">
                                    <b><a href="#">忘记密码?</a></b>
                                </div>
                                <div class="col-lg-8">
                                    <b><a href="/regist-view.do">还没账号？点击注册</a></b>
                                </div>
                                <div class="col-lg-4 text-right">
                                    <button class="btn btn-action" id="btn_login" type="button" >登录</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>

        </article>
        <!-- /Article -->

    </div>
</div>	<!-- /container -->


<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/headroom.min.js"></script>
<script src="${ctx}/js/jQuery.headroom.min.js"></script>
<script src="${ctx}/js/template.js"></script>
</body>
</html>