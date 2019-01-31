package org.jagjeet.pas.services;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.jagjeet.pas.model.Appointment;
import org.jagjeet.pas.model.Doctor;
import org.jagjeet.pas.model.Patient;

public interface PasService {

	// Patient

	public int addPatients(Patient patient) throws SQLException;

	public List<Patient> getAllPatient() throws SQLException;
	
	public Patient getPatient(int patientId);

	// Doctor

	public int addDoctor(Doctor doctor) throws SQLException;

	public List<Doctor> getAllDoctor() throws SQLException;
	
	public Doctor getDoctor(int doctorId);
	
	//Appointment
	
	public int createAppointment(int patientId, int doctorId, int durationOfAppointment, Date date) throws SQLException;
	
	public List<Appointment> getAppointment(int doctorId) throws SQLException;
	
	public String getDuration(int doctorId);

}
