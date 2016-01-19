package bloomberg;

import java.util.ArrayList;

public class merge_Integer {
	public static void main(String[] args){
		int[] input = {1,2,4,6,7,9,10,11};
		int start = input[0];
		int end = input[0];
		ArrayList<String> result = new ArrayList<String>();
		for(int i=1;i<input.length;i++){
			if(input[i]==end+1) {
				end = input[i];
				//System.out.println(start+" "+end);
			}
			
			else{
				String str = "";
				if(start==end) {
					
					str = str+start;
					result.add(str);
				}
				else{
				str = ""+start+"-"+end;
				result.add(str);
				}
				start = input[i];
				end = input[i];	
			}
		}
		if(start==end) result.add(start+"");
		else result.add(start+"-"+end);
		
		System.out.println(result.toString());
	}

}
