package cn.catguild.codenotes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 寻找 数组中的 连续子序列
 *
 * @author zhi.liu
 * @date 2021-09-02 18:08
 */
public class FindContinuousSub {

	/**
	 * 获取 给定序列中 连续的组合列表
	 * 最终排序时正序来排列的
	 *
	 * @param source 可以是无序的[其实是正序]
	 * @return 连续的组合列表
	 */
	protected List<Kv<Long, Long>> getRangeList(List<Long> source) {
		// 1、正序排序
		List<Long> collect = source.stream()
			.sorted(Comparator.naturalOrder())
			.collect(Collectors.toList());

		// 2、初始化
		List<Kv<Long, Long>> rangList = new ArrayList<>();
		Kv<Long, Long> range = new Kv<>();
		long lastL = collect.get(0);
		range.setKey(lastL);
		if (1 == collect.size()) {
			range.setValue(lastL);
			rangList.add(range);
		}

		// 3、遍历寻找连续序列组合
		for (int i = 1, collectSize = collect.size(); i < collectSize; i++) {
			Long lastR = collect.get(i);

			// 3-1、自然中断
			if (lastR != lastL && lastR != ++lastL) {
				// 找到右界
				range.setValue(lastL - 1);
				rangList.add(range);
				// 开始新的一轮
				range = new Kv<>();
				lastL = lastR;
				range.setKey(lastL);
			}

			// 3-2、到了末尾中断，以最后一个元素结束
			if (i + 1 >= collectSize) {
				range.setValue(lastR);
				rangList.add(range);
			}
		}
		return rangList;
	}

}
