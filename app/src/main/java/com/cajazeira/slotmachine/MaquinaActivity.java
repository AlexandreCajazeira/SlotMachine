package com.cajazeira.slotmachine;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MaquinaActivity extends AppCompatActivity {

    private ImageView ivimg1, ivimg2, ivimg3;
    private Roda slot2, slot1, slot3;
    private Button btn_iniciar;

    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper){
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquina);
        ivimg1 = (ImageView) findViewById(R.id.img1);
        ivimg2 = (ImageView) findViewById(R.id.img2);
        ivimg3 = (ImageView) findViewById(R.id.img3);
        btn_iniciar = (Button) findViewById(R.id.btnFinal);

    }

    public void jogar(View v){


            rodarimg1();
            rodarimg2();
            rodarimg3();
        btn_iniciar.setEnabled(false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                slot1.paraDeRodar();
                slot2.paraDeRodar();
                slot3.paraDeRodar();

                btn_iniciar.setEnabled(true);
                exibeResultado();
            }
        }, 3000);


    }
    private void exibeResultado() {
        if (slot1.indiceAtual == slot2.indiceAtual && slot2.indiceAtual == slot3.indiceAtual) {
            Toast.makeText(this, "Você venceu", Toast.LENGTH_SHORT).show();
        } else if (slot1.indiceAtual == slot2.indiceAtual || slot2.indiceAtual == slot3.indiceAtual
                || slot1.indiceAtual == slot3.indiceAtual) {
            Toast.makeText(this, "Pequena Premiação", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Você perdeu", Toast.LENGTH_SHORT).show();
        }
    }

    private void rodarimg1(){
        slot1 = new Roda(new Roda.RodaListener(){
            @Override
            public void novaImagem(final int resourceID){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ivimg1.setImageResource(resourceID);
                    }
                });
            }
        }, 200, randomLong(0, 200));
        slot1.start();
    }

    private void rodarimg2(){
        slot2 = new Roda(new Roda.RodaListener(){
            @Override
            public void novaImagem(final int resouceID){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ivimg2.setImageResource(resouceID);
                    }
                });
            }
        }, 200, randomLong(150, 400));
        slot2.start();
    }

    private void rodarimg3(){
        slot3 = new Roda(new Roda.RodaListener(){
            @Override
            public void novaImagem(final int resouceID){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ivimg3.setImageResource(resouceID);
                    }
                });
            }
        }, 200, randomLong(300, 600));
        slot3.start();
    }

}

