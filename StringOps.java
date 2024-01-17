public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println(capVowelsLowRest("Yellow"));
                System.out.println(camelCase(" Intro to coMPUter sCIEncE "));
                System.out.println();

    }

    public static String capVowelsLowRest (String string) {
        String newString = "";
        String capitalVowels = "AEIOU";
        String lowerVowels = "aeiou";

        for (int i = 0; i < string.length();i ++) {
            if (string.charAt(i) != ' ') {
                if ((capitalVowels.indexOf(string.charAt(i)) == -1) && (lowerVowels.indexOf(string.charAt(i)) == -1)) {
                    if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                        newString += (char)(string.charAt(i) + 32);
                    } else {
                        newString += string.charAt(i);
                    }
                } else { if (capitalVowels.indexOf(string.charAt(i)) == -1) {
                            newString += (char)(string.charAt(i) - 32);
                        } else {
                            newString += string.charAt(i);
                         }
                        }
            }
            else {
                newString += ' ';
            }
        }
        return newString;
    }

    public static String camelCase (String string) {
        String newString = "";
        if ((string.charAt(0) >= 'A') && (string.charAt(0) <= 'Z') && string.charAt(0) != ' ') {
            newString += (char)(string.charAt(0) + 32);
        }
        for (int i = 1; i < string.length() - 1; i++) {
            if (string.charAt(i) == ' ') {     // if the the char is space so go to the next char and check if he is lower. if so, change to capital letter.
                if(string.charAt(i + 1) != ' ') {
                    if ((string.charAt(i + 1) >= 'A') && (string.charAt(i + 1) <= 'Z')) {
                        newString += string.charAt(i + 1);
                        i++;
                    } else {
                        newString += (char)(string.charAt(i + 1) - 32);
                        i++;
                    }
                }
            } else {
                if ((string.charAt(i) >= 'A') && (string.charAt(i) <= 'Z')) {
                    newString += (char)(string.charAt(i) + 32);
                } else {
                    newString += string.charAt(i);
                }
            }
        }

        if(string.charAt(string.length() - 2) == ' ' ) { // string.charAt(string.length() -1) == ' ')  {
            if(string.charAt(string.length() -1) != ' ') {
                if ((string.charAt(string.length() - 1) >= 'A') && (string.charAt(string.length() - 1) <= 'Z')) {
                    newString += (char)(string.charAt(string.length() - 1) + 32);
                } else {
                    newString += string.charAt(string.length() - 1);
                }
            }    
        
        } else {
               if ((string.charAt(string.length() - 1) >= 'A') && (string.charAt(string.length() - 1) <= 'Z')) {
                    newString += (char)(string.charAt(string.length() - 1) + 32);
                } else {
                    newString += string.charAt(string.length() - 1);
                }
            }



        return newString;
    }

    public static int[] allIndexOf (String string, char chr) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                count++;
            }
        }
        int [] res = new int [count];
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                res[index++] = i;
            }
        }
        return res;
    }
}
