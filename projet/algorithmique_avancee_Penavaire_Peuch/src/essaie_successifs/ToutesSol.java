package essaie_successifs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToutesSol {

    protected static int cpt = 1;

    public static void rendreMonnaie (List<Integer> c, int n, List<Integer> solution){
       
        
        int piece = 0;
    
        for (int i = 0; i< c.size(); i++) {
            
            piece = c.get(i);

            // satisfaisant
            if (n >= 0 && piece <= n){ 
                // enregistrer
                solution.add(piece);
                n -= piece;

                // soltrouvée
                if (n == 0) { 
                    // écriresol
                    System.out.println("La suite de pièces à rendre est :"+solution);
                }
                else {
                    //toutessol(i+1)
                    cpt += 1;
                    rendreMonnaie(c, n, solution);
                }
            
                // défaire
                n += solution.get(solution.size() - 1);
                solution.remove(solution.size() - 1);
            }
            
        }
        
        
        return;
        
    }

    public static void main(String[] args) {// Pour les test entrer la somme multipliée par 100

        List<Integer> c = new ArrayList<>(List.of(200, 100, 50, 20, 10, 5, 2, 1));
        List<Integer> solution = new ArrayList<>();
        int n = Integer.parseInt(args[0]);

        // Donne une liste de pièce dont l'ordre est choisi au hasard
        //Collections.shuffle(c);
        System.out.println(c);

        rendreMonnaie(c, n, solution);
        System.out.println("nb d'appels récursifs :"+cpt);
    }
}
