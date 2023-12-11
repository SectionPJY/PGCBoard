function gameInfo(g_id) {
		console.log(g_id);
		
		var width = 700;
		var height = 400;
		var positionX = (window.screen.width / 2) - (width / 2);
        var positionY = (window.screen.height / 2) - (height / 2);
        
		window.open(
				"gameInfo?g_id=" + g_id, 	// 링크
				"gameInfo",	// 새 창 아이디
				"width=" + width +
				", height=" + height +
				", top=" + positionY +
				", left=" + positionX);
		
		return false;
	};
	
function gameRej(g_id) {
		console.log(g_id);

		$.ajax({
			type : "post",
			url : "http://localhost:8080/ex/gameRej",
			data : {
				g_id : g_id
			},
			success : function(data, status) {
				alert("삭제조치 되었습니다.");

				window.location.reload();
			},
			error : function(status) {
				alert("삭제조치에 실패하였습니다.");

				return false;
			}
		});
	};

function gameRes(g_id) {
		console.log(g_id);

		$.ajax({
			type : "post",
			url : "http://localhost:8080/ex/gameRestore",
			data : {
				g_id : g_id
			},
			success : function(data, status) {
				alert("복구조치 되었습니다.");

				window.location.reload();
			},
			error : function(status) {
				alert("복구에 실패하였습니다.");

				return false;
			}
		});
	};
	
function returnGame(g_id) {
	console.log(g_id);
	
	$.ajax({
		type : "post",
		url : "http://localhost:8080/ex/gameReturn",
		data : {
			g_id : g_id
		},
		success : function(data, status) {
			alert("반납처리 되었습니다.");
			
			window.location.reload();
		},
		error : function(status) {
			alert("반납처리에 실패하였습니다.");
			
			return false;
		}
	});
};

$(document).ready(function() {
	$('#dtBasicExample').DataTable();
	$('.dataTables_length').addClass('bs-select');
});

// Basic example
$(document).ready(function() {
	$('#dtBasicExample').DataTable({
		"paging" : false
	// false to disable pagination (or any other option)
	});
	$('.dataTables_length').addClass('bs-select');
});

//Basic example
$(document).ready(function () {
  $('#dtBasicExample').DataTable({
    "pagingType": "simple" // "simple" option for 'Previous' and 'Next' buttons only
  });
  $('.dataTables_length').addClass('bs-select');
});