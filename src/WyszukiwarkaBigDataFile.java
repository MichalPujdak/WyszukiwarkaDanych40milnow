import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WyszukiwarkaBigDataFile {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Vallen\\Desktop\\BigData\\wygenerowaneDane.csv"; // sciezka do pliku CSV zrodlowego
        int searchColumnIndex = 0; // wartosc oznacza kolumnie od ktorej chcesz szukac

        Scanner search = new Scanner(System.in);
        System.out.println("Podaj frazê której szukasz:");
        String searchTerm = search.next();
        search.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (lineCount > 0 && fields[searchColumnIndex].toLowerCase().contains(searchTerm.toLowerCase())) {
                    System.out.println("Wynik znaleziony w lini " + lineCount + ": " + line);
                }
                lineCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}