package gr.aueb.cf.solutions.projects;

import java.io.FileReader;
import java.io.IOException;

public class CharacterFrequency {

    public static void main(String[] args) {
        // Η συμβολοσειρά για την οποία θέλουμε να υπολογίσουμε τις συχνότητες των χαρακτήρων
        String inputString = "example string with several characters";

        // Πίνακας για την αποθήκευση των αριθμών φορές που εμφανίζεται κάθε χαρακτήρας
        int[] charCounts = new int[128];

        // Υπολογίζουμε τις συχνότητες των χαρακτήρων
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            // Ελέγχουμε αν είναι ASCII και όχι whitespace
            if (ch < 128 && !Character.isWhitespace(ch)) {
                charCounts[ch]++;
            }
        }

        // Εμφάνιση των αποτελεσμάτων κατά χαρακτήρα
        System.out.println("By character:");
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > 0) {
                System.out.println((char) i + ": " + charCounts[i]);
            }
        }

        // Εμφάνιση των αποτελεσμάτων κατά συχνότητα
        System.out.println("\nBy frequency:");
        for (int amount = getMaxValue(charCounts); amount > 0; amount--) {
            for (int i = 0; i < charCounts.length; i++) {
                if (charCounts[i] == amount) {
                    System.out.println((char) i + ": " + charCounts[i]);
                }
            }
        }
    }

    // Βοηθητική μέθοδος για το εύρεση του μέγιστου αριθμού σε έναν πίνακα
    private static int getMaxValue(int[] values) {
        int max = 0;
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}