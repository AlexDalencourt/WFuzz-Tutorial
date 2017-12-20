package fr.iagl.opl.wfuzz.MrRobot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.iagl.opl.wfuzz.MrRobot.entity.Login;
import fr.iagl.opl.wfuzz.MrRobot.repository.FilesRepository;
import fr.iagl.opl.wfuzz.MrRobot.repository.LoginRepository;

@RestController
public class HomeController {

	@Autowired private LoginRepository loginRepository;
	@Autowired private FilesRepository filesRepository;
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public void login(@RequestAttribute("login") String login, @RequestAttribute("pwd") String pwd, BindingResult binding) {
		Login entity = loginRepository.findByLoginAndPwd(login, pwd);
		if(null == entity) {
			binding.addError(new ObjectError("Not know", "Bad username / password"));
		}
		
	}
	
	@RequestMapping(path="/files/{username}", method=RequestMethod.GET)
	public List<String> listFiles(@PathVariable("username") String login){
		return null;
	}
}
