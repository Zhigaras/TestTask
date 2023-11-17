package com.zhigaras.rooms.domain

import com.zhigaras.rooms.domain.model.RoomDomainModel

interface FetchResult {
    
    fun handle(flowWrapper: RoomsFlowWrapper.Post)
    
    class Success(private val data: List<RoomDomainModel>) : FetchResult {
        
        override fun handle(flowWrapper: RoomsFlowWrapper.Post) {
        
        }
    }
    
    class Error(private val message: String) : FetchResult {
        
        override fun handle(flowWrapper: RoomsFlowWrapper.Post) {
        
        }
    }
}