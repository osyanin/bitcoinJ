package core;

import core.random.keypair.ECDSA;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.encoders.Hex;

import java.util.Base64;

public class Encode {

    public static String Sha256(String toHash) {
        byte[] firstHash = toHash.getBytes();
        SHA256Digest firstSha = new SHA256Digest(); //256-bits
        firstSha.update(firstHash, 0, firstHash.length);
        byte[] digested1 = new byte[firstSha.getDigestSize()];
        firstSha.doFinal(digested1, 0);

        return new String(Hex.encode(digested1));
    }

    public static String Base64(String bytes) throws Exception {
        return Base64.getEncoder().encodeToString(ECDSA.sign(bytes));
    }


}
