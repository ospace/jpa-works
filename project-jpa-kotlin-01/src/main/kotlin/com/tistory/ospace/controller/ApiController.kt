package com.tistory.ospace.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import com.tistory.ospace.entity.Member
import org.springframework.beans.factory.annotation.Autowired
import java.util.Optional
import com.tistory.ospace.repository.MemberRepository

@RestController
@RequestMapping("/api")
class ApiController (
    private val memberRepo:MemberRepository
) {
    @GetMapping("/me")
    fun me() : Optional<Member> {
        return memberRepo.findById("1")
    }
    
    @GetMapping("/create")
    fun new() : Member {
        val member = Member("1", "foo")
        return memberRepo.save(member)
    }
}