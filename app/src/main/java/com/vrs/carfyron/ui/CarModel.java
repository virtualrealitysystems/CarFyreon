package com.vrs.carfyron.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vrs.carfyron.R;
import com.vrs.carfyron.adapter.CarModelAdapter;
import com.vrs.carfyron.model.ModelCarDetails;
import com.vrs.carfyron.utils.Helper;

import java.util.ArrayList;
import java.util.HashMap;

import static com.vrs.carfyron.utils.Helper.*;

/**
 * Class Name: CarModel
 * Description: This class display model of selected car brand
 * Extends: Activity
 * Created by vrs on 26/3/15.
 */
public class CarModel extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    CAR mCar; //selected car brand

    ArrayList<ModelCarDetails> listAudiDetails; //audi model details
    ArrayList<ModelCarDetails> listBmwDetails; //bmw model details
    ArrayList<ModelCarDetails> listChevroletDetails; //chevrolet model details
    ArrayList<ModelCarDetails> listHondaDetails; //honda model details
    ArrayList<ModelCarDetails> listHyundaiDetails; //hyundai model details
    ArrayList<ModelCarDetails> listJaguarDetails; //jaguar model details
    ArrayList<ModelCarDetails> listMercedesDetails; //mercedes model details
    ArrayList<ModelCarDetails> listPorscheDetails; //porsche model details
    ArrayList<ModelCarDetails> listSkodaDetails; //Skoda model details
    ArrayList<ModelCarDetails> listMarutiSuzukiDetails; //maruti suzuki model details

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        setContentView(R.layout.activity_carmodel);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvCarModel);

        mRecyclerView.setHasFixedSize(true); //only set when you know changes in content do not
        // affect size of view

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = getAdapter(mCar);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * Method Name : init
     * Description : initialize class member herr
     * Created by vrs on 26/3/15.
     */
    private void init() {

        Intent inet = getIntent();
        mCar = (CAR) inet.getSerializableExtra(KEY_CAR_BRAND);

        //add audi car model here
        listAudiDetails = new ArrayList<>();
        listAudiDetails.add(new ModelCarDetails("Audi Q7 4.2 TDI quattro",
                "Starting at ₹ 87.69 lakhs", R.drawable.audi_q_seven));
        listAudiDetails.add(new ModelCarDetails("Audi RS7 Sportback 4.0 TFSI quattro",
                "Starting at ₹ 1.36 crores", R.drawable.audi_rs_seven));
        listAudiDetails.add(new ModelCarDetails("Audi RS5 4.2 Coupe",
                "Starting at ₹ 1.08 crores", R.drawable.audi_rs_five));
        listAudiDetails.add(new ModelCarDetails("Audi A8 L W12", "Starting at ₹ 1.84 crores",
                R.drawable.audi_a_eight_l));
        listAudiDetails.add(new ModelCarDetails("Audi TT 2.0 TFSI Quattro",
                "Starting at ₹ 55.15 lakhs", R.drawable.audi_tt));

        //add BMW car model here
        listBmwDetails = new ArrayList<>();
        listBmwDetails.add(new ModelCarDetails("BMW Z4 sDrive 35i", "Starting at ₹ 74.90 lakhs",
                R.drawable.bmw_z_four));
        listBmwDetails.add(new ModelCarDetails("BMW X1 sDrive20d xLine",
                "BMW X1 sDrive20d xLine", R.drawable.bmw_x_one));
        listBmwDetails.add(new ModelCarDetails("BMW i8 1.5 Petrol", "Starting at ₹ 2.29 crores",
                R.drawable.bmw_i_eight));
        listBmwDetails.add(new ModelCarDetails("BMW 7 Series Active Hybrid",
                "Starting at ₹ 1.41 crores", R.drawable.bmw_seven_active_hybrid));
        listBmwDetails.add(new ModelCarDetails("BMW 3 Series GT 320d GT Luxury Line",
                "Starting at ₹ 44.50 lakhs", R.drawable.bmw_three_series_gt));

        //add chevrolet car model here
        listChevroletDetails = new ArrayList<>();
        listChevroletDetails.add(new ModelCarDetails("Chevrolet Captiva LT",
                "Starting at ₹ 23.75 lakhs", R.drawable.chevrolet_captiva_lt));
        listChevroletDetails.add(new ModelCarDetails("Chevrolet Cruze LTZ AT",
                "Starting at ₹ 16.86 lakhs", R.drawable.chevrolet_cruze_ltz));
        listChevroletDetails.add(new ModelCarDetails("Chevrolet Tavera Neo 3-10 STR BS-III",
                "Starting at ₹ 7.59 lakhs", R.drawable.chevrolet_tavera_neo));
        listChevroletDetails.add(new ModelCarDetails("Chevrolet Spark 1.0 BS-IV OBDII",
                "Starting at ₹ 3.61 lakhs", R.drawable.bmw_three_series_gt));

        //add honda car model here
        listHondaDetails = new ArrayList<>();
        listHondaDetails.add(new ModelCarDetails("Honda Amaze 1.2 E i-VTEC",
                "Starting at ₹ 5.19 lakhs", R.drawable.honda_amaze));
        listHondaDetails.add(new ModelCarDetails("Honda Brio S MT", "Starting at ₹ 4.78 lakhs",
                R.drawable.honda_brio));
        listHondaDetails.add(new ModelCarDetails("Honda City VX", "Starting at ₹ 10.34 lakhs",
                R.drawable.honda_city));
        listHondaDetails.add(new ModelCarDetails("Honda CR-V 2.4L 4WD AVN",
                "Starting at ₹ 25.09 lakhs", R.drawable.honda_crv));

        //add hyundai car model here
        listHyundaiDetails = new ArrayList<>();
        listHyundaiDetails.add(new ModelCarDetails("Hyundai Santa Fe 2 WD AT",
                "Starting at ₹ 27.69 lakhs", R.drawable.hyunai_senta_fe));
        listHyundaiDetails.add(new ModelCarDetails("Hyundai i20 Active 1.4 SX",
                "Starting at ₹ 8.89 lakhs", R.drawable.hyundai_i20_active));
        listHyundaiDetails.add(new ModelCarDetails("Hyundai Fluidic Verna 1.6 CRDi SX AT",
                "Starting at ₹ 12.20 lakhs", R.drawable.hyundai_fluidic));
        listHyundaiDetails.add(new ModelCarDetails("Hyundai Elantra 1.6 S MT",
                "Starting at ₹ 14.43 lakhs", R.drawable.hyundai_elantra));

        //add jaguar car model here
        listJaguarDetails = new ArrayList<>();
        listJaguarDetails.add(new ModelCarDetails("Jaguar F-Type S Coupe",
                "Starting at ₹ 1.38 crores", R.drawable.jaguar_ftype));
        listJaguarDetails.add(new ModelCarDetails("Jaguar XF 2.2 Diesel Luxury",
                "Starting at ₹ 50.55 lakhs", R.drawable.jaguar_xf));
        listJaguarDetails.add(new ModelCarDetails("Jaguar XJ L 3.0 V6 premium-luxury",
                "Starting at ₹ 94.81 lakhs", R.drawable.jaguar_xj_l));

        //add mercedes car model here
        listMercedesDetails = new ArrayList<>();
        listMercedesDetails.add(new ModelCarDetails("Mercedes-Benz CLS 350",
                "Starting at ₹ 95.15 lakhs", R.drawable.marcedes_cls));
        listMercedesDetails.add(new ModelCarDetails("Mercedes-Benz A-Class Edition 1",
                "Starting at ₹ 27.90 lakhs", R.drawable.marcedes_a_class));
        listMercedesDetails.add(new ModelCarDetails("Mercedes-Benz SLK-Class SLK55 AMG",
                "Starting at ₹ 1.26 crores", R.drawable.marcedes_slk));
        listMercedesDetails.add(new ModelCarDetails("Mercedes-Benz GLA 200 Sport",
                "Starting at ₹ 36 lakhs", R.drawable.marcedes_gla));

        //add porsche car model here
        listPorscheDetails = new ArrayList<>();
        listPorscheDetails.add(new ModelCarDetails("Porsche 911 Carrera",
                "Starting at ₹ 1.38 crores", R.drawable.porsche_carrera));
        listPorscheDetails.add(new ModelCarDetails("Porsche Boxster GTS",
                "Starting at ₹ 1.15 crores", R.drawable.porsche_boxster));
        listPorscheDetails.add(new ModelCarDetails("Porsche Cayman Base Tiptronic",
                "Starting at ₹ 81.81 lakhs", R.drawable.porsche_cayman));
        listPorscheDetails.add(new ModelCarDetails("Porsche Macan Turbo",
                "Starting at ₹ 1.11 crores", R.drawable.porsche_macan));
        listPorscheDetails.add(new ModelCarDetails("Porsche Panamera 4",
                "Starting at ₹ 1.20 crores", R.drawable.porsche_panamera));

        //add skoda car model here
        listSkodaDetails = new ArrayList<>();
        listSkodaDetails.add(new ModelCarDetails("Skoda Octavia Ambition 1.4 TSI",
                "Starting at ₹ 16.25 lakhs", R.drawable.skoda_octivia));
        listSkodaDetails.add(new ModelCarDetails("Skoda Rapid 1.6 MPI Active",
                "Starting at ₹ 7.56 lakhs", R.drawable.skoda_rapid));
        listSkodaDetails.add(new ModelCarDetails("Skoda Superb Elegance 1.8 TSI MT",
                "Starting at ₹ 21.65 lakhs", R.drawable.skoda_superb));
        listSkodaDetails.add(new ModelCarDetails("Skoda Yeti Elegance 4 X 2",
                "Starting at ₹ 20.10 lakhs", R.drawable.skoda_yeti));

        //add maruti suzuki car model here
        listMarutiSuzukiDetails = new ArrayList<>();
        listMarutiSuzukiDetails.add(new ModelCarDetails("Maruti Suzuki Celerio LXi",
                "Starting at ₹ 3.90 lakhs", R.drawable.maruti_celario));
        listMarutiSuzukiDetails.add(new ModelCarDetails("Maruti Suzuki Swift VXi",
                "Starting at ₹ 5.32 lakhs", R.drawable.maruti_swift));
        listMarutiSuzukiDetails.add(new ModelCarDetails("Maruti Suzuki Grand Vitara 2.4 AT",
                "Starting at ₹ 24.61 lakhs", R.drawable.maruti_grand_vitara));
        listMarutiSuzukiDetails.add(new ModelCarDetails("Maruti Suzuki Wagon R 1.0 LXi",
                "Starting at ₹ 3.96 lakhs", R.drawable.maruti_wagon_r));
    }

    /**
     * Method Name : getAdapter;
     * Description : generate view adapter using car brand and car model list
     *
     * @param car brand of car to which you want to generate adapter
     * @return return generated adapter
     * * Created by vrs on 27/3/15.
     */
    private RecyclerView.Adapter getAdapter(CAR car) {
        RecyclerView.Adapter adapter = null;

        switch (car) {
            case AUDI:
                adapter = new CarModelAdapter(this, listAudiDetails);
                break;

            case BMW:
                adapter = new CarModelAdapter(this, listBmwDetails);
                break;

            case CHEVROLET:
                adapter = new CarModelAdapter(this, listChevroletDetails);
                break;

            case HONDA:
                adapter = new CarModelAdapter(this, listHondaDetails);
                break;

            case HYUNDAI:
                adapter = new CarModelAdapter(this, listHyundaiDetails);
                break;

            case JAGUAR:
                adapter = new CarModelAdapter(this, listJaguarDetails);
                break;

            case MERCEDES:
                adapter = new CarModelAdapter(this, listMercedesDetails);
                break;

            case PORSCHE:
                adapter = new CarModelAdapter(this, listPorscheDetails);
                break;

            case SKODA:
                adapter = new CarModelAdapter(this, listSkodaDetails);
                break;

            case MARUTISUZUKI:
                adapter = new CarModelAdapter(this, listMarutiSuzukiDetails);
                break;

        }

        return adapter;
    }
}
