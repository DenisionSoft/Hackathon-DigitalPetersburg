package spb.hack.lifeindex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.model.GeoPoint;

@Service
public class GlebService {

    public static double sigmoid(double x, double shrinkBy, double moveX) {
        return 1 / (1 + Math.exp(-x * shrinkBy + moveX));
    }

    public static double distFunction(double distance) {
        return 1 - 0.25 * sigmoid(distance, 5, 4);
    }

    public static double distance(GeoPoint c1, GeoPoint c2) {
        double lat1Rad = Math.toRadians(c1.getLat());
        double lat2Rad = Math.toRadians(c2.getLat());
        double lon1Rad = Math.toRadians(c1.getLon());
        double lon2Rad = Math.toRadians(c2.getLon());

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);

        return Math.sqrt(x * x + y * y) * 6371;
    }

    public static double logWithOffset(int x, double offset, double shrinkBy) {
        return Math.log10(x + offset) / shrinkBy;
    }
}
