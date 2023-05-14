package com.hin.spatial.postgis.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hin.spatial.postgis.GeometryAttributeConverter;
import com.hin.spatial.postgis.MultiPolygonDeserializer;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;
import org.locationtech.jts.geom.MultiPolygon;

@Data
@Entity(name = "obec_0")
public class Obec {

	@Id
	@Column(name="gid")
	private long gid;

	@Column(name="dow")
	private String dow;

	@Column(name="facc")
	private String facc;

	@Column(name="idn4")
	private long idn4;

	@Column(name="nm4")
	private String nm4;

	@Column(name="idn3")
	private long idn3;

	@Column(name="nm3")
	private String nm3;

	@Column(name="idn2")
	private long idn2;

	@Column(name="nm2")
	private String nm2;

	@Column(name="vymera")
	private String vymera;

	@Column(name="nuts1")
	private String nuts1;

	@Column(name="nuts1_code")
	private String nuts1_code;

	@Column(name="nuts2")
	private String nuts2;

	@Column(name="nuts2_code")
	private String nuts2_code;

	@Column(name="nuts3")
	private String nuts3;

	@Column(name="nuts3_code")
	private String nuts3_code;

	@Column(name="lau1")
	private String lau1;

	@Column(name="lau1_code")
	private String lau1_code;

	@Column(name="lau2")
	private String lau2;

	@Column(name="lau2_code")
	private String lau2_code;

	@Column(name="shape_leng")
	private String shape_leng;

	@Column(name="shape_area")
	private String shape_area;

	@Column(columnDefinition = "geometry(MultiPolygon,4326)")
	@JsonDeserialize(using = MultiPolygonDeserializer.class)
	@Convert(converter = GeometryAttributeConverter.class)
	private MultiPolygon geom;


}
