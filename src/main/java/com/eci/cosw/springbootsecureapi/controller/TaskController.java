package com.eci.cosw.springbootsecureapi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping( "api" )
@CrossOrigin(origins = "*")
public class TaskController {
	
	@Autowired
    ObjectMapper mapperJson;

	public TaskController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	public ResponseEntity<?> getAllTask() {
		List<Task> tasks = new ArrayList<Task>();
		try {
			tasks = mapperJson.readValue(Unirest.get("https://lab7-task-planner-api.azurewebsites.net/api/list-task?code=2laB9R2OrQDVj2800dkKqmHFsE4onIZMWXufwNHnYATyZa13pbZo2A==").asString().getBody(), new TypeReference<List<Task>>(){});
		} catch (UnirestException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	  @PostMapping
	  public ResponseEntity<?> addTask(@RequestBody Task task){
		  try {
			Unirest.post("https://lab7-task-planner-api.azurewebsites.net/api/add-task?code=qwUOluz8iootIU/V97MImZuMxg9l50shNIFlewjtZtgD10bOlus5Bg==").header("Content-Type","application/json").body(mapperJson.writeValueAsString(task)).asString().getStatus();
		} catch (JsonProcessingException | UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return new ResponseEntity<>(HttpStatus.ACCEPTED);
	  }
}
