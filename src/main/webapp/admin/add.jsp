<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>admin add page</title>
    </head>
    <body>
        <h1>Admin Add Page</h1>
        <form action="${ctx}/admin/add" method="post">
            USERNAME: <input name="username"><br>
            PASSWORD: <input name="password" type="password"><br>
            NAME: <input name="name"><br/>
            TEAM: <select name="team">
            <option value="第一组">第一组
            <option value="第二组">第二组
            <option value="第三组">第三组
            </select><br/>
            ROLE: <select name="role">
            <option value="员工">员工
            <option value="组长">组长
            </select><br/>
            <input type="submit" value="ADD">
        </form>
    </body>
</html>