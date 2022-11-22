package org.acme.client.mtls

import javax.ws.rs.core.MediaType
import org.junit.Ignore

@QuarkusTest
class GreetingResourceIntegrationTest {
    @Ignore("not ready yet") // TODO: handshake failure
    fun testHelloEndpoint() {
        RestAssured.given()
            .`when`().get("/hello")
            .then()
            .statusCode(200)
            .body(CoreMatchers.`is`<String?>("hello from server"))
    }

    companion object {
        private val wireMockServer: WireMockServer? = WireMockServer(
            wireMockConfig()
                .httpsPort(8443)
                .keystorePath(GreetingResourceTest::class.java.classLoader.getResource("ssl/server.keystore").path)
                .keystorePassword("password")
                .needClientAuth(true)
                .trustStorePath(GreetingResourceTest::class.java.classLoader.getResource("ssl/server.truststore").path)
                .trustStorePassword("password")
        )

        @BeforeAll
        fun start() {
            wireMockServer.start()
            stubFor(
                get(urlEqualTo("/hello-client")).willReturn(
                    aResponse().withStatus(200)
                        .withHeader("Content-Type", MediaType.TEXT_PLAIN)
                        .withBody("hello")
                )
            )
        }

        @AfterAll
        fun stop() {
            wireMockServer.stop()
        }
    }
}
