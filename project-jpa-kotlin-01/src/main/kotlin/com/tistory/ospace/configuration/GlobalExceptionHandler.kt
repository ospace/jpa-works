package com.tistory.ospace.configuration

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = [Exception::class])
    fun handleException(ex: Exception, req: HttpServletRequest): ErrorVo {
        logger.error("서버 내부 오류: ${ex.message}", ex)
        return ErrorVo(HttpStatus.INTERNAL_SERVER_ERROR.value(), req.requestURI, ex.message)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [NoSuchElementException::class])
    fun handleNoSuchElementException(ex: NoSuchElementException, req: HttpServletRequest) : ErrorVo {
//        logger.error("${ex.javaClass.simpleName}: uri[${req.requestURI}] message[${ex.message}]", ex)
        logger.error("${ex.javaClass.simpleName}: uri[${req.requestURI}] message[${ex.message}]")
        return ErrorVo(HttpStatus.NOT_FOUND.value(), req.requestURI, "NoSuchElementException")
    }
}

data class ErrorVo (
    val status: Int,
    val uri: String,
    val message: String?,
)