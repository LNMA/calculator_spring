package com.louay.projects.factory;

import com.louay.projects.operation.*;
import com.louay.projects.operation.impl.*;
import org.springframework.context.annotation.Bean;

public class BeanFactory {

    @Bean
    public Addition getAddition(){
        return new AdditionImpl();
    }

    @Bean
    public Subtraction getSubtraction(){
        return new SubtractionImpl();
    }

    @Bean
    public Multiplication getMultiplication(){
        return new MultiplicationImpl();
    }

    @Bean
    public Division getDivision(){
        return new DivisionImpl();
    }

    @Bean
    public Power getPower(){
        return new PowerImpl();
    }

    @Bean
    public Modulo getModulo(){
        return new ModuloImpl();
    }

    @Bean
    public OperationNumbers getOperationNumbers(){
        return new OperationNumbers();
    }


}
