var billObj;

//订单管理页面上点击删除按钮弹出删除框(billlist.jsp)
function deleteBill(obj){
	$.ajax({
		type:"GET",
		url:path+"/bill/delete.do/"+obj.attr("billid"),
		//data:{billid:obj.attr("billid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
				//changeDLGContent("删除成功");
				alert("删除成功");
			}else if(data.delResult == "false"){//删除失败
				//alert("对不起，删除用户【"+obj.attr("username")+"】失败");
				changeDLGContent("对不起，删除用户【"+obj.attr("username")+"】失败");
			}else if(data.delResult == "notexist"){
				//alert("对不起，用户【"+obj.attr("username")+"】不存在");
				changeDLGContent("对不起，用户【"+obj.attr("username")+"】不存在");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeBi').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeBi').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	$(".viewBill").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		//window.location.href=path+"/jsp/bill.do?method=view&billid="+ obj.attr("billid");
		
		$.ajax({
			type:"GET",//请求类型
			url:path+"/bill/ShowBybill.html/"+obj.attr("billid"),
			//data:{billid:obj.attr("billid")},
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				//alert(obj.attr("billid"));
				$("#providerView").html("");
				var str="";
				str+="<p><strong>订单编号：</strong><span>"+data.billCode+"</span></p>";
				str+=" <p><strong>商品名称：</strong><span>"+data.productName+"</span></p>";
				str+=" <p><strong>商品单位：</strong><span>"+data.productUnit+"</span></p>";
				str+=" <p><strong>商品数量：</strong><span>"+data.productCount+"</span></p>";
				str+=" <p><strong>总金额：</strong><span>"+data.totalPrice+"</span></p>";
				str+=" <p><strong>供应商：</strong><span>"+data.proName+"</span></p>";
				var xb=data.isPayment;
            	if(xb==1){
            		str+="<p><strong>是否付款：</strong><span>未付款</span></p>"
            	}else{
            		str+="<p><strong>是否付款：</strong><span>已经付款</span></p>"
            	}
				
				$("#providerView").html(str);
			
			},
		});
		
		
	});
	
	
	
	
	$(".modifyBill").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/bill/view/"+ obj.attr("billid");
	});
	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteBill(billObj);
	});

	$(".deleteBill").on("click",function(){
		billObj = $(this);
		changeDLGContent("你确定要删除订单【"+billObj.attr("billcc")+"】吗？");
		openYesOrNoDLG();
	});
	
	/*$(".deleteBill").on("click",function(){
		var obj = $(this);
		if(confirm("你确定要删除订单【"+obj.attr("billcc")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/bill.do",
				data:{method:"delbill",billid:obj.attr("billid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){//删除成功：移除删除行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){//删除失败
						alert("对不起，删除订单【"+obj.attr("billcc")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，订单【"+obj.attr("billcc")+"】不存在");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
			});
		}
	});*/
});