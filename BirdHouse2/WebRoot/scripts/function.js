var isIE = !!document.all;
//Selector
function bindSelector()
{
	for(var i=0; i<arguments.length; i++) {
		document.getElementById(arguments[i]).onmouseover = function(){
			this.getElementsByTagName("ul")[0].style.display = "block";
		}
		document.getElementById(arguments[i]).onmouseout = function(){
			this.getElementsByTagName("ul")[0].style.display = "none";
		}
	}
}

function getStyle(el, name)
{
	return isIE ? el.currentStyle[name] : window.getComputedStyle(el, null)[name];
}
$(function(){
	var flag;
	var flag2;
	var priceIndex=$("[name='hiddenprice']").val();
	if(priceIndex!=null){
		$('#priceList option:eq('+priceIndex+')').attr('selected','selected');
	}
	var distreetIndex=$("[name='hiddendistrict']").val();
	if(distreetIndex!=null){
		$('#district option:eq('+distreetIndex+')').attr('selected','selected');
	}
	var streetIndex=$("[name='hiddenstreet']").val();
	if(streetIndex!=null){
		$('#street option:eq('+streetIndex+')').attr('selected','selected');
	}
	var typesIndex=$("[name='hiddentypes']").val();
	if(typesIndex!=null){
		$('#types option:eq('+typesIndex+')').attr('selected','selected');
	}
	var floorageIndex=$("[name='hiddenfloorage']").val();
	if(floorageIndex!=null){
		$('#floorage option:eq('+floorageIndex+')').attr('selected','selected');
	}
	var typeid=$("[name='typeid']").val();
	if(typeid!=null){
		$('#type_id option:eq('+typeid+')').attr('selected','selected');
	}
	var districtid=$("[name='districtid']").val();
	if(districtid!=null){
		$('#fabu_district option:eq('+districtid+')').attr('selected','selected');
	}
	var streetsid=$("[name='streetsid']").val();
	if(streetsid!=null){
		var selectIndex = document.getElementById("fabu_district").selectedIndex;
		$.ajax({   
				url:'/BirdHouse2/getstreet.action',   
				type:'post',
			data:{"fabu_di":selectIndex},   
				async : true, //默认为true 异步   
			error:function(){   
			$("[name='street_id']").html("");
   			alert('请选择!'); 
   			
},   
			success:function(data){
				$("[name='street_id']").html(data);
				$('#street_id option:eq('+streetsid+')').attr('selected','selected');
			}
	})
	}
	if($("[name='priceList']").val()=='0'){
		$("[name='hiddenprice']").val('0');
	}
	if($("[name='district']").val()=='0'){
		$("[name='hiddendistrict']").val('0');
	}
	if($("[name='street_id']").val()=='0'){
		$("[name='hiddenstreet']").val('0');
	}
	if($("[name='type_id']").val()=='0'){
		$("[name='hiddentypes']").val('0');
	}
	if($("[name='floorage']").val()=='0'){
		$("[name='hiddenfloorage']").val('0');
	}
	
	$("[name='name']").blur(function(){
		var c=$(this).val();
		if(c==''){
			$(this).next().html("用户名不能为空");
			flag=false;
		}else if(c.length<6 ||c.length>12){
			$(this).next().html("请输入合法用户");
			flag=false;
		}else{
			flag=true;
		}
	})
	$("[name='name']").focus(function(){
			$(this).next().html("");
	})
	$("[name='password']").blur(function(){
		var p=$(this).val();
		if(p==''){
			$(this).next().html("密码不能为空!");
			flag2=false;
		}else if(p.length<6 ||p.length>12){
			$(this).next().html("请输入合法密码");
			flag2=false;
		}else{
			flag2=true;
		}
	})
	$("[name='submit']").click(function(){
		if(flag==true&&flag2==true){
			$("#user").attr("action","login.action"); 
			$("#user").submit(); 
		}else{
			alert("信息填写有误,请检查后登录.");
		}
		
	})
	$("[name='password']").focus(function(){
			$(this).next().html("");
	})
	$("#changeCode").click(function(){
        $("#safeCode").attr("src","page/Number.jsp?id="+Math.random());
    });
	$("#safeCode").click(function(){
        $("#safeCode").attr("src","page/Number.jsp?id="+Math.random());
    });
	$("[name='district']").change(function(){
		var selectIndex = document.getElementById("district").selectedIndex;
		$("[name='hiddendistrict']").val(selectIndex);
		if(selectIndex=='0'){
			$("[name='hiddenstreet']").val(0);
		}
		$("#sform").submit();
})
	$("[name='street_id']").change(function(){
		var selectIndex = document.getElementById("street").selectedIndex;
		$("[name='hiddenstreet']").val(selectIndex);
	})
	$("[name='type_id']").change(function(){
		var selectIndex = document.getElementById("types").selectedIndex;
		$("[name='hiddentypes']").val(selectIndex);
	})
	$("#fabu_district").change(function(){
		//$("[name='street_id']").html("<OPTION selected value=1001>中关村大街</OPTION><OPTION selected value=1001>中关村大街</OPTION>");
		var selectIndex = document.getElementById("fabu_district").selectedIndex;
		alert(selectIndex);
		$.ajax({   
				url:'/BirdHouse2/getstreet.action',   
				type:'post',
			data:{"fabu_di":selectIndex},   
				async : true, //默认为true 异步   
			error:function(){   
			$("[name='street_id']").html("");
   			alert('请选择!'); 
   			
},   
			success:function(data){
				$("[name='street_id']").html(data);
			}
	})
})
	$("[name='del']").click(function(){
		var delhouseid=$("[name='hid']").val();
		 if(confirm("确认删除?")){
			 $.ajax({   
					url:'/BirdHouse2/delHouse.action',   
					type:'post',
				data:{"delhouseid":delhouseid},   
					async : true, //默认为true 异步   
				error:function(){
		},   
				success:function(data){
					history.go(0);
				}
		})
	}
		
	})
	$("[name='upd']").click(function(){
		var updhouseid=$(this).next().val();
		 $.ajax({   
				url:'/BirdHouse2/updHouse.action',   
				type:'post',
			data:{"updhouseid":updhouseid},   
				async : true, //默认为true 异步   
			error:function(){
	},   
			success:function(data){
				window.location.href="fabu.action?moshi=1";
			}
	})
	})
})