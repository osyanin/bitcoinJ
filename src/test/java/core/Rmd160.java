package core;

import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.util.encoders.Hex;

import java.io.IOException;

public class Rmd160 extends TestBase{
    public static String once(String toEncode) throws IOException {

        byte[] r = toEncode.getBytes("US-ASCII");
        RIPEMD160Digest d = new RIPEMD160Digest();
        d.update (r, 0, r.length);
        byte[] o = new byte[d.getDigestSize()];
        d.doFinal (o, 0);

        return String.valueOf(Hex.encode(o, System.out));
    }


}
