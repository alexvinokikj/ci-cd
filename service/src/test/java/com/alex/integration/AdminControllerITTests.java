package com.alex.integration;


import com.alex.BaseTestIT;
import com.alex.api.web.Constants;
import com.alex.api.web.controllers.AdminController;
import com.alex.api.web.model.UserModel;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertEquals;

@Slf4j
public class AdminControllerITTests  extends BaseTestIT {
    private static Long USER_ID = 1l;

    private TestRestTemplate bean = null;

    @Before
    public void init(){
        bean = new TestRestTemplate();
    }

    @Test
    public void getUserByIdSuccessTest() throws Exception {

        //arrange
        UserModel expectedUser =  UserModel.builder().id(USER_ID).build();

        //act
        ResponseEntity<UserModel> responseEntity =
                bean.exchange(getUrl() + "/user/"+expectedUser.getId(), HttpMethod.GET, null, UserModel.class);

        //assert
        assertEquals( HttpStatus.OK,responseEntity.getStatusCode());

        UserModel returnedUser = responseEntity.getBody();
        assertEquals(expectedUser.getId(), returnedUser.getId());
    }

    @Test
    public void addUserPermissionsSuccessTest() throws Exception {

        //arrange
        List<String> permissions = Arrays.asList("admin");

        HttpEntity<List<String>> request = new HttpEntity<>(permissions);
        //act
        ResponseEntity<String> responseEntity =
                bean.exchange(getUrl() + "/user/"+USER_ID+"/permissions", HttpMethod.PUT, request, String.class);

        //assert
        assertEquals( HttpStatus.OK,responseEntity.getStatusCode());

        String message = responseEntity.getBody();
        assertEquals(Constants.UPDATED, message);
    }

    @Test
    public void deleteUserPermissionsSuccessTest() throws Exception {

        //arrange
        List<String> permissions = Arrays.asList("admin");
        TestRestTemplate bean = new TestRestTemplate();

        HttpEntity<List<String>> request = new HttpEntity<>(permissions);
        //act
        ResponseEntity<String> responseEntity =
                bean.exchange(getUrl() + "/user/"+USER_ID+"/permissions", HttpMethod.DELETE, request, String.class);

        //assert
        assertEquals( HttpStatus.OK,responseEntity.getStatusCode());

        String message = responseEntity.getBody();
        assertEquals(Constants.REMOVED, message);
    }


    private String getUrl() {
        return getBaseUrl() + AdminController.BASE_ROUTE;
    }
}
