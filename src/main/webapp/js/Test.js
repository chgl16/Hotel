$(document).ready(function() {
    $('#m').mouseover(function() {
        $(this).css("background", "rgb(255,255,255,.2");
    });

    $('#m').mouseout(function() {
        $(this).css("background", "rgb(255,255,255,0");
    });

    $('#m').click(function(e) {
        $('#menupop').addClass('show');
    });

    $('#main').click(function(e) {
        if (e.clientX > 200) {
            $('#menupop').removeClass('show');
        }
    });

    $('.en').mouseover(function() {
        $(this).css("color", "#000");
    });

    $('.en').mouseout(function() {
        $(this).css("color", "#fff");
    });

    // $('.en').click(function(){
    //     $('#dv1').css("display","none");
    //     $('#dv2').css("display","inline");
    // });

    // $('#logout').click(function(){
    //     $('#dv2').css("display","none");
    //     $('#dv1').css("display","inline");
    // });

    // var name = JSON.parse(data);
    // $('#dv2 label').text(name[0].firstName);
});