
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class BasicAlgorithm {

    //Basic alghorithm
    public static void sieveOfEratosthenes(int n){
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                for(int j = i * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }
        System.out.println("Svi prosti brojevi do " + n + " su:");
        System.out.println(primes);
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite gornju granicu do koje zelite ispisati proste brojeve: ");
        int granica = scanner.nextInt();
        sieveOfEratosthenes(granica);




    }
}