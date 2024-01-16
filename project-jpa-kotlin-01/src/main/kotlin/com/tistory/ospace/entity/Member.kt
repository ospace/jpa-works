package com.tistory.ospace.entity

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
data class Member (
    @Id
    public var id:String? = null,
    public var name:String? = null,
    @Transient
    public var t: LocalDateTime = LocalDateTime.now(), 
)