<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${fn:replace(req.requestURL, req.requestURI, '')}" />
<c:set var="params" value="${requestScope['javax.servlet.forward.query_string']}"/>
<c:set var="requestPath" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<c:set var="pageUrl" value="${ baseURL }${ requestPath }${ not empty params?'?'+=params:'' }"/>
<fmt:setLocale value="${sessionScope.currentLanguage}"/>
<fmt:setBundle basename="Language"/>
<html>
<head>
    <jsp:include page="head.jsp"/>

</head>
<body class="bg-light">

<div class="container-fluid pb-5 bg-light h-100" style="background-color: #F2F4F8;">
    <div class="row">
        <div class="col-6 offset-3 pt-5">
            <div class="text-center">
                <h1>Please select your city</h1><br>
                <form class="" title="Select city" action="changeCity" method="post">
                    <input type="hidden" name="returnTo" value="${pageUrl}">
                    <select class="form-control" name="city" onchange="this.form.submit()">
                        <c:forEach var = "city" items="${sessionScope.allCity}">
                            <option value="${city.id}" <c:if test="${sessionScope.currentCity.name eq city.name }"><c:out value = "selected"/></c:if>>${city.name}</option>
                        </c:forEach>
                    </select>
                </form>
            </div>
        </div>
    </div>

</div>

<jsp:include page="scripts.jsp"/>
</body>
</html>



