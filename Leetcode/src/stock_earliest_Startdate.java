package bloomberg;

public class stock_earliest_Startdate {
	public static void main(String[] args){
		
	}
	public int findEarliestTradingDate(String stockName, int startDate, int endDate){
		return 1;
	}
	public int wrapperFunction(String stockName, int startDate, int endDate){

		if(startDate<=endDate){
			int mid = (endDate+startDate)/2;
			if(findEarliestTradingDate(stockName, startDate, mid-1)==-1) return wrapperFunction(stockName, mid+1, endDate);
			else return findEarliestTradingDate(stockName, startDate, mid-1);
		}
		else return -1;
	}

}


//int wrapperFunction(String stockName， int startDate， int endDate) {
//
//if (startDate == endDate) return findEarliestTradingDatestockName, startDate, endDate); //调用api
//int mid = (startDate + endDate) / 2;. From 1point 3acres bbs
//int res = wrapperFunction(stockName, startDate, mid);.鏈枃鍘熷垱鑷�1point3acres璁哄潧
//if (res != -1) return res;
//return wrapperFunction(stockName, mid+1, endDate);
//}