package org.jagjeet.pas.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jagjeet.pas.model.Patient;
import org.jagjeet.pas.services.PasServiceImpl;

/**
 * @author Developer
 *
 */
@Path("/patients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientResource {

	/**
	 * 
	 */
	PasServiceImpl pasServiceImpl = new PasServiceImpl();

	/**
	 * @return
	 */
	@GET
	public List<Patient> getAllPatients() {

		try {
			return pasServiceImpl.getAllPatient();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param patient
	 * @return
	 * @throws SQLException
	 */
	@POST
	public int addPatients(Patient patient) throws SQLException {

		return pasServiceImpl.addPatients(patient);

	}

}
