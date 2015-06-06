<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>log list page</title>
        <script>
            function del() { return confirm('REMOVE?'); }
        </script>
    </head>
    <body>
        <h1>Log List Page</h1>
        <hr/>
        <c:import url="add.jsp"/>
        <hr/>
        <table border="1">
            <tr>
                <th>INDEX</th>
                <th>LOGDATE</th>
                <th>CONTENT</th>
                <th>USER</th>
            </tr>
            <c:forEach var="log" items="${sessionScope.pagination.list }" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${log.logdate}</td>
                <td>${log.content}</td>
                <td>${log.userId}</td>
            </tr>
            </c:forEach>
        </table>
        <c:import url="${ctx}/commons/page.jsp">
            <c:param name="path" value="log/${sessionScope.pagination.selectId}"/>
        </c:import>
    </body>
</html>