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
<%--添加常用项目对话框--%>
<div id="commonInspectionDialog" title="添加常用项目"  style="display: none" >
    <form id="commonInspectionDialogForm">
        <div class="col-md-7">
            <label class="col-md-4 control-label text-right" for="commonInspectionDialogDiseaseMnemonicCodeInput">项目查找</label>
            <div class="col-md-6 input-group">
                <input type="text" class="form-control" placeholder="输入助记码" id="commonInspectionDialogDiseaseMnemonicCodeInput"/>
                <ul id="commonInspectionDialogDiseaseMnemonicCodeInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                </ul>
            </div>
        </div>
        <div class="col-md-3">
            <div class="col-md-2">
                <button type="button" onclick="commonInspectionDialogFind()" class="btn btn-primary">&nbsp;&nbsp;项目查询&nbsp;&nbsp;</button>
            </div>
        </div>
        <input type="text" class="form-control" name="nonDrugListId" id="commonInspectionDialogNonDrugListId" style="display: none"/>
        <input type="text" class="form-control" name="doctorId" id="commonInspectionDialogDoctorId" style="display: none"/>
        <br><br><br>
        <p>项目编码：<input type="text" class="form-control" id="commonInspectionDialogCode" /></p>
        <p>项目名称：<input type="text" class="form-control" id="commonInspectionDialogNonDrugListName" /></p>
        <p>价格：<input type="text" class="form-control" name="cost" id="commonInspectionDialogCost" /></p>
        <div style="float: right;">
            <input type="button" class="btn btn-default" value="返回" onclick="closeCommonInspectionDialog()"/>
            <input type="button" class="btn btn-primary" value="添加" onclick="addCommonInspectionDialog()"/>
            <input style="display: none" type="reset" id="commonInspectionDialogReset"/>
        </div>
    </form>
</div>
<%--查看修改组套对话框--%>
<div id="modifySetDialog" title="组套详情"  style="display: none" >
    <form id="modifySetDialogForm">
        <input type="text" style="display: none" name="id" id="modifySetDialogId"/>
        <input type="text" style="display: none" name="doctorId" id="modifySetDialogDoctorId"/>
        <p>组套编码：<input type="text" class="form-control" name="combinatorialCode" id="modifySetDialogCombinatorialCode"  /></p>
        <p>组套名称：<input type="text" class="form-control" name="combinatorialName" id="modifySetDialogCombinatorialName" /></p>
        <p>目的和要求：<input type="text" class="form-control" name="requirement" id="modifySetDialogRequirement" /></p>
        <p>适用范围：<select class="form-control" name="category" id="modifySetDialogCategory" >
            <option value ="全院">全院</option>
            <option value ="科室">科室</option>
            <option value ="个人">个人</option>
        </select>
        </p>
        <input style="display: none" type="reset" id="modifySetDialogReset"/>
    </form>
    <div style="float: right;">
        <input type="button" class="btn btn-default" value="返回" onclick="closeModifySetDialog()"/>
        <input type="button" class="btn btn-primary" value="修改" onclick="saveModifySetDialog()"/>
    </div>
</div>
<%--存为组套对话框--%>
<div id="saveAsSetDialog" title="存为组套"  style="display: none" >
    <form id="saveAsSetInspectionSetForm">
        <p>组套编码：<input type="text" class="form-control" name="combinatorialCode" id="saveAsSetDialogCombinatorialCode"  /></p>
        <p>组套名称：<input type="text" class="form-control" name="combinatorialName" id="saveAsSetDialogCombinatorialName" /></p>
        <p>目的和要求：<input type="text" class="form-control" name="requirement" id="saveAsSetDialogRequirement" /></p>
        <p>适用范围：<select class="form-control" name="category" id="saveAsSetDialogCategory" >
            <option value ="全院">全院</option>
            <option value ="科室">科室</option>
            <option value ="个人">个人</option>
        </select>
        </p>
        <input style="display: none" type="reset" id="saveAsSetDialogReset"/>
    </form>
    <div class="col-md-8">
        <label class="col-md-4 control-label text-right" for="saveAsSetDialogInspectionMnemonicCodeInput">检查查找</label>
        <div class="col-md-6 input-group">
            <input type="text" class="form-control" placeholder="输入助记码" id="saveAsSetDialogInspectionMnemonicCodeInput" name="inspectionMnemonicCode"/>
            <ul id="saveAsSetDialogInspectionMnemonicCodeInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
            </ul>
        </div>
    </div>
    <div class="pull-right" style="width: 100px">
        <div class="">
            <button type="button" onclick="dialogFindOneInspection()" class="btn btn-primary">添加项目</button>
        </div>
    </div>
    <form id="saveAsSetSetDetailForm">
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th class="col-md-2">项目编码</th>
                <th class="col-md-2">名称</th>
                <th class="col-md-3">价格</th>
                <%--<th>类型</th>--%>
            </tr>
            </thead>
            <tbody id="saveAsSetInspectionTableBody">
            <tr>
                <th><input type="text" class="form-control" id="inspectionsInDialog0itemCode" readonly/></th>
                <th><input type="text" class="form-control" id="inspectionsInDialog0itemName" name="itemName" readonly/></th>
                <th><input type="text" class="form-control" id="inspectionsInDialog0price" readonly/></th>
            </tr>
            </tbody>
        </table>
    </form>
    <div style="float: right;">
        <input type="button" class="btn btn-default" value="取消" onclick="closeSaveAsSetDialog()"/>
        <input type="button" class="btn btn-primary" value="保存" onclick="saveInspectionSet()"/>
    </div>
</div>
<%--查看历史病例对话框--%>
<div id="historyMedicalRecordDialog" title="历史病例"  style="display: none" >
    <p>主诉：<input type="text" class="form-control" name="chiefComplaint" id="historyMedicalRecordChiefComplaint" readonly /></p>
    <p>现病史：<input type="text" class="form-control" name="historyOfPresentIllness" id="historyMedicalRecordHistoryOfPresentIllness" readonly/></p>
    <p>现病治疗情况：<input type="text" class="form-control" name="treatmentOfCurrentIllness" id="historyMedicalRecordTreatmentOfCurrentIllness" readonly/></p>
    <p>既往史：<input type="text" class="form-control" name="pastHistory" id="historyMedicalRecordPastHistory" readonly/></p>
    <p>过敏史：<input type="text" class="form-control" name="allergyHistory" id="historyMedicalRecordAllergyHistory" readonly/></p>
    <p>体格检查：<input type="text" class="form-control" name="physicalExamination" id="historyMedicalRecordPhysicalExamination" readonly/></p>
    <div style="float: right;">
        <input type="button" class="btn btn-primary" value="确定" onclick="closeHistoryMedicalRecordDialog()"/>
    </div>
</div>
<%--添加常用诊断对话框--%>
<div id="commonDiagnoseDialog" title="添加常用诊断"  style="display: none" >
    <form id="commonDiagnoseDialogForm">
        <div class="col-md-7">
            <label class="col-md-4 control-label text-right" for="commonDiagnoseDialogDiseaseMnemonicCodeInput">诊断查找</label>
            <div class="col-md-6 input-group">
                <input type="text" class="form-control" placeholder="输入助记码" id="commonDiagnoseDialogDiseaseMnemonicCodeInput"/>
                <ul id="commonDiagnoseDialogDiseaseMnemonicCodeInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                </ul>
            </div>
        </div>
        <div class="col-md-3">
            <div class="col-md-2">
                <button type="button" onclick="setCommonDiagnoseDialogFoundDiagnose()" class="btn btn-primary">&nbsp;&nbsp;诊断查询&nbsp;&nbsp;</button>
            </div>
        </div>
        <input type="text" class="form-control" name="diseaseId" id="commonDiagnoseDialogDiseaseId" style="display: none"/>
        <input type="text" class="form-control" name="doctorId" id="commonDiagnoseDialogDoctorId" style="display: none"/>
        <br><br><br>
        <p>国际ICD编码：<input type="text" class="form-control" id="commonDiagnoseDialogICDCode" /></p>
        <p>诊断名称：<input type="text" class="form-control" name="diseaseName" id="commonDiagnoseDialogDiseaseName" /></p>
        <p>&nbsp;&nbsp;类&nbsp;&nbsp;型&nbsp;&nbsp;：<select class="form-control" name="diseaseType" id="commonDiagnoseDialogDiseaseType" >
            <option value ="1">西医</option>
            <option value ="2">中医</option>
        </select>
        </p>
        <div style="float: right;">
            <input type="button" class="btn btn-default" value="返回" onclick="cancelCommonDiagnoseDialog()"/>
            <input type="button" class="btn btn-primary" value="添加" onclick="saveCommonDiagnoseDialog()"/>
            <input style="display: none" type="reset" id="commonDiagnoseDialogReset"/>
        </div>
    </form>
</div>
<%--修改病例模板对话框--%>
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
<%--保存病例模板对话框--%>
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
<%--导航栏--%>
<nav id="nav" class="navbar navbar-default">
    <a href="#" class="navbar-brand">首页</a>
    <ul class="nav navbar-nav" style="width: 93%">
<%--        <li class="dropdown">--%>
<%--            <a href="#" data-toggle="dropdown">信息管理 <span class="caret"></span></a>--%>
<%--            <ul class="dropdown-menu">--%>
<%--                <li><a href="user/management">用户管理</a></li>--%>
<%--                <li><a href="#yui">Yui</a></li>--%>
<%--                <li><a href="#extjs">ExtJS</a></li>--%>
<%--            </ul>--%>
<%--        </li>--%>
        <li class="active"><a>病例首页</a></li>
        <li class="dropdown pull-right" style="position: relative;right: 5px;">
            <select style="margin-top: 10px" class="form-control" onchange="update()" id="doctorID">
<%--                <option value="">登录</option>--%>
<%--                <option value="123">张三</option>--%>
<%--                <option value="1223">李四</option>--%>
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
    <%--已诊患者 待诊患者--%>
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
        <div style="height: 290px;overflow: auto">
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
            <li class="active"><a href="#medicalRecordTab" data-toggle="tab">病历首页</a></li>
            <li><a href="#inspectionInfoTab" data-toggle="tab">检查</a></li>
            <li><a href="#dingdan" data-toggle="tab"></a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active center-block" id="medicalRecordTab">
                <%--病历首页标签页--%>
                <div class="col-md-8 center-block" style="width: 70%;height: 600px;overflow: auto">
                    <%--病历首页--%>
                    <form role="form" id="medicalRecordInfo">
                        <div class="col-md-5 pull-right">
                            <input type="reset" id="medicalRecordInfoResetButton" class="btn btn-default" value="清屏" />&nbsp;
                            <button type="button" id="holdButton" class="btn btn-primary">&nbsp;暂存&nbsp;</button>&nbsp;
                            <button type="button" id="readHoldButton" class="btn btn-primary">读取暂存</button>&nbsp;
                            <button type="button" id="submitButton" class="btn btn-primary">&nbsp;提交&nbsp;</button>&nbsp;
                            <button type="button" id="templateButton" onclick="showSaveTemplateDialog()" class="btn btn-primary">设为模板</button>&nbsp;
                            <button type="button" id="readMedicalR"  class="btn btn-primary">读取病历</button>
                        </div>
                        <fieldset>
                            <legend class="">门诊病例信息</legend>
                        </fieldset>
                        <div class="form-group">
                            <label class="col-md-2 control-label text-right" for="chiefComplaint">主诉</label>
                            <div class="col-md-10 controls">
                                <textarea style="min-width: 100%" class="input-lg" id="chiefComplaint" name="chiefComplaint" rows="3"></textarea>
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
                    <%--诊断查找--%>
                    <div class="row" style="padding-top: 10px">
                        <div class="col-md-5">
                            <label class="col-md-4 control-label text-right" for="diseaseMnemonicCodeInput">诊断查找</label>
                            <div class="col-md-6 input-group">
                                <input type="text" class="form-control" placeholder="输入助记码" id="diseaseMnemonicCodeInput" name="diseaseMnemonicCode"/>
                                <ul id="diseaseMnemonicCodeInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                                </ul>
                            </div>
                        </div>
                        <div class="pull-right" style="width: 80px">
                            <div class="">
                                <button type="button" onclick="confirmed()" class="btn btn-default">&nbsp;确诊&nbsp;</button>
                            </div>
                        </div>
                        <div class="pull-right" style="width: 100px">
                            <div class="">
                                <button type="button" onclick="resetDiagnoseTableBody()" class="btn btn-default">清空诊断</button>
                            </div>
                        </div>
                        <div class="pull-right" style="width: 100px">
                            <div class="">
                                <button type="button" id="addDiagnose" class="btn btn-primary">新增诊断</button>
                            </div>
                        </div>
                        <div class="pull-right" style="width: 100px">
                            <div class="" >
                                <button type="button" id="foundDiagnose" class="btn btn-primary">诊断查询</button>
                            </div>
                        </div>
                    </div>
                    <%--病历诊断--%>
                    <form role="form" id="diagnosesInfo" >
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th class="col-md-2">国际ICD编码</th>
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
                    <%--病历首页标签页右侧的标签页--%>
                    <div class="col-md-2" style="border: solid 1px #2aabd2;width: 100%;height: 600px;overflow: auto">
                        <ul id="medicalRecordMiniTab" class="nav nav-tabs">
                            <li class="active"><a href="#medicalRecordCommon" data-toggle="tab">模板</a></li>
                            <li><a href="#commonDiagnoses" data-toggle="tab">常用诊断</a></li>
                            <li><a href="#historyMedicalRecord" data-toggle="tab">历史病例</a></li>
                        </ul>
                        <div id="medicalRecordMiniTabContent" class="tab-content">
                            <%--病例模板标签页--%>
                            <div class="tab-pane fade in active" id="medicalRecordCommon">
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
                            <%--常用诊断标签页--%>
                            <div class="tab-pane fade" id="commonDiagnoses">
                                <div style="height: 450px;overflow: auto" >
                                    <div>
                                        <button type="button" onclick="showCommonDiagnoseDialog()" class="btn btn-primary">添加常用诊断</button>&nbsp;
                                    </div>
                                    <fieldset>
                                        <div>
                                            <legend>常用诊断</legend>
                                        </div>
                                    </fieldset>
                                    <div id="displayCommonDiagnoses">
                                    </div>
                                </div>
                            </div>
                            <%--历史病例标签页--%>
                            <div class="tab-pane fade" id="historyMedicalRecord">
                                <div style="height: 450px;overflow: auto">
                                    <div>
                                        <button type="button" id="findHistoryMedicalRecordButton" onclick="getHistoryMedicalRecord()" class="btn btn-primary">&nbsp;&nbsp;查找&nbsp;&nbsp;</button>&nbsp;
                                    </div>
                                    <fieldset>
                                        <div>
                                            <legend class="">历史病例</legend>
                                        </div>
                                    </fieldset>
                                    <div id="displayHistoryMedicalRecord">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="inspectionInfoTab">
                <%--检查标签页--%>
                <div class="col-md-8 center-block" style="width: 70%;height: 600px;overflow: auto">
                    <fieldset>
                        <div>
                            <legend class="">开立检查</legend>
                        </div>
                    </fieldset>
                    <div style="height: 300px;overflow: auto">
                    <%--检查查找--%>
                    <div class="row" style="padding-top: 3px">
                        <div class="col-md-5">
                            <label class="col-md-4 control-label text-right" for="inspectionMnemonicCodeInput">检查查找</label>
                            <div class="col-md-6 input-group">
                                <input type="text" class="form-control" placeholder="输入助记码" id="inspectionMnemonicCodeInput" name="inspectionMnemonicCode"/>
                                <ul id="inspectionMnemonicCodeInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                                </ul>
                            </div>
                        </div>
                        <div class="pull-right" style="width: 100px">
                            <div class="">
                                <button type="button" onclick="resetInspectionTableBody()" class="btn btn-default">清空项目</button>
                            </div>
                        </div>
                        <div class="pull-right" style="width: 100px">
                            <div class="">
                                <button type="button" id="openInspection" onclick="openInspections()" class="btn btn-primary">开立项目</button>
                            </div>
                        </div>
                        <div class="pull-right" style="width: 100px">
                            <div class="" >
                                <button type="button" id="foundInspection" onclick="findOneInspection()" class="btn btn-primary">新增检查</button>
                            </div>
                        </div>
                    </div>
                    <%--要开立的检查--%>
                    <form role="form" id="inspectionsInfo" >
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th class="col-md-2">项目编码</th>
                                <th class="col-md-2">名称</th>
                                <th class="col-md-3">价格</th>
                                <%--<th>类型</th>--%>
                            </tr>
                            </thead>
                            <tbody id="inspectionTableBody">
                            <tr>
                                <th style="display: none"><input type="text" class="form-control" id="inspections0id" name="inspections[0].nonDrugListId"/></th>
                                <th><input type="text" class="form-control" id="inspections0itemCode" readonly/></th>
                                <th><input type="text" class="form-control" id="inspections0itemName" readonly/></th>
                                <th><input type="text" class="form-control" id="inspections0price" name="inspections[0].cost" readonly/></th>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                    </div>
                    <div class="pull-right" style="width: 100px">
                        <div class="" >
                            <button type="button" onclick="addPresentInspectionsToDialog()"  class="btn btn-primary">存为组套</button>
                        </div>
                    </div>
                    <div class="pull-right" style="width: 150px">
                        <div class="" >
                            <button type="button" onclick="getOpenedInspections()"  class="btn btn-primary">显示已开立项目</button>
                        </div>
                    </div>
                    <fieldset>
                        <legend class="">查看已开立检查</legend>
                    </fieldset>
                    <div style="height: 300px;overflow: auto">
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th class="col-md-3">名称</th>
                                <th class="col-md-3">价格</th>
                                <th class="col-md-2">检查结果</th>
                                <th class="col-md-2">作废</th>
                                <%--<th>类型</th>--%>
                            </tr>
                            </thead>
                            <tbody id="openedInspectionTableBody">
                            <tr>
                                <th style="display: none"><input type="text" class="form-control" id="openedInspections0id"/></th>
                                <th><input type="text" class="form-control" id="openedInspections0name" readonly/></th>
                                <th><input type="text" class="form-control" id="openedInspections0cost" readonly/></th>
                                <th><input type="button" class="btn btn-primary" onclick="lookInspectionResult(0)" id="openedInspections0lookButton" value="查看"/></th>
                                <th><input type="button" class="btn btn-danger" onclick="invalidInspection(0)" id="openedInspections0invalidButton" value="作废"/></th>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-2 center-block" style="width: 29%">
                        <%--病历首页标签页右侧的标签页--%>
                        <div class="col-md-2" style="border: solid 1px #2aabd2;width: 100%;height: 600px;overflow: auto">
                            <ul id="medicalRecordMiniTab000" class="nav nav-tabs">
                                <li class="active"><a href="#setTab" data-toggle="tab">组套</a></li>
                                <li><a href="#commonInspections" data-toggle="tab">常用检查</a></li>
<%--                                <li><a href="#" data-toggle="tab">历史病例</a></li>--%>
                            </ul>
                            <div id="medicalRecordMiniTabContent000" class="tab-content">
                                <%--病例模板标签页--%>
                                <div class="tab-pane fade in active" id="setTab">
                                    <div style="height: 450px;overflow: auto">
                                        <div>
                                            <button type="button" onclick="showSaveAsSetDialog()" class="btn btn-primary">添加组套</button>&nbsp;
<%--                                            <button type="button" id="hospitalCommonButton00" onclick="getHospitalCommon()" class="btn btn-primary">医院</button>&nbsp;--%>
<%--                                            <button type="button" id="departmentCommonButton00" onclick="getDepartmentCommon()" class="btn btn-primary">科室</button>&nbsp;--%>
<%--                                            <button type="button" id="personalCommonButton00" onclick="getPersonalCommon()" class="btn btn-primary">个人</button>&nbsp;--%>
                                        </div>
                                        <fieldset>
                                            <div>
                                                <legend class="">组套</legend>
                                            </div>
                                        </fieldset>
                                        <div id="displaySets">
                                        </div>
                                    </div>
                                </div>
                                <%--常用检查标签页--%>
                                <div class="tab-pane fade" id="commonInspections">
                                    <div style="height: 450px;overflow: auto" >
                                        <div>
                                            <button type="button" onclick="showCommonInspectionDialog()" class="btn btn-primary">添加常用检查</button>&nbsp;
                                        </div>
                                        <fieldset>
                                            <div>
                                                <legend>常用检查</legend>
                                            </div>
                                        </fieldset>
                                        <div id="displayCommonInspections">
                                        </div>
                                    </div>
                                </div>
<%--                                &lt;%&ndash;历史病例标签页&ndash;%&gt;--%>
<%--                                <div class="tab-pane fade" id="historyMedicalRecord">--%>
<%--                                    <div style="height: 450px;overflow: auto">--%>
<%--                                        <div>--%>
<%--                                            <button type="button" id="findHistoryMedicalRecordButton000" onclick="getHistoryMedicalRecord()" class="btn btn-primary">&nbsp;&nbsp;查找&nbsp;&nbsp;</button>&nbsp;--%>
<%--                                        </div>--%>
<%--                                        <fieldset>--%>
<%--                                            <div>--%>
<%--                                                <legend class="">历史病例</legend>--%>
<%--                                            </div>--%>
<%--                                        </fieldset>--%>
<%--                                        <div id="displayHistoryMedicalRecord00">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
                            </div>
                        </div>
                    </div>
<%--                <form role="form" id="inspectionInfo">--%>
<%--                    <div class="col-md-5 pull-right">--%>
<%--                        <input type="reset" id="inspectionInfoResetButton" class="btn btn-default" value="清屏" />&nbsp;--%>
<%--                        <button type="button" id="lookButton" class="btn btn-primary">&nbsp;查看&nbsp;</button>&nbsp;--%>
<%--&lt;%&ndash;                        <button type="button" id="readHoldButton" class="btn btn-primary">读取暂存</button>&nbsp;&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <button type="button" id="submitButton" class="btn btn-primary">&nbsp;提交&nbsp;</button>&nbsp;&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <button type="button" id="templateButton" onclick="showSaveTemplateDialog()" class="btn btn-primary">设为模板</button>&nbsp;&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <button type="button" id="readMedicalR"  class="btn btn-primary">读取病历</button>&ndash;%&gt;--%>
<%--                    </div>--%>
<%--                    <fieldset>--%>
<%--                        <legend class="">检查开立</legend>--%>
<%--                    </fieldset>--%>
<%--                    --%>
<%--                </form>--%>
            </div>
            <div class="tab-pane fade" id="dingdan">
                <p>订单中心</p>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript">
<%--    弹出的对话框  --%>
    //设为常用项目弹出框
    function showCommonInspectionDialog() {
        $('#commonInspectionDialog').dialog({
            modal:true,
            width:"600",
            height:"480"
        });
        document.getElementById("commonInspectionDialog").style.display="block";
    }
        //设为常用项目弹出框的返回按钮
    function closeCommonInspectionDialog() {
        $('#commonInspectionDialog').dialog("close");
        $("#commonInspectionDialogReset").click();
    }
        //设为常用项目弹出框的添加按钮
    function addCommonInspectionDialog() {
        $("#commonInspectionDialogDoctorId").val($("#doctorID").val());
        $.ajax({
            type: "POST",
            url: "inspection/setCommon",
            data: $('#commonInspectionDialogForm').serialize(),
            success: function () {
                alert("设置成功");
                getCommonInspectionList();
                closeCommonInspectionDialog();
            }
        });
    }
    //查看组套弹出框
    function showModifySetDialog() {
        $('#modifySetDialog').dialog({
            modal:true,
            width:"600",
            height:"480"
        });
        document.getElementById("modifySetDialog").style.display="block";
    }
        //查看组套弹出框的返回按钮
    function closeModifySetDialog() {
        $('#modifySetDialog').dialog("close");
        $("#modifySetDialogReset").click();
    }
        //查看组套弹出框的修改按钮
    function saveModifySetDialog() {
        $.ajax({
            type: "POST",
            url: "inspection/updateSet",
            data: $.param({doctorID : $("#doctorID").val()}) + '&' + $('#modifySetDialogForm').serialize(),
            success: function (result) {
                alert(result.msg);
                getAllSets();
                closeModifySetDialog();
            }
        });
    }
    //设为组套弹出框
    function showSaveAsSetDialog() {
        $('#saveAsSetDialog').dialog({
            modal:true,
            width:"600",
            height:"480"
        });
        document.getElementById("saveAsSetDialog").style.display="block";
    }
        //设为组套弹出框的返回按钮
    function closeSaveAsSetDialog() {
        $('#saveAsSetDialog').dialog("close");
        $("#saveAsSetDialogReset").click();
        dialogResetInspectionTableBody();
    }
    //历史病例弹出框
    function showHistoryMedicalRecordDialog() {
        if ($("#doctorID").val() == "") {
            alert("请先登录")
        }else {
            $('#historyMedicalRecordDialog').dialog({
                modal:true,
                width:"600",
                height:"480"
            });
            document.getElementById("historyMedicalRecordDialog").style.display="block";
        }
    }
        //历史病例弹出框的确定按钮
    function closeHistoryMedicalRecordDialog() {
        $('#historyMedicalRecordDialog').dialog("close");
    }
    //添加常用诊断弹出框
    function showCommonDiagnoseDialog() {
        if ($("#doctorID").val() == "") {
            alert("请先登录")
        }else {
            $('#commonDiagnoseDialog').dialog({
                modal:true,
                width:"600",
                height:"625"
            });
            document.getElementById("commonDiagnoseDialog").style.display="block";
        }
    }
        //添加常用诊断弹出框的返回按钮
    function cancelCommonDiagnoseDialog() {
        $("#commonDiagnoseDialogReset").click();
        $('#commonDiagnoseDialog').dialog("close");
    }
        //添加常用诊断弹出框的添加按钮
    function saveCommonDiagnoseDialog() {
        if($("#commonDiagnoseDialogDiseaseId").val() == ""){
            alert("请通过查询添加常用诊断");
        }else {
            var doctorID = Number($("#doctorID").val());
            $("#commonDiagnoseDialogDoctorId").val(doctorID);
            $.ajax({
                type: "POST",
                url: "medicalRecord/addCommonDiagnose",
                data: $("#commonDiagnoseDialogForm").serialize(),
                success: function () {
                    alert("保存成功");
                    setDisplayCommonDiagnoses();
                    $("#commonDiagnoseDialogReset").click();
                    $('#commonDiagnoseDialog').dialog("close");
                },
                error: function () {
                    alert("保存失败");
                }
            });
        }
    }
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
        //    TODO 需要更新的函数
        getWaitingDiagnosePatients();
        getDiagnosedPatients();
        $("#medicalRecordInfoResetButton").click();
        getHospitalCommon();
        setDisplayCommonDiagnoses();
        getAllSets();
        getCommonInspectionList();
    }

//病历首页

    //历史病例列表
    var historyMedicalRecords = null;
    //生成历史病例列表
    function setHistoryMedicalRecords(){
        var str = "";
        $("#displayHistoryMedicalRecord").html("");
        for (let i = 0;i < historyMedicalRecords.length;i++){
            str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + historyMedicalRecords[i].isCommon + "' readonly/>\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='lookHistoryMedicalRecord(" + i + ")'>查看</button>\n" +
                "</div>";
        }
        $("#displayHistoryMedicalRecord").append(str);
    }
    //获取历史病例
    function getHistoryMedicalRecord() {
        var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
        $.ajax({
            type: "POST",
            url: "medicalRecord/getHistoryMedicalRecord",
            data: {medicalRecordNo:medicalRecordNo},
            success: function (result) {
                historyMedicalRecords = result;
                setHistoryMedicalRecords();
            },
            error: function () {
                alert("无");
            }
        });
    }
    //查看历史病例
    function lookHistoryMedicalRecord(i) {
        $("#historyMedicalRecordChiefComplaint").val(historyMedicalRecords[i].chiefComplaint);
        $("#historyMedicalRecordHistoryOfPresentIllness").val(historyMedicalRecords[i].historyOfPresentIllness);
        $("#historyMedicalRecordTreatmentOfCurrentIllness").val(historyMedicalRecords[i].treatmentOfCurrentIllness);
        $("#historyMedicalRecordPastHistory").val(historyMedicalRecords[i].pastHistory);
        $("#historyMedicalRecordAllergyHistory").val(historyMedicalRecords[i].allergyHistory);
        $("#historyMedicalRecordPhysicalExamination").val(historyMedicalRecords[i].physicalExamination);
        showHistoryMedicalRecordDialog();
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
                            "<input type=\"radio\" class=\"col-xs-2\" style=\"width: 20%\"  name=\"patientMedicalRecordNo\" value='" + diagnosedPatients[i].medicalRecordNo + "' />\n" +
                            "<input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + diagnosedPatients[i].medicalRecordNo + "  " + diagnosedPatients[i].patientName + "  " + diagnosedPatients[i].patientAge + "岁" + "' readonly/>\n" +
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
    //常用诊断对话框的疾病助记码动态查询
    $(function(){
        //载入时隐藏下拉li
        $("#commonDiagnoseDialogDiseaseMnemonicCodeInputUl").hide(0);
    });
    $("#commonDiagnoseDialogDiseaseMnemonicCodeInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#commonDiagnoseDialogDiseaseMnemonicCodeInput").val().length == 0){
            $("#commonDiagnoseDialogDiseaseMnemonicCodeInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"disease/findByAttributeWithTwoParameters",
            data: {attribute_name : "disease_mnemonic_code",attribute : $("#commonDiagnoseDialogDiseaseMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                if(result){
                    var tempDiseases = result;
                    var str = "";
                    for (var i = 0;i < tempDiseases.length; i++){
                        str += "<li value='" + tempDiseases[i].diseaseName + "'>" + tempDiseases[i].diseaseName + "</li>\n";
                    }
                    $("#commonDiagnoseDialogDiseaseMnemonicCodeInputUl").show(0);
                    $("#commonDiagnoseDialogDiseaseMnemonicCodeInputUl").html(str);
                }else {
                    alert("无此疾病");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#commonDiagnoseDialogDiseaseMnemonicCodeInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#commonDiagnoseDialogDiseaseMnemonicCodeInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});
                $("#commonDiagnoseDialogDiseaseMnemonicCodeInputUl li").click(function(){
                    $("#commonDiagnoseDialogDiseaseMnemonicCodeInput").val($(this).html());
                    $("#commonDiagnoseDialogDiseaseMnemonicCodeInputUl").hide(0);
                });
            }
        });
    });
    //常用诊断对话框的疾病查找按钮
    function setCommonDiagnoseDialogFoundDiagnose(){
        $.ajax({
            type: "POST",
            url: "disease/findWithType",
            data: {attribute_name : "disease_name",attribute : $("#commonDiagnoseDialogDiseaseMnemonicCodeInput").val()},
            success: function (result) {
                var disease = result;
                $("#commonDiagnoseDialogDiseaseId").val(disease[0].id);
                $("#commonDiagnoseDialogICDCode").val(disease[0].internationalIcdCode);
                $("#commonDiagnoseDialogDiseaseName").val(disease[0].diseaseName);
                if (disease[0].diagnoseDirectoryName == "中医") {
                    $("#commonDiagnoseDialogDiseaseType").val("2");
                }else {
                    $("#commonDiagnoseDialogDiseaseType").val("1");
                }
            }
        });
        $("#commonDiagnoseDialogDiseaseMnemonicCodeInput").val("");
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
        var doctorID = $("#doctorID").val();
        if(doctorID != ""){
            $.ajax({
                type: "POST",
                url: "medicalRecord/getCommonDiagnoses",
                data: {doctorID : doctorID},
                async: false,
                success: function (result) {
                    displayCommonDiagnoses = result;
                    var str = "";
                    $("#displayCommonDiagnoses").html("");
                    for (let i = 0;i < displayCommonDiagnoses.length;i++){
                        str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                            "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + displayCommonDiagnoses[i].majorDiagnoseSign + "' readonly/>\n" +
                            "    <button type=\"button\" class=\"btn btn-primary\" onclick='useCommonDiagnose(" + i + ")'>引用</button>&nbsp;\n" +
                            "    <button type=\"button\" class=\"btn btn-danger\" onclick='deleteCommonDiagnose(" + i + ")'>删除</button>\n" +
                            "</div>";
                    }
                    $("#displayCommonDiagnoses").append(str);
                },
                error :function () {
                    alert("获取常用诊断失败");
                }
            });
        }
    }
    //删除常用诊断
    function deleteCommonDiagnose(i){
        var diagnoseID = displayCommonDiagnoses[i].id;
        $.ajax({
            type: "POST",
            url: "medicalRecord/deleteCommonDiagnoses",
            data: {diagnoseID : diagnoseID},
            async: false,
            success: function () {
                setDisplayCommonDiagnoses();
            },
            error :function () {
                alert("获取常用诊断失败");
            }
        });
    }
    //引用常用诊断
    function useCommonDiagnose(i){
        if ($(eval('diseases' + diagnoseNum + 'id')).val() != ""){
            $("#addDiagnose").click();
        }
        $(eval('diseases' + diagnoseNum + 'id')).val(displayCommonDiagnoses[i].diseaseId);
        $(eval('diseases' + diagnoseNum + 'internationalIcdCode')).val(displayCommonDiagnoses[i].suspectedSign);
        $(eval('diseases' + diagnoseNum + 'diseaseName')).val(displayCommonDiagnoses[i].majorDiagnoseSign);
        $(eval('diseases' + diagnoseNum + 'diseaseType')).val(displayCommonDiagnoses[i].diseaseType);
    }
    //模板列表
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
        $("#modifyTemplateCategory").val(medicalRecordTemplates[i].category);
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
    //清空病例首页下方的诊断
    function resetDiagnoseTableBody(){
        $("#diagnoseTableBody").html("");
        diagnoseNum = 0;
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
    }
    // //病历首页读取已诊患者的病历信息
    // function readMedicalR() {
    //     var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
    //     $.ajax({
    //         type: "POST",
    //         url: "medicalRecord/findByMedicalNo",
    //         data: {medicalRecordNo:medicalRecordNo},
    //         success: function (result) {
    //             if (result == null){
    //                 alert("该患者未看诊");
    //             } else {
    //                 var medicalRecord = result;
    //                 $("#chiefComplaint").val(medicalRecord.chiefComplaint);
    //                 $("#historyOfPresentIllness").val(medicalRecord.historyOfPresentIllness);
    //                 $("#treatmentOfCurrentIllness").val(medicalRecord.treatmentOfCurrentIllness);
    //                 $("#pastHistory").val(medicalRecord.pastHistory);
    //                 $("#allergyHistory").val(medicalRecord.allergyHistory);
    //                 $("#physicalExamination").val(medicalRecord.physicalExamination);
    //             }
    //         },
    //         error: function () {
    //             alert("获取失败")
    //         }
    //     });
    // }

    //确诊
    function confirmed(){
        var doctorID = $("#doctorID").val();
        var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
        $.ajax({
            type: "POST",
            url: "medicalRecord/confirmed",
            data: $.param({doctorId:doctorID,medicalRecordNo:medicalRecordNo}) + '&' + $('#diagnosesInfo').serialize(),
            success: function () {
                alert("确诊");
            },
            error: function () {
                alert("提交失败");
            }
        });
    }

//检查
    //检查数目
    var inspectionNum = 0;
    //查找具体的一项检查并添加到检查表单中
    function findOneInspection(){
        $.ajax({
            type:"POST",
            url :"inspection/findByAttribute",
            data: {type : "检查",attribute_name : "item_name",attribute : $("#inspectionMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                var inspection = result;
                if ($(eval('inspections' + inspectionNum + 'id')).val() != ""){
                    addOneInspection();
                }
                $(eval('inspections' + inspectionNum + 'id')).val(inspection[0].id);
                $(eval('inspections' + inspectionNum + 'itemCode')).val(inspection[0].itemCode);
                $(eval('inspections' + inspectionNum + 'itemName')).val(inspection[0].itemName);
                $(eval('inspections' + inspectionNum + 'price')).val(inspection[0].price);
                $("#inspectionMnemonicCodeInput").val("");
            }
        });
    }
    //检查的form表单中添加一条
    function addOneInspection(){
        inspectionNum = inspectionNum + 1;
        var str = "<tr>\n" +
            "    <th style=\"display: none\"><input type=\"text\" class=\"form-control\" id=\"inspections" + inspectionNum + "id\" name=\"inspections[" + inspectionNum + "].nonDrugListId\"/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"inspections" + inspectionNum + "itemCode\" readonly/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"inspections" + inspectionNum + "itemName\" readonly/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"inspections" + inspectionNum + "price\" name=\"inspections[" + inspectionNum + "].cost\" readonly/></th>\n" +
            "</tr>";
        $("#inspectionTableBody").append(str);
    }
    //清空检查项目
    function resetInspectionTableBody(){
        inspectionNum = -1;
        $("#inspectionTableBody").html("");
        addOneInspection();
    }
    //存为组套对话框的添加项目
        //检查数目
        var dialogInspectionNum = 0;
        //查找具体的一项检查并添加到检查表单中
        function dialogFindOneInspection(){
            $.ajax({
                type:"POST",
                url :"inspection/findByAttribute",
                data: {type : "检查",attribute_name : "item_name",attribute : $("#saveAsSetDialogInspectionMnemonicCodeInput").val()},
                async: false,
                success:function(result){
                    var inspection = result;
                    if ($(eval('inspectionsInDialog' + dialogInspectionNum + 'itemCode')).val() != ""){
                        dialogAddOneInspection();
                    }
                    $(eval('inspectionsInDialog' + dialogInspectionNum + 'itemCode')).val(inspection[0].itemCode);
                    $(eval('inspectionsInDialog' + dialogInspectionNum + 'itemName')).val(inspection[0].itemName);
                    $(eval('inspectionsInDialog' + dialogInspectionNum + 'price')).val(inspection[0].price);
                    $("#saveAsSetDialogInspectionMnemonicCodeInput").val("");
                }
            });
        }
        //检查的form表单中添加一条
        function dialogAddOneInspection(){
            dialogInspectionNum = dialogInspectionNum + 1;
            var str = "<tr>\n" +
                "    <th><input type=\"text\" class=\"form-control\" id=\"inspectionsInDialog" + dialogInspectionNum + "itemCode\" readonly/></th>\n" +
                "    <th><input type=\"text\" class=\"form-control\" id=\"inspectionsInDialog" + dialogInspectionNum + "itemName\" name='itemName' readonly/></th>\n" +
                "    <th><input type=\"text\" class=\"form-control\" id=\"inspectionsInDialog" + dialogInspectionNum + "price\" readonly/></th>\n" +
                "</tr>";
            $("#saveAsSetInspectionTableBody").append(str);
        }
        //清空检查项目
        function dialogResetInspectionTableBody(){
            dialogInspectionNum = -1;
            $("#saveAsSetInspectionTableBody").html("");
            dialogAddOneInspection();
        }
    //存为组套将当前项目添加到对话框中
    function addPresentInspectionsToDialog() {
        for (let i = 0; i < openedInspections.length; i++) {
            if ($(eval('inspectionsInDialog' + dialogInspectionNum + 'itemCode')).val() != ""){
                dialogAddOneInspection();
            }
            $(eval('inspectionsInDialog' + dialogInspectionNum + 'itemCode')).val(210101100 + i);
            $(eval('inspectionsInDialog' + dialogInspectionNum + 'itemName')).val(openedInspections[i].nonDrugListName);
            $(eval('inspectionsInDialog' + dialogInspectionNum + 'price')).val(openedInspections[i].cost);
        }
        showSaveAsSetDialog();
    }
    //存为组套向后端发送数据
    function saveInspectionSet() {
        var doctorID = $("#doctorID").val();
        $.ajax({
            type: "POST",
            url: "inspection/saveInspectionSet",
            data: $.param({doctorId:doctorID}) + '&' + $("#saveAsSetInspectionSetForm").serialize() + '&' + $('#saveAsSetSetDetailForm').serialize(),
            success: function () {
                alert("保存成功");
                closeSaveAsSetDialog();
                getAllSets();
            },
            error: function () {
                alert("提交失败");
            }
        });
    }
    //开立检查项目
    function openInspections(){
        var doctorID = $("#doctorID").val();
        var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
        $.ajax({
            type: "POST",
            url: "inspection/submitInspections",
            data: $.param({doctorId:doctorID,medicalRecordNo:medicalRecordNo}) + '&' + $('#inspectionsInfo').serialize(),
            success: function () {
                alert("所有项目已开立");
                getOpenedInspections();
                resetInspectionTableBody();
            },
            error: function () {
                alert("开立失败");
            }
        });
    }
    //根据检查助记码动态查询
    $(function(){
        //载入时隐藏下拉li
        $("#inspectionMnemonicCodeInputUl").hide(0);
    });
    $("#inspectionMnemonicCodeInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#inspectionMnemonicCodeInput").val().length == 0){
            $("#inspectionMnemonicCodeInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"inspection/findByAttribute",
            data: {type : "检查",attribute_name : "mnemonic_code",attribute : $("#inspectionMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                if(result){
                    var tempDiseases = result;
                    var str = "";
                    for (var i = 0;i < tempDiseases.length; i++){
                        str += "<li value='" + tempDiseases[i].itemName + "'>" + tempDiseases[i].itemName + "</li>\n";
                    }
                    $("#inspectionMnemonicCodeInputUl").show(0);
                    $("#inspectionMnemonicCodeInputUl").html(str);
                }else {
                    alert("无此项目");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#inspectionMnemonicCodeInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#inspectionMnemonicCodeInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#inspectionMnemonicCodeInputUl li").click(function(){
                    $("#inspectionMnemonicCodeInput").val($(this).html());
                    $("#inspectionMnemonicCodeInputUl").hide(0);
                });
            }
        });
    });
    //对话框的根据检查助记码动态查询
    $(function(){
        //载入时隐藏下拉li
        $("#saveAsSetDialogInspectionMnemonicCodeInputUl").hide(0);
    });
    $("#saveAsSetDialogInspectionMnemonicCodeInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#saveAsSetDialogInspectionMnemonicCodeInput").val().length == 0){
            $("#saveAsSetDialogInspectionMnemonicCodeInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"inspection/findByAttribute",
            data: {type : "检查",attribute_name : "mnemonic_code",attribute : $("#saveAsSetDialogInspectionMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                if(result){
                    var tempDiseases = result;
                    var str = "";
                    for (var i = 0;i < tempDiseases.length; i++){
                        str += "<li value='" + tempDiseases[i].itemName + "'>" + tempDiseases[i].itemName + "</li>\n";
                    }
                    $("#saveAsSetDialogInspectionMnemonicCodeInputUl").show(0);
                    $("#saveAsSetDialogInspectionMnemonicCodeInputUl").html(str);
                }else {
                    alert("无此项目");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#saveAsSetDialogInspectionMnemonicCodeInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#saveAsSetDialogInspectionMnemonicCodeInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#saveAsSetDialogInspectionMnemonicCodeInputUl li").click(function(){
                    $("#saveAsSetDialogInspectionMnemonicCodeInput").val($(this).html());
                    $("#saveAsSetDialogInspectionMnemonicCodeInputUl").hide(0);
                });
            }
        });
    });
    //设为常用项目对话框的根据检查助记码动态查询
    $(function(){
        //载入时隐藏下拉li
        $("#commonInspectionDialogDiseaseMnemonicCodeInputUl").hide(0);
    });
    $("#commonInspectionDialogDiseaseMnemonicCodeInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#commonInspectionDialogDiseaseMnemonicCodeInput").val().length == 0){
            $("#commonInspectionDialogDiseaseMnemonicCodeInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"inspection/findByAttribute",
            data: {type : "检查",attribute_name : "mnemonic_code",attribute : $("#commonInspectionDialogDiseaseMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                if(result){
                    var tempDiseases = result;
                    var str = "";
                    for (var i = 0;i < tempDiseases.length; i++){
                        str += "<li value='" + tempDiseases[i].itemName + "'>" + tempDiseases[i].itemName + "</li>\n";
                    }
                    $("#commonInspectionDialogDiseaseMnemonicCodeInputUl").show(0);
                    $("#commonInspectionDialogDiseaseMnemonicCodeInputUl").html(str);
                }else {
                    alert("无此项目");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#commonInspectionDialogDiseaseMnemonicCodeInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#commonInspectionDialogDiseaseMnemonicCodeInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#commonInspectionDialogDiseaseMnemonicCodeInputUl li").click(function(){
                    $("#commonInspectionDialogDiseaseMnemonicCodeInput").val($(this).html());
                    $("#commonInspectionDialogDiseaseMnemonicCodeInputUl").hide(0);
                });
            }
        });
    });
    //常用项目查找并添加到输入框中
    function commonInspectionDialogFind() {
        $.ajax({
            type:"POST",
            url :"inspection/findByAttribute",
            data: {type : "检查",attribute_name : "item_name",attribute : $("#commonInspectionDialogDiseaseMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                var inspection = result;
                $("#commonInspectionDialogNonDrugListId").val(inspection[0].id)
                $("#commonInspectionDialogCode").val(inspection[0].itemCode);
                $("#commonInspectionDialogNonDrugListName").val(inspection[0].itemName);
                $("#commonInspectionDialogCost").val(inspection[0].price);
                $("#commonInspectionDialogDiseaseMnemonicCodeInput").val("");
            }
        });
    }
    //已开立的项目
    var openedInspections = null;
    //获取并显示已开立的项目
    function getOpenedInspections(){
        var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
        $.ajax({
            type: "POST",
            url: "inspection/getOpenedInspections",
            data: {medicalRecordNo : medicalRecordNo},
            success: function (result) {
                openedInspections = result.data;
                if (openedInspections == null){
                    alert("该患者没有开立项目");
                } else {
                    $("#openedInspectionTableBody").html("");
                    var str = "";
                    for (var i = 0; i < openedInspections.length; i++){
                        str += "<tr>\n" +
                            "    <th><input type=\"text\" class=\"form-control\" value='" + openedInspections[i].nonDrugListName + "' readonly/></th>\n" +
                            "    <th><input type=\"text\" class=\"form-control\" value='" + openedInspections[i].cost + "' readonly/></th>\n" +
                            "    <th><input type=\"button\" class=\"btn btn-primary\" onclick=\"lookInspectionResult(" + i + ")\" value=\"查看\"/></th> \n" +
                            "    <th><input type=\"button\" class=\"btn btn-danger\" onclick=\"invalidInspection(" + i + ")\" value=\"作废\"/></th>\n" +
                            "</tr>";
                    }
                    $("#openedInspectionTableBody").append(str);
                }
            },
            error: function () {
                alert("开立失败");
            }
        });
    }
    //查看检查结果
    function lookInspectionResult(i){
        $.ajax({
            type: "POST",
            url: "inspection/getInspectionResult",
            data: {id : openedInspections[i].id},
            success: function (result) {
                alert(result.msg);
            },
            error: function () {
                alert("获取失败");
            }
        });
    }
    //作废开立项目
    function invalidInspection(i){
        $.ajax({
            type: "POST",
            url: "inspection/invalidInspection",
            data: openedInspections[i],
            success: function (result) {
                var str = result.msg;
                alert(str);
                getOpenedInspections();
            },
            error: function () {
                alert("作废失败");
            }
        });
    }
    //所有组套
    var allInspectionSets = null;
    //获取组套
    function getAllSets(){
        $.ajax({
            type: "POST",
            url: "inspection/getAllSets",
            async: false,
            data: {doctorId : $("#doctorID").val()},
            success: function (result) {
                allInspectionSets = result;
                displayAllSets();
            }
        });
    }
    //生成组套列表
    function displayAllSets(){
        var str = "";
        $("#displaySets").html("");
        for (let i = 0;i < allInspectionSets.length;i++){
            str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + allInspectionSets[i].combinatorialName + "' readonly/>\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='useSet(" + i + ")'>引用</button>&nbsp;\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='modifySet(" + i + ")'>查看</button>\n" +
                "    <button type=\"button\" class=\"btn btn-danger\" onclick='deleteSet(" + i + ")'>删除</button>\n" +
                "</div>";
        }
        $("#displaySets").append(str);
    }
    //引用组套
    function useSet(i){
        $.ajax({
            type: "POST",
            url: "inspection/findDetailBySetId",
            async: false,
            data: {setId : allInspectionSets[i].id},
            success: function (result) {
                var inspectionSetDetails = result;
                for (let i = 0; i < inspectionSetDetails.length; i++) {
                    if ($(eval('inspections' + inspectionNum + 'id')).val() != ""){
                        addOneInspection();
                    }
                    $(eval('inspections' + inspectionNum + 'id')).val(inspectionSetDetails[i].nonDrugListId);
                    $(eval('inspections' + inspectionNum + 'itemCode')).val(inspectionSetDetails[i].itemCode);
                    $(eval('inspections' + inspectionNum + 'itemName')).val(inspectionSetDetails[i].itemName);
                    $(eval('inspections' + inspectionNum + 'price')).val(inspectionSetDetails[i].price);
                }
            }
        });
    }
    //查看组套
    function modifySet(i){
        $("#modifySetDialogId").val(allInspectionSets[i].id);
        $("#modifySetDialogDoctorId").val(allInspectionSets[i].doctorId);
        $("#modifySetDialogCombinatorialCode").val(allInspectionSets[i].combinatorialCode);
        $("#modifySetDialogCombinatorialName").val(allInspectionSets[i].combinatorialName);
        $("#modifySetDialogRequirement").val(allInspectionSets[i].requirement);
        $("#modifySetDialogCategory").val(allInspectionSets[i].category);
        showModifySetDialog();
    }
    //删除组套
    function deleteSet(i){
        $.ajax({
            type: "POST",
            url: "inspection/deleteSet",
            async: false,
            data: {setId : allInspectionSets[i].id,doctorId : $("#doctorID").val()},
            success: function (result) {
                alert(result.msg);
                getAllSets();
            }
        });
    }
    //常用项目目录
    var commonInspectionList = null;
    //获取并显示常用项目
    function getCommonInspectionList(){
        $.ajax({
            type: "POST",
            url: "inspection/getCommonInspectionList",
            async: false,
            data: {doctorId : $("#doctorID").val()},
            success: function (result) {
                commonInspectionList = result;
                var str = "";
                $("#displayCommonInspections").html("");
                for (let i = 0;i < commonInspectionList.length;i++){
                    str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                        "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + commonInspectionList[i].nonDrugListName + "  " + commonInspectionList[i].price + "元' readonly/>\n" +
                        "    <button type=\"button\" class=\"btn btn-primary\" onclick='useCommonInspection(" + i + ")'>引用</button>&nbsp;\n" +
                        "    <button type=\"button\" class=\"btn btn-danger\" onclick='deleteCommonInspection(" + i + ")'>删除</button>\n" +
                        "</div>";
                }
                $("#displayCommonInspections").append(str);
            }
        });
    }
    //引用常用项目
    function useCommonInspection(i){
        if ($(eval('inspections' + inspectionNum + 'id')).val() != ""){
            addOneInspection();
        }
        $(eval('inspections' + inspectionNum + 'id')).val(commonInspectionList[i].nonDrugListId);
        $(eval('inspections' + inspectionNum + 'itemCode')).val(commonInspectionList[i].itemCode);
        $(eval('inspections' + inspectionNum + 'itemName')).val(commonInspectionList[i].nonDrugListName);
        $(eval('inspections' + inspectionNum + 'price')).val(commonInspectionList[i].price);
    }
    //删除常用项目
    function deleteCommonInspection(i){
        $.ajax({
            type: "POST",
            url: "inspection/deleteCommonInspection",
            async: false,
            data: {commonInspectionId : commonInspectionList[i].id},
            success: function () {
                getCommonInspectionList();
            }
        });
    }

    //DOM结构加载完毕后执行
    $(document).ready(function(){
        //TODO 打开注释
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
        //设置暂存按钮功能
        $("#holdButton").click(function () {
            var doctorID = $("#doctorID").val();
            var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
            $.ajax({
                type: "POST",
                url: "medicalRecord/temporaryStorage",
                data: $.param({doctorId:doctorID,medicalRecordNo:medicalRecordNo}) + '&' + $("#medicalRecordInfo").serialize(),
                success: function () {
                    alert("病例已暂存");
                },
                error: function () {
                    alert("暂存失败")
                }
            });
        });
        //读取暂存病例首页
        $("#readHoldButton").click(function () {
            var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
            $.ajax({
                type: "POST",
                url: "medicalRecord/readTemporaryStorage",
                data: {medicalRecordNo:medicalRecordNo},
                success: function (result) {
                    var medicalRecord = result;
                    $("#chiefComplaint").val(medicalRecord.chiefComplaint);
                    $("#historyOfPresentIllness").val(medicalRecord.historyOfPresentIllness);
                    $("#treatmentOfCurrentIllness").val(medicalRecord.treatmentOfCurrentIllness);
                    $("#pastHistory").val(medicalRecord.pastHistory);
                    $("#allergyHistory").val(medicalRecord.allergyHistory);
                    $("#physicalExamination").val(medicalRecord.physicalExamination);
                },
                error: function () {
                    alert("读取失败")
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
                    $("#medicalRecordInfoResetButton").click();
                    resetDiagnoseTableBody();
                    getWaitingDiagnosePatients();
                    getDiagnosedPatients();
                    $("#displayHistoryMedicalRecord").html("");
                },
                error: function () {
                    alert("提交失败");
                }
            });
        });
        //病历首页读取已诊患者的病历信息
        $("#readMedicalR").click(function () {
            var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
            $.ajax({
                type: "POST",
                url: "medicalRecord/findByMedicalNo",
                data: {medicalRecordNo:medicalRecordNo},
                success: function (result) {
                    if (result.data == null){
                        alert("该患者未看诊");
                        $("#medicalRecordInfoResetButton").click();
                    } else {
                        var medicalRecord = result.data;
                        $("#chiefComplaint").val(medicalRecord.chiefComplaint);
                        $("#historyOfPresentIllness").val(medicalRecord.historyOfPresentIllness);
                        $("#treatmentOfCurrentIllness").val(medicalRecord.treatmentOfCurrentIllness);
                        $("#pastHistory").val(medicalRecord.pastHistory);
                        $("#allergyHistory").val(medicalRecord.allergyHistory);
                        $("#physicalExamination").val(medicalRecord.physicalExamination);
                    }
                },
                error: function () {
                    alert("获取失败")
                }
            });
        });
    });
</script>
</body>
</html>
