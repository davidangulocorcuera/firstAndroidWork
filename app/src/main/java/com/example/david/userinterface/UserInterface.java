package com.example.david.userinterface;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInterface extends AppCompatActivity {
    // we used butter knife for take the data from the xml
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
    private TextView textView_description;
    private Button btnShowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);
        ButterKnife.bind(this);

        /*
        String str_name = et_name.getText().toString();
        String str_firstSurname = et_firstSurname.getText().toString();
        String str_secondSurname = et_secondSurname.getText().toString();
        String str_postalCode = et_postalCode.getText().toString();
        */

        switch_hide = (Switch) findViewById(R.id.switch_hide);
        textView_description = findViewById(R.id.textView_description);
        til_city = findViewById(R.id.textInputLayout_city);
        til_postalcode = findViewById(R.id.textInputLayout_postalCode);
        btnShowData = findViewById(R.id.btn_show);

        showDescription();
        showPCandCity();
        showButtonShowData();

    }

    //function for show the user description when you click on the switch button
    public void showDescription() {
        switch_hide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    textView_description.setVisibility(View.GONE);
                } else {
                    textView_description.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    //function for show the user edittext postalcode and city when name and firstname !isempty
    public void showPCandCity() {
        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (et_name.getText().length() >= 0) {
                    et_firstSurname.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            if (et_firstSurname.getText().length() >= 0) {
                                til_postalcode.setVisibility(View.VISIBLE);
                                til_city.setVisibility(View.VISIBLE);
                            }
                        }

                    });
                }
            }
        });
    }

    //with this function we show the pop up when you click the show button
    public void showPopUp(View view) {
        Toast toast = new Toast(this);
        toast.setGravity(5, 6, 6);
        Toast.makeText(this, "\n Name: " + et_name.getText().toString() + "\n First surname: " +
                et_firstSurname.getText().toString() + "\n Second surname: " + et_secondSurname.getText().toString() + "\n Postal code: " + et_postalCode.getText().toString()
                + "\n Ciudad: " + et_city.getText().toString(), Toast.LENGTH_SHORT).show();
        resetEdittext();
        btnShowData.setVisibility(View.GONE);

    }


    //function for reset all text for all edittext
    public void resetEdittext() {
        et_name.setText("");
        et_firstSurname.setText("");
        et_secondSurname.setText("");
        et_postalCode.setText("");
        et_city.setText("");
        til_postalcode.setVisibility(View.GONE);
        til_city.setVisibility(View.GONE);
    }

    //function for show the Button when all edittext have text
    public void showButtonShowData() {
        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (et_name.getText().length() >= 0) {
                    et_firstSurname.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            if (et_firstSurname.getText().length() >= 0) {
                                et_secondSurname.addTextChangedListener(new TextWatcher() {
                                    @Override
                                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                    }

                                    @Override
                                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    }

                                    @Override
                                    public void afterTextChanged(Editable s) {
                                        if (et_secondSurname.getText().length() >= 0) {
                                            et_postalCode.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                                }

                                                @Override
                                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                }

                                                @Override
                                                public void afterTextChanged(Editable s) {
                                                    if (et_postalCode.getText().length() >= 0) {
                                                        et_city.addTextChangedListener(new TextWatcher() {
                                                            @Override
                                                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                                            }

                                                            @Override
                                                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                            }

                                                            @Override
                                                            public void afterTextChanged(Editable s) {
                                                                if (et_city.getText().length() >= 0) {
                                                                    btnShowData.setVisibility(View.VISIBLE);
                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }

    //function for show the pc and the city when user write some in the others textboxes (don´t works)
    public boolean showPostalCodeAndCity(String str_name, String str_surname) {
        if (str_name.equals("") && str_surname.equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
