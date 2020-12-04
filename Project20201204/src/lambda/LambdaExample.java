package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class LambdaExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList( // collection 만들어주는 메소드
				new Student("Hong", "MALE", 70), new Student("Hwang", "FEMALE", 80), new Student("Park", "MALE", 90),
				new Student("Choi", "FEMALE", 85));

		// 1.여학생정보 : 이름 - 점수
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				System.out.println("이름: " + student.getName() + "- 점수: " + student.getScore());
			}

		}

		// 2.전체학생: 점수 80점 초과인 학생 list
		for (Student student : list) {
			if (student.getScore() > 80) {
//				System.out.println("80점 초과인 학생 list는?? " + student.getShowInfoList());
			}

		}

		// 3.남학생의 총점 : 남학생총점(160점 나오게..)

		int sum = 0;
		for (Student student : list) {

			int result = student.getScore();

			if (student.getSex().equals("MALE")) {
				sum += result;

			}
		}
		System.out.println(sum);

		// 4.여학생의 평균: 여학생평균(82.5점이 나오게..)
		double avg = 0;
		int count = 0;
		double result = 0;
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				result += student.getScore();
				count++;
				
			} avg = result/count;

			}System.out.println("여학생들의 평균은?? " + avg);
			

			// 반복문(반복자): Stream(반복자) collection을 stream타입으로 변경해야 한다.
			// 스트림 생성 -> 소진.
			Stream<Student> stream = list.stream();
			stream.filter((t) -> t.getSex().equals("FEMALE"))
			.forEach((t) -> System.out.println(t.getName() + "-" + t.getScore()));// 만들어진 stream요소들(student 4명)에 대해 반복적으로 출력
			
			stream = list.stream();
			stream.filter(t->t.getScore() > 80)//predicate는 <? super T>이기 때문에 올수 있는 타입은 
                                               //student 타입만 올 수 있다. 
            .forEach(t -> System.out.println(t.getName()+t.getScore()));//화면출력

			//남학생
			int sum1 = list.stream().filter(t->t.getSex().equals("MALE"))
			.mapToInt((value) ->value.getScore())  //학생클래스의 값 중 score만 가져오겠다는..
			.sum();
			
			//평균
			double avg1 = list.stream().filter(t -> t.getSex().equals("FEMALE"))
			.mapToInt(s -> s.getScore())
			.average()
			.getAsDouble();
			System.out.println("평균: " + avg1);	
		
			// Stream<Student> stream = list.stream();
			// Stream.filter((t)-> t.getSex().equals("MALE"))
			// Stream.forEach((t)-> sysout(t.getName()+"-"+ t.getScore())

		}
	}

