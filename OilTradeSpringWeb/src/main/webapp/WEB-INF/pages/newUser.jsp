<%@ include file="includePage.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>
<fmt:message key = "create.user.page.title"/>
</title>

<body>
<h3><fmt:message key="create.user.page.head" bundle="${one}"/></h3>
<body>
 <form:form method="POST" action="newUser" modelAttribute="user">
             <table>
                <tr>
                    <td><form:label path="user_name">Name</form:label></td>
                    <td><form:input path="user_name"/></td>
                </tr>
                <tr>
                    <td><form:label path="login">Login</form:label></td>
                    <td><form:input path="login"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:input path="password"/></td>
                </tr>
                <tr>
                    <td><form:label path="city">City</form:label></td>
                    <td><form:input path="city"/></td>
                </tr>
                <tr>
                    <td><form:label path="country">Country</form:label></td>
                    <td><form:input path="country"/></td>
                </tr>
                <tr>
                    <td><form:label path="telephone">Telephone</form:label></td>
                    <td><form:input path="telephone"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="save user"/></td>
                </tr>
            </table>
        </form:form>
        
        List of users <a href="<c:url value='/listUsers' />">List of users</a>
</body>
</html>