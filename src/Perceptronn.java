import java.util.HashMap;
import java.util.List;

public class Perceptronn {

    private double[] weights;
    private double learningRate;
    private int epochs;
    private double bias;

    public Perceptronn(double learningRate, int epochs) {
        this.learningRate = learningRate;
        this.epochs = epochs;
    }

    public int predict(double[] testVector) {

        double z = 0.0;
        for (int i = 0; i < weights.length; i++) {
            z += weights[i] * testVector[i];
        }

        return activation(z - bias); //and bias is here to optimize also!!!
    }

    public static int activation(double z) {
        return z > 0 ? 1 : 0;
    }

    public void updateWeights(double[] trainVector, int label) {
        int prediction = predict(trainVector);
        int error = label - prediction;
        for (int i = 0; i < weights.length; i++) {
            weights[i] += learningRate * error * trainVector[i];
        }
        bias = bias - learningRate*error; //updating bias in updateWeights too
    }

    void train(double[][] trainingSet, int[] labels){


    }

    public static double dotProduct(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }




    public static void main(String[] args) {
       double bias = 0.0;
       double learningRate = 0.0001;


    }
}
