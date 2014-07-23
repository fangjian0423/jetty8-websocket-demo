jetty8-websocket-demo
====================

基于jetty8的一个websocket实例。

该实例就是使用线程池处理一些耗时长的任务，使用websocket提高用户体验度。

使用maven构建项目，jetty:run起来之后访问：http://path:port/websocket/index.jsp, 然后点击start task按钮即可看到效果