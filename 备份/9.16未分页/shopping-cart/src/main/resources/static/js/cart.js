
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
                    str +="<tr><td><input type='checkbox' class='carts' id='"+item.num+"-"+item.price+"' name='carts' value="+item.gid+"></td>"+
                        "<td>"+item.tags+"</td>" +
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

        var chk =[];//定义一个数组
        $('input[name="carts"]:checked').each(function(){//遍历每一个名字为nodes的复选框，其中选中的执行函数
            chk.push($(this).val());//将选中的值添加到数组chk中
        });
        var groups = chk.join(",");

            $.ajax({
                url: "/order/insert",
                type: "post",
                data: {"chk":chk},
                dataType: "json",
                success:function(data){

                    var str=JSON.stringify(data);

                    if(str==="true"){
                        alert("购物成功，自动前往订单页面");
                        window.location.href = 'http://localhost:8080/order.html';

                    }else if(str==="false") {
                        alert("当前账户余额不足，自动前往充值页面");
                        window.location.href = 'http://localhost:8080/deposit.html';

                    }
                },
                error:function (result) {

                    var str=JSON.stringify(result);


                    alert(str.split(",")[1].split(":")[1].replace("\"","").replace("\"",""))

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
    });

    $("body").on("click",".all",function () {
        var choice=document.getElementsByName("carts");
        for(var i=0;i<choice.length;i++){
            choice[i].checked=this.checked;
        }
        var allprice=0;//总价格
        var allnum=0;//总数量
        $('input[name="carts"]:checked').each(function(){//遍历每一个名字为nodes的复选框，其中选中的执行函数
            var num=this.id.split("-")[0];//单个商品的购买数量
            var price=this.id.split("-")[1];//商品单价需要从后台获取
            allprice+=num*price;//每样商品的总价//将选中的值添加到数组chk中
        });
        $("#total").html(allprice);
    })
    $("body").on("click",".carts",function () {
        var allprice=0;//总价格
        var allnum=0;//总数量
        $('input[name="carts"]:checked').each(function(){//遍历复选框，其中选中的执行函数
            var num=this.id.split("-")[0];//单个商品的购买数量
            var price=this.id.split("-")[1];//商品单价需要从后台获取
            allprice+=num*price;//每样商品的总价//将选中的值添加到数组chk中
            allnum+=1;
        });
        var size=0;
        //遍历复选框，其中选中的执行函数
        $('input[name="carts"]').each(function(){
            size+=1;
        });
        if(size===allnum && size!==0){

            $('.all').attr('checked','true');
        }
        $("#total").html(allprice);
    })



    })
//计算总价


