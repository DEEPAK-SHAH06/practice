package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Marketing;

public class MarketingServiceImpl implements MarketingService{

	static List<Marketing> mlist = new ArrayList<>();
	@Override
	public void addTeam(Marketing mar){
		// TODO Auto-generated method stub
		mlist.add(mar);
		
	}

	@Override
	public void deleteTeam(int index) {
		// TODO Auto-generated method stub
		mlist.remove(0);
		
	}

	
	@Override
	public void addCategory(Marketing category) {
		// TODO Auto-generated method stub
		mlist.add(category);
		
	}

	@Override
	public List<Marketing> getAllTeam() {
		// TODO Auto-generated method stub
		return mlist;
	}

}
