package hello.gameService;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LENOVO on 17/04/15.
 */
public class Q {

    String q ;
    List<String> a ;
    String ra ; //right answer

    public Q(@JsonProperty("qus")String q , @JsonProperty("a")List<String> a , @JsonProperty("ra")String ra) {
        this.q = q;
        this.a = a;
        this.ra =ra;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }



    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public List<String> getA() {
        return a;
    }
}
