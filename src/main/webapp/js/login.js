/**
 * 前端验证没写
 */




// $(function ())是文档document加载完自动调用的函数
$(function () {
    /*
     获取form元素，调用其ajaxForm(...)方法
     内部的function(data)的data就是后台返回的数据
    */
    $("#root-form").ajaxForm(function (data) {
        console.log("获取到后台返回参数: " + data);
        switch (data) {
            case "success":
                alert("登录成功,进入首页..");
                window.location.href = "index.html";
                break;
            case "unregistered":
                alert("尚未注册,请注册");
                window.location.href = "register.html";
                break;
            case "wrong-password":
                alert("密码错误,请重新输入");
                window.location.reload();
                break;
        }

    });
});