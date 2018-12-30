$(document).ready(function() {
    $(".changed").click(function() {
        console.log($(this).prev().val());
    });
    $('#changed_submit').click(function() {
        var name = $("#m_uname").val();
        var pwd = $("#m_upwd").val();
        var newword = $("#m_newword").val();
        var repeat = $("#m_repeat").val();
        var phone = $("#m_phone").val();
        var identity = $("#m_identity").val();
        if (name == "" && pwd == "" && phone == "" && identity == "") {
            alert("至少输入要修改的项或者原密码");
            return false;
        }
        if (newword != repeat) {
            $('#m_upwd').val("");
            $('#m_repeat').val("");
            $('#m_repeat').attr('placeholder', "输入密码不一致");
            return false;
        }
        alert("修改成功");
    });

});