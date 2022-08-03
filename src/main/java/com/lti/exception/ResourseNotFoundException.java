package com.lti.exception;

public class ResourseNotFoundException extends RuntimeException {
	String ResourceName;
	String fieldName;
	long field;
	public ResourseNotFoundException(String resourceName, String fieldName, long field) {
		super(String.format("%s not found with %s : %l",resourceName,fieldName,field));
		ResourceName = resourceName;
		this.fieldName = fieldName;
		this.field = field;
	}
	public String getResourceName() {
		return ResourceName;
	}
	public void setResourceName(String resourceName) {
		ResourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public long getField() {
		return field;
	}
	public void setField(long field) {
		this.field = field;
	}
	
}
