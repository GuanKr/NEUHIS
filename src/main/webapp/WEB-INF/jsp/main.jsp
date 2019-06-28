<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2019/6/27
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统主页</title>
</head>
<body>
当前用户：${USER_SESSION.loginName}  id：${USER_SESSION.id}
<a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>