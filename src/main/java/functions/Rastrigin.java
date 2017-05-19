package functions;

import java.util.List;

/**
 * Created by Anna on 19.05.2017.
 */
public class Rastrigin implements Function {
    private Double realMin = 320.0;

    private Double fi(Double x) {
        return x * x - 10.0 * Math.cos(2.0 * Math.PI * x) + 10.0;
    }
    public Double evaluate(List<Double> coordinates) {
        double result = 0.0;
        for (Double c : coordinates) {
            result += fi(c);
        }
        return result;
    }

    public Double getRealMin() {
        return realMin;
    }
}
