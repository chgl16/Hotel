window.onload = function (ev) {
	var phone= localStorage.getItem("phone");
	if (phone == null || phone == "") {
		alert("抱歉，您尚未登录．．");
		window.location.href = "member_log.html";
	} else {
		// 用户已经登录, 隐藏登录框
		$('#dv1')[0].style.visibility='hidden';

		// 请求该用户订单
		$.post({
			url: "/getValidTransactionByPhone",
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
    for (var i = 0; i < data.length; ++i) {
        $("#tbody")[0].innerHTML += '<tr>\n' +
            '                            <td>'.concat(data[i].transaction_id).concat('</td>\n' +
            '                            <td>'.concat(data[i].room_id).concat('</td>\n' +
            '                            <td>'.concat(data[i].start_time.substr(0, 19)).concat('</td>\n' +
				'                        <td>'.concat(data[i].end_time.substr(0, 19)).concat('</td>\n' +
            '                            <td>'.concat(data[i].money).concat('</td>\n' +
            '                            <td>'.concat(data[i].phone).concat('</td>\n' +
            '                            <td><button onclick="unsubscribe('.concat(data[i].id).concat(')">退订</button></td>\n' +
            '                        </tr>')))))));

    }
}

/**
 * 退订
 * @param id
 */
function unsubscribe(id) {
	console.log("退订单号序号: " + id);
	var flag = confirm("您确认退订吗？");
	if (flag ==  true) {
		$.post({
			url: "/updateTransactionStatus",
			dataType: "json",
			data: {"id": id},
			success: function (data) {
                alert("退订成功！");
                window.location.reload();
            },
			error: function () {
				alert("网络异常");
            }
		});
	}
}