<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <table border="1">
            <c:forEach items="${cglist}" var="cglist">
                <tr>
                    <td rowspan="${cglist.changDiList.size()+1}"><input type="checkbox" value="${cglist.id}"></td>
                    <td rowspan="${cglist.changDiList.size()+1}">${cglist.title}</td>
                </tr>
                <c:forEach items="${cglist.changDiList}" var="cglist">
                    <tr>
                        <td>${cglist.title}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>

    </body>

</html>

