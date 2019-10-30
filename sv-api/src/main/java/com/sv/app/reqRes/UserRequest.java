package com.sv.app.reqRes;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.coyote.RequestInfo;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sv.app.bean.ULBMasterBean;

import lombok.Data;

public @Data class UserRequest {
	
	
	  @Valid
	  @JsonProperty("RequestInfo") // 
	  private RequestInfo requestInfo = new RequestInfo(null);
	  @Valid
	  
	  @NotEmpty private List<ULBMasterBean> vendors = new ArrayList<>();
	 
}
