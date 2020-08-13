package copy;

import lombok.Data;

/**
 * @author yaobw
 * @date 2019/11/18 5:40 PM
 * @since V1.0
 */
@Data
public class Student {

    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
