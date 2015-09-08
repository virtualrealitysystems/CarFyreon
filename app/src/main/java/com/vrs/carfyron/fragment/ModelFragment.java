package com.vrs.carfyron.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vrs.android.fyreon.FyreonWidget;
import com.vrs.android.fyreon.ui.SocialLoginActivity;
import com.vrs.carfyron.MainActivity;
import com.vrs.carfyron.R;
import com.vrs.carfyron.model.ModelCarDetails;
import com.vrs.carfyron.utils.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;

import at.markushi.ui.RevealColorView;

/**
 * Class Name: ${Name}
 * Description:
 * Extends:
 * Implements:
 * Created by vrs on 1/4/15.
 */
public class ModelFragment extends Fragment {

    private ImageView mIvModel;
    private TextView mTvModelName;
    private TextView mTvModelPrice;
    private GridView gvCarModel;
    private RevealColorView revealColorView;

    private View selectedView;
    private int backgroundColor;
    private ArrayList<ModelCarDetails> mSelectedList;

    private String mFyreOnCategory = "";

    ArrayList<ModelCarDetails> listAudiDetails; //audi model details
    ArrayList<ModelCarDetails> listBmwDetails; //bmw model details
    ArrayList<ModelCarDetails> listChevroletDetails; //chevrolet model details
    ArrayList<ModelCarDetails> listHondaDetails; //honda model details
    ArrayList<ModelCarDetails> listHyundaiDetails; //hyundai model details
    ArrayList<ModelCarDetails> listJaguarDetails; //jaguar model details
    ArrayList<ModelCarDetails> listMercedesDetails; //mercedes model details
    ArrayList<ModelCarDetails> listPorscheDetails; //porsche model details
    ArrayList<ModelCarDetails> listSkodaDetails; //Skoda model details
    ArrayList<ModelCarDetails> listMarutiSuzukiDetails; //maruti suzuki model
    // details


    ModelAdapter mAdapter;
    FyreonWidget mFyronWidget;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {

        switch (((MainActivity) getActivity()).mSelectedCar) {
            case AUDI:
                mFyreOnCategory = ".Audi";
                break;

            case BMW:
                mFyreOnCategory = ".Bmw";
                break;

            case CHEVROLET:
                mFyreOnCategory = ".Chevrole";
                break;

            case HONDA:
                mFyreOnCategory = ".Honda";
                break;

            case HYUNDAI:
                mFyreOnCategory = ".Hyundai";
                break;

            case JAGUAR:
                mFyreOnCategory = ".Jaguar";
                break;

            case MERCEDES:
                mFyreOnCategory = ".Mercedes";
                break;

            case PORSCHE:
                mFyreOnCategory = ".Porsche";
                break;

            case SKODA:
                mFyreOnCategory = ".Skoda";
                break;

            case MARUTISUZUKI:
                mFyreOnCategory = ".Maruti";
                break;
        }

        mFyronWidget = new FyreonWidget(getActivity(), "com.vrs.carfyron+" + mFyreOnCategory);
        View view = inflater.inflate(R.layout.fragment_model,
                container, false);

        //fyreon with facebook
//        SocialLoginActivity.setupFacebookWithReadPermissions(Arrays.asList("email",
// "public_profile"
//        ), getActivity().getApplicationContext());

        //fyreon with gplus
        SocialLoginActivity.setupGplus(getActivity().getApplicationContext());

        //fyreon with twitter
        SocialLoginActivity.setupTwitter(getString(R.string.twitter_consumer_key),
                getString(R.string.twitter_consumer_secret), getString(R.string
                        .twitter_auth_token), getString(R.string
                        .twitter_auth_secret), getString(R.string.twitter_callback), getString(R
                        .string.twitter_oauth_verifier), getActivity().getApplicationContext());


        mIvModel = (ImageView) view.findViewById(R.id.ivModel_fragment_model);
        mTvModelName = (TextView) view.findViewById(R.id.tvModelName_fragment_model);
        mTvModelPrice = (TextView) view.findViewById(R.id.tvModelPrice_fragment_model);

        revealColorView = (RevealColorView) view.findViewById(R.id.reveal);
        backgroundColor = Color.parseColor("#FFFFFF");

        gvCarModel = (GridView) view.findViewById(R.id.gvCarModel);
        gvCarModel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                setView(mSelectedList, position);

                final int color = getResources().getColor(R.color.lightColorPrimary);
                final Point p = getLocationInView(revealColorView, mIvModel);

                revealColorView.hide(p.x, p.y, backgroundColor, 0, 300, null);
                selectedView = null;
                revealColorView.reveal(p.x, p.y, color, mIvModel.getHeight() / 2, 340, null);
                selectedView = mIvModel;
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpDetails();
    }

    /**
     * Method Name : init
     * Description : initialize class member herr
     * Created by vrs on 26/3/15.
     */
    private void init() {

        mSelectedList = new ArrayList<>();

        //add audi car model here
        listAudiDetails = new ArrayList<>();
        listAudiDetails.add(new ModelCarDetails("Audi Q7 4.2 TDI quattro",
                "Starting at ₹ 87.69 lakhs", R.drawable.audi_q_seven));
        listAudiDetails.add(new ModelCarDetails("Audi RS7 Sportback 4.0 TFSI " +
                "quattro", "Starting at ₹ 1.36 crores",
                R.drawable.audi_rs_seven));
        listAudiDetails.add(new ModelCarDetails("Audi RS5 4.2 Coupe",
                "Starting at ₹ 1.08 crores", R.drawable.audi_rs_five));
        listAudiDetails.add(new ModelCarDetails("Audi A8 L W12",
                "Starting at ₹ 1.84 crores", R.drawable.audi_a_eight_l));
        listAudiDetails.add(new ModelCarDetails("Audi TT 2.0 TFSI Quattro",
                "Starting at ₹ 55.15 lakhs", R.drawable.audi_tt));

        //add BMW car model here
        listBmwDetails = new ArrayList<>();
        listBmwDetails.add(new ModelCarDetails("BMW Z4 sDrive 35i",
                "Starting at ₹ 74.90 lakhs", R.drawable.bmw_z_four));
        listBmwDetails.add(new ModelCarDetails("BMW X1 sDrive20d xLine",
                "BMW X1 sDrive20d xLine", R.drawable.bmw_x_one));
        listBmwDetails.add(new ModelCarDetails("BMW i8 1.5 Petrol",
                "Starting at ₹ 2.29 crores", R.drawable.bmw_i_eight));
        listBmwDetails.add(new ModelCarDetails("BMW 7 Series Active Hybrid",
                "Starting at ₹ 1.41 crores",
                R.drawable.bmw_seven_active_hybrid));
        listBmwDetails.add(new ModelCarDetails("BMW 3 Series GT 320d GT " +
                "Luxury Line", "Starting at ₹ 44.50 lakhs",
                R.drawable.bmw_three_series_gt));

        //add chevrolet car model here
        listChevroletDetails = new ArrayList<>();
        listChevroletDetails.add(new ModelCarDetails("Chevrolet Captiva LT",
                "Starting at ₹ 23.75 lakhs", R.drawable.chevrolet_captiva_lt));
        listChevroletDetails.add(new ModelCarDetails("Chevrolet Cruze LTZ " +
                "AT", "Starting at ₹ 16.86 lakhs",
                R.drawable.chevrolet_cruze_ltz));
        listChevroletDetails.add(new ModelCarDetails("Chevrolet Tavera Neo " +
                "3-10 STR BS-III", "Starting at ₹ 7.59 lakhs",
                R.drawable.chevrolet_tavera_neo));
        listChevroletDetails.add(new ModelCarDetails("Chevrolet Spark 1.0 " +
                "BS-IV OBDII", "Starting at ₹ 3.61 lakhs",
                R.drawable.bmw_three_series_gt));

        //add honda car model here
        listHondaDetails = new ArrayList<>();
        listHondaDetails.add(new ModelCarDetails("Honda Amaze 1.2 E i-VTEC",
                "Starting at ₹ 5.19 lakhs", R.drawable.honda_amaze));
        listHondaDetails.add(new ModelCarDetails("Honda Brio S MT",
                "Starting at ₹ 4.78 lakhs", R.drawable.honda_brio));
        listHondaDetails.add(new ModelCarDetails("Honda City VX",
                "Starting at ₹ 10.34 lakhs", R.drawable.honda_city));
        listHondaDetails.add(new ModelCarDetails("Honda CR-V 2.4L 4WD AVN",
                "Starting at ₹ 25.09 lakhs", R.drawable.honda_crv));

        //add hyundai car model here
        listHyundaiDetails = new ArrayList<>();
        listHyundaiDetails.add(new ModelCarDetails("Hyundai Santa Fe 2 WD " +
                "AT", "Starting at ₹ 27.69 lakhs", R.drawable.hyunai_senta_fe));
        listHyundaiDetails.add(new ModelCarDetails("Hyundai i20 Active 1.4 " +
                "SX", "Starting at ₹ 8.89 lakhs",
                R.drawable.hyundai_i20_active));
        listHyundaiDetails.add(new ModelCarDetails("Hyundai Fluidic Verna 1.6" +
                " CRDi SX AT", "Starting at ₹ 12.20 lakhs",
                R.drawable.hyundai_fluidic));
        listHyundaiDetails.add(new ModelCarDetails("Hyundai Elantra 1.6 S " +
                "MT", "Starting at ₹ 14.43 lakhs", R.drawable.hyundai_elantra));

        //add jaguar car model here
        listJaguarDetails = new ArrayList<>();
        listJaguarDetails.add(new ModelCarDetails("Jaguar F-Type S Coupe",
                "Starting at ₹ 1.38 crores", R.drawable.jaguar_ftype));
        listJaguarDetails.add(new ModelCarDetails("Jaguar XF 2.2 Diesel " +
                "Luxury", "Starting at ₹ 50.55 lakhs", R.drawable.jaguar_xf));
        listJaguarDetails.add(new ModelCarDetails("Jaguar XJ L 3.0 V6 " +
                "premium-luxury", "Starting at ₹ 94.81 lakhs",
                R.drawable.jaguar_xj_l));

        //add mercedes car model here
        listMercedesDetails = new ArrayList<>();
        listMercedesDetails.add(new ModelCarDetails("Mercedes-Benz CLS 350",
                "Starting at ₹ 95.15 lakhs", R.drawable.marcedes_cls));
        listMercedesDetails.add(new ModelCarDetails("Mercedes-Benz A-Class " +
                "Edition 1", "Starting at ₹ 27.90 lakhs",
                R.drawable.marcedes_a_class));
        listMercedesDetails.add(new ModelCarDetails("Mercedes-Benz SLK-Class " +
                "SLK55 AMG", "Starting at ₹ 1.26 crores",
                R.drawable.marcedes_slk));
        listMercedesDetails.add(new ModelCarDetails("Mercedes-Benz GLA 200 " +
                "Sport", "Starting at ₹ 36 lakhs", R.drawable.marcedes_gla));

        //add porsche car model here
        listPorscheDetails = new ArrayList<>();
        listPorscheDetails.add(new ModelCarDetails("Porsche 911 Carrera",
                "Starting at ₹ 1.38 crores", R.drawable.porsche_carrera));
        listPorscheDetails.add(new ModelCarDetails("Porsche Boxster GTS",
                "Starting at ₹ 1.15 crores", R.drawable.porsche_boxster));
        listPorscheDetails.add(new ModelCarDetails("Porsche Cayman Base " +
                "Tiptronic", "Starting at ₹ 81.81 lakhs",
                R.drawable.porsche_cayman));
        listPorscheDetails.add(new ModelCarDetails("Porsche Macan Turbo",
                "Starting at ₹ 1.11 crores", R.drawable.porsche_macan));
        listPorscheDetails.add(new ModelCarDetails("Porsche Panamera 4",
                "Starting at ₹ 1.20 crores", R.drawable.porsche_panamera));

        //add skoda car model here
        listSkodaDetails = new ArrayList<>();
        listSkodaDetails.add(new ModelCarDetails("Skoda Octavia Ambition 1.4 " +
                "TSI", "Starting at ₹ 16.25 lakhs", R.drawable.skoda_octivia));
        listSkodaDetails.add(new ModelCarDetails("Skoda Rapid 1.6 MPI " +
                "Active", "Starting at ₹ 7.56 lakhs", R.drawable.skoda_rapid));
        listSkodaDetails.add(new ModelCarDetails("Skoda Superb Elegance 1.8 " +
                "TSI MT", "Starting at ₹ 21.65 lakhs",
                R.drawable.skoda_superb));
        listSkodaDetails.add(new ModelCarDetails("Skoda Yeti Elegance 4 X 2",
                "Starting at ₹ 20.10 lakhs", R.drawable.skoda_yeti));

        //add maruti suzuki car model here
        listMarutiSuzukiDetails = new ArrayList<>();
        listMarutiSuzukiDetails.add(new ModelCarDetails("Maruti Suzuki " +
                "Celerio LXi", "Starting at ₹ 3.90 lakhs",
                R.drawable.maruti_celario));
        listMarutiSuzukiDetails.add(new ModelCarDetails("Maruti Suzuki Swift " +
                "VXi", "Starting at ₹ 5.32 lakhs", R.drawable.maruti_swift));
        listMarutiSuzukiDetails.add(new ModelCarDetails("Maruti Suzuki Grand " +
                "Vitara 2.4 AT", "Starting at ₹ 24.61 lakhs",
                R.drawable.maruti_grand_vitara));
        listMarutiSuzukiDetails.add(new ModelCarDetails("Maruti Suzuki Wagon " +
                "R 1.0 LXi", "Starting at ₹ 3.96 lakhs",
                R.drawable.maruti_wagon_r));
    }

    public void setUpDetails() {
        switch (((MainActivity) getActivity()).mSelectedCar) {
            case AUDI:
                mSelectedList = new ArrayList<>(listAudiDetails);
                mFyreOnCategory = ".Audi";
                break;

            case BMW:
                mSelectedList = new ArrayList<>(listBmwDetails);
                mFyreOnCategory = ".Bmw";
                break;

            case CHEVROLET:
                mSelectedList = new ArrayList<>(listChevroletDetails);
                mFyreOnCategory = ".Chevrole";
                break;

            case HONDA:
                mSelectedList = new ArrayList<>(listHondaDetails);
                mFyreOnCategory = ".Honda";
                break;

            case HYUNDAI:
                mSelectedList = new ArrayList<>(listHyundaiDetails);
                mFyreOnCategory = ".Hyundai";
                break;

            case JAGUAR:
                mSelectedList = new ArrayList<>(listJaguarDetails);
                mFyreOnCategory = ".Jaguar";
                break;

            case MERCEDES:
                mSelectedList = new ArrayList<>(listMercedesDetails);
                mFyreOnCategory = ".Mercedes";
                break;

            case PORSCHE:
                mSelectedList = new ArrayList<>(listPorscheDetails);
                mFyreOnCategory = ".Porsche";
                break;

            case SKODA:
                mSelectedList = new ArrayList<>(listSkodaDetails);
                mFyreOnCategory = ".Skoda";
                break;

            case MARUTISUZUKI:
                mSelectedList = new ArrayList<>(listMarutiSuzukiDetails);
                mFyreOnCategory = ".Maruti";
                break;
        }
        mAdapter = new ModelAdapter(getActivity(), R.layout.list_item_model,
                mSelectedList);
        gvCarModel.setAdapter(mAdapter);
        setView(mSelectedList, 0);

        final int color = getResources().getColor(R.color.lightColorPrimary);

       /* final Point p = getLocationInView(revealColorView, view);
        revealColorView.hide(gvCarModel.getTop(), gvCarModel.getLeft(), backgroundColor, 0, 300,
                null);
        selectedView = null;
        revealColorView.reveal(gvCarModel.getTop(), gvCarModel.getLeft(), color,
                gvCarModel.getHeight() / 2, 340, null);
        selectedView = gvCarModel;*/

        final Point p = getLocationInView(revealColorView, mIvModel);

        revealColorView.hide(p.x, p.y, backgroundColor, 0, 300, null);
        selectedView = null;
        revealColorView.reveal(p.x, p.y, color, mIvModel.getHeight() / 2, 340, null);
        selectedView = mIvModel;
    }

    private void setView(ArrayList<ModelCarDetails> modelList, int position) {
        ModelCarDetails details = modelList.get(position);
        mIvModel.setImageResource(details.getImage());
        mTvModelName.setText(details.getModel());
        mTvModelPrice.setText(details.getPrice());
    }

    private Point getLocationInView(View src, View target) {
        final int[] l0 = new int[2];
        src.getLocationOnScreen(l0);

        final int[] l1 = new int[2];
        target.getLocationOnScreen(l1);

        l1[0] = l1[0] - l0[0] + target.getWidth() / 2;
        l1[1] = l1[1] - l0[1] + target.getHeight() / 2;

        return new Point(l1[0], l1[1]);
    }

    /**
     * Class Name : ModelAdapter
     * Description : provides view for the each data item in data list and bind it with
     * grid view
     * Extends ArrayAdapter
     * Created by vrs on 25/03/15.
     *
     * @see com.vrs.carfyron.utils.ViewHolder
     */
    class ModelAdapter extends ArrayAdapter<ModelCarDetails> {


        private Context context;
        private int resource;
        private ArrayList<ModelCarDetails> listCarBrands;
        private LayoutInflater inflater;


        public ModelAdapter(Context context, int resource,
                            ArrayList<ModelCarDetails> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resource = resource;
            listCarBrands = objects;
            inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = (LinearLayout) inflater.inflate(resource, null);
                viewHolder.ivCarLogo = (ImageView) convertView.findViewById(R
                        .id.list_item_model_grid_ivModelImage);
                viewHolder.tvModelName = (TextView) convertView.findViewById
                        (R.id.list_item_model_grid_tvModelName);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.ivCarLogo.setImageResource(listCarBrands.get(position).getImage());
            viewHolder.tvModelName.setText(listCarBrands.get(position).getModel());

            return convertView;
        }
    }
}
