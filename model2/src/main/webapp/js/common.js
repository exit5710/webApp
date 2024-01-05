'use strict';
// common

const fn_getRandom = function (number) {
	// 0 ~ number - 1
	return Math.floor(Math.random() * number);
};

const fn_getDate = function () {
	const date = new Date();

	let year = date.getFullYear();
	let month = fn_zeroAdd(date.getMonth() + 1);
	let day = fn_zeroAdd(date.getDate());

	return year + '-' + month + '-' + day;
};

const fn_getTime = function (type) {
	const date = new Date();

	//A.M. Ante meridiem, P.M. Post meridiem
	let meridiem = '';
	let hours = date.getHours(); // 새벽 12시는 0
	let minutes = fn_zeroAdd(date.getMinutes());
	let seconds = fn_zeroAdd(date.getSeconds());

	if (type === 12) {
		(hours < 11) ? meridiem = 'AM ' : meridiem = 'PM ';
		hours = (hours - 12 <= 0) ? fn_zeroAdd(hours) : fn_zeroAdd(hours - 12);
	} else {
		hours = fn_zeroAdd(hours);
	}

	return meridiem + hours + ':' + minutes + ':' + seconds;
};

const fn_zeroAdd = function (number) {
	number = (number < 10) ? '0' + number : number;

	return number;
};

const fn_submit = function (url, data, dataType, async, callBack) {
	$.ajax({ // https://cofs.tistory.com/402
		type: 'POST',
		url: url,
		data: data, // {data : JSON.stringify(data)}
		dataType: dataType,
		cache: false,
		async: async,
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8', //application/json; charset=utf-8
		success: function (response) {
			return callBack(response);
		},
		error: function (request, status, error) {
			console.log('code : ' + request.status + '\n' + 'message : ' + request.responseText + '\n' + 'error : ' + error);
		},
		complete: function (data, textStatus) {
			console.log('fn_submit complete, dataType : ' + dataType + ' ' + data.statusText + '/' + textStatus);
		}
	});
};

$.fn.serializeObject = function () {
	let result = {};
	let extend = function (i, element) {
		let node = result[element.name];

		if ('undefined' !== typeof node && node !== null) {
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