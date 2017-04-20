package com.synerzip.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_information")
public class Project {

	@Id
	@Column(name = "project_id")
	private long projectId;
	@Column(name = "project_title")
	private String projectTitle;
	@Column(name = "technology_used")
	private String technologyUsed;
	@Column(name = "project_description")
	private String projectDescription;
	@Column(name = "project_feature")
	private String projectFeature;

	public Project() {

	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectTitle="
				+ projectTitle + ", technologyUsed=" + technologyUsed
				+ ", projectDescription=" + projectDescription
				+ ", projectFeature=" + projectFeature + "]";
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getTechnologyUsed() {
		return technologyUsed;
	}

	public void setTechnologyUsed(String technologyUsed) {
		this.technologyUsed = technologyUsed;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectFeature() {
		return projectFeature;
	}

	public void setProjectFeature(String projectFeature) {
		this.projectFeature = projectFeature;
	}
}