window.onload = function (ev) {
    var phone= localStorage.getItem("phone");
    if (phone == null || phone == "") {
        alert("抱歉，您尚未登录．．");
        window.location.href = "member_log.html";
    } else {
        // 用户已经登录, 隐藏登录框
        $('#dv1')[0].style.visibility='hidden';

        // 请求该用户所有订单
        $.post({
            url: "/getAllTransactionByPhone",
            dataType: "json",
            data: {"phone": phone},
            success: function (data) {
                console.log(JSON.stringify(data));
                fillData(data);
            },
            error: function () {
                alert("网络异常");
            }
        });
    }
};

/**
 * 填充动态数据
 *
 * @param data
 */
function fillData(data) {
    var status;
    for (var i = 0; i < data.length; ++i) {
        if (data[i].status == 1) {
            status = "有效";
        } else {
            status = "已失效";
        }
        $("#tbody")[0].innerHTML += '<tr>\n' +
            '                            <td>'.concat(data[i].transaction_id).concat('</td>\n' +
                '                            <td>'.concat(data[i].room_id).concat('</td>\n' +
                    '                            <td>'.concat(data[i].start_time.substr(0, 19)).concat('</td>\n' +
                        '                        <td>'.concat(data[i].end_time.substr(0, 19)).concat('</td>\n' +
                            '                            <td>'.concat(data[i].money).concat('</td>\n' +
                                '                            <td>'.concat(data[i].phone).concat('</td>\n' +
                                    '                            <td>'.concat(status).concat('</td>\n' +
                                        '                        </tr>')))))));

    }
}
