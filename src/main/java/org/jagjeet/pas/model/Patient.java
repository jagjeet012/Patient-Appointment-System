package org.jagjeet.pas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Developer
 *
 */
@Entity
@XmlRootElement
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	private String patientName;
	private int criticality;
	private String diseaseCatogary;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getCriticality() {
		return criticality;
	}

	public void setCriticality(int criticality) {
		this.criticality = criticality;
	}

	public String getDiseaseCatogary() {
		return diseaseCatogary;
	}

	public void setDiseaseCatogary(String diseaseCatogary) {
		this.diseaseCatogary = diseaseCatogary;
	}

}
