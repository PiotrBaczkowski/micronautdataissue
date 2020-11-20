package com.larante

import com.larante.model.*
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.context.ApplicationContext
import io.micronaut.core.type.Argument
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.http.client.RxHttpClient
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class OneToManyTest(ctx: ApplicationContext) : StringSpec({

    val embeddedServer: EmbeddedServer = ctx.getBean(EmbeddedServer::class.java)
    val client: RxHttpClient = embeddedServer.applicationContext.createBean(RxHttpClient::class.java, embeddedServer.url)

    "correct mapping for 2 categories 3 product each " {
        val responseCategoryGet = client!!.toBlocking()
            .retrieve(HttpRequest.GET<List<Category>>("/categories/"), Argument.listOf(Category::class.java));
        responseCategoryGet.size shouldBe 2;
        responseCategoryGet[0].productList!!.size shouldBe 3;
        responseCategoryGet[1].productList!!.size shouldBe 3;
    }
})
