package bail0;


import static bail0.Constants.STUDENT_VALIDATE.*;

import static bail0.Constants.STUDENT_GPA.*;

import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import bail0.Student;
import bail0.Utils;
import bail0.Constants.STUDENT_GPA;
import bail0.Constants;
import bail0.StatisLEVEL;

public class Exercise {
	
	// tạo 1 mảng tĩnh lưu trữ sinh viên
	
	private static final int MAX = 1000;  // số phần tử
	
	private static int index = 0;			// vị trí/số thứ tự của phần tử
	private static Student[] students = new Student[MAX];
	
	// chuyển sang mảng động list
	private static List<Student> list = Arrays.asList(students);
//	List<Student> students = new ArrayList<>();
	private static StatisLEVEL level[] = {
			new StatisLEVEL(0,KEM),
			new StatisLEVEL(0,YEU),
			new StatisLEVEL(0,TRUNGBINH),
			new StatisLEVEL(0,KHA),
			new StatisLEVEL(0,GIOI),
			new StatisLEVEL(0,XUATSAC)
			};
	
	
	
	// tạo scanner đọc dữ liệu từ các nguồn nhập từ bàn phím
	private static Scanner ca = new Scanner(System.in);
	
	// điều kiện id
		public static boolean validateId(String id, List<Student> students) {
			try {
				boolean checkExist = false;
				for(Student s: students) {
					if(s.getId()==Integer.parseInt(id)) {
						checkExist = true;
						break;
					}
				}
				if(!checkExist) {
					System.out.println("Không tồn tại id");
					return false;
				}
				if(id.matches("\\d+")) {
					return true;
				}
			}catch (NumberFormatException e) {
				System.out.println("Phải nhập số nguyen duong");
				return false;
			}
			return false;
		}
	
	// điều kiện name
	public static boolean validateNameLength(String name) {
		
		if(name!=null && !name.isEmpty()) {
			
			if(nameLength > name.length()){
				return true;
			}
			System.out.println("Tên không quá 100 ký tự");
		}
		System.out.println("Nhập lại tên");
		return false;
	}
	
	// diều kiện Dob
	public static boolean validateDob(String dob) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			if(dob.matches("([0-9]{2})\\-([0-9]{2})\\-([0-9]{4})")) {
				if(dob != null) {
					if(minDob < LocalDate.parse(dob, dateTimeFormatter).getYear()) {
						
						return true;
					}
					System.out.println("Năm lớn hơn 1900");
				}
			}
			
		} catch (Exception e) {
			System.out.println("Nhập lại ngày sinh");
			return false;
		}
		
		System.out.println("Nhập lại ngày sinh");
		return false;
	}
	
	// điều kiện dịa chỉ
	public static boolean validateAddress(String address) {
		if (!address.isEmpty()) {
			
			if (address.length()< addressLength) {
				return true;
			}
			System.out.println("Địa chỉ không quá 300 ký tự ");
		}
		System.out.println("Nhập lại địa chỉ ");
		return false;
	}
	
	// điều kiện chiều cao
	public static boolean validateHeight(String height) {
		try {
			if(!height.matches("[a-zA-Z]+")) {
				if (minHeight < Double.parseDouble(height) && Double.parseDouble(height) < maxHeight) {
					return true;
				}
				System.out.println("Chiều cao từ 50.0 - 300.0 cm");
			}
		}catch (NumberFormatException e) {
			System.out.println("Phải nhập số thập phân(.)");
			return false;
		}
		return false;
	}
	
	
	// điều kiện can nang
	public static boolean validateWeight(String weight) {
		try {
			if(!weight.matches("[a-zA-Z]+")) {
				if (minWeight < Double.parseDouble(weight) && Double.parseDouble(weight) < maxWeight) {
					return true;
				}
				System.out.println("Can nang từ 5.0 - 1000.0 kg");
			}
		}catch (NumberFormatException e) {
			System.out.println("Phải nhập số thập phân(.)");
			return false;
		}
		return false;
	}
	
	// điều kiện mã sinh viên
	public static boolean validateCode(String code) {
		if (code!=null && !code.isEmpty()) {

			List<String> listCode = FIleStudent.listCode();
			for(String s: listCode) {
				if(s.equalsIgnoreCase(code)) {
					System.out.println("Mã sinh viên đã tồn tại");
					return false;
				}
			}
			if ((code.trim()).length()== codeLength) {
				
				return true;
			}
			System.out.println("Mã sinh viên 10 ký tự ko khoảng trắng");
		}
		System.out.println("Nhập lại mã sinh viên ");
		return false;
	}
	
	// điều kiên trường đang hoc
	public static boolean validateSchoolLength(String school) {
			
			if(school!=null && !school.isEmpty()) {
				
				if(schoolLength > school.length()){
					return true;
				}
				System.out.println("Trường không quá 200 ký tự");
			}
			System.out.println("Nhập lại trường");
			return false;
		}
	
	// điều kiện năm bắt dầu
	public static boolean validateStartDate(String startDate) {
		
		try {
			if(!startDate.matches("[a-zA-Z]+")) {
				if (minStartDate < Double.parseDouble(startDate) ) {
					return true;
				}
				System.out.println("nam lon hon 1900");
			}
		}catch (NumberFormatException e) {
			System.out.println("Phải nhập số int");
			return false;
		}
		return false;
	}
	
	// điều kiện điểm trung binh
		public static boolean validateGpa(String gpa) {
			try {
				if(!gpa.matches("[a-zA-Z]+")) {
					if (minGpa < Double.parseDouble(gpa) && Double.parseDouble(gpa) < maxGpa) {
						return true;
					}
					System.out.println("gpa từ 0.0 - 10.0 ");
				}
			}catch (NumberFormatException e) {
				System.out.println("Phải nhập số thập phân(.)");
				return false;
			}
			return false;
			
		}
	
       // khai báo level trên student
		public static boolean validateLevel(Student student) {
			if(KEM.evalueMIN <= student.getGpa() && student.getGpa()<= KEM.evalueMAX) {
				student.setLevel(KEM);
			}
			if(YEU.evalueMIN <= student.getGpa() && student.getGpa()<= YEU.evalueMAX) {
				student.setLevel(YEU);
			}
			if(TRUNGBINH.evalueMIN <= student.getGpa() && student.getGpa()<= TRUNGBINH.evalueMAX) {
				student.setLevel(TRUNGBINH);
			}
			if(KHA.evalueMIN <= student.getGpa() && student.getGpa()<= KHA.evalueMAX) {
				student.setLevel(KHA);
			}
			if(GIOI.evalueMIN <= student.getGpa() && student.getGpa()<= GIOI.evalueMAX) {
				student.setLevel(GIOI);
			}
			if(XUATSAC.evalueMIN <= student.getGpa() && student.getGpa()<= XUATSAC.evalueMAX) {
				student.setLevel(XUATSAC);
			}
			
		
			return false;
		}	
		
		// tim theo id
		// kiểm tra id có trong danh sách ko
		public static Integer inputId() {
			
			boolean checkValidateId = false;
			while (!checkValidateId) {
				System.out.println("Type id Student pts: ");
				String id = ca.nextLine();
				checkValidateId=validateId(id, FIleStudent.getAllStudent());
				if(checkValidateId) {
					return Integer.parseInt(id);
				}
			}

			return null;
		}
		
		public static Student getById(Integer id) {// learn java 8
			// lấy tất cả học sinh trong ds
			List<Student> listAll = FIleStudent.getAllStudent();
			// chuyển từ đọng qua tĩnh mảng
			Student[] studentss = listAll.toArray(new Student[MAX]);
			// tìm id
			Optional<Student> optionalStu = Stream.of(studentss).filter(item -> item.getId() == id).findFirst(); //search id
			// nếu tìm thấy
			if(optionalStu.isPresent()) {
				Student stu = optionalStu.get(); 
				Integer index= -1;
				// lấy vị trí của st
				for(int i=0;i<listAll.size();i++) {
					if(listAll.get(i).getId()==id) {
						index = i;
						break;
					}
				}
				System.out.println(stu.toString(index));
				return stu;
			}else {
				System.out.println("Notfound Student vs id: " + id);
				new RuntimeException();
			}
			return null;
		}
		
		public static Student getByName() {// learn java 8
			System.out.print("Nhập tên: ");
			String name = ca.nextLine();
			// lấy tất cả học sinh trong ds
			List<Student> listAll = FIleStudent.getAllStudent();
			
			Integer index= -1;
			// lấy vị trí của st
			for(int i=0;i<listAll.size();i++) {
				if(listAll.get(i).getName().equalsIgnoreCase(name)) {
					index = i;
					break;
				}
			}
			if(index == -1 ) {
				System.out.println("Không tìm thấy học sinh có tên: " + name);
			}else {
				Student stu = listAll.get(index);
				System.out.println(stu.toString(index));
				return stu;
			}
			
			return null;
		}
		
		
		
		// tao ds Student
		public static Student createSutdent() {
			boolean validateName = false;
			boolean validateDob = false;
			boolean validateAddress = false;
			boolean validateHeight = false;
			boolean validateWeight = false;
			boolean validateCode = false;
			boolean validateSchoolLength = false;
			boolean validateStartDate = false;
			boolean validateGpa = false;
			Student student = new Student();
			
			// validate name 
			while(!validateName) {
				System.out.println("Type student name: ");
				student.setName(ca.nextLine());
				validateName = validateNameLength(student.getName());
			}
			
			
			// validate dob 
			while(!validateDob) {
				System.out.println("Type student Dob: ");
				String dobValue = ca.nextLine();
				validateDob = validateDob(dobValue);
				if(validateDob) {
					DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					student.setDob(LocalDate.parse(dobValue, dateTimeFormatter));
				}
			}
			
			// validate address 
			while(!validateAddress) {
				System.out.println("Type student address: ");
				student.setAddress(ca.nextLine());
				validateAddress = validateAddress(student.getAddress());
			}

			
			// validate height
			while(!validateHeight) {
				System.out.println("Type student height: ");
				String height = ca.nextLine();
				validateHeight = validateHeight(height);
				if(validateHeight) {
					student.setHeight(Double.parseDouble(height));
				}
			}
			
			// validate weight
			while(!validateWeight) {
				System.out.println("Type student weight: ");
				String weight = ca.nextLine();
				validateWeight = validateWeight(weight);
				if(validateWeight) {
					student.setWeight(Double.parseDouble(weight));
				}
			}
			
			// validate code 
			while(!validateCode) {
				System.out.println("Type student code: ");
				student.setCode(ca.nextLine());
				validateCode = validateCode(student.getCode());
			}
			
			// validate school
			while(!validateSchoolLength) {
				System.out.println("Type student school: ");
				student.setSchool(ca.nextLine());
				validateSchoolLength = validateSchoolLength(student.getSchool());
			}
			
			// validate StartDate
			while(!validateStartDate) {
				System.out.println("Type student startDate: ");
				String startDate = ca.nextLine();
				validateStartDate = validateStartDate(startDate);
				if(validateStartDate) {
					student.setStartDate(Integer.parseInt(startDate));
				}
			}
			
			// validate gpa
			while(!validateGpa) {
				System.out.println("Type student gpa: ");
				String gpa = ca.nextLine();
				validateGpa = validateGpa(gpa);
				if(validateGpa) {
					student.setGpa(Double.parseDouble(gpa));
				}
			}
			// lấy tất cả học sinh trong file
			List<Student> listAll = FIleStudent.getAllStudent();
			// lấy ra học sinh cuối rùi lấy id của bạn tiếp là id++
			student.setId(listAll.get(listAll.size()-1).getId()+1);
			validateLevel(student);
			// xét số thứ tự
			Integer nextIndex = listAll.size();
			// thỏa mãn điều điện thì ghi vào file
			if(validateName && validateDob && validateAddress && validateHeight && validateWeight &&
					validateCode && validateSchoolLength && validateStartDate && validateGpa) {
				FIleStudent.writeFile(student,nextIndex);
			}
			return student;
		}


		// updateStuden theo id

		public static List<Student> updateStudent() {
			// tạo 1 mảng hs mới để lưu thông tin hs cũ và mới ra màn hình
			List<Student> studentss = new ArrayList<>();
			Integer id = inputId();
			// láy ra studen theo id
			// lưu student cũ vào phẩn tử đầu trong mảng
			
			Student student = getById(id);
			Student studentOld = getById(id);
			studentss.add(studentOld);
			
			boolean validateName = false;
			boolean validateDob = false;
			boolean validateAddress = false;
			boolean validateHeight = false;
			boolean validateWeight = false;
			boolean validateCode = false;
			boolean validateSchoolLength = false;
			boolean validateStartDate = false;
			boolean validateGpa = false;
			
			// validate name 
			while(!validateName) {
				System.out.println("Type student name: ");
				student.setName(ca.nextLine());
				validateName = validateNameLength(student.getName());
			}
			
			
			// validate dob 
			while(!validateDob) {
				System.out.println("Type student Dob: ");
				String dobValue = ca.nextLine();
				validateDob = validateDob(dobValue);
				if(validateDob) {
					DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					student.setDob(LocalDate.parse(dobValue, dateTimeFormatter));
				}
			}
			
			// validate address 
			while(!validateAddress) {
				System.out.println("Type student address: ");
				student.setAddress(ca.nextLine());
				validateAddress = validateAddress(student.getAddress());
			}

			
			// validate height
			while(!validateHeight) {
				System.out.println("Type student height: ");
				String height = ca.nextLine();
				validateHeight = validateHeight(height);
				if(validateHeight) {
					student.setHeight(Double.parseDouble(height));
				}
			}
			
			// validate weight
			while(!validateWeight) {
				System.out.println("Type student weight: ");
				String weight = ca.nextLine();
				validateWeight = validateWeight(weight);
				if(validateWeight) {
					student.setWeight(Double.parseDouble(weight));
				}
			}
			
			// validate code 
			while(!validateCode) {
				System.out.println("Type student code: ");
				student.setCode(ca.nextLine());
				validateCode = validateCode(student.getCode());
			}
			
			// validate school
			while(!validateSchoolLength) {
				System.out.println("Type student school: ");
				student.setSchool(ca.nextLine());
				validateSchoolLength = validateSchoolLength(student.getSchool());
			}
			
			// validate StartDate
			while(!validateStartDate) {
				System.out.println("Type student startDate: ");
				String startDate = ca.nextLine();
				validateStartDate = validateStartDate(startDate);
				if(validateStartDate) {
					student.setStartDate(Integer.parseInt(startDate));
				}
			}
			
			// validate gpa
			while(!validateGpa) {
				System.out.println("Type student gpa: ");
				String gpa = ca.nextLine();
				validateGpa = validateGpa(gpa);
				if(validateGpa) {
					student.setGpa(Double.parseDouble(gpa));
				}
			}
			validateLevel(student);
			// thêm thông tin học sinh mới vào phần tử thứ 2 trong mảng
			studentss.add(student);
			return studentss;
		}
		
		public static List<Student> delete() {
			Integer id = inputId();
			List<Student> listAll = FIleStudent.getAllStudent();
			for(int i=0;i<listAll.size();i++) {
				if(listAll.get(i).getId()==id) {
					listAll.remove(i);
					break;
				}
			}
			return listAll;
		}
		
		
		// thống kê % học lưc
		
		public static void executeStatic() {
			// lấy tất cả học sinh trong ds
			List<Student> listAll = FIleStudent.getAllStudent();
			// chuyển từ đọng qua tĩnh mảng
//			Student[] studentss = listAll.toArray(new Student[MAX]);
			// taọ list mới
			List<StatisLEVEL> statisLEVELs = new ArrayList<>();
			
			long total = FIleStudent.countStudentExist();
			long totalKem = 0;
			long totalYeu = 0;
			long totalTrungBinh = 0;
			long totalKha = 0;
			long totalGioi = 0;
			long totalXuatSac = 0;
			for(Student s: listAll) {
				if(s.getLevel().toString().equalsIgnoreCase("KEM")) {
					totalKem++;
				}else if(s.getLevel().toString().equalsIgnoreCase("YEU")) {
					totalYeu++;
				}else if(s.getLevel().toString().equalsIgnoreCase("TRUNGBINH")) {
					totalTrungBinh++;
				}else if(s.getLevel().toString().equalsIgnoreCase("KHA")) {
					totalKha++;
				}else if(s.getLevel().toString().equalsIgnoreCase("GIOI")) {
					totalGioi++;
				}else if(s.getLevel().toString().equalsIgnoreCase("XUATSAC")) {
					totalXuatSac++;
				}
			}
			//add vào list
			statisLEVELs.add(new StatisLEVEL((double)totalKem/(double)total * 100,KEM));
			statisLEVELs.add(new StatisLEVEL((double)totalYeu/(double)total * 100,YEU));
			statisLEVELs.add(new StatisLEVEL((double)totalTrungBinh/(double)total * 100,TRUNGBINH));
			statisLEVELs.add(new StatisLEVEL((double)totalKha/(double)total * 100,KHA));
			statisLEVELs.add(new StatisLEVEL((double)totalGioi/(double)total * 100,GIOI));
			statisLEVELs.add(new StatisLEVEL((double)totalXuatSac/(double)total * 100,XUATSAC));
			
			
//			level[0] = new StatisLEVEL((double)totalKem/(double)total * 100,KEM);
//			level[1] = new StatisLEVEL((double)totalYeu/(double)total * 100,YEU);
//			level[2] = new StatisLEVEL((double)totalTrungBinh/(double)total * 100,TRUNGBINH);
//			level[3] = new StatisLEVEL((double)totalKha/(double)total * 100,KHA);
//			level[4] = new StatisLEVEL((double)totalGioi/(double)total * 100,GIOI);
//			level[5] = new StatisLEVEL((double)totalXuatSac/(double)total * 100,XUATSAC);
			
			
			
//			Optional<Student> optionalStu = Stream.of(studentss).filter(item -> item.getId() == id).findFirst();
//			
//			// Kem 
//			long countKem = Arrays.stream(studentss).filter(item -> item.getLevel().equals(KEM)).count();
//			level[0] = new StatisLEVEL(countKem/total * 100,KEM);
//			// Yeu 
//			long countYeu = Arrays.stream(studentss).filter(item -> item.getLevel().equals(YEU)).count();
//			level[1] = new StatisLEVEL(countYeu/total * 100,YEU);
//			
//			// TRUNGBINH 
//			long countTrungBinh  = Arrays.stream(studentss).filter(item -> item.getLevel().equals(TRUNGBINH)).count();
//			level[2] = new StatisLEVEL(countTrungBinh/total * 100,TRUNGBINH );
//			
//			// KHA 
//			long countKha  = Arrays.stream(studentss).filter(item -> item.getLevel().equals(KHA)).count();
//			level[3] = new StatisLEVEL(countKha/total * 100,KHA );
//
//			// GIOI
//			long countGioi  = Arrays.stream(studentss).filter(item -> item.getLevel().equals(GIOI)).count();
//			level[4] = new StatisLEVEL(countGioi/total * 100,GIOI );
//			
//			// XuatSAc
//			long countXuatSac  = Arrays.stream(studentss).filter(item -> item.getLevel().equals(XUATSAC)).count();
//			level[5] = new StatisLEVEL(countXuatSac/total * 100,XUATSAC) ;
			
			
			System.out.println("du lieu thong ke hoc luc");
	// lấy từ bé đến lớn
			Collections.sort(statisLEVELs, new StatisLEVELComparator());
			// đảo ngược lại
			Collections.reverse(statisLEVELs);
			// in ra
			for(StatisLEVEL s: statisLEVELs) {
				System.out.println(s.toString());
			}
//			for(int i=0 ; i<level.length ; i++) {
//				System.out.println(level[i].toString());
//				
//			}
			
		}
		
		
		public static void gpaStatis() {
			// lấy tất cả học sinh trong ds
			List<Student> listAll = FIleStudent.getAllStudent();
			Map<Double, Double> mapGpa = new HashMap<>();
			long total = FIleStudent.countStudentExist();
			for(int i=0;i<listAll.size();i++) {
				long totalItem = 0;
				for(int j=0;j<listAll.size();j++) {
					if(listAll.get(i).getGpa()==listAll.get(j).getGpa()) {
						totalItem++;
					}
				}
				mapGpa.put(listAll.get(i).getGpa(), (double)totalItem/(double)total *100);
			}
			// tạo 1 phương thuc set mới gán cho key của map gpa
			Set<Double> set = mapGpa.keySet();
			for(Double key: set) {
				System.out.println("Điểm "+key +": "+mapGpa.get(key)+"% ");
			}
			
			System.out.println("Sắp xếp theo điểm từ bé đến lớn");
			// sắp xếp theo điểm từ bé đến lớn
			TreeMap<Double, Double> mapGpaSort = new TreeMap<Double, Double>(mapGpa);
			Set<Map.Entry<Double, Double>> mapGpaSortSet = mapGpaSort.entrySet();
			for(Map.Entry<Double, Double> m: mapGpaSortSet) {
				System.out.println("Điểm "+m.getKey() +": "+m.getValue()+"% ");
				FileOutput.writeFile("Điểm "+m.getKey() +": "+m.getValue()+"% ");
			}
			
		}
		
		
}
