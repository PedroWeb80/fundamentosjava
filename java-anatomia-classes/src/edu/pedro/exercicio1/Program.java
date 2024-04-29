package edu.pedro.exercicio1;

public class Program {
    public static void main(String[] args) {
        SmartTv tv = new SmartTv();
        tv.ligar();
        tv.status();

        for(int i = 0; i < 10; i++){
            tv.aumentarVolume();
        }
        
        for(int i = 0; i < 21; i++){
            tv.dimunuirVolume();
        }
        
        tv.proximoCanal();
        tv.proximoCanal();
        tv.proximoCanal();
        tv.proximoCanal(12);   
    }
}
