package fr.iagl.opl.wfuzz.MrRobot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.iagl.opl.wfuzz.MrRobot.entity.File;

public interface FileRepository extends CrudRepository<File, String>{

	List<File> findByLogin(String login);

}
