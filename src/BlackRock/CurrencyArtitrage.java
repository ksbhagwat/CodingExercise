import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CurrencyArtitrage {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT_PATH"));
        int[] res;
        
        int _quotes_size = 0;
        _quotes_size = Integer.parseInt(in.nextLine().trim());
        String[] _quotes = new String[_quotes_size];
        String _quotes_item;
        for(int _quotes_i = 0; _quotes_i < _quotes_size; _quotes_i++) {
            try {
                _quotes_item = in.nextLine();
            } catch (Exception e) {
                _quotes_item = null;
            }
            _quotes[_quotes_i] = _quotes_item;
        }
        
        res = arbitrage(_quotes);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        
        bw.close();
    }

	
	static int[] arbitrage(String[] quotes) {
		int[] result = new int[quotes.length];
		int cnt = 0;
		for(String quote : quotes){
			String[] rates = quote.split(" ");
			double euro =  100000 / Double.parseDouble(rates[0]) ;
			double gbp = euro / Double.parseDouble(rates[1]) ;
			double usd = gbp / Double.parseDouble(rates[2]) ;
			Double artitrage = new Double (Math.round( usd -100000d  ));
			result[cnt] = artitrage >0 ?artitrage.intValue() : 0;
			cnt++;
		}
		
		return result;
    }
	
 

}
