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
<ol class="breadcrumb container">
    <li><a href="#">首页</a></li>
    <li class="active">排班信息管理</li>
</ol>
<div align="center">
    <h2>医院排班信息管理</h2>
</div>
<form class="container" id="registrationLevelForm">
    <fieldset>
        <div class="">
            <legend class="">排班规则</legend>
        </div>
    </fieldset>
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
            <th>id</th>
            <th>星期</th>
            <th>科室</th>
            <th>排班医生</th>
            <th>号别</th>
            <th>有效状态</th>
            <th>午别</th>
            <th>排班限额</th>
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
        <div class="col-md-4 pull-right">
            <button type="button" id="deleteScheduleInfoButton" class="btn btn-primary">删除已选</button>&nbsp;&nbsp;
            <input type="reset" class="btn btn-default" value="取消" />&nbsp;&nbsp;
            <button type="button" id="updateScheduleInfos" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th>删除</th>
            <th>id</th>
            <th>时间</th>
            <th>排班医生</th>
            <th>科室</th>
            <th>号别</th>
            <th>有效状态</th>
            <th>午别</th>
            <th>剩余名额</th>
            <th>排班限额</th>
        </tr>
        </thead>
        <tbody id="infoTableBody" data-offset="0" data-spy="scroll" style="padding: 0 10px;height: 600px;overflow: auto;position: relative;">
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
                <select class="show-tick form-control" id="registrationLevelIsDefau" name="bisessionalOperation">
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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
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
    //设置排班规则表格
    function setTableBody() {
        var str;
        str = "";
        $("#tableBody").html("");
        for (var i = 0;i < scheduleRules.length;i++){
            str += "<tr>" +
                "<td><input type='checkbox' value='" + scheduleRules[i].id + "'/></td>" +
                "<td><input type='text' class=\"form-control\" value=\"" + scheduleRules[i].id + "\" name=\"scheduleRules[" + i + "].id\" readonly/></td>\n";
            str += "<td><select name=\"scheduleRules[" + i + "].week\" class=\"form-control\">\n";
            str += "<option value = 星期一";
            if (scheduleRules[i].week == "星期一")
                str += "selected";
            str += ">星期一</option>\n";
            str += "<option value = 星期二";
            if (scheduleRules[i].week == "星期二")
                str += "selected";
            str += ">星期二</option>\n";
            str += "<option value = 星期三";
            if (scheduleRules[i].week == "星期三")
                str += "selected";
            str += ">星期三</option>\n";
            str += "<option value = 星期四";
            if (scheduleRules[i].week == "星期四")
                str += "selected";
            str += ">星期四</option>\n";
            str += "<option value = 星期五";
            if (scheduleRules[i].week == "星期五")
                str += "selected";
            str += ">星期五</option>\n";
            str += "<option value = 星期六";
            if (scheduleRules[i].week == "星期六")
                str += "selected";
            str += ">星期六</option>\n";
            str += "<option value = 星期日";
            if (scheduleRules[i].week == "星期日")
                str += "selected";
            str += ">星期日</option>\n";
            str += "</select></td>";
            str += "<td><input type='text' class=\"form-control\" value=\"" + scheduleRules[i].department_name + "\" readonly/></td>\n" +
            "<td><input type='text' class=\"form-control\" value=\"" + scheduleRules[i].userName + "\" readonly/></td>\n" +
            "<td><input type='text' class=\"form-control\" value=\"" + scheduleRules[i].registrationLevelName + "\" readonly/></td>\n" ;
            str += "<td><select name=\"scheduleRules[" + i + "].statusName\" class=\"form-control\">\n";
            if (scheduleRules[i].statusName == "有效"){
                str += "<option value='有效' selected>有效</option>\n";
                str += "<option value='无效'>无效</option>\n";
            }else {
                str += "<option value='有效' >有效</option>\n";
                str += "<option value='无效' selected>无效</option>\n";
            }
            str += "</select></td>";
            str += "<td><select name=\"scheduleRules[" + i + "].bisessionalOperation\" class=\"form-control\">\n";
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
            str += "<td><div class='input-group'><input type=\"text\" class=\"form-control\" value=\"" + scheduleRules[i].schedulQuota + "\" name=\"scheduleRules[" + i + "].schedulQuota\"/><span class=\"input-group-addon\">人</span></div></td>\n" +
                "</tr>";
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
            str += "<tr>" +
                "<td><input type='checkbox' value='" + scheduleInfos[i].id + "'/></td>" +
                "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].id + "\" name=\"scheduleInfos[" + i + "].id\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].scheduleDate + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].userName + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].department_name + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].registrationLevelName + "\" readonly/></td>\n";
            str += "<td><select name=\"scheduleInfos[" + i + "].statusName\" class=\"form-control\">\n";
            if (scheduleInfos[i].statusName == "有效"){
                str += "<option value='有效' selected>有效</option>\n";
                str += "<option value='无效'>无效</option>\n";
            }else {
                str += "<option value='有效' >有效</option>\n";
                str += "<option value='无效' selected>无效</option>\n";
            }
            str += "</select></td>";
            str += "<td><select name=\"scheduleInfos[" + i + "].bisessionalOperation\" class=\"form-control\">\n";
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
                "<td><input type='text' class=\"form-control\" value=\"" + scheduleInfos[i].scheduleQuota + "\" name=\"scheduleInfos[" + i + "].scheduleQuota\"/></td>\n" +
                "</tr>";
        }
        $("#infoTableBody").append(str);
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
        //设置保存按钮功能
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
