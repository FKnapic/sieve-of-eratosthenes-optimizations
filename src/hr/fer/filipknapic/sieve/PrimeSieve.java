package hr.fer.filipknapic.sieve;

import java.util.List;

public abstract class PrimeSieve {
    protected int limit;

    public PrimeSieve(int limit) {
        this.limit = limit;
    }
    public abstract List<Integer> generatePrimes();


    public void printPrimes() {
        long start = System.nanoTime();   // početak mjerenja
        List<Integer> primes = generatePrimes();
        long end = System.nanoTime();     // kraj mjerenja

        for(Integer prime : primes) {
            System.out.printf(prime + " ");
        }
        System.out.println();
        long duration = (end - start) / 1_000_000; // pretvorba u milisekunde

        System.out.println("Vrijeme izvođenja: " + duration + " ms");
    }


    public static void main(String[] args) {
        int n = 1721; // promijeni po potrebi

        PrimeSieve basic = new BasicSieveAlgorithm(n);
        PrimeSieve sqrt = new SqrtSieveAlgorithm(n);
        PrimeSieve odd = new OddNumbersSieveAlgorithm(n);
        PrimeSieve segmented = new SegmentedSieve(n);
        PrimeSieve linear = new LinearSive(n);

        System.out.println("=== Basic sieve ===");
        basic.printPrimes();

        System.out.println("\n=== Sqrt sieve ===");
        sqrt.printPrimes();

        System.out.println("\n=== Odd numbers sieve ===");
        odd.printPrimes();

        System.out.println("\n=== Segmented sieve ===");
        segmented.printPrimes();

        System.out.println("\n=== Linear sieve ===");
        linear.printPrimes();

    }
}
