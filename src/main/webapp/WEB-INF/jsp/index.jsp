<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"/>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
    <a href="user/management">用户管理</a>
    <br/><br/>
    <a class="h4" href="department/management">科室管理</a>
    <br/><br/>
    <a class="h4" href="registrationLevel/registrationLevelManagement">挂号等级管理</a>
    <br/><br/>
    <a href="registrationLevel/registrationLevelManagement">挂号等级管理</a>
    <br/><br/>

</body>
</html>
