package essaie_successifs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToutesSol {



    public static void rendreMonnaie (List<Integer> c, int n, List<Integer> solution){
       
        
        int piece = 0;
    
        for (int i = 0; i< c.size(); i++) {
            
            piece = c.get(i);

            if (n >= 0 && piece <= n){ // satisfaisant
                // enregistrer
                solution.add(piece);
                n -= piece;

                if (n == 0) { // soltrouvée
                    // écriresol
                    System.out.println(solution);
                }
                else {
                    //toutessol(i+1)
                    rendreMonnaie(c, n, solution);
                }
            
                // défaire
                n += solution.get(solution.size() - 1);
                solution.remove(solution.size() - 1);
            }
            
        }
        
        
        return;
        
    }

    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>(List.of(200, 100, 50, 20, 10, 5, 2, 1));
        List<Integer> solution = new ArrayList<>();
        int n = Integer.parseInt(args[0]);

        Collections.shuffle(c);
        System.out.println(c);
        rendreMonnaie(c, n, solution);        
    }
}
