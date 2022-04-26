/* Naming Conventions: * Package names are in lowercase*
 * Class/Interfaces names are in PascalCase * Method/Instances names are in camelCase*
 * Variable names are in camelCase (typeName) * Constants are in SNAKE_CASE*
 * Temporary variables names: i,j,k,m,n for int; c,d,e for char (else follow variable names)*
 * Sapere Aude */

package anagramsolver;

import java.util.Scanner;

/**
 * @author King Red Sanchez
 */

public class AnagramStart {

    /**
     *
     * @param args
     */
    public static void main(String args[]){
        System.out.println("pick: ");
        Scanner in = new Scanner(System.in);
        String test = in.nextLine();
        if ("yes".equals(test)){
            AnagramUI anagramUI = new AnagramUI();
        }
        
        else{
            System.out.println("oky");
        }
    }
}
