<%--
  Created by IntelliJ IDEA.
  User: Adsvsd
  Date: 2019/3/12
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script>
        function totianjia() {
            location="/tianjia.jsp";
        }
        function toxiugai() {
            document.forms[0].submit();
        }
        function shanchu() {
            document.forms[0].action="/dingdan?op=shanchu";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
    <form action="/dingdan?op=quzhi" method="post">
    <table>
        <tr>
            <td><input type="checkbox"></td>
            <td>地点</td>
            <td>人物</td>
            <td>时间</td>
        </tr>
        <c:forEach items="${chaxun}" var="chaxun">
            <tr>
                <td><input type="checkbox" name="ids" value="${chaxun.id}"></td>
                <td>${chaxun.didian}</td>
                <td>${chaxun.renwu}</td>
                <td>${chaxun.shijian}</td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <td><input type="button" value="去添加" onclick="totianjia"></td>
            <td><input type="button" value="去修改" onclick="toxiugai"></td>
            <td><input type="button" value="删除" onclick="shanchu"></td>
        </tr>
    </table>
    </form>
</body>
</html>
