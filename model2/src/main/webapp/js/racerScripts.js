"use strict";
// racerScripts

let repeat = true;

const fn_tabClickCallBack = function (tabSide) {
	if (tabSide === '#new') {
		$("#firstName").focus();
	}
};

const fn_startAJAXcalls = function () {
	if (repeat) {
		setTimeout(function () {
			fn_racerList();
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

const fn_btnStart = function () {
	repeat = true;

	fn_startAJAXcalls();
	fn_showFrequency();
};

const fn_btnStop = function () {
	repeat = false;

	$("#freq").html("Updates paused.");
};


const fn_racerList = function () {
	fn_searchSubmit("./racerList.do","", function (response) {
		$("#finishers_m").empty();
		$("#finishers_f").empty();
		$("#finishers_all").empty();

		$.each(response, function () { // $(response).find("runner").each(function () {
			// $(this).find('fname').text()
			let info = "<li>Name: " + this["firstName"] + " " + this["lastName"] + ". Time: " + this["minutes"] + ":" + this["seconds"] + "</li>";

			if (this["gender"] === "m") {
				$("#finishers_m").append(info);
			} else if (this["gender"] === "f") {
				$("#finishers_f").append(info);
			}

			$("#finishers_all").append(info);

			fn_lastUpdate();
		});
	});
};

const fn_btnSave = function () {
	//let data = $("#addRunner :input").serializeArray(); // [{name: 'firstName', value: '1'}, {name: 'lastName', value: '2'}, ...]
	let data = $("#addRunner").serializeObject(); // {firstName: '1', lastName: '2', ...} Gson vo 맵핑하기 위해선 json 형식으로 보내야함

	if (data["firstName"] === "") {
		$("#firstName").focus();
		alert("firstName을 입력하세요.");

		return false;
	}

	if (data["lastName"] === "") {
		$("#lastName").focus();
		alert("lastName을 입력하세요.");

		return false;
	}

	if (data["gender"] === "") {
		$("#gender").focus();
		alert("gender를 선택하세요.");

		return false;
	}

	if (data["minutes"] === "") {
		$("#minutes").focus();
		alert("minutes를 입력하세요.");

		return false;
	}

	if (data["seconds"] === "") {
		$("#seconds").focus();
		alert("seconds를 입력하세요.");

		return false;
	}

	fn_saveSubmit("./racerSave.do", data, true, function (response) {
		$('#addRunner')[0].reset();
		alert("정상적으로 등록되었습니다.");
	});
};

$(document).ready(function () {
	$("#btnStart").click(fn_btnStart);
	$("#btnStop").click(fn_btnStop);
	// $("#btnSave").click(fn_btnSave);

	fn_tabSetting();
	fn_racerList();
	fn_showFrequency();
	fn_startAJAXcalls();
});