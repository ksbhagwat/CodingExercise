import java.util.ArrayList;
import java.util.List;

public class Service {

	public int[] getPrimeNumber(int limit) throws Exception{
		if(limit < 0) throw new Exception("Invalid Input .Please enter Positive number");
		List<Integer> primeNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= limit; i++)         
		{ 		  	  
			int counter=0; 	  
			for(int num =i; num>=1; num--)
			{
				if(i%num==0)
				{
					counter = counter + 1;
				}
			}
			if (counter ==2)
			{
				primeNumbers.add(i);
			}	
		}	
		int[] result = new int[primeNumbers.size()];
		for(int j = 0 ; j <primeNumbers.size() ; j++ ){
			result[j] = primeNumbers.get(j);
		}
		return result;
	}

}
