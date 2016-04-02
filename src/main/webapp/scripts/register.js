$.ajax({
url:"user/register",//注意在这里的请求路径上面不能加上/否则就会出现400错误，无法找到请求路径
type:"POST",
contentType: "application/json",//不加此项就会出现415错误代码
dataType:"JSON",
data:JSON.stringify({"name":"张三","pass":"123456","phone":"15195960613","infor":"快乐每一天"}),
success:function(data,status){alert("ok");},
error:function(){alert("error");},
fail:function(){alert("fail");}
});