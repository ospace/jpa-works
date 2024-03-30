package com.tistory.ospace.controller

import com.tistory.ospace.repository.MemberRepository
import com.tistory.ospace.repository.entity.Member
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/members")
class MemberController(
    private val memberRepo: MemberRepository
) {
    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) : Member {
        logger.info("get begin: id[${id}]")
        val ret = memberRepo.findById(id)
        logger.info("get end: ret[${ret}]")
        return ret.get();
    }

    @PostMapping
    fun create(@RequestBody member : Member) : Member {
        logger.info("create begin: member[${member}]")

        val ret = memberRepo.save(member)
        logger.info("create end: ret[${ret}]")
        return ret
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody member: Member) : Member {
        logger.info("update begin: member[${member}]")
        val ret = memberRepo.save(member)
        logger.info("update end: ret[${ret}]")
        return ret
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        logger.info("delete begin: id[${id}]")
        memberRepo.deleteById(id)
        logger.info("delete end")
    }
}