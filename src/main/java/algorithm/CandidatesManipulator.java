package algorithm;

import domain.Candidate;
import functions.Function;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static options.SpeciesParameters.*;

/**
 * Created by Anna on 11.05.2017.
 */
public class CandidatesManipulator {

    private List<Candidate> candidates = new ArrayList<Candidate>();
    private Map<Integer, Double> healthStatus = new HashMap<>();
    private int population;
    private Function function;

    public CandidatesManipulator() {
        population = 0;
        initCandidates();
    }

    private void initCandidates() {
        for (int i = 0; i < candidatesNumber; i++) {
            List<Double> nextCandidatePosition = new ArrayList<Double>();
            for (int i1 = 0; i1 < dimensions; i1++) {
                nextCandidatePosition.add(generator.nextDouble() * (maxRange - minRange) + minRange);
            }
            candidates.add(new Candidate(nextCandidatePosition));
        }
    }

    public void solve(Function function) throws Exception {
        this.function = function;
        //for (int i = 0; i < 20; ++i) {
        int i = 0;
        while(findMinDiff() > 1.0) {
            //eliminationAndDispersal();
            reproduction();
            System.out.println(i++);
            //for (Candidate c : candidates) c.print();
            System.out.println(findMinDiff());
        }
    }

    private double findMinDiff() {
        Candidate minFunction = candidates.stream().min(
                (p1, p2) -> Double.compare( Math.abs(p1.evaluateFitness(function) - function.getRealMin()),
                        Math.abs(p2.evaluateFitness(function) - function.getRealMin()))).get();
        return Math.abs(minFunction.evaluateFitness(function) - function.getRealMin());
    }

    private void eliminationAndDispersal() {
        for (int i = 0; i < eliminationAndDispersalNumber; ++i) {
            reproduction();
            for (int i1 = 0;  i1 < candidates.size(); ++i1) {
                double u = generator.nextDouble() * 1;
                 if (u > possibility) {
                    candidates.remove(i1);
                    candidates.add(i1, new Candidate());
                }
            }
        }
    }

    private void reproduction() {
        for (int i1 = 0; i1 < reproductionNumber; ++i1) {
            List<Candidate> population = chemotaxis();
            Map newHealthStatus = healthStatus.entrySet().stream().sorted(
                    Map.Entry.<Integer, Double>comparingByValue()//.reversed()
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (e1, e2) -> e1, LinkedHashMap::new)
            );
            List<Integer> key = new ArrayList<>(newHealthStatus.keySet());
            for (int i = 0; i < newHealthStatus.size() / 2; ++i) {
                candidates.add(population.get(key.get(i)));
                candidates.add(population.get(key.get(i)));
            }
        }
    }

    private List<Candidate> chemotaxis() {
        List<Candidate> population = new ArrayList<Candidate>(candidates);
        for (int i = 0; i < chemotaxisNumber; ++i) {
            for (int i1 = 0; i1 < candidates.size(); ++i1) {
                population.remove(i1);
                population.add(i1, candidates.get(i).mutate(function));
            }
            candidates.clear();
            //Count health
            for (int i1 = 0; i1 < population.size(); ++i1) {
                healthStatus.put(i1, population.get(i1).evaluateFitness(function) + (healthStatus.size() >= i1 ? 0.0 : healthStatus.get(i1)));
            }
        }
        return population;
    }
}
