package com.larante.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.*
import java.time.LocalDateTime
import javax.annotation.Nullable
import javax.validation.constraints.NotBlank

@MappedEntity
@Introspected
data class Category(
        @field:Id
        @field:GeneratedValue
        var id: Long? = null,

        @NotBlank
        var name: String? = null,

        @NotBlank
        var iconUrl: String? = null,

        var visible: Boolean? = null,


        @field:Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "category")
        @field:Nullable
        var productList: List<Product>? = null,

        @DateCreated
        var createDate: LocalDateTime? = null
)

