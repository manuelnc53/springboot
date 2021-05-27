package com.example.demo.controllers;

import com.example.demo.models.EstadoModel;
import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuariosModel;
import com.example.demo.services.UsuariosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UsuariosService usuarioService;

    @GetMapping()
    public Map<String, Object> obtenerUsuarios(){
        HashMap<String, Object> map = new HashMap<>();
        try{
            map.put("data", usuarioService.obtenerUsuarios());
            map.put("status",200);
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }

    @PostMapping()
    public Map<String, Object> guardarUsuario(@RequestBody UsuariosModel usuario){
        HashMap<String, Object> map = new HashMap<>();
        try{
            usuario.setEstado(EstadoModel.ACTIVO);
            this.usuarioService.guardarUsuario(usuario);
            map.put("status",200);
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
    
    
    @PutMapping()
    public Map<String, Object> editarUsuario(@RequestBody UsuariosModel usuario){
        HashMap<String, Object> map = new HashMap<>();
        try{
            usuario.setEstado(EstadoModel.ACTIVO);
            this.usuarioService.guardarUsuario(usuario);
            map.put("status",200);
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
    
    @GetMapping( path = "/{id}")
    public Map<String, Object> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        HashMap<String, Object> map = new HashMap<>();
        try{
            Optional<UsuariosModel> usuario =this.usuarioService.obtenerPorId(id);
            if(usuario.isPresent()){
                map.put("data", usuario.get());
                map.put("status",200);
            }else{
                map.put("status",400);
                map.put("error", "No existe ese usuario");
            }
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
    @GetMapping( path = "/{id}/saldo")
    public Map<String, Object> obtenerSaldo(@PathVariable("id") Long id) {
        
        HashMap<String, Object> map = new HashMap<>();
        try{
            Optional<UsuariosModel> usuario =this.usuarioService.obtenerPorId(id);
            if(usuario.isPresent()){
                HashMap saldo = new HashMap<String, Object>();
                saldo.put("saldo", this.usuarioService.obtenerSaldo(id));
                map.put("data", saldo);
                map.put("status",200);
            }else{
                map.put("status",400);
                map.put("error", "No existe ese usuario");
            }
            
        }catch(Exception e){
            map.put("data", new ObjectMapper());
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
    
    
    
    @DeleteMapping( path = "/{id}")
    public Map<String, Object> eliminarPorId(@PathVariable("id") Long id){
        HashMap<String, Object> map = new HashMap<>();
        try{
            Optional<UsuariosModel> usuario =this.usuarioService.obtenerPorId(id);
            if(usuario.isPresent()){
                this.usuarioService.eliminarUsuario(id);
                map.put("status",200);
            }else{
                map.put("status",400);
                map.put("error", "No existe ese usuario");
            }
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
        
        
    }

}