package bloomberg;

import java.lang.reflect.Array;

public class average_value{
    public static void main(String[] args){
        int[] array = {1,2,1,12,64,232};
        System.out.println(average(array));
    }
    public static double average(int[] array){
    	double average=0;
    	int len = array.length;
    	for(int i=0;i<len;i++){
    		average += (double)(array[i])/len;
    	}
    	return average;
    }
}
