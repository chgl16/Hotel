$(document).ready(function() {
    // 获取当前日期
    var date = new Date();
    // 获取当前月份
    var nowMonth = date.getMonth() + 1;

    // 获取当前是几号
    var strDate = date.getDate();

    // 添加分隔符“-”
    var seperator = "-";

    // 最后拼接字符串，得到一个格式为(yyyy-MM-dd)的日期
    var nowDate = date.getFullYear() + seperator + nowMonth + seperator + strDate;

    $("#start_date").attr("min", nowDate);
    $("#start_date").attr("value", nowDate);

    $('#end_date').attr("min", getNextDay(nowDate));
    // $('#end_date').attr("value", getNextDay(nowDate));

    console.log(getDays($("#start_date").val(),$("#end_date").val()));

    $('#start_date').change(function() {
        $('#end_date').attr("min", getNextDay($("#start_date").val()));
        $('#label1').text("");
        $('#label1').append("您选择了"+getDays($("#start_date").val(),$("#end_date").val())+"天");
        console.log(getDays($("#start_date").val(),$("#end_date").val()));
    });

    $('#end_date').change(function() {
        $('#start_date').attr("max", getPreviousDay($("#end_date").val()));
        $('#label1').text("");
        $('#label1').append("您选择了"+getDays($("#start_date").val(),$("#end_date").val())+"天");
        console.log(getDays($("#start_date").val(),$("#end_date").val()));
    });

    function getNextDay(str) {
        var str1 = parseInt(Date.parse(str.replace(/-/g, "/"))) + 24 * 60 * 60 * 1000;
        return getFormatDate(new Date(str1));
    }

    function getPreviousDay(str) {
        var str1 = parseInt(Date.parse(str.replace(/-/g, "/"))) - 24 * 60 * 60 * 1000;
        return getFormatDate(new Date(str1));
    }

    function getFormatDate(date) {
        // 获取当前月份
        var nowMonth = date.getMonth() + 1;

        // 获取当前是几号
        var strDate = date.getDate();

        // 添加分隔符“-”
        var seperator = "-";

        // 最后拼接字符串，得到一个格式为(yyyy-MM-dd)的日期
        var nowDate = date.getFullYear() + seperator + nowMonth + seperator + strDate;

        return nowDate;
    }

    function getDays(str1,str2){
        var milosec = parseInt(Date.parse(str2.replace(/-/g, "/"))) - parseInt(Date.parse(str1.replace(/-/g, "/")));
        milosec = milosec/(24 * 60 * 60 * 1000);
        return milosec;
    }
});