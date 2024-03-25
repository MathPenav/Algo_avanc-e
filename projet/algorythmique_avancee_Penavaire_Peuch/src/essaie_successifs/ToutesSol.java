package essaie_successifs;

import java.util.ArrayList;
import java.util.List;

public class ToutesSol {



    public static void rendreMonnaie (List<Integer> c, int n, List<Integer> solution){
        
        for (int i = 0; i< c.size(); i++) {
            if (n >= 0 && c.get(i) <= n){ // satisfaisant
                // enregistrer
                solution.add(c.get(i));
                n -= c.get(i);

                if (n == 0) { // soltrouvée
                    // écriresol
                    System.out.println(solution);
                }
                else {
                    //toutessol(i+1)
                    rendreMonnaie(c, n, solution);
                }
            }
            // défaire
            n += c.get(i);
            solution.remove(solution.size() - 1);
        }
        
        
        return;
        
    }

    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>();
        
    }
}
