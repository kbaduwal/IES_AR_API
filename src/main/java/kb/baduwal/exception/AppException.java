package kb.baduwal.exception;

import java.time.LocalDate;

public class AppException {

    private String exCode;

    private String exDec;

    private LocalDate date;

    public String getExCode() {
        return exCode;
    }

    public void setExCode(String exCode) {
        this.exCode = exCode;
    }

    public String getExDec() {
        return exDec;
    }

    public void setExDec(String exDec) {
        this.exDec = exDec;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
