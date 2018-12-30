<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css"/>
    <style>
        .div1{
            padding-top: 10%;
            margin:0px auto;
            width:500px; /* 必须制定宽度 */
        }
        .bg{
            min-width: 900px;
            background-image: url("images/img_7.jpg");
            background-repeat: no-repeat;
            background-attachment: fixed;
            /*background-position: center center;*/
            background-size: cover;
        }
        /*button*/
        .butn {
            background: #3498db;
            background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
            background-image: -moz-linear-gradient(top, #3498db, #2980b9);
            background-image: -ms-linear-gradient(top, #3498db, #2980b9);
            background-image: -o-linear-gradient(top, #3498db, #2980b9);
            background-image: linear-gradient(to bottom, #3498db, #2980b9);
            -webkit-border-radius: 28;
            -moz-border-radius: 28;
            border-radius: 28px;
            font-family: Arial;
            color: #ffffff;
            font-size: 19px;
            padding: 11px 150px 10px 150px;
            text-decoration: none;
        }

        .butn:hover {
            background: #4e6e82;
            background-image: -webkit-linear-gradient(top, #4e6e82, #3498db);
            background-image: -moz-linear-gradient(top, #4e6e82, #3498db);
            background-image: -ms-linear-gradient(top, #4e6e82, #3498db);
            background-image: -o-linear-gradient(top, #4e6e82, #3498db);
            background-image: linear-gradient(to bottom, #4e6e82, #3498db);
            text-decoration: none;
        }
    </style>
</head>
<body class="bg">
    <div class="div1">
        <a href="html/index.html" class="butn">进入系统</a>
    </div>
</body>
</html>
