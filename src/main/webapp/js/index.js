window.onload = function (ev) {
    if (localStorage.getItem("phone") != null && localStorage.getItem("phone") != "") {
        // 用户已经登录, 隐藏登录框
        $('#dv1')[0].style.visibility='hidden';
    } else {
        $('#dv1')[0].style.visibility='visible';
    }

    // 获取可选房间
    $.get({
        url: "/getFreeRoom",
        dataType: "json",
        success: function (data) {
            console.log(JSON.stringify(data));
            fillTable(data);
        },
        error: function () {
            alert("网络异常");
        }
    });
}

function fillTable(data) {
    for (var i = 0; i < data.length; ++i) {
        $("#tbody")[0].innerHTML += '<tr>\n' +
            '                           <td>'.concat(data[i].id).concat('</td>\n' +
            '                           <td>'.concat(data[i].type).concat('</td>\n' +
            '                           <td>'.concat(data[i].price).concat('</td>\n' +
            '                           <td><button onclick="book('.concat(data[i].id).concat(', '.concat(data[i].price).concat(')">预订</button></td>\n' +
            '                       </tr>')))));
    }
}


function book(id, price) {
    console.log("预订房号:" + id);
    // if (localStorage.getItem("phone") == null || localStorage.getItem("phone") == "") {
    //     console.log("未登录的游客");
        $("#room-id")[0].innerHTML = id;
        $("#price")[0].innerHTML = price;
        $(".book_detail")[0].style.visibility = 'visible';
    // } else {
    //     // 登录的会员
    // }
}

// 测试弹窗显示房间类型图片
$(".test-popup-link").magnificPopup({
    type: 'image'
});

$("#concel")[0].onclick = function (ev) {
    $(".book_detail")[0].style.visibility = 'hidden';
};

/**
 * 游客确认订单
 * @param ev
 */
$("#comfirm-book")[0].onclick = function (ev) {
    var room_id = $("#room-id")[0].innerHTML;
    var price = $("#price")[0].innerHTML;
    var days = $('input[name="days"]')[0].value;
    var money = price * days;
    var phone = $('input[name="phone"]')[0].value;
    var identity = $('input[name="identity"]')[0].value;

    console.log(room_id + ", " + price + ", " + days);

    $.post({
        url: "/book",
        dataType: "json",
        data: {"room_id": room_id, "days": days, "money": money, "phone": phone, "identity": identity},
        success: function (data) {
            alert("成功预订");
            window.location.reload();
            // $(".book_detail")[0].style.visibility = 'hidden';
        },
        error: function () {
            alert("网络异常")
        }
    });
}

