package com.mms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mms.model.Mobile;
import com.mms.repository.MobileRepository;
import com.mms.service.MobileService;
import lombok.Setter;
import lombok.Getter;

@RestController
@RequestMapping("api/v1")
public class MobileController {
	@Autowired
	private MobileRepository mobRepo;

	@Autowired
	private MobileService mobServ;

	@GetMapping("/mobiles")
	public ResponseEntity<List<Mobile>> getAllMobiles() {
		return new ResponseEntity<List<Mobile>>(mobServ.getAllMobilePhone(), HttpStatus.OK);
	}

	@GetMapping("/mobiles/maker/{maker}")
	public ResponseEntity<List<Mobile>> getAllMobilesByMaker(@PathVariable String maker) {
		List<Mobile> list = mobServ.getByMaker(maker);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Mobile>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Mobile>>(list, HttpStatus.OK);
	}

	@GetMapping("/mobiles/color/{color}")
	public ResponseEntity<List<Mobile>> getAllMobilesByColor(@PathVariable String color) {
		List<Mobile> list = mobServ.getByColor(color);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Mobile>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Mobile>>(list, HttpStatus.OK);
	}

	@GetMapping("/mobiles/processor/{processor}")
	public ResponseEntity<List<Mobile>> getAllMobilesByProcessor(@PathVariable Integer processor) {
		List<Mobile> list = mobServ.getByProcessor(processor);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Mobile>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Mobile>>(list, HttpStatus.OK);
	}

	@GetMapping("/mobiles/processorgreaterthan/{value}")
	public ResponseEntity<List<Mobile>> getAllMobilesByProcessor(@PathVariable int value) {
		List<Mobile> list = mobRepo.findByProcessor(value);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Mobile>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Mobile>>(list, HttpStatus.OK);
	}

	@GetMapping("/mobiles/pricerange/{value1}/{value2}")
	public ResponseEntity<List<Mobile>> getAllMobilesByPice(@PathVariable int value1, @PathVariable int value2) {
		List<Mobile> list = mobRepo.findByPriceRange(value1, value2);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Mobile>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Mobile>>(list, HttpStatus.OK);
	}

	@GetMapping("/mobiles/{model}/{color}")
	public ResponseEntity<List<Mobile>> getAllMobilesByModelAndColor(@PathVariable String model,
			@PathVariable String color) {
		List<Mobile> list = mobServ.getByModelAndColor(model, color);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Mobile>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Mobile>>(list, HttpStatus.OK);
	}

	@PostMapping("/mobile")
	public ResponseEntity<Object> addMobile(@RequestBody Mobile mobile) {
		try {
			Mobile obj = mobServ.saveMobile(mobile);
			return new ResponseEntity<Object>(obj, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}

	}

	
	  @PutMapping("/mobile/{ime}") public ResponseEntity<Mobile>
	  updateMobile(@PathVariable Long ime , @RequestBody Mobile mobile) throws
	  Exception{ Mobile mob = mobRepo.findById(ime) .orElseThrow(() -> new
	  Exception("No Mobile of IME: "+ime+" is found :(("));
	  
	  mob.setMaker(mobile.getMaker()); mob.setCamera(mobile.getCamera());
	  mob.setColor(mobile.getColor()); mob.setModel(mobile.getModel());
	  mob.setPrice(mobile.getPrice()); mob.setProcessor(mobile.getProcessor());
	  
	  Mobile updatedMob = mobRepo.save(mob); return ResponseEntity.ok(updatedMob);
	  }
	  
	 

	@DeleteMapping("/mobile/{ime}")
	public ResponseEntity<String> deleteMobile(@PathVariable Long ime) {
		if (mobServ.deleteMobile(ime)) {
			return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("UnableToDelete :Mobile with IME :" + ime + " Not found",
					HttpStatus.NOT_FOUND);
		}
	}

}
