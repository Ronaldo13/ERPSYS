package com.hqyj.service.xsh;

import javax.servlet.http.HttpServletRequest;

public interface SellOrderMannagementService {

	void queryAllSellOrder(HttpServletRequest request);

	void deleteSellOrderByBuyLogId(HttpServletRequest request);

	void querySellOrderByOrderId(HttpServletRequest request);

	void queryUpdateSellOrderByOrderId(HttpServletRequest request);


}
