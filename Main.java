import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//C:\Users\Yazzzna\Desktop\test.txt
//C:\Users\Yazzzna\Desktop\test_result.txt

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.printf("Введите название файла: ");
            String file_name = sc.next();
            File file = new File(file_name);
            checkExist(file);

            System.out.printf("Введите название файла для записи анализа: ");
            String result_name = sc.next();
            File results = new File(result_name);
            checkExist(results);

            Analyze analyze = new Analyze();
            analyze.CountFile(file_name, result_name, file, results);
        }
            
        catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        
        sc.close();
    }

    private static void checkExist(File file) throws FileNotFoundException {
        if (!file.exists()){
            throw new FileNotFoundException("Файл не существует");
        }
    }
}
