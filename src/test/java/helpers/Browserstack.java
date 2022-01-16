package helpers;

import config.MobConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoUrl(String sessionId) {

        MobConfig mobConfig = ConfigFactory.create(MobConfig.class);

        String username = mobConfig.username();
        String password = mobConfig.password();
        String videoUrl = mobConfig.videoUrl();

        return given()
                .auth().basic(username, password)
                .when()
                .get(videoUrl + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}
