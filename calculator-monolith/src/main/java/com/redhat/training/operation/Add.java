package com.redhat.training.operation;

import java.util.function.BinaryOperator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public final class Add implements Operation {
    private static final String REGEX = "(.+)\\+(.+)";
    private static final BinaryOperator<Float> OPERATOR = (lhs, rhs) -> lhs + rhs;

    @Inject
    EquationSolver addSolver;

    public Add() {
    }

    public Float apply(final String equation) {
        return addSolver.solveGroups(equation, REGEX).stream().reduce(OPERATOR).orElse(null);
    }

}
