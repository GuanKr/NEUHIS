<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/6/27
  Time: 11:50
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
    <title>药房工作站</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="breadcrumb">
                <li><a href="#">主页</a></li>
                <li class="active">药房工作站</li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-10 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target="#example-navbar-collapse">
                            <span class="sr-only">切换导航</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">药房工作站</a>

                    </div>
                    <div class="collapse navbar-collapse" id="example-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="pharmacy/drugManagement">药品信息维护</a></li>
                            <li><a href=#>发药</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="col-md-2" >
            <input type='text' id='doctorId' class='form-control'/>
        </div>
    </div>
</div>
<div class="container" >
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-3 column">
                    <form role="form">
                        <div class="form-group">
                            <label for="drug_code">编码</label><input class="form-control" id="drug_code" type="text" />
                        </div>
                        <div class="form-group">
                            <label for="drug_name">名称</label><input class="form-control" id="drug_name" type="text"   />
                        </div>
                        <div class="form-group">
                            <label for="drug_dosage">剂型</label><input id="drug_dosage" class="form-control" type="text" />
                        </div>
                        <div class="form-group">
                            <label for="mnemonic_code">助记码</label><input id="mnemonic_code" type="text"  class="form-control"/>
                        </div>
                        <button type="button" class="btn btn-primary"  id="submit">Submit</button>
                    </form>
                </div>
                <div class="col-md-9 column" >
                    <div class="container" >
                        <div class="row clearfix"  style="height: 400px ; width: 862px ;overflow: auto">
                            <form class="row clearfix" id="drugForm" style="width:862px">
                                <div class="row">
                                    <div class="col-md-4 pull-right">
                                        <div class="btn-group">
                                            <button class="btn btn-default" type="button" id="deleteDrugButton" style="text-align: center">
                                                <em class="glyphicon glyphicon-align-left"></em>删除</button>
                                            <button class="btn btn-default" type="button" id="updateDrug" style="text-align: center">
                                                <em class="glyphicon glyphicon-align-center"></em>保存</button>
                                            <button class="btn btn-default" type="button" id="newDrug" style="text-align: center">
                                                <em class="glyphicon glyphicon-align-right"></em>添加</button>
                                            <button class="btn btn-default" type="button" style="text-align: center">
                                                <em class="glyphicon glyphicon-align-justify"></em>4</button>
                                        </div>
                                    </div>
                                </div>
                                <table class="table table-hover table-striped"  id="drug"  style="height: 400px ;width :862px;overflow: auto ;margin-left: 15px">
                                    <thead  style="height: 40px">
                                    <tr style="height: 40px">
                                        <th style="height: 40px">删除</th>
                                        <th style="height: 40px">编码</th>
                                        <th style="height: 40px">名称</th>
                                        <th style="height: 40px">规格</th>
                                        <th style="height: 40px">剂型</th>
                                        <th style="height: 40px">价格</th>
                                        <th style="height: 40px">生产厂商</th>
                                    </tr>
                                    </thead>
                                    <tbody id="drugTable" >
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="insertDrugDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog "  >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">新增药品详情</h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <label for="newDrug_code">编码</label><input class="form-control" id="newDrug_code" type="text" />
                    </div>
                    <div class="form-group">
                        <label for="newDrug_name">名称</label><input class="form-control" id="newDrug_name" type="text" />
                    </div>
                    <div class="form-group">
                        <label for="newDrug_format">规格</label><input class="form-control" id="newDrug_format" type="text" />
                    </div>
                    <div class="form-group">
                        <label for="newManuFacturer">生产厂家</label><input class="form-control" id="newManuFacturer" type="text" />
                    </div>
                    <div class="form-group">
                        <label for="newDrug_dosage">剂型</label><input class="form-control" id="newDrug_dosage" type="text" />
                    </div>
                    <div class="form-group">
                        <label for="newDrug_type">类型</label>
                        <select data-am-selected class="form-control"id = "newDrug_type" name="newDrug_type">
                            <option value="1">西药</option>
                            <option value="2">中草药</option>
                            <option value="3">中成药</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="newDrug_price">价格</label><input class="form-control" id="newDrug_price" type="text" />
                    </div>
                    <div class="form-group">
                        <label for="newDrug_mnemonic">助记码</label><input class="form-control" id="newDrug_mnemonic" type="text" />
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" >确定</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    var drugList;
    function setDrugTable() {
        var str;
        str = "";
        $("#drugTable").html("");
        for (var i = 0;i <drugList.length;i++){
            str +="<tr style='height: 40px'>" +
                "<td width=\'50px\'><input type='radio' value='"+drugList[i].id+"'/></td>"+
                "<td width=\"140px\"><input type=\"text\" class=\"form-control\" value=\""+drugList[i].drugCode+"\" name=\"drug["+ i + "].drugNameCode\" readonly/></td>\n" +
                "<td width=\"140px\"><input type=\"text\" class=\"form-control\" value=\""+drugList[i].drugName+"\" name=\"drug["+ i + "].drugName\" readonly/></td>\n" +
                "<td width=\"140px\"><input type=\"text\" class=\"form-control\" value=\""+drugList[i].drugFormat+"\" name=\"drug["+ i + "].drugFormat\" readonly/></td>\n" +
                "<td width=\"140px\"><input type=\"text\" class=\"form-control\" value=\""+drugList[i].drugDosage+"\" name=\"drug["+ i + "].drugDosage\" readonly/></td>\n" +
                "<td width=\"140px\"><input type=\"text\" class=\"form-control\" value=\""+drugList[i].drugPrice+"\" name=\"drug["+ i + "].drugPrice\" readonly/></td>\n" +
                "<td width=\"140px\"><input type=\"text\" class=\"form-control\" value=\""+drugList[i].manufacturer+"\" name=\"drug["+ i + "].manufacturer\" readonly/></td>\n" +
                "</tr>";
        }
        $("#drugTable").append(str);
    }
    $(document).ready(function(){
        $("#newDrug").click(function () {
            $.ajax({
                type: "POST",
                url: "pharmacy/insertDrug",
                contentType:"application/x-www-form-urlencoded;charset=utf-8",
                data: {},
                async: false,
                success: function (result) {
                    drugList = result;
                    setDrugTable();
                },
                error :function () {
                    alert("获取失败");
                }
            });
        });
        //设置删除按钮功能
        $("#deleteDrugButton").click(function () {
            $.ajax({
                type: "POST",
                url: "pharmacy/deleteDrugListsByID",
                data: {deleteId:$('input:radio:checked').val()},
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
        // //设置保存按钮功能
        // $("#updateDrug").click(function () {
        //     $.ajax({
        //         type: "POST",
        //         url: "nonDrugList/updateNonDrugLists",
        //         data: $('#registrationLevelForm').serialize(),
        //         success: function () {
        //             alert("保存成功");
        //             getPageN(1);
        //         },
        //         error: function () {
        //             alert("保存失败");
        //         }
        //     });
        // });
        //查找按钮
        $("#submit").click(function(){
            $.ajax({
                type:"POST",
                url :'pharmacy/searchBy',
                data: {code :$("#drug_code").val(),name:$("#drug_name").val(),dosage: $("#drug_dosage").val(),mnemonic:$("#mnemonic_code").val()},
                contentType:"application/x-www-form-urlencoded;charset=utf-8",
                async:false,
                success :function(result){
                    drugList=result;
                    setDrugTable();
                },
                error :function(){
                    alert("search fail");
                }
            });
        });
        $(document).on('click','#newDrug',function(){
            $('#insertDrugDialog').modal('show');
        });
    });



</script>
</body>
</html>
