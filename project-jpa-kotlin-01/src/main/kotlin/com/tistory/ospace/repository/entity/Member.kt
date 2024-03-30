package com.tistory.ospace.repository.entity

import jakarta.persistence.*
import org.springframework.data.jpa.domain.AbstractPersistable_.id


@Entity
// @Table(name ="tb_user")
open class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id:Long? = null;
    // @Column
    private var name:String? = null;

    open fun getId(): Long? = id
    open fun setId(id:Long?) {
        this.id = id
    }
    open fun getName(): String? = name
    open fun setName(name:String?) {
        this.name = name
    }
}