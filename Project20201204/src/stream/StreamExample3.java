package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList();
		//메소드 만들기, 첫번쨰 매개값인 String을 받아서 반환되는 값은 문자열인 Stream으로 반환됨.
		strList.stream().flatMap(new Function<String, Stream<String>>() {

			@Override
			public Stream<String> apply(String t) {
				return Arrays.stream(t.split(" "));  //배열??? split은 ""안에 무엇이 있느냐에 따라 쪼개서 배열로 만들겠다는 의미.
				                      //return t.split(" "); <- 공란을 기준으로 쪼개서 배열로 만듬.
			}
			
		}).filter(s->s.startsWith("s")).forEach(s->System.out.println(s)); 
		
		strList.stream()
		.map(new Function<String, String>() { //map은 string으로 만들어주면 알아서 stream으로 반환시킴.

			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
			
		}).forEach(s-> System.out.println(s));
	   	System.out.println("--------------------------------------");
		//student를 담아서 ...
		List<Student> students = Arrays.asList(
				new Student("Song hye won","F",100),
				new Student("Michael Jackson","M",80),
				new Student("Sara","F",89),
				new Student("Vernard","M",75)
				);
		double avg = students.stream().mapToInt(new ToIntFunction<Student>() {
			
         
			@Override
			public int applyAsInt(Student a) {
				return a.getScore();
			}
			
		}).average()
		  .getAsDouble();
           System.out.println(avg);
		   
		
	}

}
/*  List<String> strList = Arrays.asList("Hello Stranger","WOW");
		strList.stream().flatMap(t-> t.split(" "))
		.filter(s->s.startsWith("s")).forEach(s->System.out.println(s)); 
	   	
	}

}  

*/