<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>hello</title>
</head>
<script src="/static/jquery-3.2.1.js" type="text/javascript"></script>
<body>
<span th:text="${request.getAttribute('hello')}"></span>
<h1>world !!!</h1>
<script>

    var flag = "${requestScope.get("flag")}";
    console.log("flag=="+flag);
    {
        var v = "xu";
        console.log(typeof (v));
        var v2;
        console.log(v2); // undefined
        var nan = 10/0;
        console.log("nan ="+nan);
        console.log("nan ="+isNaN(nan));
    }

</script>

</body>
</html>