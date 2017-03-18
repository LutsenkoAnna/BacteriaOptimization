package bacteria;

/**
 * Created by Anna on 18.03.2017.
 */
import java.util.*;

public class PointU {
    double xMinus;
    double xPlus;

    public PointU() {
        Random randNumber = new Random();
        xMinus = randNumber.nextDouble();
        xPlus = randNumber.nextDouble();
    }
}
