<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/6/20
  Time: 10:46
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
    <title>医技工作站</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="breadcrumb">
                <li><a href="#">主页</a></li>
                <li class="active">医技工作站</li>
            </ul>
        </div>
    </div>
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
                        <a class="navbar-brand" href="#">门诊医技工作站</a>

                    </div>
                    <div class="collapse navbar-collapse" id="example-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="inspection/inspectionManagement">检查检验</a></li>
                            <li><a href="inspection/commonItems">录入结果</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="col-md-2" >
            <input type='text' id='doctorId' class='form-control'/>
        </div>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-3 column">
            <select data-am-selected class="form-control"id = "searchBy" name="searchBy">
                <option value="medical_record_no">病历号</option>
                <option value="id" selected>姓名</option>
            </select>
        </div>
        <div class="col-md-6 column">
            <input type="text" id="searchVal" name = "searchVal" class="form-control" />
        </div>
        <div class="col-md-3 column">
            <button type="button" id="search" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <table class="table table-hover table-striped"  id="inspection">
            <thead>
            <tr>
                <th>处置id</th>
                <th>病历号</th>
                <th>处置名称</th>
                <th>状态</th>
                <th>登记</th>
<%--                <th>记录结果</th>--%>
            </tr>
            </thead>
            <tbody id="inspectionTable">
            </tbody>
        </table>
    </div>
</div>
<%--<div class="tab-content vertical-tab-content col-md-12 " style="margin-left:auto;margin-right:auto;overflow: auto;">--%>
<%--    --%>
<%--</div>--%>


<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    var str ="";
    //登记按钮
    function register(i){
        $.ajax({
            type:"POST",
            data:{medicalNo :inspectionList[i].medicalRecordNo , inspectionId: inspectionList[i].id,doctorId : $("#doctorId").val()},
            async: false,
            url :'inspection/register',
            success:function (result) {
                str = result;
                alert(str);
            },
            error :function () {
                alert("登记失败");
            }
        });
    }
    var inspectionList = null;
    $(document).ready(function(){
        //设置查找功能按钮

        $("#search").click(function(){
            $.ajax({
                type:"POST",
                data: {attribute_name : $("#searchBy").val(),attribute : $("#searchVal").val(),doctorId : $("#doctorId").val()},
               // data: {attribute : $("#searchVal").val()},
                url :'inspection/findInspectionByAttribute',
                success:function(result){
                    inspectionList = result;
                    var str;
                    str = "";
                    $("#inspectionTable").html("");
                    for (var i = 0;i < inspectionList.length;i++){
                        str += "<tr>" +
                            "<td class='col-md-2'><input type=\"text\" class=\"form-control\" value=\"" + inspectionList[i].id + "\" id=\"registerId\" name=\"inspections[" + i + "].id\" readonly/></td>\n" +
                            "<td class='col-md-2'><input type=\"text\" class=\"form-control\" value=\"" + inspectionList[i].medicalRecordNo + "\" id=\"registerNo\" name=\"inspections[" + i + "].medicalRecordNo\"/></td>\n" +
                            "<td class='col-md-2'><input type=\"text\" class=\"form-control\" value=\"" + inspectionList[i].nonDrugListName + "\" name=\"inspections[" + i + "].medicalRecordNo\"/></td>\n" +
                            "<td class='col-md-2'><input type=\"text\" class=\"form-control\" value=\"" + inspectionList[i].payState + "\" name=\"inspections[" + i + "].payState\"/></td>\n" +
                            //"<td class='col-md-2'><input type=\"button\" class=\"btn btn-primary\" id = \"register\" value=\"登记\"/></td>\n" +
                            "<td class='col-md-2' ><button type=\"button\" class=\"btn btn-primary\" value=\"" + inspectionList[i].medicalRecordNo +"\"  id=\"register\" name=\"register\" onclick=\"register("+ i +")\" >登记</button></td>\n" +
                            //"<td class='col-md-2' ><button type=\"button\" class=\"btn btn-primary\" value=\"" + inspectionList[i].id + "\" id=\"result\">记录结果</button></td>\n" +
                            "</tr>";
                    }
                    $("#inspectionTable").append(str);
                },
                async: true,
                error :function () {
                    alert("获取处置患者失败");
                }
            });
        });


    });


    //设置检查检验表格
    // function setInspectionTable(){
    //     var str;
    //     str = "";
    //     $("#inspectionTable").html("");
    //     for (var i = 0;i < inspectionList.length;i++){
    //         str += "<tr>" +
    //             "<td><input type=\"text\"  class=\"form-control\" value=\"" + inspectionList[i].id + "\" name=\"inspections[" + i + "].id\" readonly/></td>\n" +
    //             "<td><input type=\"text\" class=\"form-control\" value=\"" + inspectionList[i].medicalRecordNo + "\" name=\"inspections[" + i + "].medicalRecordNo\"/></td>\n" +
    //             "<td><input type=\"text\" class=\"form-control\" value=\"" + inspectionList[i].payState + "\" name=\"inspections[" + i + "].payState\"/></td>\n" +
    //             "<td><button  value='" + inspectionList[i].id+ "'/>登记</td>" +
    //             "<td><button  value='" + inspectionList[i].id+ "'/>补录</td>" +
    //             "</tr>";
    //     }
    //     $("#inspectionTable").append(str);
    // }

</script>

