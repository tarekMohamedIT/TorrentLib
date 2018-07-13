package core.magnets;

import enums.MagnetDataType;
import interfaces.IMagnetLink;
import models.MagnetData;

import java.util.ArrayList;
import java.util.List;

public class MagnetLink implements IMagnetLink {
    private List<MagnetData> magnetData;

    public MagnetLink(String link){
        magnetData = new ArrayList<>();
        handleMagnetLink(link);
    }

    @Override
    public void handleMagnetLink(String magnetLink) {
        magnetLink = magnetLink.replaceFirst("magnet:\\?", "");

        String[] data = magnetLink.split("&");

        for (String param : data){
            String[] separatedData = param.split("=");

            addData(new MagnetData(MagnetDataType.valueOf(separatedData[0].replaceAll(".\\d", "")), separatedData[1]));
        }
    }

    @Override
    public void addData(MagnetData data) {
        this.magnetData.add(data);
    }

    @Override
    public List<MagnetData> getMagnetData() {
        return magnetData;
    }
}
