package stream;

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	@Override
	public int compareTo(Student o) {
		if(this.score <o.score )
		return -1;  //오름차순 :음수 , 같다 : 0 내림차순 : 양수
		else
			return -1;
		
		//return this.score > o.score ? 1 : -1; (어떻게 같다는 거지?)
		//return o.score - this.score;
	}
	
	

}
