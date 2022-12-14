package com.example.faircorp.dao;

import com.example.faircorp.model.Heater;
import com.example.faircorp.model.HeaterStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {
    @Autowired
    private HeaterDao heaterDao;

    @Test
    public void shouldFindAHeater() {
        Heater heater = heaterDao.getReferenceById(-10L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(heater.getStatus()).isEqualTo(HeaterStatus.OFF);
        Assertions.assertThat(heater.getPower()).isEqualTo(2000);
        Assertions.assertThat(heater.getRoom().getId()).isEqualTo(-10L);
    }
}