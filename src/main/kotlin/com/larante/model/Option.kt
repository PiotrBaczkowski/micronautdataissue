package com.larante.model

import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.*
import io.micronaut.data.jdbc.annotation.JoinTable
import java.math.BigDecimal
import java.time.LocalDateTime

@MappedEntity
@Introspected
data class Option(
        @field:Id
        @field:GeneratedValue
        var id: Long? = null,

        var value: String? = null,

        var price: BigDecimal? = BigDecimal.ZERO,

        var productOptionId: Long? = null,

        @DateCreated
        var createDate: LocalDateTime? = null


)

