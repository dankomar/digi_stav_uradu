package com.hin.spatial.postgis;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.locationtech.jts.geom.MultiPolygon;
import java.io.IOException;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.geojson.GeoJsonReader;

public class MultiPolygonDeserializer extends JsonDeserializer<MultiPolygon> {

    @Override
    public MultiPolygon deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String geoJson = parser.getValueAsString();
        GeoJsonReader reader = new GeoJsonReader();
        try {
            return (MultiPolygon) reader.read(geoJson);
        } catch (ParseException e) {
            throw new IOException(e);
        }
    }
}