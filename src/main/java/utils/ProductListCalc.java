package utils;

import static java.lang.Integer.parseInt;

public class ProductListCalc {

    public static boolean checkPrice(String product, int max_price){
        if(convertToInt(product) > max_price)
            return true;
        else
            return false;
    }

    static int convertToInt(String data){
        return parseInt(data);
    }
}
