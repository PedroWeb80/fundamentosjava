package edu.pedro.exercicio1;
/**
 * @author Pedro Daniel
 * @version 1.0
 * @since 25/01/2024
 */
public class SmartTv {
    private int volume = 10;
    private int canal = 1;
    private boolean ligada = false;

    public void proximoCanal() {
        if (this.ligada) {
            this.canal++;
            System.out.println("Canal: " + this.canal);
        }
    }

    /**
     * <h1>Método utilizado pra ir a um canal especifico</h1>
     * @param canal
     */
    public void proximoCanal(int canal) {
        if (this.ligada) {
            if (canal > 0) {
                this.canal = canal;
                System.out.println("Canal: " + this.canal);
            }
        }
    }

    public void aumentarVolume() {
        if (this.ligada) {
            if (this.volume < 100) {
                this.volume++;
            }

            System.out.println("Volume: " + this.volume);
        }
    }

    public void dimunuirVolume() {
        if (this.ligada) {
            if (this.volume >= 0) {
                this.volume--;
            }
            System.out.println("Volume: " + this.volume);
        }
    }

    public void ligar() {
        if (!this.ligada) {
            this.ligada = true;
        }
    }

    public void desligar() {
        if (this.ligada) {
            this.ligada = false;
        }
    }

    public void status() {
        System.out.println("SmartTv: ");
        System.out.println("Ligada: " + this.ligada);

        if (this.ligada) {
            System.out.println("Volume: " + this.volume);
            System.out.println("Canal: " + this.canal);
        }
    }
}
