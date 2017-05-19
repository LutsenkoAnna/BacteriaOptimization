import algorithm.CandidatesManipulator;
import functions.Rastrigin;
import functions.Rozenbrok;
import functions.Spherical;

/**
 * Created by Anna on 11.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        CandidatesManipulator candidatesManipulator = new CandidatesManipulator();
        try {
            candidatesManipulator.solve(new Rastrigin());
        } catch (Exception e) {
        }
    }
}
