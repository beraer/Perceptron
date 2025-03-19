import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PerceptronUI extends JFrame {
    private JTextField txtLearningRate, txtEpochs, txtTrainFile, txtTestFile;
    private JButton btnTrain, btnTest;
    private JTextArea txtOutput;
    private Perceptron perceptron; // Instance of your Perceptron class
    private List<Vector> trainingData;
    private List<Vector> testData;

    public PerceptronUI() {
        super("Perceptron Demo");
        setSize(780, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Learning Rate:"));
        txtLearningRate = new JTextField("0.01", 5);
        topPanel.add(txtLearningRate);

        topPanel.add(new JLabel("Epochs:"));
        txtEpochs = new JTextField("100", 5);
        topPanel.add(txtEpochs);

        topPanel.add(new JLabel("Training File:"));
        txtTrainFile = new JTextField("data/perceptron.data", 15);
        topPanel.add(txtTrainFile);

        topPanel.add(new JLabel("Test File:"));
        txtTestFile = new JTextField("data/perceptron.test.data", 15);
        topPanel.add(txtTestFile);


        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnTrain = new JButton("Train");
        btnTest = new JButton("Test");
        buttonPanel.add(btnTrain);
        buttonPanel.add(btnTest);

        txtOutput = new JTextArea(10, 50);
        txtOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtOutput);

        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        btnTrain.addActionListener(e -> trainPerceptron());
        btnTest.addActionListener(e -> testPerceptron());

        setVisible(true);
    }

    private void trainPerceptron() {
        try {
            double lr = Double.parseDouble(txtLearningRate.getText());
            int epochs = Integer.parseInt(txtEpochs.getText());
            String trainFilePath = txtTrainFile.getText();

            LoadCsv loader = new LoadCsv();
            trainingData = loader.loadDpFromFile(trainFilePath);

            perceptron = new Perceptron(lr, epochs);
            perceptron.train(trainingData);

            txtOutput.append("Training completed successfully.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
            txtOutput.append("Error during training: " + ex.getMessage() + "\n");
        }
    }

    private void testPerceptron() {
        if (perceptron == null) {
            txtOutput.append("Please train the model before testing.\n");
            return;
        }

        try {
            String testFilePath = txtTestFile.getText();
            LoadCsv loader = new LoadCsv();
            testData = loader.loadDpFromFile(testFilePath);

            double accuracy = perceptron.test(testData);
            txtOutput.append("Test Accuracy: " + accuracy + "%\n");
        } catch (Exception ex) {
            ex.printStackTrace();
            txtOutput.append("Error during testing: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PerceptronUI::new);
    }
}

