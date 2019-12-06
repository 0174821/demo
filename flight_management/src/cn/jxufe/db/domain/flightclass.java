package cn.jxufe.db.domain;

import java.util.Date;

public class flightclass {
	private flight flight;// 对应本班次的flight
	private String flightclassno;
	private Date takeoff;
	private Date arrival;
	private plane plane;// 对应本班次的plane
	private team team;// 对应调度本班次的team
	private Date dates;

	public String getFlightclassno() {
		return flightclassno;
	}

	public void setFlightclassno(String flightclassno) {
		this.flightclassno = flightclassno;
	}

	public Date getTakeoff() {
		return takeoff;
	}

	public void setTakeoff(Date takeoff) {
		this.takeoff = takeoff;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public flight getFlight() {
		return flight;
	}

	public void setFlight(flight flight) {
		this.flight = flight;
	}

	public plane getPlane() {
		return plane;
	}

	public void setPlane(plane plane) {
		this.plane = plane;
	}

	public team getTeam() {
		return team;
	}

	public void setTeam(team team) {
		this.team = team;
	}
}
