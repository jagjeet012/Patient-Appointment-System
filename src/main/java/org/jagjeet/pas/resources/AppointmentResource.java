package org.jagjeet.pas.resources;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jagjeet.pas.model.Appointment;
import org.jagjeet.pas.services.PasServiceImpl;

/**
 * @author Developer
 *
 */
@Path("/appointments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AppointmentResource {

	/**
	 * 
	 */
	PasServiceImpl pasServiceImpl = new PasServiceImpl();

	/**
	 * @param doctorId
	 * @return
	 */
	@GET
	@Path("/{doctorId}")
	public List<Appointment> getAppointment(@PathParam("doctorId") int doctorId) {

		try {
			return pasServiceImpl.getAppointment(doctorId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @param patientId
	 * @param doctorId
	 * @return
	 * @throws SQLException
	 */
	@POST
	public int createAppointment(@QueryParam("patientId") int patientId, @QueryParam("doctorId") int doctorId, @QueryParam("durtion") int duration)
			throws SQLException {

		return pasServiceImpl.createAppointment(patientId, doctorId, duration, new Date());
	}

	/**
	 * @param doctorId
	 * @return
	 */
	@GET
	@Path("/duration")
	public String getDuration(@QueryParam("doctorId") int doctorId) {

		return pasServiceImpl.getDuration(doctorId);

	}

}
