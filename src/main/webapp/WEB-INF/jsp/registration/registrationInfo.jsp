<%--
  Created by IntelliJ IDEA.
  User: GQ
  Date: 2019/6/17
  Time: 13:30
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
    <title>挂号</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body style="margin-top: 50px">
<ol class="breadcrumb container">
    <li><a href="#">首页</a></li>
    <li class="active">挂号</li>
</ol>
<div align="center">
    <h2>挂号信息</h2>
</div>
<form class="" role="form" id="registrationInfo"><div class="container">
    <fieldset>
        <div id="legend" class="">
            <legend class="">挂号信息</legend>
        </div>
    </fieldset>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="medicalRecordNoInput">病历号</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="medicalRecordNoInput" name="medicalRecordNo" readonly/>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="patientNameInput">姓名</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="patientNameInput" name="patientName"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="patientIdentityNumberInput">身份证号</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" id="patientIdentityNumberInput" name="patientIdentityNumber"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right">性别</label>
            <div class="col-md-8 input-group">
                <select type="text" class="form-control" id="patientSexInput" name="patientSex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-4">
            <label class="col-md-4 control-label text-right" for="patientBirthdayInput">出生日期</label>
            <div class="col-md-8 input-group">
                <input type="date" class="form-control" onchange="setPatientAge()" id="patientBirthdayInput" name="patientBirthday"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-2">
            <label class="col-md-5 control-label text-right">年龄</label>
            <div class="col-md-7 input-group">
                <input class="show-tick form-control" id="patientAgeInput" name="patientAge"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right">地址</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" name="address"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-left">挂号来源</label>
            <div class="col-md-8 input-group left">
                <select class="form-control" name="registrationResource">
                    <option value="医院挂号">医院挂号</option>
                    <option value="预约挂号">预约挂号</option>
                </select>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right">号别</label>
            <div class="col-md-8 input-group">
                <select class="show-tick form-control" id="registrationLevelNameInput" name="registrationLevelName">
                </select>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right" for="departmentNameInput">挂号科室</label>
            <div class="col-md-8 input-group">
                <input type="text" class="form-control" placeholder="输入助记码" id="departmentNameInput" name="departmentName"/>
                <ul id="departmentNameInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                </ul>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-4">
            <label class="col-md-4 control-label text-right">看诊日期</label>
            <div class="col-md-8 input-group">
                <input type="datetime-local" onchange="setUsableDoctors()" id="displaySeeDoctorDate" name="seeDoctorDateString" class="show-tick form-control"/>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-right">看诊医生</label>
            <div class="col-md-8 input-group">
                <select  class="form-control" id="doctorNameInput" name="doctorName">
                </select>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-left">结算类别</label>
            <div class="col-md-8 input-group left">
                <select class="form-control" id="settlementTypeNameInput" name="settlementTypeName">
                </select>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-left">病历本</label>
            <div class="col-md-8 input-group left">
                <select class="form-control" onchange="setExpenseInput()" name="isNeedMedicalrecordbook">
                    <option value=""></option>
                    <option value="需要">需要</option>
                    <option value="不需要">不需要</option>
                </select>
                <span class="input-group-addon" style="color: red">*</span>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-4 control-label text-left">金额</label>
            <div class="col-md-8 input-group left">
                <input class="form-control" id="expenseInput" name="expense" readonly/>
                <span class="input-group-addon" style="color: black">￥</span>
            </div>
        </div>
        <div class="col-md-2 pull-right">
            <input type="reset" class="btn btn-default" value="清空" />&nbsp;&nbsp;
            <button type="button" id="registrationButton" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;挂号&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
</div></form>
<br/>
<form class="container" id="registrationInfosForm">
    <fieldset>
        <div class="">
            <legend class="">挂号信息列表</legend>
        </div>
    </fieldset>
<%--    <div class="row">--%>
<%--        <div class="col-md-4 pull-right">--%>
<%--            <button type="button" id="deleteRegistrationsButton" class="btn btn-primary">删除已选</button>&nbsp;&nbsp;--%>
<%--            <input type="reset" class="btn btn-default" value="取消" />&nbsp;&nbsp;--%>
<%--            <button type="button" id="updateRegistrationLevels" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="center-block" style="overflow: auto;width: 2000px;">
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>病历号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>出生日期</th>
                <th>身份证号</th>
                <th>家庭住址</th>
                <th>结算类别</th>
                <th>挂号级别</th>
                <th>看诊日期</th>
                <th>是否已诊</th>
                <th>病历本</th>
                <th>挂号来源</th>
                <th>状态</th>
                <th>应收金额</th>
                <th>缴费状态</th>
                <th>挂号科室</th>
                <th>挂号医生</th>
            </tr>
            </thead>
            <tbody id="tableBody">
            </tbody>
        </table>
    </div>

</form>
<div align="center"><ul id="pageChoose" class="pagination pagination-lg pageindex">
</ul></div>
<br/>
<%--TODO 删除注释--%>
<%--<fieldset>--%>
<%--    <div class="">--%>
<%--        <legend class="container">查询非药品项目</legend>--%>
<%--    </div>--%>
<%--</fieldset>--%>
<%--<div class="container">--%>
<%--    <div class="col-md-4 container">--%>
<%--        <select class="form-control" id="searchBy" onchange="setSearchValS()" name="searchBy">--%>
<%--            <option value="item_code">项目编码</option>--%>
<%--            <option value="item_name">项目名称</option>--%>
<%--            <option value="item_type">项目类型</option>--%>
<%--        </select>--%>
<%--    </div>--%>
<%--    <div class="col-md-4" id="searchValS">--%>
<%--        <input type='text' id='searchVal' class='form-control'/>--%>
<%--    </div>--%>
<%--    <div class="col-md-4">--%>
<%--        <button type="button" id="search" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;&nbsp;</button>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<br/><br/><br/>--%>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    //获取病历号
    $.ajax({
        type: "POST",
        url: "registration/getMedicalRecordNo",
        async: false,
        success: function (result) {
            var medicalRecordNo = result;
            $("#medicalRecordNoInput").val(medicalRecordNo);
        },
        error :function () {
            alert("获取病历号失败");
        }
    });
    //设置号别
    var registrationLevels = null;
    $.ajax({
        type: "POST",
        url: "registrationLevel/list",
        async: false,
        success: function (result) {
            registrationLevels = result;
            setRegistrationLevelNameInput();
        },
        error :function () {
            alert("获取挂号级别表失败");
        }
    });
    function setRegistrationLevelNameInput() {
        var str = "";
        for (let i = 0; i < registrationLevels.length; i++) {
            str += "<option value=\"" + registrationLevels[i].levelName + "\">" + registrationLevels[i].levelName + "</option>\n";
        }
        $("#registrationLevelNameInput").html(str);
    }
    //结算类别
    var settlementTypes = null;
    $.ajax({
        type: "POST",
        url: "settlementType/list",
        async: false,
        success: function (result) {
            settlementTypes = result;
            setSettlementTypeInput();
        },
        error :function () {
            alert("获取挂号级别表失败");
        }
    });
    function setSettlementTypeInput() {
        var str = "";
        for (let i = 0; i < settlementTypes.length; i++) {
            str += "<option value=\"" + settlementTypes[i].settlementTypeName + "\">" + settlementTypes[i].settlementTypeName + "</option>\n";
        }
        $("#settlementTypeNameInput").html(str);
    }
    //设置医生
    var doctors = null;
    $.ajax({
        type: "POST",
        url: "user/list",
        async: false,
        success: function (result) {
            doctors = result;
            setDoctorNameInput();
        },
        error :function () {
            alert("获取医生表失败");
        }
    });
    function setDoctorNameInput() {
        var str = "";
        for (let i = 0; i < doctors.length; i++) {
            str += "<option value=\"" + doctors[i].name + "\">" + doctors[i].name + "</option>\n";
        }
        $("#doctorNameInput").html(str);
    }
    // $("#departmentNameInput")
    //获取医生
    function setUsableDoctors(){
        $.ajax({
            type: "POST",
            url: "registration/getDoctorList",
            data:$('#registrationInfo').serialize(),
            async: false,
            success: function (result) {
                doctors = result;
                setDoctorNameInput();
            },
            error :function () {
                alert("获取医生表失败");
            }
        });
    }
    //计算年龄
    function setPatientAge(){
        $.ajax({
            type: "POST",
            url: "registration/getPatientAge",
            data:{birthdayString : $('#patientBirthdayInput').val()},
            async: false,
            success: function (result) {
                $("#patientAgeInput").val(result);
            },
            error :function () {
                alert("年龄计算失败失败");
            }
        });
    }
    //根据科室助记码动态查询
    $(function(){
        //载入时隐藏下拉li
        $("#departmentNameInputUl").hide(0);
    });
    $("#departmentNameInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#departmentNameInput").val().length == 0){
            $("#departmentNameInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"department/findByAttribute",
            data: {attribute_name : "department_code",attribute : $("#departmentNameInput").val()},
            async: false,
            success:function(result){
                if(result){
                    //setUl(result);
                    var tempDepartments = result;
                    var str = "";
                    for (var i = 0;i < tempDepartments.length; i++){
                        str += "<li value='" + tempDepartments[i].departmentName + "'>" + tempDepartments[i].departmentName + "</li>\n";
                    }
                    $("#departmentNameInputUl").show(0);
                    $("#departmentNameInputUl").html(str);
                }else {
                    alert("无此科室");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#departmentNameInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#departmentNameInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#departmentNameInputUl li").click(function(){
                    $("#departmentNameInput").val($(this).html());
                    $("#departmentNameInputUl").hide(0);
                });
            }
        });
    });
    //计算挂号费用
    function setExpenseInput(){
        $.ajax({
            type: "POST",
            url: "registration/getExpense",
            data:$('#registrationInfo').serialize(),
            async: false,
            success: function (result) {
                //TODO 测试
                $("#expenseInput").val(result);
            },
            error :function () {
                alert("获取挂号费用失败");
            }
        });
    }
    var registrationInfoList = null;
    $.ajax({
        type:"POST",
        url: "registration/registrationInfoList",
        async: false,
        success: function (result) {
            registrationInfoList = result;
        },
        error :function () {
            alert("获取挂号列表失败");
        }
    });
    //设置挂号信息表格
    function setTableBody() {
        var str;
        str = "";
        $("#tableBody").html("");
        for (var i = 0;i < registrationInfoList.length;i++){
            str += "<tr>" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].id + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].medicalRecordNo + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].patientName + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].patientSex + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].patientAge + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].patientBirthdayString + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].patientIdentityNumber + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].address + "\" readonly/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + registrationInfoList[i].settlementTypeName + "\" readonly/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + registrationInfoList[i].registrationLevelName + "\" readonly/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\"" + registrationInfoList[i].seeDoctorDateString + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].isSeenDoctor + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].isNeedMedicalrecordbook + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].registrationResource + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].registrationState + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].expense + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].paymentState + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].departmentName + "\" readonly/></td>\n" +
                "<td><input type='text' class=\"form-control\" value=\"" + registrationInfoList[i].doctorName + "\" readonly/></td>\n" +
                "<td><button type='button' class=\"form-control\" onclick='withdraw(" + registrationInfoList[i].id + ")' >退号</button></td>\n" +
                "</tr>";
        }
        $("#tableBody").append(str);
    }
    function withdraw(id){
        $.ajax({
            type: "POST",
            url: "registration/withdraw",
            data: {id : id},
            success: function (result) {
                alert(result);
                $.ajax({
                    type:"POST",
                    url: "registration/registrationInfoList",
                    async: false,
                    success: function (result) {
                        registrationInfoList = result;
                        setTableBody();
                    },
                    error :function () {
                        alert("获取挂号列表失败");
                    }
                });
            },
            error: function () {
                alert("退号失败");
            }
        });
    }
    //获取查询过后的带有第N页科室信息的pageInfo
    // var pageInfo = null;
    // function getSearchedPageN(pageN) {
    //     $.ajax({
    //         type: "POST",
    //         url: "nonDrugList/findByAttributeWithPageHelper",
    //         data: {attribute_name : $("#searchBy").val(),attribute : $("#searchVal").val(),pageNum : pageN,pageSize : 10},
    //         success: function (result) {
    //             pageInfo = result;
    //             nonDrugLists = pageInfo.list;
    //             setTableBody();
    //             setSearchedPageChoose();
    //         },
    //         error: function () {
    //             alert("分页信息错误");
    //         }
    //     });
    // }
    // //设置搜索后的分页选择栏
    // function setSearchedPageChoose() {
    //     var str;
    //     str = "";
    //     $("#pageChoose").html("");
    //     for (var i = 1;i <= pageInfo.pages; i++){
    //         if(pageInfo.pageNum == i){
    //             str += "<li class=\"active\"><a onclick='getSearchedPageN(" + i + ")'>" + i + "</a></li>";
    //         }else {
    //             str += "<li><a onclick='getSearchedPageN(" + i + ")'>" + i + "</a></li>";
    //         }
    //     }
    //     $("#pageChoose").append(str);
    // }
    $(document).ready(function(){
        // getPageN(1);
        // setExpenseClassInput();
        // //设置删除按钮功能
        // $("#deleteRegistrationsButton").click(function () {
        //     var deleteIDs = [];
        //     $.each($('input:checkbox:checked'),function(){
        //         deleteIDs.push($(this).val());
        //     });
        //     $.ajax({
        //         type: "POST",
        //         url: "nonDrugList/deleteNonDrugListsByID",
        //         data: {idString:deleteIDs.join(',')},
        //         async: false,
        //         success: function () {
        //             alert("已删除");
        //             getPageN(1);
        //         },
        //         error :function () {
        //             alert("删除失败");
        //         }
        //     });
        // });
        setTableBody();
        //设置挂号按钮功能
        $("#registrationButton").click(function () {
            $.ajax({
                type: "POST",
                url: "registration/addRegistrationInfo",
                data: $('#registrationInfo').serialize(),
                success: function () {
                    alert("挂号成功");
                    $.ajax({
                        type:"POST",
                        url: "registration/registrationInfoList",
                        async: false,
                        success: function (result) {
                            registrationInfoList = result;
                            setTableBody();
                        },
                        error :function () {
                            alert("获取挂号列表失败");
                        }
                    });
                },
                error: function () {
                    alert("挂号失败");

                }
            });
        });
        // //设置挂号等级添加按钮
        // $("#addRegistrationLevelButton").click(function () {
        //     $.ajax({
        //         type: "POST",
        //         url: "nonDrugList/addNonDrugList",
        //         data: $('#addRegistrationLevel').serialize(),
        //         success: function () {
        //             alert("添加成功");
        //             getPageN(1);
        //         }
        //     });
        // });
        // //设置查找功能按钮
        // $("#search").click(function(){
        //     getSearchedPageN(1);
        // });
    });
</script>
</body>
</html>
