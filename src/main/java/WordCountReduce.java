import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * 单词统计的WordCountReduce
 */
public class WordCountReduce extends Reducer<Text,LongWritable,Text,LongWritable>{

    public void reduce(Text key, Iterable<LongWritable> values, Reducer.Context context) throws IOException, InterruptedException {

        Long totalCount = Long.valueOf(1);

        for(LongWritable value:values) {
            totalCount += value.get();
        }
        context.write(key,new LongWritable(totalCount));
    }

}
