<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <input type="text" class="form-control" placeholder="Врачи, клиники, услуги" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-danger" type="submit" id="button-addon2">Найти</button>
                    </div>
                </div>
            </form>
        </div>

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
                                <h4>532 315</h4>
                                <span class="text-muted">клиник</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="row border-right" style="height: 85%;">
                        <div class="col-3 align-self-center">
                            <div class="">
                                <span style="font-size: 40px;color:lightskyblue" class=""><i class="fas fa-clinic-medical"></i></span>
                            </div>
                        </div>
                        <div class="col-9">
                            <div class="ml-2">
                                <h4>532 315</h4>
                                <span class="text-muted">клиник</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="row border-right" style="height: 85%;">
                        <div class="col-3 align-self-center">
                            <div class="">
                                <span style="font-size: 40px;color:lightskyblue" class=""><i class="fas fa-clinic-medical"></i></span>
                            </div>
                        </div>
                        <div class="col-9">
                            <div class="ml-2">
                                <h4>532 315</h4>
                                <span class="text-muted">клиник</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="row border-right" style="height: 85%;">
                        <div class="col-3 align-self-center">
                            <div class="">
                                <span style="font-size: 40px;color:lightskyblue" class=""><i class="fas fa-clinic-medical"></i></span>
                            </div>
                        </div>
                        <div class="col-9">
                            <div class="ml-2">
                                <h4>532 315</h4>
                                <span class="text-muted">клиник</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="row" style="height: 85%;">
                        <div class="col-3 align-self-center">
                            <div class="">
                                <span style="font-size: 40px;color:lightskyblue" class=""><i class="fas fa-clinic-medical"></i></span>
                            </div>
                        </div>
                        <div class="col-9">
                            <div class="ml-2">
                                <h4>532 315</h4>
                                <span class="text-muted">клиник</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </div>

    <div style="margin-top: 70px;" class="bg-light">
        <div class="container" style="padding-top: 100px;padding-bottom: 100px;">
            <div class="row">
                <div class="col">
                    <div class="text-center">
                        <h3>В вашем городе</h3>
                    </div>
                </div>
            </div>


        <div class="row row-cols-4 pt-5">
            <div class="col">
                <div class="card" style="">
                    <div class="card-header">
                        Featured
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Dapibus ac facilisis in</li>
                        <li class="list-group-item">Vestibulum at eros</li>
                    </ul>
                </div>
            </div>
            <div class="col">
                <div class="card" style="">
                    <div class="card-header">
                        Featured
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Dapibus ac facilisis in</li>
                        <li class="list-group-item">Vestibulum at eros</li>
                    </ul>
                </div>
            </div>
            <div class="col">
                <div class="card" style="">
                    <div class="card-header">
                        Featured
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Dapibus ac facilisis in</li>
                        <li class="list-group-item">Vestibulum at eros</li>
                    </ul>
                </div>
            </div>
            <div class="col">
                <div class="card" style="">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-8">
                                <a href="" class="text-dark text-left font-weight-bold" style="font-size: 20px;">Клиники</a>
                            </div>
                            <div class="col-4 text-right">
                                <span class="text-muted font-weight-bold" style="font-size: 20px;">857</span>
                            </div>
                        </div>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="row">
                                <div class="col-8">
                                    <a href="" class="text-dark text-left">Cras justo odio</a>
                                </div>
                                <div class="col-4 text-right">
                                    <span class="text-muted">857</span>
                                </div>
                            </div>
                        </li>
                        <div class="list-group-item">
                            <div class="row">
                                <div class="col-8">
                                    <a href="" class="text-dark text-left">Cras justo odio</a>
                                </div>
                                <div class="col-4 text-right">
                                    <span class="text-muted">857</span>
                                </div>
                            </div>

                        </div>
                        <li class="list-group-item">
                            <div class="row">
                                <div class="col-8">
                                    <a href="" class="text-dark text-left">Cras justo odio</a>
                                </div>
                                <div class="col-4 text-right">
                                    <span class="text-muted">857</span>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row">
                                <div class="col-8">
                                    <a href="" class="text-dark text-left">Cras justo odio</a>
                                </div>
                                <div class="col-4 text-right">
                                    <span class="text-muted">857</span>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        </div>
    </div>

</div>


<%--<jsp:include page="joinUs.jsp"/>--%>
<jsp:include page="footer.jsp"/>
<jsp:include page="scripts.jsp"/>
</body>
</html>


