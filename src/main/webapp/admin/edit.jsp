<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>admin edit page</title>
    </head>
    <body>
        <h1>Admin Edit Page</h1>
        <form action="${ctx}/admin/modify" method="post">
            <input type="hidden" name="id" value="${sessionScope.admin.id}">
            USERNAME: <input name="username" value="${sessionScope.admin.username}"><br>
            PASSWORD: <input name="password" value="${sessionScope.admin.password}"><br>
            NAME: <input name="name" value="${sessionScope.admin.name}"><br/>
            TEAM: <select name="team">
            <option value="第一组" <c:if test="${sessionScope.admin.team eq '第一组'}"> selected="selected" </c:if>>第一组
            <option value="第二组" <c:if test="${sessionScope.admin.team eq '第二组'}"> selected="selected" </c:if>>第二组
            <option value="第三组" <c:if test="${sessionScope.admin.team eq '第三组'}"> selected="selected" </c:if>>第三组
            </select><br/>
            ROLE: <select name="role">
            <option value="员工" <c:if test="${sessionScope.admin.role eq '员工'}"> selected="selected" </c:if>>员工
            <option value="组长" <c:if test="${sessionScope.admin.role eq '组长'}"> selected="selected" </c:if>>组长
            </select><br/>
            <input type="submit" value="UPDATE">
        </form>
    </body>
</html>