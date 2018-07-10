import core.magnets.MagnetLink;
import enums.MagnetDataType;
import models.MagnetData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testing {
    public static void main(String[] args) {
        MagnetLink link = new MagnetLink("magnet:?xt=urn:btih:2647614a1f3698d5d678025c75ce1f79ada2f2e6&dn=Imagine+Dragons+-+Whatever+It+Takes+%5BSingle%5D+2017&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969&tr=udp%3A%2F%2Fzer0day.ch%3A1337&tr=udp%3A%2F%2Fopen.demonii.com%3A1337&tr=udp%3A%2F%2Ftracker.coppersurfer.tk%3A6969&tr=udp%3A%2F%2Fexodus.desync.com%3A6969");
        for (MagnetData data : link.getMagnetData()){
            if (data.getDataType() == MagnetDataType.xt){
                String[] params = data.getValue().split(":");


            }

            else if (data.getDataType() == MagnetDataType.tr){
                String val = data.getValue();
                Matcher matcher = Pattern.compile("%[A-Za-z0-9]{2}").matcher(val);

                while (matcher.find()){
                    char valueChar = (char) Integer.parseInt(matcher.group().replace("%", ""), 16);
                    val = val.replaceFirst(matcher.group(), valueChar + "");
                }

                System.out.println(data.getDataType() + " : " + val);
            }

            else
                System.out.println(data.getDataType() + " : " + data.getValue());
        }

    }
}
