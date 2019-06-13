<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<h2>${quiz.getTitle()}</h2>

<form action="/result?quizId=${quiz.getId()}" method="post">
    <c:forEach items="${quiz.getQuestions()}" var="question">
        <h3>${question.getContent()}</h3>

        <%--Tworzymy listę odpowiedzi, aby móc je losowo rozstawić na radio buttonach--%>
        <c:set scope="request" var="answers" value="${[question.getAnswer1(), question.getAnswer2(),
    question.getAnswer3(), question.getCorrectAnswer()]}"/>

        <%--Mieszamy elementy w liście losowo--%>
        <%Collections.shuffle((List<?>) request.getAttribute("answers"));%>

        <c:forEach var="answer" items="${answers}">
            <input required type="radio" id="${question.getId()}" name="${question.getId()}"
                   value="${answer}"/>${answer}
        </c:forEach>
    </c:forEach>

    <br>

    <input type="submit" value="Finish"/>
</form>


</body>
