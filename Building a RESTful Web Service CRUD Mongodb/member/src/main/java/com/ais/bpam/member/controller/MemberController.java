package com.ais.bpam.member.controller;

import com.ais.bpam.member.model.Member;
import com.ais.bpam.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping()
    public ResponseEntity<?> getMembers(){
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMember(@PathVariable String id){
        Optional<?> member = memberService.getMember(id);
        if(!member.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(member);
    }

    @PostMapping()
    public ResponseEntity<?> postMember(@RequestBody Member member) {
        Member customer = memberService.createMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putMember(@PathVariable String id, @RequestBody Member member) {
        Optional<?> customer = memberService.updateMember(id, member);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable String id) {
        if(!memberService.deleteMember(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


}
