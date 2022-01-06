package com.example.eventlisteners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton btnOnClick = findViewById(R.id.btn_onclick);
        btnOnClick.setOnClickListener(this);

        ListView lv = findViewById(R.id.lv);
        lv.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "setOnItemClickListener", Toast.LENGTH_SHORT).show();
        });

        lv.setOnItemLongClickListener((adapter, item, pos, rowId) -> {
            return false;
        });

        TextInputEditText etName = findViewById(R.id.et_name);
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Fires when text is getting changed
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Fires before text is changing
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Fires after the text has changed
                Toast.makeText(MainActivity.this, s.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        TextInputEditText etValue = findViewById(R.id.et_value);
        etValue.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                String text = v.getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        etValue.setOnTouchListener((v, event) -> {
            if(event.getAction() == MotionEvent.ACTION_UP){
                v.performClick();
                return true;
            }
            return false;
        });

    }

    public void callOnClick(View view) {
        Toast.makeText(this, "callOnClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "onClicked", Toast.LENGTH_SHORT).show();
    }
}