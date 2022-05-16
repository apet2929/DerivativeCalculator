import java.util.regex.Pattern;

public class DerivativeCalculator {

    public boolean isPowerRuleExpression(String expression){
        return Pattern.matches("\\d*.?\\d*x\\^\\d*.?\\d*", expression);
    }

    public String removeTrailingZeros(String input){
        return input.contains(".") ? input.replaceAll("0*$","").replaceAll("\\.$","") : input;
    }

    public Expression derivePowerRule(Expression expression) {
        if(!isPowerRuleExpression((expression.toString()))) throw new IllegalArgumentException();
        return new Expression(expression.coefficient * expression.exponent, expression.variable, expression.exponent-1);
    }
}
