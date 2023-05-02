/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import org.json.JSONObject;

/**
 *
 * @author Patryk
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Status: " + getComplaintStatus("2"));
        System.out.println("All complaints: " + getAllComplaints());
        System.out.println("Complaint: " + getComplaint("2"));
        changeStatus("2", "closed");
        System.out.println("Complaint: " + getComplaint("2"));
    }
    
    public static String getComplaintStatus(String id) {
        try (Client client = ClientBuilder.newClient()){
            String status = 
            client.target("http://localhost:8080/Complaints/" + 
                          "resources/complaints/" + id + "/status") 
            .request(MediaType.TEXT_PLAIN) 
            .get(String.class);
            return status;
        }
    }
    
    public static String getAllComplaints() {
        try (Client client = ClientBuilder.newClient()){
            String status = 
            client.target("http://localhost:8080/Complaints/" + 
                          "resources/complaints") 
            .request(MediaType.APPLICATION_JSON) 
            .get(String.class);
            return status;
        }
    }
    
    public static String getComplaint(String id) {
        try (Client client = ClientBuilder.newClient()){
            String status = 
            client.target("http://localhost:8080/Complaints/" + 
                          "resources/complaints/" + id) 
            .request(MediaType.APPLICATION_JSON) 
            .get(String.class);
            return status;
        }
    }
    
    public static void changeStatus(String id, String status) {
        try (Client client = ClientBuilder.newClient()){
            String complain = 
            client.target("http://localhost:8080/Complaints/" + 
                          "resources/complaints/" + id) 
            .request(MediaType.APPLICATION_JSON_TYPE) 
            .get(String.class);
            
            JSONObject tempJson = new JSONObject(complain);
            tempJson.put("status", status);
            
            client.target("http://localhost:8080/Complaints/" + 
                          "resources/complaints/" + id) 
            .request(MediaType.APPLICATION_JSON_TYPE) 
            .put(Entity.json(tempJson.toString()), String.class);
        }
    }
}
