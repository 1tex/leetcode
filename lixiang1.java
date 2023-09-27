import java.util.*;


public class lixiang1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 以数组intervals表示若干个区间的集合，其中区间为intervals[i] = [starti,endi]。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * @param intervals int整型ArrayList<ArrayList<>> 指定若干个区间的集合
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> merge (ArrayList<ArrayList<Integer>> intervals) {
        // write code here
        if (intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return Integer.compare(o1.get(0), o2.get(0));
            }
        });

        ArrayList<ArrayList<Integer>> merged = new ArrayList<>();

        for (ArrayList<Integer> interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1).get(1) < interval.get(0)) {
                merged.add(interval);
            } else {
                ArrayList<Integer> lastInterval = merged.get(merged.size() - 1);
                lastInterval.set(1, Math.max(lastInterval.get(1), interval.get(1)));
            }
        }
        return merged;
    }
}