import java.awt.image.RescaleOp;
import java.beans.Visibility;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class S{
	 public static void main(String[] args){
		 int width = 5;
		 int image[] = {
					1,1,1,1,1,
					1,9,1,1,1,
					1,1,1,1,1,
					1,1,1,1,1,
					1,1,1,1,1,};			
		 int out[] = processEdges(image, width, 2);
    }
	 public static int[] processEdges(int[] image,int width,int threshold){
		 int[] output= new int[image.length];
		 int numRows = image.length/width;
		 int xMin,xMax,yMin,yMax,pos;
		 for(int row=0;row<numRows;row++){
			 for(int col=0;col<width;col++){
				 pos = image[width*row+col];
				 if(col==0) xMin=0;
				 else xMin=col-1;
				 if(col==width-1) xMax=width-1;
				 else xMax=col+1;
				 if(row==0) yMin=0;
				 else yMin=row-1;
				 if(row==numRows-1) yMax=numRows-1;
				 else yMax=row+1;
				 if(meetthreshold(width,xMin,xMax,yMin,yMax,pos,image,threshold)){
					 output[width*row+col]=pos;
				 }
			 }
		 }
		 return output;
	 }
	 public static boolean meetthreshold(int width,int xMin,int xMax,int yMin,int yMax,int pos,int[] image,int threshold){
		 for(int row=yMin;row<=yMax;row++){
			 for(int col=xMin;col<=xMax;col++){
				 if(Math.abs(image[width*row+col]-pos)>=threshold) return true;
			 }
		 }
		 return false;
	 }
 
}



