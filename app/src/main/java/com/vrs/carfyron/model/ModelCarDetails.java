package com.vrs.carfyron.model;

import java.io.Serializable;

/**
 * Class Name: ModelCarDetails
 * Description: This contains all model details of audi car
 * Created by vrs on 26/3/15.
 */
public class ModelCarDetails implements Serializable {

    private String model; //car model
    private String price; //car model price
    private Integer imageId; //car model image

    public ModelCarDetails(String model, String price, Integer imageId) {
        this.model = model;
        this.price = price;
        this.imageId = imageId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImage() {
        return imageId;
    }

    public void setImage(Integer imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
