package functions;

import java.util.List;

/**
 * Created by Anna on 11.05.2017.
 */
public interface Function {
    public Double evaluate(List<Double> coordinates);

    public Double getRealMin();
}