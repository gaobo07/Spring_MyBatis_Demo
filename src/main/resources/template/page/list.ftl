<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>${model?uncap_first} list page</title>
        <script>
            function del() { return confirm('REMOVE?'); }
        </script>
    </head>
    <body>
        <h1>${model} List Page</h1>
        <hr/>
        <c:import url="add.jsp"/>
        <hr/>
        <form action="${'$'}{ctx}/${model?lower_case}/fuzzy" method="post">
            <#assign keys = properties?keys>
            <#list keys as key>
            ${key?upper_case} <input name="${key}">
            </#list>
            <input type="submit" value="QUERY">
        </form>
        <hr/>
        <table border="1">
            <tr>
                <th>INDEX</th>
                <th>ID</th>
                <#assign keys = properties?keys>
                <#list keys as key>
                <th>${key?upper_case}</th>
                </#list>
                <th colspan="2">OPERATION</th>
            </tr>
            <c:forEach var="${model?lower_case}" items="${'$'}{sessionScope.list }" varStatus="vs">
            <tr>
                <td>${'$'}{vs.count}</td>
                <td>${'$'}{${model?lower_case}.id}</td>
                <#assign keys = properties?keys>
                <#list keys as key>
                <td>${'$'}{${model?lower_case}.${key}}</td>
                </#list>
                <td><a href="${'$'}{ctx}/${model?lower_case}/search/${'$'}{${model?lower_case}.id}">EDIT</a></td>
                <td><a class="delete" href="${'$'}{ctx }/${model?lower_case}/remove/${'$'}{${model?lower_case}.id}" onclick="return del()">REMOVE</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>