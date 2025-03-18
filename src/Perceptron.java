public class Perceptron {
    private static double dotProduct(double[] w, double[] x) {
        double sum = 0.0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i] * x[i];
        }
        return sum;
    }

    // Method to apply the discrete activation function
    private static int activation(double z) {
        return z > 0 ? 1 : 0;
    }

    // Method to calculate the perceptron output
    public static int perceptronOutput(double[] w, double[] x, double theta, double alpha) {
        double z = dotProduct(w, x) + theta;
        return activation(z);
    }


    public static void main(String[] args) {

        double[] w = {2, -1, 4, 1};
        double theta = 3;
        double alpha = 0.01;

        double[] x1 = {7, -2, -5, 4};
        double[] x2 = {2, 0, 2, 8};

        int output1 = perceptronOutput(w, x1, theta, alpha);
        int output2 = perceptronOutput(w, x2, theta, alpha);

        System.out.println("Output for x1: " + output1);
        System.out.println("Output for x2: " + output2);
    }
}
