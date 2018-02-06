package com.arrggh.caerus.model.impl;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class RoomTest {
    @Test
    public void testEquality() {
        EqualsVerifier.forClass(Room.class).verify();
    }
}