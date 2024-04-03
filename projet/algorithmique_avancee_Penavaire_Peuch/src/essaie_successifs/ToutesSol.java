package essaie_successifs;

import java.util.ArrayList;
import java.util.List;

public class ToutesSol {



    public static void rendreMonnaie (List<Integer> c, int n, List<Integer> solution){
       
        
        int piece = 0;
        System.out.println(n);
        System.out.println(solution);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i< c.size(); i++) {
            
            piece = c.get(i);

            if (n >= 0 && piece <= n){ // satisfaisant
                // enregistrer
                solution.add(piece);
                n -= piece;

                if (n == 0) { // soltrouvée
                    // écriresol
                    System.out.println(solution);
                    return;
                }
                else {
                    //toutessol(i+1)
                    rendreMonnaie(c, n, solution);
                }
            
                // défaire
                n += piece;
                solution.remove(solution.size() - 1);
            }
            
        }
        
        
        return;
        
    }

    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>(List.of(200, 100, 50, 20, 10, 5, 2, 1));
        List<Integer> solution = new ArrayList<>();
        int n = Integer.parseInt(args[0]);

        rendreMonnaie(c, n, solution);        
    }
}
