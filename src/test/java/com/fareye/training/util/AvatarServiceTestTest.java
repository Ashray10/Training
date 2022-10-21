package com.fareye.training.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvatarServiceTestTest {

    @Test
    void addNo() {
        AvatarServiceTest test = new AvatarServiceTest();
        assertEquals(10, test.addNo(5,5));
    }
}