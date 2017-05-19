package functions;

import java.util.List;

/**
 * Created by Anna on 11.05.2017.
 */
public class Spherical implements Function {

    public Double realMin = 0.0;

    public Double evaluate(List<Double> coordinates) {
        return coordinates.stream().map(x -> x * x).reduce(0.0, (a, b) -> (a + b));
    }

    public Double getRealMin() {
        return realMin;
    }

}
