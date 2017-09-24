package com.haken.todobackendkotlin

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Todo(@Id var id:Long = 0,
                var title:String = "",
                var completed:Boolean = false,
                var url:String = "",
                @Column(name = "orderId") var order:Long = 0)

