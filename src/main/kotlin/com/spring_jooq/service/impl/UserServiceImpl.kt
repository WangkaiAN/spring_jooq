package com.spring_jooq.service.impl

import com.spring_jooq.service.UserService
import com.spring_jooq.util.R
import jdk.nashorn.internal.runtime.regexp.joni.Config.log
import org.jooq.DSLContext
import org.jooq.generated.Tables.USER
import org.jooq.generated.tables.pojos.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var dslContext: DSLContext

    override fun insertOne(user: User): R<*> {
        log.println("增加一条数据")
        val user1 = findOne(user.id)
        if(user1 != null){
            return R.failed(null,"主键相同，请修改，重新存入")
        }
        val line = dslContext.insertInto(USER)
                .set(USER.ID,user.id)
                .set(USER.NAME,user.name)
                .set(USER.AGE,user.age)
                .set(USER.CREATE_TIME, LocalDateTime.now())
                .execute()
        return R.ok(line,"插入成功，影响到")
    }

    override fun deleteOne(id: String): R<*> {
        log.println("删除一条数据")
        findOne(id) ?: return R.failed(null,"不存在该主键的数据，重新存入")
        val line = dslContext.delete(USER)
                .where(USER.ID.eq(id))
                .execute()
        return R.ok(line,"删除成功，影响到")
    }

    override fun updateOne(user: User): R<*> {
        log.println("更新一条数据")
        findOne(user.id) ?: return R.failed(null,"不存在该主键的数据，重新存入")
        val line = dslContext.update(USER)
                .set(USER.NAME,user.name)
                .set(USER.AGE,user.age)
                .where(USER.ID.eq(user.id))
                .execute()
        return R.ok(line,"更新成功，影响到")
    }

    override fun selectOne(id: String): R<*> {
        log.println("查询一条消息")
        val user = findOne(id)
        return R.ok(user,"查询到的内容为")
    }

    override fun selectAll(): R<*> {
        log.println("查询所有用户")
        val userMap : Map<String,User> = dslContext
                .select()
                .from(USER)
                .fetchMap(USER.ID,User::class.java)
        return R.ok(userMap,"查询到了所有用户")
    }

    private fun findOne(id: String?): User? {
        return dslContext.select()
                .from(USER)
                .where(USER.ID.eq(id))
                .fetchOne()?.into(User::class.java)
    }
}