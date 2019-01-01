$(document).ready(function() {
    //调整订房日期
    var date = new Date();
    var nowMonth = date.getMonth() + 1;
    var strDate = date.getDate();
    var seperator = "-";
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

        var nowMonth = date.getMonth() + 1;
        var strDate = date.getDate();
        var seperator = "-";
        var nowDate = date.getFullYear() + seperator + nowMonth + seperator + strDate;
        return nowDate;
    }

    function getDays(str1,str2){
        var milosec = parseInt(Date.parse(str2.replace(/-/g, "/"))) - parseInt(Date.parse(str1.replace(/-/g, "/")));
        milosec = milosec/(24 * 60 * 60 * 1000);
        return milosec;
    }

    var room = JSON.parse(data1);
    for(var i=0;i<room.length;i++){
        $('#table-1 tbody').append("<tr><td>"+room[i].roomType+"</td><td>"+room[i].price+"</td><td><input type='button' value='预订' class='bt'></td></tr>");
    }
});