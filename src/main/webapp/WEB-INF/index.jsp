<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Wybierz quiz:</h1>
<c:forEach items="${quizList}" var="quiz">
    <a href="/solveQuiz?id=${quiz.getId()}">${quiz.getTitle()}</a><br>
</c:forEach>
</body>
