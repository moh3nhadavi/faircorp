package com.example.building.dao;

import com.example.building.model.Building;
import com.example.building.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BuildingDaoTest {

    @Test
    void findByUsernameIgnoreCase() {
        Building building = buildingDao.getReferenceById("mmm");
        Assertions.assertThat(building.getUsername()).isEqualTo("mmm");
    }

    @Autowired
    private BuildingDao buildingDao;

    @Test
    public void shouldFindABuilding() {
        Building building = buildingDao.findByUsernameIgnoreCase("mmm");
        Assertions.assertThat(building.getName()).isEqualTo("Hotel 1");
        Assertions.assertThat(building.getOut_temperature()).isEqualTo(25.4);
    }

}