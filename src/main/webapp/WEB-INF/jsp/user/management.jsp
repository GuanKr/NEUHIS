<%--
  Created by IntelliJ IDEA.
  User: GQ
  Date: 2019/6/5
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"/>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <title>用户信息</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body style="margin-top: 50px">
    <div align="center">
        <h3>医院用户管理</h3>
    </div>

    <div class="container"><table class="table table-hover table-striped">
        <thead>
        <tr>
            <th>姓名</th>
            <th>科室</th>
            <th>类别</th>
            <th>职称</th>
            <th>挂号级别</th>
            <th>是否排班</th>
        </tr>
        </thead>
        <tbody id="tablebody">
        </tbody>
    </table></div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">

    var getUserList = function(){
        $.ajax({
            type: "POST",//方法类型
            url: "user/list" ,//url
            async: false,
            success: function (result) {

                    $("#tablebody").html("");
                    for(var i = 0; i < result.length; i++){
                        $("#tablebody").append("<tr><td>"
                            + result[i].name
                            + "</td><td>" + result[i].departmentId
                            + "</td><td>" + result[i].roleId
                            + "</td><td>" + result[i].titleId
                            + "</td><td>" + result[i].registrationLevelId
                            + "</td><td>" + result[i].paiban //TODO
                            + "</td><td><button class='btn btn-primary' id='withdraw' onclick='withdrawClick(" + result.data[i].id + ")'>退号</button>"
                            + "</td></tr>");
                    }

            },
            error : function() {
                alert("获取信息失败");
            }
        });
    };

</script>

</body>
</html>
