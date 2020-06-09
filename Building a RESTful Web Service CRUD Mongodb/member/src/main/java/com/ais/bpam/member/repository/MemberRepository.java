package com.ais.bpam.member.repository;

import com.ais.bpam.member.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberRepository extends MongoRepository<Member, String> {
    List<Member> findByName(String name);
}
