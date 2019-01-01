$(document).ready(function() {
    //cookie处理
    var CookieUtil = {

        get: function(name) {
            var cookieName = encodeURIComponent(name) + "=",
                cookieStart = document.cookie.indexOf(cookieName),
                cookieValue = null,
                cookieEnd;

            if (cookieStart > -1) {
                cookieEnd = document.cookie.indexOf(";", cookieStart);
                if (cookieEnd == -1) {
                    cookieEnd = document.cookie.length;
                }
                cookieValue = decodeURIComponent(document.cookie.substring(cookieStart + cookieName.length, cookieEnd));
            }

            return cookieValue;
        },

        set: function(name, value, expires, path, domain, secure) {
            var cookieText = encodeURIComponent(name) + "=" + encodeURIComponent(value);

            if (expires instanceof Date) {
                cookieText += "; expires=" + expires.toGMTString();
            }

            if (path) {
                cookieText += "; path=" + path;
            }

            if (domain) {
                cookieText += "; domain=" + domain;
            }

            if (secure) {
                cookieText += "; secure";
            }

            document.cookie = cookieText;
        },

        unset: function(name, path, domain, secure) {
            this.set(name, "", new Date(0), path, domain, secure);
        }

    };


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

    //从cookie中检查已登录的用户
    // $(function() {
    //     var u_name = CookieUtil.get(userName);
    //     if(u_name != null){
    //         $("#dv1").hidden();
    //         $("dv2").show();
    //         $("#dv2 label").val(u_name);
    //     }
    // });

});