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