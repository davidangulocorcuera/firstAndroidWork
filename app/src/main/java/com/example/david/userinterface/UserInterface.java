package com.example.david.userinterface;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInterface extends AppCompatActivity {

    @BindView(R.id.editText_name)
    EditText et_name;
    @BindView(R.id.editText_firstSurname)
    EditText et_firstSurname;
    @BindView(R.id.editText_secondSurname)
    EditText et_secondSurname;
    @BindView(R.id.editText_postalCode)
    EditText et_postalCode;
    @BindView(R.id.editText_city)
    EditText et_city;
    private TextInputLayout til_postalcode;
    private TextInputLayout til_city;

    private Switch switch_hide;
    private Boolean bl_switchState;
    private TextView textView_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);
        ButterKnife.bind(this);
        String str_name = et_name.getText().toString();
        String str_firstSurname = et_firstSurname.getText().toString();
        String str_secondSurname = et_secondSurname.getText().toString();
        String str_postalCode = et_postalCode.getText().toString();
        //til_city =(TextInputLayout) til_city.findViewById(R.id.textInputLayout_city);
        /*if(showPostalCodeAndCity(str_name,str_firstSurname)){
            til_city.setVisibility(View.VISIBLE);
        }*/
        switch_hide =  (Switch) findViewById(R.id.switch_hide);
        textView_description  = findViewById(R.id.textView_description);
        bl_switchState = switch_hide.isChecked();
    }
    public void showDescription(View view) {
        if(!(switch_hide.isChecked())){
            textView_description.setVisibility(View.INVISIBLE);
        }
        else{
            textView_description.setVisibility(View.VISIBLE);
        }
    }
    public void showPopUp(View view) {
        Toast toast = new Toast(this);
        toast.setGravity(5, 6, 6);
        Toast.makeText(this, "name: \n" + et_name.getText().toString() + " first surname: \n" +
                et_firstSurname.getText().toString() + "second surname \n" + et_secondSurname.getText().toString() + " postal code: \n" + et_postalCode.getText().toString()
                + " ciudad: \n" + et_city.getText().toString(), Toast.LENGTH_SHORT).show();

    }


    public boolean showPostalCodeAndCity(String str_name, String str_surname) {
        if (str_name.equals("") && str_surname.equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
