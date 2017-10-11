package registration;

import core.TestBase;
import core.random.Generate;
import core.random.keypair.ECDH;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


class FirstTest extends TestBase {

    @Test
    void positive() {

        jsonBody.put("udid", Generate.udid);
        jsonBody.put("wallet_digest", "15ygfPbm2rtyS3FaYAmDhKiZsXXE2ppGgD");
        //jsonBody.put("pub", ECDH.key.pub);

        given()
                .contentType("application/json")
                .header("X-Auth-Timestamp", "")
                .body(jsonBody)
        .when().log().all()
                .post("http://localhost:/"+ "register")
        .then().log().all()
                .statusCode(200)
                .body("status", is("success"))
                .body("data.server_ecdh_public", is(notNullValue()));
    }
}
