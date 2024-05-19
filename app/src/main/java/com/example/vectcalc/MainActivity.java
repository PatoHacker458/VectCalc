package com.example.vectcalc;

import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnSum, btnRes, btnEsc, btnVec, btnClr;
    EditText xcomp1, ycomp1, zcomp1, xcomp2, ycomp2, zcomp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSum = findViewById(R.id.btn1);
        btnRes = findViewById(R.id.btn2);
        btnEsc = findViewById(R.id.btn3);
        btnVec = findViewById(R.id.btn4);
        btnClr = findViewById(R.id.btnclr);

        btnSum.setOnClickListener(v -> sumVectors());
        btnRes.setOnClickListener(v -> resVectors());
        btnEsc.setOnClickListener(v -> escVectors());
        btnVec.setOnClickListener(v -> vecVectors());
        btnClr.setOnClickListener(v -> clearbtn());

        xcomp1 = findViewById(R.id.xcomp1);
        xcomp1.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        ycomp1 = findViewById(R.id.ycomp1);
        ycomp1.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        zcomp1 = findViewById(R.id.zcomp1);
        zcomp1.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        xcomp2 = findViewById(R.id.xcomp2);
        xcomp2.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        ycomp2 = findViewById(R.id.ycomp2);
        ycomp2.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        zcomp2 = findViewById(R.id.zcomp2);
        zcomp2.setImeOptions(EditorInfo.IME_ACTION_DONE);

    }

    private void sumVectors() {
        btnSum.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
    }
    private void resVectors() {
        btnRes.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
    }
    private void escVectors() {
        btnEsc.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
    }
    private void vecVectors() {
        btnVec.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
    }
    private void clearbtn() {
        btnSum.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        xcomp1.setText("");
        ycomp1.setText("");
        zcomp1.setText("");
        xcomp2.setText("");
        ycomp2.setText("");
        zcomp2.setText("");
    }
}