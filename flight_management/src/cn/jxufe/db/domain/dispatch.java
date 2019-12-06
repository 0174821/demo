package cn.jxufe.db.domain;

public class dispatch {
	private team team;// 对应所属team
	private teammember teammember; //这里是不是应该是多个组员。。。

	public team getTeam() {
		return team;
	}

	public void setTeam(team team) {
		this.team = team;
	}

	public teammember getTeammember() {
		return teammember;
	}

	public void setTeammember(teammember teammember) {
		this.teammember = teammember;
	}
}
