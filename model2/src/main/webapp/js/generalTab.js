"use strict";
// generalTab

const fn_tabSetting = function () {
	let currentTab = "";

	$(".tabcontent > div").hide();
	$(".idTabs a").click(function () {
		if (currentTab === $(this)[0].hash) {
			return false;
		}

		currentTab = $(this)[0].hash;

		$(".tabcontent > div").hide().filter(this.hash).fadeIn();
		$(".idTabs a").removeClass("act");
		$(this).addClass("act");

		try {
			fn_tabClickCallBack(currentTab);
		} catch (error) {
			console.error(error);
		}

		return false;
	}).filter(":eq(0)").click();
};