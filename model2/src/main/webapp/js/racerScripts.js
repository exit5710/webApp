"use strict";
// racer
let repeat = true;

const fn_tabClickCallBack = function (tabSide) {
	if (tabSide === '#new') {
		$("#firstName").focus();
	}
};

const fn_startAJAXcalls = function () {
	if (repeat) {
		setTimeout(function () {
			fn_getXMLRacers();
			fn_startAJAXcalls();
		}, 10000);
	}
};

const fn_showFrequency = function () {
	$("#freq").html("Page refreshes every 10 second(s).");
};

const fn_lastUpdate = function () {
	$('#updatedTime').html(getDate() + "&nbsp;&nbsp;" + getTime(12));
};

/*
const fn_getTimeAjax = function () {
	$("#updatedTime").load("http://localhost/norcatec/time.jsp");
};
*/

const fn_btnStart = function () {
	repeat = true;
	fn_startAJAXcalls();
	fn_showFrequency();
};

const fn_btnStop = function () {
	repeat = false;
	$("#freq").html("Updates paused.");
};

const fn_getXMLRacers = function () {
	$.ajax({
		type: "POST",
		url: "./racerList.do",
		dataType: "json",
		cache: false,
		async: true,
		beforeSend: function (xhr, opts) {
			return true; // false 전송 취소
		},
		success: function (response) {
			$("#finishers_m").empty();
			$("#finishers_f").empty();
			$("#finishers_all").empty();

			$.each(response, function () {
				let info = "<li>Name: " + this["firstName"] + " " + this["lastName"] + ". Time: " + this["minutes"] + ":" + this["seconds"] + "</li>";
				if (this["gender"] === "m") {
					$("#finishers_m").append(info);
				} else if (this["gender"] === "f") {
					$("#finishers_f").append(info);
				}
				$("#finishers_all").append(info);

				fn_lastUpdate();
				//fn_getTimeAjax();
			});

			// $(response).each(function () {
			// 	console.log($(this));
			// });

			/*
			$(response).find("runner").each(function () {
				let info = "<li>Name: " + $(this).find('fname').text() + " " + $(this).find('lname').text() + ". Time: " + $(this).find('time').text() + "</li>";
				if ($(this).find("gender").text() === "m") {
					$("#finishers_m").append(info);
				} else if ($(this).find("gender").text() === "f") {
					$("#finishers_f").append(info);
				}
				$("#finishers_all").append(info);

				fn_lastUpdate();
				//fn_getTimeAjax();
			});
			*/
		},
		error: function (request, status, error) {
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		},
		complete: function (data, textStatus) {
		}
	});
};

const fn_btnSave = function () {
	//let data = $("#addRunner :input").serializeArray(); // [{name: 'firstName', value: '1'}, {name: 'lastName', value: '2'}, ...]
	let data = $("#addRunner").serializeObject(); // {firstName: '1', lastName: '2', ...} Gson vo 맵핑하기 위해선 json 형식으로 보내야함

	$.ajax({ // https://cofs.tistory.com/402
		type: "POST",
		url: "./racerSave.do",
		data: data, // {data : JSON.stringify(data)}
		dataType: "text", //"json" - data의 값이 이미 json이기 때문에 json 변경없이 text로 하는듯...
		cache: false,
		async: true,
		contentType: "application/x-www-form-urlencoded; charset=utf-8", //application/json; charset=utf-8
		beforeSend: function (xhr, opts) {
			let bool = true;

			if (data["firstName"] === "") {
				$("#firstName").focus();
				alert("FirstName을 입력하세요.");
				bool = false;
				return false;
			}

			if (data["lastName"] === "") {
				$("#lastName").focus();
				alert("lastName을 입력하세요.");
				bool = false;
				return false;
			}

			if (data["gender"] === "") {
				$("#gender").focus();
				alert("gender를 선택하세요.");
				bool = false;
				return false;
			}

			if (data["minutes"] === "") {
				$("#minutes").focus();
				alert("minutes를 입력하세요.");
				bool = false;
				return false;
			}

			if (data["seconds"] === "") {
				$("#seconds").focus();
				alert("seconds를 입력하세요.");
				bool = false;
				return false;
			}

			return bool; // false 전송 취소
		},
		success: function (response) {
			$('#addRunner')[0].reset();
			alert("정상적으로 등록되었습니다.");
		},
		error: function (request, status, error) {
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		},
		complete: function (data, textStatus) {
		}
	});

	/*
	$.post($("#addRunner").attr("action"), data, function (json) { // $("#addRunner").attr("action") = <form action="./xxx.do"....> ./xxx값을 추출
		if (json.status === "fail") {
			alert(json.message);
		}

		if (json.status === "success") {
			alert(json.message);
			fn_clearInputs();
		}
	}, "json");
	*/
};

$(document).ready(function () {
	$("#btnStart").click(fn_btnStart);
	$("#btnStop").click(fn_btnStop);
	// $("#btnSave").click(fn_btnSave);

	fn_tabSetting();
	fn_getXMLRacers();
	fn_showFrequency();
	fn_startAJAXcalls();
});