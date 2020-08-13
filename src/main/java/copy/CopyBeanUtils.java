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
public class CopyBeanUtils <T, K> {

    public static <T, K> K copy(T source, K target){
        return BeanCopyUtils.copyBean(source, target, target.getClass());
    }

    public static <T, K> List<K> copyList(List<T> sourceList, Class<K> targetClazz){
        return BeanCopyUtils.copyList(sourceList, targetClazz);
    }


    public static void main(String[] args) {
        List list = Lists.newArrayList();
        People people = new People();
        people.setAge(1);
        people.setName("123");
        list.add(people);
        System.out.println(copyList(list, new Student().getClass()).toString());
    }

}
