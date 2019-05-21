<%--
  Created by IntelliJ IDEA.
  User: Adsvsd
  Date: 2019/3/12
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function xiugai() {
            document.forms[0].submit();
        }
    </script>
</head>
<body>
    <input type="hidden" name="id" value="${ids.id}">
    <form action="/dingdan?op=xiugai" method="post">
    <table>
        <tr>
            <td><input type="text" name="didian" value="${ids.didian}">地点</td>
            <td><input type="text" name="renwu" value="${ids.renwu}">人物</td>
            <td><input type="text" name="shijian" value="${ids.shijian}">时间</td>
            <td><input type="button" value="修改" onclick="xiugai()"></td>
        </tr>
    </table>
    </form>
</body>
</html>
