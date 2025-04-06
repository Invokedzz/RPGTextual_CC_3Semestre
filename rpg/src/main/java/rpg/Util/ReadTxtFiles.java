package rpg.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTxtFiles {

    public static void displayTxtFile (String path) {

        try {

            File file = new File(path);

            Scanner scanner = new Scanner(file);

            if (file.exists()) {

                while (scanner.hasNextLine()) {

                    String data = scanner.nextLine();

                    System.out.println(data);

                }

            }

        } catch (FileNotFoundException e) {

            throw new InvalidFilePathException(e.getMessage());

        }

    }

}
