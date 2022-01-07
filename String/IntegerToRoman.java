class IntegerToRoman {
    public String intToRoman(int num) {
        int digit;
        int count = 0;
        String result = "";
        while (num != 0) {
            digit = num % 10;
            num = num / 10;
            digit = (int) (digit * Math.pow(10, count));
            count++;
            result = valueOfInt(digit) + result;
            
        }
        return result;
    }
    
    private String valueOfInt(int num) {
        String result = "";
        if (num < 10) {
            if (num < 4) {
                int i = 0;
                while (i < num) {
                    result += "I";
                    i++;
                }
            } else if (num == 4) {
                result += "IV";
            } else if (num < 9) {
                result += "V";
                if (num > 5) {
                    int i = 6;
                    while (i <= num) {
                        result += "I";
                        i++;
                    }
                }
            } else {
                result += "IX";
            }
        } else if (num >= 10 && num < 100) {
            if (num < 40) {
                for (int i = 10; i <= num; i += 10) {
                    result += "X";
                }
            } else if (num == 40) {
                result += "XL";
            } else if (num < 90) {
                result += "L";
                for (int i = 60; i <= num; i += 10) {
                    result += "X";
                }
            } else {
                result += "XC";
            }
        } else if (num < 1000) {
            if (num < 400) {
                for (int i = 0; i < num; i += 100) {
                    result += "C";
                }
            } else if (num == 400) {
                result += "CD";
            } else if (num < 900) {
                result += "D";
                for (int i = 600; i <= num; i += 100) {
                    result += "C";
                }
            } else {
                result += "CM";
            }
        } else {
            for (int i = 1000; i <= num; i += 1000) {
                result += "M";
            }
        }
       return result; 
    }
}
