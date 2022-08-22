import java.util.Comparator;

public class TvCompotator implements Comparator<TV> {
    @Override
    public int compare(TV t1, TV t2) {
        return ((Long)t1.getPrice()).compareTo((Long)t2.getPrice());
    }
}


