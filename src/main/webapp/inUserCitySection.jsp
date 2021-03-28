<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="${sessionScope.currentLanguage}"/>
<fmt:setBundle basename="Language"/>


<div style="margin-top: 70px;" class="bg-light">
    <div class="container" style="padding-top: 100px;padding-bottom: 100px;">
        <div class="row">
            <div class="col">
                <div class="text-center">
                    <h3><span style="color: crimson">Популярное</span> в ${sessionScope.currentCity.name}</h3>
                </div>
            </div>
        </div>


        <div class="row row-cols-4 pt-5">
            <div class="col">
                <div class="card" style="">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-8">
                                <a href="" class="text-dark text-left font-weight-bold" style="font-size: 20px;">Аптеки</a>
                            </div>
                            <div class="col-4 text-right">
                                <span class="text-muted font-weight-bold" style="font-size: 20px;">
                                    <c:if test = "${sessionScope.pharmaciesByCityId != null}">
                                        ${fn:length(sessionScope.pharmaciesByCityId)}
                                    </c:if>
                                </span>
                            </div>
                        </div>
                    </div>
                    <ul class="list-group list-group-flush">
                        <c:forEach var = "pharmacy" items="${sessionScope.popularPharmacies}">
                            <li class="list-group-item">
                                <div class="row">
                                    <div class="col-8">
                                        <a href="" class="text-dark text-left">${pharmacy.key}</a>
                                    </div>
                                    <div class="col-4 text-right">
                                        <span class="text-muted">${pharmacy.value}</span>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="row">
                        <div class="col" >
                            <a href="" class="btn btn-outline-secondary rounded-0 btn-block">ВСЕ АПТЕКИ</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card" style="">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-8">
                                <a href="" class="text-dark text-left font-weight-bold" style="font-size: 20px;">Лекарства</a>
                            </div>
                            <div class="col-4 text-right">
                                <span class="text-muted font-weight-bold" style="font-size: 20px;">
                                    <c:if test = "${sessionScope.popularMedicines != null}">
                                        ${fn:length(sessionScope.popularMedicines)}
                                    </c:if>
                                </span>
                            </div>
                        </div>
                    </div>
                    <ul class="list-group list-group-flush">
                        <c:forEach var = "medicine" items="${sessionScope.popularMedicines}">
                            <li class="list-group-item">
                                <div class="row">
                                    <div class="col-8">
                                        <a href="" class="text-dark text-left">${medicine.key}</a>
                                    </div>
                                    <div class="col-4 text-right">
                                        <span class="text-muted">${medicine.value}</span>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="row">
                        <div class="col" >
                            <a href="" class="btn btn-outline-secondary rounded-0 btn-block">ВСЕ ЛЕКАРСТВА</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card" style="">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-8">
                                <a href="" class="text-dark text-left font-weight-bold" style="font-size: 20px;">Мед.центры</a>
                            </div>
                            <div class="col-4 text-right">
                                <span class="text-muted font-weight-bold" style="font-size: 20px;">
                                    <c:if test = "${sessionScope.medCentersByCityId != null}">
                                        ${fn:length(sessionScope.medCentersByCityId)}
                                    </c:if>
                                </span>
                            </div>
                        </div>
                    </div>
                    <ul class="list-group list-group-flush">
                        <c:forEach var = "medCenter" items="${sessionScope.popularClinicGroups}">
                            <li class="list-group-item">
                                <div class="row">
                                    <div class="col-8">
                                        <a href="" class="text-dark text-left">${medCenter.key}</a>
                                    </div>
                                    <div class="col-4 text-right">
                                        <span class="text-muted">${medCenter.value}</span>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="row">
                        <div class="col" >
                            <a href="" class="btn btn-outline-secondary rounded-0 btn-block">ВСЕ МЕД.ЦЕНТРЫ</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card" style="">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-8">
                                <a href="" class="text-dark text-left font-weight-bold" style="font-size: 20px;">Врачи</a>
                            </div>
                            <div class="col-4 text-right">
                                <span class="text-muted font-weight-bold" style="font-size: 20px;">
                                    <c:if test = "${sessionScope.popularProfessions != null}">
                                        ${fn:length(sessionScope.popularProfessions)}
                                    </c:if>
                                </span>
                            </div>
                        </div>
                    </div>
                    <ul class="list-group list-group-flush">
                        <c:forEach var = "profession" items="${sessionScope.popularProfessions}">
                            <li class="list-group-item">
                                <div class="row">
                                    <div class="col-8">
                                        <a href="" class="text-dark text-left">${profession.key}</a>
                                    </div>
                                    <div class="col-4 text-right">
                                        <span class="text-muted">${profession.value}</span>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="row">
                        <div class="col" >
                            <a href="" class="btn btn-outline-secondary rounded-0 btn-block">ВСЕ ВРАЧИ</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
