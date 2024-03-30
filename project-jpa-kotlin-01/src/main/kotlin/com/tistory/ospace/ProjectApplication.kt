package com.tistory.ospace

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ProjectApplication

fun main(args: Array<String>) {
	runApplication<ProjectApplication>(*args)
}
