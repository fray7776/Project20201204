package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		List<String> list = null;
//		list.add("ㅂ");
		list = Arrays.asList("Song", "Hye", "Won", "YEAH", "YO");

		Stream<String> stream = list.stream();
		stream.filter((t) -> t.length() > 3).forEach((t) -> System.out.println(t));

		// BaseStream -> Stream<T>, IntStream, LongStream, DoubleStream
		// IntStream: Stream<Integer> LongStream: Stream<Long> DoubleStream:
		// stream<double>

		String[] strAry = { "Song", "Hye", "Won" };
		Stream<String> strstream = Arrays.stream(strAry);

		int[] intAry = { 1, 2, 3, 4, 5 };
		IntStream intStrem = Arrays.stream(intAry);

		
		
		
	    double[] dblAry= {1.1,2.2,3.3,4.4,5.5,6.6};
	    DoubleStream dblStream = Arrays.stream(dblAry);
	    
	    dblStream.forEach(new DoubleConsumer() {
	    	double result = 0;

			@Override
			public void accept(double value) {
				result +=value;
				System.out.println(result);
				
			}
	    	
	    });
	    IntStream is= IntStream.range(1, 10);
	    is.forEach(n -> System.out.println(n));
	    
	    is = IntStream.rangeClosed(1,10);
	    System.out.println("합: " + is.sum());
	    
	    Path path = Paths.get("list.txt"); //C:\Dev\workspace\Project20201204에 만든 txt파일
	    
	    try {
			Stream<String> stream1 = Files.lines(path);
			stream1.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    path = Paths.get("c:/Program files");
	    try {
			Stream<Path> pStream = Files.list(path);
			pStream.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
