$("#signup_form").on("click","#accountPurchaseSubmit",function(){
	var listjson = {};
	listjson["id"]=$("#id").val();
	listjson["title"]=$("#title").val();
	listjson["inquirynum"]=$("#inquirynum").val();
	listjson["checker"]=$("#accountPurchaseForm_checker").val();
	var DetailList = new Array();
	var supplierList = new Array();
	
	$("#accountPurchaseDetailList tr").each(function(){
		var json={};
		json["suppliercode"]=$(this).children("td").eq(0).find("input").attr("suppliercode");
		json["materialcode"]=$(this).children("td").eq(1).find("input").attr("materialcode");
		json["packway"]=$(this).children("td").eq(2).find("select").val();
		json["transport"]=$(this).children("td").eq(3).find("select").val();
		json["freightfee"]=$(this).children("td").eq(4).find("input").val();
		json["unitprice"]=$(this).children("td").eq(5).find("input").val();
		json["quantity"]=$(this).children("td").eq(6).find("input").val();
		json["receivedate"]=$(this).children("td").eq(7).find("input").val();
		json["totlemoney"]=$(this).children("td").eq(8).find("input").val();
		json["remarks"]=$(this).children("td").eq(9).find("textarea").val();
		DetailList.push(json);
	});
	listjson["accountPurchaseDetailList"]=DetailList;
	
	$("#supplierList tr").each(function(){
		var json={};
		json["supplier"]=$(this).children("td").eq(0).find("input").val();
		json["deadline"]=$(this).children("td").eq(1).find("input").val();
		json["payway"]=$(this).children("td").eq(2).find("select").val();
		supplierList.push(json);
	});
	listjson["supplierList"]=supplierList;
	
	console.log(listjson);
	
	$.ajax("http://"+IP_config+"/account/accountPurchase/save", {
		dataType: "json",
		contentType:"application/json;charset=UTF-8",
		data:JSON.stringify(listjson),
		xhrFields: {
			withCredentials: true
		},
		type: "POST",
		success: function(data) {
			//console.log(data);
			if(data.success){
				//提交成功
				layer.alert(data.msg);
				$("#index_content").load("actTaskHistoricList.html");
			}else{
				//提交失败提示
				layer.alert(data.msg);
			}
		}
	});
});
//当前登录用户为创建人的话，获取订货表信息，反填
function getPurchase(accountPurchaseForm_id){
	//根据订货单id获取询价单字表列表
	$.ajax("http://"+IP_config+"/account/accountPurchase/formView", {
		dataType: "json",
		xhrFields: {
			withCredentials: true
		},
		type: "GET",
		data:{
			"accountPurchaseid":accountPurchaseForm_id
		},
		success: function(data) {
			//console.log(data);
			if(data.success){
				//获取成功
				//layer.alert(data.msg);
				if(data.obj!=null){
					if(data.obj.purchase.accountPurchaseDetailList.length>0){
						var html="";
						for (i in data.obj.purchase.accountPurchaseDetailList) {
							html+='<tr><td>';
							var detail = data.obj.purchase.accountPurchaseDetailList[i];
							html+='<input readonly type="text" maxlength="35" suppliercode="'+detail.suppliercode+'" value="'+detail.supplier+'" class="form-control required"></td><td>';	
							html+='<input  readonly type="text" maxlength="35" materialcode="'+detail.materialcode+'" value="'+detail.materialname+'" class="form-control required"></td>';
							html+='<td><select name="packway" data-value="" class="form-control required">'
								+'<option value="'+detail.packway+'" selected="true">'+detail.packways+'</option>'
								+packway
								+'	</select></td>';
							html+='<td><select name="transport" data-value="" class="form-control required">'
								+'<option value="'+detail.transport+'" selected="true">'+detail.transports+'</option>'
								+transport
								+'</select></td>';
							html+='<td>'
								+'	<input  name="freightfee" type="text"  value="'+detail.freightfee+'" class="money form-control number required">'
								+'</td>'
								+'<td>'
								+'	<input readonly name="unitprice" value="'+detail.unitprice+'" type="text" class="form-control number">'
								+'</td>'
								+'<td>'
								+'	<input  name="quantity" type="text" value="'+detail.quantity+'" maxlength="11" class="money form-control required number">'
								+'</td>'
								+'<td>'
								+'	<input readonly name="receivedate" value="'+detail.receivedate+'" type="text" maxlength="20" class="form-control Wdate required form_datetime" value="" >'
								+'</td>'
								+'<td>'
								+'	<input readonly name="totlemoney" value="'+detail.totlemoney+'" maxlength="10" type="text" value="" class="form-control number required" >'
								+'</td>'
								+'<td>'
								+'	<textarea  name="remarks" rows="4"  maxlength="255" class="form-control ">'+detail.remarks+'</textarea>'
								+'</td>';
								
							html+='</tr>';
						}
						$("#accountPurchaseDetailList").html(html);
						
					}
					//供应商列表
					if(data.obj.purchase.supplierList.length>0){
						var html="";
						for (i in data.obj.purchase.supplierList) {
							var supplier=data.obj.purchase.supplierList[i];
							html+='<tr>'
								+'<td>'
								+'<input  name="supplier"  readonly type="text" value="'+supplier.supplier+'" maxlength="35" class="form-control required"/>'
								+'</td>'
								+'<td>'
								+'	<input value="'+supplier.deadline+'"   readonly name="deadlines" type="text"  maxlength="20" class="form-control Wdate required form_datetime" >'
								+'</td>'
								+'<td>'
								+'	<select name="payway" data-value="" class="form-control required">'
								+'<option value="'+supplier.payway+'" selected="true">'+supplier.payways+'</option>'
								+payway	
								+'	</select>'
								+'</td>'
								+'	</tr>';
						}
						$("#supplierList").html(html); 
					}
					
					$(".form_datetime").datetimepicker({
						language:  'zh-CN', 
						minView: "month", //选择日期后，不会再跳转去选择时分秒 
					    format: 'yyyy-mm-dd',
					    todayBtn:  1,
					    autoclose: 1,});
					
					//流程节点列表
					if(data.obj.actlist.length>0){
						var html="";
						for (i in data.obj.actlist) {
							var act = data.obj.actlist[i];
							html += '<tr><td>'
									+ act.requisitionName + '</td>' + '<td>'
									+ act.checkerName + '</td>' + '<td>'
									+ formatDateTime(act.start_time) + '</td>' + '<td>';
									if(act.end_time!=null){
										html+= formatDateTime(act.end_time) + '</td>' + '<td>';
									}else{
										html+='</td>' + '<td>';
									}
								
									if(act.conclusion==1){
										html+='同意</td>' + '<td>';
									}else if(act.conclusion==0){
										html+='不同意</td>' + '<td>';
									}else {
										html+='</td>' + '<td>';
									}
									
									html+= act.remarks + '</td>' + '</tr>';
						}
						$("#accountPurchaseForm_act_table tbody").html(html); 
					}
					
				}
				
			}else{
				//获取失败提示
				layer.alert(data.msg);
			}
		}
	
	});
};