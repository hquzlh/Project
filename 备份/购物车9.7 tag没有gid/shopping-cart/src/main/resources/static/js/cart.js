
$(function () {
        $.ajax({
            url: "/cart/findAll",
            type: "post",
            dataType: "json",
            success: function (data) {
                var str = "";
                var total=0;
                //循环遍历json数组格式的数据
                $.each(data, function (index, item) {
                    total+=item.price*item.num;
                    str +=
                        "<tr><td>"+item.one_tag+"</td>" +
                        "<td>"+item.two_tag+"</td>" +
                        "<td> " + item.name + "</td>" +
                        "<td>" + item.price + "</td>" +
                        "<td>" +"<button class='btn btn-default down' id=down-"+item.gid+"-"+item.id+">-</button><span id=num-"+item.gid+">"+
                        item.num +
                        "</span><button class='btn btn-default up' id=up-"+item.gid+"-"+item.id+">+</button>"+
                        "</td>" +
                        "<td>" + item.price*item.num + "</td>" +
                        "<td><button class='btn btn-sm btn-primary delete' id=delete-"+item.gid+"-"+item.id+">删除商品</button>" +
                        "</td></tr>";
                });
                $("#total").html(total);
                $("#cartlist").html(str);
            }
        })
    $("body").on("click",".down",function () {
        var id=this.id.split("-")[2];
        var gid=this.id.split("-")[1];
        $.ajax({
            url: "/cart/downCart",
            type: "post",
            data: {"id":id,"gid":gid},
            dataType: "json",
            success:function(data){
                window.location.reload();
            }


        });
    })
    $("body").on("click",".up",function () {
        var id=this.id.split("-")[2];
        var gid=this.id.split("-")[1];
        $.ajax({
            url: "/cart/upCart",
            type: "post",
            data: {"id":id,"gid":gid},
            dataType: "json",
            success:function(data){
                var str=JSON.stringify(data);
                if(str==="false"){
                    alert("库存不足");
                }else {
                    window.location.reload();
                }
            }


        });
    })
    $("body").on("click",".delete",function () {
        var id=this.id.split("-")[2];
        var gid=this.id.split("-")[1];
        $.ajax({
            url: "/cart/delete",
            type: "post",
            data: {"id":id,"gid":gid},
            dataType: "json",
            success:function(data){
                window.location.reload();
            }


        });
    })


    $("body").on("click",".buy1",function () {
        var uid=this.id;
            $.ajax({
                url: "/cart/deleteAll-1",
                type: "post",
                data: {"uid":uid},
                dataType: "json",
                success:function(data){
                    window.location.reload();

                }
            });
    })
    $("body").on("click",".buy2",function () {
        var uid=this.id;
        $.ajax({
            url: "/cart/deleteAll-2",
            type: "post",
            dataType: "json",
            success:function(data){
                window.location.reload();

            }
        });
    })
    }
)

