/**
 * 
 */

/* 멤버리스트페이지 페이징 시작 /admin/memberList.jsp */
function movePage1(p1) {    // 페이지 이동
	
    let p3 = $("#pKeyField").val().trim();  // p3 : keyField
    let p4 = $("#pKeyWord").val().trim();  // p4 : keyWord

	let param = "/admin/memberList?nowPage="+p1;	    
	     param += "&keyField="+p3;
	     param += "&keyWord="+p4 ; 
	location.href= param;
}
/* 멤버리스트페이지 페이징 끝 /bbs/list.jsp */

/* 멤버리스트페이지 페이징 블럭이동 시작 /admin/memberList.jsp */
function moveBlock1(p1, p2, param3) {    
	                // 이전 블럭 또는 이후 블럭으로 이동  p1 => nowBlock-1  또는 nowBlock+1

	let moveBlock = parseInt(p1);    // 이전 블럭의 시작페이지로 이동에 사용하는 소
	let pagePerBlock = parseInt(p2);	
	//alert("p1(moveBlock) : " + p1 + "\np2(pagePerBlock) : " + p2);
	
    let p3 = $("#pKeyField").val().trim();  // p3 : keyField
    let p4 = $("#pKeyWord").val().trim();  // p4 : keyWord
	
	if (param3 == 'ab') {
		 param = "/admin/memberList?nowPage="+(moveBlock*pagePerBlock);
	     // moveBlock : nowBlock - 1 
	     param += "&keyField="+p3;
	     param += "&keyWord="+p4 ;
	} else if (param3 == 'cd' ) {		
		 param = "/admin/memberList?nowPage="+(pagePerBlock*(moveBlock-1)+1);   
		 // moveBlock : nowBlock + 1 
	     param += "&keyField="+p3;
	     param += "&keyWord="+p4 ;
	}
	location.href=param;
	
	
	
	
	$("#loginAlertBtn").click(function(){		
		alert("로그인 후 작성하실 수 있습니다.");
	});	
	$("#noticeWriteBtn").click(function(){		
		location.href="/admin/noticeWrite?uId=${uId}";
	});
	
	
}
/* 멤버리스트페이지 페이징 블럭이동 끝 /admin/memberList.jsp */