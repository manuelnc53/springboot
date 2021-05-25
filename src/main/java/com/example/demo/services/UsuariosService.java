package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuariosModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    UsuariosRepository usuarioRepository;
    
    public ArrayList<UsuariosModel> obtenerUsuarios(){
        return (ArrayList<UsuariosModel>) usuarioRepository.findAll();
    }

    public UsuariosModel guardarUsuario(UsuariosModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuariosModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }


    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}