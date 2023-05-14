package com.hin.spatial.postgis.database;

import jakarta.persistence.Column;

import java.util.List;

public class ObecDO {
    private long gid;

    private String dow;

    private String facc;

    private long idn4;

    private String nm4;

    private long idn3;

    private String nm3;

    private long idn2;

    private String nm2;

    private String vymera;

    private String nuts1;

    private String nuts1_code;

    private String nuts2;

    private String nuts2_code;

    private String nuts3;

    private String nuts3_code;

    private String lau1;

    private String lau1_code;

    private String lau2;

    private String lau2_code;

    private String shape_leng;

    private String shape_area;

    private byte[] geom;

    public ObecDO(long gid, String dow, String facc, long idn4, String nm4, long idn3, String nm3, long idn2, String nm2, String vymera,
                  String nuts1, String nuts1_code, String nuts2, String nuts2_code, String nuts3, String nuts3_code, String lau1, String lau1_code,
                  String lau2, String lau2_code, String shape_leng, String shape_area, byte[] geom) {
        this.gid = gid;
        this.dow = dow;
        this.facc = facc;
        this.idn4 = idn4;
        this.nm4 = nm4;
        this.idn3 = idn3;
        this.nm3 = nm3;
        this.idn2 = idn2;
        this.nm2 = nm2;
        this.vymera = vymera;
        this.nuts1 = nuts1;
        this.nuts1_code = nuts1_code;
        this.nuts2 = nuts2;
        this.nuts2_code = nuts2_code;
        this.nuts3 = nuts3;
        this.nuts3_code = nuts3_code;
        this.lau1 = lau1;
        this.lau1_code = lau1_code;
        this.lau2 = lau2;
        this.lau2_code = lau2_code;
        this.shape_leng = shape_leng;
        this.shape_area = shape_area;
        this.geom = geom;
    }

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public String getFacc() {
        return facc;
    }

    public void setFacc(String facc) {
        this.facc = facc;
    }

    public long getIdn4() {
        return idn4;
    }

    public void setIdn4(long idn4) {
        this.idn4 = idn4;
    }

    public String getNm4() {
        return nm4;
    }

    public void setNm4(String nm4) {
        this.nm4 = nm4;
    }

    public long getIdn3() {
        return idn3;
    }

    public void setIdn3(long idn3) {
        this.idn3 = idn3;
    }

    public String getNm3() {
        return nm3;
    }

    public void setNm3(String nm3) {
        this.nm3 = nm3;
    }

    public long getIdn2() {
        return idn2;
    }

    public void setIdn2(long idn2) {
        this.idn2 = idn2;
    }

    public String getNm2() {
        return nm2;
    }

    public void setNm2(String nm2) {
        this.nm2 = nm2;
    }

    public String getVymera() {
        return vymera;
    }

    public void setVymera(String vymera) {
        this.vymera = vymera;
    }

    public String getNuts1() {
        return nuts1;
    }

    public void setNuts1(String nuts1) {
        this.nuts1 = nuts1;
    }

    public String getNuts1_code() {
        return nuts1_code;
    }

    public void setNuts1_code(String nuts1_code) {
        this.nuts1_code = nuts1_code;
    }

    public String getNuts2() {
        return nuts2;
    }

    public void setNuts2(String nuts2) {
        this.nuts2 = nuts2;
    }

    public String getNuts2_code() {
        return nuts2_code;
    }

    public void setNuts2_code(String nuts2_code) {
        this.nuts2_code = nuts2_code;
    }

    public String getNuts3() {
        return nuts3;
    }

    public void setNuts3(String nuts3) {
        this.nuts3 = nuts3;
    }

    public String getNuts3_code() {
        return nuts3_code;
    }

    public void setNuts3_code(String nuts3_code) {
        this.nuts3_code = nuts3_code;
    }

    public String getLau1() {
        return lau1;
    }

    public void setLau1(String lau1) {
        this.lau1 = lau1;
    }

    public String getLau1_code() {
        return lau1_code;
    }

    public void setLau1_code(String lau1_code) {
        this.lau1_code = lau1_code;
    }

    public String getLau2() {
        return lau2;
    }

    public void setLau2(String lau2) {
        this.lau2 = lau2;
    }

    public String getLau2_code() {
        return lau2_code;
    }

    public void setLau2_code(String lau2_code) {
        this.lau2_code = lau2_code;
    }

    public String getShape_leng() {
        return shape_leng;
    }

    public void setShape_leng(String shape_leng) {
        this.shape_leng = shape_leng;
    }

    public String getShape_area() {
        return shape_area;
    }

    public void setShape_area(String shape_area) {
        this.shape_area = shape_area;
    }

    public byte[] getGeom() {
        return geom;
    }

    public void setGeom(byte[] geom) {
        this.geom = geom;
    }
}
