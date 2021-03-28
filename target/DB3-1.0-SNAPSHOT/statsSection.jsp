<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="${sessionScope.currentLanguage}"/>
<fmt:setBundle basename="Language"/>


<jsp:include page="head.jsp"/>


<div class="pt-4">
    <div class="row row-cols-5">
        <div class="col">
            <div class="row border-right" style="height: 85%;">
                <div class="col-3 align-self-center">
                    <div class="">
                        <span style="font-size: 40px;color:lightskyblue" class=""><i class="fas fa-clinic-medical"></i></span>
                    </div>
                </div>
                <div class="col-9">
                    <div class="ml-2">
                        <h4>
                            <c:if test = "${sessionScope.allPharmacy != null}">
                                ${fn:length(sessionScope.allPharmacy)}
                            </c:if>
                        </h4>
                        <span class="text-muted">аптек</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="row border-right" style="height: 85%;">
                <div class="col-3 align-self-center">
                    <div class="">
                        <span style="font-size: 40px;color:lightskyblue" class=""><i class="fas fa-pills"></i></span>
                    </div>
                </div>
                <div class="col-9">
                    <div class="ml-2">
                        <h4>
                            <c:if test = "${sessionScope.allMedicine != null}">
                                ${fn:length(sessionScope.allMedicine)}
                            </c:if>
                        </h4>
                        <span class="text-muted">лекарств</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="row border-right" style="height: 85%;">
                <div class="col-3 align-self-center">
                    <div class="">
                        <span style="font-size: 40px;color:lightskyblue" class=""><i class="fas fa-hospital"></i></span>
                    </div>
                </div>
                <div class="col-9">
                    <div class="ml-2">
                        <h4>
                            <c:if test = "${sessionScope.allMedCenters != null}">
                                ${fn:length(sessionScope.allMedCenters)}
                            </c:if>
                        </h4>
                        <span class="text-muted">мед.центров</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="row border-right" style="height: 85%;">
                <div class="col-3 align-self-center">
                    <div class="">
                        <span style="font-size: 40px;color:lightskyblue" class=""><i class="fas fa-user-md"></i></span>
                    </div>
                </div>
                <div class="col-9">
                    <div class="ml-2">
                        <h4>
                            <c:if test = "${sessionScope.allDoctors != null}">
                                ${fn:length(sessionScope.allDoctors)}
                            </c:if>
                        </h4>
                        <span class="text-muted">докторов</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="row" style="height: 85%;">
                <div class="col-3 align-self-center">
                    <div class="">
                        <span style="font-size: 40px;color:lightskyblue" class=""><i class="fas fa-comments"></i></span>
                    </div>
                </div>
                <div class="col-9">
                    <div class="ml-2">
                        <h4>37213</h4>
                        <span class="text-muted">отзывов</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="scripts.jsp"/>