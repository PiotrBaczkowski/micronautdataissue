package com.larante.repository

import com.larante.model.Category
import io.micronaut.data.annotation.Join
import io.micronaut.data.annotation.repeatable.JoinSpecifications
import io.micronaut.data.repository.CrudRepository

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import javax.inject.Singleton

@JdbcRepository(dialect = Dialect.POSTGRES)
@Singleton
interface CategoryRepository : CrudRepository<Category, Long> {

    @JoinSpecifications(
    Join(value = "productList", alias =  "p_", type =  Join.Type.LEFT_FETCH)
    )
    override fun findAll(): List<Category>;
}

