package org.springframework.samples.test.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="BUS_TABLE")
@JsonSerialize(using = JaksonCustomBusSerializer.class)
//@JsonDeserialize(using = JacksonCustomBusDeserializer.class)
public class Bus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int busID;
	private String name;
	
	@OneToMany(mappedBy="bus",cascade=CascadeType.ALL)
	private List<Passenger> paxLst;
	
	/**
	 * @return the pax
	 */
 
	/**
	 * @return the busID
	 */
	public int getBusID() {
		return busID;
	}
	/**
	 * @return the paxLst
	 */
	public List<Passenger> getPaxLst() {
		return paxLst;
	}
	/**
	 * @param paxLst the paxLst to set
	 */
	public void setPaxLst(List<Passenger> paxLst) {
		this.paxLst = paxLst;
	}
	/**
	 * @param busID the busID to set
	 */
	public void setBusID(int busID) {
		this.busID = busID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
