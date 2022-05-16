import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class DerivativeCalculatorTest {
    DerivativeCalculator calculator = new DerivativeCalculator();
    @Test
    public void threeXSquaredShouldMatchPowerRule(){
        Expression threeXSquared = new Expression(3, "x", 2);
        assertTrue(calculator.isPowerRuleExpression(threeXSquared.toString()));
    }

    @Test
    public void threeXSquaredShouldDeriveSixX(){
        Expression threeXSquared = new Expression(3, "x", 2);
        Expression expected = new Expression(6, "x");
        assertEquals(expected, calculator.derivePowerRule(threeXSquared));
    }

    @Test
    public void threeXCubedShouldDeriveNineXSquared(){
        Expression threeXCubed = new Expression(3, "x", 3);
        Expression expected = new Expression(9, "x", 2);
        assertEquals(expected, calculator.derivePowerRule(threeXCubed));
    }

    @Test
    public void invalidExpressionShouldNotDerive(){
        Expression invalid = new Expression(1, "x", 0);
        assertThrows(IllegalArgumentException.class, () -> calculator.derivePowerRule(invalid) );
    }

    @Test
    public void expressionWithNoVariableShouldSimplify(){
        Expression noVar = new Expression(12,"", 3);
        assertEquals(Math.pow(12, 3), noVar.coefficient, 0);
        assertEquals(1, noVar.exponent, 0);
    }

    @Test
    public void expressionWithZeroCoefficientShouldSimplify(){
        Expression zeroCo = new Expression(0, "x", 2);
        assertFalse(zeroCo.hasVariable());
        assertEquals(1, zeroCo.exponent, 0);
    }

    @Test
    public void yee(){
        Expression yee = new Expression(12, "x", 5);
        Expression expected = new Expression(12 * 5, "x", 4);
        assertEquals(expected, calculator.derivePowerRule(yee));
    }
}