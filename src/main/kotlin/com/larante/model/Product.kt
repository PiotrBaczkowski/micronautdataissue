package com.larante.model

import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.*
import io.micronaut.data.jdbc.annotation.JoinTable
import java.math.BigDecimal
import java.time.LocalDateTime

@MappedEntity
@Introspected
data class Product(
        @field:Id
        @field:GeneratedValue
        var id: Long? = null,
        var name: String,
        var price: BigDecimal,
        var description: String,
        var visible: Boolean = true,

        var categoryId: Long? = null,

        @field:Relation(Relation.Kind.ONE_TO_MANY, mappedBy = "productId")
        var productOption: List<ProductOption>? = null,
        var imageUrl: String? = null,

        @DateCreated
        var createDate: LocalDateTime? = null


)

