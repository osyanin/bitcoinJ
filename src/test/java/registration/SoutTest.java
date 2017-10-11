package registration;

import core.TestBase;
import core.random.Generate;
import core.random.keypair.ECDH;
import core.random.keypair.ECDSA;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SoutTest extends TestBase{

    @Test
    void firstSoutTest() throws Exception {

        logger.info("First Test");
        logger.info("ECDH Public Key:  " + ECDH.keyPair.pub);
        logger.info("ECDH Private Key:  " + ECDH.keyPair.priv);
    }

    @Test
    void secondSoutTest() throws Exception {
        logger.info("");
        logger.info("");
        logger.info("");

        logger.info("Second Test");
        logger.info("ECDH Public Key:  " + ECDH.keyPair.pub);
        logger.info("ECDH Private Key:  " + ECDH.keyPair.priv);
        logger.info(Generate.udid);

        logger.info("");
        logger.info("");
        logger.info("");

        logger.info("Third Test");
        logger.info("ECDH Public Key:  " + ECDH.keyPair.pub);
        logger.info("ECDH Private Key:  " + ECDH.keyPair.priv);
        logger.info(Generate.udid);


    }

    @Test
    void thirdSoutTest() throws Exception {
        logger.info(Generate.message);
        logger.info(Generate.hashedMessage);

        logger.info("Wallet digest:  " + Generate.wallet_digest());

        logger.info(Generate.udid);
        logger.info(Generate.unixtime);
        logger.info(ECDH.keyPair.pub);
        logger.info(ECDH.keyPair.priv);
        logger.info(ECDSA.keyPair.getPublic());
        logger.info(ECDSA.keyPair.getPrivate());
        logger.info(ECDSA.sign(""));
    }
}
