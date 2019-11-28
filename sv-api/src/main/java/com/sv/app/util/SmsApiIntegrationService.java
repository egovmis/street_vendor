package com.sv.app.util;


import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class SmsApiIntegrationService {

boolean status = false;
	OkHttpClient client = new OkHttpClient();
	Response response;
	public boolean smsCallService(String mobileNo, String msg) {
		try {
	Request request = new Request.Builder()
	  .url("http://13.127.211.3:8080/sms-api/send-sms?mobileNo="+mobileNo+"&messageText="+msg)
	  .get()
	  .build();
	response = client.newCall(request).execute();
	if(response.message().equals("OK")){
		status = true;		
	}
	else
	{
		status = false;
	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return status;
	}
	
	

}
