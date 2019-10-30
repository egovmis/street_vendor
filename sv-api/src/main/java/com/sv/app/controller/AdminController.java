package com.sv.app.controller;
//package com.medical.app.controller;
//
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.medical.app.bean.AdminBean;
//import com.medical.app.bean.CompanyBean;
//import com.medical.app.bean.PatientBean;
//import com.medical.app.bean.PhysicianBean;
//import com.medical.app.bean.UserBean;
//import com.medical.app.service.AdminService;
//import com.medical.app.service.CompanyService;
//import com.medical.app.service.PatientService;
//import com.medical.app.service.PhysicianService;
//import com.medical.app.service.StaffService;
//import com.medical.app.service.UserService;
//
//@RestController
//@RequestMapping(value={"/admin"})
//public class AdminController {
//	
//	@AutowiredI
//	AdminService adminService;	
//	
//	@Autowired
//	PatientService patientService;
//	
//	@Autowired
//	UserService userService;
//	
//	@Autowired
//	PhysicianService physicianService;
//	
//	@Autowired
//	CompanyService companyService;
//	
//	@Autowired
//	StaffService staffService;
//	
//	
//	   @GetMapping(value = "/login/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
//	    @ResponseBody
//	    public ResponseEntity<AdminBean> findByLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
////	       boolean isUserValidate = validator.userLoginValidate(email, password);
//		   String authToken = UUID.randomUUID().toString();
//	       int isUserValidate = adminService.setAuthToken(authToken, email, password);
//	       AdminBean admin = new AdminBean();
//	        if(isUserValidate>0)
//	        	admin = adminService.adminLogin(email, password);
//		
//			  if (admin != null) 
//			  {
//				  return new ResponseEntity<AdminBean>(admin, HttpStatus.OK);
//			  }
//			  return new ResponseEntity<AdminBean>(HttpStatus.NOT_FOUND);
//	    }
//	   
//	   
//	   @GetMapping(value = "/patient-list", produces = MediaType.APPLICATION_JSON_VALUE)
//	    @ResponseBody
//	    public List<PatientBean> findAllPatients() {
//	        	List<PatientBean> patient = patientService.findAllPatient();
//				  return patient;
//			  
//	    }
//
//	   
//	   @PostMapping(value="/add-patient",headers="Accept=application/json")
//		 public ResponseEntity<Void> addPatient(@RequestBody UserBean userBean, @RequestBody PatientBean patientBean, UriComponentsBuilder ucBuilder){
//		     System.out.println("Creating User ");
//		     userService.addUser(userBean);
//		     patientService.addPatient(patientBean);
//		     HttpHeaders headers = new HttpHeaders();
////		     headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(patientBean).toUri());
//		     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//		 }
//	   
//	   
//	   @GetMapping(value = "/physician-list", produces = MediaType.APPLICATION_JSON_VALUE)
//	    @ResponseBody
//	    public List<PhysicianBean> findAllPhysician() {
//	        	List<PhysicianBean> patient = physicianService.findAllPhysician();
//				  return patient;
//			  
//	    }
//	   
//	   @GetMapping(value = "/staff-list", produces = MediaType.APPLICATION_JSON_VALUE)
//	    @ResponseBody
//	    public List<PhysicianBean> findAllStaff() {
//	        	List<PhysicianBean> patient = physicianService.findAllPhysician();
//				  return patient;
//			  
//	    }
//	   
//	   @GetMapping(value = "/company-list", produces = MediaType.APPLICATION_JSON_VALUE)
//	    @ResponseBody
//	    public List<CompanyBean> findAllCompany() {
//	        	List<CompanyBean> patient = companyService.findAllCompany();
//				  return patient;
//			  
//	    }
//}