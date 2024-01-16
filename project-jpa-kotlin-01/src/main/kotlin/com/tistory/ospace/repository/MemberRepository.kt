package com.tistory.ospace.repository

import org.springframework.data.repository.CrudRepository
import com.tistory.ospace.entity.Member

interface MemberRepository : CrudRepository<Member, String> {
}