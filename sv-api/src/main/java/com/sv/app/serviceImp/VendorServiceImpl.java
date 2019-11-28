package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.app.bean.ApplicationStatusBean;
import com.sv.app.bean.EmployeeBean;
import com.sv.app.bean.ULBMasterBean;
import com.sv.app.bean.VendorBean;
import com.sv.app.repository.VendorRepository;
import com.sv.app.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	VendorRepository vendorRepository;
	@Override
	public List<VendorBean> findVendor(ULBMasterBean ulbBean) {
		return (List<VendorBean>) vendorRepository.findVendor(ulbBean.getUlbCode());
	}

	@Override
	public List<VendorBean> findVendorByRequestParam(VendorBean vendorBean,ULBMasterBean ulbBean) {
		return (List<VendorBean>) vendorRepository.findVendorByRequestParam(vendorBean.getVendorId(), vendorBean.getName(), vendorBean.getMobileNo(),ulbBean.getUlbCode());
	}

	@Override
	public VendorBean save(VendorBean vendorBean) {
		return (VendorBean) vendorRepository.save(vendorBean);
	}

	@Override
	public VendorBean findVendorById(int vendorID) {
		return (VendorBean) vendorRepository.findById(vendorID);
	}
	/*
	 * @Override public int getNextSequence(String sequenceName) { return
	 * vendorRepository.getNextSequence(sequenceName); }
	 * 
	 * @Override public void createSequence(String sequenceName) {
	 * vendorRepository.createSequence(sequenceName);
	 * 
	 * }
	 */

	@Override
	public List<VendorBean> getVendorByEmployeeandStatus(ULBMasterBean ulBean, ApplicationStatusBean status) {
		return (List<VendorBean>) vendorRepository.getVendorByEmployeeandStatus(ulBean.getUlbCode(),status.getStatusCode());
	}

	@Override
	public void update(VendorBean response) {
		vendorRepository.update(response.getVendorId(),response.getApplicationStatus().getStatusCode());
	}
	
	@Override
	public void updateForApproval(VendorBean response) {
		vendorRepository.updateForApproval(response.getVendorId(),response.getApplicationStatus().getStatusCode(),response.getValidFrom(),response.getValidTill(),response.getAllocatedZone().getVendingZoneCode(),response.getAllocatedVendingCategory().getCategoryName(),response.getDateOfApproval());
	}
	@Override
	public void updateForFeePayment(VendorBean response) {
		vendorRepository.updateForFeePayment(response.getVendorId(),response.getApplicationStatus().getStatusCode(),response.getRegistrationNo(),response.getReceiptNumber(),response.getReceiptDate(),response.getPaymentStatus());
	}

	@Override
	public Boolean searchMobile(String mobile_number,ULBMasterBean ulbBean) {
		VendorBean vendorBean=new VendorBean();
		vendorBean.setMobileNo(mobile_number);
		List<VendorBean> list=vendorRepository.findVendorByRequestParam(vendorBean.getVendorId(), vendorBean.getName(), vendorBean.getMobileNo(),ulbBean.getUlbCode());
		if(list.isEmpty() && list.size()==0)
			return true;
		else
			return false;
	}
	
	/*
	 * @Override public List<VendorBean> getVendorByEmployeeandStatus(EmployeeBean
	 * employeeBean, ApplicationStatusBean status) { return (List<VendorBean>)
	 * vendorRepository.getVendorByEmployeeandStatus(employeeBean.getEmpId(),status.
	 * getStatusCode()) }
	 */

	/*
	 * @Override public VendorBean update(VendorBean vendorBean) { return
	 * (VendorBean) vendorRepository.update(vendorBean); }
	 */
}
