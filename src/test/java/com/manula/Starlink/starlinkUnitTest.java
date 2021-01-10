package com.manula.Starlink;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.Random;

public class starlinkUnitTest {
    Random rand = new Random();
    int upperbound = 500;
    int random_num = rand.nextInt(upperbound);
    String random_number = String.valueOf(random_num);
    String satID = "TESTsat"+random_number;


    @Test (priority=1)
    public void validateInsertSatellite(){
//        given().when().post("http://localhost:80/addsatellite").then().statusCode(200);
//
//        with().body(new Satellite(satID, "TEST Constellation", "TEST Orbit", "TEST Health"))
//                .when()
//                .request("POST", "http://localhost:80/Satellites")
//                .then()
//                .statusCode(200);

        RestAssured.baseURI = "http://localhost:3000";
        given().urlEncodingEnabled(false)
                .body(new Satellite(satID, "TEST Constellation", "TEST Orbit", "TEST Health"))
                .contentType(ContentType.JSON)
                .post("/addsatellite")
                .then()
                .statusCode(200);

        RestAssured.baseURI = "http://localhost:3000";
        given().urlEncodingEnabled(false)
                .body(new Satellite("sat0001", "Canis", "Alpha01", "Green"))
                .contentType(ContentType.JSON)
                .post("/addsatellite")
                .then()
                .statusCode(200);
        RestAssured.baseURI = "http://localhost:3000";
        given().urlEncodingEnabled(false)
                .body(new Satellite("sat0002", "Orion", "Alpha02", "Yellow"))
                .contentType(ContentType.JSON)
                .post("/addsatellite")
                .then()
                .statusCode(200);
        RestAssured.baseURI = "http://localhost:3000";
        given().urlEncodingEnabled(false)
                .body(new Satellite("sat0003", "Canis Major", "Alpha01", "Green"))
                .contentType(ContentType.JSON)
                .post("/addsatellite")
                .then()
                .statusCode(200);
        RestAssured.baseURI = "http://localhost:3000";
        given().urlEncodingEnabled(false)
                .body(new Satellite("sat0004", "Canis", "Omega1", "Red"))
                .contentType(ContentType.JSON)
                .post("/addsatellite")
                .then()
                .statusCode(200);
        RestAssured.baseURI = "http://localhost:3000";
        given().urlEncodingEnabled(false)
                .body(new Satellite("sat0005", "Pisces", "Omega1", "Green"))
                .contentType(ContentType.JSON)
                .post("/addsatellite")
                .then()
                .statusCode(200);
        RestAssured.baseURI = "http://localhost:3000";
        given().urlEncodingEnabled(false)
                .body(new Satellite("sat0006", "Orion", "Omega2", "Yellow"))
                .contentType(ContentType.JSON)
                .post("/addsatellite")
                .then()
                .statusCode(200);
    }

    @Test (priority=2)
    public void validateUpdateSatellite(){
        //given().when().post("http://localhost:80/addsatellite").then().statusCode(200);

        with().body(new Satellite(satID, "TEST UPDATE Constellation", "TEST UPDATE Orbit", "TEST UPDATE Health"))
                .when()
                .contentType(ContentType.JSON)
                .request("PUT", "http://localhost:3000/updatesatellite/"+satID)
                .then()
                .statusCode(200);
    }

    @Test(priority=3)
    public void validateSelectAll(){
        given().when().get("http://localhost:3000/satellite").then().statusCode(200);
    }

    @Test (priority=4)
    public void validateDeleteSatellite(){
        given().when().delete("http://localhost:3000/deletesatellite/"+satID).then().statusCode(200);
    }





}
