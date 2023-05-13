<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgott Password</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="<c:url value='/template/login/css/style.css'/>">
	<script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<style>
	.form-gap {
    padding-top: 70px;
}
</style>
<body class="img js-fullheight"
	style="background-image: url(<c:url value='https://thuthuatnhanh.com/wp-content/uploads/2022/06/Hinh-nen-iPad-4K.jpg' />);">
	<div class="form-gap"></div>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
              <div class="panel-body">
                <div class="text-center">
                  <h3><i class="fa fa-lock fa-4x"></i></h3>
                  <h2 class="text-center">Forgot Password?</h2>
                  <h5 class="text-center">You can reset your password here.</h5>
                  <p></p>
                  <div class="panel-body">
    
                    <form action="${pageContext.request.contextPath}/forgetPassword" id="register-form" role="form" autocomplete="off" class="form" method="post">
    
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                          <input id="email" name="email" placeholder="email address" class="form-control"  type="email">
                        </div>
                      </div>
                      <div class="form-group">
                        <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit">
                      </div>
                     <h2 class="text-center">${ThongBao}</h2>
                     <a href="${pageContext.request.contextPath}/login"><h2 class="text-center">Login</h2></a>
                    </form>
    
                  </div>
                </div>
              </div>
            </div>
          </div>
	</div>
</div>
<script src="<c:url value='/template/login/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/login/js/popper.js'/>"></script>
	<script src="<c:url value='/template/login/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/template/login/js/main.js'/>"></script>
</body>
</html>