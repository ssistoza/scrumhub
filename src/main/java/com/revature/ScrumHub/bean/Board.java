package com.revature.ScrumHub.bean;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="BOARD")
public class Board {
	
	@Id
	@SequenceGenerator(name="B_SEQ", sequenceName="B_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="B_SEQ")
	@Column(name="B_ID")
	private int bId;
	
	@Column(name="B_NAME")
	private String bName;

	@CreationTimestamp
	@Column(name="B_TIMESTAMP")
	private Timestamp bTimestamp;
		
	public Board() {}

	public int getbId() { return bId; }
	public void setbId(int bId) { this.bId = bId; }
	public String getbName() { return bName; }
	public void setbName(String bName) { this.bName = bName; }
	public Timestamp getbTimestamp() { return bTimestamp; }
	public void setbTimestamp(Timestamp bTimestamp) { this.bTimestamp = bTimestamp; }

	@Override
	public String toString() {
		return "ScrumBoard [bId=" + bId + ", bName=" + bName + ", bTimestamp=" + bTimestamp + "]";
	}
	
}