public class Expression {
    double coefficient;
    String variable;
    double exponent;

    public Expression(double coefficient, String variable, double exponent) {
        this.coefficient = coefficient;
        this.variable = variable;
        this.exponent = exponent;

        if(coefficient == 0){
            this.variable = "";
            this.exponent = 1.0d;
        }

        if(!hasVariable()){
            this.coefficient = Math.pow(coefficient, exponent);
            this.exponent = 1;
        }

        if(exponent == 0){
            this.variable = "";
            this.exponent = 1;
        }
    }
    public Expression(double coefficient, String variable) {
        this(coefficient, variable, 1);
    }
    public Expression(String variable, double exponent) {
        this(1, variable, exponent);
    }
    public Expression(double coefficient){
        this(coefficient, "", 1);
    }

    public void setCoefficient(double coefficient){
        this.coefficient = coefficient;
        if(coefficient == 0){
            variable = "";
            exponent = 1.0d;
        }
    }

    public void setExponent(double exponent){
        if(!hasVariable()){
            coefficient = Math.pow(coefficient, exponent);
            this.exponent = 1;
        }
        if(exponent == 0){
            variable = "";
            this.exponent = 1;
        }
    }

    public boolean hasVariable(){
        return !variable.equals("");
    }

    @Override
    public String toString() {
        String co = Utils.removeTrailingZeros(coefficient);
        if(hasVariable()){
            if(exponent == 1) return co + "x";
            String ex = Utils.removeTrailingZeros(exponent);
            return co + "x^" + ex;
        }
        return co;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(Expression.class)) {
            Expression object = (Expression) obj;
            return coefficient == object.coefficient && variable.equals(object.variable) && exponent == object.exponent;
        }
        System.err.println("Tried to compare Expression with object of type:" + obj.getClass().getName());
        return false;
    }
}
