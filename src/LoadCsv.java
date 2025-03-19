import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadCsv {
    public List<Vector> loadDpFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<Vector> vectors = new ArrayList<>();
        String label = "";
        String line;
        while((line = br.readLine()) != null){
            String[] data = line.split(",");
            double[] attributes = new double[data.length];
            for (int i = 0; i < data.length - 1; i++) {
                attributes[i] = Double.parseDouble(data[i]);
            }
            label = data[data.length - 1];
            vectors.add(new Vector(attributes, label));
        }
        return vectors;
    }
}
