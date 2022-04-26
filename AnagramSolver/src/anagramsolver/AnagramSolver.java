/* Naming Conventions: * Package names are in lowercase*
 * Class/Interfaces names are in PascalCase * Method/Instances names are in camelCase*
 * Variable names are in camelCase (typeName) * Constants are in SNAKE_CASE*
 * Temporary variables names: i,j,k,m,n for int; c,d,e for char (else follow variable names)*
 * Sapere Aude */
package anagramsolver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author King Red Sanchez
 */
public class AnagramSolver {

    /**
     * @param strGivenWord
     * @return
     * @throws java.io.IOException
     */
    public static ArrayList<String> transferHandler(String strGivenWord) throws IOException {
        ArrayList<String> arrListPermutation = new ArrayList<>();
        ArrayList<String> arrListFinal = new ArrayList<>();
        arrListPermutation = permutation(strGivenWord);
        arrListFinal = wordComparator(arrListPermutation);
        return arrListFinal;
    }

    /**
     * List permutations of a string.
     *
     * @param s the input string
     * @return the list of permutations
     */
    public static ArrayList<String> permutation(String s) {
        // The result
        ArrayList<String> res = new ArrayList<>();
        // If input string's length is 1, return {s}
        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;
            // Find out the last character
            String last = s.substring(lastIndex);
            // Rest of the string
            String rest = s.substring(0, lastIndex);
            // Perform permutation on the rest string and
            // merge with the last character
            res = merge(permutation(rest), last);
        }
        return res;
    }

    /**
     * @param list a result of permutation, e.g. {"ab", "ba"}
     * @param c    the last character
     * @return a merged new list, e.g. {"cab", "acb" ... }
     */
    public static ArrayList<String> merge(ArrayList<String> list, String c) {
        ArrayList<String> res = new ArrayList<>();
        // Loop through all the string in the list
        list.forEach(s -> {
            // For each string, insert the last character to all possible positions
            // and add them to the new list
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        });
        return res;
    }

    /**
     *
     * @param arrListPermutation
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<String> wordComparator(ArrayList<String> arrListPermutation)
            throws FileNotFoundException, IOException {
        List<String> listFinal = new ArrayList<String>();
        Comparator<String> strLengthComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        };
        String strLine, strOut;
        boolean bFound;
        try (BufferedReader readTestSheet = new BufferedReader(
                new InputStreamReader(new FileInputStream("D:/Harry/Word Bank.txt")));) {
            while ((strLine = readTestSheet.readLine()) != null) {
                for (int i = 0; i < arrListPermutation.size(); i++) {
                    strOut = arrListPermutation.get(i);
                    strOut = strOut.toUpperCase();
                    bFound = strOut.contains(strLine);
                    if (bFound == true) {
                        listFinal.add(strLine);
                    }
                }
            }
        } catch (Exception e) {
        }
        Collections.sort(listFinal, strLengthComp);
        LinkedHashSet<String> hashSetFinal = new LinkedHashSet<>(listFinal);
        ArrayList<String> arrListFinalWords = new ArrayList<>(hashSetFinal);
        return arrListFinalWords;
    }

    /**
     * @param intMultiplicand
     * @param intMultiplier
     * @return int
     */
    public static int intMultiply(int intMultiplicand, int intMultiplier) {
        int intProduct;
        intProduct = intMultiplicand * intMultiplier;
        return intProduct;
    }

}
