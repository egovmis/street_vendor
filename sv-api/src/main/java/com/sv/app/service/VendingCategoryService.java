package com.sv.app.service;

import java.util.List;

import com.sv.app.bean.VendingCategoryBean;

public interface VendingCategoryService {

	public List<VendingCategoryBean> getAllVendingCategory();

	public VendingCategoryBean getVendingZoneByName(String name);
}
