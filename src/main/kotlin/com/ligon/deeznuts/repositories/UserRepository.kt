package com.ligon.deeznuts.repositories

import com.ligon.deeznuts.models.User
import com.ligon.deeznuts.models.dao.UserDao
import com.ligon.deeznuts.tables.Users
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.or
import org.jetbrains.exposed.sql.selectAll

class UserRepository {
    suspend fun existsByUsernameOrPhoneNumber(username: String, phoneNumber: String): Boolean = dbQuery {
        Users.selectAll()
            .where { (Users.username eq username) or (Users.phoneNumber eq phoneNumber) }
            .any()
    }

    suspend fun create(user: User): User = dbQuery {
        val dao = UserDao.new {
            username = user.username
            firstName = user.firstName
            lastName = user.lastName
            phoneNumber = user.phoneNumber
            password = user.password
        }

        dao.toUser()
    }

    suspend fun findByUsernameOrPhoneNumber(usernameOrPhoneNumber: String): User? = dbQuery {
        UserDao.find { Users.username eq usernameOrPhoneNumber }
            .singleOrNull()
            ?.toUser()
    }

    suspend fun findById(id: Long): User? = dbQuery {
        UserDao.find { Users.id eq id }.singleOrNull()?.toUser()
    }

    suspend fun delete(id: Long) = dbQuery {
        Users.deleteWhere { Users.id eq id }
    }
}
