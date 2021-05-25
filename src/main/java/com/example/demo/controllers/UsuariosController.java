package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuariosModel;
import com.example.demo.services.UsuariosService;
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
    public ArrayList<UsuariosModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuariosModel guardarUsuario(@RequestBody UsuariosModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    
    
    @PutMapping()
    public UsuariosModel editarUsuario(@RequestBody UsuariosModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    
    @GetMapping( path = "/{id}")
    public Optional<UsuariosModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }
    @GetMapping( path = "/{id}/saldo")
    public Map<String, Object> obtenerSaldo(@PathVariable("id") Long id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("saldo", this.usuarioService.obtenerSaldo(id));
        return map;
    }
    
    
    
    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}