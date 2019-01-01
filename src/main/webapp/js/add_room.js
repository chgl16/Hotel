$(function() {
    $("#add_form").ajaxForm(function (data) {
        console.log("获取到后台返回参数: " + data);
        alert("添加成功");
        window.location.reload();
    });
});