package com.redhat.training.registry;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.redhat.training.operation.Add;
import com.redhat.training.operation.Identity;
import com.redhat.training.operation.Multiply;
import com.redhat.training.operation.Operation;
import com.redhat.training.operation.Substract;

@ApplicationScoped
public class OperationsRegistry {

    private List<Operation> operations;

    @Inject
    Add add;

    @Inject
    Substract substract;

    @Inject
    Identity identity;

    @Inject
    Multiply multiply;

    @PostConstruct
    public void buildOperationList() {
        operations = List.of(substract, add, multiply, identity);
    }

    public List<Operation> getOperations() {
        return this.operations;
    }
}
