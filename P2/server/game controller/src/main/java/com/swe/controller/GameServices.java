package com.swe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameServices extends Game{
	
	@RequestMapping("/create/game/courseid") //show content in index.html
	public String index1()
	{
		return "index1";
	}
	
	@RequestMapping("/result1")
	public ModelAndView createCourse(
			@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("courseId") String courseId,
			@RequestParam("category") String category,
			@RequestParam("teacher") String teacher,
			Model model)
			{
			 Game s2 =new Game();
			 s2.setId(id);
			 s2.setName(name);
			 s2.setTeacher(teacher);
			 s2.setCategory(category);
			 s2.setCourseId(courseId);
			 allGames.add(s2);
			 ModelAndView mv = new ModelAndView();
			 mv.setViewName("index1");//select view 
			 mv.addObject("result1","Game: "+name +", added sucessfuly." );
			 return mv;
			}
	
	@RequestMapping("/games")
	public String allGames()
	{
		return "AllGames";
	}
	
	@RequestMapping("/result2")
	public ModelAndView getAllGames(Model model)
	{	String AllGames = "";
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AllGames");
		for(int i=0 ; i< allGames.size() ; i++)
		{
			AllGames+=" Game-"+(i+1)+" is : "+allGames.get(i).name + ".\n";
		}
		mv.addObject("result2" , AllGames);
		 return mv;
	}
	
	@RequestMapping("/game/id")
	public String getGameById()
	{
		return "getGameById";
	}
	@RequestMapping("/result3")
	public ModelAndView getCourseById(
			@RequestParam("id") String id,
			Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getGameById");
		for(int i=0 ; i< allGames.size() ; i++)
		{
			
			if(allGames.get(i).getId().contains( id )){
				mv.addObject("result3" ,"       "+ allGames.get(i).name+ " game.");
			}
		}
		 return mv;
	}
	
	@RequestMapping("/gamebycourse/courseid")
	public String getGameByCourse()
	{
		return "getGameByCourse";
	}
	@RequestMapping("/result4")
	public ModelAndView getGameByCourse(
			@RequestParam("courseId") String courseId,
			Model model)
	{
		String allGame ="";
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getGameByCourse");
		for(int i=0 ; i< allGames.size() ; i++)
		{
			
			if(allGames.get(i).getCourseId().contains( courseId )){
				allGame+="Game "+(i+1)+" is " +allGames.get(i).name +"  ,  ";
				}
		}
		mv.addObject("result4" ,allGame );
		 return mv;
	}

}