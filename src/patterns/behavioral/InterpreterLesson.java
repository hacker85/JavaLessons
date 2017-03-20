package patterns.behavioral;

import java.util.Stack;

public class InterpreterLesson {
    public static void main(String[] args) {
        String expression = "1+2+3-4";
        Evaluator sentence = new Evaluator(expression);
        System.out.println(sentence.interpret(sentence));
    }
}
interface Expression {
    int interpret(Expression context);
}

class Number implements Expression {
    int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Expression context) {
        return number;
    }
}

class Plus implements Expression {
    Expression leftOperand;
    Expression rightOperand;

    public Plus(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public int interpret(Expression context) {
        return leftOperand.interpret(context) + rightOperand.interpret(context);
    }
}
class Minus extends Plus {
    public Minus(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int interpret(Expression context) {
        return leftOperand.interpret(context) - rightOperand.interpret(context);
    }
}
class Evaluator implements Expression {
    private Expression syntaxTree;
    Stack<Expression> expressions = new Stack<>();
    public Evaluator(String expression) {
        expression = new StringBuilder(expression).reverse().toString();
        for(String s : expression.split("\\D")) {
            expressions.push(new Number(Integer.parseInt(s)));
        }
        expression = new StringBuilder(expression).reverse().toString();
        for(String s : expression.split("\\d")) {
            if(s.equals("+")) {
                expressions.push(new Plus(expressions.pop(), expressions.pop()));
            } else if(s.equals("-")) {
                expressions.push(new Minus(expressions.pop(), expressions.pop()));
            }
        }
        syntaxTree = expressions.pop();
    }

    @Override
    public int interpret(Expression context) {
        return syntaxTree.interpret(context);
    }
}