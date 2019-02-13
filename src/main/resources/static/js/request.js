
//跨域版
 function ajaxCross(options){


     //创建-第一步
     var xhr;
     //非IE6
     if(window.XMLHttpRequest){
         xhr=new XMLHttpRequest();
     }else{
         //ie6及其以下版本浏览器
         xhr=ActiveXObject('Microsoft.XMLHTTP');
     }

     //接收-第三步
     xhr.onreadystatechange=function(){
         if(xhr.readyState==4){
             var status=xhr.status;
             if(status>=200&&status<300){
                 options.success&&options.success(xhr.responseText,xhr.responseXML);
             }else{
                 options.error&&options.error(status);
             }
         }
     }

     var params = options.data;
     //连接和发送-第二步
     if(options.type=='GET'){
         params=formatParams(options.data);
         xhr.open('GET',options.url+'?'+params,true);
         xhr.send(null);
     }else if(options.type=='POST'){
         xhr.open('POST',options.url,true);
         //设置表单提交时的内容类型
         // xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
         // xhr.send(params);
         xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
         xhr.send(JSON.stringify(params));
         // JSON.stringify
     }
 }
 //发送请求原生版
 function ajax(options){
     var params =formatParams(options.data);

     //创建-第一步
     var xhr;
     //非IE6
     if(window.XMLHttpRequest){
         xhr=new XMLHttpRequest();
     }else{
         //ie6及其以下版本浏览器
         xhr=ActiveXObject('Microsoft.XMLHTTP');
     }

     //接收-第三步
     xhr.onreadystatechange=function(){
         if(xhr.readyState==4){
             var status=xhr.status;
             if(status>=200&&status<300){
                 options.success&&options.success(xhr.responseText,xhr.responseXML);
             }else{
                 options.error&&options.error(status);
             }
         }
     }

     //连接和发送-第二步
     if(options.type=='GET'){
         xhr.open('GET',options.url+'?'+params,true);
         xhr.send(null);
     }else if(options.type=='POST'){
         xhr.open('POST',options.url,true);
         //设置表单提交时的内容类型
         // xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
         // xhr.send(params);
         xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
         console.log(params);
         xhr.send(JSON.stringify(params));
         // JSON.stringify
     }
 }

 //格式化参数
 function formatParams(data){
     var arr=[];
     for(var name in data){
         arr.push(encodeURIComponent(name)+'='+encodeURIComponent(data[name]));
     }
     // arr.push(('v='+Math.random()).replace('.',''));
     return arr.join('&');
 }

function sendGet(URL, PARAMS) {

    // 发送ajax 请求 需要 五步

    // （1）创建异步对象
    var ajaxObj = new XMLHttpRequest();

    // （2）设置请求的参数。包括：请求的方法、请求的url。
    ajaxObj.open('get', URL);
    URL+='?';

    for (var key in PARAMS) {
        URL+= '&'+a+'='+PARAMS[a];
    }
    console.log("url:",URL);
    // （3）发送请求
    ajaxObj.send();

    //（4）注册事件。 onreadystatechange事件，状态改变时就会调用。
    //如果要在数据完整请求回来的时候才调用，我们需要手动写一些判断的逻辑。
    ajaxObj.onreadystatechange = function () {
        // 为了保证 数据 完整返回，我们一般会判断 两个值
        if (ajaxObj.readyState == 4 && ajaxObj.status == 200) {
            // 如果能够进到这个判断 说明 数据 完美的回来了,并且请求的页面是存在的
            // 5.在注册的事件中 获取 返回的 内容 并修改页面的显示
            console.log('数据返回成功');

            // 数据是保存在 异步对象的 属性中
            console.log(ajaxObj.responseText);

            // $('#result').text(data.result);
        }
    }
    alert("发送成功");
}