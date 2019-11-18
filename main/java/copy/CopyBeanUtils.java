package copy;

import com.google.common.collect.Lists;
import com.tuyang.beanutils.BeanCopyUtils;

import java.util.List;

/**
 * @author yaobw
 * @date 2019/11/18 5:33 PM
 * @since V1.0
 *
 */
public class CopyBeanUtils {

    public void copy(){
        Object source = new Object();
        Object target = new Object();
        BeanCopyUtils.copyBean(source, target);
    }

    public void copyList(){
        List<People> list = Lists.newArrayList();
        List<Student> studentList = BeanCopyUtils.copyList(list, Student.class);
    }
}