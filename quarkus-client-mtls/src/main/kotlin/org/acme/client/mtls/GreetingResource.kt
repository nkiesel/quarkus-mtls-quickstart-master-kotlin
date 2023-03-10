package org.acme.client.mtls

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import org.eclipse.microprofile.rest.client.inject.RestClient

@Path("/hello-client")
class GreetingResource(@RestClient private val greetingService: GreetingService) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        return greetingService.hello()
    }
}
