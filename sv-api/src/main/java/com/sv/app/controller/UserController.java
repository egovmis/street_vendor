package com.sv.app.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sv.app.bean.UserBean;
import com.sv.app.service.UserService;


@RestController
@RequestMapping(value={"/user"})
public class UserController {
	@Autowired
	UserService userService;
	
	
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Validated
//  public ResponseEntity<?> findByLogin(@Valid @RequestParam(required = true) String email, @PathParam("password") String password) {
   public ResponseEntity<?> findByLogin(@RequestBody UserBean ub) {

    	//       boolean isUserValidate = validator.userLoginValidate(email, password);
    	System.out.println("==========="+ub.getEmail());
       String authToken = UUID.randomUUID().toString();
       int isUserValidate = userService.setAuthToken(authToken, ub.getEmail(), ub.getPassword());
   	System.out.println("=====isUserValidate======"+isUserValidate);
       UserBean userBean = new UserBean();
        if(isUserValidate>0)
        userBean = userService.userLogin(ub.getEmail(), ub.getPassword());	
		
	
		  if (userBean.getId()==0) 
		  {
			
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			  
		  }
//		  return new ResponseEntity<UserBean>(HttpStatus.NOT_FOUND);
		  return ResponseEntity.ok(userBean);
    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserBean> getUserById(@PathVariable("id") long id) {
        UserBean userBean = userService.findById(id);
        if (userBean == null) {
            return new ResponseEntity<UserBean>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserBean>(userBean, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	  @ResponseStatus(HttpStatus.CREATED)
	 public ResponseEntity<UserBean> createUser(@RequestBody @Valid UserBean userBean) throws Exception{
	     UserBean ub = userBean;

	     if(userBean.getPatientBean()!=null)
	     {
	    	userBean.getPatientBean().setUserBean(ub);
	     }
	     else if(userBean.getStaffBean() != null)
	     {
	    	userBean.getStaffBean().setUserBean(ub);
	     }
	     else if(userBean.getCompanyBean() != null)
	     {
	    	 userBean.getCompanyBean().setUserBean(ub);
	     }
	     else
	     {
	    	 userBean.getPhysicianBean().setUserBean(ub);
	     }
	    
	     userService.addUser(ub);
	     HttpHeaders headers = new HttpHeaders();
	     return new ResponseEntity<UserBean>(userBean, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/getAll", headers="Accept=application/json")
	 @ResponseBody
	 public List<UserBean> getAllUser() {
		 String token = UUID.randomUUID().toString();
	  List<UserBean> tasks=userService.getUser();
	
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<UserBean> updateUser(@RequestBody UserBean userBean, UriComponentsBuilder ucBuilder) throws Exception{
	     UserBean ub = userBean;
	     if(userBean.getPatientBean()!=null)
	     {
	    	userBean.getPatientBean().setUserBean(ub);
	     }
	     else if(userBean.getStaffBean() != null)
	     {
	    	userBean.getStaffBean().setUserBean(ub);
	     }
	     else if(userBean.getCompanyBean() != null)
	     {
	    	 userBean.getCompanyBean().setUserBean(ub);
	     }
	     else
	     {
	    	 userBean.getPhysicianBean().setUserBean(ub);
	     }
	    
	     userService.update(ub);
	     HttpHeaders headers = new HttpHeaders();
	     return new ResponseEntity<UserBean>(userBean,HttpStatus.OK);
	 }

	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<UserBean> deleteUser(@PathVariable("id") long id){
		UserBean userBean = userService.findById(id);
		if (userBean == null) {
			return new ResponseEntity<UserBean>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<UserBean>(HttpStatus.NO_CONTENT);
	}
	
	
}
