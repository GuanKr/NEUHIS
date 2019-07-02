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
    <title>科室信息</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body style="margin-top: 50px">
<div class="container"><div class="row clearfix"><div class="column">
    <nav id="nav" class="navbar navbar-default">
        <a class="navbar-brand">HIS</a>
        <ul class="nav navbar-nav" style="width: 93%">
            <li><a href="user/management">用户管理</a></li>
            <li class="active"><a href="department/management">科室管理</a></li>
            <li><a href="registrationLevel/registrationLevelManagement">挂号等级管理</a></li>
            <li><a href="settlementType/settlementTypeManagement">结算类别管理</a></li>
            <li><a href="diagnoseDirectory/diagnoseDirectoryManagement">诊断目录管理</a></li>
            <li><a href="nonDrugList/nonDrugListManagement">非药品目录管理</a></li>
            <li><a href="schedule/scheduleManagement">排班管理</a></li>
            <li class="active pull-right" style="top: 10px"><input style="top: 10px" class="btn btn-danger" type="button" id="logOutButton" value="退出"/></li>
            <li class="pull-right" id="loginUser"></li>
            <a style="display: none" id="logOut" href="${pageContext.request.contextPath}/logout">退出</a>
        </ul>
    </nav>
</div></div></div>
<%--    <ol class="breadcrumb container">--%>
<%--        <li><a href="#">首页</a></li>--%>
<%--        <li class="active">科室管理</li>--%>
<%--    </ol>--%>
    <div align="center">
        <h2>医院科室管理</h2>
    </div>
    <form class="container" id="departmentsForm">
        <div class="row">
            <div class="col-md-2 pull-right">
                <input type="reset" class="btn btn-default" value="取消" />
                <button type="button" id="updateDepartments" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
        </div>
        <table class="table table-hover table-striped">
            <thead>
                <tr>
                    <th >id</th>
                    <th >科室编码</th>
                    <th>科室名称</th>
                    <th>科室分类</th>
                    <th>科室类别</th>
                </tr>
            </thead>
            <tbody id="tableBody">
            </tbody>
        </table>
    </form>
    <div align="center"><ul id="pageChoose" class="pagination pagination-lg pageindex">
    </ul></div>
    <fieldset>
        <div class="">
            <legend class="container">查询科室</legend>
        </div>
    </fieldset>
    <div class="container">
        <div class="col-md-4 container">
            <select class="form-control" id="searchBy" name="searchBy">
                <option value="department_code">科室编码</option>
                <option value="department_name">科室名称</option>
                <option value="department_category">科室分类</option>
                <option value="department_type">科室类别</option>
            </select>
        </div>
        <div class="col-md-4" id="searchValS">
            <input type='text' id='searchVal' class='form-control'/>
        </div>
        <div class="col-md-4">
            <button type="button" id="search" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
    <br/><br/><br/>
    <form class="" role="form" id="addDepartment"><div class="container">
        <fieldset>
            <div id="legend" class="">
                <legend class="">添加科室</legend>
            </div>
        </fieldset>
        <div class="row">
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" for="departmentCodeInput">科室编码</label>
                <div class="col-md-8 input-group">
                    <input type="text" class="form-control" id="departmentCodeInput" name="departmentCode" />
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" for="departmentNameInput">科室名称</label>
                <div class="col-md-8 input-group">
                    <input type="text" class="form-control" id="departmentNameInput" name="departmentName"/>
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" for="departmentCategoryInput">科室分类</label>
                <div class="col-md-8 input-group">
                    <select class="show-tick form-control" id="departmentCategoryInput" name="departmentCategory">
                    </select>
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" for="departmentTypeNameInput">科室类别</label>
                <div class="col-md-8 input-group">
                    <select class="show-tick form-control" id="departmentTypeNameInput" name="departmentTypeName">
                        <option value="临床科室" >临床科室</option>
                        <option value="医技科室" >医技科室</option>
                        <option value="财务科室" >财务科室</option>
                        <option value="行政科室" >行政科室</option>
                        <option value="其他科室" >其他科室</option>
                    </select>
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2 pull-right">
                <input type="reset" class="btn btn-default" value="清空" />&nbsp;&nbsp;
                <button type="button" id="addDepartmentButton" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;添加&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
        </div>
    </div></form>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    //科室表
    var departments = null;
    //科室分类
    var departmentCategories = null;
    $.ajax({
        type: "POST",
        url: "department/departmentCategory",
        async: false,
        success: function (result) {
            departmentCategories = result;
        },
        error: function () {
            alert("获取科室分类失败");
        }
    });
    //设置科室信息表格
    function setTableBody() {
        var str;
        str = "";
        $("#tableBody").html("");
        for (var i = 0;i < departments.length;i++){
            str += "<tr>" +
                "<td><input type='text' class=\"form-control\" value=\"" + departments[i].id + "\" name=\"departments[" + i + "].id\" readonly/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + departments[i].departmentCode + "\" name=\"departments[" + i + "].departmentCode\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + departments[i].departmentName + "\" name=\"departments[" + i + "].departmentName\"/></td>\n";
            str += "<td><select name=\"departments[" + i + "].departmentCategory\" class=\"form-control\">\n";
            for(var departmentCategoriesI = 0;departmentCategoriesI < departmentCategories.length;departmentCategoriesI++){
                if (departmentCategories[departmentCategoriesI] == departments[i].departmentCategory){
                    str += "<option value=\"" + departmentCategories[departmentCategoriesI] + "\" selected>" + departmentCategories[departmentCategoriesI] + "</option>\n";
                }else {
                    str += "<option value=\"" + departmentCategories[departmentCategoriesI] + "\">" + departmentCategories[departmentCategoriesI] + "</option>\n";
                }
            }
            str += "</select></td>";
            str += "<td><select name=\"departments[" + i + "].departmentTypeName\" class=\"form-control\">\n";
            if (departments[i].departmentTypeName == "临床科室"){
                str += "<option value='临床科室' selected>临床科室</option>" +
                    "<option value='医技科室' >医技科室</option>" +
                    "<option value='财务科室' >财务科室</option>" +
                    "<option value='行政科室' >行政科室</option>" +
                    "<option value='其他科室' >其他科室</option>";
            }else if (departments[i].departmentTypeName == "医技科室") {
                str += "<option value='临床科室' >临床科室</option>" +
                    "<option value='医技科室' selected>医技科室</option>" +
                    "<option value='财务科室' >财务科室</option>" +
                    "<option value='行政科室' >行政科室</option>" +
                    "<option value='其他科室' >其他科室</option>";
            }else if (departments[i].departmentTypeName == "财务科室") {
                str += "<option value='临床科室' >临床科室</option>" +
                    "<option value='医技科室' >医技科室</option>" +
                    "<option value='财务科室' selected>财务科室</option>" +
                    "<option value='行政科室' >行政科室</option>" +
                    "<option value='其他科室' >其他科室</option>";
            }else if (departments[i].departmentTypeName == "行政科室") {
                str += "<option value='临床科室' >临床科室</option>" +
                    "<option value='医技科室' >医技科室</option>" +
                    "<option value='财务科室' >财务科室</option>" +
                    "<option value='行政科室' selected>行政科室</option>" +
                    "<option value='其他科室' >其他科室</option>";
            }else {
                str += "<option value='临床科室' >临床科室</option>" +
                    "<option value='医技科室' >医技科室</option>" +
                    "<option value='财务科室' >财务科室</option>" +
                    "<option value='行政科室' >行政科室</option>" +
                    "<option value='其他科室' selected>其他科室</option>";
            }
            str += "</select></td>";
            str += "</tr>";
        }
        $("#tableBody").append(str);
    }
    function setDepartmentCategoryInput(){
        var setDepartmentCategory = null;
        for (var i = 0; i < departmentCategories.length; i++) {
            setDepartmentCategory += "<option value=" + departmentCategories[i] + ">" + departmentCategories[i] + "</option>\n";
        }
        $("#departmentCategoryInput").html(setDepartmentCategory);
    }
    //设置分页选择栏
    function setPageChoose() {
        var str;
        str = "";
        $("#pageChoose").html("");
        for (var i = 1;i <= pageInfo.pages; i++){
            if(pageInfo.pageNum == i){
                str += "<li class=\"active\"><a onclick='getPageN(" + i + ")'>" + i + "</a></li>";
            }else {
                str += "<li><a onclick='getPageN(" + i + ")'>" + i + "</a></li>";
            }
        }
        $("#pageChoose").append(str);
    }
    //设置搜索后的分页选择栏
    function setSearchedPageChoose() {
        var str;
        str = "";
        $("#pageChoose").html("");
        for (var i = 1;i <= pageInfo.pages; i++){
            if(pageInfo.pageNum == i){
                str += "<li class=\"active\"><a onclick='getSearchedPageN(" + i + ")'>" + i + "</a></li>";
            }else {
                str += "<li><a onclick='getSearchedPageN(" + i + ")'>" + i + "</a></li>";
            }
        }
        $("#pageChoose").append(str);
    }
    //获取指定页科室数据
    var pageInfo = null;
    function getPageN(pageN) {
        $.ajax({
            type: "POST",
            url: "department/listWithPageHelper",
            data: {pageNum : pageN,pageSize : 10},
            success: function (result) {
                pageInfo = result;
                departments = pageInfo.list;
                setTableBody();
                setPageChoose();
            },
            error: function () {
                alert("分页信息错误");
            }
        });
    }
    //获取查询过后的带有第N页科室信息的pageInfo
    var pageInfo = null;
    function getSearchedPageN(pageN) {
        $.ajax({
            type: "POST",
            url: "department/findByAttributeWithPageHelper",
            data: {attribute_name : $("#searchBy").val(),attribute : $("#searchVal").val(),pageNum : pageN,pageSize : 10},
            success: function (result) {
                pageInfo = result;
                departments = pageInfo.list;
                setTableBody();
                setSearchedPageChoose();
            },
            error: function () {
                alert("分页信息错误");
            }
        });
    }
    $(document).ready(function(){
        $("#loginUser").append("<a>" + "${USER_SESSION.loginName}" + "</a><input style=\"display: none\" id=\"userID\" value='" + ${USER_SESSION.id} + "'/>");
        $("#logOutButton").click(function (){
            document.getElementById("logOut").click();
        });
        getPageN(1);
        setDepartmentCategoryInput();
        //设置保存按钮功能
        $("#updateDepartments").click(function () {
            $.ajax({
                type: "POST",
                url: "department/updatedepartments",
                data: $('#departmentsForm').serialize(),
                success: function () {
                    alert("保存成功");
                    getPageN(1);
                },
                error: function () {
                    alert("保存失败");
                }
            });
        });
        //设置查找功能按钮
        $("#search").click(function(){
            getSearchedPageN(1);
        });
        //设置用户添加按钮
        $("#addDepartmentButton").click(function () {
            $.ajax({
                type: "POST",
                url: "department/insertDepartment",
                data: $('#addDepartment').serialize(),
                success: function () {
                    getPageN(1);
                }
            });
        });
    });
</script>
</body>
</html>
