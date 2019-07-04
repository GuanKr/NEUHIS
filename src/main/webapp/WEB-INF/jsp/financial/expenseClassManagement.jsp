<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/7/1
  Time: 11:26
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
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <title>财务管理</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body style="margin-top: 50px">
<ol class="breadcrumb container">
    <li><a href="#">首页</a></li>
    <li class="active">费用科目管理</li>
</ol>
<div align="center">
    <h2>医院费用科目管理</h2>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-10 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target="#example-navbar-collapse">
                            <span class="sr-only">切换导航</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">财务管理</a>

                    </div>
                    <div class="collapse navbar-collapse" id="example-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="financial/expenseClassManagement">费用科目管理</a></li>
                            <li><a href="financial/workload" >工作量统计</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>

<div class="tab-content vertical-tab-content col-md-12 " style="height: 600px;display: block;overflow: auto;">
    <form class="container" id="expenseClassForm" >
        <div class="row">
            <div class="col-md-4 pull-right">
                <button type="button" id="deleteExpenseClass" class="btn btn-primary">删除已选</button>&nbsp;&nbsp;
                <input type="reset" class="btn btn-default" value="取消" />&nbsp;&nbsp;
                <button type="button" id="updateExpenseClasses" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
        </div>
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th>删除</th>
                <th class="col-md-2">id</th>
                <th >费用科目编码</th>
                <th >费用科目名称</th>
            </tr>
            </thead>
            <tbody id="tableBody">
            </tbody>
        </table>
    </form>
</div>

<br/>
<form class="" role="form" id="addExpenseClass"><div class="container">
    <fieldset>
        <div id="legend" class="">
            <legend class="">添加费用科目</legend>
        </div>
    </fieldset>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="ExpenseClassCodeInput">费用编码</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="ExpenseClassCodeInput" name="expenseCode"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="ExpenseClassNameInput">费用科目名称</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="ExpenseClassNameInput" name="expenseName"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 pull-right">
            <input type="reset" class="btn btn-default" value="清空" />&nbsp;&nbsp;
            <button type="button" id="addExpensClassButton" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;添加&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
</div></form>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    //费用科目表
    var expenseClasses = null;
    $.ajax({
        type: "POST",
        url: "financial/listAll",
        async: false,
        success: function (result) {
            expenseClasses = result;
        },
        error :function () {
            alert("获取结算类别表失败");
        }
    });
    //设置费用科目信息表格
    function setTableBody() {
        var str;
        str = "";
        $("#tableBody").html("");
        for (var i = 0;i < expenseClasses.length;i++){
            str += "<tr>" +
                "<td ><input type='checkbox' value='" +  expenseClasses[i].id + "'/></td>" +
                "<td class='col-md-2'><input type=\"text\" class=\"form-control\" value=\"" + expenseClasses[i].id + "\" name=\"expenseClasses[" + i + "].id\" readonly/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + expenseClasses[i] .expenseCode+ "\" name=\"expenseClasses[" + i + "].expenseCode\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" +  expenseClasses[i] .expenseName+ "\" name=\"expenseClasses[" + i + "].expenseName\"/></td>\n" +
                "</tr>";
        }
        $("#tableBody").append(str);
    }
    $(document).ready(function(){
        setTableBody();
        //设置删除按钮功能
        $("#deleteExpenseClass ").click(function () {
            var deleteIDs = [];
            $.each($('input:checkbox:checked'),function(){
                deleteIDs.push($(this).val());
            });
            $.ajax({
                type: "POST",
                url: "financial/deleteById",
                data: {idString: deleteIDs.join(',')},
                async: false,
                success: function () {
                    $.ajax({
                        type: "POST",
                        url: "financial/listAll",
                        async: false,
                        success: function (result) {
                            expenseClasses = result;
                            setTableBody();
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
        $("#updateExpenseClasses").click(function () {
            $.ajax({
                type: "POST",
                url: "financial/update",
                data: $('#expenseClassForm').serialize(),
                success: function () {
                    alert("保存成功");
                },
                error: function () {
                    alert("保存失败");
                }
            });
        });
        //设置添加按钮
        $("#addExpensClassButton").click(function () {
            $.ajax({
                type: "POST",
                url: "financial/addExpenseClass",
                data: $('#addExpenseClass').serialize(),
                success: function () {
                    alert("添加成功");
                    $.ajax({
                        type: "POST",
                        url: "financial/listAll",
                        async: false,
                        success: function (result) {
                            expenseClasses = result;
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
