package com.mms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.exception.MobileAlreadyExisted;
import com.mms.model.Mobile;
import com.mms.repository.MobileRepository;

@Service
public class MobileService {
	@Autowired
	private MobileRepository repo;
	
	public List<Mobile> getAllMobilePhone() {
		return repo.findAll();
	}
	public List<Mobile> getByMaker(String maker) {
		return repo.findByMaker(maker);
	}
	public List<Mobile> getByColor(String color) {
		return repo.findByColor(color);
	}
	public List<Mobile> getByModelAndColor(String model ,String color) {
		return repo.findByModelAndColor(model,color);
	}
	public List<Mobile> getByProcessor(Integer processor) {
		return repo.findByProcessor(processor);
	}
	
	
	
	
	
	
	public Mobile saveMobile(Mobile mobile) throws MobileAlreadyExisted {
		if(repo.existsById(mobile.getIme())==true) {
			throw new MobileAlreadyExisted("Mobile with same IME is existed");
		}else {
			return repo.save(mobile);
		}
	}
	
	
	
	public boolean deleteMobile(Long ime) {
		if(repo.existsById(ime)) {
			repo.deleteById(ime);
			return true;
		}else {
			return false;
		}
	}

}
