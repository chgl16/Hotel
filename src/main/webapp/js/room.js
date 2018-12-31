window.onload = function (ev) {
  $.get({
      url: "/getAllRoom",
      dataType: "json",
      success: function (data) {
          console.log(JSON.stringify(data));
          fillPage(data);
      },
      error: function () {
          alert("网络错误");
      }
  });
};

function fillPage(data) {
    var status;
    for (var i = 0; i < data.length; ++i) {
        if (data[i].status == 0) {
            status = "可定";
        } else {
            status = "有客";
        }
        $("#tbody")[0].innerHTML += ' <tr>\n' +
            '                            <td>'.concat(data[i].id).concat('</td>\n' +
            '                            <td>'.concat(data[i].type).concat('</td>\n' +
            '                            <td>'.concat(data[i].price).concat('</td>\n' +
            '                            <td>'.concat(status).concat('</td>\n' +
            '                            <td><button onclick="reverseStatus('.concat(data[i].id).concat(')">状态取反</button></td>\n' +
            '                        </tr>')))));
    }
}

function reverseStatus(id) {
    var flag = confirm("确定将房间".concat(id).concat("状态取反"));
    if (flag == true) {
        $.post({
            url: "/reverseRoomStatus",
            data: {"id": id},
            dataType: "json",
            success: function (data) {
                alert("修改成功");
                window.location.reload();
            },
            error: function () {
                alert("网络异常");
            }
        });
    }
}