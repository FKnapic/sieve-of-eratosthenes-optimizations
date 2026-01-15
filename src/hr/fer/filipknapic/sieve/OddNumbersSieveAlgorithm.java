package hr.fer.filipknapic.sieve;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersSieveAlgorithm extends PrimeSieve {
    public OddNumbersSieveAlgorithm(int limit) {
        super(limit);
    }

    @Override
    public List<Integer> generatePrimes() {
        boolean[] isPrime = new boolean[limit + 1];
        isPrime[0] = isPrime[1] = false;

        isPrime[2] = true;
        for(int i = 3; i <= limit; i = i + 2){
            isPrime[i] = true;
        }

        for(int i = 3; i < Math.sqrt(limit); i = i + 2){
            if(isPrime[i]){
                for(int j = i * i; j <= limit; j += i){
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= limit; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }
        return primes;
    }
}
