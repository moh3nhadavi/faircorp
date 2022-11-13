package com.example.faircorp.dao;

import com.example.faircorp.model.Sensor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class SensorDaoTest {

    @Autowired
    private SensorDao sensorDao;

    @Test
    public void shouldFindASensor() {
        Sensor sensor = sensorDao.getReferenceById(-10L);
        Assertions.assertThat(sensor.getName()).isEqualTo("Sensor 1");
        Assertions.assertThat(sensor.getTemperature()).isEqualTo(8.9);
        Assertions.assertThat(sensor.getRoom().getId()).isEqualTo(-10L);
    }

}