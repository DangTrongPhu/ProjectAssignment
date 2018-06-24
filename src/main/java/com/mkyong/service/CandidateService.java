package com.mkyong.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.mkyong.model.Candidate;
import com.mkyong.repository.CandidateRepository;


@Service
public class CandidateService {

	private CandidateRepository candidateRepository;

	@Autowired
	public CandidateService(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}
	
	public List<Candidate> findAll() {
		return candidateRepository.findAll();
	}
	public Candidate save(Candidate candidate) {
			return candidateRepository.save(candidate);
		
		
	}
	
	public List<Candidate> filterCandidate(String search)
	{
		return candidateRepository.filterCandidate(search);
	}
	@PersistenceUnit
	private EntityManagerFactory emfactory;
	public List<Candidate> vidu(String passed,String failed,String start,String end,String test ) {
	    EntityManager entityManager = emfactory.createEntityManager() ;
	    String queryString = "select * FROM candidate u";
	    javax.persistence.Query q = entityManager.createNativeQuery(queryString,Candidate.class);
	    /*if(!passed.equals(""))
	    {
	    	queryString+=" where u.interviewresult ='"+passed+"'";//sinh viên đậu
	    	if(!start.equals(""))
	    	{
	    		queryString+=" and u.interviewdate >='"+start+"' and u.interviewdate<='"+end+"'"; // đậu + ngày
	    		if(!test.equals(""))
	    		{
	    			queryString+=" and u.university like '%"+test+"%'";
	    		}
	    		if(!failed.equals(""))
	    		{
	    			queryString = "select * FROM candidate u where u.interviewdate >='"+start+"' and u.interviewdate<='"+end+"'";// đậu rớt từ ngày đến ngày
	    		}
	    	}
	    	
	    	
	    }
	    else
	    {
	    	queryString+=" where u.interviewresult ='"+failed+"'";
	    	if(!start.equals(""))
	    	{
	    		queryString+=" and u.interviewdate >='"+start+"' and u.interviewdate<='"+end+"'"; // đậu + ngày
	    		if(!test.equals(""))
	    		{
	    			queryString+=" and u.university like '%"+test+"%'";
	    		}
	    	}
	    	
	    }*/
	    if(!passed.equals(""))
	    {
	    	queryString+=" where u.interviewresult ='"+passed+"'";//sinh viên đậu
	    	if(!start.equals("")&& !test.equals(""))
	    	{
	    		queryString+=" and u.interviewdate >='"+start+"' and u.interviewdate<='"+end+"'and u.university  like '%"+test+"%'"; // đậu + ngày
	    	}
	    	else
	    	{
	    		if(!start.equals(""))
	    		{
	    			queryString+=" and u.interviewdate >='"+start+"' and u.interviewdate<='"+end+"'";
	    		}
	    		else
	    		{
	    			if(!test.equals(""))
	    			{
	    				queryString+=" and u.university like '%"+test+"%'";
	    			}
	    			
	    		}
	    	}
	    }
	    if(!failed.equals(""))
	    {
	    	queryString+=" where u.interviewresult ='"+failed+"'";//sinh viên rớt
	    	if(!start.equals("")&& !test.equals(""))
	    	{
	    		queryString+=" and u.interviewdate >='"+start+"' and u.interviewdate<='"+end+"'and u.university like '%"+test+"%'"; // failed + ngày
	    	}
	    	else
	    	{
	    		if(!start.equals(""))
	    		{
	    			queryString+=" and u.interviewdate >='"+start+"' and u.interviewdate<='"+end+"'";
	    		}
	    		else
	    		{
	    			if(!test.equals(""))
	    			{
	    				queryString+=" and u.university like '%"+test+"%'";
	    			}
	    			
	    		}
	    	}
	    }
	    if(!passed.equals("")&& !failed.equals(""))
	    {
	    	queryString = "select * FROM candidate u";
	    	if(!start.equals("")&& !test.equals(""))
	    	{
	    		queryString+=" where u.interviewdate >='"+start+"' and u.interviewdate<='"+end+"'and u.university like '%"+test+"%'"; // failed + ngày
	    	}
	    	else
	    	{
	    		if(!start.equals(""))
	    		{
	    			queryString+=" where u.interviewdate >='"+start+"' and u.interviewdate<='"+end+"'";
	    		}
	    		else
	    		{
	    			if(!test.equals(""))
	    			{
	    				queryString+=" where u.university like '%"+test+"%'";
	    			}
	    			
	    		}
	    	}
	    	
	    }
	    q = entityManager.createNativeQuery(queryString,Candidate.class);
	    List<Candidate> result = (List<Candidate>) ((javax.persistence.Query) q).getResultList();;
	    entityManager.close();
	    return result;
	}
	public List<Candidate> filter1Candidate(String passed,String failed,String start,String end,String university)
	{
		try {
			return candidateRepository.filter1Candidate(passed,failed,start,end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void delete(Long id) {
		candidateRepository.delete(id);
	}
	public Candidate update(Candidate candidate) {
		if (String.valueOf(candidate.getId()) != null && !candidateRepository.exists(candidate.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return candidateRepository.save(candidate);
	}
	public Candidate findByEmail(String email)
	{
		return candidateRepository.findEmail(email);
	}
	
	public Candidate findOne(Long id)
	{
		return candidateRepository.findOne(id);
	}
	public List<Candidate> findByInterviewresult(String interviewresult)
	{
		return candidateRepository.findByInterviewresult(interviewresult);
	}
	
	public List<Candidate> findCadidateByUser(Integer id_roles)
	{
		return candidateRepository.findCadidateByUser(id_roles);
	}
}
