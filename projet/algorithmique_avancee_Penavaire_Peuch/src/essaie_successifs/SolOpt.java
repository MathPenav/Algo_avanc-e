package essaie_successifs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolOpt {

    public static void rendreMonnaieOpt (List<Integer> c, int n, List<Integer> solution, List<Integer> sol_pot){
       
        
        int piece = 0;

        for (int j = 0; j< c.size(); j++) {
            
            piece = c.get(j);

            if (n >= 0 && piece <= n){ // satisfaisant
                // enregistrer
                sol_pot.add(piece);
                n -= piece;

                if (n == 0 && sol_pot.size() < solution.size()) { // soltrouvée et meilleur
                    solution = sol_pot;
                    // écriresol
                    System.out.println(solution);
                }
                else {
                    //encore_possible et toutessol(i+1)
                    rendreMonnaieOpt(c, n, solution, sol_pot);
                }
            
                // défaire
                n += sol_pot.get(sol_pot.size() - 1);
                sol_pot.remove(sol_pot.size() - 1);
            }
            
        }
        return;
        
    }

    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>(List.of(200, 100, 50, 20, 10, 5, 2, 1));
        List<Integer> solution = new ArrayList<>();
        List<Integer> sol_pot = new ArrayList<>();
        int n = Integer.parseInt(args[0]);
        int k;

        Collections.shuffle(c);
        System.out.println(c);

        for (k=0;k<n;k++){
            solution.add(1);
        }
        System.out.println(solution);

        rendreMonnaieOpt(c, n, solution, sol_pot);        
    }
}
