package models;

import enums.MagnetDataType;

public class MagnetData {
    MagnetDataType dataType;
    String value;

    public MagnetData(MagnetDataType dataType, String value) {
        this.dataType = dataType;
        this.value = value;
    }

    public MagnetDataType getDataType() {
        return dataType;
    }

    public String getValue() {
        return value;
    }
}
