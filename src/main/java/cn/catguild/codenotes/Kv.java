package cn.catguild.codenotes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * kv键值对
 *
 * @author zhi.liu
 * @date 2021-06-24 19:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kv<T,R> {

    /**
     * 键
     */
    private T key;

    /**
     * 值
     */
    private R value;

}
