package functions;

import java.util.List;

/**
 * Created by Anna on 19.05.2017.
 */
public class Rozenbrok implements Function{

    private Double realMin = 380.0;

    private Double fi(Double x1, Double x2) {
        return 100 * Math.pow(x1 * x1 - x2, 2) + Math.pow(x1 - 1.0, 2);
    }
    public Double evaluate(List<Double> coordinates) {
        double result = 0.0;
        for (int i = 0; i < coordinates.size() - 1; ++i) {
            result += fi(coordinates.get(i), coordinates.get(i + 1));
        }
        return result;
    }

    public Double getRealMin() {
        return realMin;
    }
}
