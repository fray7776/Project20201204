package stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		//1부터 100까지 숫자 가져오기
		// range or rangeclosed로 stream 만들기
		//짝수만 결과 출력
		
		IntStream.range(1,100).filter((value)-> value%2 ==0)
		.forEach((value)->System.out.println(value)); //forEach는 루핑을 돌면서 값을 출력해준다.
		                                              //forEach는 리턴(결과)값이 없기 때문에 매개값을 넣을수 없다.
		int a=IntStream.range(1,100).filter((value)-> value%2 ==0)
		.sum(); 
		System.out.println(a);	//sum을 사용해서 짝수를 더하려면, sum은 매개값을 지정해서 출력, sum은 결과값이 있고,
		                        //기능을 받지 않기 때문에 sum()으로 사용
		                        
		int[] intAry = {2,4,6,8,9,1,7,1111};
		IntStream is = Arrays.stream(intAry);
		
		System.out.println("-----------------------------------");
		
		int max1 = is.max().getAsInt(); //getAsInt는 메소드!
		System.out.println(max1);
		
		System.out.println("-----------------------------------");
		
		is = Arrays.stream(intAry);
		int min = is.min().getAsInt();
		System.out.println(min);
		
		System.out.println("-----------------------------------");
		
		is = Arrays.stream(intAry);
		double avg = is.average().getAsDouble();
		System.out.println(avg);
		
		System.out.println("-----------------------------------");
		
		//조건(filter)
		Arrays.stream(intAry).filter((b)-> b%2==0).forEach((b)-> System.out.println(b));
		
	}

}
