import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User>{
    private String name;
    private Integer order;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }
    public int compareTo(User arg0) {
    	String o;
        return this.getOrder().compareTo(arg0.getOrder());
    }
    public static void main(String[] args){
    	String[] a = new String[3];
    	
    	System.out.println(a instanceof Object[]);
    }
}