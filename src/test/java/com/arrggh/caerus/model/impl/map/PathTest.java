package com.arrggh.caerus.model.impl.map;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class PathTest {
    @Test
    public void testEquality() {
        EqualsVerifier.forClass(Path.class).verify();
    }
}