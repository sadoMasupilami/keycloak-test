package com.example;

import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/admin")
public class AdminResource {

    @Inject
    SecurityIdentity identity;

    @GET
    @RolesAllowed("myadminrole")
    @Produces(MediaType.TEXT_PLAIN)
    public String admin() {
        return "admin access granted for " + identity.getPrincipal().getName();
    }
}
