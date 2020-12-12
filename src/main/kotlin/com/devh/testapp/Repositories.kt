package com.devh.testapp

import org.springframework.data.repository.CrudRepository
import com.fasterxml.jackson.annotation.JsonProperty


interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddAtDesc(): List<Article>
}

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
}
