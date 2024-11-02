import java.io.*;

public class Analyze {
    public static void CountFile(String file_name, String result_name, File file, File results){
        char[] infile = new char[(int) file.length()];

        try (FileReader reader = new FileReader(file_name)) {
            for (int i = 0; i < infile.length; i++) {
                infile[i] = (char) reader.read();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        int[] English_alfBig = new int[26];
        int[] English_alfSmall = new int[26];
        for (char c : infile){
            if (c >= 'A' && c <= 'Z') {
                English_alfBig[c - 'A']++;
            }
            else if (c >= 'a' && c <= 'z') {
                English_alfSmall[c - 'a']++;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(result_name))) {
            for (int i = 0; i < 26; i++) {
                char alf = (char) ('A' + i);
                writer.write(alf + ": " + English_alfBig[i] + '\n');
            }
            for (int i = 0; i < 26; i++) {
                char alf = (char) ('a' + i);
                writer.write(alf + ": " + English_alfSmall[i] + '\n');
            }
            System.out.println("Частотный словарь символов записан в файл " + result_name);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
