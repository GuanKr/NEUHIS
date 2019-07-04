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
<h2>HIS</h2>
    <a href="user/management">用户管理</a>
    <br/><br/>
    <a href="department/management">科室管理</a>
    <br/><br/>
    <a href="registrationLevel/registrationLevelManagement">挂号等级管理</a>
    <br/><br/>
    <a href="settlementType/settlementTypeManagement">结算类别管理</a>
    <br/><br/>
    <a href="diagnoseDirectory/diagnoseDirectoryManagement">诊断目录管理</a>
    <br/><br/>
    <a href="nonDrugList/nonDrugListManagement">非药品目录管理</a>
    <br/><br/>
    <a href="schedule/scheduleManagement">排班管理</a>
    <br/><br/>
    <a href="medicalRecord/medicalRecord">病例首页</a>
    <br/><br/>
    <a href="registration/registrationInfo">挂号</a>
    <br/><br/>
    <a href="charge/chargeManagement">门诊收费</a>
    <br/><br/>
    <a href="inspection/inspectionManagement">医技</a>
    <br/><br/>
    <a href="pharmacy/drugManagement">药房</a>
    <br/><br/>
    <a href="financial/expenseClassManagement">财务</a>
    <br/><br/>

</body>
</html>
