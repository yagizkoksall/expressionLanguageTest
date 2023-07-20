package com.example.expressionlanguagetest.business;

import com.example.expressionlanguagetest.dto.TestDto;
import com.example.expressionlanguagetest.entity.TestEntity;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    ExpressionParser parser = new SpelExpressionParser();


    @Override
    public boolean testRelationalOperator(TestDto testDto) {
        TestEntity testEntity = new TestEntity();
        testEntity.setName(testDto.getName());
        testEntity.setLastName(testDto.getLastName());

        StandardEvaluationContext context = new StandardEvaluationContext(testEntity);
        context.setVariable("queryName", testDto.getName());
        context.setVariable("queryLastName", testDto.getLastName());

        String expression = "isMember(#queryName) and isMember(#queryLastName)";

        //   String expression = "isMember(#queryName)";

        /*
        Expression exp =  parser.parseExpression(expression);
        EvaluationContext context = new StandardEvaluationContext(societyContext);

        boolean denenecekString = (Boolean) exp.getValue(context);

         */
        return parser.parseExpression(expression).getValue(context, Boolean.class);
    }

    @Override
    public boolean testRelationalOperatorButList(TestDto testDto) {
        TestEntity testEntity = new TestEntity();

        StandardEvaluationContext context = new StandardEvaluationContext(testEntity);
        context.setVariable("queryName",testDto.getList());


        String expression = "isMemberButList(#queryName)";


        return parser.parseExpression(expression).getValue(context,Boolean.class);
    }


}
