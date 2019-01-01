window.onload = function (ev) {
  // 获取所有订单
  $.post({
      url: "/getAllTransaction",
      dataType: "json",
      success: function (data) {
          console.log(JSON.stringify(data));
          fillPage(data);
      },
      error: function () {
          alert("网络异常");
      }
  });
};

function fillPage(data) {
    var status;
    for (var i = 0; i < data.length; ++i) {
        if (data[i].status == 0) {
            status = "失效";
        } else {
            status = "有效";
        }
        $("#tbody")[0].innerHTML += '<tr>\n' +
            '                        <td>'.concat(data[i].transaction_id).concat('</td>\n' +
            '                        <td>'.concat(data[i].start_time.substr(0, 19)).concat('</td>\n' +
            '                        <td>'.concat(data[i].days).concat('</td>\n' +
            '                        <td>'.concat(data[i].room_id).concat('</td>\n' +
            '                        <td>'.concat(data[i].phone).concat('</td>\n' +
            '                        <td>'.concat(data[i].money).concat('</td>\n' +
            '                        <td>'.concat(status).concat('</td>\n' +
            '                    </tr>')))))));
    }
}