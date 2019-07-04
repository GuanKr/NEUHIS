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
<%--添加常用药品对话框--%>
<div id="commonDrugDialog" title="添加常用药品"  style="display: none" >
    <form id="commonDrugDialogForm">
        <div class="col-md-6">
            <label class="col-md-4 control-label text-right" for="commonDrugDialogDrugMnemonicCodeInput">药品查找</label>
            <div class="col-md-6 input-group">
                <input type="text" class="form-control" placeholder="输入助记码" id="commonDrugDialogDrugMnemonicCodeInput"/>
                <ul id="commonDrugDialogDrugMnemonicCodeInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                </ul>
            </div>
        </div>
        <div class="col-md-3">
            <div class="col-md-2">
                <button type="button" onclick="commonDrugDialogFind()" class="btn btn-primary">&nbsp;&nbsp;药品查询&nbsp;&nbsp;</button>
            </div>
        </div>
        <br><br><br>
        <p>药品名称：<input type="text" class="form-control" name="drugName" id="commonDrugDialogDrugName" readonly /></p>
        <p>药品规格：<input type="text" class="form-control" name="drugFormat" id="commonDrugDialogDrugFormat" readonly/></p>
        <div style="float: right;">
            <input type="button" class="btn btn-default" value="返回" onclick="closeCommonDrugDialog()"/>
            <input type="button" class="btn btn-primary" value="添加" onclick="addCommonDrugDialog()"/>
            <input style="display: none" type="reset" id="commonDrugDialogReset"/>
        </div>
    </form>
</div>
<%--查看修改处方组套对话框--%>
<div id="modifyDrugSetDialog" title="处方组套详情"  style="display: none" >
    <form id="modifyDrugSetDialogForm">
        <input type="text" style="display: none" name="id" id="modifyDrugSetDialogId"/>
        <input type="text" style="display: none" name="doctorId" id="modifyDrugSetDialogDoctorId"/>
        <p>组套编码：<input type="text" class="form-control" name="combinatorialCode" id="modifyDrugSetDialogCombinatorialCode"  /></p>
        <p>组套名称：<input type="text" class="form-control" name="combinatorialName" id="modifyDrugSetDialogCombinatorialName" /></p>
        <p>目的和要求：<input type="text" class="form-control" name="requirement" id="modifyDrugSetDialogRequirement" /></p>
        <p>适用范围：<select class="form-control" name="category" id="modifyDrugSetDialogCategory" >
            <option value ="全院">全院</option>
            <option value ="科室">科室</option>
            <option value ="个人">个人</option>
        </select>
        </p>
        <input style="display: none" type="reset" id="modifyDrugSetDialogReset"/>
    </form>
    <div style="float: right;">
        <input type="button" class="btn btn-default" value="返回" onclick="closeModifyDrugSetDialog()"/>
        <input type="button" class="btn btn-primary" value="修改" onclick="saveModifyDrugSetDialog()"/>
    </div>
</div>
<%--存为处方组套对话框--%>
<div id="saveAsDrugSetDialog" title="存为处方组套"  style="display: none" >
    <form id="saveAsDrugSetForm">
        <p>组套编码：<input type="text" class="form-control" name="combinatorialCode" id="saveAsDrugSetDialogCombinatorialCode"  /></p>
        <p>组套名称：<input type="text" class="form-control" name="combinatorialName" id="saveAsDrugSetDialogCombinatorialName" /></p>
        <p>目的和要求：<input type="text" class="form-control" name="requirement" id="saveAsDrugSetDialogRequirement" /></p>
        <p>适用范围：<select class="form-control" name="category" id="saveAsDrugSetDialogCategory" >
            <option value ="全院">全院</option>
            <option value ="科室">科室</option>
            <option value ="个人">个人</option>
        </select>
        </p>
        <input style="display: none" type="reset" id="saveAsDrugSetDialogReset"/>
    </form>
    <div class="col-md-8">
        <label class="col-md-4 control-label text-right" for="saveAsDrugSetDialogInspectionMnemonicCodeInput">药品查找</label>
        <div class="col-md-6 input-group">
            <input type="text" class="form-control" placeholder="输入助记码" id="saveAsDrugSetDialogInspectionMnemonicCodeInput"/>
            <ul id="saveAsDrugSetDialogInspectionMnemonicCodeInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
            </ul>
        </div>
    </div>
    <div class="pull-right" style="width: 100px">
        <div class="">
            <button type="button" onclick="dialogFindOneDrug()" class="btn btn-primary">添加项目</button>
        </div>
    </div>
    <form id="saveAsDrugSetSetDetailForm">
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th class="col-md-2">名称</th>
                <th class="col-md-2">规格</th>
                <th class="col-md-1">价格</th>
                <th class="col-md-2">用法</th>
                <th class="col-md-2">用量</th>
                <th class="col-md-2">频次</th>
            </tr>
            </thead>
            <tbody id="saveAsDrugSetTableBody">
            </tbody>
        </table>
    </form>
    <div style="float: right;">
        <input type="button" class="btn btn-default" value="取消" onclick="closeSaveAsDrugSetDialog()"/>
        <input type="button" class="btn btn-primary" value="保存" onclick="saveDrugSetDialog()"/>
    </div>
</div>
<%--查看检查检验结果对话框--%>
<div id="inspectionResultDialog" title="检查结果"  style="display: none" >
    <form>
        <p>结果：<textarea class="input-lg form-control" id="inspectionResultInput" rows="3" ></textarea></p>
        <div style="float: right;">
            <input type="button" class="btn btn-primary" value="确定" onclick="addInspectionResultAnalyze()"/>
            <input style="display: none" type="reset" id="inspectionResultDialogReset"/>
        </div>
    </form>
</div>
<%--添加常用项目对话框--%>
<div id="commonInspectionDialog" title="添加常用项目"  style="display: none" >
    <form id="commonInspectionDialogForm">
        <div class="col-md-3"><select class="form-control" id="commonInspectionDialogThreeSelectOne" >
            <option value="检查">检查</option>
            <option value="检验">检验</option>
            <option value="处置">处置</option>
        </select>
        </div>
        <div class="col-md-6">
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
        <p>组套类型：<select class="form-control" id="saveAsSetDialogThreeSelectOne" >
            <option value="检查">检查</option>
            <option value="检验">检验</option>
            <option value="处置">处置</option>
        </select>
        </p>
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
        <p>国际ICD编码：<input type="text" class="form-control" id="commonDiagnoseDialogICDCode" readonly/></p>
        <p>诊断名称：<input type="text" class="form-control" name="diseaseName" id="commonDiagnoseDialogDiseaseName" readonly/></p>
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
        <a class="navbar-brand">HIS</a>
        <ul class="nav navbar-nav" style="width: 93%">
            <li class="active"><a href="medicalRecord/medicalRecord">门诊医生工作站</a></li>
            <li class="active pull-right" style="top: 10px"><input style="top: 10px" class="btn btn-danger" type="button" id="logOutButton" value="退出"/></li>
            <li class="pull-right" id="loginUser"></li>
            <a style="display: none" id="logOut" href="${pageContext.request.contextPath}/logout">退出</a>
            <li style="display: none"><input id="doctorID"/></li>
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
    <%--右侧区域--%>
    <div class="col-md-8 center-block" style="border: solid 1px #2aabd2;width: 79.5%;height: 600px;overflow: auto">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#medicalRecordTab" data-toggle="tab">病历首页</a></li>
            <li><a href="#inspectionInfoTab" data-toggle="tab">项目</a></li>
            <li><a href="#drugList" data-toggle="tab">处方</a></li>
            <li><a href="#costList" data-toggle="tab">费用明细</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active center-block" id="medicalRecordTab">
                <%--病历首页标签页--%>
                <div class="col-md-8 center-block" style="width: 70%;height: 600px;overflow: auto">
                    <%--病历首页--%>
                    <form role="form" id="medicalRecordInfo">
                        <div class="col-md-6 pull-right">
                            <input type="reset" id="medicalRecordInfoResetButton" class="btn btn-default" value="清屏" />&nbsp;
                            <button type="button" id="holdButton" class="btn btn-primary">&nbsp;暂存&nbsp;</button>&nbsp;
                            <button type="button" id="readHoldButton" class="btn btn-primary">读取暂存</button>&nbsp;
                            <button type="button" id="submitButton" class="btn btn-primary">&nbsp;提交&nbsp;</button>&nbsp;
                            <button type="button" id="templateButton" onclick="showSaveTemplateDialog()" class="btn btn-primary">设为模板</button>&nbsp;
                            <button type="button" id="readMedicalR"  class="btn btn-primary">读取病历</button>
                            <button type="button" onclick="overMR()" class="btn btn-primary">诊毕</button>
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
                            </tr>
                            </thead>
                            <tbody id="diagnoseTableBody">
                            <tr>
                                <th style="display: none"><input type="text" class="form-control" id="diseases0id" name="diagnoses[0].diseaseId"/></th>
                                <th><input type="text" class="form-control" id="diseases0internationalIcdCode" readonly/></th>
                                <th><input type="text" class="form-control" id="diseases0diseaseName" name="diagnoses[0].diseaseName" readonly/></th>
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
                <%--项目标签页--%>
                <div class="col-md-8 center-block" style="width: 70%;height: 600px;overflow: auto">
                    <fieldset>
                        <div>
                            <legend class="">开立项目</legend>
                        </div>
                    </fieldset>
                    <div style="height: 300px;overflow: auto">
                        <%--检查查找--%>
                        <div class="row" style="padding-top: 3px">
                            <div class="col-md-2">
                                <select class="form-control" id="threeSelectOne">
                                    <option value="检查">检查</option>
                                    <option value="检验">检验</option>
                                    <option value="处置">处置</option>
                                </select>
                            </div>
                            <div class="col-md-5">
                                <label class="col-md-4 control-label text-right" for="inspectionMnemonicCodeInput">项目查找</label>
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
                                    <button type="button" id="foundInspection" onclick="findOneInspection()" class="btn btn-primary">新增项目</button>
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
                        <legend class="">查看已开立项目</legend>
                    </fieldset>
                    <div style="height: 300px;overflow: auto">
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th class="col-md-3">名称</th>
                                <th class="col-md-3">价格</th>
                                <th class="col-md-2">结果</th>
                                <th class="col-md-2">作废</th>
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
                            <li><a href="#commonInspections" data-toggle="tab">常用项目</a></li>
                        </ul>
                        <div id="medicalRecordMiniTabContent000" class="tab-content">
                            <%--组套标签页--%>
                            <div class="tab-pane fade in active" id="setTab">
                                <div style="height: 550px;overflow: auto">
                                    <div>
                                        <button type="button" onclick="showSaveAsSetDialog()" class="btn btn-primary">添加组套</button>&nbsp;
                                    </div>
                                    <div style="height: 300px;overflow: auto">
                                        <fieldset>
                                            <div>
                                                <legend >检查组套</legend>
                                            </div>
                                        </fieldset>
                                        <div id="displaySetsOne">
                                        </div>
                                    </div>
                                    <div style="height: 290px;overflow: auto">
                                        <fieldset>
                                            <div>
                                                <legend class="">检验组套</legend>
                                            </div>
                                        </fieldset>
                                        <div id="displaySetsTwo">
                                        </div>
                                    </div>
                                    <div style="height: 290px;overflow: auto">
                                        <fieldset>
                                            <div>
                                                <legend class="">处置组套</legend>
                                            </div>
                                        </fieldset>
                                        <div id="displaySetsThree">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--常用项目标签页--%>
                            <div class="tab-pane fade" id="commonInspections">
                                <div style="height: 450px;overflow: auto" >
                                    <div>
                                        <button type="button" onclick="showCommonInspectionDialog()" class="btn btn-primary">添加常用项目</button>&nbsp;
                                    </div>
                                    <fieldset>
                                        <div>
                                            <legend>常用项目</legend>
                                        </div>
                                    </fieldset>
                                    <div id="displayCommonInspections">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="drugList">
                <div class="col-md-8 center-block" style="width: 70%;height: 600px;overflow: auto">
                    <fieldset>
                        <div>
                            <legend class="">开立处方</legend>
                        </div>
                    </fieldset>
                    <div style="height: 300px;overflow: auto">
                        <%--开立处方--%>
                        <div class="row" style="padding-top: 3px">
                            <div class="col-md-5">
                                <label class="col-md-4 control-label text-right" for="drugMnemonicCodeInput">药品查找</label>
                                <div class="col-md-6 input-group">
                                    <input type="text" class="form-control" placeholder="输入助记码" id="drugMnemonicCodeInput"/>
                                    <ul id="drugMnemonicCodeInputUl" style="height: 200px;overflow: auto" class="dropdown-menu">
                                    </ul>
                                </div>
                            </div>
                            <div class="pull-right" style="width: 100px">
                                <div class="">
                                    <button type="button" onclick="resetDrugsTableBody()" class="btn btn-default">清空处方</button>
                                </div>
                            </div>
                            <div class="pull-right" style="width: 100px">
                                <div class="">
                                    <button type="button" id="sendDrugList" onclick="openDrugPrescription()" class="btn btn-primary">开立处方</button>
                                </div>
                            </div>
                            <div class="pull-right" style="width: 100px">
                                <div>
                                    <button type="button" id="foundDrug" onclick="findOneDrug()" class="btn btn-primary">添加药品</button>
                                </div>
                            </div>
                        </div>
                        <%--要开立的药品--%>
                        <form role="form" id="drugsInfo" >
                            <table class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th style="min-width: 130px;max-width: 150px">名称</th>
                                    <th style="min-width: 130px;max-width: 150px">规格</th>
                                    <th style="min-width: 100px;max-width: 130px">单价</th>
                                    <th style="min-width: 130px;max-width: 150px">用法</th>
                                    <th style="min-width: 130px;max-width: 150px">用量</th>
                                    <th style="min-width: 100px;max-width: 130px">剂型</th>
                                    <th style="min-width: 130px;max-width: 150px">频次</th>
                                    <th style="min-width: 100px;max-width: 130px">天数</th>
                                    <th style="min-width: 100px;max-width: 130px">数量</th>
                                    <th style="min-width: 100px;max-width: 130px">用药嘱托</th>
                                </tr>
                                </thead>
                                <tbody id="drugsTableBody">
                                <tr>
                                    <th style="display: none"><input type="text" class="form-control" id="drugPrescription0id" name="drugPrescription[0].drugId"/></th>
                                    <th><input type="text" class="form-control" id="drugPrescription0drugName" name="drugPrescription[0].drugName" readonly/></th>
                                    <th><input type="text" class="form-control" id="drugPrescription0drugFormat" name="drugPrescription[0].drugFormat" readonly/></th>
                                    <th><input type="text" class="form-control" id="drugPrescription0drugPrice" name="drugPrescription[0].drugPrice" readonly/></th>
                                    <th><select class="form-control" id="drugPrescription0drugUsage" name="drugPrescription[0].drugUsage">
                                        <option value=""></option>
                                    </select>
                                    </th>
                                    <th><input type="text" class="form-control" name="drugPrescription[0].drugDosage" /></th>
                                    <th><input type="text" class="form-control" id="drugPrescription0drugDosage" readonly/></th>
                                    <th><input type="text" class="form-control" id="drugPrescription0frequency" name="drugPrescription[0].frequency"/></th>
                                    <th><input type="text" class="form-control" id="drugPrescription0dayNumber" name="drugPrescription[0].dayNumber"/></th>
                                    <th><input type="text" class="form-control" id="drugPrescription0quantity" name="drugPrescription[0].quantity"/></th>
                                    <th><input type="text" class="form-control" id="drugPrescription0doctorAdvice" name="drugPrescription[0].doctorAdvice"/></th>
                                    <th style="display: none"><input type="text" class="form-control" id="drugPrescription0drugType" name="drugPrescription[0].drugType"/></th>
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
                            <button type="button" onclick="getOpenedDrugPrescription()"  class="btn btn-primary">显示已开立处方</button>
                        </div>
                    </div>
                    <fieldset>
                        <legend class="">查看已开立处方</legend>
                    </fieldset>
                    <div style="height: 300px;overflow: auto">
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th class="col-md-3">名称</th>
                                <th class="col-md-3">数量</th>
                                <th class="col-md-2">总价</th>
                                <th class="col-md-2">作废</th>
                            </tr>
                            </thead>
                            <tbody id="openedDrugPrescriptionTableBody">
                            </tbody>
                        </table>
                    </div>
                </div>
                <%--处方模板及常用药品--%>
                <div class="col-md-2 center-block" style="width: 29%">
                    <%--处方标签页右侧的标签页--%>
                    <div class="col-md-2" style="border: solid 1px #2aabd2;width: 100%;height: 600px;overflow: auto">
                        <ul id="medicalRecordMiniTab00" class="nav nav-tabs">
                            <li class="active"><a href="#drugSetTab" data-toggle="tab">处方组套</a></li>
                            <li><a href="#commonDrugs" data-toggle="tab">常用药品</a></li>
                        </ul>
                        <div id="medicalRecordMiniTabContent00" class="tab-content">
                            <%--组套标签页--%>
                            <div class="tab-pane fade in active" id="drugSetTab">
                                <div style="height: 550px;overflow: auto">
                                    <div>
                                        <button type="button" onclick="showSaveAsDrugSetDialog()" class="btn btn-primary">添加处方组套</button>&nbsp;
                                    </div>
                                    <div style="height: 450px;overflow: auto">
                                        <fieldset>
                                            <div>
                                                <legend >处方组套</legend>
                                            </div>
                                        </fieldset>
                                        <div id="displayDrugSets">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--常用药品标签页--%>
                            <div class="tab-pane fade" id="commonDrugs">
                                <div style="height: 450px;overflow: auto" >
                                    <div>
<%--                                        TODO--%>
                                        <button type="button" onclick="showCommonDrugDialog()" class="btn btn-primary">添加常用药品</button>&nbsp;
                                    </div>
                                    <fieldset>
                                        <div>
                                            <legend>常用药品</legend>
                                        </div>
                                    </fieldset>
                                    <div id="displayCommonDrugs">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>

            <%--                费用明细标签页--%>
            <div class="tab-pane fade" id="costList">
                <div class="col-md-8 center-block" style="width: 95%;height: 600px;overflow: auto">
                    <div class="pull-right" style="width: 150px">
                        <div class="" >
                            <input class="form-control" id="doctorSeeTotalCost" readonly>
                        </div>
                    </div>
                    <fieldset>
                        <div>
                            <legend class="">费用明细</legend>
                        </div>
                    </fieldset>
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label class="col-md-4 control-label text-right">开始时间</label>
                            <div class="col-md-8 input-group">
                                <input type="date" class="form-control" id="startTimeInput"/>
                            </div>
                        </div>
                        <div class="form-group col-md-4">
                            <label class="col-md-4 control-label text-right">结束时间</label>
                            <div class="col-md-8 input-group">
                                <input type="date" class="form-control" id="endTimeInput"/>
                            </div>
                        </div>
                        <div class="pull-right" style="width: 150px">
                            <div class="" >
                                <button type="button" onclick="findCostList()"  class="btn btn-primary">查看费用明细</button>
                            </div>
                        </div>
                    </div>

                    <table class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>项目</th>
                            <th>类型</th>
                            <th>费用</th>
                            <th>执行科室</th>
                            <th>开立科室</th>
                        </tr>
                        </thead>
                        <tbody id="costListTableBody">
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript">
    <%--  弹出的对话框  --%>
    //设为常用药品弹出框
    function showCommonDrugDialog() {
        $('#commonDrugDialog').dialog({
            modal:true,
            width:"600",
            height:"480"
        });
        document.getElementById("commonDrugDialog").style.display="block";
    }
        //设为常用药品弹出框的返回按钮
    function closeCommonDrugDialog() {
        $('#commonDrugDialog').dialog("close");
        $("#commonDrugDialogReset").click();
    }
        //设为常用药品弹出框的添加按钮
    function addCommonDrugDialog() {
        var doctorId = $("#doctorID").val();
        $.ajax({
            type: "POST",
            url: "drugPrescription/setCommon",
            data: $.param({'doctorId': doctorId}) + '&' + $('#commonDrugDialogForm').serialize(),
            success: function () {
                alert("设置成功");
                getCommonDrugList();
                closeCommonDrugDialog();
            }
        });
    }
    //药品根据助记码动态查询 添加常用药品对话框
    $(function(){
        //载入时隐藏下拉li
        $("#commonDrugDialogDrugMnemonicCodeInputUl").hide(0);
    });
    $("#commonDrugDialogDrugMnemonicCodeInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#commonDrugDialogDrugMnemonicCodeInput").val().length == 0){
            $("#commonDrugDialogDrugMnemonicCodeInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"drugPrescription/findDrugsByMnemonicCode",
            data: {drugMnemonicCode : $("#commonDrugDialogDrugMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                if(result){
                    var tempDrugs = result;
                    var str = "";
                    for (var i = 0;i < tempDrugs.length; i++){
                        str += "<li value='" + tempDrugs[i].drugName + "'>" + tempDrugs[i].drugName + "</li>\n";
                    }
                    $("#commonDrugDialogDrugMnemonicCodeInputUl").show(0);
                    $("#commonDrugDialogDrugMnemonicCodeInputUl").html(str);
                }else {
                    alert("无此药品");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#commonDrugDialogDrugMnemonicCodeInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#commonDrugDialogDrugMnemonicCodeInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#commonDrugDialogDrugMnemonicCodeInputUl li").click(function(){
                    $("#commonDrugDialogDrugMnemonicCodeInput").val($(this).html());
                    $("#commonDrugDialogDrugMnemonicCodeInputUl").hide(0);
                });
            }
        });
    });
    function commonDrugDialogFind() {
        $.ajax({
            type:"POST",
            url :"drugPrescription/findDrugsByName",
            data: {drugName : $("#commonDrugDialogDrugMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                var drug = result;
                $("#commonDrugDialogDrugName").val(drug[0].drugName);
                $("#commonDrugDialogDrugFormat").val(drug[0].drugFormat);
                $("#commonDrugDialogDrugMnemonicCodeInput").val("");
            }
        });
    }
    //查看处方组套弹出框
    function showModifyDrugSetDialog() {
        $('#modifyDrugSetDialog').dialog({
            modal:true,
            width:"600",
            height:"480"
        });
        document.getElementById("modifyDrugSetDialog").style.display="block";
    }
        //查看处方组套弹出框的返回按钮
    function closeModifyDrugSetDialog() {
        $('#modifyDrugSetDialog').dialog("close");
        $("#modifyDrugSetDialogReset").click();
    }
        //查看处方组套弹出框的修改按钮
    function saveModifyDrugSetDialog() {
        $.ajax({
            type: "POST",
            url: "drugPrescription/updateSet",
            data: $.param({doctorID : $("#doctorID").val()}) + '&' + $('#modifyDrugSetDialogForm').serialize(),
            success: function (result) {
                alert(result.msg);
                getDrugPrescriptionSets();
                closeModifyDrugSetDialog();
            }
        });
    }
    //设为处方组套弹出框
    function showSaveAsDrugSetDialog() {
        $('#saveAsDrugSetDialog').dialog({
            modal:true,
            width:"800",
            height:"480"
        });
        dialogResetDrugSetTableBody();
        document.getElementById("saveAsDrugSetDialog").style.display="block";
    }
        //设为处方组套弹出框的返回按钮
    function closeSaveAsDrugSetDialog() {
        $('#saveAsDrugSetDialog').dialog("close");
        $("#saveAsDrugSetDialogReset").click();
        dialogResetDrugSetTableBody();
    }
        //存为处方组套向后端发送数据
    function saveDrugSetDialog() {
        var doctorID = $("#doctorID").val();
        $.ajax({
            type: "POST",
            url: "drugPrescription/saveDrugSet",
            data: $.param({doctorId:doctorID}) + '&' + $("#saveAsDrugSetForm").serialize() + '&' + $('#saveAsDrugSetSetDetailForm').serialize(),
            success: function () {
                alert("保存成功");
                closeSaveAsDrugSetDialog();
                getDrugPrescriptionSets();
            },
            error: function () {
                alert("提交失败");
            }
        });
    }
        //存为处方弹出框的添加药品
            //药品数目
    var dialogDrugNum = 0;
            //查找具体的一种药品并添加到处方form中
    function dialogFindOneDrug(){
        $.ajax({
            type:"POST",
            url :"drugPrescription/findDrugsByName",
            data: {drugName : $("#saveAsDrugSetDialogInspectionMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                var drug = result;
                if ($(eval('dialogDrugPrescription' + dialogDrugNum + 'id')).val() != ""){
                    dialogAddOneDrug();
                }
                $(eval('dialogDrugPrescription' + dialogDrugNum + 'id')).val(drug[0].id);
                $(eval('dialogDrugPrescription' + dialogDrugNum + 'drugName')).val(drug[0].drugName);
                $(eval('dialogDrugPrescription' + dialogDrugNum + 'drugFormat')).val(drug[0].drugFormat);
                $(eval('dialogDrugPrescription' + dialogDrugNum + 'drugPrice')).val(drug[0].drugPrice);
                // $(eval('dialogDrugPrescription' + dialogDrugNum + 'drugDosage')).val(drug[0].drugDosage);
                $(eval('dialogDrugPrescription' + dialogDrugNum + 'drugType')).val(drug[0].drugType);
                $("#saveAsDrugSetDialogInspectionMnemonicCodeInput").val("");
            }
        });
    }
            //处方组套的form表单中添加一条
    function dialogAddOneDrug(){
        dialogDrugNum = dialogDrugNum + 1;
        var str = "<tr>\n" +
            "    <th style=\"display: none\"><input type=\"text\" class=\"form-control\" id=\"dialogDrugPrescription" + dialogDrugNum + "id\" name=\"drugPrescription[" + dialogDrugNum + "].drugId\"/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"dialogDrugPrescription" + dialogDrugNum + "drugName\" name=\"drugPrescription[" + dialogDrugNum + "].drugName\" readonly/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"dialogDrugPrescription" + dialogDrugNum + "drugFormat\" name=\"drugPrescription[" + dialogDrugNum + "].drugFormat\" readonly/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"dialogDrugPrescription" + dialogDrugNum + "drugPrice\" name=\"drugPrescription[" + dialogDrugNum + "].drugPrice\" readonly/></th>\n" +
            "    <th><select class=\"form-control\" id=\"dialogDrugPrescription" + dialogDrugNum + "drugUsage\" name=\"drugPrescription[" + dialogDrugNum + "].drugUsage\">\n";
        for (let i = 0; i < drugUsage.length; i++) {
            str += "        <option value='" +  drugUsage[i].drugUsage + "'>" + drugUsage[i].drugUsage + "</option>\n";
        }
        str += "    </select>\n" +
            "    </th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" name=\"drugPrescription[" + dialogDrugNum + "].drugDosage\" /></th>" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"dialogDrugPrescription" + dialogDrugNum + "frequency\" name=\"drugPrescription[" + dialogDrugNum + "].frequency\"/></th>\n" +
            "    <th style=\"display: none\"><input type=\"text\" class=\"form-control\" id=\"dialogDrugPrescription" + dialogDrugNum + "drugType\" name=\"drugPrescription[" + dialogDrugNum + "].drugType\"/></th>\n" +
            "</tr>";
        $("#saveAsDrugSetTableBody").append(str);

    }
            //清空检查项目
    function dialogResetDrugSetTableBody(){
        dialogDrugNum = -1;
        $("#saveAsDrugSetTableBody").html("");
        dialogAddOneDrug();
    }
    //药品根据助记码动态查询
    $(function(){
        //载入时隐藏下拉li
        $("#saveAsDrugSetDialogInspectionMnemonicCodeInputUl").hide(0);
    });
    $("#saveAsDrugSetDialogInspectionMnemonicCodeInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#saveAsDrugSetDialogInspectionMnemonicCodeInput").val().length == 0){
            $("#saveAsDrugSetDialogInspectionMnemonicCodeInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"drugPrescription/findDrugsByMnemonicCode",
            data: {drugMnemonicCode : $("#saveAsDrugSetDialogInspectionMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                if(result){
                    var tempDrugs = result;
                    var str = "";
                    for (var i = 0;i < tempDrugs.length; i++){
                        str += "<li value='" + tempDrugs[i].drugName + "'>" + tempDrugs[i].drugName + "</li>\n";
                    }
                    $("#saveAsDrugSetDialogInspectionMnemonicCodeInputUl").show(0);
                    $("#saveAsDrugSetDialogInspectionMnemonicCodeInputUl").html(str);
                }else {
                    alert("无此药品");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#saveAsDrugSetDialogInspectionMnemonicCodeInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#saveAsDrugSetDialogInspectionMnemonicCodeInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#saveAsDrugSetDialogInspectionMnemonicCodeInputUl li").click(function(){
                    $("#saveAsDrugSetDialogInspectionMnemonicCodeInput").val($(this).html());
                    $("#saveAsDrugSetDialogInspectionMnemonicCodeInputUl").hide(0);
                });
            }
        });
    });

    //检查检验结果分析弹出框
    function showInspectionResultDialog() {
        $('#inspectionResultDialog').dialog({
            modal:true,
            width:"600",
            height:"480"
        });
        document.getElementById("inspectionResultDialog").style.display="block";
    }
        //检查检验结果分析弹出框的确定按钮
    function addInspectionResultAnalyze() {
        $('#inspectionResultDialog').dialog("close");
        $("#inspectionResultDialogReset").click();
    }
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
                getInspectionSetsOne();
                getInspectionSetsTwo();
                getInspectionSetsThree();
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

    //医生登录后进行更新
    function update(){
        //    TODO 需要更新的函数
        getWaitingDiagnosePatients();
        getDiagnosedPatients();
        $("#medicalRecordInfoResetButton").click();
        getHospitalCommon();
        setDisplayCommonDiagnoses();
        getInspectionSetsOne();
        getInspectionSetsTwo();
        getInspectionSetsThree();
        getCommonInspectionList();
        getDrugPrescriptionSets();
        getCommonDrugList();
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
            "<th><input type=\"text\" class=\"form-control\" id=\"diseases" + diagnoseNum + "internationalIcdCode\" readonly/></th>" +
            "<th><input type=\"text\" class=\"form-control\" id='diseases" + diagnoseNum + "diseaseName' name='diagnoses[" + diagnoseNum + "].diseaseName' readonly/></th>\n" +
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
    //诊毕
    function overMR() {
        var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
        if(medicalRecordNo == null){
            alert("请选择患者");
        }else {
            $.ajax({
                type: "POST",
                url: "medicalRecord/overMR",
                data: {medicalRecordNo: medicalRecordNo},
                success: function () {
                    alert("已诊毕");
                },
                error:function () {
                    alert("无法诊毕");
                }
            });
        }
    }

//检查
    //检查数目
    var inspectionNum = 0;
    //查找具体的一项检查并添加到检查表单中
    function findOneInspection(){
        $.ajax({
            type:"POST",
            url :"inspection/findByAttribute",
            data: {type : $("#threeSelectOne").val(),attribute_name : "item_name",attribute : $("#inspectionMnemonicCodeInput").val()},
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
                data: {type : $("#saveAsSetDialogThreeSelectOne").val(),attribute_name : "item_name",attribute : $("#saveAsSetDialogInspectionMnemonicCodeInput").val()},
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
                getInspectionSetsOne();
                getInspectionSetsTwo();
                getInspectionSetsThree();
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
            success: function (result) {
                alert(result.msg);
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
            data: {type : $("#threeSelectOne").val(),attribute_name : "mnemonic_code",attribute : $("#inspectionMnemonicCodeInput").val()},
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
            data: {type : $("#saveAsSetDialogThreeSelectOne").val(),attribute_name : "mnemonic_code",attribute : $("#saveAsSetDialogInspectionMnemonicCodeInput").val()},
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
            data: {type : $("#commonInspectionDialogThreeSelectOne").val(),attribute_name : "mnemonic_code",attribute : $("#commonInspectionDialogDiseaseMnemonicCodeInput").val()},
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
            data: {type : $("#commonInspectionDialogThreeSelectOne").val(),attribute_name : "item_name",attribute : $("#commonInspectionDialogDiseaseMnemonicCodeInput").val()},
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
                if (result.status == "NG") {
                    alert(result.msg);
                }else {
                    $("#inspectionResultInput").val(result.msg);
                    showInspectionResultDialog();
                }
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

    //检查组套
    var inspectionSetsOne = null;
    //获取检查组套
    function getInspectionSetsOne(){
        $.ajax({
            type: "POST",
            url: "inspection/getSetsOne",
            async: false,
            data: {doctorId : $("#doctorID").val()},
            success: function (result) {
                inspectionSetsOne = result;
                displaySetsOne();
            }
        });
    }
    //生成检查组套列表
    function displaySetsOne(){
        var str = "";
        $("#displaySetsOne").html("");
        for (let i = 0;i < inspectionSetsOne.length;i++){
            str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + inspectionSetsOne[i].combinatorialName + "' readonly/>\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='useSetOne(" + i + ")'>引用</button>&nbsp;\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='modifySetOne(" + i + ")'>查看</button>\n" +
                "    <button type=\"button\" class=\"btn btn-danger\" onclick='deleteSetOne(" + i + ")'>删除</button>\n" +
                "</div>";
        }
        $("#displaySetsOne").append(str);
    }
    //引用检查组套
    function useSetOne(i){
        $.ajax({
            type: "POST",
            url: "inspection/findDetailBySetId",
            async: false,
            data: {setId : inspectionSetsOne[i].id},
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
    //查看检查组套
    function modifySetOne(i){
        $("#modifySetDialogId").val(inspectionSetsOne[i].id);
        $("#modifySetDialogDoctorId").val(inspectionSetsOne[i].doctorId);
        $("#modifySetDialogCombinatorialCode").val(inspectionSetsOne[i].combinatorialCode);
        $("#modifySetDialogCombinatorialName").val(inspectionSetsOne[i].combinatorialName);
        $("#modifySetDialogRequirement").val(inspectionSetsOne[i].requirement);
        $("#modifySetDialogCategory").val(inspectionSetsOne[i].category);
        showModifySetDialog();
    }
    //删除检查组套
    function deleteSetOne(i){
        $.ajax({
            type: "POST",
            url: "inspection/deleteSet",
            async: false,
            data: {setId : inspectionSetsOne[i].id,doctorId : $("#doctorID").val()},
            success: function (result) {
                alert(result.msg);
                getInspectionSetsOne();
            }
        });
    }
    //检验组套
    var inspectionSetsTwo = null;
    //获取检验组套
    function getInspectionSetsTwo(){
        $.ajax({
            type: "POST",
            url: "inspection/getSetsTwo",
            async: false,
            data: {doctorId : $("#doctorID").val()},
            success: function (result) {
                inspectionSetsTwo = result;
                displaySetsTwo();
            }
        });
    }
    //生成检验组套列表
    function displaySetsTwo(){
        var str = "";
        $("#displaySetsTwo").html("");
        for (let i = 0;i < inspectionSetsTwo.length;i++){
            str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + inspectionSetsTwo[i].combinatorialName + "' readonly/>\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='useSetTwo(" + i + ")'>引用</button>&nbsp;\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='modifySetTwo(" + i + ")'>查看</button>\n" +
                "    <button type=\"button\" class=\"btn btn-danger\" onclick='deleteSetTwo(" + i + ")'>删除</button>\n" +
                "</div>";
        }
        $("#displaySetsTwo").append(str);
    }
    //引用检验组套
    function useSetTwo(i){
        $.ajax({
            type: "POST",
            url: "inspection/findDetailBySetId",
            async: false,
            data: {setId : inspectionSetsTwo[i].id},
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
    //查看检验组套
    function modifySetTwo(i){
        $("#modifySetDialogId").val(inspectionSetsTwo[i].id);
        $("#modifySetDialogDoctorId").val(inspectionSetsTwo[i].doctorId);
        $("#modifySetDialogCombinatorialCode").val(inspectionSetsTwo[i].combinatorialCode);
        $("#modifySetDialogCombinatorialName").val(inspectionSetsTwo[i].combinatorialName);
        $("#modifySetDialogRequirement").val(inspectionSetsTwo[i].requirement);
        $("#modifySetDialogCategory").val(inspectionSetsTwo[i].category);
        showModifySetDialog();
    }
    //删除检验组套
    function deleteSetTwo(i){
        $.ajax({
            type: "POST",
            url: "inspection/deleteSet",
            async: false,
            data: {setId : inspectionSetsTwo[i].id,doctorId : $("#doctorID").val()},
            success: function (result) {
                alert(result.msg);
                getInspectionSetsTwo();
            }
        });
    }
    //处置组套
    var inspectionSetsThree = null;
    //获取处置组套
    function getInspectionSetsThree(){
        $.ajax({
            type: "POST",
            url: "inspection/getSetsThree",
            async: false,
            data: {doctorId : $("#doctorID").val()},
            success: function (result) {
                inspectionSetsThree = result;
                displaySetsThree();
            }
        });
    }
    //生成处置组套列表
    function displaySetsThree(){
        var str = "";
        $("#displaySetsThree").html("");
        for (let i = 0;i < inspectionSetsThree.length;i++){
            str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + inspectionSetsThree[i].combinatorialName + "' readonly/>\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='useSetThree(" + i + ")'>引用</button>&nbsp;\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='modifySetThree(" + i + ")'>查看</button>\n" +
                "    <button type=\"button\" class=\"btn btn-danger\" onclick='deleteSetThree(" + i + ")'>删除</button>\n" +
                "</div>";
        }
        $("#displaySetsThree").append(str);
    }
    //引用处置组套
    function useSetThree(i){
        $.ajax({
            type: "POST",
            url: "inspection/findDetailBySetId",
            async: false,
            data: {setId : inspectionSetsThree[i].id},
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
    //查看处置组套
    function modifySetThree(i){
        $("#modifySetDialogId").val(inspectionSetsThree[i].id);
        $("#modifySetDialogDoctorId").val(inspectionSetsThree[i].doctorId);
        $("#modifySetDialogCombinatorialCode").val(inspectionSetsThree[i].combinatorialCode);
        $("#modifySetDialogCombinatorialName").val(inspectionSetsThree[i].combinatorialName);
        $("#modifySetDialogRequirement").val(inspectionSetsThree[i].requirement);
        $("#modifySetDialogCategory").val(inspectionSetsThree[i].category);
        showModifySetDialog();
    }
    //删除处置组套
    function deleteSetThree(i){
        $.ajax({
            type: "POST",
            url: "inspection/deleteSet",
            async: false,
            data: {setId : inspectionSetsThree[i].id,doctorId : $("#doctorID").val()},
            success: function (result) {
                alert(result.msg);
                getInspectionSetsThree();
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

//处方
    //药品根据助记码动态查询
    $(function(){
        //载入时隐藏下拉li
        $("#drugMnemonicCodeInputUl").hide(0);
    });
    $("#drugMnemonicCodeInput").keyup(function(){
        //如果文本框为空，不发送请求
        if($("#drugMnemonicCodeInput").val().length == 0){
            $("#drugMnemonicCodeInputUl").hide(0);
            return false;
        }
        $.ajax({
            type:"POST",
            url :"drugPrescription/findDrugsByMnemonicCode",
            data: {drugMnemonicCode : $("#drugMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                if(result){
                    var tempDrugs = result;
                    var str = "";
                    for (var i = 0;i < tempDrugs.length; i++){
                        str += "<li value='" + tempDrugs[i].drugName + "'>" + tempDrugs[i].drugName + "</li>\n";
                    }
                    $("#drugMnemonicCodeInputUl").show(0);
                    $("#drugMnemonicCodeInputUl").html(str);
                }else {
                    alert("无此药品");
                }
            }
        });
    });
    $(function(){
        //按下按键后100毫秒显示下拉提示
        $("#drugMnemonicCodeInput").keyup(function(){
            setInterval(changeHover,100);
            function changeHover(){
                $("#drugMnemonicCodeInputUl li").hover(function(){
                        $(this).css("background","#aaa");},
                    function()
                    { $(this).css("background","#fff");});

                $("#drugMnemonicCodeInputUl li").click(function(){
                    $("#drugMnemonicCodeInput").val($(this).html());
                    $("#drugMnemonicCodeInputUl").hide(0);
                });
            }
        });
    });
    //药品使用方式
    var drugUsage = null;
    $.ajax({
        type:"POST",
        url :"drugPrescription/findUsage",
        async: false,
        success:function(result){
            drugUsage = result;
            resetDrugsTableBody();
        }
    });
    //药品数目
    var drugNum = 0;
    //查找具体的一项药品并添加到处方中
    function findOneDrug(){
        $.ajax({
            type:"POST",
            url :"drugPrescription/findDrugsByName",
            data: {drugName : $("#drugMnemonicCodeInput").val()},
            async: false,
            success:function(result){
                var drug = result;
                if ($(eval('drugPrescription' + drugNum + 'id')).val() != ""){
                    addOneDrug();
                }
                $(eval('drugPrescription' + drugNum + 'id')).val(drug[0].id);
                $(eval('drugPrescription' + drugNum + 'drugName')).val(drug[0].drugName);
                $(eval('drugPrescription' + drugNum + 'drugFormat')).val(drug[0].drugFormat);
                $(eval('drugPrescription' + drugNum + 'drugPrice')).val(drug[0].drugPrice);
                $(eval('drugPrescription' + drugNum + 'drugDosage')).val(drug[0].drugDosage);
                $(eval('drugPrescription' + drugNum + 'drugType')).val(drug[0].drugType);
                $("#drugMnemonicCodeInput").val("");
            }
        });
    }
    //处方的form表单中添加一条
    function addOneDrug(){
        drugNum = drugNum + 1;
        var str = "<tr>\n" +
            "    <th style=\"display: none\"><input type=\"text\" class=\"form-control\" id=\"drugPrescription" + drugNum + "id\" name=\"drugPrescription[" + drugNum + "].drugId\"/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"drugPrescription" + drugNum + "drugName\" name=\"drugPrescription[" + drugNum + "].drugName\" readonly/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"drugPrescription" + drugNum + "drugFormat\" name=\"drugPrescription[" + drugNum + "].drugFormat\" readonly/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"drugPrescription" + drugNum + "drugPrice\" name=\"drugPrescription[" + drugNum + "].drugPrice\" readonly/></th>\n" +
            "    <th><select class=\"form-control\" id=\"drugPrescription" + drugNum + "drugUsage\" name=\"drugPrescription[" + drugNum + "].drugUsage\">\n";
        for (let i = 0; i < drugUsage.length; i++) {
            str += "        <option value='" +  drugUsage[i].drugUsage + "'>" + drugUsage[i].drugUsage + "</option>\n";
        }
        str += "    </select>\n" +
            "    </th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" name=\"drugPrescription[0].drugDosage\" /></th>" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"drugPrescription" + drugNum + "drugDosage\" readonly/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"drugPrescription" + drugNum + "frequency\" name=\"drugPrescription[" + drugNum + "].frequency\"/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"drugPrescription" + drugNum + "dayNumber\" name=\"drugPrescription[" + drugNum + "].dayNumber\"/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"drugPrescription" + drugNum + "quantity\" name=\"drugPrescription[" + drugNum + "].quantity\"/></th>\n" +
            "    <th><input type=\"text\" class=\"form-control\" id=\"drugPrescription" + drugNum + "doctorAdvice\" name=\"drugPrescription[" + drugNum + "].doctorAdvice\"/></th>\n" +
            "    <th style=\"display: none\"><input type=\"text\" class=\"form-control\" id=\"drugPrescription" + drugNum + "drugType\" name=\"drugPrescription[" + drugNum + "].drugType\"/></th>\n" +
            "</tr>";
        $("#drugsTableBody").append(str);
    }
    //清空处方
    function resetDrugsTableBody(){
        drugNum = -1;
        $("#drugsTableBody").html("");
        addOneDrug();
    }
    //开立处方
    function openDrugPrescription(){
        var doctorID = $("#doctorID").val();
        var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
        $.ajax({
            type: "POST",
            url: "drugPrescription/submitDrugPrescription",
            data: $.param({doctorId:doctorID,medicalRecordNo:medicalRecordNo}) + '&' + $('#drugsInfo').serialize(),
            success: function (data) {
                alert(data.msg);
                // getOpenedInspections();
                getOpenedDrugPrescription();
                resetDrugsTableBody();
            },
            error: function () {
                alert("开立失败");
            }
        });
    }
    //已开立的处方
    var openedDrugPrescription = null;
    //获取并显示已开立处方
    function getOpenedDrugPrescription(){
        var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
        $.ajax({
            type: "POST",
            url: "drugPrescription/getOpenedDrugPrescription",
            data: {medicalRecordNo : medicalRecordNo},
            success: function (result) {
                openedDrugPrescription = result.data;
                if (openedDrugPrescription == null){
                    alert("该患者没有开立处方");
                } else {
                    $("#openedDrugPrescriptionTableBody").html("");
                    var str = "";
                    for (var i = 0; i < openedDrugPrescription.length; i++){
                        str += "<tr>\n" +
                            "    <th><input type=\"text\" class=\"form-control\" value='" + openedDrugPrescription[i].drugName + "' readonly/></th>\n" +
                            "    <th><input type=\"text\" class=\"form-control\" value='" + openedDrugPrescription[i].quantity + "' readonly/></th>\n" +
                            "    <th><input type=\"text\" class=\"form-control\" value='" + openedDrugPrescription[i].cost + "' readonly/></th>\n" +
                            "    <th><input type=\"button\" class=\"btn btn-danger\" onclick=\"invalidDrugPrescription(" + i + ")\" value=\"作废\"/></th>\n" +
                            "</tr>";
                    }
                    $("#openedDrugPrescriptionTableBody").append(str);
                }
            },
            error: function () {
                alert("获取处方列表失败");
            }
        });
    }
    //作废已开立的处方
    function invalidDrugPrescription(i){
        $.ajax({
            type: "POST",
            url: "drugPrescription/invalidDrugPrescription",
            data: {drugPrescriptionId : openedDrugPrescription[i].id},
            success: function (result) {
                var str = result.msg;
                alert(str);
                getOpenedDrugPrescription();
            },
            error: function () {
                alert("作废失败");
            }
        });
    }
    //处方组套
    var drugPrescriptionSets = null;
    //获取处方组套
    function getDrugPrescriptionSets(){
        $.ajax({
            type: "POST",
            url: "drugPrescription/getDrugPrescriptionSets",
            async: false,
            data: {doctorId : $("#doctorID").val()},
            success: function (result) {
                drugPrescriptionSets = result;
                displayDrugPrescriptionSets();
            }
        });
    }
    //生成处方组套列表
    function displayDrugPrescriptionSets(){
        var str = "";
        $("#displayDrugSets").html("");
        for (let i = 0;i < drugPrescriptionSets.length;i++){
            str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + drugPrescriptionSets[i].combinatorialName + "' readonly/>\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='useDrugPrescriptionSet(" + i + ")'>引用</button>&nbsp;\n" +
                "    <button type=\"button\" class=\"btn btn-primary\" onclick='modifyDrugPrescriptionSet(" + i + ")'>查看</button>\n" +
                "    <button type=\"button\" class=\"btn btn-danger\" onclick='deleteDrugPrescriptionSet(" + i + ")'>删除</button>\n" +
                "</div>";
        }
        $("#displayDrugSets").append(str);
    }
    //引用处方组套
    function useDrugPrescriptionSet(i){
        $.ajax({
            type: "POST",
            url: "drugPrescription/findDetailBySetId",
            async: false,
            data: {setId : drugPrescriptionSets[i].id},
            success: function (result) {
                var drugPrescriptionSetDetails = result;
                for (let i = 0; i < drugPrescriptionSetDetails.length; i++) {
                    if ($(eval('drugPrescription' + drugNum + 'id')).val() != ""){
                        addOneDrug();
                    }
                    $(eval('drugPrescription' + drugNum + 'id')).val(drugPrescriptionSetDetails[i].drugId);
                    $(eval('drugPrescription' + drugNum + 'drugName')).val(drugPrescriptionSetDetails[i].drugName);
                    $(eval('drugPrescription' + drugNum + 'drugFormat')).val(drugPrescriptionSetDetails[i].drugFormat);
                    $(eval('drugPrescription' + drugNum + 'drugUsage')).val(drugPrescriptionSetDetails[i].drugUsage);
                    $(eval('drugPrescription' + drugNum + 'drugPrice')).val(drugPrescriptionSetDetails[i].price);
                    $(eval('drugPrescription' + drugNum + 'drugDosage')).val(drugPrescriptionSetDetails[i].drugUsage);
                    $(eval('drugPrescription' + drugNum + 'frequency')).val(drugPrescriptionSetDetails[i].frequency);
                    $(eval('drugPrescription' + drugNum + 'drugType')).val(drugPrescriptionSetDetails[i].type);

                }
            }
        });
    }
    //查看处方组套
    function modifyDrugPrescriptionSet(i){
        $("#modifyDrugSetDialogId").val(drugPrescriptionSets[i].id);
        $("#modifyDrugSetDialogDoctorId").val(drugPrescriptionSets[i].doctorId);
        $("#modifyDrugSetDialogCombinatorialCode").val(drugPrescriptionSets[i].combinatorialCode);
        $("#modifyDrugSetDialogCombinatorialName").val(drugPrescriptionSets[i].combinatorialName);
        $("#modifyDrugSetDialogRequirement").val(drugPrescriptionSets[i].requirement);
        $("#modifyDrugSetDialogCategory").val(drugPrescriptionSets[i].category);
        showModifyDrugSetDialog();
    }
    //删除处方组套
    function deleteDrugPrescriptionSet(i){
        $.ajax({
            type: "POST",
            url: "drugPrescription/deleteSet",
            async: false,
            data: {setId : drugPrescriptionSets[i].id,doctorId : $("#doctorID").val()},
            success: function (result) {
                alert(result.msg);
                getDrugPrescriptionSets();
            }
        });
    }
    //常用药品目录
    var commonDrugList = null;
    //获取并显示常用药品
    function getCommonDrugList(){
        $.ajax({
            type: "POST",
            url: "drugPrescription/getCommons",
            async: false,
            data: {doctorId : $("#doctorID").val()},
            success: function (result) {
                commonDrugList = result;
                var str = "";
                $("#displayCommonDrugs").html("");
                for (let i = 0;i < commonDrugList.length;i++){
                    str += "<div class=\"row center-block\" style=\"width: 100%;margin-bottom: 3px\">\n" +
                        "    <input type=\"text\" class=\"form-control\" style=\"width: 80%\" value='" + commonDrugList[i].drugName + "' readonly/>\n" +
                        "    <button type=\"button\" class=\"btn btn-primary\" onclick='useCommonDrug(" + i + ")'>引用</button>&nbsp;\n" +
                        "    <button type=\"button\" class=\"btn btn-danger\" onclick='deleteCommonDrug(" + i + ")'>删除</button>\n" +
                        "</div>";
                }
                $("#displayCommonDrugs").append(str);
            }
        });
    }
    //引用常用药品
    function useCommonDrug(i){
        $.ajax({
            type:"POST",
            url :"drugPrescription/findDrugsByName",
            data: {drugName :commonDrugList[i].drugName},
            async: false,
            success:function(result){
                var drug = result;
                if ($(eval('drugPrescription' + drugNum + 'id')).val() != ""){
                    addOneDrug();
                }
                $(eval('drugPrescription' + drugNum + 'id')).val(drug[0].id);
                $(eval('drugPrescription' + drugNum + 'drugName')).val(drug[0].drugName);
                $(eval('drugPrescription' + drugNum + 'drugFormat')).val(drug[0].drugFormat);
                $(eval('drugPrescription' + drugNum + 'drugPrice')).val(drug[0].drugPrice);
                $(eval('drugPrescription' + drugNum + 'drugDosage')).val(drug[0].drugDosage);
                $(eval('drugPrescription' + drugNum + 'drugType')).val(drug[0].drugType);
            }
        });
    }
    //删除常用药品
    function deleteCommonDrug(i){
        $.ajax({
            type: "POST",
            url: "drugPrescription/deleteCommonDrug",
            async: false,
            data: {commonDrugId : commonDrugList[i].id},
            success: function () {
                getCommonDrugList();
            }
        });
    }

//费用明细
    //收费项目列表
    var items = null;
    // //应收金额
    // var cost = 0;
    //收费项目查找
    function findCostList() {
        var medicalRecordNo =  $('input[name=patientMedicalRecordNo]:checked').val();
        $.ajax({
            type: "POST",
            url: "charge/costList",
            async: false,
            data: {medicalRecordNo : medicalRecordNo,startTime : $("#startTimeInput").val(),endTime : $("#endTimeInput").val()},
            success: function (result) {
                items = result;
                if (items.length == 0){
                    alert("无缴费项目");
                    $("#costListTableBody").html("");
                } else {
                    // cost = result.cost;
                    // $("#totalCost").val(cost + "元");
                    setCostListTableBody();
                }
            }
        });
    }
    //生成收费项目表
    function setCostListTableBody() {
        var str = "";
        $("#costListTableBody").html("");
        var doctorSeeTotalCostVal = 0;
        for (let i = 0; i < items.length; i++) {
            str += "<tr>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].itemName + "' name='items[" + i + "].itemName' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].costType + "' name='items[" + i + "].format' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].cost + "元' name='items[" + i + "].unitPrice' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].executiveDepartmentName + "' name='items[" + i + "].departmentName' readonly/></th>\n" +
                "<th><input  type=\"text\" class='form-control' value='" + items[i].drawBillDepartmentName + "' name='items[" + i + "].drawBillDepartmentName' readonly/></th>\n" +
                "</tr>";
            doctorSeeTotalCostVal += items[i].cost;
        }
        doctorSeeTotalCostVal = doctorSeeTotalCostVal.toFixed(2);
        $("#doctorSeeTotalCost").val("共计：" + doctorSeeTotalCostVal + "元");
        $("#costListTableBody").append(str);
    }

    //DOM结构加载完毕后执行
    $(document).ready(function(){
        $("#loginUser").append("<a>" + "${USER_SESSION.loginName}" + "</a><input style=\"display: none\" id=\"userID\" value='" + ${USER_SESSION.id} + "'/>");
        $("#doctorID").val(${USER_SESSION.id});
        $("#logOutButton").click(function (){
            document.getElementById("logOut").click();
        });
        update();
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
                "<th><input type=\"text\" class=\"form-control\" id=\"diseases" + diagnoseNum + "internationalIcdCode\" readonly/></th>" +
                "<th><input type=\"text\" class=\"form-control\" id='diseases" + diagnoseNum + "diseaseName' name='diagnoses[" + diagnoseNum + "].diseaseName' readonly/></th>\n" +
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

                        // $.ajax({
                        //     type: "POST",
                        //     url: "medicalRecord/getDiagnose",
                        //     data: {medicalRecordNo:medicalRecordNo},
                        //     success: function (result) {
                        //         var diagnoseList = result;
                        //         for (let i = 0; i < diagnoseList.length; i++) {
                        //             if ($(eval('diseases' + diagnoseNum + 'id')).val() != ""){
                        //                 $("#addDiagnose").click();
                        //             }
                        //             $(eval('diseases' + diagnoseNum + 'id')).val(diagnoseList[i].diseaseId);
                        //             $(eval('diseases' + diagnoseNum + 'internationalIcdCode')).val(diagnoseList[i].suspectedSign);
                        //             $(eval('diseases' + diagnoseNum + 'diseaseName')).val(diagnoseList[i].majorDiagnoseSign);
                        //             $(eval('diseases' + diagnoseNum + 'diseaseType')).val(diagnoseList[i].diseaseType);
                        //         }
                        //     }
                        // });

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
