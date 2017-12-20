package fr.iagl.opl.wfuzz.MrRobot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Files implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5439675658615706145L;

	@Id
	private String login;
	
	@Column
	private String file;

	public Files() {}
	
	public Files(String login, String file) {
		this.file = file;
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
}
