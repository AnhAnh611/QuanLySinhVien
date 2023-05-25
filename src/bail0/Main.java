package bail0;

import static bail0.Constants.STUDENT_VALIDATE.maxHeight;
import static bail0.Constants.STUDENT_VALIDATE.minHeight;

import java.awt.Window.Type;
import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;






public class Main {
	
	private static final Integer Integer = null;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
//
//		Exercise.createSutdent();
//		FIleStudent.updateFile();
//		FIleStudent.deleteStudentFile();
//		FIleStudent.readFile();
		String choose = null;
        boolean exit = false;
        Exercise exercise = new Exercise();
//        int studentId;
 
        // show menu
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
            case "1":
            	Exercise.createSutdent();
            	FIleStudent.readFile();
                break;
            case "2":
            	Exercise.getById(Exercise.inputId());
                break;
            case "3":
            	FIleStudent.updateFile();
            	FIleStudent.readFile();
                break;
            case "4":
            	FIleStudent.deleteStudentFile();
            	FIleStudent.readFile();
                break;
            case "5":
            	FIleStudent.readFile();
                break;
            case "6":
                Exercise.executeStatic();
                
                break;
            case "7":
              	Exercise.gpaStatis();
                break;
            case "8":
              	Exercise.getByName();
                break;
            case "0":
                System.out.println("exited!");
                exit = true;
                break;
            default:
                System.out.println("invalid! please choose action in below menu:");
                break;
            }
            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }
    }
 
    /**
     * create menu
     */
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. CreateSutdent.");
        System.out.println("2. Search student by id.");
        System.out.println("3. UpDate student by id.");
        System.out.println("4. Delete student by id..");
        System.out.println("5. Show ds Student.");
        System.out.println("6. % Level.");
        System.out.println("7. % GPA");
        System.out.println("8. Search by name");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
	        
}