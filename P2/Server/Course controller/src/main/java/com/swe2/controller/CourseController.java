package com.swe2.controller;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class CourseController  extends Courses{

	
	/******************************************************/
	// Get My courses (  getMycourse  /mycourses/teacherid )
	@RequestMapping("/mycourses/teacherid") //show content in index.html
	public String course_teacherid()
	{
		return "getMycourses";
	}
	 
	
	@RequestMapping("/result4")
	public ModelAndView getMycourses(@RequestParam("teacherid") String teacherid,Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getMycourses");
		String allcourses = "";
		for(int i=0 ; i< AllCourses.size() ; i++)
		{
			
			if(AllCourses.get(i).getTeacherId().contains( teacherid ))
			{
				allcourses+= "Course "+ (1+i) +" is "+ AllCourses.get(i).getName() +" , ";
			}
			}
		mv.addObject("result4" ,allcourses);
		return mv;
		}
		
	
	
	
	/******************************************************/
	// Create new course   (createCourse     /create/course/teacherid)
	@RequestMapping("/create/course/teacherid") //show content in index.html
	public String index1()
	{
		return "index1";
	}
	
	@RequestMapping("/result1")
	public  ModelAndView createCourse(@RequestParam("name") String name ,@RequestParam("category") String category,
			@RequestParam("description") String description ,@RequestParam("courseid") String courseid,@RequestParam("courseid") String teacherid,Model model)
			{
			 Courses s2 =new Courses();	
			 s2.setName(name);
			 s2.setCategory(category);	
			 s2.setDescription(description);
			 s2.setId(courseid);
			 s2.setTeacherId(teacherid);
			 AllCourses.add(s2);
			 ModelAndView mv = new ModelAndView();
			 mv.setViewName("index1");//select view 
			 mv.addObject("result1","Course "+name +" added sucessfuly" );
			 return mv;
			}
			
	/******************************************************/
	// Get all courses   (getAllcourses   /courses ) 
	@RequestMapping("/courses")
	public String Allcourses()
	{
		return "Allcourses";
	}
	
	@RequestMapping("/result2")
	public ModelAndView getAllcourses(Model model)
	{	String Allcourses = "";
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Allcourses");
		for(int i=0 ; i< AllCourses.size() ; i++)
		{
			Allcourses+=" course "+(i+1)+" is : "+AllCourses.get(i).name + " , ";
		}
		mv.addObject("result2" , Allcourses);
		 return mv;
	}
	
	
	/******************************************************/
	// Get course by course id (	getCourseById	/course/id   ) 


	@RequestMapping("/course/id") //show content in index.html
	public String getCourseById()
	{
		return "getCourseById";
	}
	@RequestMapping("/result3")
	public ModelAndView getCourseById(@RequestParam("id") String id,Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getCourseById");
		for(int i=0 ; i< AllCourses.size() ; i++)
		{
			
			if(AllCourses.get(i).getId().contains( id )){mv.addObject("result3" , AllCourses.get(i).name );
			}
		}
		 return mv;
	}

}