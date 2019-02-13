//post 请求
function sendP(url) {
    var parent = event.srcElement.parentNode;
    var els =  parent.getElementsByTagName('input');
    var map = {};
    for (var i = 0; i < els.length; i++) {
        eval('map.'+els[i].getAttribute('name')+'=\''+els[i].getAttribute('value')+'\'');
    }

    ajaxCross({
        type: "POST",
        url: url,
        async: false, // 使用同步方式
        // 1 需要使用JSON.stringify 否则格式为 a=2&b=3&now=14...
        // 2 需要强制类型转换，否则格式为 {"a":"2","b":"3"}

        data:map,
        // data: JSON.stringify({
        //     a: parseInt($('input[name="a"]').val()),
        //     b: parseInt($('input[name="b"]').val()),
        //     now: new Date().getTime() // 注意不要在此行增加逗号
        // }),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data) {
            data = JSON.parse(data);
            console.log("自主操作：",data);
            if (data.state){
                document.getElementById('result').innerText =JSON.stringify(data.data.token);
            }

            // $('#result').text(data.result);
        } // 注意不要在此行增加逗号
    });
}

function sendG(url,params) {

    ajaxCross({
        type: "GET",
        url: url,
        async: false, // 使用同步方式
        // 1 需要使用JSON.stringify 否则格式为 a=2&b=3&now=14...
        // 2 需要强制类型转换，否则格式为 {"a":"2","b":"3"}

        data:params,
        // data: JSON.stringify({
        //     a: parseInt($('input[name="a"]').val()),
        //     b: parseInt($('input[name="b"]').val()),
        //     now: new Date().getTime() // 注意不要在此行增加逗号
        // }),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data) {
            data = JSON.parse(data);
            console.log("自主操作：",data);

            // $('#result').text(data.result);
        } // 注意不要在此行增加逗号
    });
}
