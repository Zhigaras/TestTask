package com.zhigaras.adapterdelegate

interface ListItem {
    
    fun itemType(): Int = this::class.hashCode()
    
    fun areItemTheSame(other: ListItem): Boolean
    
    fun areContentTheSame(other: ListItem): Boolean
    
    fun payload(other: ListItem): Payload<*> = Payload.None()
}