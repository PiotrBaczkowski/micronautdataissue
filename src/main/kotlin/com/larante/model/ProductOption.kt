package com.larante.model

import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.*
import io.micronaut.data.jdbc.annotation.JoinTable
import io.micronaut.data.model.DataType
import java.math.BigDecimal
import java.time.LocalDateTime

@MappedEntity
@Introspected
data class ProductOption(
        @field:Id
        @field:GeneratedValue
        var id: Long? = null,

        var name:String? = null,
        var productId: Long? = null,
        var required: Boolean = true,
        var multiple: Boolean = true,

        @field:Relation(Relation.Kind.ONE_TO_MANY, mappedBy = "productOptionId")
        var option: List<Option>? = null,

        @DateCreated
        var createDate: LocalDateTime? = null


)

