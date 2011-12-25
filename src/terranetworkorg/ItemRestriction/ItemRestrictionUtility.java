package terranetworkorg.ItemRestriction;

import java.io.*;

public class ItemRestrictionUtility {
    public static ItemRestriction plugin;

    public ItemRestrictionUtility(ItemRestriction instance) {
        plugin = instance;
    }

    public void copy(InputStream inputThis, File sFile) throws IOException{
        InputStream in = inputThis;
        OutputStream out = new FileOutputStream(sFile);
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        out.close();
        in.close();
    }
}
