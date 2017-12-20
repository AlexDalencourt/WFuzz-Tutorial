package fr.iagl.opl.wfuzz.MrRobot.repository;

import org.springframework.data.repository.CrudRepository;

import fr.iagl.opl.wfuzz.MrRobot.entity.Login;

public interface LoginRepository extends CrudRepository<Login, String>{

	public Login findByLoginAndPwd(String login, String pwd);
}
