package fr.iagl.opl.wfuzz.MrRobot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Login implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7024983633731650128L;

	@Id
	private String login;
	
	@Column
	private String pwd;
	
	public Login() {}
	
	public Login(String login, String pwd) {
		this.login = login;
		this.pwd = pwd;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
