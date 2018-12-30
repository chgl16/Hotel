function check_login() {
    // $.ajax({
    //     type: "post",
    //     url: "",
    //     data: {
    //         uname: $("#uname").val(),
    //         upwd: $("#upwd").val()
    //     },
    //     success:function(data) {
    //         if (data == "登陆成功") {
    //             //建立用户名cookie
    //             // CookieUtil.set("userName",$("#uname").val(),null,"");
    //             window.location.href = "../html/index.html";
    //         } else {
    //             $("#login_form").removeClass('shake_effect');
    //             setTimeout(function() {
    //                 $("#login_form").addClass('shake_effect')
    //             }, 1);
    //         }
    //     }
    // });
    var name = $("#l_uname").val();
    var pwd = $("#l_upwd").val();
    if (name == null || pwd == null || name == "" || pwd == "") {
        $("#login_form").removeClass('shake_effect');
        setTimeout(function() {
            $("#login_form").addClass('shake_effect')
        }, 1);
        alert("登陆失败");
    }
}

function check_register() {
    var name = $("#r_uname").val();
    var pwd = $("#r_upwd").val();
    var sure = $("#r_sure").val();
    var phone = $("#r_phone").val();
    var identity = $("#r_identity").val();
    if(name == "" || pwd == "" || sure == "" || phone == "" || identity == ""){
        $("#login_form").removeClass('shake_effect');
        setTimeout(function() {
            $("#login_form").addClass('shake_effect')
        }, 1);
        alert("所有项不能为空");
        return false;
    }
    if (pwd != sure) {
        $('#r_upwd').val("");
        $('#r_sure').val("");
        $('#r_sure').attr('placeholder',"输入密码不一致");
        return false;
    }
    alert("注册成功");
    // window.location.href = "";
    return true;
    // var name = $("#r_user_name").val();
    // var pass = $("#r_password").val();
    // var phone = $("#r_phone").val();
    // var identity = $("#r_identity").val();
    // if (name == "" || pass == "" || phone == "" || identity =="") {
    //     alert("不能为空");
    //     $("#login_form").removeClass('shake_effect');
    //     setTimeout(function() {
    //         $("#login_form").addClass('shake_effect');
    //     }, 1);
    // } else {
    //     $.ajax({
    //         type:"post",
    //         url:"",
    //         data:{
    //             r_uname:name,
    //             r_upwd:pass,
    //             r_phone:phone,
    //             r_identity:identity
    //         },
    //         success:function(data){
    //             if(data == "注册成功"){
    //                 window.location.href = "../html/member_log.html";
    //             }
    //             else{
    //                 alert("注册失败");
    //                 $("#r_user_name").val("");
    //                 $("#r_sure").val("");
    //                 $("#r_password").val("");
    //                 $("#r_phone").val("");
    //                 $("#r_identity").val("");
    //             }
    //         }
    //     });
    // }
}


$(function() {
    // $("#create").click(function() {
    //     check_register();
    //     return false;
    // });
    // $("#login").click(function() {
    //     check_login();
    //     return false;
    // });
    $('.message a').click(function() {
        $('form').animate({
            height: 'toggle',
            opacity: 'toggle'
        }, 'slow');
    });

    /*
     获取form元素，调用其ajaxForm(...)方法
     内部的function(data)的data就是后台返回的数据
    */
    $("#login-form").ajaxForm(function (data) {
        console.log("获取到后台返回参数: " + data);
        switch (data) {
            case "success":
                alert("登录成功,进入首页..");
                window.location.href = "index.html";
                break;
            case "unregistered":
                alert("尚未注册,请注册");
                // window.location.href = "register.html";
                break;
            case "wrong-password":
                alert("密码错误,请重新输入");
                window.location.reload();
                break;
        }
    });

    $("#register-form").ajaxForm(function (data) {
            console.log("获取到后台返回参数: " + data);
            if (data == "false") {
                alert("注册失败，用户已注册");
                window.location.href = "member_log.html";
            } else {
                alert("注册成功，进入首页..");
                window.location.href = "index.html";
            }
        }
    );
});