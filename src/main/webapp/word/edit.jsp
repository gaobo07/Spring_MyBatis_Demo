<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>word edit page</title>
    </head>
    <body>
        <h1>Word Edit Page</h1>
        <form action="${ctx}/word/modify" method="post">
            <input type="hidden" name="id" value="${sessionScope.word.id}">
            ENGLISH: <input name="english" value="${sessionScope.word.english}"><br>
            CHINESE: <input name="chinese" value="${sessionScope.word.chinese}"><br>
            PROPERTY: <input name="property" value="${sessionScope.word.property}"><br>
            SENTENCE: <input name="sentence" value="${sessionScope.word.sentence}"><br>
            <input type="submit" value="UPDATE">
        </form>
    </body>
</html>