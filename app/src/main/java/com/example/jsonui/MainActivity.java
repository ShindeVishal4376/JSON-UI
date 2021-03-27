package com.example.jsonui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String jsonString;
    JSONArray jsonarray = null;
    JSONArray choiceArray = null;
    LinearLayout linearLayout;
    String firstName = "", lastName = "";
    TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getJson();
        setUI();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setUI() {
        linearLayout = (LinearLayout) findViewById(R.id.container);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,10,10,10);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = null;
            String type = null;
            try {
                jsonobject = jsonarray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                type = (String) jsonobject.get("type");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (type.equals(Constatnts.TEXTBOX)) {
                EditText editText = new EditText(this);
                try {
                    editText.setHint((String) jsonobject.get("prompt"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                editText.setLayoutParams(params);
                editText.setId(i);
                editText.addTextChangedListener(new GenericTextWatcher(i));
                linearLayout.addView(editText);
            } else if (type.equals(Constatnts.DATE_PICKER)) {
                DatePicker datePicker = new DatePicker(this);
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                datePicker.setId(i);
                datePicker.setLayoutParams(params);
                linearLayout.addView(datePicker);
            } else if (type.equals(Constatnts.FORMULA)) {
                textView = new TextView(this);
                textView.setId(i);
                textView.setLayoutParams(params);
                linearLayout.addView(textView);
            } else if (type.equals(Constatnts.CHOICE)) {
                final RadioButton[] rb = new RadioButton[5];
                RadioGroup rg = new RadioGroup(this);
                rg.setLayoutParams(params);
                rg.setOrientation(RadioGroup.HORIZONTAL);
                try {
                    choiceArray = jsonobject.getJSONArray("choices");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (int l = 0; l < choiceArray.length(); l++) {
                    rb[l] = new RadioButton(this);
                    try {
                        rb[l].setText(choiceArray.get(l).toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    rb[l].setId(l + 100);
                    rg.addView(rb[l]);
                }
                linearLayout.addView(rg);
            }
        }
    }

    private void getJson() {
        jsonString = Constatnts.JSON_STRING;
        try {
            jsonarray = new JSONArray(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class GenericTextWatcher implements TextWatcher {

        int id;
        public GenericTextWatcher(int a) {
            this.id = a;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            if (id == 0) {
                firstName = text;
            } else {
                lastName = text;
            }
            textView.setText(firstName + " " + lastName);
        }
    }

}