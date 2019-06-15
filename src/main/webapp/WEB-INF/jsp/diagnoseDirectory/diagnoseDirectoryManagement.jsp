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
<div class="row">
    <div class="col-md-2 pull-right">
<%--        <input type="reset" class="btn btn-default" value="取消" />--%>
        <button type="button" id="updateDepartments" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>
    </div>
</div>
<div class="container" style="padding-left: 1px;padding-right: 1px;margin-left: 70px;margin-right: 50px">
    <div class="col-md-2" style="padding-left: 5px;padding-right: 5px;width: 120px;">
        <ul class="nav nav-tab vertical-tab" style="padding-left: 0px;padding-right: 0px;width: 110px;" role="tablist" id="diagnoseDirectoryTab">
        </ul>
    </div>
    <div class="tab-content vertical-tab-content col-md-10">
        <form class="container" style="" id="diagnoseTab">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
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
            data: {pageNum : pageN,pageSize : 20},
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
        // setDepartmentCategoryInput();

        //设置保存按钮功能
        $("#updateDepartments").click(function () {
            $.ajax({
                type: "POST",
                url: "disease/updateDiseases",
                data: $('#diseaseTableBody').serialize(),
                success: function () {
                    alert("保存成功");
                },
                error: function () {
                    alert("保存失败");
                }
            });
        });
        // //设置查找功能按钮 TODO 查询 添加 删除
        // $("#search").click(function(){
        //     getSearchedPageN(1);
        // });
        // //设置用户添加按钮
        // $("#addDepartmentButton").click(function () {
        //     $.ajax({
        //         type: "POST",
        //         url: "department/updatedepartments",
        //         data: $('#addDepartment').serialize(),
        //         success: function () {
        //             getPageN(1);
        //         }
        //     });
        // });
    });
</script>
</body>
</html>
