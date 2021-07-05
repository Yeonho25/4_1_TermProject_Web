package service;

import java.util.ArrayList;

import domain.Product;
import persistence.MemberRepository;
import persistence.ProductRepository;


public class MemberService {
	private final MemberRepository memberRepository = new MemberRepository();
	public MemberService() {
		
	}
	
	public void login(String memberID,String memberPassword) {
		memberRepository.login(memberID, memberPassword);
	}
}
