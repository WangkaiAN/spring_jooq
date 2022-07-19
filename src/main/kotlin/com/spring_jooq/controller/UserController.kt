package com.spring_jooq.controller

import com.spring_jooq.service.UserService
import com.spring_jooq.util.R
import org.jooq.generated.tables.pojos.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping
    fun insertOne(@RequestBody user: User) : R<*>{
        return userService.insertOne(user)
    }

    @DeleteMapping
    fun deleteOne(@RequestParam id :String) : R<*>{
        return userService.deleteOne(id)
    }

    @PutMapping
    fun updateOne(@RequestBody user: User) : R<*>{
        return userService.updateOne(user)
    }

    @GetMapping
    fun selectOne(@RequestParam id :String) : R<*>{
        return userService.selectOne(id)
    }

    @GetMapping("/all")
    fun selectAll() :R<*>{
        return userService.selectAll()
    }
}