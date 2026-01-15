import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SegmentedSieve extends PrimeSieve{
    public SegmentedSieve(int limit) {
        super(limit);
    }

    @Override
    public List<Integer> generatePrimes() {
        final int S = 10000;
        List<Integer> primes = new ArrayList<>();
        int nsqrt = (int) Math.sqrt(limit);
        boolean[] isPrime = new boolean[nsqrt + 2];
        Arrays.fill(isPrime, true);

        //klasično sito do sqrt(n)
        for (int i = 2; i <= nsqrt; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i * i; j <= nsqrt; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        Boolean[] block = new Boolean[S];

        for(int k = 0; k * S <= limit; k++) {
            Arrays.fill(block, true);
            int start = k * S;
            for(int p : primes) {
                int startIndex = (start + p - 1) / p;
                int j = Math.max(startIndex, p) * p - start;
                for(; j < S; j += p){
                    block[j] = false;
                }
            }
            if(k == 0){
                block[0] = block[1] = false;
            }
            for(int i = 0; i < S && start + i <= limit; i++) {
                if(block[i]){
                    result.add(start + i);
                }
            }
        }
        return result;
    }
}
