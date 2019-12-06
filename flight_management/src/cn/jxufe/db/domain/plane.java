package cn.jxufe.db.domain;

public class plane {
	private String planeno;
	private int seatnum;
	private type planetype;//对应机型
	public String getPlaneno() {
		return planeno;
	}
	public void setPlaneno(String planeno) {
		this.planeno = planeno;
	}
	public int getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}
	public type getPlanetype() {
		return planetype;
	}
	public void setPlanetype(type plane) {
		this.planetype = plane;
	}

}
