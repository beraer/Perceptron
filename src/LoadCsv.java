import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadCsv {

    public List<DataPoint> loadDpFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<DataPoint> dataPoints = new ArrayList<>();
        String label = "";
        String line;
        while((line = br.readLine()) != null){
            String[] data = line.split(",");
            double[] features = new double[data.length];
            for (int i = 0; i < data.length - 1; i++) {
                features[i] = Double.parseDouble(data[i]);

            }
        }
    }
}
