import java.awt.geom.Area;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
//Given a string of RGB value (rr, gg, bb)which represents in hexadecimal.
//Compare if rr or gg or bb is the biggest, or two of those values are equal and larger than the third one,
//or three valuesare equal with each other.

import org.omg.CORBA.portable.ValueInputStream;

public class RGBCompare{
	public static class RGB_color{
		String color;
		int number;
		RGB_color(String col,int num){
			this.color = col;
			this.number = num;
		}
	}
	
	public static void main(String[] args){
		RGB("010202");
		RGB("010201");
		RGB("ffffff");
		System.out.println("///////////////////////////////////////////");
		RGB_compare("010202");
		RGB_compare("020203");
		RGB_compare("ffffff");
	}
	public static void RGB_compare(String str){
		RGB_color R = new RGB_color("R",Integer.parseInt(str.substring(0,2),16));
		RGB_color G = new RGB_color("G",Integer.parseInt(str.substring(2,4),16));
		RGB_color B = new RGB_color("B",Integer.parseInt(str.substring(4,6),16));

		ArrayList<RGB_color> list = new ArrayList<RGB_color>();
		list.add(R);
		list.add(G);
		list.add(B);
		Collections.sort(list,new Comparator<RGB_color>(){
			@Override
			public int compare(RGB_color o1,RGB_color o2){
				return Integer.compare(o1.number, o2.number);
			}
		});
		if(list.get(0).number==list.get(1).number&&list.get(1).number==list.get(2).number) System.out.println("three value are the same");
		else if(list.get(2).number>list.get(1).number) System.out.println(list.get(2).color+" is the biggest value");
		else if(list.get(2).number==list.get(1).number) System.out.println(list.get(2).color+" "+list.get(1).color+ " are the biggest values larger than" + list.get(0).color);
		//else if(list.get(0).number==list.get(1).number) System.out.println(list.get(0).color+" "+list.get(1).color+ " are the same values and less than" + list.get(2).color);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String color;
	private int number;

	public RGBCompare(String color, int number){
		this.color = color;
		this.number = number;
	}

	public static void RGB(String input){
		int R = Integer.parseInt(input.substring(0,2),16);
		RGBCompare r = new RGBCompare("R",R);
		int G = Integer.parseInt(input.substring(2,4),16);
		RGBCompare g = new RGBCompare("G",G);
		int B = Integer.parseInt(input.substring(4,6),16);
		RGBCompare b = new RGBCompare("B",B);
		List<RGBCompare> list = new ArrayList<RGBCompare>();
		list.add(r);
		list.add(g);
		list.add(b);
		Collections.sort(list, new Comparator<RGBCompare>(){
			public int compare(RGBCompare r1, RGBCompare r2){
				if(r1.number > r2.number){
					return 1;
				}else{
					if(r1.number == r2.number){
						return 0;
					}else{
						return -1;
					}
				}
			}
		});

		if(list.get(0).number == list.get(2).number){
			System.out.println("Three equal");
			return;
		}
		if(list.get(1).number == list.get(2).number){
			System.out.println(list.get(1).color+ " and "+list.get(2).color+" is larger than "+list.get(0).color);
			return;
		}
		System.out.println(list.get(2).color+" is largest, second largest is "+list.get(1).color+", smallest is "+list.get(0).color+".");
	}
}