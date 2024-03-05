package com.cafe.services;

import java.util.List;

import com.cafe.model.Member;


public interface MemberSevice {
	
	public Member addMember(Member member);

	public Member getMemberByMemberNameAndDesignation(String memberName, String designation );

	public List<Member> getAllMember();

	public Member getMemberById(int id);

	public boolean updateMember(Member member);
	
	public boolean deleteMember(int id);

	
}
