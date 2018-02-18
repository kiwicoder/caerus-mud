package com.arrggh.caerus.model.impl.map;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class DoorTest {
    @Test
    public void testEquality() {
        EqualsVerifier.forClass(Door.class).verify();
    }
}