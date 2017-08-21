$("#accountPurchaseSubmit").click(function(){
	var data_json={};
	var inquirynum=$("#accountPurchaseForm_contract").val();
	var title=$("#title").val();
	var checker=$("#accountPurchaseForm_checker").val();
	var purchase_id=$("#title").attr("purchase_id");
	data_json["id"]=purchase_id;
	data_json["inquirynum"]=inquirynum;
	data_json["title"]=title;
	data_json["checker"]=checker;
	
	var listjson = new Array();
	$("#secondPageTbody tr").each(function(){
		var json={};
		json["materialcode"]=$(this).children("td").eq(0).attr("materialcode");
		json["unitprice"]=$(this).children("td").eq(2).text();
		json["quantity"]=$(this).children("td").eq(3).find("input").val();
		json["totlemoney"]=$(this).children("td").eq(4).find("input").val();
		listjson.push(json);
	});
	data_json["accountPurchaseDetailList"]=listjson;
	console.log(data_json);
	
	$.ajax("../accountPurchase/save", {
		dataType: "json",
		contentType:"application/json;charset=UTF-8",
		data:JSON.stringify(data_json),
		xhrFields: {
			withCredentials: true
		},
		type: "POST",
		success: function(data) {
			//console.log(data);
			if(data.success){
				//提交成功
				layer.alert(data.msg);
				$("#index_content").load("accountPurchaseList.html");
			}else{
				//提交失败提示
				layer.alert(data.msg);
			}
		}
	});
});

//删除
$("#accountPurchaseDanger").click(function(){
	$.ajax("../accountPurchase/delete", {
		dataType: "json",
		data:{
			"accountPurchaseid" : accountPurchaseAudit_id
		},
		xhrFields: {
			withCredentials: true
		},
		type: "POST",
		success: function(data) {
			//console.log(data);
			if(data.success){
				//提交成功
				layer.alert(data.msg);
				$("#index_content").load("accountPurchaseList.html");
			}else{
				//提交失败提示
				layer.alert(data.msg);
			}
		}
	});
})

