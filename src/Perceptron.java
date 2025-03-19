import java.util.List;

public class Perceptron {

    private double[] weights;
    private double learningRate;
    private int epochs;
    private double bias;



    public Perceptron(double learningRate, int epochs) {
        this.learningRate = learningRate;
        this.epochs = epochs;
    }

    public double[] getInitialWeights(int dimension){
        double[] weights = new double[dimension];
        for(int i = 0; i < dimension; i++) weights[i] = Math.random();
        return weights;
    }

    public void train(List<Vector> data){
        int numOfFeatures = data.get(0).features.length;
        weights = getInitialWeights(numOfFeatures);
        bias = Math.random();

        for(int e = 0; e < epochs; e++){
            for(Vector v : data){
                int labelInt = v.label.equals("Iris-virginica") ? 1 : 0;
                updateWeights(v.features, labelInt);
            }
        }
    }

    public double test(List<Vector> data) {
        int correct = 0;
        for (Vector v : data) {
            int predicted = predict(v.features);
            int actual = v.label.equals("Iris-virginica") ? 1 : 0;
            if (predicted == actual) {
                correct++;
            }
        }
        return 100.0 * correct / data.size();
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
        bias = bias - learningRate * error; //updating bias in updateWeights too
    }


    public static double dotProduct(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }
}
