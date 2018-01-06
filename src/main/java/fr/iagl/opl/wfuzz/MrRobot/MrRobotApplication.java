package fr.iagl.opl.wfuzz.MrRobot;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import fr.iagl.opl.wfuzz.MrRobot.entity.File;
import fr.iagl.opl.wfuzz.MrRobot.entity.Login;
import fr.iagl.opl.wfuzz.MrRobot.repository.FileRepository;
import fr.iagl.opl.wfuzz.MrRobot.repository.LoginRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MrRobotApplication {

	@Autowired LoginRepository loginRepository;
	@Autowired FileRepository fileRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MrRobotApplication.class, args);
	}
	
	@PostConstruct
	public void init() throws NoSuchAlgorithmException {
		loginRepository.save(new Login("arthur", "supersecure"));
		loginRepository.save(new Login("marvin", "robot"));
		loginRepository.save(new Login("ford", "h2g2"));
		MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update("trillian".getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter
	      .printHexBinary(digest).toUpperCase();
		loginRepository.save(new Login("zaphod", myHash.toLowerCase()));
		fileRepository.save(new File("arthur", "arthur-description"));
		fileRepository.save(new File("arthur", "h2g2.jpeg"));
		fileRepository.save(new File("marvin", "marvin.jpeg"));
	}
}
