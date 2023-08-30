package com.doza.cloud.DozaCloud.repository;

import com.doza.cloud.DozaCloud.models.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    Page<Car> findAll(PageRequest page);
}
