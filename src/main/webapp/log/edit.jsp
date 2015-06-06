<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>log edit page</title>
    </head>
    <body>
        <h1>Log Edit Page</h1>
        <form action="${ctx}/log/modify" method="post">
            <input type="hidden" name="id" value="${sessionScope.log.id}">
            LOGDATE: <input name="logdate" value="${sessionScope.log.logdate}"><br>
            CONTENT: <input name="content" value="${sessionScope.log.content}"><br>
            USERID: <input name="userId" value="${sessionScope.log.userId}"><br>
            <input type="submit" value="UPDATE">
        </form>
    </body>
</html>