package com.vrs.carfyron.utils;

/**
 * Class Name: Helper
 * Description:this is provide helper data to other classes
 * Created by vrs on 27/3/15.
 */
public class Helper {

    //car brand type
    public enum CAR {
        AUDI, BMW, CHEVROLET, HONDA, HYUNDAI, JAGUAR, MERCEDES, PORSCHE, SKODA, MARUTISUZUKI
    }

    ;

    public static final String KEY_CAR_BRAND = "keyCarBrand"; //key for car brand
    public static final String KEY_MODEL_DETAILS = "keyModelDetails"; //key for passing car
    // details through intent extra
}
