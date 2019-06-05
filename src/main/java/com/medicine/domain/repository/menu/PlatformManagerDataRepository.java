package com.medicine.domain.repository.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlatformManagerDataRepository extends JpaRepository<PlatformManagerData, Long>{

    PlatformManagerData findByPmId(Long id);

    @Query("select d from PlatformManagerData d left join PlatformManager m on d.pmId = m.id where  " +
            " m.name like :name and" +
            " d.x12 like :jy and" +
            " d.x16 like :xwgj and" +
            " d.x17 like :xwgj and" +
            " d.x18 like :xwgj and" +
            " d.x20 like :glzz and" +
            " d.x11 like :xz and" +
            " m.type like :type"

    )
    Page<PlatformManagerData> findByQuery(
            @Param(value = "name") String name,
            @Param( "jy") String jy,
            @Param("xwgj") String xwgj,
            @Param("glzz") String glzz,
            @Param("xz") String xz,
            @Param(value = "type") Integer type,
            Pageable pageable
    );
}
