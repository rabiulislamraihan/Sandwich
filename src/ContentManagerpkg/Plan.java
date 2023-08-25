
package ContentManagerpkg;

import java.io.Serializable;


class Plan implements Serializable{
    String name;
    String days;
    public Plan(String name, String days){
        this.name = name;
        this.days = days;
    }

    @Override
    public String toString() {
        return "Plan{" + "name=" + name + ", days=" + days + '}';
    }
    
}
