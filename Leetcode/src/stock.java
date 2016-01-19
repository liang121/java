package bloomberg;

import java.util.Deque;

public class stock{
	double average;
	int size;
	private int old_s;
	Deque<Integer> deq;
	
	stock(int n,Deque<Integer> q) {
		// TODO Auto-generated constructor stub
		this.size = n;
		this.deq = q;
		this.average = calculate_average(q, n);
		
	}
	private double calculate_average(Deque<Integer> q,int n){
		int sum = 0;
		for(int i=0;i<n;i++){
			sum += (int) q.toArray()[i];
		}
		return (double)sum/n;
		
		
	}
	
	public int enqueue(int new_stock){
		deq.add(new_stock);
		return new_stock;
	}
	private int dequeue(){
		this.old_s = deq.poll();
		System.out.println("old "+old_s);
		return old_s;
	}
	public double new_average(int new_stock){
		this.dequeue();
		this.average = (this.average*this.size-old_s+new_stock)/this.size;
		return this.average;
	}
}