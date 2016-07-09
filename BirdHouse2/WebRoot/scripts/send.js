	$(function(){
		var count=getCookie("count");
		var flag=false;
		var flag2=false;
		var flag3=false;
		var flag4=false;
		var flag5=false;
		//设置或添加cookie
		function setCookie(name,value,time){ 
		    var str = name + "=" + escape(value);
		    if(time > 0){
		        var date = new Date();
		        var ms = time*3600*1000;
		        date.setTime(date.getTime() + ms);
		        str += "; expires=" + date.toGMTString();
		    }
		    document.cookie = str;
		}
		//获取cookie  
		function getCookie(name){  
		    //cookie中的数据都是以分号加空格区分开  
		    var arr = document.cookie.split("; ");  
		    for(var i=0; i<arr.length; i++){  
		        if(arr[i].split("=")[0] == name){  
		            return arr[i].split("=")[1];  
		        }
		    }
		    //未找到对应的cookie则返回空字符串  
		    return '';  
		}
			var yzm="";
			$("[name='send']").click(function(){
				if($("[name='user.telephone']").val().length!=11){
					alert('请输入合法号码,否则无法发送验证码');
				}else{
				if(count>=3){
					alert('使用次数已经超过了最大次数,请明天重试！');
				}else{
				var sendphonenumber=$("[name='user.telephone']").val();
				$.ajax({   
   				url:'/BirdHouse2/yanz.action',   
   				type:'post',   
    			data:{"sendphonenumber":sendphonenumber},   
   				async : true, //默认为true 异步   
    			error:function(){   
       			alert('发送失败!');  
       			flag5=false;
    },   
    			success:function(data){
    				alert("发送成功!");
    				var name="count";
    				var value="1";
    				if(count == "" || count == undefined || count == null){
    					setCookie(name,value,"24");
    				}else{
    					count=count+1;
    					setCookie(name,count,"24");
    				}
       			yzm=data;
    }
});}}})
			$("[name='yzm']").blur(function(){
				var yzm2=$("[name='yzm']").val();
				if (yzm2==yzm&&yzm2!=""&&yzm!=null) {
					alert("验证成功");
					flag5=true;
				}else{
					alert('验证码不匹配.');
					flag5=false;
				}
			})
		$("[name='user.name']").blur(function(){
		var name=$(this).val();
		if(name == "") {
			$(this).next().html("用户名不能为空");
        }else if(!/[a-zA-Z0-9]+/.test(name)){
            $(this).next().html("用户名只能是英文字母或者数字");
        }else{
        	$.ajax({   
   				url:'/BirdHouse2/yanzname.action',   
   				type:'post',
    			data:{"name":name},   
   				async : true, //默认为true 异步   
    			error:function(){   		
    },   
    success:function(data){
		if(data!=0){
			flag=true;
		}else{
		alert("用户名已经被使用,请重新输入!");
		$("[name='user.name']").val('');
		flag=false;
}}})}
	})
	$("[name='user.name']").focus(function(){
			$(this).next().html("");
	})
	$("[name='user.password']").blur(function(){
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
	$("[name='user.username']").focus(function(){
			$(this).next().html("");
	})
	$("[name='user.username']").blur(function(){
		var p=$(this).val();
		if(p==''){
			$(this).next().html("用户名不能为空!");
			flag3=false;
		}else if(p.length==1 ||p.length>4){
			$(this).next().html("请输入合法用户名");
			flag3=false;
		}else{
			flag3=true;
		}
	})
	$("[name='repassword']").focus(function(){
			$(this).next().html("");
	})
	$("[name='repassword']").blur(function(){
		var p=$(this).val();
		var p2=$("[name='user.password']").val();
		if(p==''){
			$(this).next().html("密码不能为空!");
			flag4=false;
		}else if(p!=p2){
			$(this).next().html("两次密码不一致");
			flag4=false;
		}else{
			flag4=true;
		}
	})
	$("[name='user.password']").focus(function(){
			$(this).next().html("");
	})
	$("[name='submit']").click(function(){
		if(flag==true&&flag2==true&&flag3==true&&flag4==true&&flag5==true){
			$("#reg").attr("action","regsgo.action"); 
			$("#reg").submit(); 
		}else{
			alert("信息填写有误,请检查后登录.");
		}
		
	})
	
		})