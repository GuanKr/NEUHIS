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
        <h2>医院用户管理</h2>
    </div>
    <form class="container" id="usersForm">
        <div class="row">
            <div class="col-md-2 pull-right">
                <input type="reset" class="btn btn-default" value="取消" />
                <button type="button" id="updateUsers" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
        </div>
        <table class="table table-hover table-striped">
            <thead>
                <tr>
                    <th >id</th>
                    <th >姓名</th>
                    <th>科室</th>
                    <th>类别</th>
                    <th>职称</th>
                    <th>挂号级别</th>
                    <th>登录名</th>
                    <th>登录密码</th>
                </tr>
            </thead>
            <tbody id="tableBody">
            </tbody>
        </table>
    </form>
    <fieldset>
        <div class="">
            <legend class="container">查询用户</legend>
        </div>
    </fieldset>
    <div class="container">
        <div class="col-md-4 container">
            <select class="form-control" id="searchBy" name="searchBy">
                <option value="role_name">类别</option>
                <option value="name">姓名</option>
                <option value="login_name">登录名</option>
                <option value="department_name">科室</option>
                <option value="title_name">职称</option>
                <option value="level_name">挂号等级</option>
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
    <form class="" role="form" id="addUser"><div class="container">
        <fieldset>
            <div id="legend" class="">
                <legend class="">添加用户</legend>
            </div>
        </fieldset>
        <div class="row">
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" for="userNameInput">姓名</label>
                <div class="col-md-8 input-group">
                    <input type="text" class="form-control" id="userNameInput" name="name" />
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" for="departmentInput">科室</label>
                <div class="col-md-8 input-group">
                    <select class="show-tick form-control" id="departmentInput" name="departmentname">
                    </select>
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" for="roleNameInput">类别</label>
                <div class="col-md-8 input-group">
                    <select class="show-tick form-control" id="roleNameInput" name="rolename">
                    </select>
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" for="titleNameInput">职称</label>
                <div class="col-md-8 input-group">
                    <select class="show-tick form-control" id="titleNameInput" name="titlename">
                    </select>
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" for="registrationLevelNameInput">挂号等级</label>
                <div class="col-md-8 input-group">
                    <select class="show-tick form-control" id="registrationLevelNameInput" name="registrationLevelname">
                    </select>
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" >登录名</label>
                <div class="col-md-8 input-group">
                    <input type="text" class="form-control"  name="loginName" />
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
            <div class="form-group col-md-3">
                <label class="col-md-4 control-label text-right" >密码</label>
                <div class="col-md-8 input-group">
                    <input type="text" class="form-control"  name="password" />
                    <span class="input-group-addon" style="color: red">*</span>
                </div>
            </div>
            <div class="col-md-2 pull-right">
                <input type="reset" class="btn btn-default" value="清空" />&nbsp;&nbsp;
                <button type="button" id="addUserButton" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;添加&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
        </div>
    </div></form>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    //用户列表
    var users = null;
    $.ajax({
        type: "POST",
        url: "user/list",
        async: false,
        success: function (result) {
            users = result;
            console.log(result);
        },
        error :function () {
            alert("获取用户表失败");
        }
    });
    //科室表
    var departments = null;
    $.ajax({
        type: "POST",
        url: "department/list",
        async: false,
        success: function (result) {
            departments = result;
        },
        error :function () {
            alert("获取科室信息失败");
        }
    });
    //角色表
    var roles = null;
    $.ajax({
        type: "POST",
        url: "role/list",
        async: false,
        success: function (result) {
            roles = result;
        },
        error :function () {
            alert("获取角色信息失败");
        }
    });
    //职称表
    var titles = null;
    $.ajax({
        type: "POST",
        url: "title/list",
        async: false,
        success: function (result) {
            titles = result;
        },
        error :function () {
            alert("获取职称信息失败");
        }
    });
    //挂号等级表
    var registrationLevels = null;
    $.ajax({
        type: "POST",
        url: "registrationLevel/list",
        async: false,
        success: function (result) {
            registrationLevels = result;
        },
        error :function () {
            alert("获取挂号等级表失败");
        }
    });
    //设置用户表格信息
    function setTableBody() {
        var str;
        str = "";
        $("#tableBody").html("");
        for (let i = 0;i < users.length;i++){
            str += "<tr>" +
                "<td><input type='text' class=\"form-control\" value=\"" + users[i].id + "\" name=\"users[" + i + "].id\" readonly/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + users[i].name + "\" name=\"users[" + i + "].name\"/></td>\n";
            str += "<td><select name=\"users[" + i + "].departmentname\" class=\"form-control\">\n";
            for(var departmentI = 0;departmentI < departments.length;departmentI++){
                if (departments[departmentI].departmentName == users[i].departmentname){
                    str += "<option value=\"" + departments[departmentI].departmentName + "\" selected>" + departments[departmentI].departmentName + "</option>\n";
                }else {
                    str += "<option value=\"" + departments[departmentI].departmentName + "\">" + departments[departmentI].departmentName + "</option>\n";
                }
            }
            str += "</select></td>";
            str += "<td><select name=\"users[" + i + "].rolename\" class=\"form-control\">\n";
            for(var roleI = 0;roleI < roles.length;roleI++){
                if (roles[roleI].roleName == users[i].rolename){
                    str += "<option value=\"" + roles[roleI].roleName + "\" selected>" + roles[roleI].roleName + "</option>\n";
                }else {
                    str += "<option value=\"" + roles[roleI].roleName + "\">" + roles[roleI].roleName + "</option>\n";
                }
            }
            str += "</select></td>";
            str += "<td><select name=\"users[" + i + "].titlename\" class=\"form-control\">\n";
            str += "<option value=null selected></option>\n";
            for(var titleI = 0;titleI < titles.length;titleI++){
                if (titles[titleI].titleName == users[i].titlename){
                    str += "<option value=\"" + titles[titleI].titleName + "\" selected>" + titles[titleI].titleName + "</option>\n";
                }else {
                    str += "<option value=\"" + titles[titleI].titleName + "\">" + titles[titleI].titleName + "</option>\n";
                }
            }
            str += "</select></td>";
            str += "<td><select name=\"users[" + i + "].registrationLevelname\" class=\"form-control\">\n";
            str += "<option value='' selected></option>\n";
            for(var registrationLevelI = 0;registrationLevelI < registrationLevels.length;registrationLevelI++){
                if (registrationLevels[registrationLevelI].levelName == users[i].registrationLevelname){
                    str += "<option value=\"" + registrationLevels[registrationLevelI].levelName + "\" selected>" + registrationLevels[registrationLevelI].levelName + "</option>\n";
                }else {
                    str += "<option value=\"" + registrationLevels[registrationLevelI].levelName + "\">" + registrationLevels[registrationLevelI].levelName + "</option>\n";
                }
            }
            str += "</select></td>";
            str += "<td><input type='text' class=\"form-control\" value=\"" + users[i].loginName + "\" name=\"users[" + i + "].loginName\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + users[i].password + "\" name=\"users[" + i + "].password\"/></td>\n";
            str += "</tr>";
        }
        $("#tableBody").append(str);
    }
    function setAddUser(){
        var setDepartment = null;
        for (let i = 0; i < departments.length; i++) {
            setDepartment += "<option value=" + departments[i].departmentName + ">" + departments[i].departmentName + "</option>\n";
        }
        $("#departmentInput").html(setDepartment);
        var setRoleName = null;
        for (let i = 0; i < roles.length; i++) {
            setRoleName += "<option value=" + roles[i].roleName + ">" + roles[i].roleName + "</option>\n";
        }
        $("#roleNameInput").html(setRoleName);
        var setTitleName = null;
        for (let i = 0; i < titles.length; i++) {
            setTitleName += "<option value=" + titles[i].titleName + ">" + titles[i].titleName + "</option>\n";
        }
        $("#titleNameInput").html(setTitleName);
        var setRegistrationLevelName = null;
        for (let i = 0; i < registrationLevels.length; i++) {
            setRegistrationLevelName += "<option value=" + registrationLevels[i].levelName + ">" + registrationLevels[i].levelName + "</option>\n";
        }
        $("#registrationLevelNameInput").html(setRegistrationLevelName);
    }
    $(document).ready(function(){
        setTableBody();
        setAddUser();
        //设置保存按钮功能
        $("#updateUsers").click(function () {
            $.ajax({
                type: "POST",
                url: "user/updateusers",
                data: $('#usersForm').serialize(),
                success: function () {
                    $.ajax({
                        type: "POST",
                        url: "user/list",
                        async: false,
                        success: function (result) {
                            users = result;
                            setTableBody();
                        },
                        error :function () {
                            alert("获取用户表失败");
                        }
                    });
                },
                error: function () {
                    alert("保存失败");
                }
            });
        });
        //设置查找功能按钮
        $("#search").click(function(){
            $.ajax({
                type: "POST",
                url: "user/findbyattribute",
                data: {attribute_name : $("#searchBy").val(),attribute : $("#searchVal").val()},
                success: function (result) {
                    //    TODO result为users 未测试
                    users = result;
                    setTableBody();
                }
            });
        });
        //设置用户添加按钮
        $("#addUserButton").click(function () {
            $.ajax({
                type: "POST",
                url: "user/insertuser",
                data: $('#addUser').serialize(),
                success: function () {
                    $.ajax({
                        type: "POST",
                        url: "user/list",
                        async: false,
                        success: function (result) {
                            users = result;
                            setTableBody();
                        },
                        error :function () {
                            alert("获取用户表失败");
                        }
                    });
                }
            });
        });
    });
</script>
</body>
</html>
