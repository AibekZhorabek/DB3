<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MedPortal</title>
</head>
<body>


<c:if test = "${sessionScope.currentCity == null}">
    <jsp:forward page="selectCity.jsp" />
</c:if>

<c:if test = "${sessionScope.currentCity != null}">
    <c:redirect url = "http://localhost:8081/main" />
</c:if>


<%--<jsp:forward page="main.jsp" />--%>
</body>
</html>
