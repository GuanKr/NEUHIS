<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/6/29
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body style="margin-top: 50px">
<%--<div class="container">--%>
<%--    <div class="row clearfix">--%>
<%--        <div class="col-md-12 column">--%>
<%--            <ul class="breadcrumb">--%>
<%--                <li><a href="#">主页</a></li>--%>
<%--                <li class="active">药房工作站</li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="container">--%>
<%--    <div class="row clearfix">--%>
<%--        <div class="col-md-12 column">--%>
<%--            <nav class="navbar navbar-default" role="navigation">--%>
<%--                <div class="container-fluid">--%>
<%--                    <div class="navbar-header">--%>
<%--                        <button type="button" class="navbar-toggle" data-toggle="collapse"--%>
<%--                                data-target="#example-navbar-collapse">--%>
<%--                            <span class="sr-only">切换导航</span>--%>
<%--                            <span class="icon-bar"></span>--%>
<%--                            <span class="icon-bar"></span>--%>
<%--                            <span class="icon-bar"></span>--%>
<%--                        </button>--%>
<%--                        <a class="navbar-brand" href="#">药房工作站</a>--%>

<%--                    </div>--%>
<%--                    <div class="collapse navbar-collapse" id="example-navbar-collapse">--%>
<%--                        <ul class="nav navbar-nav">--%>
<%--                            <li ><a href="pharmacy/drugManagement">药品信息维护</a></li>--%>
<%--                            <li class="active"><a href="pharmacy/deliverDrug">发药</a></li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </nav>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--导航栏--%>
<div class="container"><div class="row clearfix"><div class="column">
    <nav id="nav" class="navbar navbar-default">
        <a class="navbar-brand">HIS</a>
        <ul class="nav navbar-nav" style="width: 93%">
            <li><a href="pharmacy/drugManagement">药品信息维护</a></li>
            <li class="active"><a href="pharmacy/deliverDrug" >发药</a></li>
            <li class="active pull-right" style="top: 10px"><input style="top: 10px" class="btn btn-danger" type="button" id="logOutButton" value="退出"/></li>
            <li class="pull-right" id="loginUser"></li>
            <a style="display: none" id="logOut" href="${pageContext.request.contextPath}/logout">退出</a>
            <li style="display: none"><input id="doctorID"/></li>
        </ul>
    </nav>
</div></div></div>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-3 column">
            <form role="form">
                <label class="col-md-4 control-label text-right" for="medical-record-no">病历号</label>
                <div class="col-md-8 form-group" >
                    <input type="text" class="form-control" id="medical-record-no" name="medical-record-no"/>
                </div>

                <label class="col-md-4 control-label text-right" for="state">状态</label>
                <div class="col-md-8 form-group" >
                    <select data-am-selected class="form-control" id = "state" name="state">
                        <option value="0" selected >未发</option>
                        <option value="1"  >已退</option>
                        <option value="2">已发</option>
                    </select>
                </div>
                <button class="btn btn-default" type="button" id="searchBy">search</button>
            </form>
            <table class="table table-hover table-striped">
                <thead>
                </thead>
                <tbody id="prescriptionTable">
                </tbody>
            </table>
        </div>
        <div class="col-md-9 column">
            <table class="table table-hover table-striped">
                <thead id="detailHead">
                <tr>
                    <th>病历号</th>
                    <th>姓名</th>
                    <th>药品名称</th>
                    <th>数量</th>
                    <th>总价</th>
                    <th>单价</th>
                    <th>发药</th>
                </tr>
                </thead>
                <tbody id="detailsTable" >
                </tbody>
            </table>
        </div>
    </div >
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
    var patientName="";
    var prescriptionList="";
    var certainPrescription;

    function findName(){
        $.ajax({
            type: "POST",
            url: "pharmacy/findNameByMedical",
            async: false,
            data: { medicalNo: $("#medical-record-no").val()},
            success: function (result) {
                patientName=result;
            },
            error : function(){
                alert("find name from registration fail");
            }
        });
    }
    function setPrescriptionTable(){
        var str;
        str = "";
        $("#prescriptionTable").html("");
        for (var i = 0;i <prescriptionList.length;i++){
            str +="<tr  onclick=\"showDetails('"+prescriptionList[i].medicalRecordNo+"','"+prescriptionList[i].id+"')\"  >\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\""+prescriptionList[i].medicalRecordNo+"\" name=\"\" id=\"foundMedicalNo\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\""+patientName+"\" name=\"\" id=\"foundName\"/></td>\n" +
                "<td><input type=\"text\" class=\"form-control\" value=\""+prescriptionList[i].id+"\" name=\"\" id=\"foundId\"/></td>\n" +
                "</tr>"
        }
        $("#prescriptionTable").append(str);
    }
    //发药/退药按钮
    function takeMedicine(i){
        $.ajax({
            type: "POST",
            url: "pharmacy/takeMedicine",
            data: {medicalNo :prescriptionList[i].medicalRecordNo, prescriptionId:prescriptionList[i].id},
            async: false,
            success: function(){
                alert("take Medicine success");
            },
            error: function(){
                alert("take Medicine fail");
            }
        });

    }
    function returnMedicine(medicalNo,prescriptionId,quantity){
        var resulstr="";
        $.ajax({
            type: "POST",
            url: "pharmacy/returnMedicine",
            data: {medicalNo :medicalNo,prescriptionId:prescriptionId ,quantity:quantity},
            async: false,
            success: function(result){
                resultstr=result;
                alert(resultstr);
            },
            error: function(){
                alert("return Medicine fail");
            }
        });
    }
    function showDetails(){
        if($("#state").val()==0){

            var headstr="";
            $("#detailHead").html("");
            headstr+="<tr>\n" +
                "                    <th>病历号</th>\n" +
                "                    <th>姓名</th>\n" +
                "                    <th>药品名称</th>\n" +
                "                    <th>数量</th>\n" +
                "                    <th>总价</th>\n" +
                "                    <th>单价</th>\n" +
                "                    <th>发药</th>\n" +
                "                </tr>";
            $("#detailHead").append(headstr);

            $("#detailsTable").html("");
            var str="";
            for(var i=0;i<prescriptionList.length;i++){
                str+="<tr>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+prescriptionList[i].medicalRecordNo+"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+patientName.msg+"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+prescriptionList[i].drugName+"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+prescriptionList[i].quantity+"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+prescriptionList[i].cost+"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+prescriptionList[i].drugPrice+"\" /></td>\n" +
                    "<td><button class=\"btn btn-primary \" type=\"button\" id=\"takeMedicine\" onclick=\"takeMedicine("+ i +")\" >发药</button></td>\n" +
                    "</tr>";
            }
            $("#detailsTable").append(str);
        }
        if($("#state").val()==1){

            var headstr="";
            $("#detailHead").html("");
            headstr+="<tr>\n" +
                "                    <th>病历号</th>\n" +
                "                    <th>姓名</th>\n" +
                "                    <th>药品名称</th>\n" +
                "                    <th>数量</th>\n" +
                "                    <th>总价</th>\n" +
                "                    <th>单价</th>\n" +
                "                </tr>";
            $("#detailHead").append(headstr);

            $("#detailsTable").html("");
            var str="";
            for(var i=0;i<prescriptionList.length;i++){
                str+="<tr>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+prescriptionList[i].medicalRecordNo+"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+patientName.msg+"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+prescriptionList[i].drugName+"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+prescriptionList[i].quantity+"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+prescriptionList[i].cost+"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\""+prescriptionList[i].drugPrice+"\" /></td>\n" +
                    "</tr>";
            }
            $("#detailsTable").append(str);
        }
        if($("#state").val()==2) {
            var headstr = "";
            $("#detailHead").html("");
            headstr += "<tr>\n" +
                "                    <th>病历号</th>\n" +
                "                    <th>姓名</th>\n" +
                "                    <th>药品名称</th>\n" +
                "                    <th>数量</th>\n" +
                "                    <th>总价</th>\n" +
                "                    <th>单价</th>\n" +
                "                    <th>退药数量</th>\n" +
                "                    <th>退药</th>\n" +
                "                </tr>";
            $("#detailHead").append(headstr);

            $("#detailsTable").html("");
            var str = "";
            for (var i = 0; i < prescriptionList.length; i++) {
                str += "<tr \">\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\"" + prescriptionList[i].medicalRecordNo + "\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\"" + patientName.msg +"\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\"" + prescriptionList[i].drugName + "\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\"" + prescriptionList[i].quantity + "\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\"" + prescriptionList[i].cost + "\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\" value=\"" + prescriptionList[i].drugPrice + "\" /></td>\n" +
                    "<td><input class=\"form-control\" type=\"text\"  id =\"quantity\"/></td>\n" +
                    "<td onclick=\"returnMedicine('"+prescriptionList[i].medicalRecordNo+"','"+prescriptionList[i].id+"',$(this).prev().children(':input').val())\" ><button class=\"btn btn-primary \" type=\"button\" id=\"takeMedicine\" >退药</button></td>\n" +
                    "</tr>";
            }
            $("#detailsTable").append(str);

        }
    }
    $(document).ready(function () {

        $("#loginUser").append("<a>" + "${USER_SESSION.loginName}" + "</a><input style=\"display: none\" id=\"userID\" value='" + ${USER_SESSION.id} + "'/>");
        <%--$("#doctorID").val(${USER_SESSION.id});--%>
        $("#logOutButton").click(function (){
            document.getElementById("logOut").click();
        });

        //searchBy按钮
        $("#searchBy").click(function(){
            $.ajax({
                type: "POST",
                url: "pharmacy/findAllDrugPrescriptionByMedical",
                data: {medicalNo: $("#medical-record-no").val(),state: $("#state").val()},
                success: function (result){
                    prescriptionList=result;
                    findName();
                    showDetails();
                },
                error:function(){
                    alert("findAll fail");
                }
            });
        });
    });

</script>
</body>
</html>
