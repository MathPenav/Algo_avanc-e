package algo_glouton;

import java.util.ArrayList;
import java.util.List;

public class Greedy {


    public static void glouton(int n,List<Integer> c, List<Integer> solution) {
        
        int piece = 0;
    
        for (int i = 0; i< c.size(); i++) {
            
            piece = c.get(i);

            // satisfaisant
            if (n > 0){ 
                while (piece <= n){
                    // enregistrer
                    solution.add(piece);
                    n -= piece;
                }
            }
        }
        // soltrouvée
        System.out.println("La suite de pièces à rendre est :"+solution);

        return;
    }

    public static void main(String[] args) {// Pour les test entrer la somme multipliée par 100 et choisir un entier entre 1 et 2
        
        List<Integer> c = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        if (k == 1){
            c = List.of(200, 100, 50, 20, 10, 5, 2, 1);
        }
        else if (k == 2){
            c = List.of(50,30,10,5,3,1);
        }

        glouton(n, c, solution);        
    }
}
