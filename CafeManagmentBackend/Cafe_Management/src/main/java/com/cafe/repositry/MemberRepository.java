package com.cafe.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.model.Member;


public interface MemberRepository extends JpaRepository<Member, Integer>{
	Member getMemberByMemberNameAndDesignation(String memberName, String designation);
}
