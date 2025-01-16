package com.service;

import java.util.List;

import com.model.Electronics;

public interface ElectronicsService {
	
	void addElectronics(Electronics ele);
	void removeElectronics(int index);
	List<Electronics>  getAllElectronics();

}
