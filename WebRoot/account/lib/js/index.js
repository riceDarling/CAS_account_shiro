$(function(){
	//获取当前登录用户
	$.ajax("http://"+IP_config+"/account/admin/getLoginAdmin", {
		dataType: "json",
		xhrFields: {
			withCredentials: true
		},
		type: "GET",
		success: function(data) {
			//console.log(data);
			if(data.success){
				//获取用户成功
				$("#index_username").text(data.obj.username);
				$.cookie("login_userid",data.obj.id);
			}else{
				//获取用户失败，跳转到登录页
				location.href="login/login.html";
			}
		}
	});
	//菜单点击load页面
	$(".menu").click(function(){
		//alert($(this).attr("data-original-title"));
		var html=$(this).attr("data-original-title");
		$("#index_content").load(html+".html");
	});
	$("#admin_logout").click(function(){
		$.ajax({
			url:"http://"+IP_config+"/account/admin/exit",
			dataType:"json",
			type:"post",
			timeout:1000,
			success:function(data){
				if (data.success) {
					location.href="../account/login/login.html";
				} else {
					layer.alert(data.msg);
				}
			}
		});
	});
});