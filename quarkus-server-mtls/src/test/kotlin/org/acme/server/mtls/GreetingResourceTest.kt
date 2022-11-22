package org.acme.server.mtls

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test

@QuarkusTest
open class GreetingResourceTest {
    @Test
    fun testHelloEndpoint() {
        RestAssured.given()
            .`when`()["/hello-server"]
            .then()
            .statusCode(200)
            .body(CoreMatchers.`is`("hello from server"))
    }
}
