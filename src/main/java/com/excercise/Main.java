package com.excercise;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        System.out.println(toRoman(100));
        System.out.println(fromRoman("MCMXC"));
    }
    public static String toRoman (int n){
        if (n < 1 || n > 3999) {
            throw new IllegalArgumentException("insert valid number( between 1 and 3999)");
        }

        /////////// translating to arraylist

        ArrayList<Integer> numberArray=new ArrayList<>();
        while(n!=0){
            int number =n%10;
            n/=10;
            numberArray.add(0,number);//adding to front
        }
//library of numerals
        String roman="";
        String [] singles={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String [] tens={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String [] hundreds={"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String [] thousands={"", "M", "MM", "MMM"};
        int size=numberArray.size();
//appending numerals to string
        if((size)>=4){
            roman+=thousands[numberArray.get(0)];
        }
        if((size)>=3){
            roman+=hundreds[numberArray.get(size-3)];
        }
        if(size>=2){
            roman+=tens[numberArray.get(size-2)];
        }
        roman+=singles[numberArray.get(size-1)];

        return roman;
    }

    public static int fromRoman(String romanNumeral){
        int number=0;
        String romanNum=romanNumeral;

        if(romanNum.contains("CM")){
            number+=900;
            romanNum=romanNum.replace("CM","");
        }
        if(romanNum.contains("CD")){
            number+=400;
            romanNum=romanNum.replace("CD","");
        }
        if(romanNum.contains("XC")){
            number+=90;
            romanNum=romanNum.replace("XC","");
        }
        if(romanNum.contains("XL")){
            number+=40;
            romanNum=romanNum.replace("XL","");
        }
        if(romanNum.contains("IX")){
            number+=9;
            romanNum=romanNum.replace("IX","");
        }
        if(romanNum.contains("IV")){
            number+=4;
            romanNum=romanNum.replace("IV","");
        }
        HashMap<String,Integer> singleDigits=new HashMap<>();
        singleDigits.put("M",1000);
        singleDigits.put("D",500);
        singleDigits.put("C",100);
        singleDigits.put("L",50);
        singleDigits.put("X",10);
        singleDigits.put("V",5);
        singleDigits.put("I",1);

        char [] charArray= romanNum.toCharArray();
        for(int i=0;i<charArray.length;i++){
                number+=singleDigits.get(String.valueOf(charArray[i]));
        }
        return number;
    }
}