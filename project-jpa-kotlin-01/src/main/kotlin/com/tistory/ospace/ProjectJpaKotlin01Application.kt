package com.tistory.ospace

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ProjectJpaKotlin01Application

fun main(args: Array<String>) {
	runApplication<ProjectJpaKotlin01Application>(*args)
}
