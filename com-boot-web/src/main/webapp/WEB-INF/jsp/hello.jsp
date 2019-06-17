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
    alert("are you ok !!!!")
</script>

</body>
</html>