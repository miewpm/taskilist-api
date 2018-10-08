package com.task.api;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskApiController {
	
	List<TaskApi> tasklist = new ArrayList<>();
	private List<TaskApi> taskInList;
	
	@RequestMapping("/tasks")
	public List<TaskApi> getTaskList(){
		return tasklist;
	}
	
	@RequestMapping(value = "/tasks/{subject}", method = RequestMethod.GET)
	public List<TaskApi> getSingleTask(@PathVariable String subject) {
		System.out.println("Task : " + subject);
		for(int i = 0; i < tasklist.size(); i++) {
		    if(tasklist.get(i).getSubjectOfTask().equalsIgnoreCase(subject)) {
		    	taskInList = Arrays.asList(
		    			new TaskApi(tasklist.get(i).getSubjectOfTask(), 
		    					tasklist.get(i).getDetailOfTask(), 
		    					tasklist.get(i).getStatusOfTask()));
		    }
		}
		return taskInList;
	}
	
	 @RequestMapping(value = "/create", method = RequestMethod.POST)
	 public List<TaskApi> createTask(@RequestBody TaskApi taskAdd) {
		 System.out.println("Create Task : " + taskAdd.getStatusOfTask());
		 taskInList = Arrays.asList(new TaskApi(taskAdd.getSubjectOfTask(), 
				 taskAdd.getDetailOfTask(), 
				 taskAdd.getStatusOfTask()));
		 
		 tasklist.addAll((Collection<? extends TaskApi>) taskInList);
		 return tasklist;
	}
	 
	@RequestMapping(value = "/update/{subject}", method = RequestMethod.PUT)
	public List<TaskApi> updateTask(@PathVariable String subject, @RequestBody TaskApi taskAdd) {
		System.out.println("Update Task : " + subject);
	         
	        for(int i = 0; i < tasklist.size(); i++) {
			    if(tasklist.get(i).getSubjectOfTask().equals(subject)) {
			    	
			    	if(taskAdd.getSubjectOfTask() != null || !(taskAdd.getSubjectOfTask().equals(""))) {
			    		tasklist.get(i).setSubjectOfTask(taskAdd.getSubjectOfTask());
			    	}
			    	if(taskAdd.getDetailOfTask() != null || !(taskAdd.getDetailOfTask().equals(""))) {
			    		tasklist.get(i).setDetailOfTask(taskAdd.getDetailOfTask());
			    	}
			    	if(taskAdd.getStatusOfTask() != null || !(taskAdd.getStatusOfTask().equals(""))) {
			    		tasklist.get(i).setStatusOfTask(taskAdd.getStatusOfTask());
			    	}
			    	
			    }
			}
			return tasklist; 
	}
	
	@RequestMapping(value = "/updatestatus/{subject}", method = RequestMethod.PUT)
	public List<TaskApi> updateStatusOfTask(@PathVariable String subject, @RequestBody TaskApi taskAdd) {
		System.out.println("Update Task : " + subject);
	         
	        for(int i = 0; i < tasklist.size(); i++) {
			    if(tasklist.get(i).getSubjectOfTask().equals(subject)) {
			    	tasklist.get(i).setStatusOfTask(taskAdd.getStatusOfTask());
			    }
			}
			return tasklist; 
	}
	 
	 
	@RequestMapping(value = "/delete/{subject}", method=RequestMethod.DELETE)
	public void deleteSingleTask(@PathVariable String subject) {
		System.out.println("Delete Task : " + subject);
		for(int i = 0; i < tasklist.size(); i++) {
		    if(tasklist.get(i).getSubjectOfTask().equals(subject)) {
		    	tasklist.remove(i);
		        break;
		    }
		}
	}
	
	
 }
