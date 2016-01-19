/*
 * Get a date (mon/day/year) from user. Print exact the week of dates 
 * (Sun to Sat). ex) input: 2/20/2001 if the day isWednesday 
 * output: Sunday 2/17/2001 
 * Monday 2/18/2001
 * Tuesday 2/19/2001 
 * Wednesday 2/20/2001
 * Thursday 2/21/2001 
 * Friday 2/22/2001 
 * Saturday 2/23/2001
 */
public class calendar {
	public static void main(String[] args){
		getdates(1,2,2004,3);
	}
	
	public static boolean isLeap(int year){
		if(year%400==0||year%4==0) return true;
		return false;
	}
	public static int getMonDays(int m,int year){
		
		if(isLeap(year)){
			int[] map= {0,31,29,31,30,31,30,31,31,30,31,30,31};
			return map[m];
		}
		else{
			int[] map= {0,31,28,31,30,31,30,31,31,30,31,30,31};
			return map[m];
		}
	}
	public static String getweekday(int w){
		switch(w){
		case 0: return "Sunday";
		case 1: return "Monday";
		case 2: return "Tuesday";
		case 3: return "Wednesday";
		case 4: return "Thursday";
		case 5: return "Friday";
		case 6: return "Saturday";
		default: return "";
		}
	}
	public static void getdates(int month,int dates,int year,int weekday){
		while(weekday>0){
			dates--;
			if(dates==0) {
				month--;
				if(month==0){
					year--;
					month=12;
				}
				dates =getMonDays(month,year);
			}
			weekday--;
			//System.out.println(month+"/"+dates+"/"+year+" "+weekday);
		}
		
		for(weekday=0;weekday<7;weekday++){
			System.out.println(month+"/"+dates+"/"+year+" "+getweekday(weekday));
			dates++;
			if(dates>getMonDays(month,year)){
				month++;
				dates=1;
				if(month>12){
					year++;
					month=1;
				}
			}
		}
		
	}
}
