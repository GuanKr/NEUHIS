<%--
  Created by IntelliJ IDEA.
  User: GQ
  Date: 2019/6/26
  Time: 9:22
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
    <title>收费管理</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css">
</head>
<body style="margin-top: 50px">
<%--缴费对话框--%>
<div id="chargeDialog" title="缴费"  style="display: none" >
    <form>
        <p>应收：<input type="text" class="form-control" id="shouldInput" readonly/></p>
        <p>实收：<input type="text" class="form-control" id="realInput" /></p>
        <div style="float: right;">
            <input type="button" class="btn btn-primary" value="确定" onclick="closeDialog()"/>
            <input style="display: none" type="reset" id="chargeDialogReset"/>
        </div>
    </form>
</div>
<%--导航栏--%>
<div class="container"><div class="row clearfix"><div class="column">
    <nav id="nav" class="navbar navbar-default">
        <a class="navbar-brand">HIS</a>
        <ul class="nav navbar-nav" style="width: 93%">
            <li><a href="registration/registrationInfo">现场挂号</a></li>
            <li class="active"><a href="charge/chargeManagement">门诊收费</a></li>
            <li class="active pull-right" style="top: 10px"><input style="top: 10px" class="btn btn-danger" type="button" id="logOutButton" value="退出"/></li>
            <li class="pull-right" id="loginUser"></li>
            <a style="display: none" id="logOut" href="${pageContext.request.contextPath}/logout">退出</a>
            <li style="display: none"><input id="doctorID"/></li>
        </ul>
    </nav>
</div></div></div>
<%--<nav id="nav" class="navbar navbar-default">--%>
<%--    <a href="#" class="navbar-brand">首页</a>--%>
<%--    <ul class="nav navbar-nav" style="width: 93%">--%>
<%--        <li class="active"><a>门诊收费</a></li>--%>
<%--        <li class="dropdown pull-right" style="position: relative;right: 5px;">--%>
<%--            <select style="margin-top: 10px" class="form-control" id="doctorID">--%>
<%--            </select>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</nav>--%>
<div align="center">
    <h2>门诊收费管理</h2>
</div>
<form class="" role="form" id="registrationInfo"><div class="container">
    <div class="col-md-2 pull-right">
        <button type="button" onclick="findRegistrationInfo()" class="btn btn-primary">查找</button>&nbsp;&nbsp;
    </div>
    <fieldset>
        <div id="legend" class="">
            <legend class="">挂号信息</legend>
        </div>
    </fieldset>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="medicalRecordNoInput">病历号</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="medicalRecordNoInput" name="medicalRecordNo"/>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="patientNameInput">姓名</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="patientNameInput" name="patientName" readonly/>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="patientIdentityNumberInput">身份证号</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="patientIdentityNumberInput" name="patientIdentityNumber" readonly/>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right">性别</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="patientSexInput" name="patientSex" readonly/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-4">
            <label class="col-md-4 control-label text-right" for="patientBirthdayInput">出生日期</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="patientBirthdayInput" name="patientBirthday" readonly/>
            </div>
        </div>
        <div class="form-group col-md-2">
            <label class="col-md-5 control-label text-right">年龄</label>
            <div class="col-md-7 input-group">
                <input class="show-tick form-control" id="patientAgeInput" name="patientAge" readonly/>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right">地址</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="addressInput" name="address" readonly/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right">号别</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelNameInput" name="registrationLevelName" readonly/>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-left">结算类别</label>
            <div class="col-md-8 input-group left">
                <input type="text" class="form-control" id="settlementTypeNameInput" name="settlementTypeName" readonly/>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-left">病历本</label>
            <div class="col-md-8 input-group left">
                <input type="text" class="form-control" id="isNeedMedicalRecordBookInput" name="isNeedMedicalrecordbook" readonly/>
            </div>
        </div>
    </div>
    <div class="row">
    </div>
</div></form>
<br/>
<!-- 导航区 -->
<ul class="container nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">未缴费项目</a></li>
    <li role="presentation"><a href="#profile" role="tab" data-toggle="tab">已缴费项目</a></li>
</ul>
<!-- 面板区 -->
<div class="container tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">
        <br>
        <form class="container" id="chargeInfosForm">
            <div class="col-md-3 pull-right">
                <b style="float: left">总金额：</b>
                <input type="text" class="form-control" style="width: 80px;float: left" id="totalCost" readonly/>&nbsp;&nbsp;
                <button type="button" id="deleteRegistrationsButton" onclick="showChargeDialog()" class="btn btn-primary">缴费</button>&nbsp;&nbsp;
            </div>
            <fieldset>
                <div class="">
                    <legend class="">未缴费项目列表</legend>
                </div>
            </fieldset>
            <div class="center-block" style="overflow: auto;width: 100%;">
                <form id="itemsForm">
                    <table class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>项目</th>
                            <th>规格</th>
                            <th>单价</th>
                            <th>数量</th>
                            <th>费用</th>
                            <th>执行科室</th>
                            <th>类型</th>
                            <th>开立医生</th>
                            <th>所属科室</th>
                        </tr>
                        </thead>
                        <tbody id="tableBody">
                        </tbody>
                    </table>
                </form>
            </div>
        </form>
    </div>
    <div role="tabpanel" class="tab-pane" id="profile">
        <br>
        <div class="col-md-2 pull-right">
            <b style="float: left">总金额：</b>
            <input type="text" class="form-control" style="width: 80px;float: left" id="paymentTotalCost" readonly/>
        </div>
        <fieldset>
            <div class="">
                <legend class="">已缴费项目列表</legend>
            </div>
        </fieldset>
        <div class="center-block" style="overflow: auto;width: 100%;">
            <form id="paymentItemsForm">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>发票号</th>
                        <th>项目</th>
                        <th>金额</th>
                        <th>类型</th>
                        <th>结算方式</th>
                        <th>开立科室</th>
                        <th>执行科室</th>
                        <th>缴费时间</th>
                    </tr>
                    </thead>
                    <tbody id="paymentTableBody">
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript">
    //缴费弹出框
    function showChargeDialog() {
        $("#shouldInput").val(cost + "元");
        $('#chargeDialog').dialog({
            modal:true,
            width:"500",
            height:"400"
        });
        document.getElementById("chargeDialog").style.display="block";
    }
    //缴费弹出框的确定按钮
    function closeDialog() {
        $('#chargeDialog').dialog("close");
        charge();
        $("#chargeDialogReset").click();
    }
    //病例查找
    function findRegistrationInfo() {
        if ($("#medicalRecordNoInput").val() == ""){
            alert("请输入病历号");
        } else {
            $.ajax({
                type:"POST",
                url: "registration/findByAttribute",
                async: false,
                data: {attribute_name : "medical_record_no",attribute : $("#medicalRecordNoInput").val()},
                success: function (result) {
                    var registrationInfo = result.data;
                    if (registrationInfo == null){
                        alert("无此病例");
                    } else {
                        $("#patientNameInput").val(registrationInfo.patientName);
                        $("#patientIdentityNumberInput").val(registrationInfo.patientIdentityNumber);
                        $("#patientSexInput").val(registrationInfo.patientSex);
                        $("#patientBirthdayInput").val(registrationInfo.patientBirthdayString);
                        $("#patientAgeInput").val(registrationInfo.patientAge);
                        $("#addressInput").val(registrationInfo.address);
                        $("#registrationLevelNameInput").val(registrationInfo.registrationLevelName);
                        $("#settlementTypeNameInput").val(registrationInfo.settlementTypeName);
                        $("#isNeedMedicalRecordBookInput").val(registrationInfo.isNeedMedicalrecordbook);
                        //查找未缴费与已缴费项目
                        findItemsAndCost();
                        findPaymentItems();
                    }
                },
                error :function () {
                    alert("获取挂号信息失败");
                }
            });
        }
    }
    //未收费项目列表
    var items = null;
    //应收金额
    var cost = 0;
    //收费项目查找
    function findItemsAndCost() {
        $.ajax({
            type: "POST",
            url: "charge/findUnpaidItem",
            async: false,
            data: {medicalNo : $("#medicalRecordNoInput").val()},
            success: function (result) {
                items = result.items;
                if (items.length == 0){
                    alert("无未缴费项目");
                } else {
                    cost = result.cost;
                    $("#totalCost").val(cost + "元");
                    setTableBody();
                }
            }
        });
    }
    //生成收费项目表
    function setTableBody() {
        var str = "";
        $("#tableBody").html("");
        for (let i = 0; i < items.length; i++) {
            var format = "";
            if (items[i].format != null) {
                format = items[i].format;
            }
            str += "<tr>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].itemName + "' name='items[" + i + "].itemName' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + format + "' name='items[" + i + "].format' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].unitPrice + "元' name='items[" + i + "].unitPrice' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].quantity + "' name='items[" + i + "].quantity' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].cost + "元' name='items[" + i + "].cost' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].departmentName + "' name='items[" + i + "].departmentName' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].category + "' name='items[" + i + "].category' readonly/></th>\n" +
                "<th style='display: none'><input  type=\"text\" class='form-control' value='" + items[i].categoryId + "' name='items[" + i + "].categoryId' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].doctorName + "' name='items[" + i + "].doctorName' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].drawBillDepartmentName + "' name='items[" + i + "].drawBillDepartmentName' readonly/></th>\n" +
                "</tr>";
        }
        $("#tableBody").append(str);
    }
    //已收费项目列表
    var paymentItems = null;
    //已收金额
    var paymentCost = 0;
    //已收费项目查找
    function findPaymentItems() {
        $.ajax({
            type: "POST",
            url: "charge/findByMedNo",
            async: false,
            data: {medicalNo : $("#medicalRecordNoInput").val()},
            success: function (result) {
                if (result.status == "OK"){
                    paymentItems = result.data;
                    setPaymentTableBody();
                }
            }
        });
    }
    //生成已收费项目表
    function setPaymentTableBody() {
        var str = "";
        paymentCost = 0;
        $("#paymentTableBody").html("");
        for (let i = 0; i < paymentItems.length; i++) {
            str += "<tr>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + paymentItems[i].invoiceNo + "' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + paymentItems[i].itemName + "' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + paymentItems[i].cost + "元' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + paymentItems[i].costType + "' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + paymentItems[i].settlementTypeName + "' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + paymentItems[i].drawBillDepartmentName + "' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + paymentItems[i].executiveDepartmentName + "' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + paymentItems[i].patientName + "' readonly/></th>\n" +
                "</tr>";
            paymentCost += paymentItems[i].cost;
        }
        $("#paymentTableBody").append(str);
        paymentCost = paymentCost.toFixed(2);
        $("#paymentTotalCost").val(paymentCost + "元");
    }

    //缴费
    function charge() {
        if($("#doctorID").val() == ""){
            alert("请先登录");
        }else {
            var dataString = JSON.stringify({"tollCollectorId":$("#doctorID").val(),"patientName":$("#patientNameInput").val(),"medicalNo":$("#medicalRecordNoInput").val(),"settlementType":$("#settlementTypeNameInput").val(),"items":items});
            $.ajax({
                type: "POST",
                url: "charge/charge",
                async: false,
                data: dataString,
                contentType: 'application/json;charset=utf-8',
                success: function () {
                    // var money = Number($("#realInput").val()) - cost;
                    var money = $("#realInput").val() - cost;
                    money = money.toFixed(2);
                    alert("找零：" + money +"元，缴费成功");
                    $("#totalCost").val("");
                    $("#tableBody").html("");
                    findPaymentItems()
                }
            });
        }
    }
    // //医生列表
    // var doctors = null;
    // $.ajax({
    //     type: "POST",
    //     url: "user/findbyattribute",
    //     data: {attribute_name : "role_name",attribute : "挂号收费员"},
    //     success: function (result) {
    //         doctors = result;
    //         setDoctorIDBody();
    //     }
    // });
    // //设置登录选项
    // function setDoctorIDBody(){
    //     var str;
    //     str = "<option value=''>登录</option>";
    //     $("#doctorID").html("");
    //     for (let i = 0;i < doctors.length;i++){
    //         str += "<option value=\"" + doctors[i].id + "\">" + doctors[i].name + "</option>\n";
    //     }
    //     $("#doctorID").append(str);
    // }

    $(document).ready(function () {
        $("#loginUser").append("<a>" + "${USER_SESSION.loginName}" + "</a><input style=\"display: none\" id=\"userID\" value='" + ${USER_SESSION.id} + "'/>");
        $("#doctorID").val(${USER_SESSION.id});
        $("#logOutButton").click(function (){
            document.getElementById("logOut").click();
        });
        // alert("请登录");
    });
</script>
</body>
</html>
