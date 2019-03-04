package com.alex.api.web.controllers;

import static com.alex.api.web.Constants.END_POINT_BASE_ROUTE;
import static com.alex.api.web.Constants.REQUEST_MAPPING_ID;

import com.alex.api.web.Constants;
import com.alex.api.web.model.UserModel;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AdminController.BASE_ROUTE)
public class AdminController {

    public static final String BASE_ROUTE = END_POINT_BASE_ROUTE + "admin";

    @ApiOperation(value = "get user by id", response = String.class)
    @RequestMapping(method = RequestMethod.GET, value = "/user/"+REQUEST_MAPPING_ID)
    @ResponseBody
    public ResponseEntity<UserModel> findUserById(@PathVariable final long id) {
        UserModel user = new UserModel().builder().id(id).build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "add permissions to user", response = String.class)
    @RequestMapping(
            value = "/user/"+REQUEST_MAPPING_ID+"/permissions",
            method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<String> addPermissions(@PathVariable Long id, @RequestBody List<String> permissions) {
        return new ResponseEntity<>(Constants.UPDATED, HttpStatus.OK);
    }

    @ApiOperation(value = "remove permissions from user", response = String.class)
    @RequestMapping(
            value = "/user/"+REQUEST_MAPPING_ID+"/permissions",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<String> removePermissions(@PathVariable Long id, @RequestBody List<String> permissions) {
        return new ResponseEntity<>(Constants.REMOVED, HttpStatus.OK);
    }
}
