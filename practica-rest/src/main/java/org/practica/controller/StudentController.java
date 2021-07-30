package org.practica.controller;


import com.google.gson.Gson;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.practica.model.Student;

import java.util.List;

public class StudentController {

    public List<Student> getAllStudents(){
        HttpResponse<List<Student>> response = Unirest.get("http://localhost:7000/api/estudiante/")
                .asObject(new GenericType<List<Student>>(){});

        return response.getBody();
    }
    public Student getStudent(){
        HttpResponse<Student> response = Unirest.get("http://localhost:7000/api/estudiante/{matricula}")
                .header("accept", "application/json")
                .routeParam("matricula", "20178955")
                .asObject(Student.class);
        System.out.println(new Gson().toJson(response.getBody()));
        return response.getBody();
    }

    public Student createStudent(){
        HttpResponse<Student> response = Unirest.post("http://localhost:7000/api/estudiante/")
                .header("accept", "application/json")
                .asObject(Student.class);
        System.out.println(response.getStatus());
        System.out.println(new Gson().toJson(response.getBody()));
        return response.getBody();
    }
    public void deleteStudent(){
        HttpResponse<String> response = Unirest.delete("http://localhost:7000/api/estudiante/{matricula}")
                .routeParam("matricula", "20178955")
                .asString();
        System.out.println("Status: "+ response.getStatus());

    }
}
