package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.UserBean;
import com.sv.app.repository.UserRepository;
import com.sv.app.service.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;

	public UserBean addUser(UserBean userBean) {
		// TODO Auto-generated method stub
		return userRepository.save(userBean);
	}

	public List<UserBean> getUser() {
		// TODO Auto-generated method stub
		return (List<UserBean>) userRepository.findAll();
	}

	public UserBean findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	public UserBean update(UserBean userBean) {
		// TODO Auto-generated method stub
		return userRepository.save(userBean);
	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	public UserBean updatePartially(UserBean userBean, long id) {
		// TODO Auto-generated method stub
		UserBean usr = findById(id);
		return userRepository.save(usr);
	}

	@Override
	public UserBean userLogin(String email, String password) {
	return userRepository.findByLogin(email, password);
	}
	
	@Override
	public int setAuthToken(String authToken, String email, String password)
	{
		int userValidate;
		userValidate = userRepository.setToken(authToken, email, password);
		return userValidate;
	}



}
