package com.virtualClass.App.model;


public class Meeting {
	
	
	private String zoomMeetingId;
	private String zoomMeetingPassword;
	private String studentNic;
	private String studentName;
	//
	
	private String message;

	private boolean messageStatus;
	
	public String getZoomMeetingId() {
		return zoomMeetingId;
	}
	public void setZoomMeetingId(String zoomMeetingId) {
		this.zoomMeetingId = zoomMeetingId;
	}
	public String getZoomMeetingPassword() {
		return zoomMeetingPassword;
	}
	public void setZoomMeetingPassword(String zoomMeetingPassword) {
		this.zoomMeetingPassword = zoomMeetingPassword;
	}
	public String getStudentNic() {
		return studentNic;
	}
	public void setStudentNic(String studentNic) {
		this.studentNic = studentNic;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(boolean messageStatus) {
		this.messageStatus = messageStatus;
	}
	
	
	
	
	

}
