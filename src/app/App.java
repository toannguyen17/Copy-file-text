package app;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the source file: ");
        String sourceFile = scanner.nextLine();

        System.out.print("Enter the target file copy: ");
        String sourceTarget = scanner.nextLine();

        BufferedInputStream  bindIn  = null;
        BufferedOutputStream bindOut = null;

        try {
            File file                         = new File(sourceFile);
            bindIn = new BufferedInputStream(new FileInputStream(file));

            // Write to new File
            File fileTarget       = new File(sourceTarget);
            bindOut = new BufferedOutputStream(new FileOutputStream(fileTarget));

            while (true) {
                int data = bindIn.read();
                if (data == -1) {
                    break;
                }
                bindOut.write(data);
            }
            bindOut.flush();

        }catch (FileNotFoundException e){
            System.out.println("File source not found.");
        }catch (IOException e){
            System.out.println("File source not found.");
        }finally {
            try {
                bindIn.close();
                bindOut.close();
                //NullPointerException
            }catch (NullPointerException | IOException e){

            }
        }
    }
}
