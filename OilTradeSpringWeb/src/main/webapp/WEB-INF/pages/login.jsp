 <%@ include file="includePage.jsp"%>
 <html>
<head>
<title><fmt:message key="login.page.title" bundle="${one}" /></title>
</head>

 <body>

	<h3>
		FROM WEB-INF <fmt:message key="login.page.head" bundle="${one}" />
	</h3>
	
	
	
	
	
	Create new User <a href="<c:url value='/newUser' />">Create new User</a>
	
	
	
	
	<!-- <form action="Controller" name="LoginForm" method="post">
		<input type="hidden" name="command" value="LogIn" />
		<fmt:message key="login.page.login" bundle="${one}" />
		<input name="login" type="text" /><br />
		<fmt:message key="login.page.password" bundle="${one}" />
		<input name="password" type="password" /><br />

		<fmt:message var="loginButton" key="login.page.button" bundle="${one}" />
		<input type="submit" value="${loginButton}"> 
		
		<a href="Controller?command=newUser" ><fmt:message key="login.page.register" bundle="${one}" /> </a>
			<br/>
				
		
	</form>-->
</body>
</html>


 


  
    
    <br/>
    <br/>
    Go back to <a href="<c:url value='/offersListPage' />">List of All Offers</a>
</body>
</html>
-->
