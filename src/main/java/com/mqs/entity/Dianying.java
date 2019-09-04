package com.mqs.entity;


public class Dianying implements java.io.Serializable {

	//columns START
	private Integer did;
	private String dname;
	private String djs;
	private String dename;
	private String time;
	
	private String tname;
	private String tid;
	
	@Override
	public String toString() {
		return "Dianying [did=" + did + ", dname=" + dname + ", djs=" + djs + ", dename=" + dename + ", time=" + time
				+ ", tname=" + tname + ", tid=" + tid + "]";
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	//columns END
	public Dianying(){
	}
	public Dianying(Integer did,String dname,String djs,String dename,String time){
		this.did=did;		this.dname=dname;		this.djs=djs;		this.dename=dename;		this.time=time;	}

	public void setDid(Integer did){
		this.did=did;
	}
	public Integer getDid(){
		return did;
	}

	public void setDname(String dname){
		this.dname=dname;
	}
	public String getDname(){
		return dname;
	}

	public void setDjs(String djs){
		this.djs=djs;
	}
	public String getDjs(){
		return djs;
	}

	public void setDename(String dename){
		this.dename=dename;
	}
	public String getDename(){
		return dename;
	}

	public void setTime(String time){
		this.time=time;
	}
	public String getTime(){
		return time;
	}
}

