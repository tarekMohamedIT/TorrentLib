package interfaces;

import models.MagnetData;

import java.util.List;

public interface IMagnetLink {
    void handleMagnetLink(String magnetLink);
    void addData(MagnetData data);
    List<MagnetData> getMagnetData();
}
