package core.magnets;

import enums.MagnetDataType;
import models.MagnetData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MagnetLink {
    private List<MagnetData> magnetData;

    public MagnetLink(String link){
        magnetData = new ArrayList<>();
        link = link.replaceFirst("magnet:\\?", "");

        String[] data = link.split("&");

        for (String param : data){
            String[] seperatedData = param.split("=");

            magnetData.add(new MagnetData(MagnetDataType.valueOf(seperatedData[0].replaceAll(".\\d", "")), seperatedData[1]));
        }
    }

    public List<MagnetData> getMagnetData() {
        return magnetData;
    }
}
