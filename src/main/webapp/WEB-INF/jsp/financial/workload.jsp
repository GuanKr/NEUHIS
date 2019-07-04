<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/7/3
  Time: 13:51
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
    <title>工作量统计</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
<ol class="breadcrumb container">
    <li><a href="#">首页</a></li>
    <li class="active">工作量统计</li>
</ol>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
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
                        <a class="navbar-brand" href="#">财务管理</a>

                    </div>
                    <div class="collapse navbar-collapse" id="example-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li ><a href="financial/expenseClassManagement">费用科目管理</a></li>
                            <li class="active"><a href="financial/workload" >工作量统计</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<form class="" role="form" id="addRegistrationLevel">
    <div class="container">
        <div class="form-group col-md-3">
            <select class="form-control" id="role"  name="role">
                <option value="1" onclick="unshowInputId()">执行科室</option>
                <option value="2" onclick="unshowInputId()">开立科室</option>
                <option value="3" onclick="unshowInputId()">全部医生</option>
                <option value="4" onclick="showInputId()">门诊医生</option>
<%--                需要医生id--%>
            </select>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-3 control-label text-left" >开始时间</label>
            <div class="col-md-8 input-group left">
                <input type="date" class="form-control" name="startTime"  id="startTime"/>
            </div>
        </div>
        <div class="form-group col-md-3">
            <label class="col-md-3 control-label text-left" >结束时间</label>
            <div class="col-md-8 input-group left">
                <input type="date" class="form-control" name="endTime" id="endTime"/>
            </div>
        </div>
<%--        <div class="col-md-2 pull-right">--%>
<%--            <input type="reset" class="btn btn-default" value="清空" />&nbsp;&nbsp;--%>
<%--            <button type="button" id="addRegistrationLevelButton" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;添加&nbsp;&nbsp;&nbsp;&nbsp;</button>--%>
<%--        </div>--%>
        <div class="form-group col-md-3">
            <input type="text" id="doctorId" class="form-control col-md-1" style="display: none ;max-width: 100px "/>
            <button type="button" id="search" onclick="findWorkload($('#role').val())" class=" btn btn-primary  col-md-6">&nbsp;&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>
    </div>
</form>
<form class="container" id="workloadForm">
    <table class="table table-hover table-striped">
        <thead id="tableHead">
        </thead>
        <tbody id="tableBody">
        </tbody>
    </table>
</form>

</table>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    var workloadList="";
    function showInputId(){
        $("#doctorId").css('display','block');
    }
    function unshowInputId(){
        $("#doctorId").css('display','none');
    }
    function findWorkload(i){
        //执行科室
        if(i==1){
            $.ajax({
                type:"POST",
                url:"financial/executiveDepartmentWorkload",
                data:{startTime: $("#startTime").val(),endTime: $("#endTime").val()},
                async: false,
                success:function(result){
                    workloadList=result;
                    var headstr="";
                    $("#tableHead").html("");
                    headstr+="<tr>\n" +
                        "            <th>科室名称</th>\n" +
                        "            <th>发票数量</th>\n" +
                        "            <th>看诊人数</th>\n" +
                        "            <th>挂号费</th>\n" +
                        "            <th>处方费</th>\n" +
                        "            <th>检查费</th>\n" +
                        "            <th>检验费</th>\n" +
                        "            <th>处置费</th>\n" +
                        "            <th>金额</th>\n" +
                        "        </tr>";
                    $("#tableHead").append(headstr);
                    var bodystr="";
                    $("#tableBody").html("");
                    for(var k=0; k<workloadList.length;k++){
                        bodystr+=" <tr>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].departmentName+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].invoiceQuantity+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].seeQuantity+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].regCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].drugCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].inspectionCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].checkoutCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].handleCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].cost+"\" /></th>\n" +
                            "        </tr>";
                    }
                    $("#tableBody").append(bodystr);
                },
                error:function(){
                    alert("search fail");
                }
            });
        }
        //开立科室
        if(i==2){
            $.ajax({
                type:"POST",
                url:"financial/drawBillDepartmentWorkload",
                data:{startTime: $("#startTime").val(),endTime: $("#endTime").val()},
                async: false,
                success:function(result){
                    workloadList=result;
                    var headstr="";
                    $("#tableHead").html("");
                    headstr+="<tr>\n" +
                        "            <th>科室Id</th>\n" +
                        "            <th>科室名称</th>\n" +
                        "            <th>发票数量</th>\n" +
                        "            <th>看诊人数</th>\n" +
                        "            <th>挂号费</th>\n" +
                        "            <th>处方费</th>\n" +
                        "            <th>检查费</th>\n" +
                        "            <th>检验费</th>\n" +
                        "            <th>处置费</th>\n" +
                        "            <th>金额</th>\n" +
                        "        </tr>";
                    $("#tableHead").append(headstr);
                    var bodystr="";
                    $("#tableBody").html("");
                    for(var k=0; k<workloadList.length;k++){
                        bodystr+=" <tr>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].departmentId+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].departmentName+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].invoiceQuantity+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].seeQuantity+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].regCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].drugCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].inspectionCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].checkoutCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].handleCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].cost+"\" /></th>\n" +
                            "        </tr>";
                    }
                    $("#tableBody").append(bodystr);
                },
                error:function(){
                    alert("search fail");
                }
            });
        }
        //quanbuyisheng
        if(i==3){
            $.ajax({
                type:"POST",
                url:"financial/allPersonWorkload",
                data:{startTime: $("#startTime").val(),endTime: $("#endTime").val()},
                async: false,
                success:function(result){
                    workloadList=result;
                    var headstr="";
                    $("#tableHead").html("");
                    headstr+="<tr>\n" +
                        "            <th>医生姓名</th>\n" +
                        "            <th>发票数量</th>\n" +
                        "            <th>看诊人数</th>\n" +
                        "            <th>挂号费</th>\n" +
                        "            <th>处方费</th>\n" +
                        "            <th>检查费</th>\n" +
                        "            <th>检验费</th>\n" +
                        "            <th>处置费</th>\n" +
                        "            <th>金额</th>\n" +
                        "        </tr>";
                    $("#tableHead").append(headstr);
                    var bodystr="";
                    $("#tableBody").html("");
                    for(var k=0;k<workloadList.length;k++){
                        bodystr+=" <tr>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].doctorName+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].invoiceQuantity+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].seeQuantity+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].regCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].drugCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].inspectionCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].checkoutCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].handleCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].cost+"\" /></th>\n" +
                            "        </tr>";
                    }

                    $("#tableBody").append(bodystr);
                },
                error:function(){
                    alert("search fail");
                }
            });
        }
        if(i==4){
            $.ajax({
                type:"POST",
                url:"financial/personalWorkload",
                data:{startTime: $("#startTime").val(),endTime: $("#endTime").val(),doctorId:$("#doctorId").val()},
                async: false,
                success:function(result){
                    workloadList=result;
                    var headstr="";
                    $("#tableHead").html("");
                    headstr+="<tr>\n" +
                        "            <th>医生姓名</th>\n" +
                        "            <th>患者姓名</th>\n" +
                        "            <th>病历号</th>\n" +
                        "            <th>挂号费</th>\n" +
                        "            <th>处方费</th>\n" +
                        "            <th>检查费</th>\n" +
                        "            <th>检验费</th>\n" +
                        "            <th>处置费</th>\n" +
                        "            <th>金额</th>\n" +
                        "        </tr>",
                    $("#tableHead").append(headstr);
                    var bodystr="";
                    $("#tableBody").html("");
                    for(var k=0;k<workloadList.length;k++){
                        bodystr+=" <tr>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].doctorName+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].patientName+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].medicalNo+"\"/></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].regCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].drugCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].inspectionCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].checkoutCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].handleCost+"\" /></th>\n" +
                            "            <th><input type=\"text\" class=\"form-control\" value=\""+workloadList[k].cost+"\" /></th>\n" +
                            "        </tr>";
                    }
                    $("#tableBody").append(bodystr);
               },
                error:function(){
                    alert("search fail");
                }
            });
        }

    }
</script>
</body>
</html>
