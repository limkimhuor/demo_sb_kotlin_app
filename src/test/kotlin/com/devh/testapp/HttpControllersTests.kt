package com.devh.testapp

import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class HttpControllersTests(@Autowired val mockMvc: MockMvc) {

    @MockBean
    private lateinit var userRepository: UserRepository

    @MockBean
    private lateinit var articleRepository: ArticleRepository

    @Test
    fun `List articles`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        val spring5Article = Article("Spring 5 Framework", "Dear..", "Lorem", juergen)
        val spring4Article = Article("Spring 4 Framework", "Dear..", "Lorem", juergen)
        every { articleRepository.findAllByOrderByAddAtDesc() } returns listOf(spring5Article, spring4Article)
        mockMvc.perform(get("/api/article").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("\$.[0].author.login").value(juergen.login))
            .andExpect(jsonPath("\$.[0].slug").value(spring5Article.slug))
            .andExpect(jsonPath("\$.[1].author.login").value(juergen.login))
            .andExpect(jsonPath("\$.[1].slug").value(spring4Article.slug))

    }

    @Test
    fun `List users`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        val smaldini = User("smaldini", "Stéphane", "Maldini")
every { userRepository.findAll() } returns listOf(juergen, smaldini)
        mockMvc.perform(get("/api/user").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("\$.[0].login").value(juergen.login))
            .andExpect(jsonPath("\$.[1].login").value(smaldini.login))
    }

}
