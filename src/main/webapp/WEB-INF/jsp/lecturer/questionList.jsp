<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title> Quiz Application</title>
    <style>
        <%@include file="/WEB-INF/jsp/style/lecturer.css" %>
        <%@include file="/WEB-INF/jsp/style/style.css"%>
    </style>
</head>
<body>

<header class="header">
    <h1 class="h1">Lecturer Staff</h1>
</header>

<h1 style="text-align: center">Lecturer Management</h1>
<div>
    <table id="centre">
        <caption class="h2-tag">List of Questions</caption>
        <tr>
            <th class="border name">Name</th>
            <th class="border">Actions</th>
        </tr>
        <c:forEach var="question" items="${questions}">
            <tr>
                <td class="border"><c:out value="${question.question}"/></td>
                <td class="border">
                    <a class="btn-form btn-create" href="/question/edit?id=${question.id}">Edit</a>
                    <form class="form form-container" method="post"
                          action="${pageContext.request.contextPath}/question/delete">
                        <a class="btn-form btn-create"
                           href="${pageContext.request.contextPath}/question/delete?id=${question.id}">Delete</a>
                    </form>
                    <a class="btn-form btn-create"
                       href="${pageContext.request.contextPath}/question/answers?id=${question.id}">Answers</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="create-block">
        <a class="btn-form btn-create create" href="/question/form">Create</a>
    </div>
</div>
</body>
</html>
