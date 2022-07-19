package com.spring_jooq.service

import com.spring_jooq.util.R
import org.jooq.generated.tables.pojos.User

interface UserService {
    fun insertOne(user: User): R<*>
    fun deleteOne(id: String): R<*>
    fun updateOne(user: User): R<*>
    fun selectOne(id: String): R<*>
    fun selectAll(): R<*>
}