package cn.mldn.eusplatform.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Schedule implements Serializable {
	private Long sid;
	private String seid;
	private String aeid;
	private Long iid;
	private String title;
	private Date sdate;
	private Date subdate;
	private Integer audit;
	private String note;
	private Date auddate;
	private String anote;
	private Integer ecount;
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getSeid() {
		return seid;
	}
	public void setSeid(String seid) {
		this.seid = seid;
	}
	public String getAeid() {
		return aeid;
	}
	public void setAeid(String aeid) {
		this.aeid = aeid;
	}
	public Long getIid() {
		return iid;
	}
	public void setIid(Long iid) {
		this.iid = iid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getSubdate() {
		return subdate;
	}
	public void setSubdate(Date subdate) {
		this.subdate = subdate;
	}
	public Integer getAudit() {
		return audit;
	}
	public void setAudit(Integer audit) {
		this.audit = audit;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getAuddate() {
		return auddate;
	}
	public void setAuddate(Date auddate) {
		this.auddate = auddate;
	}
	public String getAnote() {
		return anote;
	}
	public void setAnote(String anote) {
		this.anote = anote;
	}
	public Integer getEcount() {
		return ecount;
	}
	public void setEcount(Integer ecount) {
		this.ecount = ecount;
	}
	@Override
	public String toString() {
		return "Schedule [sid=" + sid + ", seid=" + seid + ", aeid=" + aeid + ", iid=" + iid + ", title=" + title
				+ ", sdate=" + sdate + ", subdate=" + subdate + ", audit=" + audit + ", note=" + note + ", auddate="
				+ auddate + ", anote=" + anote + ", ecount=" + ecount + "]";
	}
	
	

}
