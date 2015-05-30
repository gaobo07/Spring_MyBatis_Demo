<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>word add page</title>
    </head>
    <body>
        <h1>Word Add Page</h1>
        <form action="${ctx}/word/add" method="post">
            ENGLISH: <input name="english"><br>
            CHINESE: <input name="chinese"><br>
            PROPERTY: <input name="property"><br>
            SENTENCE: <input name="sentence"><br>
            <input type="submit" value="ADD">
        </form>
    </body>
</html>