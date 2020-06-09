package com.ais.bpam.member.service;

import com.ais.bpam.member.model.Member;
import com.ais.bpam.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository){
        this.repository = repository;
    }

    //GET ALL DATA LIST
    public List<Member> getAllMembers(){
        return repository.findAll();
    }

    public Optional<Member> getMember(String id){
        return repository.findById(id);
    }

    //GET MEMBER BY NAME(S)
    public List<Member> getMemberByName(String name){
        return repository.findByName(name);
    }

    public Member createMember(Member member){
        return repository.save(member);
    }

    //UPDATE BY ID
    public Optional<Member> updateMember(String id,Member member){
        Optional<Member> memberOpt = repository.findById(id);

        if(!memberOpt.isPresent()){
            return  memberOpt;
        }
        member.setId(id);
        return Optional.of(repository.save(member));
    }

    //DELETE BY ID
    public boolean deleteMember(String id){
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
