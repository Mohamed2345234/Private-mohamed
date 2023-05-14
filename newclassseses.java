import java.util.Arrays;
import java.util.List;

class OuderPairwiseTesting {

    public static void main(String[] args) {
        // Define all possible values for each input parameter
        List<Boolean> isRedenRelevantValues = Arrays.asList(true, false);
        List<Boolean> gaatOverSchoolValues = Arrays.asList(true, false);
        List<Boolean> gaatOverBijbaanValues = Arrays.asList(true, false);
        List<Boolean> redenGeaccepteerdValues = Arrays.asList(true, false);

        // Perform pairwise testing by creating all possible pairs of input parameter values
        for (Boolean isRedenRelevant : isRedenRelevantValues) {
            for (Boolean gaatOverSchool : gaatOverSchoolValues) {
                for (Boolean gaatOverBijbaan : gaatOverBijbaanValues) {
                    for (Boolean redenGeaccepteerd : redenGeaccepteerdValues) {
                        System.out.println("Test case:");
                        System.out.println("isRedenRelevant = " + isRedenRelevant);
                        System.out.println("gaatOverSchool = " + gaatOverSchool);
                        System.out.println("gaatOverBijbaan = " + gaatOverBijbaan);
                        System.out.println("redenGeaccepteerd = " + redenGeaccepteerd);
                        System.out.println("-----------------------------------");
                    }
                }
            }
        }
    }

}
