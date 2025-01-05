package gr.aueb.cf.solutions.projects;

public class MaximumSubarraySum {

    public static int maxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // ή κάποια ένδειξη για μη έγκυρη είσοδο
        }

        // Αρχικοποίηση
        int currentMax = arr[0];
        int globalMax = arr[0];

        // Ξεκινάμε από το δεύτερο στοιχείο γιατί το πρώτο κομμάτι έχει ήδη αντιμετωπιστεί στην αρχικοποίηση
        for (int i = 1; i < arr.length; i++) {
            // Ενημερώστε το μέγιστο μέχρι την θέση i
            currentMax = Math.max(arr[i], currentMax + arr[i]);

            // Ενημερώστε το global maximum αν είναι μικρότερο από το τρέχον τοπικό μέγιστο
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("The maximum subarray sum is: " + maxSubArraySum(arr));
    }
}
