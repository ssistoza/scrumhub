package com.revature.ScrumHub.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SWIM_LANE")
public class Swimlane implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(sequenceName="SL_SEQ", name="SL_SEQ")
	@GeneratedValue(generator="SL_SEQ", strategy=GenerationType.SEQUENCE)
	@Column(name="SL_ID", nullable=false)
	private int slId;
	@Column(name="SL_NAME", nullable=false)
	private String slName;
	@Column(name="SL_ORDER")
	private int slOrder;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SL_STATUS_ID")
	private SlStatus slStatus;

	//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="B_ID")
//	private int boardId;
	
	
	public Swimlane() {}


	public Swimlane(int slId, String slName, int slOrder) {
		super();
		this.slId = slId;
		this.slName = slName;
		this.slOrder = slOrder;
	}


	public int getSlId() {
		return slId;
	}
	public void setSlId(int slId) {
		this.slId = slId;
	}
	
	public String getSlName() {
		return slName;
	}
	public void setSlName(String slName) {
		this.slName = slName;
	}
	
	public int getSlOrder() {
		return slOrder;
	}
	public void setSlOrder(int slOrder) {
		this.slOrder = slOrder;
	}	

	public int getSlStatusId() {
		return slStatusId;
	}


	public void setSlStatusId(int slStatusId) {
		this.slStatusId = slStatusId;
	}


	@Override
	public String toString() {
		return "Swimlane [slId=" + slId + ", slName=" + slName + ", slOrder=" + slOrder + "]";
	}
	
	
}
