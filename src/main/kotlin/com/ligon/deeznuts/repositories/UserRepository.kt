package com.ligon.deeznuts.repositories

import com.ligon.deeznuts.models.User
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepository {
    private object Users : Table() {
        val id = integer("id").autoIncrement()
        val username = text("username").uniqueIndex()
        val email = text("email").uniqueIndex()
        val password = text("password")

        override val primaryKey = PrimaryKey(id)
    }

    init {
        transaction {
            SchemaUtils.create(Users)
        }
    }

    suspend fun existsByUsernameOrEmail(username: String, email: String): Boolean = dbQuery {
        Users.selectAll().where { (Users.username eq username) or (Users.email eq email) }.any()
    }

    suspend fun create(user: User): User = dbQuery {
        val res = Users.insert {
            it[username] = user.username
            it[email] = user.email
            it[password] = user.password
        }
        return@dbQuery User(res[Users.id], res[Users.username], res[Users.email], res[Users.password])
    }

    suspend fun findByUsernameOrEmail(usernameOrEmail: String): User? = dbQuery {
        Users.selectAll()
            .where { (Users.username eq usernameOrEmail) or (Users.email eq usernameOrEmail) }
            .map(::toUser)
            .singleOrNull()
    }

    suspend fun findById(id: Int): User? = dbQuery {
        Users.selectAll()
            .where { Users.id eq id }
            .map(::toUser)
            .singleOrNull()
    }

    suspend fun read(id: Int): User? {
        return dbQuery {
            Users.selectAll()
                .where { Users.id eq id }
                .map(::toUser)
                .singleOrNull()
        }
    }

    suspend fun delete(id: Int) {
        dbQuery {
            Users.deleteWhere { Users.id eq id }
        }
    }

    private suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }

    private fun toUser(it: ResultRow) = User(it[Users.id], it[Users.username], it[Users.email], it[Users.password])
}
