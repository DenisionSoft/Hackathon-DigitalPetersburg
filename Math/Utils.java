package calculations;

import static java.langMath.log10;
import static java.langMath.exp;

public class Coordinates {
    double latitude;
    double longtitude;
}

public class Utils {
    public static double sigmoid(double x, double shrinkBy, double moveX) {
        return 1 / (1 + exp(-x * shrink + moveX));
    }

    public static double distFunction(double distance) {
        return 1 - 0.25 * sigmoid(distance, 5, 4);
    }

    public static double distance(Coordinates c1, Coordinates c2) {
        double lat1Rad = Math.toRadians(c1.latitude);
        double lat2Rad = Math.toRadians(c2.latitude);
        double lon1Rad = Math.toRadians(c1.longtitude);
        double lon2Rad = Math.toRadians(c2.longtitude);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);
        double distance = Math.sqrt(x * x + y * y) * 6371;

        return distance;
    }

    public static double logWithOffset(int x, double offset, double shrinkBy) {
        return log10(x + offset) / shrinkBy;
    }
}