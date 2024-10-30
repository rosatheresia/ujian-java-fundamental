package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Tmdb {

    String baseUrl = "https://api.themoviedb.org/3";

    String myToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlOGJkN2VmMTVkOGI3ZjM5M2M5MDkzYTNiZjU2NTYzNCIsIm5iZiI6MTczMDExNzYzOS41NzgyMDcsInN1YiI6IjY3MWUyZmU1NmQ2YjcwNWRjODcxYjU5YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.JOuZqnRpnFGqrWS2og42J3FTnmwt5g-NmiIgFTXiipM";

    @Test
    public void testGetNowPlayingMoviesValid() {
        RestAssured.baseURI = baseUrl;

        // Positive Test Now Playing Movies
        given()
                .queryParam("language","en-US")
                .queryParam("page","1")
                .header("Authorization",myToken)
                .when()
                .get(baseUrl+"/movie/now_playing")
                .then()
                .statusCode(200) // Memastikan status code 200 OK
                .body("results", not(empty())) // Memastikan ada daftar film
                .body("results.title", everyItem(not(emptyString()))) // Memastikan setiap film memiliki title
                .log().all(); // Menampilkan log respons

//        /* Positive Test Now Playing Movies dengan cara Response Json Path*/
//        RequestSpecification request = RestAssured.given();
//        request.queryParam ("Language", "en-US");
//        request.queryParam ("page", "1");
//        request.header ("Authorization", myToken);
//        Response response = request.get ("/movie/now_playing");
//        int statusCode = response. statusCode();
//        int page = response.getBody().jsonPath().getInt("page");
//        String title = response.getBody().jsonPath().getString("results.title[0]");
//        System.out.println(statusCode) ;
//        System.out.println(page);
//        System.out.println(title);
//        Assert.assertEquals(statusCode, 200);
//        Assert.assertEquals(page, 1);
//        Assert.assertEquals(title, "Venom: The Last Dance");
    }

    @Test
    public void testGetNowPlayingMoviesInvalid() {
        RestAssured.baseURI = baseUrl;

        // Negative Test Now Playing Movies
        given()
                .queryParam("language","en-US")
                .queryParam("page","1")
                .header("Authorization",myToken)
                .when()
                .post(baseUrl+"/movie/now_playing") // Menggunakan Endpoint yang salah dari GET ke POST
                .then()
                .statusCode(404) // Memastikan status code 404 Not Found
                .body("status_message", equalTo("The resource you requested could not be found.")) // Memastikan pesan yang sesuai
                .log().all(); // Menampilkan log respons
    }

    @Test
    public void testGetPopularMoviesValid() {
        RestAssured.baseURI = baseUrl;

        // Positive Test Popular Movies
        given()
                .queryParam("language","en-US")
                .queryParam("page","1")
                .header("Authorization",myToken)
                .when()
                .get(baseUrl+"/movie/popular")
                .then()
                .statusCode(200) // Memastikan status code 200 OK
                .body("results", not(empty())) // Memastikan ada daftar film
                .body("results.title", everyItem(not(emptyString()))) // Memastikan setiap film memiliki title
                .log().all(); // Menampilkan log respons

//        /* Positive Test Popular Movies dengan cara Response Json Path*/
//        RequestSpecification request = RestAssured.given();
//        request.queryParam ("Language", "en-US");
//        request.queryParam ("page", "1");
//        request.header ("Authorization", myToken);
//        Response response = request.get ("/movie/popular");
//        int statusCode = response. statusCode();
//        int page = response.getBody().jsonPath().getInt("page");
//        String title = response.getBody().jsonPath().getString("results.title[0]");
//        System.out.println(statusCode) ;
//        System.out.println(page);
//        System.out.println(title);
//        Assert.assertEquals(statusCode, 200);
//        Assert.assertEquals(page, 1);
//        Assert.assertEquals(title, "Venom: The Last Dance");
    }

    @Test
    public void testGetPopularMoviesInvalid() {
        RestAssured.baseURI = baseUrl;

        // Negative Test Popular Movies
        String jsonBody = String.format("{\"value\": 8.0}"); // Memberi nilai pada Endpoint GET akan membuat status code 403 Forbidden

        given()
                .queryParam("language","en-US")
                .queryParam("page","1")
                .header("Authorization",myToken)
                .body(jsonBody)
                .when()
                .get(baseUrl+"/movie/popular")
                .then()
                .statusCode(403) // Memastikan status code 403 Forbidden
                .log().all(); // Menampilkan log respons
    }

    @Test
    public void testPostRatingValid() {
        RestAssured.baseURI = baseUrl;

        // Positive Test Post Rating Movie
        int movieId = 1034541;
        String jsonBody = String.format("{\"value\": 8.5}");

        given()
                .header("Authorization",myToken)
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/movie/"+movieId+"/rating") // Endpoint untuk memberikan rating
                .then()
                .statusCode(201) // Memastikan status code 201 Created
                .body("status_message", equalTo("Success.")) // Memastikan pesan yang sesuai
                .log().all(); // Menampilkan log respons
    }

    @Test
    public void testPostRatingInvalid() {
        RestAssured.baseURI = baseUrl;

        // Negative Test Post Rating Movie
        int movieId = 1034541;
        String jsonBody = String.format("{\"value\": 8.9}");

        given()
                .header("Authorization", myToken)
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/movie/"+movieId+"/rating") // Endpoint untuk memberikan rating
                .then()
                .statusCode(400) // Memastikan status code 400 Bad Request
                .body("status_message", equalTo("Value invalid: Value must be a multiple of 0.50.")) // Memastikan pesan yang sesuai
                .log().all(); // Menampilkan log respons
    }

    @Test
    public void testGetMovieDetailsValid() {
        RestAssured.baseURI = baseUrl;

        // Positive Test Movie Details
        given()
                .header("Authorization", myToken)
                .when()
                .get(baseUrl+"/movie/1184918")
                .then()
                .statusCode(200) // Memastikan status code 200 OK
                .body("title", not(emptyString())) // Memastikan detail film memiliki title
                .body("release_date", not(emptyString())) // Memastikan ada informasi lain seperti release date
                .log().all(); // Menampilkan log respons
    }

    @Test
    public void testGetMovieDetailsInvalid() {
        RestAssured.baseURI = baseUrl;

        // Negative Test Movie Details
        given()
                .queryParam("language","en-US")
                .queryParam("page","1")
                .when()
                .get(baseUrl+"/movie/1184918")
                .then()
                .statusCode(401) // Tidak menggunakan authorization untuk memicu 401 Unauthorized
                .body("status_message", equalTo("Invalid API key: You must be granted a valid key.")) // Memastikan pesan yang sesuai
                .log().all(); // Menampilkan log respons
    }

}