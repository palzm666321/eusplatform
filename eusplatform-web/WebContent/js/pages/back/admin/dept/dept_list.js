$(function(){
	$("button[id^=edit-]").each(function(){
		$(this).on("click",function(){
			did = this.id.split("-")[1] ;
			dname = $("#dname-" + did).val() ;
			maxnum=$("#maxnum-"+did).val();
			currnum=$("#currnum-"+did).text();
			if(dname==""){
				operateAlert(false,"","部门名称不允许为空，请确认后再提交更新！") ;
			}else if(currnum-maxnum>0){
				operateAlert(false,"","最大人数不能低于当前员工数，请确认后再提交更新！") ;
			}else{
				$.post("pages/back/admin/dept/DeptActionFront!edit.action",{"did":did,"dname":dname,"maxnum":maxnum},function(data){
					operateAlert(data.trim()=="true","部门修改成功！","部门修改失败!") ;
				},"text");
			}
			
		}) ;
	}) ;
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("-")[1] ;
			console.log("雇员编号：" + eid) ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;