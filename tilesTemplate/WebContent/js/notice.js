//공지사항 목록
$.ajax({
	url : "ajax/noticeList.do" ,
	dataType : "json",
	success : function(datas){
		for(data of datas) {
			$("<tr>").append(  $("<td>").html(data.id)  )
					 .append(  $("<td>").html(data.title)  )
					 .appendTo(  $("#list")  );
		}
	}
});

//등록
$("#btnSave").on("click", function(){
	$.ajax({
		url : "ajax/noticeInsert.do",
		method : "post",
		data : $(frm).serialize(),   //질의문자열 
		dataType : "json",
		success :  function(data){
			$("<tr>").append(  $("<td>").html(data.id)  )
					 .append(  $("<td>").html(data.title)  )
					 .appendTo(  $("#list")  );
		}
	});
})

