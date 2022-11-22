package org.acme.client.mtls

import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.junit.mockito.InjectMock
import io.restassured.RestAssured
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test
import org.mockito.Mockito

@QuarkusTest
open class GreetingResourceTest {
    @InjectMock
    @RestClient
    var greetingService: GreetingService? = null
    @Test
    fun testHelloEndpoint() {
        Mockito.`when`(greetingService.hello()).thenReturn("hello from server")
        RestAssured.given()
            .`when`()["/hello-client"]
            .then()
            .statusCode(200)
            .body(CoreMatchers.`is`("hello from server"))
    }
}
