package com.redhat.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.redhat.training.service.SolverService;

public class MultiplierResourceTest {
    
    @RestClient
    @Inject
    SolverService solverService;
    MultiplierResource multiplierResource;

    @BeforeEach
    public void setup() {
        solverService = mock(SolverService.class);
        multiplierResource = new MultiplierResource(solverService);
    }

    @Test 
    public void simpleMultiplicationofTwoPositiveValuesTest() {

        when(solverService.solve("4")).thenReturn(4.0f);
        when(solverService.solve("20")).thenReturn(20.0f);
        
        Float result = multiplierResource.multiply("4", "20");
        
        assertEquals(80.0f, result);
    }
    
    @Test 
    public void simpleMultiplicationofNegativeAndPositiveValuesTest() {

        when(solverService.solve("-4")).thenReturn(-4.0f);
        when(solverService.solve("20")).thenReturn(20.0f);
        
        Float result = multiplierResource.multiply("-4", "20");
        
        assertEquals(-80.0f, result);
    }
    
    @Test 
    public void simpleMultiplicationofInvalidValuesThrowsErrorTest() {

        when(solverService.solve("a")).thenThrow(new NumberFormatException("Invalid Number"));
        when(solverService.solve("20")).thenReturn(20.0f);
        
        Executable multiplication = () -> multiplierResource.multiply("a", "20");
        
        assertThrows(NumberFormatException.class, multiplication);
    }
}
