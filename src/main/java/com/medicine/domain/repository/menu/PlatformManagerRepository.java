package com.medicine.domain.repository.menu;


import com.medicine.domain.menu.PlatformManager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlatformManagerRepository extends JpaRepository<PlatformManager, Long> {

    List<PlatformManager> findBySysType(String sysType);

    List<PlatformManager> findByIsMenuAndSysType(Integer isMenu, String sysType);

    List<PlatformManager> findByFClass(Long fClass);


}
