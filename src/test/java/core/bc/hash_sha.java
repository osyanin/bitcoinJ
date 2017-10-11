package core.bc;

import java.security.Security;

import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.ShortenedDigest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.crypto.digests.GOST3411Digest;

public class hash_sha {

    public static String hash_sha(String forHash) {
        Security.addProvider(new BouncyCastleProvider());

        byte[] trial = forHash.getBytes();

        // TODO Auto-generated method stub

        //GOST3411Digest examplesha = new GOST3411Digest(); //256-bits
        //SHA1Digest examplesha = new SHA1Digest();
        SHA256Digest examplesha = new SHA256Digest(); //256-bits
        //SHA384Digest examplesha = new SHA384Digest(); //384-bits
        //SHA512Digest examplesha = new SHA512Digest(); //512-bits
        //SHA3Digest examplesha = new SHA3Digest();

        examplesha.update(trial, 0, trial.length);

        byte[] digested = new byte[examplesha.getDigestSize()];
        examplesha.doFinal(digested, 0);

        System.out.println("Input (hex): " + new String(Hex.encode(trial)));
        System.out.println("Output (hex): " + new String(Hex.encode(digested)));
        return new String(Hex.encode(digested));
    }

    public static String hashed(String forHash) {
        Security.addProvider(new BouncyCastleProvider());

        byte[] trial = forHash.getBytes();

        //GOST3411Digest examplesha = new GOST3411Digest(); //256-bits
        //SHA1Digest examplesha = new SHA1Digest();
        SHA256Digest examplesha = new SHA256Digest(); //256-bits
        //SHA384Digest examplesha = new SHA384Digest(); //384-bits
        //SHA512Digest examplesha = new SHA512Digest(); //512-bits
        //SHA3Digest examplesha = new SHA3Digest();

        examplesha.update(trial, 0, trial.length);

        byte[] digested = new byte[examplesha.getDigestSize()];
        examplesha.doFinal(digested, 0);
        return new String(Hex.encode(digested));
    }

    /*public static String doubleHash(String toHash) {
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

    }*/




}
