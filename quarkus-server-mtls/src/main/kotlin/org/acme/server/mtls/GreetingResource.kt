package org.acme.server.mtls

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello-server")
class GreetingResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String? {
        return "hello from server"
    }
}
