package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class ReduceExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(//
				new Student("Song", 100), new Student("Park", 80), new Student("Lee", 95));
		int sum = list.stream().mapToInt(t -> t.getScore()).sum();
		System.out.println("합계>>>" + sum);

		// reduce
		int result = list.stream().mapToInt(t -> t.getScore()).reduce(new IntBinaryOperator() {

			@Override
			public int applyAsInt(int left, int right) {
				System.out.println("left " + left + "right " + right);
				return left + right;
			}

		}).getAsInt();
		System.out.println("합은>>> " + result);

		System.out.println("결과값: " + result);
		result = list.stream()
				.mapToInt(t -> t.getScore()) //mapToInt를 써서 getscore만 가져옴
				.reduce(0, (left, right) -> left + right);
		System.out.println("결과값: " + result);

		result = list.stream().mapToInt(t -> t.getScore()).reduce(0,(left, right) -> left > right ? left : right);
		System.out.println("최대값: " + result);
		
		result = list.stream().mapToInt(t -> t.getScore()).reduce((left, right) -> left < right ? left : right)
				.getAsInt();
		System.out.println("최소값: " + result); //reduce(0,~~)이면 0이랑 비교하는 거라 최소값은 비교 불가, getAsInt로 가져와야함
		
		result = list.stream().mapToInt(t -> t.getScore()).reduce((left, right) -> (left+right)/2)
				.getAsInt();
		System.out.println("평균값: " + result);
		
		
	}

}
