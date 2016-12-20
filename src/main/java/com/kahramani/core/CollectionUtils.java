package com.kahramani.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kahramani on 12/20/2016.
 */
public class CollectionUtils {

    /**
     * to split a list into {partitionCount} sub-lists
     * @param list wanted to split
     * @param partitionCount how many partition created at the end
     * @return a List of List whose parent list has {partitionCount} sub-lists
     */
    public static List<List> splitListByPartitionCount(List list, int partitionCount) {
        ArgumentUtils.isEmptyOrNull(list, "list argument cannot be null or empty");
        ArgumentUtils.isTrue(partitionCount <= 0, "partitionCount argument cannot be null or empty");

        int listSize = list.size();
        int partitionSize = (int) Math.ceil((double) listSize / partitionCount);

        return splitListByPartitionSize(list, partitionSize);
    }

    /**
     * to split a list into equal sized lists having size of partitionSize each
     * @param list wanted to split
     * @param partitionSize size of every partition created from the list
     * @return a List of List whose sub-lists has the size of {partitionSize} equally
     */
    public static List<List> splitListByPartitionSize(List list, int partitionSize) {
        ArgumentUtils.isEmptyOrNull(list, "list argument cannot be null or empty");
        ArgumentUtils.isTrue(partitionSize <= 0, "partitionSize argument cannot be null or empty");

        List<List> partitionList = new ArrayList<>();
        for (int i = 0; i < list.size(); i += partitionSize) {
            List subList = new ArrayList(list.subList(i, Math.min(i + partitionSize, list.size())));
            partitionList.add(subList);
        }
        return partitionList;
    }
}
