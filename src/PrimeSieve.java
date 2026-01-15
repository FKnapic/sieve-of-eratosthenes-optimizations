import java.util.List;
import java.util.Scanner;

public abstract class PrimeSieve {
    protected int limit;

    public PrimeSieve(int limit) {
        this.limit = limit;
    }
    public abstract List<Integer> generatePrimes();


    public void printPrimes() {
        List<Integer> primes = generatePrimes();
        System.out.println("Prosti brojevi do " + limit + ": " + primes);
    }


    public static void main(String[] args) {
        PrimeSieve sieve = new LinearSive(11);
        sieve.printPrimes();

    }
}
