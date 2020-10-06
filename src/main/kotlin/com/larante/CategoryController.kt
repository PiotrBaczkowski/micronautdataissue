package com.larante

import com.larante.repository.*
import com.larante.model.Category
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/categories")
class CategoryController (
        private val categoryRepository: CategoryRepository
) {

    @Get("/")
    fun findAll(): HttpResponse<Any> {
        val response = categoryRepository.findAll();
        return HttpResponse.ok(response);
    }

    @Post("/")
    fun saveCategory(category: Category, partnerId: Long): HttpResponse<Category>{
        return HttpResponse.created(categoryRepository.save(category))
    }

}
