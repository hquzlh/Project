$(function () {
    $.ajax({
        url: "/user/getName",
        type: "post",
        dataType: "json",
        success: function (data) {
            var str = "账户:"+data;
            $("#myname").html(str);
        }
    })
    $.ajax({
        url: "/user/getMoney",
        type: "post",
        dataType: "json",
        success: function (data) {
            var str = "余额"+data;
            $("#mymoney").html(str);
        }
    })
    $("body").on("click","#logout",function () {
        $.ajax({
            url: "/user/logout",
            type: "post",
            dataType: "json",
            success:function(data){
                alert(data)
                window.location.reload();
            }
        });
    })

})