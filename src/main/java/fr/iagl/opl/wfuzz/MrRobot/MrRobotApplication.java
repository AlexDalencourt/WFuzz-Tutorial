package fr.iagl.opl.wfuzz.MrRobot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import fr.iagl.opl.wfuzz.MrRobot.entity.Files;
import fr.iagl.opl.wfuzz.MrRobot.entity.Login;
import fr.iagl.opl.wfuzz.MrRobot.repository.FilesRepository;
import fr.iagl.opl.wfuzz.MrRobot.repository.LoginRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MrRobotApplication {

	@Autowired LoginRepository loginRepository;
	@Autowired FilesRepository filesRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MrRobotApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		loginRepository.save(new Login("arthur", "supersecure"));
		loginRepository.save(new Login("marvin", "robot"));
		loginRepository.save(new Login("ford", "h2g2"));
		filesRepository.save(new Files("arthur", "arthur-description"));
		filesRepository.save(new Files("arthur", "h2g2.jpeg"));
		filesRepository.save(new Files("marvin", "marvin.jpeg"));
	}
}
