<%--
  Created by IntelliJ IDEA.
  User: GQ
  Date: 2019/6/13
  Time: 21:12
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
    <title>排班信息</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body style="margin-top: 50px">
<div class="container"><div class="row clearfix"><div class="column">
    <nav id="nav" class="navbar navbar-default">
        <a class="navbar-brand">HIS</a>
        <ul class="nav navbar-nav" style="width: 93%">
            <li><a href="user/management">用户管理</a></li>
            <li><a href="department/management">科室管理</a></li>
            <li><a href="registrationLevel/registrationLevelManagement">挂号等级管理</a></li>
            <li><a href="settlementType/settlementTypeManagement">结算类别管理</a></li>
            <li><a href="diagnoseDirectory/diagnoseDirectoryManagement">诊断目录管理</a></li>
            <li><a href="nonDrugList/nonDrugListManagement">非药品目录管理</a></li>
            <li class="active"><a href="schedule/scheduleManagement">排班管理</a></li>
            <li class="active pull-right" style="top: 10px"><input style="top: 10px" class="btn btn-danger" type="button" id="logOutButton" value="退出"/></li>
            <li class="pull-right" id="loginUser"></li>
            <a style="display: none" id="logOut" href="${pageContext.request.contextPath}/logout">退出</a>
        </ul>
    </nav>
</div></div></div>
<div align="center">
    <h2>医院排班管理</h2>
</div>
<form class="container" id="registrationLevelForm">
    <fieldset>
        <div class="">
            <legend class="">排班规则</legend>
        </div>
    </fieldset>
    <div class="row">
        <div class="col-md-3 pull-right">
            <button type="button" id="deleteRegistrationsButton" class="btn btn-primary">删除已选</button>&nbsp;&nbsp;
            <input type="reset" class="btn btn-default" value="取消" />&nbsp;&nbsp;
            <button type="button" id="updateRegistrationLevels" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
    <table class="table table-hover table-striped" >
        <thead>
        <tr>
            <th width="50px">删除</th>
            <th style="display: none">id</th>
            <th style="text-align: center">星期</th>
            <th style="text-align: center">科室</th>
            <th style="text-align: center">排班医生</th>
            <th style="text-align: center">号别</th>
            <th style="text-align: center">有效状态</th>
            <th style="text-align: center">午别</th>
            <th style="text-align: center">排班限额</th>
        </tr>
        </thead>
        <tbody id="tableBody" data-offset="0" data-spy="scroll" style="padding: 0 10px;height: 600px;overflow: auto;position: relative;">
        </tbody>
<%--        <tbody id="tableBody">--%>
<%--        </tbody>--%>
    </table>
</form>
<br/>
<form class="container" id="scheduleInfoForm">
    <fieldset>
        <div class="">
            <legend class="">排班信息</legend>
        </div>
    </fieldset>
    <div class="row">
        <div class="form-group col-md-4">
            <label class="col-md-3 control-label text-left" for="registrationLevelIsDefaultInput">开始时间</label>
            <div class="col-md-8 input-group left">
                <input type="date" id="startTime" class="form-control" name="startTime"/>
            </div>
        </div>
        <div class="form-group col-md-4">
            <label class="col-md-3 control-label text-left" for="registrationLevelIsDefaultInput">结束时间</label>
            <div class="col-md-8 input-group left">
                <input type="date" id="endTime" class="form-control" name="endTime"/>
            </div>
        </div>
        <div style="width: 310px" class=" pull-right">
            <button type="button" id="creatInfo" class="btn btn-primary">生成排班信息</button>&nbsp;&nbsp;
            <input type="reset" class="btn btn-default" value="取消" />&nbsp;&nbsp;
            <button type="button" id="updateScheduleInfos" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
    <table class="table table-hover table-striped">
        <thead style="display: block;width: 1120px;">
            <tr style="display: block;width: 1100px;">
                <th style="display: none">id</th>
                <th style="width: 170px;text-align: center">时间</th>
                <th style="width: 150px;text-align: center">排班医生</th>
                <th style="width: 130px;text-align: center">科室</th>
                <th style="width: 140px;text-align: center">号别</th>
                <th style="width: 130px;text-align: center">有效状态</th>
                <th style="width: 130px;text-align: center">午别</th>
                <th style="width: 130px;text-align: center">剩余名额</th>
                <th style="width: 130px;text-align: center">排班限额</th>
            </tr>
        </thead>
        <tbody id="infoTableBody" data-offset="0" data-spy="scroll" style="padding: 0 10px;height: 600px;display: block;overflow: auto;position: relative;">
        </tbody>
        <%--        <tbody id="tableBody">--%>
        <%--        </tbody>--%>
    </table>
</form>
<br/>
<form class="" role="form" id="addRegistrationLevel"><div class="container">
    <fieldset>
        <div id="legend" class="">
            <legend class="">添加排班规则</legend>
        </div>
    </fieldset>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="nameOfP">姓名</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="nameOfP" name="userName"/>
                    <ul id="nameOfPUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                    </ul>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelCodeInput">星期</label>
            <div class="col-md-8 input-group">
                <select class="show-tick form-control" id="registrationLevelCodeInput" name="week">
                    <option value="星期一" >星期一</option>
                    <option value="星期二" >星期二</option>
                    <option value="星期三" >星期三</option>
                    <option value="星期四" >星期四</option>
                    <option value="星期五" >星期五</option>
                    <option value="星期六" >星期六</option>
                    <option value="星期日" >星期日</option>
                </select>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelIsDefaultInput">午别</label>
            <div class="col-md-8 input-group">
                <select class="show-tick form-control" id="registrationLevelIsDefaultInput" name="bisessionalOperation">
                    <option value="上午" >上午</option>
                    <option value="下午" >下午</option>
                    <option value="全天" >全天</option>
                </select>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelPriceInput">排班限额</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="registrationLevelPriceInput" name="schedulQuota"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="registrationLevelIsDefau">状态</label>
            <div class="col-md-8 input-group">
                <select class="show-tick form-control" id="registrationLevelIsDefau" name="statusName">
                    <option value="有效" >有效</option>
                    <option value="无效" >无效</option>
                </select>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="col-md-2 pull-right">
            <input type="reset" class="btn btn-default" value="清空" />&nbsp;&nbsp;
            <button type="button" id="addRegistrationLevelButton" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;添加&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
</div></form>
<br/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    //根据姓名动态查询用户 排班规则
    $(function(){
        //载入时隐藏下拉li
        $("#nameOfPUl").hide(0);
    });
    $("#nameOfP").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#nameOfP").val().length == 0){
            $("#nameOfPUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"user/findbyattribute",
            data: {attribute_name : "name",attribute : $("#nameOfP").val()},
            async: false,
            success:function(result){
                if(result){
                    var users = result;
                    var str = "";
                    //debugger;
                    for (var i = 0;i < users.length; i++){
                        str += "<li value='" + users[i].name + "'>" + users[i].name + "</li>\n";
                    }
                    $("#nameOfPUl").show(0);
                    $("#nameOfPUl").html(str);
                }else {
                    alert("无此用户");
                }
            }
        });
    });
    $(function(){
        //按下按键后300毫秒显示下拉提示
        $("#nameOfP").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#nameOfPUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#nameOfPUl li").click(function(){
                    $("#nameOfP").val($(this).html());
                    $("#nameOfPUl").hide(0);
                });
            }
        });
    });
    //根据姓名动态查询用户 排班信息
    $(function(){
        //载入时隐藏下拉li
        $("#executiveDepartmentNameInputUl").hide(0);
    });
    $("#nameOfP2").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#nameOfP2").val().length == 0){
            $("#executiveDepartmentNameInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"user/findbyattribute",
            data: {attribute_name : "name",attribute : $("#nameOfP2").val()},
            async: false,
            success:function(result){
                if(result){
                    var users = result;
                    var str = "";
                    //debugger;
                    for (var i = 0;i < users.length; i++){
                        str += "<li value='" + users[i].name + "'>" + users[i].name + "</li>\n";
                    }
                    $("#executiveDepartmentNameInputUl").show(0);
                    $("#executiveDepartmentNameInputUl").html(str);
                }else {
                    alert("无此用户");
                }
            }
        });
    });
    $(function(){
        //按下按键后300毫秒显示下拉提示
        $("#nameOfP2").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#executiveDepartmentNameInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#executiveDepartmentNameInputUl li").click(function(){
                    $("#nameOfP2").val($(this).html());
                    $("#executiveDepartmentNameInputUl").hide(0);
                });
            }
        });
    });
    //排班规则表
    var scheduleRules = null;
    $.ajax({
        type: "POST",
        url: "schedule/scheduleRulesList",
        async: false,
        success: function (result) {
            scheduleRules = result;
        },
        error :function () {
            alert("获取排班规则失败");
        }
    });
    function toDate(str){
        var sd=str.split("-");
        return new Date(sd[0],sd[1]-1,sd[2]);
    }
    // var d1=toDate("2001-2-2 ");
    // debugger;
    // var d2=toDate("2001-2-3");
    // debugger;
    // alert(d1<d2);
    //设置排班规则表格
    function setTableBody() {
        var str;
        str = "";
        $("#tableBody").html("");
        for (var i = 0;i < scheduleRules.length;i++){
            str += "<tr>";
            str += "<td><input type='checkbox' value='" + scheduleRules[i].id + "'/></td>" +
                "<td style='display: none'><input type='text' class=\"form-control\" value=\"" + scheduleRules[i].id + "\" name=\"scheduleRules[" + i + "].id\" readonly/></td>\n";
            str += "<td><select style='width: 120px' name=\"scheduleRules[" + i + "].week\" class=\"form-control\">\n";
            str += "<option value = '星期一' ";
            if (scheduleRules[i].week == "星期一")
                str += "selected";
            str += ">星期一</option>\n";
            str += "<option value = '星期二' ";
            if (scheduleRules[i].week == "星期二")
                str += "selected";
            str += ">星期二</option>\n";
            str += "<option value = '星期三' ";
            if (scheduleRules[i].week == "星期三")
                str += "selected";
            str += ">星期三</option>\n";
            str += "<option value = '星期四' ";
            if (scheduleRules[i].week == "星期四")
                str += "selected";
            str += ">星期四</option>\n";
            str += "<option value = '星期五' ";
            if (scheduleRules[i].week == "星期五")
                str += "selected";
            str += ">星期五</option>\n";
            str += "<option value = '星期六' ";
            if (scheduleRules[i].week == "星期六")
                str += "selected";
            str += ">星期六</option>\n";
            str += "<option value = '星期日' ";
            if (scheduleRules[i].week == "星期日")
                str += "selected";
            str += ">星期日</option>\n";
            str += "</select></td>";
            str += "<td><input type='text' class=\"form-control\" value=\"" + scheduleRules[i].department_name + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + scheduleRules[i].userName + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + scheduleRules[i].registrationLevelName + "\" readonly/></td>\n" ;
            str += "<td><select style='width: 120px' name=\"scheduleRules[" + i + "].statusName\" class=\"form-control\">\n";
            if (scheduleRules[i].statusName == "有效"){
                str += "<option value='有效' selected>有效</option>\n";
                str += "<option value='无效'>无效</option>\n";
            }else {
                str += "<option value='有效' >有效</option>\n";
                str += "<option value='无效' selected>无效</option>\n";
            }
            str += "</select></td>";
            str += "<td><select style='width: 100px' name=\"scheduleRules[" + i + "].bisessionalOperation\" class=\"form-control\">\n";
            if (scheduleRules[i].bisessionalOperation == "上午"){
                str += "<option value='上午' selected>上午</option>\n";
                str += "<option value='下午'>下午</option>\n";
                str += "<option value='全天'>全天</option>\n";
            }else if (scheduleRules[i].bisessionalOperation == "下午") {
                str += "<option value='上午'>上午</option>\n";
                str += "<option value='下午' selected>下午</option>\n";
                str += "<option value='全天'>全天</option>\n";
            }else{
                str += "<option value='上午'>上午</option>\n";
                str += "<option value='下午'>下午</option>\n";
                str += "<option value='全天' selected>全天</option>\n";
            }
            str += "</select></td>";
            str += "<td><div class='input-group'><input type=\"text\" class=\"form-control\" value=\"" + scheduleRules[i].schedulQuota + "\" name=\"scheduleRules[" + i + "].schedulQuota\"/><span class=\"input-group-addon\">人</span></div></td>\n";

            str += "</tr>";
        }
        $("#tableBody").append(str);
    }
    //排班信息表
    var scheduleInfos = null;
    $.ajax({
        type: "POST",
        url: "schedule/scheduleInfosList",
        async: false,
        success: function (result) {
            scheduleInfos = result;
        },
        error :function () {
            alert("获取排班规则失败");
        }
    });
    //设置排班信息表格
    function setInfoTableBody() {
        var str = "";
        $("#infoTableBody").html("");
        for (var i = 0;i < scheduleInfos.length;i++){
            str += "<tr>";
            var now = new Date();
            var scheduleDate = toDate(scheduleInfos[i].scheduleDateString + '');
            if (now > scheduleDate){
                str += "<td><input type='text' class=\"form-control\"value=\"" + scheduleInfos[i].scheduleDateString + "\" readonly/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].userName + "\" readonly/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].department_name + "\" readonly/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].registrationLevelName + "\" readonly/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].statusName + "\" readonly/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].bisessionalOperation + "\" readonly/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].surplusQuota + "\" readonly/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].scheduleQuota + "\" readonly/></td>\n" ;
            } else {
                str += "<td style='display: none'><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].id + "\" name=\"scheduleInfos[" + i + "].id\" readonly/></td>\n" +
                    "<td><input type='date' class=\"form-control\" value=\"" + scheduleInfos[i].scheduleDateString + "\" readonly/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].userName + "\" readonly/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].department_name + "\" readonly/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].registrationLevelName + "\" readonly/></td>\n";
                str += "<td><select style='width: 120px' name=\"scheduleInfos[" + i + "].statusName\" class=\"form-control\">\n";
                if (scheduleInfos[i].statusName == "有效"){
                    str += "<option value='有效' selected>有效</option>\n";
                    str += "<option value='无效'>无效</option>\n";
                }else {
                    str += "<option value='有效' >有效</option>\n";
                    str += "<option value='无效' selected>无效</option>\n";
                }
                str += "</select></td>";
                str += "<td><select style='width: 120px' name=\"scheduleInfos[" + i + "].bisessionalOperation\" class=\"form-control\">\n";
                if (scheduleInfos[i].bisessionalOperation == "上午"){
                    str += "<option value='上午' selected>上午</option>\n";
                    str += "<option value='下午'>下午</option>\n";
                    str += "<option value='全天'>全天</option>\n";
                }else if (scheduleInfos[i].bisessionalOperation == "下午") {
                    str += "<option value='上午'>上午</option>\n";
                    str += "<option value='下午' selected>下午</option>\n";
                    str += "<option value='全天'>全天</option>\n";
                }else{
                    str += "<option value='上午'>上午</option>\n";
                    str += "<option value='下午'>下午</option>\n";
                    str += "<option value='全天' selected>全天</option>\n";
                }
                str += "</select></td>";
                str += "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].surplusQuota + "\" name=\"scheduleInfos[" + i + "].surplusQuota\"/></td>\n" +
                    "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].scheduleQuota + "\" name=\"scheduleInfos[" + i + "].scheduleQuota\"/></td>\n";
            }
            str += "</tr>";
        }
        $("#infoTableBody").append(str);
    }
    $(document).ready(function(){
        $("#loginUser").append("<a>" + "${USER_SESSION.loginName}" + "</a><input style=\"display: none\" id=\"userID\" value='" + ${USER_SESSION.id} + "'/>");
        $("#logOutButton").click(function (){
            document.getElementById("logOut").click();
        });
        setTableBody();
        setInfoTableBody();
        //设置排班规则删除按钮功能
        $("#deleteRegistrationsButton").click(function () {
            var deleteIDs = [];
            $.each($('input:checkbox:checked'),function(){
                deleteIDs.push($(this).val());
            });
            $.ajax({
                type: "POST",
                url: "schedule/deleteScheduleRulesByID",
                data: {idString:deleteIDs.join(',')},
                async: false,
                success: function () {
                    $.ajax({
                        type: "POST",
                        url: "schedule/scheduleRulesList",
                        async: false,
                        success: function (result) {
                            scheduleRules = result;
                            setTableBody();
                        },
                        error :function () {
                            alert("获取排班规则失败");
                        }
                    });
                },
                error :function () {
                    alert("删除失败");
                }

            });
        });
        //设置生成排班信息按钮功能
        $("#creatInfo").click(function () {
            $.ajax({
                type: "POST",
                url: "schedule/createScheduleInfos",
                data: {startTime:$("#startTime").val(),endTime:$("#endTime").val()},
                success: function () {
                    $.ajax({
                        type: "POST",
                        url: "schedule/scheduleInfosList",
                        async: false,
                        success: function (result) {
                            scheduleInfos = result;
                            setInfoTableBody();
                        },
                        error :function () {
                            alert("获取排班信息失败");
                        }
                    });
                },
                error: function () {
                    alert("排班信息生成失败");
                }
            });
        });
        //设置排班规则保存按钮功能
        $("#updateRegistrationLevels").click(function () {
            $.ajax({
                type: "POST",
                url: "schedule/updateScheduleRules",
                data: $('#registrationLevelForm').serialize(),
                success: function () {
                    alert("保存成功");
                },
                error: function () {
                    alert("保存失败");
                }
            });
        });
        //设置排班信息保存按钮功能
        $("#updateScheduleInfos").click(function () {
            $.ajax({
                type: "POST",
                url: "schedule/updateScheduleInfos",
                data: $('#scheduleInfoForm').serialize(),
                success: function () {
                    alert("保存成功");
                },
                error: function () {
                    alert("保存失败");
                }
            });
        });
        //设置排班规则添加按钮
        $("#addRegistrationLevelButton").click(function () {
            $.ajax({
                type: "POST",
                url: "schedule/addScheduleRule",
                data: $('#addRegistrationLevel').serialize(),
                success: function () {
                    alert("添加成功");
                    $.ajax({
                        type: "POST",
                        url: "schedule/scheduleRulesList",
                        async: false,
                        success: function (result) {
                            scheduleRules = result;
                            setTableBody();
                        },
                        error :function () {
                            alert("获取排班规则失败");
                        }
                    });
                },
                error: function () {
                    alert("添加失败");
                }
            });
        });
    });
</script>
</body>
</html>
