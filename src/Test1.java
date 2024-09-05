import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Test1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//count the names staring with A.
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Rahul");
		names.add("Don");
		names.add("Arun");
		names.add("Andrew");
		int count = 0;
		for(int i=0;i<names.size();i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			
			}
		}
		System.out.println(count);
		
}
}