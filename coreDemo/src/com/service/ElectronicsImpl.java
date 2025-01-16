package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Electronics;

public class ElectronicsImpl implements ElectronicsService{

	static List<Electronics> elist = new ArrayList<>();
	@Override
	public void addElectronics(Electronics ele) {
		elist.add(ele);
	}

	@Override
	public void removeElectronics(int index) {
		elist.remove(0);
		
	}

	@Override
	public List<Electronics> getAllElectronics() {
		return elist;
	}

}
