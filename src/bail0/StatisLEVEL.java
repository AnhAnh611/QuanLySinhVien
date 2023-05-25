package bail0;

import bail0.Constants;
import bail0.Constants.STUDENT_GPA;

public class StatisLEVEL {
	
	public double percent;
	public Constants.STUDENT_GPA level;

	
	public StatisLEVEL(double percent, STUDENT_GPA level) {
		this.percent = percent;
		this.level = level;
	}
	
	
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public Constants.STUDENT_GPA getLevel() {
		return level;
	}
	public void setLevel(Constants.STUDENT_GPA level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "StatisLEVEL [percent=" + percent +"%" +", level=" + level.name() + "] \n";
	}
}
// khởi tạo comparator mới để so sánh
class StatisLEVELComparator implements java.util.Comparator<StatisLEVEL> {
    @Override
    public int compare(StatisLEVEL a, StatisLEVEL b) {
        return (int) (a.getPercent() - b.getPercent());
    }
}