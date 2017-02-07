import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTest {

	Service service = null;
	@Before
	public void setup(){
		service = new Service();
	}
	@Test(expected=Exception.class)
	public void testCheckNegative() throws Exception{
			service.getPrimeNumber(-1);
	}
	
	@Test
	public void testPrime() throws Exception{
		int[] result = new int[]{2,3,5,7,11};
		int[] array = service.getPrimeNumber(11);
		
		Assert.assertArrayEquals(result, array);
	}
	
	
	
	
}
