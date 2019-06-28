<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>socket</title>
</head>
<body>
    <script>

        if (window.WebSocket){
            var socket = new WebSocket("ws://localhost:8086/ws");
            socket.onopen = function () {
                socket.send("....send..");
            };
            socket.onmessage = function (ev) {
                var data = ev.data;
                console.log(data)
            };
            socket.onclose = function () {
                alert("close")
            }
        }
    </script>
</body>
</html>