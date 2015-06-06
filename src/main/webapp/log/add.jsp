<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>log add page</title>
    </head>
    <body>
        <h1>Log Add Page</h1>
        <form action="${ctx}/log/add" method="post">
            LOGDATE: <input name="logdate"><br>
            CONTENT: <input name="content"><br>
            <input type="submit" value="ADD">
        </form>
    </body>
</html>