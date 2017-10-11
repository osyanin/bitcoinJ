package core.random.keypair;

import core.Base58Check;
import core.TestBase;
import core.random.Generate;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;


public class ECDSA extends TestBase{

    public ECDSA() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
    }

    private static byte[] GenerateSignature(String plaintext, KeyPair keys)
            throws SignatureException, UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException{
        Signature ecdsaSign = Signature.getInstance("SHA256withECDSA", "BC");
        ecdsaSign.initSign(keys.getPrivate());
        ecdsaSign.update(plaintext.getBytes("UTF-8"));
        return ecdsaSign.sign();
    }

    private static boolean ValidateSignature(String plaintext, KeyPair pair, byte[] signature)
            throws
            SignatureException,
            InvalidKeyException,
            UnsupportedEncodingException,
            NoSuchAlgorithmException,
            NoSuchProviderException
    {

        Signature ecdsaVerify = Signature.getInstance("SHA256withECDSA", "BC");
        ecdsaVerify.initVerify(pair.getPublic());
        ecdsaVerify.update(plaintext.getBytes("UTF-8"));
        return ecdsaVerify.verify(signature);
    }

    private static KeyPair GenerateKeys() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException{
//	Other named curves can be found in http://www.bouncycastle.org/wiki/display/JA1/Supported+Curves+%28ECDSA+and+ECGOST%29
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp256k1");

        KeyPairGenerator g = KeyPairGenerator.getInstance("ECDSA", "BC");

        g.initialize(ecSpec, new SecureRandom());

        return g.generateKeyPair();
    }


    public static KeyPair keyPair;

    static {
        try {
            Security.addProvider(new BouncyCastleProvider());
            keyPair = GenerateKeys();
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }

    public static byte[] sign(String plaintext) throws Exception{

        final X509EncodedKeySpec publicKey = new X509EncodedKeySpec(keyPair.getPublic().getEncoded());
        final PKCS8EncodedKeySpec privateKey = new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded());

		logger.info("ECDSA PubKey:  " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        logger.info("ECDSA PrivKey:  " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        byte[] signature = GenerateSignature(plaintext, keyPair);
        boolean isValidated = ValidateSignature(plaintext, keyPair, signature);
        assert isValidated;

        return signature;
    }



    public static String wallet_digest() throws IOException, NoSuchAlgorithmException {
        return Base58Check.encode(Generate.rmd160(Generate.sha256PubKey).getBytes());
    }

}
