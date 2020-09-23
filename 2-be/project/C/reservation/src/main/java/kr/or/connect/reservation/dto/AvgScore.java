package kr.or.connect.reservation.dto;

public class AvgScore {
	private int count;
	private double sum;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "AvgScore [count=" + count + ", sum=" + sum + "]";
	}

}
