package com.sv.app.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value={"/streetvendor"})
public class UpsetController {
	/*@Autowired
	VendorService vendorService;
	
	@PostMapping(value="/registervendor",headers="Accept=application/json")
	
	 @ResponseStatus(HttpStatus.CREATED) public ResponseEntity<VendorBean>
	 createUser(@RequestBody @Valid VendorBean vendorBean) throws Exception{
	 VendorBean vb = vendorBean;
	 
	 vendorService.save(vb); 
	 HttpHeaders headers = new HttpHeaders();
	 return new	ResponseEntity<VendorBean>(vendorBean, HttpStatus.CREATED); 
	 
	}
	*/
	@PostMapping(value="/registervendor1",headers="Accept=application/json")
	 
	 @ResponseStatus(HttpStatus.CREATED) public String
	 createUser1(@Valid String code) throws Exception{
	 System.out.println(code);
	 return "Code is"+code;
	}
	 
	/*
	 * @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @ResponseBody
	 * 
	 * @Validated // public ResponseEntity<?>
	 * findByLogin(@Valid @RequestParam(required = true) String
	 * email, @PathParam("password") String password) { public ResponseEntity<?>
	 * findByLogin(@RequestBody ULBMasterBean ub) {
	 * 
	 * // boolean isUserValidate = validator.userLoginValidate(email, password);
	 * System.out.println("==========="+ub.getEmail()); String authToken =
	 * UUID.randomUUID().toString(); int isUserValidate =
	 * userService.setAuthToken(authToken, ub.getEmail(), ub.getPassword());
	 * System.out.println("=====isUserValidate======"+isUserValidate); ULBMasterBean
	 * userBean = new ULBMasterBean(); if(isUserValidate>0) userBean =
	 * userService.userLogin(ub.getEmail(), ub.getPassword());
	 * 
	 * 
	 * if (userBean.getId()==0) {
	 * 
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 * 
	 * } // return new ResponseEntity<UserBean>(HttpStatus.NOT_FOUND); return
	 * ResponseEntity.ok(userBean); }
	 * 
	 * @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<ULBMasterBean> getUserById(@PathVariable("id") long id)
	 * { ULBMasterBean userBean = userService.findById(id); if (userBean == null) {
	 * return new ResponseEntity<ULBMasterBean>(HttpStatus.NOT_FOUND); } return new
	 * ResponseEntity<ULBMasterBean>(userBean, HttpStatus.OK); }
	 * 
	 * @PostMapping(value="/create",headers="Accept=application/json")
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public ResponseEntity<ULBMasterBean>
	 * createUser(@RequestBody @Valid ULBMasterBean userBean) throws Exception{
	 * ULBMasterBean ub = userBean;
	 * 
	 * if(userBean.getPatientBean()!=null) {
	 * userBean.getPatientBean().setUserBean(ub); } else if(userBean.getStaffBean()
	 * != null) { userBean.getStaffBean().setUserBean(ub); } else
	 * if(userBean.getCompanyBean() != null) {
	 * userBean.getCompanyBean().setUserBean(ub); } else {
	 * userBean.getPhysicianBean().setUserBean(ub); }
	 * 
	 * userService.addUser(ub); HttpHeaders headers = new HttpHeaders(); return new
	 * ResponseEntity<ULBMasterBean>(userBean, HttpStatus.CREATED); }
	 * 
	 * @GetMapping(value="/getAll", headers="Accept=application/json")
	 * 
	 * @ResponseBody public List<ULBMasterBean> getAllUser() { String token =
	 * UUID.randomUUID().toString(); List<ULBMasterBean>
	 * tasks=userService.getUser();
	 * 
	 * return tasks;
	 * 
	 * }
	 * 
	 * @PutMapping(value="/update", headers="Accept=application/json") public
	 * ResponseEntity<ULBMasterBean> updateUser(@RequestBody ULBMasterBean userBean,
	 * UriComponentsBuilder ucBuilder) throws Exception{ ULBMasterBean ub =
	 * userBean; if(userBean.getPatientBean()!=null) {
	 * userBean.getPatientBean().setUserBean(ub); } else if(userBean.getStaffBean()
	 * != null) { userBean.getStaffBean().setUserBean(ub); } else
	 * if(userBean.getCompanyBean() != null) {
	 * userBean.getCompanyBean().setUserBean(ub); } else {
	 * userBean.getPhysicianBean().setUserBean(ub); }
	 * 
	 * userService.update(ub); HttpHeaders headers = new HttpHeaders(); return new
	 * ResponseEntity<ULBMasterBean>(userBean,HttpStatus.OK); }
	 * 
	 * 
	 * @DeleteMapping(value="/{id}", headers ="Accept=application/json") public
	 * ResponseEntity<ULBMasterBean> deleteUser(@PathVariable("id") long id){
	 * ULBMasterBean userBean = userService.findById(id); if (userBean == null) {
	 * return new ResponseEntity<ULBMasterBean>(HttpStatus.NOT_FOUND); }
	 * userService.deleteUserById(id); return new
	 * ResponseEntity<ULBMasterBean>(HttpStatus.NO_CONTENT); }
	 */
	
	
}
