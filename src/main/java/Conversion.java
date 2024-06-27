import java.time.LocalDateTime;

public class Conversion {
    private String monedaInicio;
    private String monedaFinal;
    private Double cantidadInicio;
    private Double cantidadFinal;
    private LocalDateTime tiempo;

    public Conversion(String monedaInicio, String monedaFinal, double cantidadInicio, double cantidadFinal) {
        this.monedaInicio = monedaInicio;
        this.monedaFinal = monedaFinal;
        this.cantidadInicio = cantidadInicio;
        this.cantidadFinal = cantidadFinal;
        this.tiempo = LocalDateTime.now();
    }

    public String getMonedaInicio() {
        return monedaInicio;
    }

    public void setMonedaInicio(String monedaInicio) {
        this.monedaInicio = monedaInicio;
    }

    public String getMonedaFinal() {
        return monedaFinal;
    }

    public void setMonedaFinal(String monedaFinal) {
        this.monedaFinal = monedaFinal;
    }

    public Double getCantidadInicio() {
        return cantidadInicio;
    }

    public void setCantidadInicio(Double cantidadInicio) {
        this.cantidadInicio = cantidadInicio;
    }

    public Double getCantidadFinal() {
        return cantidadFinal;
    }

    public void setCantidadFinal(Double cantidadFinal) {
        this.cantidadFinal = cantidadFinal;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalDateTime tiempo) {
        this.tiempo = tiempo;
    }
}

