package com.example.demo.api.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.api.jpa.vo.MemberVo;

public interface MemberRepository extends CrudRepository<MemberVo, Long> {
	
	List<MemberVo> findByNameAndAgeLessThan(String name, int age);
	
	@Query("select t from Member t where name=:name and age < :age")
	List<MemberVo> findByNameAndAgeLessThanSQL(@Param("name") String name, @Param("age") int age);
	
	List<MemberVo> findByNameAndAgeLessThanOrderByAgeDesc(String name, int age);
}
