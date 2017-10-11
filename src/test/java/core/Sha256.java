/*
package core;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

public class Sha256 {

    public static String twice(String toHash) {
        Security.addProvider(new BouncyCastleProvider());

        byte[] firstHash = toHash.getBytes();
        SHA256Digest firstSha = new SHA256Digest(); //256-bits
        firstSha.update(firstHash, 0, firstHash.length);
        byte[] digested1 = new byte[firstSha.getDigestSize()];
        firstSha.doFinal(digested1, 0);


        byte[] secondHash = Hex.encode(digested1);
        SHA256Digest secondSha = new SHA256Digest(); //256-bits
        secondSha.update(secondHash, 0, secondHash.length);
        byte[] digested2 = new byte[secondSha.getDigestSize()];
        firstSha.doFinal(digested2, 0);

        return new String(Hex.encode(digested2));
    }

    public static String once(String toHash) {
        byte[] firstHash = toHash.getBytes();
        SHA256Digest firstSha = new SHA256Digest(); //256-bits
        firstSha.update(firstHash, 0, firstHash.length);
        byte[] digested1 = new byte[firstSha.getDigestSize()];
        firstSha.doFinal(digested1, 0);

        return new String(Hex.encode(digested1));
    }
}
*/
