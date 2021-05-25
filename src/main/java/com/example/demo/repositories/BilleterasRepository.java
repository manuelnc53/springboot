package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.BilleterasModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilleterasRepository extends CrudRepository<BilleterasModel, Long> {

}