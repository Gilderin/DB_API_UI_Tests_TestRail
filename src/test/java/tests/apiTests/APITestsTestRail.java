package tests.apiTests;

import org.apache.http.HttpStatus;
import baseEntity.BaseApiTest;
import models.Project;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APITestsTestRail extends BaseApiTest {
    int projectID;


    @Test
    public void addNewProject() {
        String projectName = "";
        String projecttype="";
        String query = "Select * from public.\"project\"" +
                " where id=1";
        ResultSet rs = jdbcService.executeQuery(query);
        try {
            while (rs.next()) {
                projectName = rs.getString("projectName");
                projecttype = rs.getString("projecttype");
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        int index=0;
        switch (projecttype) {
            case "Use a single repository for all cases (recommended)":
                index=1;
                break;
            case "Use a single repository with baseline support":
                index=2;
                break;
            case "Use multiple test suites to manage cases":
                index=3;
                break;
        }
        String endpoint = "/index.php?/api/v2/add_project";
        Project project = new Project.Builder()
                .withName(projectName)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", index);
        projectID=given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Test
    public void getAllProjects() {
        String endpoint = "/index.php?/api/v2/get_projects";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body();

    }

    @Test(dependsOnMethods = "addNewProject")
    public void deleteProject() {
        String endpoint = "index.php?/api/v2/delete_project/{project_id}";

        given()
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectNegative() {
        String projectName = "";
        String projecttype="";
        String query = "Select * from public.\"project\"" +
                " where id=2";
        ResultSet rs = jdbcService.executeQuery(query);
        try {
            while (rs.next()) {
                projectName = rs.getString("projectName");
                projecttype = rs.getString("projecttype");
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        int index=0;
        switch (projecttype) {
            case "Use a single repository for all cases (recommended)":
                index=1;
                break;
            case "Use a single repository with baseline support":
                index=2;
                break;
            case "Use multiple test suites to manage cases":
                index=3;
                break;
        }
        String endpoint = "/index.php?/api/v2/add_project";
        Project project = new Project.Builder()
                .withName(projectName)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", index);
        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
