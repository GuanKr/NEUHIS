<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2019/6/27
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
<%--    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">--%>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>

<style type="text/css">
    body{
        background-image: url('https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1561630327&di=f3daf214b2b68f55df4529bd63e5f0be&src=http://hbimg.b0.upaiyun.com/b1f76f2b2bc33abe60540577d4e8d872e4e0d40870fd6-zNlpSc_fw658');
        background-size:cover;
    }
</style>
<body>

<%--
<td style = "background-image:url('https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1561630327&di=f3daf214b2b68f55df4529bd63e5f0be&src=http://hbimg.b0.upaiyun.com/b1f76f2b2bc33abe60540577d4e8d872e4e0d40870fd6-zNlpSc_fw658')"></td>
--%>
<!--引入头部JSP-->
<%--<jsp:include page="head.jsp" ></jsp:include>--%>
<!--使用模态框的方式模拟一个登陆框-->
<div class = "modal-header">
    <h1 class="text-center text-primary">东软云医院HIS系统</h1>
</div>

<div class="modal show" style = "background-image:url('https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1561630327&di=f3daf214b2b68f55df4529bd63e5f0be&src=http://hbimg.b0.upaiyun.com/b1f76f2b2bc33abe60540577d4e8d872e4e0d40870fd6-zNlpSc_fw658')" id="loginModal">
    <div class="modal-dialog" >
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close">×</button>
                <h2 class="text-center text-primary">登录</h2>
            </div>
            <div class="modal-body">
                <form class="form col-md-12 center-block" id="loginForm" action="${pageContext.request.contextPath}/login" method="post">
                    <div class="form-group-lg"  id="accountDiv">
                        <label class="sr-only" for="inputAccount">账号</label>
                        <div class="input-group">
                            <div class="input-group-addon"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></div>
                            <input class="form-control" id="inputAccount" name="loginName" type="text" placeholder="账号" required autofocus>
                        </div>
                    </div>
                    <br>
                    <div class="form-group-lg" id="pwdDiv">
                        <label class="sr-only" for="inputPassword">密码</label>
                        <div class="input-group">
                            <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                            <input class="form-control" id="inputPassword" name="password" type="password" placeholder="密码" required>
                            <div class="input-group-addon"><span class="glyphicon glyphicon-eye-open"></span></div>
                        </div>
                     <br>
                        <div class="text-center" id="pwdMsg">${msg}</div>
                    </div>
<%--                    <div class="checkbox">
                        <label> <input type="checkbox" value="remember-me">记住我</label>
                    </div>--%>
                    <div class="form-group" >
                        <button class="btn btn-default btn-lg col-md-3" style="visibility: hidden" type="button"></button>
                        <button class="btn btn-primary btn-lg col-md-6" id="btn_login"  onclick="login()" type="button" >登录</button>
                        <button class="btn btn-default btn-lg col-md-3" style="visibility: hidden" type="button"></button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<!-- /container -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<%--<script src="<%=basePath %>resources/js/myJs/login.js"></script>--%>
<script type="text/javascript">
function login(){
    var loginName = $("#inputAccount").val();//获取登陆用户名
    var password = $("#inputPassword").val();  //获取登陆密码
        $("#loginForm").submit();
}
</script>
</body>
</html>
