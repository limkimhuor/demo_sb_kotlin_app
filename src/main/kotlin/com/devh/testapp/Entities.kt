package com.devh.testapp

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "articles")
class Article(
    var title: String = "",
    var headline: String = "",
    var content: String = "",
    // Don't use FetchType.Lazy will not load user
    @ManyToOne(fetch = FetchType.EAGER, optional = false) @JoinColumn(name = "author_id", nullable = false) var author: User? = null,
    var slug: String = title.let { it.toSlug() },
    var addAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null
)

@Entity
@Table(name = "users")
class User(
    var login: String = "",
    var firstname: String = "",
    var lastname: String = "",
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null
) : Serializable
