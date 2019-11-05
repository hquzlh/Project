
$(function () {
        $.ajax({
            url: "/good/findAll",
            type: "post",
            dataType: "json",
            success: function (data) {
                var str = "";
                var tags= "";
                //循环遍历json数组格式的数据
                $.each(data, function (index, item) {

                    str +=
                        "<tr><td>"+item.tags+"</td>" +
                        "<td><img   alt='"+item.name+"' class=\"img-rounded\" src='"+item.img_uri+"'width=66 height=66></td>" +
                        "<td>" + item.name + "</td>" +
                        "<td>" + item.price + "</td>" +
                        "<td>" + item.num + "</td>" +
                        "<td><button class='btn btn-sm btn-primary insert' id=insert-" + item.gid + ">加入购物车</button>" +
                        "</td><td><form action='/cart/addMore'><input type=text placeholder='数量' name=num class=form-control id=inserts-" + item.gid + ">" +
                        "<input type='hidden' name=gid  value="+item.gid+"><button type='submit'  class='btn btn-default addmore' >添加</button></form>"+
                        "</td></tr>";
                });
                $("#goodlist").html(str);
            }
        })
        $("body").on("click",".insert",function () {
            var gid=this.id.split("-")[1];
            $.ajax({
                url: "/cart/insert",
                type: "post",
                data: {"gid":gid},
                dataType: "json",
                success:function(data){
                    var str=JSON.stringify(data)
                    if(str==='false'){
                        alert("抱歉库存不足");
                    }else {
                        window.location.reload();
                    }
                }
            });
        })
        $("body").on("click",".addmore",function () {
            var gid=this.id.split("-")[1];
            var num=document.getElementById("gid").value;
            $.ajax({
                url: "/cart/checkNum",
                type: "post",
                data: {"gid":gid,"num":num},
                dataType: "json",
                success:function(data){
                    var str=JSON.stringify(data)
                    if(str==='false'){
                        alert("抱歉库存不足");
                    }else {
                        window.location.reload();
                    }
                }
            });
        })
        $("#search").keyup(function(){

            if(event.keyCode == 13){
                var str=$("#search").val()
                $.ajax({
                    url: "/good/findByN",
                    type: "post",
                    data: {"name":str},
                    dataType: "json",
                    success: function (data) {
                        var str = "";
                        //循环遍历json数组格式的数据
                        $.each(data, function (index, item) {
                            str +=
                                "<tr><td>"+item.one_tag+"</td>" +
                                "<td>"+item.two_tag+"</td>" +
                                "<td><img   alt='"+item.name+"' class=\"img-rounded\" src='"+item.img_uri+"'width=66 height=66></td>" +
                                "<td>" + item.name + "</td>" +
                                "<td>" + item.price + "</td>" +
                                "<td>" + item.num + "</td>" +
                                "<td><button class='btn btn-sm btn-primary insert' id=insert-" + item.gid + ">加入购物车</button>" +
                                "</td><td><form action='/cart/addMore'><input type=text placeholder='数量' name=num class='form-control in' id=inserts-" + item.gid + ">" +
                                "<input type='hidden' name=gid  value="+item.gid+"><button type='submit'  class='btn btn-default addmore' >添加</button></form>"+
                                "</td></tr>";
                        });
                        $("#goodlist").html(str);
                    }
                });
            }

        });


    }
)
