package org.jagjeet.pas.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jagjeet.pas.dbutility.HibernateUtility;
import org.jagjeet.pas.model.Appointment;
import org.jagjeet.pas.model.Doctor;
import org.jagjeet.pas.model.Patient;

/**
 * @author Developer
 *
 */
public class PasDaoImpl implements PasDao {

	/* (non-Javadoc)
	 * @see org.jagjeet.pas.dao.PasDao#addPatients(org.jagjeet.pas.model.Patient)
	 */
	@Override
	public int addPatients(Patient patient) throws SQLException {

		Session session = HibernateUtility.getSession();
		int patientId;
		try {
			session.beginTransaction();
			patientId = (Integer) session.save(patient);
			session.getTransaction().commit();
			session.close();
			System.out.println("Check :" + patientId);
			return patientId;
		} catch (HibernateException e) {
			session.clear();
			System.out.println("HibernateException in insertPatient()");
			e.printStackTrace();
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see org.jagjeet.pas.dao.PasDao#getAllPatient()
	 */
	@Override
	public List<Patient> getAllPatient() throws SQLException {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Patient> criteria = builder.createQuery(Patient.class);
			Root<Patient> root = criteria.from(Patient.class);
			criteria.select(root);
			List<Patient> listOfPatient = entityManager.createQuery(criteria).getResultList();
			session.getTransaction().commit();
			return listOfPatient;
		} catch (HibernateException e) {
			session.close();
			System.out.println("HibernateException in getAllPatients()");
			e.printStackTrace();
			return null;
		}

	}

	/* (non-Javadoc)
	 * @see org.jagjeet.pas.dao.PasDao#getPatient(int)
	 */
	@Override
	public Patient getPatient(int patientId) {

		Session session = HibernateUtility.getSession();
		session.beginTransaction();
		Patient patient = session.get(Patient.class, patientId);
		session.getTransaction().commit();
		session.close();
		return patient;
	}

	/* (non-Javadoc)
	 * @see org.jagjeet.pas.dao.PasDao#addDoctors(org.jagjeet.pas.model.Doctor)
	 */
	@Override
	public int addDoctors(Doctor doctor) throws SQLException {

		Session session = HibernateUtility.getSession();
		int doctorId;
		try {
			session.beginTransaction();
			doctorId = (Integer) session.save(doctor);
			session.getTransaction().commit();
			session.close();
			System.out.println("Check :" + doctorId);
			return doctorId;
		} catch (HibernateException e) {
			session.clear();
			System.out.println("HibernateException in insertDoctor()");
			e.printStackTrace();
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see org.jagjeet.pas.dao.PasDao#getAllDoctor()
	 */
	@Override
	public List<Doctor> getAllDoctor() throws SQLException {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
			Root<Doctor> root = criteria.from(Doctor.class);
			criteria.select(root);
			List<Doctor> listOfDoctor = entityManager.createQuery(criteria).getResultList();
			session.getTransaction().commit();
			return listOfDoctor;
		} catch (HibernateException e) {
			session.close();
			System.out.println("HibernateException in getAllDoctors()");
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.jagjeet.pas.dao.PasDao#getDoctor(int)
	 */
	@Override
	public Doctor getDoctor(int doctorId) {

		Session session = HibernateUtility.getSession();
		session.beginTransaction();
		Doctor doctor = session.get(Doctor.class, doctorId);
		session.getTransaction().commit();
		session.close();
		return doctor;
	}

	/* (non-Javadoc)
	 * @see org.jagjeet.pas.dao.PasDao#createAppointment(org.jagjeet.pas.model.Appointment)
	 */
	@Override
	public int createAppointment(Appointment appointment) throws SQLException {

		Session session = HibernateUtility.getSession();
		int appointmentId;
		try {
			session.beginTransaction();
			appointmentId = (Integer) session.save(appointment);
			session.getTransaction().commit();
			session.close();
			System.out.println("Check :" + appointmentId);
			return appointmentId;
		} catch (HibernateException e) {
			session.clear();
			System.out.println("HibernateException in insertAppointment()");
			e.printStackTrace();
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see org.jagjeet.pas.dao.PasDao#getAppointments(int)
	 */
	@Override
	public List<Appointment> getAppointments(int doctorId) throws SQLException {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Appointment> criteria = builder.createQuery(Appointment.class);
			Root<Appointment> root = criteria.from(Appointment.class);
			criteria.select(root);
			List<Appointment> listOfAppointment = entityManager.createQuery(criteria).getResultList();
			session.getTransaction().commit();
			return listOfAppointment;
		} catch (HibernateException e) {
			session.close();
			System.out.println("HibernateException in getAllDoctors()");
			e.printStackTrace();
			return null;
		}

	}

}
