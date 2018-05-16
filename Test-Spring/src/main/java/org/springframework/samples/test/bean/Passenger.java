package org.springframework.samples.test.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PASSENGER")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int paxId;
	private String paxname;
	@ManyToOne
	private Bus bus;
	/**
	 * @return the paxId
	 */
	public int getPaxId() {
		return paxId;
	}
	/**
	 * @param paxId the paxId to set
	 */
	public void setPaxId(int paxId) {
		this.paxId = paxId;
	}
	/**
	 * @return the paxname
	 */
	public String getPaxname() {
		return paxname;
	}
	/**
	 * @param paxname the paxname to set
	 */
	public void setPaxname(String paxname) {
		this.paxname = paxname;
	}
	/**
	 * @return the bus
	 */
	public Bus getBus() {
		return bus;
	}
	/**
	 * @param bus the bus to set
	 */
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
}
