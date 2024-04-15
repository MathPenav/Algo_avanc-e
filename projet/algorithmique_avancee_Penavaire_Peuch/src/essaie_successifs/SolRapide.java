package essaie_successifs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolRapide {

    protected static int cpt = 1;

    public static void rendreMonnaieRapide (List<Integer> c, int n, List<Integer> solution, List<Integer> sol_pot){
       
        
        int piece = 0;

        for (int j = 0; j < c.size(); j++) {
            
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
                    System.out.println("La suite de pièces à rendre est :"+solution);
                }
                //encore_possible
                /* Condition d'élagage : si la liste de pièces sol_pot 
                    est plus grande que celle appélée solution, alors 
                    on ne cherche pas plus loin et on défait la dernière pièce */
                else if (sol_pot.size() <= solution.size()){    
                    //toutessol(i+1)
                    cpt += 1;
                    //System.out.println(cpt);
                    rendreMonnaieRapide(c, n, solution, sol_pot);
                }
                // défaire
                n += sol_pot.get(sol_pot.size() - 1);
                sol_pot.remove(sol_pot.size() - 1);

            }
            
        }
        return;
        
    }

    public static void main(String[] args) {// Pour les test entrer la somme multipliée par 100
        
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

        rendreMonnaieRapide(c, n, solution, sol_pot);   
        System.out.println("nb d'appels récursifs :"+cpt);     
    }

}
