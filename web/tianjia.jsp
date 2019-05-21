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
        function tianjia() {
            document.forms[0].submit();
        }
    </script>
</head>
<body>
    <form action="/dingdan?op=tianjia" method="post">
    <table>
        <tr>
            <td><input type="text" name="didian">地点</td>
            <td><input type="text" name="renwu">人物</td>
            <td><input type="text" name="shijian">时间</td>
            <td><input type="button" value="添加" onclick="tianjia()"></td>
        </tr>
    </table>
    </form>
</body>
</html>
