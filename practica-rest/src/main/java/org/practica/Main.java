package org.practica;

import com.google.gson.Gson;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.rendering.JavalinRenderer;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.practica.model.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       getStudent();
        getAllStudents();
        Student student = new Student();
        student.setMatricula(20170465);
        student.setNombre("Alicia Cruz");
        student.setCarrera("ISC");
        createStudent(student);
        getAllStudents();
        deleteStudent();
        getAllStudents();
    }
    public static List<Student> getAllStudents(){
        HttpResponse<List<Student>> response = Unirest.get("http://localhost:7000/api/estudiante/")
                .asObject(new GenericType<List<Student>>(){});
        System.out.println("Lista de estudiantes:");
        System.out.println(new Gson().toJson(response.getBody()));
        return response.getBody();
    }
    public static Student getStudent(){
        HttpResponse<Student> response = Unirest.get("http://localhost:7000/api/estudiante/{matricula}")
                .header("accept", "application/json")
                .routeParam("matricula", "20011136")
                .asObject(Student.class);
        System.out.println("Estudiante:");
        System.out.println(new Gson().toJson(response.getBody()));
        return response.getBody();
    }

    public static Student createStudent(Student student){
        HttpResponse<Student> response = Unirest.post("http://localhost:7000/api/estudiante/")
                .header("accept", "application/json")
                .body(student)
                .asObject(Student.class);
        System.out.println("Estuudiante creado:");
        System.out.println("Status: "+response.getStatus());
        System.out.println(new Gson().toJson(response.getBody()));
        return response.getBody();
    }
    public static void deleteStudent(){
        HttpResponse<String> response = Unirest.delete("http://localhost:7000/api/estudiante/{matricula}")
                .routeParam("matricula", "20170465")
                .asString();
        System.out.println("Eliminar estudiante:");
        System.out.println("Status: "+ response.getStatus());

    }

}
