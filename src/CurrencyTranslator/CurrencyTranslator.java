import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CurrencyTranslator {

	 private static final String[] tensNames = {
			    "",
			    " ten",
			    " twenty",
			    " thirty",
			    " forty",
			    " fifty",
			    " sixty",
			    " seventy",
			    " eighty",
			    " ninety"
			  };

		  private static final String[] numNames = {
		    "",
		    " one",
		    " two",
		    " three",
		    " four",
		    " five",
		    " six",
		    " seven",
		    " eight",
		    " nine",
		    " ten",
		    " eleven",
		    " twelve",
		    " thirteen",
		    " fourteen",
		    " fifteen",
		    " sixteen",
		    " seventeen",
		    " eighteen",
		    " nineteen"
		  };

	public static void main(String[] args) {
		try {
			CurrencyTranslator translator = new CurrencyTranslator();
			translator.createSampleData();
			translator.readSampleData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createSampleData() throws IOException  {
		File currencyStore = new File("currency_store.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(currencyStore));
		try{
			for(int i = 0 ;i< 15 ; i++){
				BigDecimal currency = new BigDecimal(Math.random() * 20 );
				if(currency.doubleValue() == 0.0d ) continue;
				currency = currency.setScale(2, RoundingMode.CEILING);
				writer.newLine();
				writer.write(currency.toString());
			}
			
		}finally{
			writer.close();
		}
	}
	
	public void readSampleData() throws IOException  {
		File currencyStore = new File("currency_store.txt");
		File currencyStoreWords = new File("currency_store_words.txt");
		Scanner scanFile = new Scanner(currencyStore);
		BufferedWriter writer = new BufferedWriter(new FileWriter(currencyStoreWords));
		try{
			while(scanFile.hasNextLine()){
				BigDecimal currency = scanFile.nextBigDecimal();
				String result = parseNumToString(currency);
				writer.write(result);
				writer.newLine();
			}
		}finally{
			writer.close();
		}
	}
	
	public String parseNumToString(BigDecimal currency){
		StringBuilder result = new StringBuilder();
		int integral = currency.intValue();
		BigDecimal fraction = currency.subtract(new BigDecimal(integral));		
		int tenName = fraction.multiply(new BigDecimal(10)).intValue();
		int numName = fraction.multiply(new BigDecimal(100)).subtract(new BigDecimal(tenName * 10)).intValue();
		
		if( fraction.multiply(new BigDecimal(100)).doubleValue() <= 20){
			tenName = fraction.multiply(new BigDecimal(100)).intValue();
			result.append(numNames[integral]).append(" dollars and ").append(numNames[tenName]).append(" cents");
		}else{
			result.append(numNames[integral]).append(" dollars and ").append( tensNames[tenName]).append(numNames[numName]).append(" cents");
		}
		return result.toString();
	}
	

}
