<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>WebSocket Demo</title>
    <script type="text/javascript" src="jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        var ws = null;
        function startWebSocket() {
            if (!window.WebSocket) alert("this browser not support WebSocket!");
            var websocketLoc = "ws://127.0.0.1:8888/websocket/main.do";
            //create WebSocket
            ws = new WebSocket(websocketLoc);
            ws.onmessage = function(resp) {
                $('#msgBox').append(resp.data);
                $('#msgBox').append('</br>');
            };
        }
    </script>
</head>
<body onload="startWebSocket();">
<div id="msgBox" style="width:400px;height:300px;border:1px solid #000000;margin: 0 auto;background-color: #FFFF00;">
</div>
<div style="text-align: center; margin: 10px;">
    <input type="button" value="btn" class="btn" onclick="javascript: ws.send('go')"/>
</div>
</body>
</html>