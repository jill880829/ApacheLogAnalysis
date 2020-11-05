import sys

currentWord = None
currentCount = 0

for line in sys.stdin:
	line = line.strip()
	word, count = line.split('\t', 1)
	count = int(count)

	if currentWord == word:
		currentCount += count
	else:
		if currentWord:
			print('%s\t%s' % (currentWord, currentCount))
		currentWord = word
		currentCount = count

if currentWord:
	print('%s\t%s' % (currentWord, currentCount))