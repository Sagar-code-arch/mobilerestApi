package com.mms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mms.model.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
	
	List<Mobile> findByMaker(String maker);
	
	List<Mobile> findByColor(String color);
	
	List<Mobile> findByModelAndColor(String model,String color);
	
	List<Mobile> findByProcessor(Integer processor);
	
	@Query(value="select * from mobile where processor >= :value",nativeQuery = true)
	List<Mobile> findByProcessor(@Param("value") int value);
	
	@Query(value="select * from mobile where price between :value1 and :value2",nativeQuery = true)
	List<Mobile> findByPriceRange(@Param("value1") int value1,@Param("value2") int value2);
}
