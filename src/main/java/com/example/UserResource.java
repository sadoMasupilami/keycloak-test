package com.example;

import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.annotations.cache.NoCache;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/users")
public class UserResource {

    @Inject
    SecurityIdentity identity;

    @Inject
    JsonWebToken token;

    @GET
    @Path("/me")
    @RolesAllowed("myrole")
    @NoCache
    @Produces(MediaType.TEXT_PLAIN)
    public String me() {

        return identity.getPrincipal().toString() + "\n\n\n" + token.getRawToken();
    }
}
