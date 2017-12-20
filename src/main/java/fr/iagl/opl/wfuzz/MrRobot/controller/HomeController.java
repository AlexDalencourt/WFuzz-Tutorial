package fr.iagl.opl.wfuzz.MrRobot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.iagl.opl.wfuzz.MrRobot.entity.Login;
import fr.iagl.opl.wfuzz.MrRobot.repository.FileRepository;
import fr.iagl.opl.wfuzz.MrRobot.repository.LoginRepository;

@RestController
public class HomeController {

	@Autowired private LoginRepository loginRepository;
	@Autowired private FileRepository fileRepository;
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public ResponseEntity<Login> login(@RequestParam("login") String login, @RequestParam("pwd") String pwd) {
		Login entity = loginRepository.findByLoginAndPwd(login, pwd);
		if(null == entity) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(entity, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(path="/filesList/{username}", method=RequestMethod.GET)
	public List<String> listFiles(@PathVariable("username") String login){
		List<String> output = new ArrayList<>();
		fileRepository.findByLogin(login).iterator().forEachRemaining(x->output.add(x.getFile()));
		return output;
	}
	
	@RequestMapping(path="/file/{filename:.*}", method=RequestMethod.GET)
	public FileSystemResource getFile(@PathVariable("filename") String filename) throws IOException {
		return new FileSystemResource(new ClassPathResource("static/files/" + filename).getFile());
	}
}
