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
<html>
<head>
    <title>用户信息</title>
</head>
    <body>
    <div align="center">
        <h3>医院用户管理</h3>
    </div>
    <div align="center"><form action="/user/list">
        <table border="1">
            <tr>
                <th>&nbsp;</th>
                <th>姓名</th>
                <th>科室</th>
                <th>类别</th>
                <th>职称</th>
            </tr>
            <c:forEach items="${list.list}" var="user">
                <tr>
                    <td><input type="checkbox" name="ids" value="${user.id}"/> </td>
                    <td><input type="text" value="${user.name}" name=""></td>
                    <td>${user.departmentId}</td>
                    <td>${user.roleId}</td>
                    <td>${user.title}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6" align="right"><input type="submit" value="删除选择的城市"/> </td>
            </tr>
            <tr>
                <td colspan="6">当前第${list.pageNum + 1}页
                    <c:forEach step="1" begin="0" end="${list.total}" var="cnt" varStatus="status">
                        <a href="city/list?pageNum=${cnt}&pageCount=10">第${cnt + 1}页</a>
                    </c:forEach>
                    共${list.total}页
                </td>
            </tr>
        </table>
    </form>
    </div>
    </body>
</html>
