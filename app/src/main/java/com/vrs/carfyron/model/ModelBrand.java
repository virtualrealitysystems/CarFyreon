package com.vrs.carfyron.model;

/**
 * Class Name: ${Name}
 * Description:
 * Extends:
 * Implements:
 * Created by vrs on 31/3/15.
 */
public class ModelBrand {
    String mBrandName;
    Integer mBrandLogoId;

    public ModelBrand(String mBrandName, Integer mBrandLogoId) {
        this.mBrandName = mBrandName;
        this.mBrandLogoId = mBrandLogoId;
    }

    public String getmBrandName() {
        return mBrandName;
    }

    public void setmBrandName(String mBrandName) {
        this.mBrandName = mBrandName;
    }

    public Integer getmBrandLogoId() {
        return mBrandLogoId;
    }

    public void setmBrandLogoId(Integer mBrandLogoId) {
        this.mBrandLogoId = mBrandLogoId;
    }
}
