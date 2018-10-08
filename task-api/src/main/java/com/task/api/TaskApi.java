package com.task.api;

public class TaskApi {
	private String subjectOfTask;
	private String detailOfTask;
	private String statusOfTask;
	
	public TaskApi(String subject, String detail, String status) {
		this.subjectOfTask = subject;
		this.detailOfTask = detail;
		this.statusOfTask = status;
	}

	public String getSubjectOfTask() {
		return subjectOfTask;
	}

	public void setSubjectOfTask(String subjectOfTask) {
		this.subjectOfTask = subjectOfTask;
	}

	public String getDetailOfTask() {
		return detailOfTask;
	}

	public void setDetailOfTask(String detailOfTask) {
		this.detailOfTask = detailOfTask;
	}

	public String getStatusOfTask() {
		return statusOfTask;
	}

	public void setStatusOfTask(String statusOfTask) {
		this.statusOfTask = statusOfTask;
	}	
}
