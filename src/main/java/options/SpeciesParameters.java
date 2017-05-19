package options;

import java.util.Random;

/**
 * Created by Anna on 11.05.2017.
 */
public class SpeciesParameters {
    public static Random generator = new Random(0); //0 for testing purposes
    public static int candidatesNumber = 50;
    public static double minRange = -5;
    public static double maxRange = 5;
    public static int dimensions = 2;
    public static int chemotaxisNumber = 10;
    public static int swimNumber = 10;
    public static int reproductionNumber = 10;
    public static int eliminationAndDispersalNumber = 10;
    public static double chemotaxisStep = 0.1;
    public static double possibility = 0.25;
    public static double dAttr = 0.1;
    public static double wAttr = 0.2;
    public static double hRep = dAttr;
    public static double wRep = 10;
    public static double stepSize = 0.1;

}
