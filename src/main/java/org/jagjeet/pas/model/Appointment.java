package org.jagjeet.pas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Developer
 *
 */
@Entity
@XmlRootElement
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmnetId;

	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	private int durationOfAppointment;

	private Date date;

	public int getAppointmnetId() {
		return appointmnetId;
	}

	public void setAppointmnetId(int appointmnetId) {
		this.appointmnetId = appointmnetId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getDurationOfAppointment() {
		return durationOfAppointment;
	}

	public void setDurationOfAppointment(int durationOfAppointment) {
		this.durationOfAppointment = durationOfAppointment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
