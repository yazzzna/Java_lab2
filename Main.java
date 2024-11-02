import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//C:\Users\Yazzzna\Desktop\test.txt
//C:\Users\Yazzzna\Desktop\test_result.txt

public class Main {
    public static void main(String[] args) {

        System.out.printf("Введите название файла: ");
        Scanner sc = new Scanner(System.in);
        String file_name = sc.next();
        File file = new File(file_name);
        if (file.exists()) {
            System.out.println("Файл существует");
        } else {
            System.out.println("Файл не существует");
            sc.close();
            return;
        }

        System.out.printf("Введите название файла для записи анализа: ");
        String result_name = sc.next();
        File results = new File(result_name);
        if (!results.exists()){
            System.out.println("Файл не существует");
            sc.close();
            return;
        }
        sc.close();

        Analyze analyze = new Analyze();
        analyze.CountFile(file_name, result_name, file, results);
    }
}
