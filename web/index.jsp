<%--
  Created by IntelliJ IDEA.
  User: Adsvsd
  Date: 2019/3/6
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
  <head>
    <title>$Title$</title>
    <script>
        function spchaxun(){
            location="/shangpin?op=chaxun";
        }
        function yhchaxun(){
            location="/yonghu?op=chaxun";
        }
    </script>
  </head>
  <body>
  <span onclick="spchaxun()">商品查询</span>
  <span onclick="yhchaxun()">用户查询</span>
  </body>
</html>
