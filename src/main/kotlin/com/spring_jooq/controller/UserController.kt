package com.spring_jooq.controller

import com.spring_jooq.service.UserService
import com.spring_jooq.util.R
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.jooq.generated.tables.pojos.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@Api(tags = ["管理用户"])
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @ApiOperation("增加用户")
    @PostMapping
    fun insertOne(@RequestBody user: User) : R<*>{
        return userService.insertOne(user)
    }

    @ApiOperation("删除用户")
    @DeleteMapping
    fun deleteOne(@RequestParam id :String) : R<*>{
        return userService.deleteOne(id)
    }

    @ApiOperation("更新用户")
    @PutMapping
    fun updateOne(@RequestBody user: User) : R<*>{
        return userService.updateOne(user)
    }

    @ApiOperation("查询用户")
    @GetMapping
    fun selectOne(@RequestParam id :String) : R<*>{
        return userService.selectOne(id)
    }

    @ApiOperation("查询所有")
    @GetMapping("/all")
    fun selectAll() :R<*>{
        return userService.selectAll()
    }
}