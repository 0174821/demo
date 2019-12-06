package cn.jxufe.db.domain;

public class seat {
	private plane plane;//对应所属飞机
	private String seatno;
	private int cono;
	private int rowno;
	private String sellstatus;
	private tank tank;//对应所属舱等

	public String getSeatno() {
		return seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	public int getCono() {
		return cono;
	}

	public void setCono(int cono) {
		this.cono = cono;
	}

	public int getRowno() {
		return rowno;
	}

	public void setRowno(int rowno) {
		this.rowno = rowno;
	}

	public String getSellstatus() {
		return sellstatus;
	}

	public void setSellstatus(String sellstatus) {
		this.sellstatus = sellstatus;
	}

	public plane getPlane() {
		return plane;
	}

	public void setPlane(plane plane) {
		this.plane = plane;
	}

	public tank getTank() {
		return tank;
	}

	public void setTank(tank tank) {
		this.tank = tank;
	}

}
