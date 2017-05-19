package functions;

import java.util.List;

/**
 * Created by Anna on 11.05.2017.
 */
public class Spherical implements Function {

    public Double evaluate(List<Double> cordinates) {
        return cordinates.stream().map(x -> x * x).reduce(0.0, (a, b) -> (a + b));
    }

}
