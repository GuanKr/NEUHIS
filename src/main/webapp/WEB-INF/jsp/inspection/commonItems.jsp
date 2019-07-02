<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/6/25
  Time: 14:23
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
                            <li ><a href="inspection/inspectionManagement">检查检验</a></li>
                            <li class="active"><a href="inspection/commonItems">录入结果</a></li>
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
<%--                <th>登记</th>--%>
                <th>记录结果</th>
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">录入结果</h4>
                <input type="text" style="display: none" id="none-i">
            </div>
            <div class="modal-body">
                <input class="form-control" id="inputResult" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="saveResult()">保存结果</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    var inspectionList = null;
    function saveResult(){
        $.ajax({
            type:"POST",
            data: {inspectionId : $("#none-i").val(),result: $("#inputResult").val()},
            url :'inspection/saveResult',
            async: false,
            success :function () {
                alert("结果保存成功");
            },
            error :function(){
                alert("结果保存失败");
            }
        });
    }
    function resultDia(i){
        $("#none-i").val(i);
        $('#myModal').modal('show');
    }
    $(document).ready(function(){
        //设置查找功能按钮
        $("#search").click(function(){
            $.ajax({
                type:"POST",
                data: {medicalNo : $("#searchVal").val()},
                url :'inspection/findDoneRegister',
                success:function(result){
                    inspectionList = result;
                    var str;
                    str = "";
                    $("#inspectionTable").html("");
                    for (var i = 0;i < inspectionList.length;i++){
                        str += "<tr>" +
                            "<td class='col-md-2'><input type=\"text\" class=\"form-control\" value=\"" + inspectionList[i].id + "\" id=\"resultId\" name=\"inspections[" + i + "].id\" readonly/></td>\n" +
                            "<td class='col-md-2'><input type=\"text\" class=\"form-control\" value=\"" + inspectionList[i].medicalRecordNo + "\" id=\"resultNo\" name=\"inspections[" + i + "].medicalRecordNo\"/></td>\n" +
                            "<td class='col-md-2'><input type=\"text\" class=\"form-control\" value=\"" + inspectionList[i].nonDrugListName + "\" name=\"inspections[" + i + "].medicalRecordNo\"/></td>\n" +
                            "<td class='col-md-2'><input type=\"text\" class=\"form-control\" value=\"" + inspectionList[i].registerState + "\" name=\"inspections[" + i + "].registerState\"/></td>\n" +
                            //"<td class='col-md-2'><input type=\"button\" class=\"btn btn-primary\" id = \"register\" value=\"登记\"/></td>\n" +
                            //"<td class='col-md-2' ><button type=\"button\" class=\"btn btn-primary\" value=\"" + inspectionList[i].medicalRecordNo +"\"  id=\"register\" name=\"register\">登记</button></td>\n" +
                            "<td class='col-md-2' ><button type=\"button\" class=\"btn btn-primary \" data-toggle=\"modal\"  value=\"" + inspectionList[i].id + "\" id=\"result\" onclick='resultDia("+ inspectionList[i].id +")'>记录结果</button></td>\n" +
                            "</tr>";
                    }
                    //data-target="#myModal"
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
</body>
</html>
