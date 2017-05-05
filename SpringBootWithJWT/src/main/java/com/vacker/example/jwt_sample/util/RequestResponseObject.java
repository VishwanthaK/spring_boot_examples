package com.vacker.example.jwt_sample.util;

import java.io.Serializable;

public class RequestResponseObject implements Serializable {
	
	private static final long serialVersionUID = 5299096808961968410L;
	
	private Long task_reference_id;
	private String task_reference_name;
	private boolean task_status;
	private String message;
	
	public Long getTask_reference_id() {
		return task_reference_id;
	}
	public void setTask_reference_id(Long task_reference_id) {
		this.task_reference_id = task_reference_id;
	}
	public String getTask_reference_name() {
		return task_reference_name;
	}
	public void setTask_reference_name(String task_reference_name) {
		this.task_reference_name = task_reference_name;
	}
	public boolean isTask_status() {
		return task_status;
	}
	public void setTask_status(boolean task_status) {
		this.task_status = task_status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
