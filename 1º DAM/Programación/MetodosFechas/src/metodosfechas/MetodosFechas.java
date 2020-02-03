package metodosfechas;

public class MetodosFechas {

    private int year;
    private int month;
    private int day;

    public MetodosFechas() {

    }

    public MetodosFechas(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    
    public void muestreDia(){
        System.out.println(getDay()+"/"+getMonth()+"/"+getYear());
    }
    
    public int pasarDia() {
        day++;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) {
                    month += 1;
                    day = 1;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    month += 1;
                    day = 1;
                }
                break;
            case 2:
                if (year > 1582 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
                    if (day > 29) {
                        month += 1;
                        day = 1;
                    }
                } else {
                    if (day > 28) {
                        month += 1;
                        day = 1;
                    }
                }
                break;
        }
        if (month > 12) {
            month = 1;
            year += 1;
        }
        return 0;
    }

    public String NombreMes() {
        String NombreMes = null;
        switch (month) {
            case 1:
                NombreMes = "Enero";
                break;
            case 2:
                NombreMes = "Febrero";
                break;
            case 3:
                NombreMes = "Marzo";
                break;
            case 4:
                NombreMes = "Abril";
                ;
                break;
            case 5:
                NombreMes = "Mayo";
                break;
            case 6:
                NombreMes = "Junio";
                break;
            case 7:
                NombreMes = "Julio";
                break;
            case 8:
                NombreMes = "Agosto";
                break;
            case 9:
                NombreMes = "Septiembre";
                break;
            case 10:
                NombreMes = "Octubre";
                break;
            case 11:
                NombreMes = "Noviembre";
                break;
            case 12:
                NombreMes = "Diciembre";
                break;

        }
        return NombreMes;
    }

    public String getDiaSemana() {

        String a[] = {"Domingo", "Lunes", "Martes", "Miercóles", "Jueves", "Viernes", "Sábado"};
        int d = day % 7;
        return a[d];

    }

    public boolean esBisiesto() {
        boolean añoB = false;
        if (year > 1582 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
            añoB = true;
        }
        return añoB;
    }
    
    public void Fechacompleta(){
        System.out.println("Hoy es "+getDiaSemana()+", "+getDay()+" de "+NombreMes()+" de "+getYear());
    
    }
}
