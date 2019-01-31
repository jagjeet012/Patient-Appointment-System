package org.jagjeet.pas.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jagjeet.pas.model.Doctor;
import org.jagjeet.pas.services.PasServiceImpl;

/**
 * @author Developer
 *
 */
@Path("/doctors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorResource {

	/**
	 * 
	 */
	PasServiceImpl pasServiceImpl = new PasServiceImpl();

	/**
	 * @return
	 */
	@GET
	public List<Doctor> getAllDoctor() {

		try {
			return pasServiceImpl.getAllDoctor();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param doctor
	 * @return
	 * @throws SQLException
	 */
	@POST
	public int addDoctor(Doctor doctor) throws SQLException {

		return pasServiceImpl.addDoctor(doctor);
	}

}
