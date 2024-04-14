package programmation_dynamique;

import java.util.ArrayList;
import java.util.List;

public class NBP {


    public static int nbMinimalPiece(int n,List <Integer> c) {
        
        // Création d'un tableau de dimension (c.size()+1)x(n+1)
        int[][] nbp = new int[c.size()+1][n+1];

        //Initialisation de la colonne 0 et correspond a NBP(0,j)=0
        for (int i=0;i < nbp.length;i++){
            nbp[i][0] = 0;
        }
        
        
        //Initialisation de la colonne 0 et correspond a NBP(i,0)=-1
        for (int i=1;i < nbp[0].length;i++){
            nbp[0][i] = -1;
        }
        
        //Cas général
        for (int i=1;i < nbp.length;i++){
            for (int j=1;j < nbp[i].length;j++){
                //NBP(i,j) = 1 + NBP(i,j-c_i) si j >= c_i et NBP(i,j) != -1
                if (c.get(i-1) <= j && nbp[i-1][j] == -1){
                    nbp[i][j] = 1+nbp[i][j-c.get(i-1)];
                }  
                //NBP(i,j) = NBP(i-1,j) sinon
                else {
                    nbp[i][j] = nbp[i-1][j];
                }
            }
        }
        
        return nbp[c.size()][n];

    }


    public static void main(String[] args) {// Pour les test entrer la somme multipliée par 100 et choisir un entier entre 1 et 8

        List<Integer> c = new ArrayList<>(List.of(200, 100, 50, 20, 10, 5, 2, 1));
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int nbDePiecesMin;

        //Nombre de pièces qui compose notre liste de pièces disponibles
        List<Integer> list = c.subList(0, k);
        
        nbDePiecesMin = nbMinimalPiece(n, list);
        System.out.println("Le nombre minimal de pièce pour rendre la monnaie est de :"+nbDePiecesMin);
    }
}