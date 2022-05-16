public class Utils {

    public static String removeTrailingZeros(String input){
        return input.contains(".") ? input.replaceAll("0*$","").replaceAll("\\.$","") : input;
    }

    public static String removeTrailingZeros(double input){
        if(input % 1 == 0){
            return Integer.toString((int)input);
        }
        return Double.toString(input);
    }

}
