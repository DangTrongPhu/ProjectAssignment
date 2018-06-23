package com.mkyong.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.messeage.Response;
import com.mkyong.model.Candidate;
import com.mkyong.service.CandidateService;

@RestController
@RequestMapping("/api")
public class CandidateController {	

	private CandidateService candidateService;

	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	@GetMapping("candidates")
	public Response getAllCandidate(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		int quyen = 0;
		List<Candidate> candidate =new ArrayList<>();
		try {
			if (session == null) {
			    // Not created yet. Now do so yourself.
			    session = request.getSession();
			} 
			
			if(session.getAttribute("quyen")==null)
			{
				session = request.getSession(true);
				session.setAttribute("quyen", 0);
				
			}
			else
			{
				Object q= session.getAttribute("quyen");
				quyen = Integer.parseInt((String) q);
			}
		}catch(Exception ex)
		{
			
		}
		if(quyen==1)
		{
			candidate = candidateService.findAll();
		}
		else
		{
			if(quyen==2)
			{
				candidate = candidateService.findCadidateByUser(2);
			}
			else
			{
				candidate = candidateService.findAll();
			}
		}
		return new Response("Done",candidate);
	}
	@GetMapping("deleteCandidate")
	public Response deleteCandidate(@RequestParam("id") String id) {
		try {
			candidateService.delete(Long.parseLong(id));
			return new Response("Done","");
		}catch(Exception e) {
			return new Response("false","Delete Candidate error");
		}
	}
	@GetMapping("quyen")
	public Response getquyen(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		int quyen = 0;
		try {
			if (session == null) {
			    // Not created yet. Now do so yourself.
			    session = request.getSession();
			} 
			
			if(session.getAttribute("quyen")==null)
			{
				session = request.getSession(true);
				session.setAttribute("quyen", 0);
				
			}
			else
			{
				Object q= session.getAttribute("quyen");
				quyen = Integer.parseInt((String) q);
			}
			
		}
		catch(Exception ex)
		{
		}
		
		
		return new Response("Done",quyen);
	}
	@RequestMapping("/savecandidate")
	public Response saveCandidate(@RequestParam("id_user") String id_user,@RequestParam("fullname") String fullname,@RequestParam("gpa") String gpa,@RequestParam("graduationyear") String 	graduationyear,
								@RequestParam("position") String position,@RequestParam("university") String university,@RequestParam("interviewdate") Date interviewdate,@RequestParam("iqtest") String 	iqtest,
								@RequestParam("technicaltest") String technicaltest,@RequestParam("toeic") String toeic,@RequestParam("interviewresult") String interviewresult,@RequestParam(value="interviewcomments",required=false) String interviewcomments,
								@RequestParam("dayofbirth") Date dayofbirth,@RequestParam("email") String email,@RequestParam("phone") String phone,@RequestParam("address") String address,
								@RequestParam("degree") String degree,@RequestParam(value="notes",required=false) String notes) throws ParseException {
		if(candidateService.findByEmail(email)!=null)
		{

			return new Response("false","Email đã tồn tại");
		}
		try {
		
		Candidate candidate = new Candidate();
		candidate.setId_user(id_user);
		candidate.setFullname(fullname);
		candidate.setGpa(Double.parseDouble(gpa));
		candidate.setGraduationyear(Integer.parseInt(graduationyear));
		candidate.setPosition(position);
		candidate.setUniversity(university);
		candidate.setInterviewdate(interviewdate);
		candidate.setIqtest(Integer.parseInt(iqtest));
		candidate.setTechnicaltest(Integer.parseInt(technicaltest));
		candidate.setToeic(Integer.parseInt(toeic));
		candidate.setInterviewresult(interviewresult);
		candidate.setInterviewcomments(interviewcomments);
		candidate.setDayofbirth(dayofbirth);
		candidate.setEmail(email);
		candidate.setPhone(phone);
		candidate.setAddress(address);
		candidate.setDegree(degree);
		candidate.setNotes(notes);
		candidate = candidateService.save(candidate);
		return new Response("Done", candidate);
	}catch (Exception e) 
	{
		return new Response("false","");
	}
		
	}
	@RequestMapping("/updatecandidate")
	public Response updateCandidate(@RequestParam("id") String id,@RequestParam("id_user") String id_user,@RequestParam("fullname") String fullname,@RequestParam("gpa") String gpa,@RequestParam("graduationyear") String 	graduationyear,
								@RequestParam("position") String position,@RequestParam("university") String university,@RequestParam("interviewdate") Date interviewdate,@RequestParam("iqtest") String 	iqtest,
								@RequestParam("technicaltest") String technicaltest,@RequestParam("toeic") String toeic,@RequestParam("interviewresult") String interviewresult,@RequestParam(value="interviewcomments",required=false) String interviewcomments,
								@RequestParam("dayofbirth") Date dayofbirth,@RequestParam("email") String email,@RequestParam("phone") String phone,@RequestParam("address") String address,
								@RequestParam("degree") String degree,@RequestParam(value="notes",required=false) String notes) throws ParseException {
		
		
		try {
		Candidate candidate = candidateService.findOne(Long.parseLong(id));
		if(!email.equals(candidate.getEmail()))
		{
			if(candidateService.findByEmail(email)!=null)
			{
				return new Response("false","Email đã tồn tại");
			}
		}
		candidate.setId_user(id_user);
		candidate.setFullname(fullname);
		candidate.setGpa(Double.parseDouble(gpa));
		candidate.setGraduationyear(Integer.parseInt(graduationyear));
		candidate.setPosition(position);
		candidate.setUniversity(university);
		candidate.setInterviewdate(interviewdate);
		candidate.setIqtest(Integer.parseInt(iqtest));
		candidate.setTechnicaltest(Integer.parseInt(technicaltest));
		candidate.setToeic(Integer.parseInt(toeic));
		candidate.setInterviewresult(interviewresult);
		candidate.setInterviewcomments(interviewcomments);
		candidate.setDayofbirth(dayofbirth);
		candidate.setEmail(email);
		candidate.setPhone(phone);
		candidate.setAddress(address);
		candidate.setDegree(degree);
		candidate.setNotes(notes);
		candidateService.save(candidate);
		return new Response("Done", candidate);
	}catch (Exception e) 
	{
		return new Response("false","Update candidate error");
	}
		
	}
	/*@GetMapping("filter1")
	public Response filter1(HttpServletRequest request,@RequestParam(value="test",required=false) String test,@RequestParam(value="select",required=false) String select,@RequestParam(value="passed",required=false) String passed,@RequestParam(value="failed",required=false) String failed,@RequestParam(value="end",required=false) String end,@RequestParam(value="start",required=false) String start) {
		List<Candidate> candidate = new ArrayList<>();
		try {
			if(!String.valueOf(start).equals("")&&!String.valueOf(end).equals(""))
			{
				if(passed.equals("true"))
				{
					candidate= candidateService.filter1Candidate("passed","",start,end,"");
					
					if(failed.equals("true"))
					{
						candidate= candidateService.filter1Candidate("passed","failed",start,end,"");
						if(!test.equals("undifined")&& select.equals("undifined"))
						{
							candidate =candidateService.filter1Candidate("passed", "failed",start, end, test);
						}
					}
				
				}
				else
				{
					if(failed.equals("true"))
					{
						candidate =candidateService.vidu("failed");
					}
				}
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Response("Done",candidate);
	}*/
	@GetMapping("filter1")
	public Response filter1(HttpServletRequest request,@RequestParam(value="test",required=false) String test,@RequestParam(value="select",required=false) String select,@RequestParam(value="passed",required=false) String passed,@RequestParam(value="failed",required=false) String failed,@RequestParam(value="end",required=false) String end,@RequestParam(value="start",required=false) String start) {
		List<Candidate> candidate = new ArrayList<>();
		try {
				if(passed.equals("true"))
				{
					candidate= candidateService.vidu("passed","","",""); // sinh viên đậu
					
					if(failed.equals("true"))
					{
						candidate = candidateService.findAll();
					}
					if(!start.equals("undefined"))
					{
						candidate= candidateService.vidu("passed","",start,end); //đậu + từ ngày đến ngày
						if(failed.equals("true"))
						{
							candidate = candidateService.vidu("passed", "failed", start, end); //đậu +rớt+ từ ngày đến ngày
						}
					}
				}
				else
				{
					if(failed.equals("true"))
					{
						candidate =candidateService.vidu("","failed",start,end);
						if(!start.equals("undefined"))
						{
						candidate= candidateService.vidu("","failed",start,end); //đậu + từ ngày đến ngày
						
					}
					}
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Response("Done",candidate);
	}
	@GetMapping("filter")
	public Response filter(HttpServletRequest request,@RequestParam("search") String search) {
		List<Candidate> candidate = new ArrayList<>();
		try {
			candidate=candidateService.filterCandidate(search);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Response("Done",candidate);
	}
	@GetMapping("search")
	public Response getAll(HttpServletRequest request,@RequestParam("search") Integer search) {
		Iterable<Candidate> candidate = candidateService.findAll();
		switch (search) {
		case 1:
			candidate = candidateService.findByInterviewresult("Passed");
			return new Response("Done",candidate);
		case 2:
			candidate = candidateService.findByInterviewresult("Failed");
			return new Response("Done", candidate);

		default:
			candidate = candidateService.findAll();
			break;
		}
		return new Response("Done",candidate);
	}
	
	@RequestMapping(value = "candidate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> getAllCandidates(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object q= session.getAttribute("quyen");
		List<Candidate> candidate =new ArrayList<>();
		int quyen = Integer.parseInt((String) q);
		if(String.valueOf(quyen)==null)
		{
			quyen=0;
		}
		if(quyen==1)
		{
			candidate = candidateService.findAll();
		}
		else
		{
			if(quyen==2)
			{
				candidate = candidateService.findCadidateByUser(2);
			}
			else
			{
				candidate = candidateService.findAll();
			}
		}
		return candidate;
		
	}
	@RequestMapping(value = "candidate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) throws URISyntaxException {
		try {
				if(candidateService.findByEmail(candidate.getEmail())==null)
				{
					Candidate result = candidateService.save(candidate);
					return ResponseEntity.created(new URI("/api/candidate/" + result.getId())).body(result);
				}
			
			} catch (EntityExistsException e) {
			return new ResponseEntity<Candidate>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Candidate>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/candidate/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
		candidateService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "candidate", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate) throws URISyntaxException {
		if (String.valueOf(candidate.getId()) == null) {
			return new ResponseEntity<Candidate>(HttpStatus.NOT_FOUND);
		}

		try {
			Candidate result = candidateService.update(candidate);

			return ResponseEntity.created(new URI("/api/candidate/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Candidate>(HttpStatus.NOT_FOUND);
		}
	}
}
