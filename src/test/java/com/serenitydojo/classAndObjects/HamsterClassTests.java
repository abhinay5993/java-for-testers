package com.serenitydojo.classAndObjects;
import static org.assertj.core.api.StrictAssertions.assertThat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.testng.annotations.Test;

public class HamsterClassTests {
	
    @Test
    public void theDogClassShouldExist() throws ClassNotFoundException {
    assertThat(Class.forName("com.serenitydojo.classAndObjects.HampsterEntity")).isNotNull();
    System.out.println("\nTC-01 - theDogClassShouldExist() - Executed successfully.");
    }

    
    @Test
    public void shouldBeAPet() throws Exception {
        assertThat(Class.forName("com.serenitydojo.classAndObjects.HampsterEntity").getSuperclass().getSimpleName())
                  .isEqualTo("AbstractPetEntity");
    System.out.println("\nTC-02 - shouldBeAPet() - Executed successfully.");
    }

    
    @Test
    public void theDogClassShouldHaveAFavoriteToy() throws Exception {
        assertThat(Class.forName("com.serenitydojo.classAndObjects.HampsterEntity").getDeclaredField("favoriteGame").getGenericType())
                   .isEqualTo(String.class);
        System.out.println("\nTC-03 - theDogClassShouldHaveAFavoriteToy() - Executed successfully.");
    }

    
    @Test
    public void theDogClassShouldHaveAMethodCalledMakeNoise() throws Exception {
        assertThat(Class.forName("com.serenitydojo.classAndObjects.DogEntity").getMethod("makeNoise").getReturnType())
                   .isEqualTo(String.class);
    System.out.println("\nTC-04 - theDogClassShouldHaveAMethodCalledMakeNoise() - Executed successfully.");
    }

    
    @Test
    public void theDogClassShouldHaveAConstantField_MAKE_NOISE() throws Exception {
        Field makeNoise = Class.forName("com.serenitydojo.classAndObjects.DogEntity").getDeclaredField("DOG_NOISE");
        assertThat(makeNoise.getType()).isEqualTo(String.class);
        assertThat(Modifier.isFinal(makeNoise.getModifiers())).isTrue();
        assertThat(Modifier.isStatic(makeNoise.getModifiers())).isTrue();
    System.out.println("\nTC-05 - theDogClassShouldHaveAConstantField_MAKE_NOISE() - Executed successfully.");
    }

}