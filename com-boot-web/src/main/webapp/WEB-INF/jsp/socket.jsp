<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>socket</title>
</head>
<body>
    <script>
        if (window.WebSocket){
            var socket = new WebSocket("ws://localhost:8087/ws");
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