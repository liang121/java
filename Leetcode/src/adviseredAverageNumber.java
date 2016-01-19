
/*
 * Write a program to display the advisered average for the list of 
 * numbers my omitting the three largest number in the series.
 * E.g:3,6,12,55,289,600,534,900,172.  
 * avg = (3+6+12+55+289+172)/6 and eliminating 534,900,600
 */
public class adviseredAverageNumber{
	public static void main(String[] args){
		int[] input = {3,6,600,534,12,55,289,172,900};
		System.out.println(getav(input));
	}
	public static Double getav(int[] input){
		if(input.length<3){
			System.out.println("oops!! Input is not correct, please give at least 3 numbers!!");
			return null;
		}
		int max1=Integer.MIN_VALUE;
		int max2=Integer.MIN_VALUE;
		int max3=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<input.length;i++){
			sum += input[i];
			if(input[i]>max1) {
				max3=max2;
				max2=max1;
				max1=input[i];
			}
			else if(input[i]>max2){
				max3=max2;
				max2=input[i];
			}
			else if(input[i]>max3) max3=input[i];
		}
		System.out.println(max1 + " "+max2+" "+max3);
		return (double)(sum-max1-max2-max3)/(input.length-3);
	}
}
