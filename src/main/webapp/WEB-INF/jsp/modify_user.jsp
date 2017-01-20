<%--
  Created by IntelliJ IDEA.
  User: liuw
  Date: 2017/1/17
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="${ctx}/js/jquery-1.9.1.js" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/js/artDialog/jquery.artDialog.js?skin=blue"></script>
    <link rel="stylesheet" href="${ctx}/css/bootstrap/bootstrap.min.css">
</head>
<script>

    $(function () {
        $('.btn-confirm').click(function () {
            var username = $('#id-username').val();
            var password = $('#id-password').val();
            var authority = $('#id-authority').val();
            if (username == "") {
                alert('用户名为空');
            } else if (password == "") {
                alert('密码为空');
            } else if (authority == "") {
                alert('权限为空');
            } else {
                $.ajax({
                    url: 'modify_user.do',
                    dataType: 'json',
                    type: 'POST',
                    data: {
                        username:username,
                        password:password,
                        authority:authority,
                        id:${id}

                    },
                    success: function (r) {
                        if(r.code){
                            alert('修改成功');
                            //window.location.href="/modify_view.do";
                        }else{
                            alert('修改失败，请重试');
                        }
                    },
                    error: function (xhr,e) {
                        alert('修改出错' + xhr.readyState);
                    }

                });

            }

        });
    });


</script>
<body>
<div class="top-margin">
    <label>用户名 </label>
    <input type="text" id="id-username" value="${username}">
</div>
<div class="top-margin">
    <label>密码 </label>
    <input type="text" id="id-password" value="${password}">
</div>
<div class="top-margin">
    <label>权限 </label>
    <input type="text" id="id-authority" value="${authority}">
</div>
<div class="col-lg-4 text-right">
    <button class="btn-confirm">确定</button>
</div>

</body>
</html>
