<%--
  Created by IntelliJ IDEA.
  User: GQ
  Date: 2019/6/17
  Time: 18:59
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
    <title>病例首页</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css">
</head>
<body style="margin-top: 20px">
<%--修改病例模板弹出框--%>
<div id="modifyTemplateDialog" title="修改模板"  style="display: none" >
    <form id="modifyTemplateDialogForm">
        <input type="text" class="form-control" name="id" id="modifyTemplateId" style="display: none"/>
        <input type="text" class="form-control" name="doctorId" id="templateDoctorId" style="display: none"/>
        <p>模板名称：<input type="text" class="form-control" name="templateName" id="modifyTemplateName" /></p>
        <p>&nbsp;&nbsp;类&nbsp;&nbsp;别&nbsp;&nbsp;：<select class="form-control" name="category" id="modifyTemplateCategory" >
            <option value ="1">全院</option>
            <option value ="2">科室</option>
            <option value ="3">个人</option>
        </select>
        </p>
        <p>主诉：<input type="text" class="form-control" name="chiefComplaint" id="modifyChiefComplaint" /></p>
        <p>现病史：<input type="text" class="form-control" name="historyOfPresentIllness" id="modifyHistoryOfPresentIllness" /></p>
        <p>现病治疗情况：<input type="text" class="form-control" name="treatmentOfCurrentIllness" id="modifyTreatmentOfCurrentIllness" /></p>
        <p>既往史：<input type="text" class="form-control" name="pastHistory" id="modifyPastHistory" /></p>
        <p>过敏史：<input type="text" class="form-control" name="allergyHistory" id="modifyAllergyHistory" /></p>
        <p>体格检查：<input type="text" class="form-control" name="physicalExamination" id="modifyPhysicalExamination" /></p>
        <div style="float: right;">
            <input type="button" class="btn btn-default" value="返回" onclick="cancelModifyTemplate()"/>
            <input type="button" class="btn btn-primary" value="修改" onclick="saveModifyTemplate()"/>
            <input type="button" class="btn btn-danger" value="删除" onclick="deleteModifyTemplate()"/>
        </div>
    </form>
</div>
<%--保存病例模板弹出框--%>
<div id="saveTemplateDialog" title="存为模板"  style="display: none" >
    <form>
        <p>模板名称：<input class="form-control" type="text" id="templateName" /></p>
        <p>&nbsp;&nbsp;类&nbsp;&nbsp;别&nbsp;&nbsp;：<select class="form-control" id="templateCategory" >
            <option value ="1">全院</option>
            <option value ="2">科室</option>
            <option value ="3">个人</option>
        </select>
        </p>
        <div style="float: right;">
            <input type="button" class="btn btn-default" value="取消" onclick="cancelSaveTemplate()"/>
            <input type="button" class="btn btn-primary" value="保存" onclick="saveTemplate()"/>
        </div>
    </form>
</div>
<nav id="nav" class="navbar navbar-default">
    <a href="#" class="navbar-brand">首页</a>
    <ul class="nav navbar-nav" style="width: 93%">
        <li class="dropdown">
            <a href="#" data-toggle="dropdown">信息管理 <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="user/management">用户管理</a></li>
                <li><a href="#yui">Yui</a></li>
                <li><a href="#extjs">ExtJS</a></li>
            </ul>
        </li>
        <li class="active"><a>病例首页</a></li>
        <li class="dropdown pull-right" style="position: relative;right: 5px;">
            <select style="margin-top: 10px" class="form-control" onchange="update()" id="doctorID">
                <option value="">登录</option>
                <option value="123">张三</option>
                <option value="1223">李四</option>
            </select>
<%--            <a id="userID" data-toggle="dropdown">登录 <span class="caret"></span></a>--%>
<%--            <ul class="dropdown-menu">--%>
<%--                <li><a href="#jquery">jQuery</a></li>--%>
<%--                <li><a href="#yui">Yui</a></li>--%>
<%--                <li><a href="#extjs">ExtJS</a></li>--%>
<%--            </ul>--%>
        </li>
    </ul>
</nav>
<div class="center-block" style="width: 95%">
    <div class="col-md-2 center-block" style="border: solid 1px #5e5e5e;width: 19.5%;height: 600px;overflow: auto">
        <div style="height: 300px;overflow: auto">
            <fieldset>
                <div>
                    <legend class="">待诊患者</legend>
                </div>
            </fieldset>
            <div id="waitingDiagnosePatients">
            </div>
        </div>
        <div style="height: 290px">
            <fieldset>
                <div>
                    <legend class="">已诊患者</legend>
                </div>
            </fieldset>
            <div id="diagnosedPatients">
                <%--显示已诊患者--%>
            </div>
        </div>

    </div>
    <div class="col-md-8 center-block" style="border: solid 1px #2aabd2;width: 79.5%;height: 600px;overflow: auto">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#medicalRecordTab" data-toggle="tab">病例首页</a></li>
            <li><a href="#yonghu" data-toggle="tab">用户中心</a></li>
            <li><a href="#dingdan" data-toggle="tab">订单中心</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active center-block" id="medicalRecordTab">
<%--                病例首页标签页--%>
                <div class="col-md-8 center-block" style="width: 70%;height: 600px;overflow: auto">
                    <form role="form" id="medicalRecordInfo">
                        <div class="col-md-6 pull-right">
                            <input type="reset" class="btn btn-default" value="清屏" />&nbsp;
                            <button type="button" id="holdButton" class="btn btn-primary">&nbsp;&nbsp;&nbsp;暂存&nbsp;&nbsp;&nbsp;</button>&nbsp;
                            <button type="button" id="submitButton" class="btn btn-primary">&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;</button>&nbsp;
                            <button type="button" id="templateButton" onclick="showSaveTemplateDialog()" class="btn btn-primary">&nbsp;设为模板&nbsp;</button>
                        </div>
                        <fieldset>
                            <legend class="">门诊病例信息</legend>
                        </fieldset>
                        <div class="form-group">
                            <label class="col-md-2 control-label text-right" for="chiefComplaint">主诉</label>
                            <div class="col-md-10 controls">
                                <textarea style="min-width: 100%" class="input-lg" id="chiefComplaint" name="chiefComplaint" rows="2"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label text-right" for="historyOfPresentIllness">现病史</label>
                            <div class="col-md-10 controls">
                                <textarea style="min-width: 100%" class="input-lg" id="historyOfPresentIllness" name="historyOfPresentIllness" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 3px">
                            <label class="col-md-2 control-label text-right" for="treatmentOfCurrentIllness">现病治疗情况</label>
                            <div class="col-md-10 controls">
                                <textarea style="min-width: 100%" class="input-lg" id="treatmentOfCurrentIllness" name="treatmentOfCurrentIllness" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label text-right" for="pastHistory">既往史</label>
                            <div class="col-md-10 controls">
                                <textarea style="min-width: 100%" class="input-lg" id="pastHistory" name="pastHistory" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label text-right" for="allergyHistory">过敏史</label>
                            <div class="col-md-10 controls">
                                <textarea style="min-width: 100%" class="input-lg" id="allergyHistory" name="allergyHistory" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label text-right" for="physicalExamination">体格检查</label>
                            <div class="col-md-10 controls">
                                <textarea style="min-width: 100%" class="input-lg" id="physicalExamination" name="physicalExamination" rows="3"></textarea>
                            </div>
                        </div>
                    </form>
                    <div class="row" style="padding-top: 10px">
                        <div class="col-md-5">
                            <label class="col-md-4 control-label text-right" for="diseaseMnemonicCodeInput">诊断查找</label>
                            <div class="col-md-6 input-group">
                                <input type="text" class="form-control" placeholder="输入助记码" id="diseaseMnemonicCodeInput" name="diseaseMnemonicCode"/>
                                <ul id="diseaseMnemonicCodeInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="col-md-2">
                                <button type="button" id="foundDiagnose" class="btn btn-primary">&nbsp;&nbsp;诊断查询&nbsp;&nbsp;</button>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="col-md-2 pull-right">
                                <button type="button" id="addDiagnose" class="btn btn-primary">&nbsp;&nbsp;新增诊断&nbsp;&nbsp;</button>
                            </div>
                        </div>
                    </div>
                    <form role="form" id="diagnosesInfo" >
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th class="col-md-2">id</th>
                                <th class="col-md-2">名称</th>
                                <th>主诊</th>
                                <th class="col-md-3">发病日期</th>
                                <th>类型</th>
<%--                                <th>类型</th>--%>
                            </tr>
                            </thead>
                            <tbody id="diagnoseTableBody">
                            <tr>
                                <th style="display: none"><input type="text" class="form-control" id="diseases0id" name="diagnoses[0].diseaseId"/></th>
                                <th><input type="text" class="form-control" id="diseases0internationalIcdCode" /></th>
                                <th><input type="text" class="form-control" id="diseases0diseaseName" name="diagnoses[0].diseaseName"/></th>
                                <th><select class="form-control" name="diagnoses[0].majorDiagnoseSign">
                                    <option value="1">主诊</option>
                                    <option value="0">疑似</option>
                                </select></th>
                                <th><input type="date" class="form-control" name="diagnoses[0].diseaseTime"/></th>
                                <th><select class="form-control" id="diseases0diseaseType" name="diagnoses[0].diseaseType">
                                    <option value="西医">西医</option>
                                    <option value="中医">中医</option>
                                </select></th>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
                <div class="col-md-2 center-block" style="width: 29%">
<%--                    病例首页标签页右侧的标签页--%>
                    <div class="col-md-2" style="border: solid 1px #2aabd2;width: 100%;height: 600px;overflow: auto">
                        <ul id="medicalRecordMiniTab" class="nav nav-tabs">
                            <li class="active"><a href="#medicalRecordCommon" data-toggle="tab">病例模板</a></li>
                            <li><a href="#commonDiagnoses" data-toggle="tab">常用诊断</a></li>
                            <li><a href="#lishi" data-toggle="tab">历史病例</a></li>
                        </ul>
                        <div id="medicalRecordMiniTabContent" class="tab-content">
                            <div class="tab-pane fade in active" id="medicalRecordCommon">
<%--                                病例模板标签页--%>
                                <div style="height: 450px;overflow: auto">
                                    <div>
                                        <button type="button" id="hospitalCommonButton" onclick="getHospitalCommon()" class="btn btn-primary">医院</button>&nbsp;
                                        <button type="button" id="departmentCommonButton" onclick="getDepartmentCommon()" class="btn btn-primary">科室</button>&nbsp;
                                        <button type="button" id="personalCommonButton" onclick="getPersonalCommon()" class="btn btn-primary">个人</button>&nbsp;
                                    </div>
                                    <fieldset>
                                        <div>
                                            <legend class="">模板</legend>
                                        </div>
                                    </fieldset>
                                    <div id="displayCommons">
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="commonDiagnoses">
                                <div style="height: 450px;overflow: auto" id="displayCommonDiagnoses">
                                    <input type="button" onclick="setDisplayCommonDiagnoses()" class="btn btn-primary" value="1233"/>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="lishi">
                                <p>历史病例</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="yonghu">
                <p>用户中心</p>
            </div>
            <div class="tab-pane fade" id="dingdan">
                <p>订单中心</p>
            </div>
        </div>
    </div>
<%--    <div class="col-md-2" style="border: solid 1px #2aabd2;width: 29.5%;height: 600px;overflow: auto">--%>

<%--    </div>--%>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript">
    //修改病例模板弹出框
    function showModifyTemplateDialog() {
        $('#modifyTemplateDialog').dialog({
            modal:true,
            width:"600",
            height:"625"
        });
        document.getElementById("modifyTemplateDialog").style.display="block";
    }
        //修改病例模板弹出框的返回按钮
    function cancelModifyTemplate() {
        $('#modifyTemplateDialog').dialog("close");
    }
        //修改病例模板弹出框的修改按钮
    function saveModifyTemplate() {
        var doctorID = Number($("#doctorID").val());
        $.ajax({
            type: "POST",
            url: "medicalRecord/modifyMedicalRecordTemplate",
            data: $.param({operatorDoctorId:doctorID}) + '&' + $("#modifyTemplateDialogForm").serialize(),
            success: function (result) {
                alert(result.msg);
                getHospitalCommon();
                $('#modifyTemplateDialog').dialog("close");
            },
            error: function () {
                alert("修改失败");
            }
        });
    }
        //修改病例模板弹出框的删除按钮
    function deleteModifyTemplate() {
        var doctorID = Number($("#doctorID").val());
        $.ajax({
            type: "POST",
            url: "medicalRecord/deleteMedicalRecordTemplate",
            data: $.param({operatorDoctorId:doctorID,templateId:$("#modifyTemplateId").val()}),
            success: function (result) {
                alert(result.msg);
                getHospitalCommon();
                $('#modifyTemplateDialog').dialog("close");
            },
            error: function () {
                alert("删除失败");
            }
        });
    }
    //病例模板显示弹出框
    function showSaveTemplateDialog() {
        $('#saveTemplateDialog').dialog({
            modal:true,
            width:"400",
            height:"223"
        });
        document.getElementById("saveTemplateDialog").style.display="block";
    }
        //病例模板弹出框的保存按钮
    function saveTemplate() {
        var templateName = $("#templateName").val();
        var templateCategory = $("#templateCategory").val();
        var doctorID = $("#doctorID").val();
        // var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
        $.ajax({
            type: "POST",
            url: "medicalRecord/saveMedicalRecordTemplate",
            data: $.param({doctorId:doctorID,category:templateCategory,templateName:templateName}) + '&' + $("#medicalRecordInfo").serialize(),
            success: function () {
                alert("保存成功");
                getHospitalCommon();
            },
            error: function () {
                alert("保存失败");
            }
        });
        $("#templateName").val("");
        $("#templateCategory").empty();
        var ops={
            "1":"全院",
            "2":"科室",
            "3":"个人"
        };
        var parent=document.getElementById("templateCategory");
        for(var key in ops) {
            var o = new Option(ops[key],key);
            parent.appendChild(o);
        }
        $('#saveTemplateDialog').dialog("close");
    }
        //病例模板弹出框的返回按钮
    function cancelSaveTemplate() {
        $("#templateName").val("");
        $("#templateCategory").empty();
        var ops={
            "1":"全院",
            "2":"科室",
            "3":"个人"
        };
        var parent=document.getElementById("templateCategory");
        for(var key in ops) {
            var o = new Option(ops[key],key);
            parent.appendChild(o);
        }
        $('#saveTemplateDialog').dialog("close");
    }
    //医生列表
    var doctors = null;
    $.ajax({
        type: "POST",
        url: "user/findbyattribute",
        data: {attribute_name : "role_name",attribute : "医生"},
        success: function (result) {
            //    TODO result为users 未测试
            doctors = result;
            setDoctorIDBody();
        }
    });
    //设置登录选项
    function setDoctorIDBody(){
        var str;
        str = "<option value=\"\">登录</option>";
        $("#doctorID").html("");
        for (let i = 0;i < doctors.length;i++){
            str += "<option value=\"" + doctors[i].id + "\">" + doctors[i].name + "</option>\n";
        }
        $("#doctorID").append(str);
    }
    //医生登录后进行更新
    function update(){
        getWaitingDiagnosePatients();
        getDiagnosedPatients();
        $("#chiefComplaint").val("");
        $("#historyOfPresentIllness").val("");
        $("#treatmentOfCurrentIllness").val("");
        $("#pastHistory").val("");
        $("#allergyHistory").val("");
        $("#physicalExamination").val("");
        getHospitalCommon();
    //    TODO 需要更新的函数
    }
    //获取待诊患者
    function getWaitingDiagnosePatients(){
        var waitingDiagnosePatients = null;
        var doctorID = $("#doctorID").val();
        if(doctorID != ""){
            $.ajax({
                type: "POST",
                url: "registration/getWaitingDiagnosePatientsByID",
                data: {id : doctorID},
                async: false,
                success: function (result) {
                    waitingDiagnosePatients = result;
                    var str = "";
                    $("#waitingDiagnosePatients").html("");
                    for (let i = 0;i < waitingDiagnosePatients.length;i++){
                        str += "<div class=\"row\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                            "<input type=\"radio\" class=\"col-xs-2\" style=\"width: 20%\"  name=\"patientMedicalRecordNo\" value='" + waitingDiagnosePatients[i].medicalRecordNo + "' />\n" +
                            "<input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + waitingDiagnosePatients[i].medicalRecordNo + "  " + waitingDiagnosePatients[i].patientName + "  " + waitingDiagnosePatients[i].patientAge + "岁" + "' readonly/>\n" +
                            "</div>";
                    }
                    $("#waitingDiagnosePatients").append(str);
                },
                error :function () {
                    alert("获取待诊病人失败");
                }
            });
        }
    }
    //获取已诊患者
    function getDiagnosedPatients(){
        var diagnosedPatients = null;
        var doctorID = $("#doctorID").val();
        if(doctorID != ""){
            $.ajax({
                type: "POST",
                url: "registration/getDiagnosedPatientsByID",
                data: {id : doctorID},
                async: false,
                success: function (result) {
                    diagnosedPatients = result;
                    var str = "";
                    $("#diagnosedPatients").html("");
                    for (let i = 0;i < diagnosedPatients.length;i++){
                        str += "<div class=\"row\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                            "<input type=\"text\" class=\"form-control\" style=\"width: 100%\" value='" + diagnosedPatients[i].medicalRecordNo + "  " + diagnosedPatients[i].patientName + "  " + diagnosedPatients[i].patientAge + "岁" + "' readonly/>\n" +
                            "</div>";
                    }
                    $("#diagnosedPatients").append(str);
                },
                error :function () {
                    alert("获取已诊病人失败");
                }
            });
        }
    }
    //获取全院模板
    function getHospitalCommon(){
        $.ajax({
            type: "POST",
            url: "medicalRecord/getHospitalCommon",
            success: function (result) {
                medicalRecordTemplates = result;
                setMedicalRecordTemplates();
            }
        });
    }
    //获取科室模板
    function getDepartmentCommon(){
        var doctorID = $("#doctorID").val();
        if (doctorID == ""){
            alert("请先登录");
        }else {
            $.ajax({
                type: "POST",
                url: "medicalRecord/getDepartmentCommon",
                data:{doctorID:doctorID},
                success: function (result) {
                    medicalRecordTemplates = result;
                    setMedicalRecordTemplates();
                }
            });
        }
    }
    //获取个人模板
    function getPersonalCommon(){
        var doctorID = $("#doctorID").val();
        if (doctorID == ""){
            alert("请先登录");
        }else {
            $.ajax({
                type: "POST",
                url: "medicalRecord/getPersonalCommon",
                data:{doctorID:doctorID},
                success: function (result) {
                    medicalRecordTemplates = result;
                    setMedicalRecordTemplates();
                }
            });
        }
    }
    //根据疾病助记码动态查询
    $(function(){
        //载入时隐藏下拉li
        $("#diseaseMnemonicCodeInputUl").hide(0);
    });
    $("#diseaseMnemonicCodeInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#diseaseMnemonicCodeInput").val().length == 0){
            $("#diseaseMnemonicCodeInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"disease/findByAttributeWithTwoParameters",
            data: {attribute_name : "disease_mnemonic_code",attribute : $("#diseaseMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                if(result){
                    //setUl(result);
                    var tempDiseases = result;
                    var str = "";
                    for (var i = 0;i < tempDiseases.length; i++){
                        str += "<li value='" + tempDiseases[i].diseaseName + "'>" + tempDiseases[i].diseaseName + "</li>\n";
                    }
                    $("#diseaseMnemonicCodeInputUl").show(0);
                    $("#diseaseMnemonicCodeInputUl").html(str);
                }else {
                    alert("无此疾病");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#diseaseMnemonicCodeInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#diseaseMnemonicCodeInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#diseaseMnemonicCodeInputUl li").click(function(){
                    $("#diseaseMnemonicCodeInput").val($(this).html());
                    $("#diseaseMnemonicCodeInputUl").hide(0);
                });
            }
        });
    });
    //诊断数目
    var diagnoseNum = 0;



    //常用诊断目录
    var displayCommonDiagnoses = null;
    //生成常用诊断
    function setDisplayCommonDiagnoses(){
        // var str = "";
        // $("#displayCommonDiagnoses").html("");
        // for (let i = 0;i < displayCommonDiagnoses.length;i++){
        //     str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
        //         "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + displayCommonDiagnoses[i].diseaseName + "' readonly/>\n" +
        //         "    <button type=\"button\" class=\"btn btn-primary\" onclick='useCommonDiagnose(" + i + ")'>引用</button>&nbsp;\n" +
        //         "    <button type=\"button\" class=\"btn btn-primary\" onclick='deleteCommonDiagnose(" + i + ")'>查看</button>\n" +
        //         "</div>";
        // }
        // $("#displayCommonDiagnoses").append(str);
        // $("#eval('displayCommonDiagnoses'+ )").val();
        // var te = eval('disease'+diagnoseNum+'Id');
        // $(te).val(233);
        // $(eval('disease'+diagnoseNum+'Id')).val(23333);
        // alert($(eval('disease'+diagnoseNum+'Id')).val());
        // $(eval('disease0diseaseType')).val('中医');
    }


    //模板列表 TODO
    var medicalRecordTemplates = null;
    //生成模板列表
    function setMedicalRecordTemplates(){
        var str = "";
        $("#displayCommons").html("");
        for (let i = 0;i < medicalRecordTemplates.length;i++){
            str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + medicalRecordTemplates[i].templateName + "' readonly/>\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='useMedicalRecordTemplate(" + i + ")'>引用</button>&nbsp;\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='modifyMedicalRecordTemplate(" + i + ")'>查看</button>\n" +
                "</div>";
        }
        $("#displayCommons").append(str);
    }
    //修改模板
    function modifyMedicalRecordTemplate(i){
        $("#modifyTemplateId").val(medicalRecordTemplates[i].id);
        $("#templateDoctorId").val(medicalRecordTemplates[i].doctorId);
        $("#modifyTemplateName").val(medicalRecordTemplates[i].templateName);
        // $("#modifyTemplateCategory").val(medicalRecordTemplates[i].category);
        $("#modifyChiefComplaint").val(medicalRecordTemplates[i].chiefComplaint);
        $("#modifyHistoryOfPresentIllness").val(medicalRecordTemplates[i].historyOfPresentIllness);
        $("#modifyTreatmentOfCurrentIllness").val(medicalRecordTemplates[i].treatmentOfCurrentIllness);
        $("#modifyPastHistory").val(medicalRecordTemplates[i].pastHistory);
        $("#modifyAllergyHistory").val(medicalRecordTemplates[i].allergyHistory);
        $("#modifyPhysicalExamination").val(medicalRecordTemplates[i].physicalExamination);
        showModifyTemplateDialog();
    }
    //引用模板
    function useMedicalRecordTemplate(i){
        $("#chiefComplaint").val(medicalRecordTemplates[i].chiefComplaint);
        $("#historyOfPresentIllness").val(medicalRecordTemplates[i].historyOfPresentIllness);
        $("#treatmentOfCurrentIllness").val(medicalRecordTemplates[i].treatmentOfCurrentIllness);
        $("#pastHistory").val(medicalRecordTemplates[i].pastHistory);
        $("#allergyHistory").val(medicalRecordTemplates[i].allergyHistory);
        $("#physicalExamination").val(medicalRecordTemplates[i].physicalExamination);
    }
    //DOM结构加载完毕后执行
    $(document).ready(function(){
        // alert("请登录");
        //诊断查找按钮
        $("#foundDiagnose").click(function () {
            $.ajax({
                type: "POST",
                url: "disease/findWithType",
                data: {attribute_name : "disease_name",attribute : $("#diseaseMnemonicCodeInput").val()},
                success: function (result) {
                    var disease = result;
                    $(eval('diseases' + diagnoseNum + 'id')).val(disease[0].id);
                    $(eval('diseases' + diagnoseNum + 'internationalIcdCode')).val(disease[0].internationalIcdCode);
                    $(eval('diseases' + diagnoseNum + 'diseaseName')).val(disease[0].diseaseName);
                    $(eval('diseases' + diagnoseNum + 'diseaseType')).val(disease[0].diagnoseDirectoryName);
                }
            });
            $("#diseaseMnemonicCodeInput").val("");
        });
        //设置暂存按钮功能 TODO
        $("#holdButton").click(function () {
            var doctorID = $("#doctorID").val();
            var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
            alert(medicalRecordNo);
            $.ajax({
                type: "POST",
                url: "medicalRecord/temporaryStorage",
                //TODO
                // data: {doctorID : doctorID,medicalRecordNo : medicalRecordNo,medicalRecord : $('#medicalRecordInfo').serialize()},
                success: function () {
                    alert("病例已暂存");
                }
            });
        });
        //设置添加诊断按钮
        $("#addDiagnose").click(function () {
            diagnoseNum = diagnoseNum + 1;
            var str = "<tr>\n" +
                "<th style='display: none'><input type=\"text\" class=\"form-control\" id='diseases" + diagnoseNum + "id' name=\"diagnoses[" + diagnoseNum + "].diseaseId\"/></th>" +
                "<th><input type=\"text\" class=\"form-control\" id=\"diseases" + diagnoseNum + "internationalIcdCode\"/></th>" +
                "<th><input type=\"text\" class=\"form-control\" id='diseases" + diagnoseNum + "diseaseName' name='diagnoses[" + diagnoseNum + "].diseaseName'/></th>\n" +
                "    <th><select class=\"form-control\" name=\"diagnoses[" + diagnoseNum + "].majorDiagnoseSign\">\n" +
                "    <option value=\"1\">主诊</option>\n" +
                "    <option value=\"0\">疑似</option>\n" +
                "    </select></th>\n" +
                "<th><input type=\"date\" class=\"form-control col-md-3\" name=\"diagnoses[" + diagnoseNum + "].diseaseTime\"/></th>\n" +
                "<th><select class=\"form-control col-md-3\" id='diseases" + diagnoseNum + "diseaseType' name=\"diagnoses[" + diagnoseNum + "].diseaseType\">\n" +
                "    <option value=\"西医\">西医</option>\n" +
                "    <option value=\"中医\">中医</option>\n" +
                "    </select></th>\n" +
                "</tr>";
            $("#diagnoseTableBody").append(str);
        });
        //设置提交按钮功能
        $("#submitButton").click(function () {
            var doctorID = $("#doctorID").val();
            var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
            $.ajax({
                type: "POST",
                url: "medicalRecord/submitMedicalRecord",
                data: $.param({doctorId:doctorID,medicalRecordNo:medicalRecordNo}) + '&' + $("#medicalRecordInfo").serialize() + '&' + $('#diagnosesInfo').serialize(),
                success: function (result) {
                    alert(result.msg);
                },
                error: function () {
                    alert("提交失败");
                }
            });
        });
        // //设置查找功能按钮
        // $("#search").click(function(){
        //     $.ajax({
        //         type: "POST",
        //         url: "user/findbyattribute",
        //         data: {attribute_name : $("#searchBy").val(),attribute : $("#searchVal").val()},
        //         success: function (result) {
        //             users = result;
        //             setTableBody();
        //         }
        //     });
        // });
        // //设置用户添加按钮
        // $("#addUserButton").click(function () {
        //     $.ajax({
        //         type: "POST",
        //         url: "user/insertuser",
        //         data: $('#addUser').serialize(),
        //         success: function () {
        //             $.ajax({
        //                 type: "POST",
        //                 url: "user/list",
        //                 async: false,
        //                 success: function (result) {
        //                     users = result;
        //                     setTableBody();
        //                 },
        //                 error :function () {
        //                     alert("获取用户表失败");
        //                 }
        //             });
        //         }
        //     });
        // });
    });
</script>
</body>
</html>
