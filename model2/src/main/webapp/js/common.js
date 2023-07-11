"use strict";
// common

const getRandom = function (number) {
	return Math.floor(Math.random() * number);
};

const getDate = function () {
	const date = new Date();
	let year = date.getFullYear();
	let month = zeroAdd(date.getMonth() + 1);
	let day = zeroAdd(date.getDate());

	return year + "-" + month + "-" + day;
};

const getTime = function (type) {
	const date = new Date();

	//A.M. Ante meridiem, P.M. Post meridiem
	let meridiem = "";
	let hours = date.getHours(); // 새벽 12시는 0
	let minutes = zeroAdd(date.getMinutes());
	let seconds = zeroAdd(date.getSeconds());

	if (type === 12) {
		(hours < 11) ? meridiem = "AM " : meridiem = "PM ";
		hours = (hours - 12 <= 0) ? zeroAdd(hours) : zeroAdd(hours - 12);
	} else {
		hours = zeroAdd(hours);
	}

	return meridiem + hours + ":" + minutes + ":" + seconds;
};

const zeroAdd = function (number) {
	number = (number < 10) ? "0" + number : number;

	return number;
};

const fn_searchSubmit = function (url, data, callBack) {
	$.ajax({
		type: "POST",
		url: url,
		data: data,
		dataType: "json",
		cache: false,
		async: true,
		contentType: "application/x-www-form-urlencoded; charset=utf-8", //application/json; charset=utf-8
		beforeSend: function (xhr, opts) {
			return true; // false 전송 취소
		},
		success: function (response) {
			return callBack(response)
		},
		error: function (request, status, error) {
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		},
		complete: function (data, textStatus) {
			console.log("fn_searchSubmit complete : " + data.statusText + "/" + textStatus);
		}
	});
};

const fn_saveSubmit = function (url, data, async, callBack) {
	$.ajax({ // https://cofs.tistory.com/402
		type: "POST",
		url: url,
		data: data, // {data : JSON.stringify(data)}
		dataType: "text", //"json" - data의 값이 이미 json이기 때문에 json 변경없이 text로 하는듯...
		cache: false,
		async: async,
		contentType: "application/x-www-form-urlencoded; charset=utf-8", //application/json; charset=utf-8
		success: function (response) {
			return callBack(response);
		},
		error: function (request, status, error) {
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		},
		complete: function (data, textStatus) {
			console.log("fn_saveSubmit complete : " + data.statusText + "/" + textStatus);
		}
	});
};

$.fn.serializeObject = function () {
	let result = {};
	let extend = function (i, element) {
		let node = result[element.name];

		if ("undefined" !== typeof node && node !== null) {
			if ($.isArray(node)) {
				node.push(element.value);
			} else {
				result[element.name] = [node, element.value];
			}
		} else {
			result[element.name] = element.value;
		}
	};

	$.each(this.serializeArray(), extend);

	//return JSON.stringify(result); // return result;
	return JSON.parse(JSON.stringify(result));
};