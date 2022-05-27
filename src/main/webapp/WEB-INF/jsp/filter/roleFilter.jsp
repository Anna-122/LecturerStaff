<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Role</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div>
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Choose your role</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" value="Lecturer" data-bs-dismiss="modal">
                    <a style="color: white; text-decoration: none;" href="/questions">Lecturer</a>
                </button>
                <button type="button" class="btn btn-primary" value="Students" data-bs-dismiss="modal">
                    <a style="color: white; text-decoration: none;"
                       href="/student">Student</a>
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
