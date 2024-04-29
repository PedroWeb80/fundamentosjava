public class ParametrosInvalidosException extends Exception{
    public ParametrosInvalidosException() {
        super("Os parâmetros são invalidos. O primeiro valor deve ser menor que o segundo");
    }
}
