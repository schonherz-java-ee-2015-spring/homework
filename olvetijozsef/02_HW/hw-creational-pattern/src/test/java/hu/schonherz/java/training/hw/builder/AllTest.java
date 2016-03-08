package hu.schonherz.java.training.hw.builder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import hu.schonherz.java.training.hw.builder.material.AllMaterialTest;
import hu.schonherz.java.training.hw.builder.part.AllPartTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CarTest.class, CarBuilderTest.class, AllMaterialTest.class, AllPartTest.class })
public class AllTest {

}
