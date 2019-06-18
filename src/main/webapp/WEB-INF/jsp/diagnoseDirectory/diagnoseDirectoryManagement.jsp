<%--
  Created by IntelliJ IDEA.
  User: GQ
  Date: 2019/6/13
  Time: 13:44
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
    <title>诊断目录</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
<ol class="breadcrumb container">
    <li><a href="#">首页</a></li>
    <li class="active">诊断目录管理</li>
</ol>
<div align="center">
    <h2>医院诊断目录管理</h2>
</div>
<div class="row" style="padding-left: 20px;padding-right: 1px;margin-left: 3px;margin-right: 3px">
    <div class="col-md-2" style="border: solid 1px #2aabd2;height: 600px;display: block;overflow: auto;padding-left: 5px;padding-right: 5px;width: 180px;">
        <div>
<%--            <label class="text-left">分类查询</label>--%>

            <input type="text" id="executiveDepartmentNameInput" class="form-control"/>
            <button type="button" id="searchBut" class="btn btn-primary">分类查询</button>
<%--            动态查询--%>
            <ul id="executiveDepartmentNameInputUl" style="height: 175px;overflow: auto" class="dropdown-menu">
            </ul>
        </div>
        <ul class="nav nav-tab vertical-tab" style="padding-left: 0px;padding-right: 0px;width: 110px;" role="tablist" id="diagnoseDirectoryTab">
        </ul>
    </div>
    <div class="tab-content vertical-tab-content col-md-10 " style="width: 1300px;height: 600px;display: block;overflow: auto;">
        <form class="container" style="" id="diagnoseTab">
            <div class="row">
                <div class="col-md-3 pull-right">
                    <button type="button" id="deleteRegistrationsButton" class="btn btn-primary">删除已选</button>&nbsp;&nbsp;
                    <input type="reset" class="btn btn-default" value="取消" />&nbsp;&nbsp;
                    <button type="button" id="updateDepartments" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>
                </div>
            </div>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>删除</th>
                    <th>id</th>
                    <th>国际ICD编码</th>
                    <th>疾病名称</th>
                    <th>疾病助记编码</th>
                    <th>所属类型</th>
                </tr>
                </thead>
                <tbody id="diseaseTableBody">
                </tbody>
            </table>
        </form>
    </div>
</div>
<br/>
<fieldset>
    <div class="">
        <legend class="container">查询疾病</legend>
    </div>
</fieldset>
<div class="container">
    <div class="col-md-3 container">
        <input type="text" class="form-control" placeholder="疾病分类" id="diagnoseDirectoryNameInput" name="diagnoseDirectoryName"/>
            <%--                TODO 动态查询 --%>
        <ul id="diagnoseDirectoryNameInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
        </ul>
    </div>
    <div class="col-md-3 container">
        <select class="form-control" id="searchBy" name="searchBy">
            <option value="international_icd_code">国际ICD编码</option>
            <option value="disease_name">疾病名称</option>
        </select>
    </div>
    <div class="col-md-3" id="searchValS">
        <input type='text' id='searchVal' class='form-control'/>
    </div>
    <div class="col-md-3">
        <button type="button" id="search" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;&nbsp;</button>
    </div>
</div>
<br/>
<form class="" role="form" id="addRegistrationLevel"><div class="container">
    <fieldset>
        <div id="legend" class="">
            <legend class="">添加疾病信息</legend>
        </div>
    </fieldset>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="nameOfP">国际ICD编码</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="nameOfP" name="internationalIcdCode "/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelCodeInput">疾病名称</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelCodeInput" name="diseaseName"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelIsDefaultInput">疾病助记编码</label>
            <div class="col-md-8 input-group">
                <input class="show-tick form-control" id="registrationLevelIsDefaultInput" name="diseaseMnemonicCode"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelPriceInput">诊断目录名称</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelPriceInput" name="diagnoseDirectoryName"/>
<%--                TODO 动态查询 --%>
                <ul id="registrationLevelPriceInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                </ul>
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
    var diagnoseDirectories = null;
    var diagnoseDirectoryPageInfo = null;
    //获取第N页诊断目录
    function getDiagnoseDirectoryPageN(pageN) {
        $.ajax({
            type: "POST",
            url: "diagnoseDirectory/listWithPageHelper",
            data: {pageNum : pageN,pageSize : 500},
            async: false,
            success: function (result) {
                diagnoseDirectoryPageInfo = result;
                diagnoseDirectories = diagnoseDirectoryPageInfo.list;
                setDiagnoseDirectoryTab();
            },
            error :function () {
                alert("获取诊断目录失败");
            }
        });
    }
    //获取diagnoseType类的疾病
    var directoryName = null;
    var diseases = null;
    $.ajax({
        type: "POST",
        url: "disease/listFindByDirectory",
        data: {directory : '阿米巴病'},
        async: false,
        success: function (result) {
            diseases = result;
            setDiseaseTableBody();
        },
        error :function () {
            alert("获取排班规则失败");
        }
    });
    function getDiagnose(directoryName) {
        $.ajax({
            type: "POST",
            url: "disease/listFindByDirectory",
            data: {directory : directoryName},
            async: false,
            success: function (result) {
                diseases = result;
                setDiseaseTableBody();
            },
            error :function () {
                alert("获取疾病表失败");
            }
        });
    }
    //根据疾病分类名称动态查询并查找疾病
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
            url :"disease/directoryFindByAttribute",
            data: {attribute : $("#executiveDepartmentNameInput").val()},
            async: false,
            success:function(result){
                if(result){
                    //setUl(result);
                    var tempDirectories = result;
                    var str = "";
                    for (var i = 0;i < tempDirectories.length; i++){
                        str += "<li value='" + tempDirectories[i].diseaseCategoryName + "'>" + tempDirectories[i].diseaseCategoryName + "</li>\n";
                    }
                    $("#executiveDepartmentNameInputUl").show(0);
                    $("#executiveDepartmentNameInputUl").html(str);
                }else {
                    alert("无此疾病");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
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
                    // getDiagnose($("#executiveDepartmentNameInput").val());
                });
            }
        });
    });
    //根据疾病分类名称动态查询1
    $(function(){
        //载入时隐藏下拉li
        $("#diagnoseDirectoryNameInputUl").hide(0);
    });
    $("#diagnoseDirectoryNameInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#diagnoseDirectoryNameInput").val().length == 0){
            $("#diagnoseDirectoryNameInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"disease/directoryFindByAttribute",
            data: {attribute : $("#diagnoseDirectoryNameInput").val()},
            async: false,
            success:function(result){
                if(result){
                    //setUl(result);
                    var tempDirectories = result;
                    var str = "";
                    for (var i = 0;i < tempDirectories.length; i++){
                        str += "<li value='" + tempDirectories[i].diseaseCategoryName + "'>" + tempDirectories[i].diseaseCategoryName + "</li>\n";
                    }
                    $("#diagnoseDirectoryNameInputUl").show(0);
                    $("#diagnoseDirectoryNameInputUl").html(str);
                }else {
                    alert("无此疾病");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#diagnoseDirectoryNameInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#diagnoseDirectoryNameInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#diagnoseDirectoryNameInputUl li").click(function(){
                    $("#diagnoseDirectoryNameInput").val($(this).html());
                    $("#diagnoseDirectoryNameInputUl").hide(0);
                });
            }
        });
    });
    //根据疾病分类名称动态查询2
    $(function(){
        //载入时隐藏下拉li
        $("#registrationLevelPriceInputUl").hide(0);
    });
    $("#registrationLevelPriceInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#registrationLevelPriceInput").val().length == 0){
            $("#registrationLevelPriceInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"disease/directoryFindByAttribute",
            data: {attribute : $("#registrationLevelPriceInput").val()},
            async: false,
            success:function(result){
                if(result){
                    //setUl(result);
                    var tempDirectories = result;
                    var str = "";
                    for (var i = 0;i < tempDirectories.length; i++){
                        str += "<li value='" + tempDirectories[i].diseaseCategoryName + "'>" + tempDirectories[i].diseaseCategoryName + "</li>\n";
                    }
                    $("#registrationLevelPriceInputUl").show(0);
                    $("#registrationLevelPriceInputUl").html(str);
                }else {
                    alert("无此疾病");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#registrationLevelPriceInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#registrationLevelPriceInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#registrationLevelPriceInputUl li").click(function(){
                    $("#registrationLevelPriceInput").val($(this).html());
                    $("#registrationLevelPriceInputUl").hide(0);
                });
            }
        });
    });
    //设置诊断目录分类表
    function setDiagnoseDirectoryTab() {
        var str;
        str = "";
        $("#diagnoseDirectoryTab").html("");
        for (var i = 0;i < diagnoseDirectories.length;i++){
            str += "<li role=\"presentation\">\n" +
                "<a onclick=\"getDiagnose('" + diagnoseDirectories[i].diseaseCategoryName +"')\" role=\"tab\">" + diagnoseDirectories[i].diseaseCategoryName + "</a>\n" +
                "</li>";
        }
        $("#diagnoseDirectoryTab").append(str);
    }
    //设置疾病信息表格
    function setDiseaseTableBody() {
        var str;
        str = "";
        $("#diseaseTableBody").html("");
        for (var i = 0;i < diseases.length;i++){
            str += "<tr>" +
                "<td><input type='checkbox' value='" + diseases[i].id + "'/></td>" +
                "<td class='col-md-1'><input type='text' class=\"form-control\" value=\"" + diseases[i].id + "\" name=\"diseases[" + i + "].id\" readonly/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + diseases[i].internationalIcdCode + "\" name=\"diseases[" + i + "].internationalIcdCode\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + diseases[i].diseaseName + "\" name=\"diseases[" + i + "].diseaseName\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + diseases[i].diseaseMnemonicCode + "\" name=\"diseases[" + i + "].diseaseMnemonicCode\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + diseases[i].diagnoseDirectoryName + "\" name=\"diseases[" + i + "].diagnoseDirectoryName\"/></td>\n" +
                "</tr>";
        }
        $("#diseaseTableBody").append(str);
    }

    $(document).ready(function(){
        getDiagnoseDirectoryPageN(1);
        //设置分类查询功能
        $("#searchBut").click(function () {
            getDiagnose($("#executiveDepartmentNameInput").val());
        });
        //设置保存按钮功能
        $("#updateDepartments").click(function () {
            $.ajax({
                type: "POST",
                url: "disease/updateDiseases",
                data: $('#diagnoseTab').serialize(),
                success: function () {
                    alert("保存成功");
                },
                error: function () {
                    alert("保存失败");
                }
            });
        });
        //设置疾病删除按钮功能
        $("#deleteRegistrationsButton").click(function () {
            var deleteIDs = [];
            $.each($('input:checkbox:checked'),function(){
                deleteIDs.push($(this).val());
            });
            $.ajax({
                type: "POST",
                url: "disease/deleteDiseaseByID",
                data: {idString:deleteIDs.join(',')},
                async: false,
                success: function () {
                    alert("删除成功");
                    $.ajax({
                        type: "POST",
                        url: "disease/listFindByDirectory",
                        data: {directory : '阿米巴病'},
                        async: false,
                        success: function (result) {
                            diseases = result;
                            setDiseaseTableBody();
                        },
                        error :function () {
                            alert("获取疾病信息失败");
                        }
                    });
                },
                error :function () {
                    alert("删除失败");
                }

            });
        });
        //设置疾病添加按钮
        $("#addRegistrationLevelButton").click(function () {
            $.ajax({
                type: "POST",
                url: "disease/addDisease",
                data: $('#addRegistrationLevel').serialize(),
                success: function () {
                    alert("添加成功");
                    $.ajax({
                        type: "POST",
                        url: "disease/listFindByDirectory",
                        data: {directory : '阿米巴病'},
                        async: false,
                        success: function (result) {
                            diseases = result;
                            setDiseaseTableBody();
                        },
                        error :function () {
                            alert("获取疾病信息失败");
                        }
                    });
                },
                error: function () {
                    alert("添加失败");
                }
            });
        });
        //设置查找功能按钮
        $("#search").click(function(){
            if ($("#diagnoseDirectoryNameInput").val() == "") {
                $.ajax({
                    type: "POST",
                    url: "disease/findByAttributeWithTwoParameters",
                    data: {attribute_name : $("#searchBy").val(),attribute : $("#searchVal").val()},
                    success: function (result) {
                        diseases = result;
                        setDiseaseTableBody();
                    },
                    error: function () {
                        alert("查找出错");
                    }
                });
            }else {
                $.ajax({
                    type: "POST",
                    url: "disease/findByAttribute",
                    data: {directory_name : $("#diagnoseDirectoryNameInput").val(),attribute_name : $("#searchBy").val(),attribute : $("#searchVal").val()},
                    success: function (result) {
                        diseases = result;
                        setDiseaseTableBody();
                    },
                    error: function () {
                        alert("查找出错");
                    }
                });
            }
        });
    });
</script>
</body>
</html>
