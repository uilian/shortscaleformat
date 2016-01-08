NumberShortScaleFormatter
=========

Simple Java application to format numbers to short scale.


Requirements
-------------------------
 - Java 8
 - Maven
 - Intellij (optional)


Building and Testing
-------------------------

 - Run tests: mvn test
 - Create Jar: mvn package
 - Complete: mvn install


Use
-------------------------

Include the generated jar file to your project and use like this:


```
import com.uilian.crossover.format.NumberShortScaleFormatter;
import com.uilian.crossover.format.NumberShortScaleFormatterException;

public class TestNSSF {

    public static void main(String[] args) {
        try {
            String nf = NumberShortScaleFormatter.format(1000000);
            System.out.println(nf); //prints "1M"
        } catch (NumberShortScaleFormatterException e) {
            e.printStackTrace();
        }
    }
}
```