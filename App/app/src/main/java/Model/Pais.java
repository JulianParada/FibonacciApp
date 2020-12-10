package Model;

public class Pais {

    private String name;
    private String capital;
    private String name_int;
    private String code;

    public Pais(String name, String capital, String name_int, String code) {
        this.name = name;
        this.capital = capital;
        this.name_int = name_int;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getName_int() {
        return name_int;
    }

    public void setName_int(String name_int) {
        this.name_int = name_int;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return name;
    }
}
