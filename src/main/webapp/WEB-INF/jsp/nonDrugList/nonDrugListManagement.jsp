<%--
  Created by IntelliJ IDEA.
  User: GQ
  Date: 2019/6/13
  Time: 11:46
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
    <title>非药品收费目录</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<%--    日期选择控件    --%>
<%--    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">--%>
</head>
<body style="margin-top: 50px">
<ol class="breadcrumb container">
    <li><a href="#">首页</a></li>
    <li class="active">非药品收费目录管理</li>
</ol>
<div align="center">
    <h2>医院非药品收费目录管理</h2>
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
            <th style="width: 30px">id</th>
            <th>项目编码</th>
            <th>项目名称</th>
            <th>规格</th>
            <th>单价</th>
            <th width="140px">费用所属科目</th>
            <th width="180px">执行科室</th>
            <th>拼音助记码</th>
            <th width="100px">项目类型</th>
            <th>创建时间</th>
        </tr>
        </thead>
        <tbody id="tableBody">
        </tbody>
    </table>
</form>
<div align="center"><ul id="pageChoose" class="pagination pagination-lg pageindex">
</ul></div>
<br/>
<fieldset>
    <div class="">
        <legend class="container">查询非药品项目</legend>
    </div>
</fieldset>
<div class="container">
    <div class="col-md-4 container">
        <select class="form-control" id="searchBy" onchange="setSearchValS()" name="searchBy">
            <option value="item_code">项目编码</option>
            <option value="item_name">项目名称</option>
            <option value="item_type">项目类型</option>
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
<form class="" role="form" id="addRegistrationLevel"><div class="container">
    <fieldset>
        <div id="legend" class="">
            <legend class="">添加非药品项目</legend>
        </div>
    </fieldset>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelCodeInput">项目编码</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelCodeInput" name="itemCode"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelNameInput">项目名称</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelNameInput" name="itemName"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelIsDefaultInput">项目规格</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelIsDefaultInput" name="format"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right">单价</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelPriceInput" name="price"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right">费用所属科目</label>
            <div class="col-md-8 input-group">
                <select class="show-tick form-control" id="expenseClassNameInput" name="expenseClassName">
                </select>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelNameInput">执行科室</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" placeholder="科室助记码" id="executiveDepartmentNameInput" name="executivedepartmentName"/>
                    <ul id="executiveDepartmentNameInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                    </ul>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelIsDefaultInput">拼音助记码</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" name="mnemonicCode"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelPriceInput">项目类型</label>
            <div class="col-md-8 input-group">
                <select class="show-tick form-control" name="itemTypeName">
                    <option value="检查" >检查</option>
                    <option value="检验" >检验</option>
                    <option value="处置" >处置</option>
                </select>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-3 control-label text-left" for="registrationLevelIsDefaultInput">创建时间</label>
            <div class="col-md-8 input-group left">
                <input type="date" class="form-control" name="creationTime"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="col-md-2 pull-right">
            <input type="reset" class="btn btn-default" value="清空" />&nbsp;&nbsp;
            <button type="button" id="addRegistrationLevelButton" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;添加&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
</div></form>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<%--<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>--%>
<script type="text/javascript">
    function setSearchValS() {
        var searchByVal = $("#searchBy").val();
        var str = "";
        if (searchByVal == "item_type") {
            str += "<select id=\"searchVal\" class=\"selectpicker show-tick form-control\">\n" +
                "<option value=1>检查</option>\n" +
                "<option value=2>检验</option>\n" +
                "<option value=3>处置</option>";
            str += "</select>";
        }else {
            str += "<input type='text' id='searchVal' class='form-control'/>";
        }
        $("#searchValS").html(str);
    }

    var departments = null;
    //根据拼音助记码动态查询科室
    $(function(){
        //载入时隐藏下拉li
        $("#executiveDepartmentNameInputUl").hide(0);
    });
    $("#executiveDepartmentNameInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#executiveDepartmentNameInput").val().length == 0){
            $("#executiveDepartmentNameInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"department/findByAttribute",
            data: {attribute_name : "department_code",attribute : $("#executiveDepartmentNameInput").val()},
            async: false,
            success:function(result){
                if(result){
                    //setUl(result);
                    var tempdepartments = result;
                    var str = "";
                    //debugger;
                    for (var i = 0;i < tempdepartments.length; i++){
                        str += "<li value='" + tempdepartments[i].departmentName + "'>" + tempdepartments[i].departmentName + "</li>\n";
                    }
                    $("#executiveDepartmentNameInputUl").show(0);
                    $("#executiveDepartmentNameInputUl").html(str);
                }else {
                    alert("无此科室");
                }
            }
        });
    });
    $(function(){
        //按下按键后300毫秒显示下拉提示
        $("#executiveDepartmentNameInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#executiveDepartmentNameInputUl li").hover(function(){
                    $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#executiveDepartmentNameInputUl li").click(function(){
                    $("#executiveDepartmentNameInput").val($(this).html());
                    $("#executiveDepartmentNameInputUl").hide(0);
                });
            }
        });
    });
    //科室表
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
    //挂号等级表
    var nonDrugLists = null;
    //获取指定页非药品数据
    var pageInfo = null;
    function getPageN(pageN) {
        $.ajax({
            type: "POST",
            url: "nonDrugList/listWithPageHelper",
            data: {pageNum : pageN,pageSize : 10},
            success: function (result) {
                pageInfo = result;
                nonDrugLists = pageInfo.list;
                setTableBody();
                setPageChoose();
            },
            error: function () {
                alert("分页信息错误");
            }
        });
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
    //费用所属科目
    var expenseClasses = null;
    $.ajax({
        type: "POST",
        url: "expenseClass/list",
        async: false,
        success: function (result) {
            expenseClasses = result;
        },
        error :function () {
            alert("获取费用科目表失败");
        }
    });
    //设置搜索框类型
    function setExpenseClassInput() {
        var str = "";
        for (let i = 0; i < expenseClasses.length; i++) {
            str += "<option value=\"" + expenseClasses[i].expenseName + "\">" + expenseClasses[i].expenseName + "</option>\n";
        }
        $("#expenseClassNameInput").html(str);
    }
    //设置非药品信息表格
    function setTableBody() {
        var str;
        str = "";
        $("#tableBody").html("");
        for (var i = 0;i < nonDrugLists.length;i++){
            str += "<tr>" +
                "<td ><input type='checkbox' value='" + nonDrugLists[i].id + "'/></td>" +
                "<td ><input type='text' class=\"form-control\" value=\"" + nonDrugLists[i].id + "\" name=\"nonDrugLists[" + i + "].id\" readonly/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + nonDrugLists[i].itemCode + "\" name=\"nonDrugLists[" + i + "].itemCode\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + nonDrugLists[i].itemName + "\" name=\"nonDrugLists[" + i + "].itemName\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + nonDrugLists[i].format + "\" name=\"nonDrugLists[" + i + "].format\"/></td>\n" +
                "<td><div class='input-group'><input type=\"text\" class=\"form-control\" value=\"" + nonDrugLists[i].price + "\" name=\"nonDrugLists[" + i + "].price\"/><span class=\"input-group-addon\">￥</span></div></td>\n";
            str += "<td><select name=\"nonDrugLists[" + i + "].expenseClassName\" class=\"form-control\">\n";
            for(var departmentI = 0;departmentI < expenseClasses.length;departmentI++){
                if (expenseClasses[departmentI].expenseName == nonDrugLists[i].expenseClassName){
                    str += "<option value=\"" + expenseClasses[departmentI].expenseName + "\" selected>" + expenseClasses[departmentI].expenseName + "</option>\n";
                }else {
                    str += "<option value=\"" + expenseClasses[departmentI].expenseName + "\">" + expenseClasses[departmentI].expenseName + "</option>\n";
                }
            }
            str += "</select></td>";
            str += "<td><select name=\"nonDrugLists[" + i + "].executivedepartmentName\" class=\"form-control\">\n";
            for(var departmentI = 0;departmentI < departments.length;departmentI++){
                if (departments[departmentI].departmentName == nonDrugLists[i].executivedepartmentName){
                    str += "<option value=\"" + departments[departmentI].departmentName + "\" selected>" + departments[departmentI].departmentName + "</option>\n";
                }else {
                    str += "<option value=\"" + departments[departmentI].departmentName + "\">" + departments[departmentI].departmentName + "</option>\n";
                }
            }
            str += "</select></td>";
            str += "<td><input type=\"text\" class=\"form-control\" value=\"" + nonDrugLists[i].mnemonicCode + "\" name=\"nonDrugLists[" + i + "].mnemonicCode\"/></td>\n";
            str += "<td><select name=\"nonDrugLists[" + i + "].itemTypeName\" class=\"form-control\">\n";
            if (nonDrugLists[i].itemTypeName == "检查"){
                str += "<option value=\"检查\" selected>检查</option>\n" +
                    "<option value=\"检验\" >检验</option>\n" +
                    "<option value=\"处置\" >处置</option>";
            }else if (nonDrugLists[i].itemTypeName == "检验") {
                str += "<option value=\"检查\" >检查</option>\n" +
                    "<option value=\"检验\" selected>检验</option>\n" +
                    "<option value=\"处置\" >处置</option>";
            }else {
                str += "<option value=\"检查\" >检验</option>\n" +
                    "<option value=\"检验\" >检验</option>\n" +
                    "<option value=\"处置\" selected>处置</option>";
            }
            str += "</select></td>";
            str += "<td><input type=\"text\" class=\"form-control\" value=\"" + nonDrugLists[i].creationdateString + "\" name=\"nonDrugLists[" + i + "].creationTime\" readonly/></td>\n" + "</tr>";
        }
        $("#tableBody").append(str);
    }
    //获取查询过后的带有第N页科室信息的pageInfo
    // var pageInfo = null;
    function getSearchedPageN(pageN) {
        $.ajax({
            type: "POST",
            url: "nonDrugList/findByAttributeWithPageHelper",
            data: {attribute_name : $("#searchBy").val(),attribute : $("#searchVal").val(),pageNum : pageN,pageSize : 10},
            success: function (result) {
                pageInfo = result;
                nonDrugLists = pageInfo.list;
                setTableBody();
                setSearchedPageChoose();
            },
            error: function () {
                alert("分页信息错误");
            }
        });
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
    $(document).ready(function(){
        getPageN(1);
        setExpenseClassInput();
        //设置删除按钮功能
        $("#deleteRegistrationsButton").click(function () {
            var deleteIDs = [];
            $.each($('input:checkbox:checked'),function(){
                deleteIDs.push($(this).val());
            });
            $.ajax({
                type: "POST",
                url: "nonDrugList/deleteNonDrugListsByID",
                data: {idString:deleteIDs.join(',')},
                async: false,
                success: function () {
                    alert("已删除");
                    getPageN(1);
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
                url: "nonDrugList/updateNonDrugLists",
                data: $('#registrationLevelForm').serialize(),
                success: function () {
                    alert("保存成功");
                    getPageN(1);
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
                url: "nonDrugList/addNonDrugList",
                data: $('#addRegistrationLevel').serialize(),
                success: function () {
                    alert("添加成功");
                    getPageN(1);
                }
            });
        });
        //设置查找功能按钮
        $("#search").click(function(){
            getSearchedPageN(1);
        });
    });
</script>
</body>
</html>
