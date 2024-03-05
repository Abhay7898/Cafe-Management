package com.cafe.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.model.Member;
import com.cafe.repositry.MemberRepository;
import com.cafe.services.MemberSevice;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeamServiceImpl implements MemberSevice {

	@Autowired
	public MemberRepository memberRepository;

	@Override
	public Member addMember(Member member) {
		Member check=getMemberByMemberNameAndDesignation(member.getMemberName(), member.getDesignation());
		return check==null?null:memberRepository.save(null);
	}

	@Override
	public Member getMemberByMemberNameAndDesignation(String memberName, String designation) {
		return memberRepository.getMemberByMemberNameAndDesignation(memberName, designation);
	}

	@Override
	public List<Member> getAllMember() {
		return memberRepository.findAll();
	}

	@Override
	public Member getMemberById(int id) {
		return memberRepository.findById(id).get();
	}

	@Override
	public boolean updateMember(Member member) {
		Optional<Member> check=memberRepository.findById(member.getId());
		if(check.isPresent()) {
			Member old=check.get();
			old.setId(member.getId());
			old.setMemberName(member.getMemberName());
			old.setDesignation(member.getDesignation());
			old.setMemberImage(member.getMemberImage());
			try {
				memberRepository.save(old);
				return true;
			}catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean deleteMember(int id) {
		if(memberRepository.existsById(id)) {
			try {
				memberRepository.deleteById(id);
				return true;
			} catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}

}
