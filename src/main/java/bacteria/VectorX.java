package bacteria;

/**
 * Created by Anna on 17.03.2017.
 */
import java.util.*;

public class VectorX {
    private ArrayList<PointU> X = new ArrayList<PointU>();
    int size;

    VectorX(int size) {
        initialize(size);
    }

    private void initialize(int size) {
        for (int i = 0; i < size; ++i) {
            PointU u = new PointU();
            X.add(u);
        }
    }
}
