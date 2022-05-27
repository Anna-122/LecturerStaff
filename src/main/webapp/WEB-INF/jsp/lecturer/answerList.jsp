<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Lecturer Application</title>
    <style>
        <%@include file="/WEB-INF/jsp/style/answer.css" %>
        <%@include file="/WEB-INF/jsp/style/style.css" %>
    </style>
</head>
<body>
<header class="header">
    <h1 class="h1">Lecturer Staff</h1>
</header>

<input type="hidden" name="questionId" <c:out value="${question.id}"/>/>
<h1 style="text-align: center">Lecturer Management</h1>
<div>
    <table id="centre">
        <caption class="h2-tag">List of Answers</caption>
        <tr class="border">
            <th class="border name"> Option Answer</th>
            <th class="border name">Answer</th>
            <th class="border">Actions</th>
        </tr>

        <c:forEach var="answer" items="${answers}">
            <tr>
                <td class="border"><c:out value="${answer.answer}"/></td>
                <td class="border"><c:out value="${answer.answerBoolean}"/></td>

                <td class="border">
                    <a class="btn-form"
                       href="${pageContext.request.contextPath}/answer/delete?id=${answer.id}&questionId=${questionId}">Delete</a>
                    <a class="btn-form"
                       href="${pageContext.request.contextPath}/answer/edit?id=${answer.id}&questionId=${questionId}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="btn-block">
        <a class="answer-btn pointer"
           href="${pageContext.request.contextPath}/answer/form?questionId=${questionId}">Create</a>
        <a class="answer-btn pointer" type="submit" href="/questions">Back</a>
    </div>
</div>
</body>
</html>



