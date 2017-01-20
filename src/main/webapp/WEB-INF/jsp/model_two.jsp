<%--
  Created by IntelliJ IDEA.
  User: liuw
  Date: 2017/1/18
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/js/artDialog/jquery.artDialog.js?skin=blue"></script>
<title>表单提交</title>
</head>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function sendForm() {
        //var form = new FormData(document.getElementById("form"));
        var formData = new FormData($("#form")[0]);
        $.ajax({
            url:"/form.do",
            type:"post",
            data:formData,
            async : false,
            cache : false,
            processData:false,
            contentType:false,
            dataType:'json',
            success:function(data){
              //  window.clearInterval(timer);
                if(data.code){
                    alert("文件上传成功");

                }
                console.log("over..");
            },
            error:function(e){
                alert("错误！！" + e);
               // window.clearInterval(timer);
            }
        });
        //get();//此处为上传文件的进度条
    }


</script>

<body>
<%--enctype="multipart/form-data" id="form"--%>
<form role="form" enctype="multipart/form-data"  onsubmit="sendForm() " id="form">
    <div class="form-group">
        <label for="name">名称</label>
        <input type="text" class="form-control" id="name" name="name"
               placeholder="请输入名称">
    </div>
    <div class="form-group">
        <label for="inputfile">文件输入</label>
        <input type="file" id="inputfile" name="file">
    </div>
    <button type="submit" class="btn btn-default">提交</button>
</form>
</body>
</html>
