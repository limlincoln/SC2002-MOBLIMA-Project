package utils;

import java.text.DecimalFormat;

public class ConvertDouble {
    public static String convert(Double val) {
      DecimalFormat df = new DecimalFormat(".##");
      if(val == 0){
        return "NA";
      }else{
        return df.format(val);
      }
    }  
  }