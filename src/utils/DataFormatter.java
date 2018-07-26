package utils;

public class DataFormatter {
    public static String formatToSha1(String text){
        for (int j = 0;j < text.length(); j += 3){
            text = text.substring(0, j) + "%" + text.substring(j, text.length());
        }
        return text;
    }

    public static byte[] StringToByteArray(String data){
        return data.getBytes();
    }

    public static String byteToHex(Byte b, String prefix){
        return prefix + Integer.toHexString(b).toUpperCase();
    }

    public static String intToHex(int i, String prefix){
        return prefix + Integer.toHexString(i).toUpperCase();
    }

    public static int[] hexStringToByteArray(String hex, int bytesNumber){
        int[] bytes = new int[bytesNumber];

        hex = hex.replace("0x", "");
        StringBuilder val = new StringBuilder();

        for (int i = hex.length(); i < (bytesNumber * 2); i++){
            val.append("0");
        }

        val.append(hex);

        for( int i = 0, j = 0; i < bytesNumber * 2; i += 2, j++){
            bytes[j] = Integer.parseInt(val.charAt(i) + "" + val.charAt(i + 1), 16);
        }

        return bytes;
    }
}
