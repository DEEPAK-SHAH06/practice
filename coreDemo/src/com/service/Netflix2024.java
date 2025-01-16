package com.service;

import java.util.List;

import com.model.NetflixModel;
import com.view.Netflix;

public interface Netflix2024 {
	
	void addUserThroughSignUp(NetflixModel user);
	void LoginOldUser();
	void removeUser();
	List<NetflixModel> getAllUSer();
	boolean LoginOldUser(NetflixModel user);
	

}
