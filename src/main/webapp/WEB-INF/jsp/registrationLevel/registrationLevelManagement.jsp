<%--
  Created by IntelliJ IDEA.
  User: GQ
  Date: 2019/6/12
  Time: 10:43
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
    <title>挂号等级</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body style="margin-top: 50px">
<ol class="breadcrumb container">
    <li><a href="#">首页</a></li>
    <li class="active">挂号等级管理</li>
</ol>
<div align="center">
    <h2>医院挂号等级管理</h2>
</div>
<form class="container" id="registrationLevelForm">
    <div class="row">
        <div class="col-md-3 pull-right">
            <button type="button" id="deleteRegistrationsButton" class="btn btn-primary">删除已选</button>&nbsp;&nbsp;
            <input type="reset" class="btn btn-default" value="取消" />&nbsp;&nbsp;
            <button type="button" id="updateRegistrationLevels" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th>删除</th>
            <th class="col-md-2">id</th>
            <th >等级编码</th>
            <th>等级名称</th>
            <th class="col-md-2">是否默认</th>
            <th class=>挂号费用</th>
        </tr>
        </thead>
        <tbody id="tableBody">
        </tbody>
    </table>
</form>
<br/>
<form class="" role="form" id="addRegistrationLevel"><div class="container">
    <fieldset>
        <div id="legend" class="">
            <legend class="">添加挂号等级</legend>
        </div>
    </fieldset>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelCodeInput">等级编码</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelCodeInput" name="code"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelNameInput">等级名称</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelNameInput" name="levelName"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelIsDefaultInput">是否默认</label>
            <div class="col-md-8 input-group">
                <select class="show-tick form-control" id="registrationLevelIsDefaultInput" name="isDefault">
                    <option value=0 >否</option>
                    <option value=1 >默认</option>
                </select>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelPriceInput">挂号价格</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelPriceInput" name="registrationPrice"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 pull-right">
            <input type="reset" class="btn btn-default" value="清空" />&nbsp;&nbsp;
            <button type="button" id="addRegistrationLevelButton" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;添加&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
</div></form>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
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
    //设置挂号等级信息表格
    function setTableBody() {
        var str;
        str = "";
        $("#tableBody").html("");
        for (var i = 0;i < registrationLevels.length;i++){
            str += "<tr>" +
                "<td ><input type='checkbox' value=" + registrationLevels[i].id + " /></td>" +
                "<td class='col-md-2'><input type='text' class=\"form-control\" value=\"" + registrationLevels[i].id + "\" name=\"registrationLevels[" + i + "].id\" readonly/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + registrationLevels[i].code + "\" name=\"registrationLevels[" + i + "].code\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + registrationLevels[i].levelName + "\" name=\"registrationLevels[" + i + "].levelName\"/></td>\n";
            str += "<td class='col-md-2'><select name=\"registrationLevels[" + i + "].isDefault\" class=\"form-control\">\n";
            if (registrationLevels[i].isDefault == 0){
                str += "<option value=0 selected>否</option>\n";
                str += "<option value=1>默认</option>\n";
            }else {
                str += "<option value=0 >否</option>\n";
                str += "<option value=1 selected>默认</option>\n";
            }
            str += "</select></td>";
            str += "<td class='col-lg-2'><div class='input-group'><input type=\"text\" class=\"form-control\" value=\"" + registrationLevels[i].registrationPrice + "\" name=\"registrationLevels[" + i + "].registrationPrice\"/><span class=\"input-group-addon\">￥</span></div></td>\n" +
                "</tr>";
        }
        $("#tableBody").append(str);
    }
    //获取被选择的CheckBox
    $(document).ready(function(){
        setTableBody();
        //设置删除按钮功能
        $("#deleteRegistrationsButton").click(function () {
            var deleteIDs = [];
            $.each($('input:checkbox:checked'),function(){
                deleteIDs.push($(this).val());
            });
            $.ajax({
                type: "POST",
                url: "registrationLevel/deleteRegistrationLevelsByID",
                data: {idString:deleteIDs.join(',')},
                async: false,
                success: function () {
                    $.ajax({
                        type: "POST",
                        url: "registrationLevel/list",
                        async: false,
                        success: function (result) {
                            registrationLevels = result;
                            setTableBody();
                        },
                        error :function () {
                            alert("获取挂号等级表失败");
                        }
                    });
                },
                error :function () {
                    alert("删除失败");
                }

            });
        });
        //设置保存按钮功能
        $("#updateRegistrationLevels").click(function () {
            $.ajax({
                type: "POST",
                url: "registrationLevel/updateRegistrationLevels",
                data: $('#registrationLevelForm').serialize(),
                success: function () {
                    alert("保存成功");
                    $.ajax({
                        type: "POST",
                        url: "registrationLevel/list",
                        async: false,
                        success: function (result) {
                            registrationLevels = result;
                            setTableBody();
                        },
                        error :function () {
                            alert("获取挂号等级表失败");
                        }
                    });
                },
                error: function () {
                    alert("保存失败");
                }
            });
        });
        //设置挂号等级添加按钮
        $("#addRegistrationLevelButton").click(function () {
            $.ajax({
                type: "POST",
                url: "registrationLevel/addRegistrationLevel",
                data: $('#addRegistrationLevel').serialize(),
                success: function () {
                    $.ajax({
                        type: "POST",
                        url: "registrationLevel/list",
                        async: false,
                        success: function (result) {
                            registrationLevels = result;
                            setTableBody();
                        },
                        error :function () {
                            alert("获取挂号等级表失败");
                        }
                    });
                }
            });
        });
    });
</script>
</body>
</html>
