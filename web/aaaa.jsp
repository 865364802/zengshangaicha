<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="qwe" uri="http://java.sun.com/jsp/jstl/hahaha" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <c:forEach var="aa" items="${qwe:sel()}">
       <tr><td rowspan="7">${aa.title}</td></tr>
        <c:forEach items="${aa.jiaoseList}" var="bb">
           <tr><td rowspan="3">${bb.title}</td></tr>
            <c:forEach var="cc" items="${bb.quanXianList}">
                <tr><td>${cc.title}</td></tr>
            </c:forEach>
        </c:forEach>
    </c:forEach>

 <%--<c:forEach items="${yhlist}" var="yhlist">--%>
     <%--<tr>--%>
         <%--<td rowspan="${yhlist.jiaoseList.size()+1}">${yhlist.title}</td>--%>
     <%--</tr>--%>
     <%--<c:forEach items="${yhlist.jiaoseList}" var="jiaoseList">--%>
         <%--<tr>--%>
             <%--<td>${jiaoseList.title}</td>--%>
             <%--<td>--%>
                 <%--<table>--%>
                     <%--<c:forEach items="${jiaoseList.quanXianList}" var="quanXianList">--%>
                         <%--<tr>--%>
                             <%--<td>${quanXianList.title}</td>--%>
                         <%--</tr>--%>
                     <%--</c:forEach>--%>
                 <%--</table>--%>
             <%--</td>--%>
         </tr>
     </c:forEach>
 </c:forEach>



</table>
</body>
</html>