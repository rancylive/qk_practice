package practice.quikr.p_hibernate_em.sellerOnboarding.vo;

import java.util.Date;

public class Commission {
	private Date starttime;
	private Date expirytime;
	private double commission;
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getExpirytime() {
		return expirytime;
	}
	public void setExpirytime(Date expirytime) {
		this.expirytime = expirytime;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	@Override
	public String toString() {
		return "Commission [starttime=" + starttime + ", expirytime=" + expirytime + ", commission=" + commission + "]";
	}
	
	
}
