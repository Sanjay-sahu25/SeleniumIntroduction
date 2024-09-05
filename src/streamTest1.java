import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class streamTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Rahul");
		names.add("Don");
		names.add("Arun");
		names.add("Andrew");
		// there is no life for intermediate opeartion if there is no terminal op
		//terminal opreation will execute only if inter op(filter) returns is true
		//we can create stream
		//how to use filter in Stream API
		long c= names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		long d = Stream.of("Abhishek","Rahul","Don","Arun","Andrew").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		
	   System.out.println(d);
	   //print all the names of Arraylist
	   //names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
	   names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	   
	   
	   //streamMap
	   //print names of which have last letter as "a" with Uppercase
	   
	   Stream.of("Abhishek","Rahul","Alekhya","Arun","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	   
	   ArrayList<String> names2 = new ArrayList<String>();
		names.add("man");
		names.add("Rahul");
		names.add("women");
	   //print names which have first letter as "a" with uppercase and sorted
	   List<String>  names3 = Arrays.asList("Azbhishek","Rahul","Don","Arun","Andrew");
	   names3.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	   	
	   //Merging 2 different lists
	   Stream<String> newStream = Stream.concat(names2.stream(), names3.stream());
	   //newStream.sorted().forEach(s->System.out.println(s));
	   
	   boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("DON"));
	   System.out.println(flag);
	   Assert.assertTrue(flag);
	   
	   //collect
	   
	  List<String> ls = Stream.of("Abhishek","Rahul","Alekhya","Arun","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).
			  collect(Collectors.toList());
	  System.out.println(ls.get(0));
	  
	  List<Integer>  values = Arrays.asList(3,2,2,7,5,1,9,7);
	  //print unique numbers
	  //sort array
	  //values.stream().distinct().forEach(s->System.out.println(s));
	  List<Integer> li= values.stream().distinct().sorted().collect(Collectors.toList());
	  System.out.println(li.get(2));
	  
	
	}

}
