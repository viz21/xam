package rmi;

import java.io.Serializable;

public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String [] answers;
	private String questionText;
	private int sphone,sbday;
	private String sid,sfname,slname,sgender,saddress;
	private int tphone,tbday;
	private String tid,tfname,tlname,tgender,temail;
	

	




/**
 * Students data of the admin panel
 * @return
 */
	public String getSid() {
		return sid;
	}

	public int getSphone() {
		return sphone;
	}

	public int getSbday() {
		return sbday;
	}


	public String getSfname() {
		return sfname;
	}
	
	
	public String getSlname() {
		return slname;
	}
	
	public String getSgender() {
		return sgender;
	}
	
	public String getSaddress() {
		return saddress;
	}
	

	public void setSid(String sid) {
		this.sid = sid;
	}

	
	public void setSphone(int sphone) {
		this.sphone = sphone;
	}


	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}



	public void setSbday(int sbday) {
		this.sbday = sbday;
	}
	

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}


	public void setSfname(String sfname) {
		this.sfname = sfname;
	}


	public void setSlname(String slname) {
		this.slname = slname;
	}

	/**
	 * Teachers data of the admin panel
	 * @return
	 */
	public String getTid() {
		return tid;
	}


	public void setTid(String tid) {
		this.tid = tid;
	}


	public String getTlname() {
		return tlname;
	}


	public void setTlname(String tlname) {
		this.tlname = tlname;
	}


	public String getTemail() {
		return temail;
	}


	public void setTemail(String temail) {
		this.temail = temail;
	}


	public String getTgender() {
		return tgender;
	}


	public void setTgender(String tgender) {
		this.tgender = tgender;
	}


	public String getTfname() {
		return tfname;
	}


	public void setTfname(String tfname) {
		this.tfname = tfname;
	}


	public int getTphone() {
		return tphone;
	}


	public void setTphone(int tphone) {
		this.tphone = tphone;
	}


	public int getTbday() {
		return tbday;
	}


	public void setTbday(int tbday) {
		this.tbday = tbday;
	}





	
	
}
