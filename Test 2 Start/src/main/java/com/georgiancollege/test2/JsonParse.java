package com.georgiancollege.test2;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class JsonParse {
    public static User[] jsonFileParser(String filePath) {

        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();     //Creating a gson instance
            ApiResponse apiResponse = gson.fromJson(reader, ApiResponse.class);     //Using the Gson class to parse the json file into the ApiResponse object
            return apiResponse.getUsers();      //access the array

        } catch (IOException error) {       //error handling
            error.getMessage();
            return null;
        }
    }


}

