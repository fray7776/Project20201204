package lambda;

public class Student {
	private String name;
	private String sex;
	private int score;
	
	public Student(String name, String sex, int score) {
		super();
		this.name = name;
		this.sex = sex;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public int getScore() {
		return score;
	}
	
	public void showInfoList() {
		System.out.println("학생이름: "+ name + "학생성별: " + sex + "학생점수: " +score);
	}
}
