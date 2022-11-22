package org.acme.client.mtls

import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@Path("/")
@ApplicationScoped
@RegisterRestClient
interface GreetingService {
    @GET
    @Path("/hello-server")
    @Produces(MediaType.TEXT_PLAIN)
    open fun hello(): String
}
