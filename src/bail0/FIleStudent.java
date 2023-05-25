package bail0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FIleStudent {
	
	private static final int MAX = 1000;  // số phần tử
	// ghi 1 hs mới vào file
	public static void writeFile(Student student, Integer index) {
		// 
		try {
	      File newFile = new File("students.txt");
	      // nếu chưa có thì tạo 1 file mới
	      if (newFile.createNewFile()) {
	        System.out.println("The file is created successfully!");
	      }
	      FileWriter myWriter = new FileWriter("students.txt",true);
	      myWriter.write(student.toString(index));
	      myWriter.append('\n');
	      myWriter.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	// đọc file
	public static void readFile() {
		try {
	      File file = new File("students.txt");
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
	
	
	public static void updateFile() throws IOException {
		// lay tất cả hs
		List<Student> listAll = getAllStudent();
		// lấy thông tin hs cũ, mới
		List<Student> list = Exercise.updateStudent();
		// stt
		Student studentOld = list.get(0);
		Student studentNew = list.get(1);
		// vi trí hs trong ds 
		Integer indexStudent = -1;
		for(int i=0;i<listAll.size();i++) {
			if(listAll.get(i).getId()==studentOld.getId()) {
				indexStudent = i;
				break;
			}
		}
		// thay hs mới vào cũ
		listAll.set(indexStudent, studentNew);

		// clear all
		// xáo dữ liệu file cũ
		try {
	      File newFile = new File("students.txt");
	      if (newFile.createNewFile()) {
	        System.out.println("The file is created successfully!");
	      }
	      FileWriter myWriter = new FileWriter("students.txt");
	      myWriter.write("");
	      myWriter.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		// ghi lại vào file
		for(int i=0;i<listAll.size();i++) {
			writeFile(listAll.get(i),i);
		}
	}
	
	public static void deleteStudentFile() throws IOException {
		// lấy ds hs sau khi xóa
		List<Student> listAll = Exercise.delete();
		
		// clear all
		// xóa dl rùi 
		try {
	      File newFile = new File("students.txt");
	      if (newFile.createNewFile()) {
	        System.out.println("The file is created successfully!");
	      }
	      FileWriter myWriter = new FileWriter("students.txt");
	      myWriter.write("");
	      myWriter.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		// ghi lại
		for(int i=0;i<listAll.size();i++) {
			writeFile(listAll.get(i),i);
		}
	}
	// chuyển string sang model
	// cát dữ liệu
	public static Student stringToStudent(String str) {
		// cắt 2 dấu ngoặc [] chuyển thành chuỗi rỗng( xóa đi)
		str = str.replace("]", "");
		str = str.replace("[", "");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		// khởi tạo student mới
		Student student = new Student();
		// cắt theo ", " sau khi cắt xong thì lưu vào mảng vừa tạo 
		String[] strs1 = str.split(", ");
		student.setId(Integer.parseInt(getValue(strs1[0],"id")));
		student.setName(getValue(strs1[1],"name"));
		student.setDob(LocalDate.parse(getValue(strs1[2],"dob"), dateTimeFormatter));
		student.setAddress(getValue(strs1[3],"address"));
		student.setHeight(Double.parseDouble(getValue(strs1[4],"height")));
		student.setWeight(Double.parseDouble(getValue(strs1[5],"weight")));
		student.setCode(getValue(strs1[6],"code"));
		student.setSchool(getValue(strs1[7],"school"));
		student.setStartDate(Integer.parseInt(getValue(strs1[8],"startDate")));
		student.setGpa(Double.parseDouble(getValue(strs1[9],"gpa")));
		student.setLevel(Constants.STUDENT_GPA.valueOf(getValue(strs1[10],"level")));
		
		return student;
	}
	// Lấy giá trị của từng phần tử
	public static String getValue(String str, String variable) {
		// nếu là id
		if(variable.equals("id")) {
			// tiếp tục cắt theo dâu "="
			String[] strs = str.split("="); 
			return strs[1];
		}else {
			// nếu ko là id thì xóa tên biến+=
			return str.replace(variable+"=", "");
		}
	}
	
	// lấy tất cả học sinh tỏng file
	public static List<Student> getAllStudent() {
		List<Student> list = new ArrayList<>();
		try {
		      File file = new File("students.txt");
		      Scanner sc = new Scanner(file);
		      while (sc.hasNextLine()) {
		        String data = sc.nextLine();
		        list.add(stringToStudent(data));
		      }
		      sc.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return list;
	}
	
	public static long countStudentExist() {
		long count =0;
		try {
	      File file = new File("students.txt");
	      Scanner sc = new Scanner(file);
	      // docj theo dongf
	      while (sc.hasNextLine()) {
	        String data = sc.nextLine();
//	        System.out.println(data);
	        count++;
	      }
	      sc.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		return count;
	}
	// laasy code student ddeer check trungf
	public static String splitCode(String str){
		// cắ theo "code="
		String[] strs = str.split("code=");
		
		// lấy phần từ thứ 2 cắt tiếp theo ", " rồi lấy phần từ đầu là được code
		String[] strs2 = strs[1].split(", ");
		//trả về code
		return strs2[0];
	}
	
	// lấy ra danh sách code của tất cả học sinh trong file
	public static List<String> listCode(){
		List<String> list = new ArrayList<>();
		try {
	      File file = new File("students.txt");
	      Scanner sc = new Scanner(file);
	      while (sc.hasNextLine()) {
	    	  String data = sc.nextLine();
	    	  list.add(splitCode(data));
	      }
	      sc.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		return list;
	}

}
