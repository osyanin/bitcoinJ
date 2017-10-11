package core.random;

import com.fasterxml.uuid.Generators;
import core.Base58Check;
import core.Encode;
import core.Rmd160;
import core.TestBase;
import core.random.keypair.ECDH;
import core.random.keypair.ECDSA;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Generate extends TestBase {

    private static String udid() {
        return Generators.randomBasedGenerator().generate().toString();
    }

    private static String unixtime() {
        Date now = new Date();
        Long timestamp = now.getTime() / 1000;
        return String.valueOf(timestamp);
    }

    final public static String sha256PubKey = Encode.Sha256(ECDSA.keyPair.getPublic().toString());

    public static String rmd160(String toHash) throws IOException {
        return Rmd160.once(toHash);
    }

    public static String wallet_digest() throws IOException, NoSuchAlgorithmException {
        return Base58Check.encode(rmd160(sha256PubKey).getBytes());
    }
    //final static public String wallet_digest = wallet_digest();

    final static public String udid = udid();
    final static public String unixtime = unixtime();

    static public String message;

    static {
        try {
            try {
                message = "POST" +
                        "/register" +
                        "{'udid':'" + Generate.udid + "'," +
                        "'ecdh_pub':'" + ECDH.keyPair.pub + "'," +
                        "'wallet_digest':'" + wallet_digest() + "'}" +
                        Generate.unixtime;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final static public String hashedMessage = Encode.Sha256(Encode.Sha256(message));
}
