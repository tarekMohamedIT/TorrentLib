package utils;

public class DataFormatter {
    public static String formatToSha1(String text){
        for (int j = 0;j < text.length(); j += 3){
            text = text.substring(0, j) + "%" + text.substring(j, text.length());
        }
        return text;
    }
}
