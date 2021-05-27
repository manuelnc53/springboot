package com.example.demo.controllers;

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
            map.put("data", new ObjectMapper());
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }

    @PostMapping()
    public Map<String, Object> guardarUsuario(@RequestBody UsuariosModel usuario){
        HashMap<String, Object> map = new HashMap<>();
        try{
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
            map.put("data", this.usuarioService.obtenerPorId(id));
            map.put("status",200);
        }catch(Exception e){
            map.put("data", new ObjectMapper());
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
    @GetMapping( path = "/{id}/saldo")
    public Map<String, Object> obtenerSaldo(@PathVariable("id") Long id) {
        
        HashMap<String, Object> map = new HashMap<>();
        try{
            map.put("data", new HashMap<String, Object>().put("saldo", this.usuarioService.obtenerSaldo(id)));
            map.put("status",200);
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
            this.usuarioService.eliminarUsuario(id);
            map.put("status",200);
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
        
        
    }

}