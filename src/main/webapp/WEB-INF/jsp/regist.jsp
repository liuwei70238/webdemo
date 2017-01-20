<%--
  Created by IntelliJ IDEA.
  User: liuw
  Date: 2017/1/13
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<jsp:include page="head.jsp"></jsp:include>
<title>注册界面</title>
</head>

<script>
    $(function () {
        $(".btn").click(function () {

            var username = $("#id-username").val();
            var password = $("#id-password").val();
            var password_r = $('#id-password_repete').val();
            console.log('点击..' + username + ", " + password + ",  " + password_r);
            if (username == "") {
                alert('用户名为空');
            } else if (password == "") {
                alert('密码为空');
            } else if (password != password_r) {
                alert('密码两次输入不相同');
            }else{
                $.ajax( {
                    url:'signin.do',
                    type:'POST',
                    dataType:'json',
                    timeout : 50000,
                    async: false,    // 使用同步操作
                    data:{
                        username: username,
                        password: password
                    },
                    success: function (r) {
                        if (r.code) {
                            alert('注册成功');
                            //window.location.href="login.do?username=" + username + "&password" + password;
                        } else {
                            alert('注册失败');
                        }
                    },
                    error:function (err,e) {
                        alert('请求出错' + err.readyState);
                    }


                });
            }
        });
        

    });
    function check_change() {
        var state = $('.id-checkbox').is(':checked');
        //console.log('state:' + state);
        if(state){
            //console.log('state:' + state);
            $('.btn').attr("disabled",false);
        }else{
            $('.btn').attr("disabled",true);

        }
       // console.log('state:' + $('.id-checkbox').is(':checked'));
    }
</script>
<body>
<!-- container -->
<div class="container">

    <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li class="active">Registration</li>
    </ol>

    <div class="row">

        <!-- Article main content -->
        <article class="col-xs-12 maincontent">
            <header class="page-header">
                <h1 class="page-title">Registration</h1>
            </header>

            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="thin text-center">注册新账户</h3>
                        <hr>

                        <form>
                            <div class="top-margin">
                                <label>用户名 <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="id-username">
                            </div>

                            <div class="row top-margin">
                                <div class="col-sm-6">
                                    <label>密码 <span class="text-danger">*</span></label>
                                    <input type="password" class="form-control" id="id-password">
                                </div>
                                <div class="col-sm-6">
                                    <label>再次输入密码 <span class="text-danger">*</span></label>
                                    <input type="password" class="form-control" id="id-password_repete">
                                </div>
                            </div>

                            <hr>

                            <div class="row">
                                <div class="col-lg-8">
                                    <label class="checkbox">
                                        <input class="id-checkbox" type="checkbox" onchange="check_change()">
                                       同意条款
                                    </label>
                                </div>
                                <div class="col-lg-4 text-right">
                                    <button class="btn btn-action" type="submit" disabled="false">注册</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>

        </article>
        <!-- /Article -->

    </div>
</div>    <!-- /container -->


<footer id="footer" class="top-space">

    <div class="footer1">
        <div class="container">
            <div class="row">

                <div class="col-md-3 widget">
                    <h3 class="widget-title">Contact</h3>
                    <div class="widget-body">
                        <p>+234 23 9873237<br>
                            <a href="mailto:#">some.email@somewhere.com</a><br>
                            <br>
                            234 Hidden Pond Road, Ashland City, TN 37015
                        </p>
                    </div>
                </div>

                <div class="col-md-3 widget">
                    <h3 class="widget-title">Follow me</h3>
                    <div class="widget-body">
                        <p class="follow-me-icons clearfix">
                            <a href=""><i class="fa fa-twitter fa-2"></i></a>
                            <a href=""><i class="fa fa-dribbble fa-2"></i></a>
                            <a href=""><i class="fa fa-github fa-2"></i></a>
                            <a href=""><i class="fa fa-facebook fa-2"></i></a>
                        </p>
                    </div>
                </div>

                <div class="col-md-6 widget">
                    <h3 class="widget-title">Text widget</h3>
                    <div class="widget-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Excepturi, dolores, quibusdam
                            architecto voluptatem amet fugiat nesciunt placeat provident cumque accusamus itaque
                            voluptate modi quidem dolore optio velit hic iusto vero praesentium repellat commodi ad id
                            expedita cupiditate repellendus possimus unde?</p>
                        <p>Eius consequatur nihil quibusdam! Laborum, rerum, quis, inventore ipsa autem repellat
                            provident assumenda labore soluta minima alias temporibus facere distinctio quas adipisci
                            nam sunt explicabo officia tenetur at ea quos doloribus dolorum voluptate reprehenderit
                            architecto sint libero illo et hic.</p>
                    </div>
                </div>

            </div> <!-- /row of widgets -->
        </div>
    </div>

    <div class="footer2">
        <div class="container">
            <div class="row">

                <div class="col-md-6 widget">
                    <div class="widget-body">
                        <p class="simplenav">
                            <a href="#">Home</a> |
                            <a href="about.html">About</a> |
                            <a href="sidebar-right.html">Sidebar</a> |
                            <a href="contact.html">Contact</a> |
                            <b><a href="signup.html">Sign up</a></b>
                        </p>
                    </div>
                </div>

                <div class="col-md-6 widget">
                    <div class="widget-body">
                        <p class="text-right">
                            Copyright &copy; 2014, Your name. Designed by <a href="http://gettemplate.com/"
                                                                             rel="designer">gettemplate</a>
                        </p>
                    </div>
                </div>

            </div> <!-- /row of widgets -->
        </div>
    </div>
</footer>


<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/headroom.min.js"></script>
<script src="${ctx}/js/jQuery.headroom.min.js"></script>
<script src="${ctx}/js/template.js"></script>
</body>
</html>
