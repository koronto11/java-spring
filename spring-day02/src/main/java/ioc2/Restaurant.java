package ioc2;

public class Restaurant {

	//属性
	private Waiter wt;
	
	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}

	public void setWt(Waiter wt) {
		System.out.println("setWt()");
		this.wt = wt;
	}

	public Restaurant() {
		System.out.println("Restaurant()");
	}
	
	

}
