package com.tistory.ospace.repository

import com.tistory.ospace.repository.entity.Member
import org.springframework.data.repository.CrudRepository

interface MemberRepository : CrudRepository<Member, Long>{
}