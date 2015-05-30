<%@ page pageEncoding="UTF-8" %>
<%@ include file="inc.jsp" %>
<script src="${ctx}/static/js/jquery-1.11.2.min.js"></script>
<script>
    $(function () {
        var form = $('#form');
        $('#submit').click(function () {
            form.attr('action', form.attr('action') + $('#page').val());
            form.submit();
        });
    });
</script>
<p>共 ${sessionScope.pagination.totalRows} 条记录，共 ${sessionScope.pagination.totalPages} 页，当前第 ${sessionScope.pagination.currentPage} 页</p>
<c:choose>
    <c:when test="${sessionScope.pagination.currentPage eq 1}">
        首页
        上一页
    </c:when>
    <c:otherwise>
        <a href="${ctx}/${param.path}/1">首页</a>
        <a href="${ctx}/${param.path}/${sessionScope.pagination.currentPage-1}">上一页</a>
    </c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${sessionScope.pagination.currentPage eq sessionScope.pagination.totalPages || sessionScope.pagination.totalPages eq 0}">
        下一页
        尾页
    </c:when>
    <c:otherwise>
        <a href="${ctx}/${param.path}/${sessionScope.pagination.currentPage+1}">下一页</a>
        <a href="${ctx}/${param.path}/${sessionScope.pagination.totalPages}">尾页</a>
    </c:otherwise>
</c:choose>
<form id="form" action="${ctx}/${param.path}/" method="post">
    跳到第
    <select id="page">
        <c:forEach var="i" begin="1" end="${sessionScope.pagination.totalPages}">
        <option value="${i}">${i}
        </c:forEach>
    </select>
    页
    <a id="submit" href="#">GO</a>
</form>
<%--
<c:import url="${ctx}/commons/page.jsp">
    <c:param name="path" value="word/${sessionScope.pagination.selectId}"/>
</c:import>
--%>
