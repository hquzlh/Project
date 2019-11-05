
$(function () {
    $.ajax({
        url: "/order/findAll",
        type: "post",
        dataType: "json",
        success: function (data) {
            var str = "";

            //循环遍历json数组格式的数据
            $.each(data, function (index, item) {

                str +=
                    "<tr>" +
                    "<td><img  alt='" + item.name + "' class=\"img-rounded\" src='" + item.uri + "'width=66 height=66></td>" +
                    "<td>" + item.name + "</td>" +
                    "<td>" + item.num + "</td>" +
                    "<td>" + item.price*item.num + "</td>" +
                    "<td>" + item.orderNumber+ "</td>" +
                    "<td>" + item.date + "</td>" +
                    "</tr>";
            });
            $("#orderlist").html(str);
        }
    })
})
