<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
    <style>
        <%@include file="/WEB-INF/jsp/style/lecturer.css" %>
        <%@include file="/WEB-INF/jsp/style/style.css" %>
    </style>
    <%@include file="/WEB-INF/jsp/header.jsp" %>
</head>
<body>
<header class="header">
    <h1 class="h1">Lecturer Staff</h1>
</header>
<div style="width: 100%">
    <form class="row g-3 form-shadow" method="post">
        <div class="head">
            <h2>${not empty question && not empty question.id?"Edit": "Add"} Question</h2>
        </div>
        <input type="hidden" name="id" value="<c:out value="${question.id}"/>"/>
        <div class="col-md-6">
            <label for="question" class="form-label"></label>
            <input type="text" class="form-control" id="question" name="question" size="45"
                   placeholder="Question..."
                   value="<c:out value="${question.question}"/>"/>
            <p class="error"><c:out value="${errors['question']}"/></p>
        </div>
        <div>
            <a class="btn-form btn-left pointer" type="submit" href="/questions">Back</a>
            <input class="editOrAdd btn-left pointer" type="submit" name="questionAddOrEdit"
                   value="${not empty question && not empty question.id?"Edit" : "Add"}"/>
        </div>
    </form>
</div>

</body>
</html>




<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title></title>--%>
<%--    <style>--%>
<%--        <%@include file="/WEB-INF/jsp/style/lecturer.css" %>--%>
<%--        <%@include file="/WEB-INF/jsp/style/style.css" %>--%>
<%--    </style>--%>
<%--    <%@include file="/WEB-INF/jsp/header.jsp" %>--%>
<%--</head>--%>
<%--<body>--%>
<%--<header class="header">--%>
<%--    <h1 class="h1">Lecturer Staff</h1>--%>
<%--</header>--%>
<%--<div style="width: 100%">--%>
<%--    <form class="row g-3 form-shadow" method="post">--%>
<%--        <div class="head">--%>
<%--            <h2>${not empty question && not empty question.id?"Edit": "Add"} Question</h2>--%>
<%--        </div>--%>
<%--        <input type="hidden" name="id" value="<c:out value="${question.id}"/>"/>--%>
<%--        <div class="col-md-6">--%>
<%--            <label for="question" class="form-label"></label>--%>
<%--            <input type="text" class="form-control" id="question" name="question" size="45"--%>
<%--                   placeholder="Question..."--%>
<%--                   value="<c:out value="${question.question}"/>"/>--%>
<%--            <p class="error"><c:out value="${errors['question']}"/></p>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <a class="btn-form btn-left pointer" type="submit" href="/">Back</a>--%>
<%--            <input class="editOrAdd btn-left pointer" type="submit" name="questionAddOrEdit"--%>
<%--                   value="${not empty question && not empty question.id?"Edit" : "Add"}"/>--%>
<%--        </div>--%>
<%--    </form>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>





