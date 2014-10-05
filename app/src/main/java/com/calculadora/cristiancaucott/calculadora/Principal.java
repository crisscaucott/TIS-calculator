package com.calculadora.cristiancaucott.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Principal extends ActionBarActivity implements View.OnClickListener{

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bp,bmul,bdiv,bsum,bres,beq, bdel;
    private EditText res;
    private Double num1 = 0.0, num2 = 0.0, num, resfinal;
    private Boolean aux = true;
    private int op = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b0 = (Button) findViewById(R.id.b0);
        bp = (Button) findViewById(R.id.bp);
        bmul = (Button) findViewById(R.id.bmul);
        bdiv = (Button) findViewById(R.id.bdiv);
        bsum = (Button) findViewById(R.id.bsum);
        bres = (Button) findViewById(R.id.bres);
        beq = (Button) findViewById(R.id.beq);
        bdel = (Button)findViewById(R.id.bdel);
        res = (EditText)findViewById(R.id.res);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bp.setOnClickListener(this);
        bmul.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bsum.setOnClickListener(this);
        bres.setOnClickListener(this);
        beq.setOnClickListener(this);
        bdel.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View arg) {
        Button b = (Button) arg;
        switch (arg.getId()){
            case R.id.bsum: // +
                op = 1;
                num1 = Double.parseDouble(res.getText().toString());
                aux = true;
                break;
            case R.id.bres: // -
                op = 2;
                num1 = Double.parseDouble(res.getText().toString());
                aux = true;
                break;
            case R.id.bdiv: // /
                op = 3;
                num1 = Double.parseDouble(res.getText().toString());
                aux = true;
                break;
            case R.id.bmul: // *
                op = 4;
                num1 = Double.parseDouble(res.getText().toString());
                aux = true;
                break;
            case R.id.bdel: // borrar
                System.out.println("Aqui");
                res.setText("0");
                aux = true;
                break;
            case R.id.beq:  // =
                if(op != -1){
                    num2 = Double.parseDouble(res.getText().toString());
                    switch (op){
                        case 1:
                            resfinal = num1 + num2;
                            break;
                        case 2:
                            resfinal = num1 - num2;
                            break;
                        case 3:
                            resfinal = num1 / num2;
                            break;
                        case 4:
                            resfinal = num1 * num2;
                            break;
                        default:
                            break;
                    }
                    op = -1;
                    aux = true;
                    res.setText(resfinal.toString());
                }
                break;
            default:    // Numeros
                if(aux){
                    res.setText(b.getText().toString());
                    aux = false;
                }else{
                     res.setText(res.getText().toString() + b.getText().toString());
                }
                break;
        }
    }
}
