<%@ include file="includePage.jsp"%>
 <html>
<head>
<title><fmt:message key="login.page.title" bundle="${one}" /></title>
</head>

 <body>

	<h3>
		<fmt:message key="login.page.head" bundle="${one}" />
	</h3>
	<form action="Controller" name="LoginForm" method="post">
		<input type="hidden" name="command" value="LogIn" />
		<fmt:message key="login.page.login" bundle="${one}" />
		<input name="login" type="text" /><br />
		<fmt:message key="login.page.password" bundle="${one}" />
		<input name="password" type="password" /><br />

		<fmt:message var="loginButton" key="login.page.button" bundle="${one}" />
		<input type="submit" value="${loginButton}"> 
		
		<a href="Controller?command=Registrate" ><fmt:message key="login.page.register" bundle="${one}" /> </a>
			<br/>
				
		
	</form>
</body>
</html>

-->


<!--
<%@ include file="includePage.jsp"%>
 <html>
<head>
<title><fmt:message key="login.page.title" bundle="${one}" /></title>
</head>
 <body>

	<div class="container">

		<div class="jumbotron" style="margin-top: 20px;">
			<h1>Devcolibri.com</h1>
			<p class="lead">Devcolibri - это сервис предоставляющий всем
				желающим возможность обучаться программированию.</p>
			<sec:authorize access="!isAuthenticated()">
				<p>
					<a class="btn btn-lg btn-success" href="<c:url value="/login" />"
						role="button">Войти</a>
				</p>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<p>
					Ваш логин:
					<sec:authentication property="principal.username" />
				</p>
				<p>
					<a class="btn btn-lg btn-danger" href="<c:url value="/logout" />"
						role="button">Выйти</a>
				</p>

			</sec:authorize>
		</div>

		

	</div>
</body>
</html>
-->