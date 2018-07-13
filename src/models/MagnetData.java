package models;

import enums.MagnetDataType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MagnetData {
    private MagnetDataType dataType;
    private String value;

    public MagnetData(MagnetDataType dataType, String value) {
        this.dataType = dataType;
        setValue(value);
    }

    public MagnetDataType getDataType() {
        return dataType;
    }

    public void setValue(String value) {
        StringBuilder tmpData = new StringBuilder();

        if (getDataType() == MagnetDataType.xt){
            String[] params = value.split(":");

            for (int i = 0;i < params.length; i++){
                if (i == params.length -1){
                    for (int j = 0;j < params[i].length(); j += 3){
                        params[i] = params[i].substring(0, j) + "%" + params[i].substring(j, params[i].length());
                    }
                    tmpData.append(params[i]);
                }
                tmpData.append(params[i]).append(":");
            }
        }

        else if (getDataType() == MagnetDataType.tr){
            String val = value;
            Matcher matcher = Pattern.compile("%[A-Za-z0-9]{2}").matcher(val);

            while (matcher.find()){
                char valueChar = (char) Integer.parseInt(matcher.group().replace("%", ""), 16);
                val = val.replaceFirst(matcher.group(), valueChar + "");
            }

            tmpData.append(val);
        }

        else
            tmpData.append(value);

        this.value = tmpData.toString();
    }

    public String getValue() {
        return value;
    }
}
