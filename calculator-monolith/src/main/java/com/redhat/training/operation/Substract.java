package com.redhat.training.operation;

import java.util.function.BinaryOperator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
@ApplicationScoped
public final class Substract implements Operation {

    private static final String REGEX = "(.+)\\-(.+)";
    private static final BinaryOperator<Float> OPERATOR = (lhs, rhs) -> lhs - rhs;

    @Inject
    EquationSolver subtractSolver;

    public Substract() {
    }

    public Float apply(final String equation) {
        return subtractSolver.solveGroups(equation, REGEX).stream().reduce(OPERATOR).orElse(null);
    }

}
