package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Marketing;

public interface MarketingService {
	
	void addTeam(Marketing mar);
	void deleteTeam(int index);
	List<Marketing> getAllTeam();
	void addCategory(Marketing catogory);
	

}
