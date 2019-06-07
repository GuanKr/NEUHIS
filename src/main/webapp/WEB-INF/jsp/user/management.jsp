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
        </tr>
        </thead>
        <tbody id="tablebody">
        <c:forEach items=""
        <tr>
            <th><input type="text" name=""></th>
        </tr>
        </tbody>
    </table></div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    var getUserList = function(){
        var departmentList = $.ajax({
                                type: "POST",
                                url: "department/list",
                                async: false,
                                success: function (result) {
                                    return result;
                                },
                                error :function () {
                                    alert("获取科室信息失败");
                                }
                            });
        $.ajax({
            type: "POST",//方法类型
            url: "user/list" ,//url
            async: false,
            success: function (result) {
                    $("#tablebody").html("");
                    for(var i = 0; i < result.length; i++){
                        $("#tablebody").append("<tr><td><input type='text' value='"
                            + result[i].name + "' name='users[" + i + "].name'/>"
                            + "</td><td><select class='form-control' placeholder='"+ result[i].departmentname +"name='users[' " + i + "].departmentId'>"
                            <c:forEach items="departmentList" var="department">
                                <c:choose>
                                    <c:when test="${department.departmentId == result[i].departmentId}">
                                        <option value="${department.departmentId}" selected>${department.departmentName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${country.code}">${country.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            + "</select>"
                            + "</td><td>" + result[i].rolename
                            + "</td><td>" + result[i].titlename
                            + "</td><td>" + result[i].registrationLevelId
                            + "</td></tr>");
                    }
            },
            error : function() {
                alert("获取用户信息失败");
            }
        });
    };
    $(document).ready(function () {
        //加载用户列表
        getUserList();
        }
    );

</script>

</body>
</html>
