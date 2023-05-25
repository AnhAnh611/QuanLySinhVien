package bail0;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOutput {

	public static void writeFile(String text) {
		// 
		try {
	      File newFile = new File("output.txt");
	      // nếu chưa có thì tạo 1 file mới
	      if (newFile.createNewFile()) {
	        System.out.println("The file is created successfully!");
	      }
	      FileWriter myWriter = new FileWriter("output.txt",true);
	      myWriter.write(text);
	      myWriter.append('\n');
	      myWriter.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	public static void readFile() {
		try {
	      File file = new File("output.txt");
	      Scanner sc = new Scanner(file);
	      while (sc.hasNextLine()) {
	        String data = sc.nextLine();
	        System.out.println(data);
	      }
	      sc.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
}
