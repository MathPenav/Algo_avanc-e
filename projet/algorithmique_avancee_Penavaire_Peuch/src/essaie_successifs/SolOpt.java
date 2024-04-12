package essaie_successifs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolOpt {

    protected static int cpt = 0;

    public static void rendreMonnaieOpt (List<Integer> c, int n, List<Integer> solution, List<Integer> sol_pot){
       
        
        int piece = 0;

        for (int j = 0; j< c.size(); j++) {
            
            piece = c.get(j);

            // satisfaisant
            if (n >= 0 && piece <= n){ 
                // enregistrer
                sol_pot.add(piece);
                n -= piece;

                // soltrouvée et meilleur
                if (n == 0 && sol_pot.size() <= solution.size()) { 
                    solution.clear();
                    solution.addAll(sol_pot);
                    // écriresol
                    System.out.println(solution);
                }
                else {
                    //encore_possible et toutessol(i+1)
                    cpt += 1;
                    System.out.println(cpt);
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

        // Donne une liste de pièce dont l'ordre est choisi au hasard
        //Collections.shuffle(c);
        System.out.println(c);

        // Initialise la solution par une liste de pièces de 1 centime
        for (k=0;k<n;k++){
            solution.add(1);
        }

        rendreMonnaieOpt(c, n, solution, sol_pot);        
    }
}
