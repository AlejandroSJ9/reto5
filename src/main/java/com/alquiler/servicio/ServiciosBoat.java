/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alquiler.servicio;

import com.alquiler.repositorio.RepositorioBoat;
import com.alquiler.modelo.Boat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosBoat {
     @Autowired
    private RepositorioBoat metodosCrud;

    public List<Boat> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Boat> getBoat(int id) {
        return metodosCrud.getBoat(id);
    }

    public Boat save(Boat boat){
        if(boat.getId()==null){
            return metodosCrud.save(boat);
        }else{
            Optional<Boat> e=metodosCrud.getBoat(boat.getId());
            if(e.isEmpty()){
                return metodosCrud.save(boat);
            }else{
                return boat;
            }
        }
    }

    public Boat update(Boat boat){
        if(boat.getId()!=null){
            Optional<Boat> e=metodosCrud.getBoat(boat.getId());
            if(!e.isEmpty()){
                if(boat.getName()!=null){
                    e.get().setName(boat.getName());
                }
                if(boat.getBrand()!=null){
                    e.get().setBrand(boat.getBrand());
                }
                if(boat.getYear()!=null){
                    e.get().setYear(boat.getYear());
                }
                if(boat.getDescription()!=null){
                    e.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory()!=null){
                    e.get().setCategory(boat.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return boat;
            }
        }else{
            return boat;
        }
    }


    public boolean deleteBoat(int id) {
        Boolean aBoolean = getBoat(id).map(boat -> {
            metodosCrud.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
