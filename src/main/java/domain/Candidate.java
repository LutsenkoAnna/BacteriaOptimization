package domain;

import functions.Function;

import static java.lang.Math.sqrt;
import static options.SpeciesParameters.*;
import static options.SpeciesParameters.minRange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 11.05.2017.
 */
public class Candidate {

    public List<Double> position = new ArrayList<Double>();

    public Candidate(List<Double> position) {
        this.position = position;
    }

    public Candidate() {
        List<Double> nextCandidatePosition = new ArrayList<Double>();
        for (int i1 = 0; i1 < dimensions; ++i1) {
            nextCandidatePosition.add(generator.nextDouble() * (maxRange - minRange) + minRange);
        }
        this.position = nextCandidatePosition;
    }

    //Not good, because makes all with matrix
    private List<Double> mutatedSum(List<Double> mutatedVector) {
        List<Double> mutatedCandidatePosition = new ArrayList<>();
        double v = mutatedVector.stream().map(x -> x * x).reduce(0.0, (a, b) -> a + b);
        for (int i = 0; i < dimensions; ++i) {
            mutatedCandidatePosition.add(this.position.get(i) + chemotaxisStep * mutatedVector.get(i) / sqrt(v));
        }
        return mutatedCandidatePosition;
    }

    /**
     * mutate this candidate to new one.
     * @return new Candidate
     */
    public Candidate mutate(Function function) {
        List<Double> mutatedVector = new ArrayList<Double>();
        for (int i = 0; i < dimensions; ++i) {
            double v = (generator.nextDouble() * (2) - 1);
            mutatedVector.add(v);
        }
        return new Candidate(mutatedSum(mutatedVector));
    }

    public Double evaluateFitness(Function function) {
        return function.evaluate(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return position.equals(candidate.position);
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }

    public void print() {
        for (Double d : position)
            System.out.print(" x = " + d);
        System.out.println();
    }
}