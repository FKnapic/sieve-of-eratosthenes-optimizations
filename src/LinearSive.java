import java.util.ArrayList;
import java.util.List;

public class LinearSive extends PrimeSieve{

    public LinearSive(int limit){
        super(limit);
    }
    @Override
    public List<Integer> generatePrimes() {
        int[] lp = new int[limit + 1];
        List<Integer> pr = new ArrayList<>();

        for(int i = 2; i <= limit; i++){
            if(lp[i] == 0){
                lp[i] = i;
                pr.add(i);
            }
            for(int j = 0; i * pr.get(j) <= limit; j++){
                lp[i * pr.get(j)] = pr.get(j);
                if(pr.get(j) == lp[i]){
                    break;
                }

            }
        }


        return pr;
    }
}
