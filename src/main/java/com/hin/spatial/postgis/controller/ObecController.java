package com.hin.spatial.postgis.controller;

import java.util.List;

import com.hin.spatial.postgis.database.ObecDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hin.spatial.postgis.model.Obec;
import com.hin.spatial.postgis.service.ObecService;

@RestController
@RequestMapping("obec")
public class ObecController {

	@Autowired
	private ObecService service;
	
	@GetMapping
	public List<ObecDO> getObecPage(){
		return service.findAll();
	}

	@GetMapping("{name}")
	public List<ObecDO> getObecByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@GetMapping("{lat}/{lon}/{distanceM}")
	public List<Obec> getCityNear(
			@PathVariable double lat, 
			@PathVariable double lon, 
			@PathVariable double distanceM){
		return service.findAround(lat, lon, distanceM);
	}


	
}
