<%--
  Created by IntelliJ IDEA.
  User: GQ
  Date: 2019/6/13
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
<%--    该网页id名称未修改  --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <title>结算类别</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body style="margin-top: 50px">
<ol class="breadcrumb container">
    <li><a href="#">首页</a></li>
    <li class="active">结算类别管理</li>
</ol>
<div align="center">
    <h2>医院结算类别管理</h2>
</div>
<form class="container" id="registrationLevelForm">
    <div class="row">
        <div class="col-md-4 pull-right">
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
            <th >结算类别</th>
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
            <legend class="">添加结算类别</legend>
        </div>
    </fieldset>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="settlementTypeInput">结算类别</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="settlementTypeInput" name="settlementTypeName"/>
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
    //结算类别表
    var settlementTypes = null;
    $.ajax({
        type: "POST",
        url: "settlementType/list",
        async: false,
        success: function (result) {
            settlementTypes = result;
        },
        error :function () {
            alert("获取结算类别表失败");
        }
    });
    //设置挂号等级信息表格
    function setTableBody() {
        var str;
        str = "";
        $("#tableBody").html("");
        for (var i = 0;i < settlementTypes.length;i++){
            str += "<tr>" +
                "<td ><input type='checkbox' value='" + settlementTypes[i].id + "'/></td>" +
                "<td class='col-md-2'><input type='text' class=\"form-control\" value=\"" + settlementTypes[i].id + "\" name=\"settlementTypes[" + i + "].id\" readonly/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + settlementTypes[i].settlementTypeName + "\" name=\"settlementTypes[" + i + "].settlementTypeName\"/></td>\n";
            str += "</tr>";
        }
        $("#tableBody").append(str);
    }
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
                url: "settlementType/deleteSettlementTypesByID",
                data: {idString:deleteIDs.join(',')},
                async: false,
                success: function () {
                    $.ajax({
                        type: "POST",
                        url: "settlementType/list",
                        async: false,
                        success: function (result) {
                            settlementTypes = result;
                        },
                        error :function () {
                            alert("获取结算类别表失败");
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
                url: "settlementType/updateSettlementTypes",
                data: $('#registrationLevelForm').serialize(),
                success: function () {
                    alert("保存成功");
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
                url: "settlementType/addSettlementType",
                data: $('#addRegistrationLevel').serialize(),
                success: function () {
                    alert("添加成功");
                    $.ajax({
                        type: "POST",
                        url: "settlementType/list",
                        async: false,
                        success: function (result) {
                            settlementTypes = result;
                            setTableBody();
                        },
                        error :function () {
                            alert("获取结算类别表失败");
                        }
                    });
                }
            });
        });
    });
</script>
</body>
</html>