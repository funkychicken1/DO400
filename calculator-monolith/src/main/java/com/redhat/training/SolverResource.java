package com.redhat.training;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.training.operation.Operation;
import com.redhat.training.registry.OperationsRegistry;
import com.redhat.training.service.SolverService;

public final class SolverResource implements SolverService {
    private static final Logger LOG = LoggerFactory.getLogger(SolverResource.class);

    @Inject
    OperationsRegistry operations;

    @Override
    public Float solve(@PathParam("equation") final String equation) {
        LOG.info("Solving '{}'", equation);
        for (Operation operation : operations.getOperations()) {
            Float result = operation.apply(equation);
            if (result != null) {
                LOG.info("Solved '{} = {}'", equation, result);
                return result;
            }
        }

        throw new WebApplicationException(
                Response.status(Response.Status.BAD_REQUEST).entity("Unable to parse: " + equation).build());
    }

}
