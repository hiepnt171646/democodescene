/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.Scanner;

/**
 *
 * @author lanvy
 */
public class Inputter {

    public static Scanner sc = new Scanner(System.in);

    public static String Normalize(String s) {
        String[] tokens = s.split("\\s+");
        String result = "";
        for (String token : tokens) {
            result += token + " ";
        }
        return result.trim();
    }

    public static String getNonBlank(String msg) {
        String result;
        do {
            System.out.print(msg);
            result = Normalize(sc.nextLine());
        } while (result.length() == 0);
        return result;
    }

    public static String getRegex(String msg, String regex) {
        String result;
        do {
            System.out.print(msg);
            result = Normalize(sc.nextLine());
        } while (!result.matches(regex));
        return result;
    }

    public static String checkEmpty(String msg) {
        String result;
        System.out.print(msg);
        result = Normalize(sc.nextLine());
        return result;
    }

    public static int getInt(String msg) {
        int result = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                if (result <= 0) {
                    throw new Exception();
                }
                break;
            } catch (NumberFormatException e) {
                check = false;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    
    public static String getString(String msg) {
        return getString(msg, 0, null);
    }
    public static double getdouble(String msg) {
        double result;
        do {
            System.out.print(msg);
            result = Double.parseDouble(sc.nextLine());
        } while (result < 0);
        return result;
    }
    public static double getDouble(String msg) {
        double result = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.print(msg);
               sc = new Scanner(System.in);
                result = Double.parseDouble(sc.nextLine());
                if (result <= (double)0) {
                    throw new Exception();
                }
                break;
            } catch (NumberFormatException e) {
                check = false;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    public static int getInt(String msg, int minRange, int maxRange) {
        if (minRange > maxRange) {
            int temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        int value = Integer.MIN_VALUE;

        while (true) {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }

                value = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
            }

            if (value >= minRange && value <= maxRange) {
                break;
            }
        }

        return value;
    }
    public static String getStringN(String msg, int minNumChars) {
        return getString(msg, minNumChars, null);
    }
     public static double getDouble(String msg, double minRange, double maxRange) {
        if (minRange > maxRange) {
            double temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        double value = Double.MIN_VALUE;

        while (true) {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }

                value = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
            }

            if (value >= minRange && value <= maxRange) {
                break;
            }
        }

        return value;
    }


  public static String getString(String msg, int minNumChars, String forbiddenChars, String... comparedValues) {
        String tempValue = "";

        boolean isPassed = false;

        while (!isPassed) {
            if (msg != null) {
                System.out.print(msg);
            }

            tempValue = sc.nextLine();

            if (tempValue.length() >= minNumChars) {
                if (forbiddenChars != null) {
                    if (tempValue.contains(forbiddenChars)) {
                        continue;
                    }
                }

                if (comparedValues.length == 0) {
                    isPassed = true;
                } else {
                    for (String comparedValue : comparedValues) {
                        if (tempValue.equals(comparedValue)) {
                            isPassed = true;
                        }
                    }
                }
            }
        }

        return tempValue;
    }


}