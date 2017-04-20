package com.synerzip.restapi.projectmanagement;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import org.hibernate.Query;
import org.hibernate.Session;
import com.synerzip.project.dbconnection.HibernateUtils;
import com.synerzip.project.model.Project;

@Path("/project")
public class ProjectServeice {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getAllProject() {
		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Query query = session.createQuery("from project_information");
			List<Project> projects = query.list();
			session.getTransaction().commit();
			return projects;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{projectId}")
	public String getProject(@PathParam("projectId") long projectId) {
		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Project project = (Project) session.get(Project.class, projectId);
			tx.commit();
			return project.toString();
		} catch (Exception e) {
			return "record not found";
		} finally {
			session.close();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addProject(Project project) {

		Session session = HibernateUtils.getSession();

		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			session.save(project);
			tx.commit();
			return "data saved";
		} catch (Exception e) {
			return "something went wrong";
		} finally {
			session.close();
		}
	}
}