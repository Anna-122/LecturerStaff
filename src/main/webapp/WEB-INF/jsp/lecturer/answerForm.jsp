<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <style>
        <%@include file="/WEB-INF/jsp/style/answer.css" %>
        <%@include file="/WEB-INF/jsp/style/style.css"%>
    </style>
    <%@include file="/WEB-INF/jsp/header.jsp" %>
</head>
<body class="bg-light bg-gradient">
<header class="header">
    <h1 class="h1">Lecturer Staff</h1>
</header>

<div style="width: 100%">
    <form class="row g-3 form-shadow" method="post">
        <div class="head">
            <h2>${not empty answer && not empty answer.id?"Edit": "Add"} Answer</h2>
        </div>
        <input type="hidden" name="id" value="<c:out value="${answer.id}"/>"/>
        <input type="hidden" name="questionId" value="<c:out value="${questionId}"/>"/>
        <div style="width: 700px; height: 300px">
            <div class="col-md-12">
                <label for="inputAnswer" class="form-label">Answer</label>
                <input type="text" class="form-control" id="inputAnswer" name="answer" size="45"
                       placeholder="Your answer..."
                       value="<c:out value="${answer.answer}"/>"/>
                <p class="error"><c:out value="${errors['answer']}"/></p>
            </div>

            <div style="margin-top: 20px" class="col-md-12">
                <label for="inputQuestion" class="form-label">Question</label>
                <select id="inputQuestion" name="questions" class="form-select">
                    <c:forEach items="${questions}" var="question">
                        <option name="option" value="${question.id}" ${question.id == questionId ? 'selected' : ''}>
                            <c:out value="${question.question}"/>
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div style="margin-top: 20px" class="col-md-12">
                <div class="form-check">
                    <input class="form-check-input"
                           type="radio"
                           name="radioAnswer"
                           value="true"
                           id="flexRadioDefault1"${answer.answerBoolean == true ? 'checked' : ''}>
                    <label class="form-check-label" for="flexRadioDefault1">
                        True
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input"
                           type="radio"
                           name="radioAnswer"
                           value="false"
                           id="flexRadioDefault2" ${answer.answerBoolean == false ? 'checked' : ''}>
                    <label class="form-check-label" for="flexRadioDefault2">
                        False
                    </label>
                </div>
            </div>
            <a style="margin-top: 10px" class="btn-form btn-left pointer" type="submit" href="/questions">Back</a>
            <input style="margin-top: 10px" class="editOrAdd btn-left pointer" type="submit" name="answerAddOrEdit"
                   value="${not empty answer && not empty answer.id?"Edit": "Add"}"/>
        </div>
    </form>
</div>
</body>
</html>
