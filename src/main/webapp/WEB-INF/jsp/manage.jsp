<%--
  Created by IntelliJ IDEA.
  User: liuw
  Date: 2017/1/16
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<jsp:include page="head.jsp"></jsp:include>
<script type ="text/javascript" src="${ctx}/js/artDialog/jquery.artDialog.js?skin=blue"></script>
<title>用户管理界面</title>
</head>
<script>
    $(function () {


    });
    function modify_user(username,password,authority,id) {
       // console.log('username:' + username);
        art.dialog({
            title : '修改用户信息',
            lock : true,
            padding:0,
            content : "<iframe class='modify-iframe' src='modify_view.do?username=" + username + "&password=" + password + "&authority=" + authority + "&id=" + id +"'></iframe>",

            ok:function () {

            }
        });

    }

    function delete_user(id) {
        console.log('id' + id);
        $.ajax( {
            url:'delete_user.do',
            type:'POST',
            dataType:'json',
            data:{
                id:id
            },
            success: function (r) {
                location.reload();
            },
            error:function (err,e) {
                alert('删除失败' + err.readyState);
            }


        });
    }


</script>
<body>
<table class="table table-hover">
    <caption>所有用户</caption>
    <thead>
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>权限</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${list}" varStatus="i">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <c:choose>
                <c:when test="${user.authority == 0}">
                    <td>非管理员权限</td>
                    <td><a class="id-modify" style="cursor: pointer" onclick="modify_user('${user.username}','${user.password}',${user.authority},${user.id})">修改</a></td>
                    <td><a class="id-delete" style="cursor: pointer" onclick="delete_user(${user.id})">删除</a></td>
                </c:when>
                <c:otherwise>
                    <td>管理员权限</td>
                    <td></td>
                    <td></td>
                </c:otherwise>
            </c:choose>

        </tr>
    </c:forEach>
    </tbody>
</table>
<table>
    <tr>
        <td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页<br>
            <a href="/manage.do?pageNo=${page.topPageNo}"><input type="button" name="fristPage" value="首页" /></a>
            <c:choose>
                <c:when test="${page.pageNo!=1}">
                    <a href="/manage.do?pageNo=${page.previousPageNo }"><input type="button" name="previousPage" value="上一页" /></a>
                </c:when>
                <c:otherwise>
                    <input type="button" disabled="disabled" name="previousPage" value="上一页" />
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${page.pageNo != page.totalPages}">
                    <a href="/manage.do?pageNo=${page.nextPageNo}"><input type="button" name="nextPage" value="下一页" /></a>
                </c:when>
                <c:otherwise>
                    <input type="button" disabled="disabled" name="nextPage" value="下一页" />
                </c:otherwise>
            </c:choose>
            <a href="/manage.do?pageNo=${page.bottomPageNo}"><input type="button" name="lastPage" value="尾页" /></a>
        </td>
    </tr>
</table>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/headroom.min.js"></script>
<script src="${ctx}/js/jQuery.headroom.min.js"></script>
<script src="${ctx}/js/template.js"></script>
</body>
</html>
