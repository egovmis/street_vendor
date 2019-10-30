package com.sv.app.service;

import java.util.List;

import com.sv.app.bean.UserBean;


public interface UserService{
	public UserBean addUser(UserBean userBean);
	public List<UserBean> getUser();
	public UserBean userLogin(String email, String password);
	public int setAuthToken(String authToken, String email, String password);
	public UserBean findById(long id);
	public UserBean update(UserBean userBean);
	public void deleteUserById(long id);
	public UserBean updatePartially(UserBean userBean, long id);
}
