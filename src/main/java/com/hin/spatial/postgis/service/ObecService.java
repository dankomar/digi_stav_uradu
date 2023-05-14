package com.hin.spatial.postgis.service;

import java.util.List;

import com.hin.spatial.postgis.database.ObecDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hin.spatial.postgis.model.Obec;
import com.hin.spatial.postgis.repo.ObecRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ObecService {

	@Autowired
	private ObecRepository repo;
	
	// WGS-84 SRID
	private GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);
	
	public List<ObecDO> findAll(){
		return repo.findAllMultiPolygonAsGeomWkb();
	}
	public List<ObecDO> findByName(String name){
		return repo.findObecByNameAsGeomWkb(name);
	};
	
	public List<Obec> findAround(double lat, double lon, double distanceM){
		log.info("Looking for city around ({},{}) withing {} meters", lat, lon, distanceM);
		Point p = factory.createPoint(new Coordinate(lon, lat));
		return repo.findNearWithinDistance(p, distanceM);
	}
}
