package org.jagjeet.pas.services;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.jagjeet.pas.dao.PasDaoImpl;
import org.jagjeet.pas.model.Appointment;
import org.jagjeet.pas.model.Doctor;
import org.jagjeet.pas.model.Patient;

/**
 * @author Developer
 *
 */
public class PasServiceImpl implements PasService {

	PasDaoImpl pasDaoImpl = new PasDaoImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.pas.services.PasService#addPatients(org.jagjeet.pas.model.
	 * Patient)
	 */
	@Override
	public int addPatients(Patient patient) throws SQLException {
		return pasDaoImpl.addPatients(patient);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.pas.services.PasService#getAllPatient()
	 */
	@Override
	public List<Patient> getAllPatient() throws SQLException {
		return pasDaoImpl.getAllPatient();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.pas.services.PasService#addDoctors(org.jagjeet.pas.model.Doctor)
	 */
	@Override
	public int addDoctor(Doctor doctor) throws SQLException {
		return pasDaoImpl.addDoctors(doctor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.pas.services.PasService#getAllDoctor()
	 */
	@Override
	public List<Doctor> getAllDoctor() throws SQLException {
		return pasDaoImpl.getAllDoctor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.pas.services.PasService#createAppointment(int, int, int,
	 * java.util.Date)
	 */
	@Override
	public int createAppointment(int patientId, int doctorId, int durationOfAppointment, Date date)
			throws SQLException {

		Appointment appointment = new Appointment();

		appointment.setPatient(pasDaoImpl.getPatient(patientId));
		appointment.setDoctor(pasDaoImpl.getDoctor(doctorId));
		appointment.setDurationOfAppointment(durationOfAppointment);
		appointment.setDate(date);
		return pasDaoImpl.createAppointment(appointment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.pas.services.PasService#getAppointment(int)
	 */
	@Override
	public List<Appointment> getAppointment(int doctorId) throws SQLException {
		return pasDaoImpl.getAppointments(doctorId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.pas.services.PasService#getPatient(int)
	 */
	@Override
	public Patient getPatient(int patientId) {
		return pasDaoImpl.getPatient(patientId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.pas.services.PasService#getDoctor(int)
	 */
	@Override
	public Doctor getDoctor(int doctorId) {
		return pasDaoImpl.getDoctor(doctorId);
	}

	/**
	 * 
	 */
	private int totalAppointmentHours;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.pas.services.PasService#getDuration(int)
	 */
	@Override
	public String getDuration(int doctorId) {

		totalAppointmentHours = 0;
		try {
			List<Appointment> appointmentList = getAppointment(doctorId);
			appointmentList.forEach((appointment) -> {
				totalAppointmentHours = totalAppointmentHours + appointment.getDurationOfAppointment();
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalAppointmentHours + " minutes";
	}

}
