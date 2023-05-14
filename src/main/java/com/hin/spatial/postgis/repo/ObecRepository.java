package com.hin.spatial.postgis.repo;

import java.util.List;
import java.util.stream.Collectors;

import com.hin.spatial.postgis.database.ObecDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hin.spatial.postgis.model.Obec;
import com.vividsolutions.jts.geom.Point;


@Repository
public interface ObecRepository extends JpaRepository<Obec, Long>{

	@Query(value="SELECT * from us_cities where ST_DistanceSphere(geom, :p) < :distanceM", nativeQuery = true)
	List<Obec> findNearWithinDistance(Point p, double distanceM);

	@Query(value = "SELECT new com.hin.spatial.postgis.database.ObecDO(gid, dow, facc, idn4, nm4, idn3,  nm3, idn2, nm2, vymera, nuts1, nuts1_code, nuts2, nuts2_code, nuts3, nuts3_code, lau1, lau1_code, lau2, lau2_code, shape_leng, shape_area, ST_AsBinary(ST_GeomFromWKB(geom))) FROM obec_0")
	List<ObecDO> findAllMultiPolygonAsGeomWkb();

	@Query(value = "SELECT new com.hin.spatial.postgis.database.ObecDO(gid, dow, facc, idn4, nm4, idn3,  nm3, idn2, nm2, vymera, nuts1, nuts1_code, nuts2, nuts2_code, nuts3, nuts3_code, lau1, lau1_code, lau2, lau2_code, shape_leng, shape_area, ST_AsBinary(ST_GeomFromWKB(geom))) FROM obec_0 where nm4 = :name")
	List<ObecDO> findObecByNameAsGeomWkb(String name);
}
