"use strict";
// generalTab

const fn_tabSetting = function () {
	$('.tabcontent > div').hide();
	$('.idTabs a').click(function () {
		$('.tabcontent > div').hide().filter(this.hash).fadeIn();
		$('.idTabs a').removeClass('act');
		$(this).addClass('act');

		try {
			fn_tabClickCallBack($(this)[0].hash);
		} catch {
		}

		return false;
	}).filter(':eq(0)').click();
};