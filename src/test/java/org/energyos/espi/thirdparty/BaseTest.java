package org.energyos.espi.thirdparty;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class BaseTest {
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
}
