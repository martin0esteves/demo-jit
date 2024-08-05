import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;

class Parser {
    public static void main(String args[]) throws  IOException {

        String fileName = "output.txt";
        String csvFileName = "output.csv";

        Path filePath = Paths.get(fileName);

        try (BufferedReader reader = Files.newBufferedReader(filePath);
             FileWriter writer = new FileWriter(csvFileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace("made not entrant", "madenotentrant")
                        .replace("made zombie", "madezombie")
                        .replace(" bytes)", "bytes)")
                        .replace("(native)", "")
                        .replace("(static)", "");

                String csvLine = line.replaceAll("\\s+", ",");
                csvLine = csvLine.substring(1);
                String[] csvParts = csvLine.split(",");
                if (csvParts.length < 4) throw new IllegalArgumentException();
                csvLine = addFlagCWhenNoFlags(csvParts);

                System.out.println(csvLine);
                writer.write(csvLine + "\n");
            }
        }
    }

    private static String addFlagCWhenNoFlags(String[] values) {
        String[] levels = { "0", "1", "2", "3", "4" };
        boolean isCompilationLevel = false;
        for (String level : levels) {
            if (values[2].equals(level)) {
                isCompilationLevel = true;
                break;
            }
        }
        if (isCompilationLevel) {
            values[2] = "c," + values[2];
            return String.join(",", values);
        }
        return String.join(",", values);
    }
}