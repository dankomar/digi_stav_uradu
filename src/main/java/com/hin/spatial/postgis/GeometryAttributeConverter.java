package com.hin.spatial.postgis;

import jakarta.persistence.AttributeConverter;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arjen10
 * @date 2023/3/6 14:42
 */
public class GeometryAttributeConverter implements AttributeConverter<Geometry, byte[]> {

    private static final WKBWriter WKB_WRITER = new WKBWriter();

    private static final WKBReader WKB_READER = new WKBReader();

    private static final ReentrantLock WRITE_LOCK = new ReentrantLock();

    private static final ReentrantLock READ_LOCK = new ReentrantLock();

    @Override
    public byte[] convertToDatabaseColumn(Geometry attribute) {
        WRITE_LOCK.lock();
        try {
            //PostGIS's storage format is WKB
            return WKB_WRITER.write(attribute);
        }finally {
            WRITE_LOCK.unlock();
        }
    }

    @Override
    public Geometry convertToEntityAttribute(byte[] dbData) {
        READ_LOCK.lock();
        try {
            return WKB_READER.read(dbData);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            READ_LOCK.unlock();
        }
    }

}