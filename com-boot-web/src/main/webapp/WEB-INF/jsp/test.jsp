<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/12
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp - test</title>
</head>

<script src="/static/js/jquery-3.2.1.js" type="text/javascript"></script>
<script src="/static/js/my.js" type="text/javascript"></script>
<body>
jsp -test

<script>
    x(); // 无效
    /*-----------------------------------------------------------------*/
    var session = '${sessionScope.get("name")}'; // 有效
    console.log(session);
    alert(session);
</script>

</body>
</html>
