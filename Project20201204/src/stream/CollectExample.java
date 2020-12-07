package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//collect를 활용해서 최종결과값을 다시 컬렉션으로 만들어보자
public class CollectExample {
	public static void main(String[] args) {
		
		List<Student> list = Arrays.asList(//
				new Student("Song", 100), new Student("Park", 80), new Student("Lee", 85));
		List<Student> student80s = list.stream().filter(s -> s.getScore() / 10 == 8).sorted() // 정렬
				.collect(Collectors.toList()); // 이미 구현되어진 class를 사용(collectors.toList
		
		for (Student student : student80s) {
			System.out.println("이름: " + student.getName() + " 점수: " + student.getScore());
		}
		// .forEach(System.out::println);// student타입을 tosting으로 호출(student class에 있는..)
		// forEach(s -> sysout(s))과 똑같은 말, 대신 조건은 s가 어떠한 기능 없이 매개값의 기능만 한다면 써도됨.

		Map<String, Integer> map = list.stream()//리턴타입은 map타입
		.filter(s -> s.getScore() / 10 == 8)//
		.sorted() // 정렬
		.collect(//
			Collectors.toMap(//
				(t)-> t.getName(),  //key
				(t)-> t.getScore() //value
				)
				); //end of collect
		Set<String> set = map.keySet();
		for(String key : set) {
			System.out.println("KEY: " + key + " VALUE: " + map.get(key));
		}
	}

}
