package com.zhigaras.cloudservice

interface ApiResponse<T : Any> {
    
    class Success<T : Any>(private val data: T) : ApiResponse<T>
    
    class Error<T : Any>(private val message: String) : ApiResponse<T>
}