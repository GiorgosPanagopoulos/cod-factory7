package gr.aueb.cf.solutions.projects;
import java.io.*;
import java.util.*;

public class LotteryFilter {

    public static void main(String[] args) {
        // Σταθερή λίστα με τους αριθμούς που επιλέξατε
        List<Integer> numbers = Arrays.asList(3, 5, 11, 14, 20, 25, 33, 37, 40, 42, 45);

        try {
            if (numbers.size() < 7 || numbers.size() > 49) {
                throw new IllegalArgumentException("Ο αριθμός των εισαγόμενων αριθμών πρέπει να είναι τουλάχιστον 7 και το πολύ 49.");
            }

            // Ταξινόμηση των αριθμών
            Collections.sort(numbers);

            // Δημιουργεί και φιλτράρει όλες τις δυνατές εξάδες
            List<List<Integer>> filteredCombinations = generateAndFilterCombinations(numbers, 6);

            // Αποθήκευση των φιλτραρισμένων εξάδων σε αρχείο
            writeResultsToFile(filteredCombinations, "filtered_combinations.txt");

        } catch (Exception e) {
            System.out.println("Σφάλμα: " + e.getMessage());
        }
    }

    public static List<List<Integer>> generateAndFilterCombinations(List<Integer> numbers, int combinationSize) {
        List<List<Integer>> filteredCombinations = new ArrayList<>();
        generateCombinationsRecursive(numbers, new ArrayList<>(), 0, combinationSize, filteredCombinations);
        return filteredCombinations;
    }

    private static void generateCombinationsRecursive(List<Integer> numbers, List<Integer> currentCombination,
                                                      int start, int size, List<List<Integer>> result) {
        if (currentCombination.size() == size) {
            if (isValidCombination(currentCombination)) {
                result.add(new ArrayList<>(currentCombination));
            }
            return;
        }
        for (int i = start; i < numbers.size(); i++) {
            currentCombination.add(numbers.get(i));
            generateCombinationsRecursive(numbers, currentCombination, i + 1, size, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static boolean isValidCombination(List<Integer> combination) {
        return (countEvenNumbers(combination) <= 4) &&
                (countOddNumbers(combination) <= 4) &&
                (countContiguous(combination) <= 2) &&
                (countSameEnding(combination) <= 3) &&
                (countSameDecade(combination) <= 3);
    }

    public static int countEvenNumbers(List<Integer> combination) {
        int count = 0;
        for (int number : combination) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countOddNumbers(List<Integer> combination) {
        int count = 0;
        for (int number : combination) {
            if (number % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int countContiguous(List<Integer> combination) {
        int maxContiguous = 1;
        int currentContiguous = 1;
        for (int i = 1; i < combination.size(); i++) {
            if (combination.get(i) == combination.get(i - 1) + 1) {
                currentContiguous++;
                if (currentContiguous > maxContiguous) {
                    maxContiguous = currentContiguous;
                }
            } else {
                currentContiguous = 1;
            }
        }
        return maxContiguous;
    }

    public static int countSameEnding(List<Integer> combination) {
        int[] endings = new int[10];
        for (int number : combination) {
            endings[number % 10]++;
        }
        int maxEnding = 0;
        for (int ending : endings) {
            if (ending > maxEnding) {
                maxEnding = ending;
            }
        }
        return maxEnding;
    }

    public static int countSameDecade(List<Integer> combination) {
        int[] decades = new int[5]; // Decades are 0-9, 10-19, 20-29, 30-39, 40-49
        for (int number : combination) {
            decades[number / 10]++;
        }
        int maxDecade = 0;
        for (int decade : decades) {
            if (decade > maxDecade) {
                maxDecade = decade;
            }
        }
        return maxDecade;
    }

    public static void writeResultsToFile(List<List<Integer>> combinations, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (List<Integer> combination : combinations) {
            writer.write(combination.toString());
            writer.newLine();
        }
        writer.close();
    }
}