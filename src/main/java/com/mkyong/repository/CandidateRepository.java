package com.mkyong.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkyong.model.Candidate;
public interface CandidateRepository extends JpaRepository<Candidate,Long>{
	@Query(value="select * from candidate u where u.email =:email" ,nativeQuery= true)
	Candidate findEmail(@Param("email") String email);
	List<Candidate> findByInterviewresult(String interviewresult);
	@Query(value="SELECT * FROM candidate c inner join user u on c.id_user = u.id inner join roles r on u.id_roles = r.id and r.id=:id_roles" ,nativeQuery= true)
	List<Candidate> findCadidateByUser(@Param("id_roles") Integer id_roles);
	@Query(value="select * from candidate u where u.university like %?1% or u.gpa like %?1% or u.interviewdate like %?1% or u.graduationyear like %?1% or u.toeic like %?1% or u.interviewresult like %?1% or u.fullname like %?1% or u.iqtest like %?1% or u.technicaltest like %?1% or u.position like %?1% or u.email like %?1% or u.degree like %?1%",nativeQuery= true)
	List<Candidate> filterCandidate(String search);
	@Query(value="select * from candidate u where u.interviewresult=:failed or u.interviewresult=:passed and u.interviewdate>=:start and u.interviewdate<=:end",nativeQuery= true)
	List<Candidate> filter1Candidate(@Param("passed") String passed,@Param("failed") String failed,@Param("start") String start,@Param("end") String end);
	
	
	
}
