<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.currentLanguage}"/>
<fmt:setBundle basename="Language"/>
<html>
<head>
    <jsp:include page="head.jsp"/>


    <style>
        .cards:hover{
            background-color: #FBFBFB;
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="bg-white pb-5" style="padding-bottom: 30px;">
    <div class="container">

        <div class="pt-5">
            <div class="row">
                <div class="col">
                    <h3><fmt:message key = "welcome.msg"/> <span style="color: crimson">Med</span><span style="color: lightskyblue">Portal</span></h3>
                </div>
            </div>
        </div>

        <div class="pt-3">
            <form action="" method="get">
                <div class="input-group input-group-lg">
                    <input type="text" class="form-control" placeholder="Врачи, мед.центры, аптеки, лекарства" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-danger" type="submit" id="button-addon2">Найти</button>
                    </div>
                </div>
            </form>
        </div>


        <jsp:include page="statsSection.jsp"/>
    </div>

    <jsp:include page="inUserCitySection.jsp"/>
</div>





<%--<jsp:include page="joinUs.jsp"/>--%>
<jsp:include page="footer.jsp"/>
<jsp:include page="scripts.jsp"/>
</body>
</html>


