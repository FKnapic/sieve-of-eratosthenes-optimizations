import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqrtSieveAlgorithm extends PrimeSieve{
    public SqrtSieveAlgorithm(int limit) {
        super(limit);

    }

    @Override
    public List<Integer> generatePrimes() {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i <= (int) Math.sqrt(limit); i++){
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
