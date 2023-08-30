package com.doza.cloud.DozaCloud.repository;

import com.doza.cloud.DozaCloud.models.CarOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<CarOrder, Integer> {
}
