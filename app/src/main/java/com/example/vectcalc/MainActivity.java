package com.example.vectcalc;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
    Button btnSum, btnRes, btnEsc, btnVec, btnAng, btnClr;
    EditText xcomp1, ycomp1, zcomp1, xcomp2, ycomp2, zcomp2;
    double x1, y1, z1, x2, y2, z2;
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
        btnAng = findViewById(R.id.btn5);
        btnClr = findViewById(R.id.btnclr);
        btnSum.setOnClickListener(v -> sumButton());
        btnRes.setOnClickListener(v -> resButton());
        btnEsc.setOnClickListener(v -> escButton());
        btnVec.setOnClickListener(v -> vecButton());
        btnAng.setOnClickListener(v -> angButton());
        btnClr.setOnClickListener(v -> clrButton());
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

    private void sumButton() {
        btnSum.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        if(validate()){
            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("SUMA")
                    .setMessage("< " + sumavectores() + " >")
                    .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        }
    }
    private String sumavectores() {
        initInputs();
        double[] res = new double[3];
        res[0] = x1 + x2;
        res[1] = y1 + y2;
        res[2] = z1 + z2;
        StringBuilder sb = new StringBuilder();
        for (double appended : res){
            sb.append(appended).append(" , ");
        }
        return sb.toString();
    }
    private void resButton() {
        btnRes.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        if(validate()){
            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("RESTA")
                    .setMessage("< " + restavectores() + " >")
                    .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        }
    }
    private String restavectores() {
        initInputs();
        double[] res = new double[3];
        res[0] = x1 - x2;
        res[1] = y1 - y2;
        res[2] = z1 - z2;
        StringBuilder sb = new StringBuilder();
        for (double appended : res){
            sb.append(appended).append(" , ");
        }
        return sb.toString();
    }
    private void escButton() {
        btnEsc.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        if(validate()){
            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("PRODUCTO ESCALAR")
                    .setMessage(productoescalar())
                    .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        }
    }
    private String productoescalar() {
        initInputs();
        double res = x1 * x2 + y1 * y2 + z1 * z2;
        return String.valueOf(res);
    }
    private void vecButton() {
        btnVec.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        if(validate()){
            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("PRODUCTO VECTORIAL")
                    .setMessage("< " + productovectorial() + " >")
                    .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        }
    }
    private String productovectorial(){
        initInputs();
        double[] res = new double[3];
        res[0] = y1 * z2 - z1 * y2;
        res[1] = z1 * x2 - x1 * z2;
        res[2] = x1 * y2 - y1 * x2;
        StringBuilder sb = new StringBuilder();
        for (double appended : res) {
            sb.append(appended).append(" , ");
        }
        return sb.toString();
    }
    private void angButton() {
        btnAng.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        if(validate()){
            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("ANGULO ENTRE VECTORES")
                    .setMessage(angulo())
                    .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        }
    }

    private String angulo() {
        initInputs();
        double magnitud1 = Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
        double magnitud2 = Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2);
        double productoEscalar = x1 * x2 + y1 * y2 + z1 * z2;
        double cosAngulo = productoEscalar / (magnitud1 * magnitud2);
        double anguloRadianes = Math.acos(cosAngulo);
        double anguloGrados = Math.toDegrees(anguloRadianes);
        return String.format("%.2f grados", anguloGrados);
    }

    private void initInputs() {
        x1 = Double.parseDouble(xcomp1.getText().toString());
        y1 = Double.parseDouble(ycomp1.getText().toString());
        z1 = Double.parseDouble(zcomp1.getText().toString());
        x2 = Double.parseDouble(xcomp2.getText().toString());
        y2 = Double.parseDouble(ycomp2.getText().toString());
        z2 = Double.parseDouble(zcomp2.getText().toString());
    }
    private void clrButton() {
        btnSum.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        xcomp1.setText("");
        ycomp1.setText("");
        zcomp1.setText("");
        xcomp2.setText("");
        ycomp2.setText("");
        zcomp2.setText("");
    }
    private boolean validate(){
        if (xcomp1.getText().toString().isEmpty() ||
            ycomp1.getText().toString().isEmpty() ||
            zcomp1.getText().toString().isEmpty() ||
            xcomp2.getText().toString().isEmpty() ||
            ycomp2.getText().toString().isEmpty() ||
            zcomp2.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Por favor, complete todos los campos.")
                    .setPositiveButton("OK", null)
                    .show();
            return false;
        }
        return true;
    }
}