/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alquiler.interfaceCrud;

import com.alquiler.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */
public interface InterfaceCliente extends CrudRepository<Cliente,Integer> {
    
}
