package ApacheLog;

import java.io.IOException;
import java.text.SimpleDateFormat;  
import java.text.ParseException;
import java.util.Date;  

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class ApacheLogMapper extends MapReduceBase implements Mapper <LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);

	public void map(LongWritable key, Text value, OutputCollector <Text, IntWritable> output, Reporter reporter) throws IOException {

		String valueString = value.toString();
		String tmp = valueString.split("\\[")[1];
		String keyword = tmp.split(" -0800")[0];
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss");
		try {
			Date date=formatter.parse(keyword);
			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd 'T' HH");
			String result = formatter1.format(date);  
			output.collect(new Text(result+":00:00"), one);
		} catch (ParseException e) {

		}
	}
}