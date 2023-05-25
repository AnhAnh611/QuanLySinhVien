package bail0;

public class Constants {
	
	// tạo bộ kiểm tra để xác nhận điều kiện giới hạn
	public static class STUDENT_VALIDATE{
		public static final int nameLength = 100;
		public static final int minDob = 1900;
		public static final int addressLength = 300;
		public static final double minHeight = 50.0;
		public static final double maxHeight = 300.0;
		public static final double minWeight = 5.0;
		public static final double maxWeight = 1000.0;
		public static final int codeLength = 10;
		public static final int schoolLength = 200;
		public static final int minStartDate = 1900;
		public static final double minGpa = 0;
		public static final double maxGpa = 10.0;
	}
	
	public enum STUDENT_GPA{
		KEM(0,3),YEU(3,5),TRUNGBINH(5, 6.5),KHA(6.5,7.5),GIOI(7.5,9),XUATSAC(9,10);
		public double evalueMIN;
		public double evalueMAX;
		
		STUDENT_GPA(double evalueMIN, double evalueMAX) {
			this.evalueMIN = evalueMIN;
			this.evalueMAX = evalueMAX;
		}
	}
}
