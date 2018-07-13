import core.magnets.MagnetLink;
import models.MagnetData;

public class Testing {
    public static void main(String[] args) {
        MagnetLink link = new MagnetLink("magnet:?xt=urn:btih:2647614a1f3698d5d678025c75ce1f79ada2f2e6&dn=Imagine+Dragons+-+Whatever+It+Takes+%5BSingle%5D+2017&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969&tr=udp%3A%2F%2Fzer0day.ch%3A1337&tr=udp%3A%2F%2Fopen.demonii.com%3A1337&tr=udp%3A%2F%2Ftracker.coppersurfer.tk%3A6969&tr=udp%3A%2F%2Fexodus.desync.com%3A6969");
        for (MagnetData data : link.getMagnetData())
            System.out.println(data.getDataType() + " : " + data.getValue());
    }
}
