import sys
import time
import datetime

for line in sys.stdin:
	line = line.strip()
	keyword = line.split('[')[1]
	keyword = keyword.split(' -0800')[0]
	tm = datetime.datetime.strptime(keyword, "%d/%b/%Y:%H:%M%S")
	print(time.strftime('%Y-%m-%d T %H:00:00.000', tm)+'\t1')
