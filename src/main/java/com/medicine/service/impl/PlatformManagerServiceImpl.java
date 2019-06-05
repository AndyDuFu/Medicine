package com.medicine.service.impl;

import com.alibaba.fastjson.JSON;
import com.medicine.common.constant.MenuStatus;
import com.medicine.domain.attiendRecode.Medicine;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.MedicineDTO;
import com.medicine.domain.dto.count.CountDTO;
import com.medicine.domain.dto.count.StatementDTO;
import com.medicine.domain.dtoAndFrom.menu.*;
import com.medicine.domain.mapper.PlatformManagerDataMapper;
import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.menu.Prescription;
import com.medicine.domain.queryFrom.FJQueryFrom;
import com.medicine.domain.queryFrom.ZyQueryFrom;
import com.medicine.domain.repository.attiendRecode.MedicineRepository;
import com.medicine.domain.repository.menu.PlatformManagerDataRepository;
import com.medicine.domain.repository.menu.PlatformManagerRepository;
import com.medicine.domain.repository.menu.PrescriptionRepository;
import com.medicine.service.PlatformManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlatformManagerServiceImpl implements PlatformManagerService {

    @Autowired
    private PlatformManagerRepository platformManagerRepository;

    @Autowired
    private PlatformManagerDataRepository platformManagerDataRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PlatformManagerDataMapper platformManagerDataMapper;

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public PlatformManager save(Map<String, Object> data) {
        String type = data.get("sysType").toString();
        String json = JSON.toJSONString(data, true);
        PlatformManager platformManager = new PlatformManager();
        switch (type) {
            case "cdm":return getPlatformRecord(json, CdmManager.class);
            case "wdm":return getPlatformRecord(json, WdmManager.class);
            case "zh":return getPlatformRecord(json, ZhManager.class);
            case "sz":return getPlatformRecord(json, SzManager.class);
            case "yp":return getPlatformRecord(json, YpManager.class);
            case "zy":return getPlatformRecord(json, ZyManager.class);
            case "zzzf":return getPlatformRecord(json, ZzzFmManager.class);
            case "mz":return getPlatformRecord(json, MzManager.class);
            case "gxlx":return getPlatformRecord(json, GxlxManager.class);
            case "fj":return getPlatformRecord(json, FjManager.class);
            case "fjzz":return getPlatformRecord(json, FjzzManager.class);
            case "zz":return getPlatformRecord(json, ZzManager.class);
        }

        return platformManager;
    }

    /**
     *
     * @param json
     * @param clazz
     * @return
     */
    public PlatformManager getPlatformRecord(String json, Type clazz) {
        SuperManager superManager = JSON.parseObject(json,  clazz);
        PlatformManager platformManager = superManager.managerToPlatformConvert(superManager);
        PlatformManagerData platformManagerData;
        if (!StringUtils.isEmpty( platformManager.getId())) {
            Long platId = platformManager.getId();
            platformManagerData = platformManagerDataRepository.findByPmId(platId);
            if (platformManagerData != null) {
                platformManagerDataRepository.delete(platformManagerData);
            }
            if (platformManager.getSysType().equals("fj")) {
                List<Prescription> prescriptions = prescriptionRepository.findByMenuId(platId);
                prescriptions.forEach(e->prescriptionRepository.delete(e));
            }
        }
        platformManagerData = superManager.managerToPlatformConvertData(superManager);
        platformManager = platformManagerRepository.save(platformManager);
        if (platformManager.getIsMenu().equals(0)) {
            final Long platId = platformManager.getId();
            platformManagerData.setPmId(platId);
            platformManagerDataRepository.save(platformManagerData);
            if (platformManager.getSysType().equals("fj")) {
               FjManager fjManager = (FjManager)superManager;
               List<Prescription> prescriptions = fjManager.getCf();
               prescriptions.forEach(e->{
                   e.setMenuId(platId);
                   prescriptionRepository.save(e);
               });
            }
        }
        return platformManager;
    }

    @Override
    public List<Map<String, Object>> findByManager(String type) {
        List<PlatformManager> platformManagers = platformManagerRepository.findBySysType(type);
        List<Map<String, Object>> maps = new ArrayList<>();
        platformManagers.forEach(e ->maps.add(getManagerMap(e)));
        return maps;
    }


    /**
     * 从数据库查询 对应平台数据。其中每个类型对应字段意思不同。。具体看实现类
     * @param e
     * @return
     */
    public Map<String, Object> getManagerMap(PlatformManager e) {
        SuperManager superManager;
        Map<String, Object> map = new HashMap<>();
        if (e.getIsMenu().equals(0)) {
            PlatformManagerData platformManagerData = platformManagerDataRepository.findByPmId(e.getId());
            switch (e.getSysType()) {
                    /** 中医疾病管理 */
                case "cdm":
                    superManager = new CdmManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            CdmManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                    /** 西医疾病管理 */
                case "wdm":
                    superManager = new WdmManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            WdmManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                    /** 证候管理 */
                case "zh":
                    superManager = new ZhManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            ZhManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                    /** 舌诊管理 */
                case "sz":
                    superManager = new SzManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            SzManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                    /** 饮片管理 */
                case "yp":
                    superManager = new YpManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            YpManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                    /** 中药管理 */
                case "zy":
                    superManager = new ZyManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            ZyManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                    /** 治则治法管理 */
                case "zzzf":
                    superManager = new ZzzFmManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            ZzzFmManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                    /** 脉诊管理 */
                case "mz":
                    superManager = new MzManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            MzManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                    /** 功效类型管理 */
                case "gxlx":
                    superManager = new GxlxManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            GxlxManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                    /** 方剂管理 */
                case "fj":
                    superManager = new FjManager();
                    List<Prescription> prescriptions = prescriptionRepository.findByMenuId(e.getId());
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getFjManager(
                                            FjManager.class, superManager, e, platformManagerData, prescriptions
                                    )
                            )
                    );break;
                    /** 方剂主治管理 */
                case "fjzz":
                    superManager = new FjzzManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            FjzzManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                    /** 症状管理 */
                case "zz":
                    superManager = new ZzManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            ZzManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
            }
        } else {
            map = JSON.parseObject(JSON.toJSONString(e));
        }
        return map;
    }
    public <T> T getManager(Class<T> type, SuperManager superManager, PlatformManager e, PlatformManagerData platformManagerData) {
        return  cast(type, superManager.platformToCdmManagerConvert(e, platformManagerData));
    }

    public <T> T getFjManager(Class<T> type, SuperManager superManager, PlatformManager e, PlatformManagerData platformManagerData, List<Prescription> prescriptions) {
        return cast(type, superManager.platformToCdmManagerConvert(e, platformManagerData, prescriptions));
    }

    public static <T> T cast(Class<T> type, Object bean) {
        return type.cast(bean);
    }
    @Override
    public void deletePlatAndPlatDate(Long id) {
        PlatformManager platformManager = new PlatformManager();
        platformManager.setId(id);
        PlatformManager p = platformManagerRepository.findOne(Example.of(platformManager)).get();
        deleteSubMenus(p);
    }

    /**
     * 递归实现删除菜单
     * @param platformManager
     */
    public void deleteSubMenus(PlatformManager platformManager) {
        Long id = platformManager.getId();
        if (platformManager.getIsMenu().equals(1)) {
            List<PlatformManager> platformManagers =
                    platformManagerRepository.findByFClass(id);
            if (platformManagers.size() > 0) {
                platformManagers.forEach(this::deleteSubMenus);
            }
        } else {
            PlatformManagerData platformManagerData = platformManagerDataRepository.findByPmId(id);
            if (platformManagerData != null) {
                platformManagerDataRepository.delete(platformManagerData);
            }
            List<Prescription> prescriptions = prescriptionRepository.findByMenuId(id);
            if (prescriptions.size() > 0) {
                prescriptions.forEach(e->prescriptionRepository.delete(e));
            }
        }
        platformManagerRepository.delete(platformManager);
    }

    @Override
    public List<String> findByZyName() {
        List<PlatformManager> platformManagers =
                platformManagerRepository.findByIsMenuAndSysType(
                        MenuStatus.NOT_MENU_STATUS, "zy"
                );
        List<String> list = new ArrayList<>();
        if (platformManagers.size() >0 ) {
            platformManagers.forEach(e->list.add(e.getName()));
        }
        return list;
    }

    @Override
    public List<PlatformManagerData> findZhongYi(ZyQueryFrom zyQueryFrom) {
        return platformManagerDataMapper.selectPlatformManagerDataList(
               zyQueryFrom
        );
    }

    @Override
    public List<FjManager> findFj(FJQueryFrom fjQueryFrom) {
        return platformManagerDataMapper.findByFj(fjQueryFrom);
    }


    public List<StatementDTO> countData(FJQueryFrom fjQueryFrom, Integer type) {
        switch (type) {
            case 0: return syzhCount(fjQueryFrom);
            case 1: return platformManagerDataMapper.MedicineQuery(fjQueryFrom);
            case 2: return countZy(fjQueryFrom, 2);
            case 3: return countZy(fjQueryFrom, 3);
            case 4: return countZy(fjQueryFrom, 4);
        }
        return null;
    }

    @Override
    public List<MedicineDTO> findByFJZI(Integer status, Long mid) {
        List<MedicineDTO> medicineDTOS = new ArrayList<>();
        if (status.equals(0)) {
            List<Prescription> prescriptions = prescriptionRepository.findByMenuId(mid);
            medicineDTOS = MedicineDTO.prescriptionsDTOS(prescriptions);
        } else {
            List<Medicine> medicines = medicineRepository.findByDatId(mid);
            medicineDTOS = MedicineDTO.medicineDTOS(medicines);
        }
        return medicineDTOS;
    }


    public List<StatementDTO> syzhCount(FJQueryFrom fjQueryFrom) {
        List<StatementDTO> s = platformManagerDataMapper.syzhCount(fjQueryFrom);
        Map<String, Integer> map = new HashMap<>();
        s.forEach(e -> {
            List<String> list = CountDTO.stringListConvertString(e.getName());
            list.forEach(a -> {
                if(!map.containsKey(a)){
                    map.put(a, 1);
                }else {
                    map.put(a, map.get(a)+1);
                }
            });
        });

        return countData(map);
    }


    public List<StatementDTO> countData(Map<String, Integer> map) {
        List<StatementDTO> statementDTOS = new ArrayList<>();
        for (String in : map.keySet()) {
            StatementDTO statementDTO = new StatementDTO();
            statementDTO.setName(in);
            statementDTO.setCount(map.get(in));
            statementDTOS.add(statementDTO);
        }
        return statementDTOS;
    }
    public List<StatementDTO> countZy(FJQueryFrom f, Integer type) {
        List<CountDTO> statementDTOList = platformManagerDataMapper.selectCountZY(f);
        Map<String, Integer> map = new HashMap<>();
        statementDTOList.forEach(e -> {
            if (e != null) {
                List<String> list = CountDTO.stringListConvertString(type.equals(2) ? e.getGj() : type.equals(3) ? e.getSq() : e.getWw());
                list.forEach(a -> {
                    if (!map.containsKey(a)) {
                        map.put(a, 1);
                    } else {
                        map.put(a, map.get(a) + 1);
                    }
                });
            }
        });
        return countData(map);
    }

	@Override
	public List<PlatformManagerData> findZhongYiByLike(ZyQueryFrom zyQueryFrom) {
		 return platformManagerDataMapper.likePlatformManagerDataList(zyQueryFrom);
	}

	@Override
	public List<FjManager> likeByFj(FJQueryFrom fjQueryFrom) {
		return platformManagerDataMapper.likeByFj(fjQueryFrom);
	}
}
