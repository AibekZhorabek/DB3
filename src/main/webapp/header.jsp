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


<nav class="navbar navbar-expand-lg navbar-light bg-white sticky-top">
    <div class="container py-2">
        <a class="navbar-brand" href="index.jsp">
            <h4><span style="color: crimson">Med</span><span style="color: lightskyblue">Portal</span></h4>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="container border-right mr-3">
                <ul class="nav justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link" href="/pharmacies"><fmt:message key = "card.pharmacy"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/medicines"><fmt:message key = "card.medicines"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/medical-centers">Мед.центры</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/doctors">Врачи</a>
                    </li>
                </ul>
            </div>

            <form class="form-inline my-2 my-lg-0 mr-3" title="Select language" action="changeLanguage" method="post">
                <input type="hidden" name="returnTo" value="${pageUrl}">
                <select class="form-control" name="language" onchange="this.form.submit()" id="select">
                    <option value="ru" <c:if test="${\"ru\" == sessionScope.currentLanguage }"><c:out value = "selected"/></c:if>>RU</option>
                    <option value="en" <c:if test="${\"en\" == sessionScope.currentLanguage }"><c:out value = "selected"/></c:if>>EN</option>
                </select>
            </form>

            <form class="form-inline my-2 my-lg-0 mr-3" title="Select city" action="changeCity" method="post">
                <input type="hidden" name="returnTo" value="${pageUrl}">
                <select class="form-control" name="city" onchange="this.form.submit()" id="select1">
                    <c:forEach var = "city" items="${sessionScope.allCity}">
                        <option value="${city.id}" <c:if test="${sessionScope.currentCity.name eq city.name }"><c:out value = "selected"/></c:if>>${city.name}</option>
                    </c:forEach>
                </select>
            </form>

            <c:choose>
                <c:when test = "${sessionScope.currentUser != null}">
                    <div class="dropdown">
                        <button class="btn dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${sessionScope.currentUser.lastName}  ${sessionScope.currentUser.firstName}
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu">
                            <form action="logout" method="get">
                                <button class="dropdown-item" type="submit">Log out</button>
                            </form>
                        </div>
                    </div>
                </c:when>

                <c:when test = "${sessionScope.currentDoctor != null}">
                    <div class="dropdown">
                        <button class="btn dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${sessionScope.currentDoctor.lastName}  ${sessionScope.currentDoctor.firstName}
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <form action="logoutDoctor" method="get">
                                <button class="dropdown-item" type="submit">Log out</button>
                            </form>
                        </div>
                    </div>
                </c:when>


                <c:otherwise>
                    <a href="login.jsp" class="nav-link"><fmt:message key = "login"/></a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>






