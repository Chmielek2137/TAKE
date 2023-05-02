/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Patryk
 */
@ApplicationScoped
public class ModelMapperProducer {
    @Produces
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
