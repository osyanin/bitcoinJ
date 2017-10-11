package core.random.keypair;

import core.holders.KeyHolder;
import core.TestBase;
import org.whispersystems.curve25519.Curve25519KeyPair;

import java.util.Base64;

import static org.whispersystems.curve25519.Curve25519.*;

public class ECDH extends TestBase {

    final private static Curve25519KeyPair keys = getInstance(JAVA).generateKeyPair();


    static final private String pubKey = Base64.getEncoder().encodeToString(keys.getPublicKey());
    static final private String privateKey = Base64.getEncoder().encodeToString(keys.getPrivateKey());

    public static KeyHolder keyPair = new KeyHolder(pubKey, privateKey);

}
