import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HackLandElection {

	public static void main(String[] args) throws IOException {
		  Scanner in = new Scanner(System.in);
	        BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT_PATH"));
	        String res;
	        
	        int _votes_size = 0;
	        _votes_size = Integer.parseInt(in.nextLine().trim());
	        String[] _votes = new String[_votes_size];
	        String _votes_item;
	        for(int _votes_i = 0; _votes_i < _votes_size; _votes_i++) {
	            try {
	                _votes_item = in.nextLine();
	            } catch (Exception e) {
	                _votes_item = null;
	            }
	            _votes[_votes_i] = _votes_item;
	        }
	        
	        res = electionWinner(_votes);
	        bw.write(res);
	        bw.newLine();
	        
	        bw.close();
	    }
	
	static String electionWinner(String[] votes) {
		Map<String,Integer> votesMap = new HashMap<>();
		for(String vote :  votes){
			if(votesMap.containsKey(vote)){
				votesMap.put(vote, (votesMap.get(vote) + 1));
			}else{
				votesMap.put(vote, Integer.valueOf(1));
			}
		}
		int max = 0;
		LinkedList<String> resultList =  new LinkedList<>();
		for(String name : votesMap.keySet()){
			if(votesMap.get(name) > max){
				max = votesMap.get(name);
			}
		}
		for(String name : votesMap.keySet()){
			if(max ==  votesMap.get(name)){
				resultList.add(name);
			}
		}
		Collections.sort(resultList);
		return resultList.getLast();
	}

}
